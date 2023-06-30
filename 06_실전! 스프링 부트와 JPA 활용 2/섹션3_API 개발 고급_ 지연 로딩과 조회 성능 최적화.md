



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