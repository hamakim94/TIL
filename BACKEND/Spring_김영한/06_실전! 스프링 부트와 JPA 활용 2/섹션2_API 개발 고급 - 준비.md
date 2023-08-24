# API 개발 고급 - 준비



- 장애의 90% 이상은 조회에서 나온다..!!
- 이번 강의들은 조회에 대한 서버 최적화.!

지연 로딩 -> N+1 문제~

불필요한 조인 -> 컬렉션 조인 최적화

페이징 -> 페이징을 하는데도, 조인을 하면 뻥튀기가 될 수 있으니까 어떻게 할까?

OSIV와 성능 최적화 -> Open Session 뭐시기라는게 있다. 이걸 사용하면 lazy loading easy -> 어떤 상황에서 키고 끄는지!



## 조회용 샘플 데이터 입력



userA - JPA1 BOOK, JPA2 BOOK

useB - SPRING BOOK1, SPRING BOOK2