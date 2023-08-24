# 220427

## REST

### 개념

- Representational State Transfer : **하나의 URI는 하나의 고유한 리소스(Resource)를 대표**하도록 설계된다는 개념에 전송방식을 결합해서 원하는 작업
- 웹의 장점을 최대한 활용할 수 있느 아키텍처(설계구조)로써 REST를 발표
- HTTP URI를 통해 제어할 자원(Resource)를 명시하고, **HTTP Method(GET,POST,PUT,DELETE)** 을 통해 해당 자원(Resource)를 제어하는 명령을 내리는 방식의 아키텍처.

---

### 구성

- 자원 (Resource) - URI
- 행위 (Verb) - HTTP Method
- 표현 (Representation)

잘 표현된 HTTP URI로 **리소스를 정의**하고, HTTP method로 리소스에 대한 **행위를 정의**한다

리소스는 JSON, XML과 같은 여러 가지 언어로 **표현**할 수 있다.

- URI + [GET(조회), POST(등록),, DELETE(삭제), PUT(수정)]

---

### 방식

| 작업           | 기존방식                     | REST방식               | 비고   |
| -------------- | ---------------------------- | ---------------------- | ------ |
| Create(Insert) | POST    /board/write         | POST       /board      | 글쓰기 |
| Read(SELECT)   | GET       /board/detail?id=2 | GET         /board/2   | 글읽기 |
| Update(Update) | POST    /board/update        | **PUT**         /board | 글수정 |
| Delete(Delete) | GET       /board/delete?id=2 | **DELETE**   /board/2  | 글삭제 |

- 기존의 접근 방식은 GET과 POST만으로 자원에 대한 CRUD를 처리하면, URI는 액션을 나타냈음
- REST로 변경할 경우, 4가지 method를 모두 사용해 CRUD 처리, URI는 제어하려는  자원을 나타낸다

---

## API

### 개념(위키)

- 컴퓨터나 컴퓨터 프로그램 사이의 연결
  - 일종의 소프트웨어 인터페이스, 다른 종류의 소프트웨어에 서비스를 제공한다
- **엔드포인트**

### 개념(직관)

#### API(Application Programming Interface)

- 두 소프트웨어 요소들이 서로 통신 할 수 있게 하는 방식 (예> 미세먼지 제공 시스템 / 핸드폰 미세먼지 앱)
- Application은 고유한 기능을 가진 모든 소프트웨어
- Interface는 두 어플리케이션 간의 요청과 응답에 의한 통신하는 방법
- 그동안 우리는 view를 응답했는데, REST는 사용자가 요청한 그 데이터 자체만 가져오는 느낌.

---

### 유형

- 프라이빗 API
  - 기업 내부에 있으며, 비즈니스 내에서 시스템과 데이터를 연결하는 데만 사용
- 퍼블릭 API
  - 일반에 공개되며 누구나 사용
  - 단 사용 권한에 대한 설정과 비용이 있을 수있음
  - 공공데이터 포털, 기상청, naver, kakao, youtube
  - 대부분이 REST 방식으로 작성

---

## Rest API

- 기존 방식과는 달리 서버는 요총으로 받은 리소스에 대해 **순수한 데이터**를 전송한다
- 기존에 GET/POST 외에 PUT DELETE 방식 사용하여 리소스에 대한 CRUD
- HTTP URI를 통해 제어할 자원을 명시하고, HTTP METHOD(GET/POST/PUT/DELETE)를 통해 제어하는 명령을 내리는 방식의 Architecture이다
- 가장 큰 단점이 없어서 암묵적인 표준만 정해져 있음
  - 그룹은 대충 끝에 s 사용
  - 하이픈(-)은 사용 가능하지만 언더바(_)는 사용하지 않는다 ( 가독성 )
  - 특별한 경우를 제외하고 대문자 사용을 하지 않는다 ( 대소문자 구분하기 때문에)
  - URI 마지막에 /를 사용핮 ㅣ않는다
  - 슬래시로 계층 관계를 나타낸다
  - 확장자가 포함된 파일 이름을 직접 포함시키지 안흔다
  - URI는 명사를 사용한다

---

### SPRING REST 관련 Annotation 및 클래스

| Annotation                                                   | Description                                                  |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| @GetMapping<br />@PostMapping<br />@PutMapping<br />@DeleteMapping | 요청방식                                                     |
| @RestController                                              | Controller가 REST 방식을 처리하기 위한 것임을 명시           |
| @ResponseBody                                                | JSP 같은 뷰로 전달되는게 아니라 데이터 자체를 전달<br />뷰, 데이터 동시 전달하고 싶으면, 메소드에 @Responsebody라고 붙임 |
| @PathVariable                                                | URL 경로에 있는 값을 파라미터로 추출                         |
| @CrossOrigin                                                 | Ajax의 크로스 도메인 문제를 해결                             |
| @RequestBody                                                 | JSON 데이터를 원하는 타입으로 바인딩                         |
| ResponseEntity                                               | 데이터 응답시 [상태코드, 헤더, 데이터] 설정 가능             |

---

### HTTP 약속

- 요청과 응답을 동일한 형태로 보내줌
- HTTP : (시작라인 + 헤더 + 바디)
  - 시작라인
  - 헤더값
  - 빈 줄
  - 바디 ( 응답하려고 하는 데이터들)

~~~ java
new ResponseEntity<0> (0, 0, 0);
첫번째 0 : Body의 타입, (BODY내용, 헤더, 상태코드)
~~~

