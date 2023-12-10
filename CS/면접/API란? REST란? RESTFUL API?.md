## API(Application Programming Interface)

한 응용 프로그램이 다른 응용 프로그램과 통신하기 위한 규칙들과 프로토콜을 정의하는 SW 인터페이스
API는 다른 소프트웨어 시스템 정보를 요청하교 교환하는데 매우 중요한 역할을 함



## REST(Representational State Transfer)

네트워크 응용 프로그램을 위한 아키텍처 스타일

1. URI를 통한 자원 명시
2. HTTP Method(GET, POST, PUT, DELETE, PATCH 등)을 통해
3. 해당 자원(URI)에 대한 CRUD Operation 하는 것.

### 구성 요소

1. 자원 : HTTP URI
2. 자원에 대한 행위 : HTTP METHOD
3. 자원에 대한 행위의 내용 : HTTP Message 



## RESTFUL API

REST의 원칙을 준수하는 API

1. **무상태성(Statelessness)**
   각 클라이언트에서 서버로의 요청은 해당 요청을 이해하고 처리하는데 필요한 모든 정보를 포함
   서버는 요청 간에 클라이언트 상태에 대한 정보를 저장하지 않아야 함
2. **리소스 기반(Resource-Based)**
   데이터 개체 또는 서비스와 같은 리소스는 **URI(Uniform Resource Identifier)로 식별**
   클라이언트는 **표준 HTTP 메서드**를 사용해 이러한 리소스와 상호 작용
3. **표현(Representation)**
   리소스는 JSON, XML과 같은 여러 표현 가질 수 있음
   클라이언트는 요청에서 원하는 표현을 지정하고, 서버는 해당 표현으로 응답
4. **일관된 인터페이스(Uniform Interface)**
   인터페이스의 일관성은 아키텍처를 단순화하고 분리하여 더 확장 가능하고 유연하게 만들어줌



## 요약

#### API(Application Programming Interface)

응용 SW끼리 통신하기 위해 지켜야 하는 규칙과 프로토콜을 정의하는 인터페이스

#### REST(Representaional State Transfer)

URI를 통해 자원을 명시하고, HTTP Method를 활용해 CRUD 연산을 하는 아키텍처

#### Restful API

REST 아키텍처 스타일을 준수한 API

#### REST 장점 

HTTP 표준 프로토콜을 따르는 모든 플랫폼에서 사용 가능
서버와 클라이언트 역할 명확하게 분리

#### 단점

표준이 존재하지 않음
HTTP METHOD 의 형태가 제한적

