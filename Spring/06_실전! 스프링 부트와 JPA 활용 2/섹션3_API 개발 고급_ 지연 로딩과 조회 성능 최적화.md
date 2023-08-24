



## 간단한 주문 조회 V1 - 엔티티 직접 노출



주문 + 베송정보 + 회원을 조회하는 API ( 모든거 포함 , 결국 주문 API )
지연 로딩 때문에 발생하는 성능 문제를 단계적으로 해결!!



> 참고: 지금부터 설명하는 내용은 정말 중요, 100% 이해해야 한다
>
> 안 그러면 엄청난 시간과 인생 낭비



### 간단한 주문 조회 V1 : 엔티티 직접 노출



```java
@GetMapping("/api/v1/simple-orders")
    public List<Order> ordersV1(){
        List<Order> all = orderRepository.findAllByString(new OrderSearch());
        return all;
    }
```

Orders 호출 -> Members 호출(일대다) -> Orders 호출 ....무한

잭슨 라이브러리 입장은, 객체를 무한히 뽑게 도니다..

한 쪽은 @JsonIgnore로 막아줘야 한다

그래서 총, Member, OrderItem, Delivery 객체에서 @JsonIgnore 했다

그런데도 에러가 나 ..

- 지연 로딩 때문에, DB에서 가지고 오지 않아..!!
- 그래서 프록시 라이브러리(bytebuddy)로 -> ProxyMember를 상속함 
- Jackson -> Order를 가지고 Member를 뽑으려는데, 뭔가 이상한게 있어..



```
implementation group: 'com.fasterxml.jackson.datatype', name: 'jackson-datatype-hibernate5'
```

추가

- 심지여 지연 로딩(hibernate5module -> 기본 null, 근데 옵션 설정해서 바꿀 수 있음)
- 가능하다!
  - force lazy loading -> 현재 기능을 만드는데 필요하지 않는 것 까지 전부 다 select 해서 가져옴..

- **하이버네이트 모듈 자체를 등록해서 사용한다 -> 권장 XXXXX**
  - **근데 엔티티를 외부에 노출하지 않는게 더 중요**



- 한 번 돌렸는데 너무 오래 걸려? -> 이 강의 다시 보기
- 꼭, Entity 직접 반환 XX
- **지연 로딩을 피하기 위해 EAGER로 하면 절 대 안 돼**
  - 성능 최적화 여지 XX



## 간단한 주문 조회 V2: 엔티티를 DTO로 반환



1개 select -> query, 총 5개

Lazy loading 

- N+1문제 발생
  - 1 + 회원 N + 배송 N
  - 1 + 2 + 2 -> 5번 실행됨.. ()
- **지연 로딩 조회 때문**
  - 지연 로딩은 기본적으로 영속성 컨텍스트를 찌름
  - 만약 같은 객체를 사용하면 DB 다시 안 따짐
  - 이미 조회 된 경우에는 ㅠㅍ



## 간단한 주문 조회 V3: 엔티티를 DTO로 반환 - 페치 조인 최적화

- 만약 주문 10개면?
  - 주문 1번 + 회원 10번 배송 10번(lazy) -> 21번..

```java
public List<Order> findAllWithMemberDelivery() {
        return em.createQuery(
                "select o from Order o" +
                        " join fetch o.member m" +
                        " join fetch o.delivery d", Order.class
        ).getResultList();
    }		
```

- 프록시 사용하는게 아니라 진짜 객체 다 긁어오기
- 페치 조인 100% 이해해야 함



- 지연 로딩 자체가 X, 한 번에 다 들고와버림!

- 실무에서 정말 자주 사용



## 간단한 주문 조회 V4: JPA에서 DTO로 바로 조회



JPA는 기본 식별자를 넣기 떄문에, 쿼리에서 바로 DTO 바인딩은 안 된다

그래서 다 노가다로 넣어줘야함..

fetch join은 전체 다 가져와서 컬럼 양이 많은데

DTO를 만들어서, query를 직접 짜서 반환하면 조금 덜 가져온다



v3 - fetch join : 외부의 모습을 건드리지 않음. 내부에 원하는 것만 fetch해서 tuning

v4 - 실제 SQL 짜듯이, 가져옴, 화면에는 최적화, 그러나 **재사용성이 많이 떨어짐**



v4 -> new 쓰는 것

- SQL 을 사용할 때 처럼 원하는 값을 선택해서 조회
- new 명령어 사용 -> JPQL의 결과를 바로 DTO로
- SELECT절에서 원하는 데디터를 직접 선택 -> 애플리케이션 네트웍 용량 최적화
- 그러나 리포지토리 재사용성이 떨어짐..



**논리적인 개념이 꺠져있음, 의존관계 이상**

코드상 3번이 좋은데, 4번이 이쁘긴 해..



직접 성능 테스트를 해봐야 아는 점이 있다(요즘 네트워크 좋다 + 대부분의 성능은 join에서 먹기 때문에, 어떤 컬럼을 가져오는지, 필드가 추가되는지는 엄청난 차이 XX)



대부분 문제는 index쪽이지, 컬럼 몇 개 가져오는지는 중요하진 않다!(데이터 너무 큰 경우 제외~)



**리포지토리는 ,entity 조회할 떄 쓰는거!!!!!!!!!** 



쿼리용, 성능 최적화용 패키지를 뽑아서 관리한다

쿼리용으로 별도로 DTO를 뽑느다

따로 뽑아야 유지 보수가 중요한다.즉 화면 자체 뿌리기에 좋은편.

완전 조회용, 화면이랑 연결된 것이구나! 라고 분리하는걸 추천하느 편



### 정리

엔티티를 DTO로 변환, DTO로 바로 조회하는 방법은 장단점이 있다.

엔티티로 조회하면 리포지토리 재사용성도 좋고, 개발도 단순



### 쿼리 방식 선택

1. 엔티티를 DTO로 변환하는 방법 선택
2. 필요하면 페치 종니으로 성능을 최적화 한다 -> 대부분 해결
3. 그래도 안 되면 DTO로 직접 조회하는 방법을 사용
4. 최후의 방버은 JPA가 제공하는 네이티브 SQL이나 스프링 JDBC Template를 사용해서 SQL을 직접 사용!!





