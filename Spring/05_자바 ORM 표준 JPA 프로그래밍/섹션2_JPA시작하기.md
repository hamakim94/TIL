# Hello JPA - 프로젝트 생성

- H2Dialect
  - 방언, 각 DB마다 방언이 있어서 JPA에 어떤거 쓸건지 알려줘야 함
  - 하이버네이트에서만 사용(전용 옵션)
- Javax - 표준임~



## Hello JPA - 애플리케이션 개발



### JPA 구동 방식

- Persistence에서 설정 정보를 조회한다
- (META-INF/persistence.xml)

- 해당 정보를 바탕으로 EntityManagerFactory를 만들고
- EntityManager들을 생성해서 사용한다



JPA 객체 : @Entity annotation

- @Id : javax



### 꼭 트랜잭션 안에다 저장해야해

entityManager : 컬렉션이라고 생각하면 편함

### 수정 

- 자바 객체에서 값만 바꿨는데,, set만 했는데 바꿔짐
- easy - 자세한건 뒤에서



### 주의

EntityManagerFactory : 하나만 생성

**엔티티 매니저는 쓰레드간에 공유 X(사용하고 버려야 함)**

**JPA의 모든 데이터 변경은 트랜잭션 안에서 실행**





### JPQL

- 나이가 18상 이상인 회원을 모두 검색?
- 내가 원하는 데이터만 쇽쇽 가져오고 싶으면..!?



JPA 사용 - 엔티티 객체를 중심으로 개발

문제는 검색 쿼리(select)

검색을 할 때도 테이블이 아닌 엔티티 객체를 대상으로 검색

모든 DB 데이터를 객체로 변환해서 검색하는 것은 불가능

애플리케이션이 필요한 데이터만 DB에서 불러오려면 결국 검색 조건이 포함된 SQL이 필요





