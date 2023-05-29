# 섹션 7 일반 헤더





## HTTP 헤더 개요



- HTTP 전송에 필요한 모든 부가정보, 표준 헤더 너무 많고, 임의의 헤더도 추가 가능



- 헤더 분류(RFC2616)
  - General 헤더
  - Request 헤더
  - Response 헤더
  - **Entity 헤더 : 엔티티 바디에 대한 정보**
- 2014년 RFC7230 에서 엔티티 body라는 용어가 사라짐
  - Entity -> Representation
  - Representation = representation Metedata + Representation Data
  - 표현 = 표현 메타데이터 + 표현 데이터



RFC7230

- 메시지 본문을 통해 표현 데이터 전달
- 메시지 본문 = 페이로드(payload)
- **표현** 은 요청이나 응답에서 전달할 실제 데이터
- **표현 헤더**는 **표현 데이터**를 해석할 수 있는 정보 제공
  - 데이터 유형(html, json), 데이터 길이, 압축 정보 등등



왜 표현?

- 특정 리소스를(원하는 정보) html message(반환 정보)를 통해 '표현'한다!



## 표현

- **Content-Type**
  - 표현 데이터의 형식 설명(html), application/json , image/png
  - 미디어 타입, 문자 인코딩
- **Content-Encoding**
  - 표현 데이터 인코딩
    - 표현 데이터를 **압축**하기 위해 사용
    - 데이터를 전달하는 곳에서 압축 후 인코딩 헤더 추가
    - 데이터 읽는 쪽에서 인코딩 헤더의 정보로 압축 해제
    - gzip, deflate, identity
- **Content-Language**
  - 표현 데이터의 자연 언어를 표현
    - ko, en, en-US
- **Content-length**
  - 표현 데이터의 길이
    - 바이트의 단위
    - Transfer-Encoding을 사용하면 Content-Length를 사용하면 안 돼

표현 헤더는 전송, 응답 둘 다 사용



## 협상(콘텐츠 네고시에이션)

**클라이언트가 선호하는 표현 요청**

- Accept : 클라이언트가 선호하는 미디어 타입 전달
- Accept-Charset: 클라이언트가 선호하는 문자 인코딩
- Accept-Encoding: 클라이언트가 선호하는 압축 인코딩
- Accept-Language: 클라이언트가 선호하는 자연 언어

협상 헤더는 **요청**시에만 사용



#### Accept-Language 적용 전

한국어 브라우저 -> 영어로 반환

**적용 후**

Accept-Language: ko 

로 보내면 서버에서 한국어로 지원(다중 언어 지원 서버)



그런데, 다중 언어 지원 서버가, 기본이 독일어! 영어도 지원!

근데 나는 한국어로 요청하는데(accept-language:ko) 로 요청을 보내면 독일어로 반환



#### 협상과 우선순위1

**Quality Values(q)**

- **0~1**, 클수록 높은 우선순위
- 생략하면 1

#### 협상과 우선순위 2

- 구체적인 것이 우선
- Accept: text/*, text/plain, text.plain;format=flowed, \*/\*
  - 가장 구체적인게 우선
  - 1. text.plain;format=flowed
  - 2. text.plain
  - 3. text/*
  - 4. \*/\*



## 전송 방식

- **단순 전송**
  - 컨텐트 길이 알 때 
- **압축 전송**
  - 압축 -> 실제로 효율적
  - Content-Encoding이 필요하겠지?
- **분할 전송**
  - Transfer_Encoding: chunked
  - 5
  - world
  - 5
  - hello ( 5byte 보낼거고 world 보내고 5바이트 보낼거고 hello 보내고..)
  - 용량이 너무 커서. 분할해서 보내면 온 대로 바로 표현 가능 하니까!
  - (Content-Length가 처음에 예상이 안 돼서 길이를 미리 지정하면 XX )
- **범위 전송(Range, Content-Range)**
  - 반 이상 받았는데, 또 다시 요청하긴 XX
  - 반 이후 부터 보내줘 라는 느낌으로 전송 가능

## 

## 일반 정보

### From : 유저 에이전트의 이메일 정보

- 일반적으로 잘 사용 X
- 검색 엔진에서 주로 사용!

### Referer(이전 웹 페이지 주소) - 엄청 많이 씀

- 현재 요청된 페이지의 이전 웹 페이지 주소
- A->B로 이동하는 경우 B를 요청할 대 Referer : A 를 포함해서 요청
- 유입 경로 분석 가능
- 요청에서 사용
- referrer의 오타임



### User-Agent

**유제 에이전트 애플리케이션 정보**

- 클라이언트의 애플리케이션 정보(웹 브라우저 정보 등등)
- 통계 정보
- 어떤 브라우저에서 장애가 발생하는지 파악 가능
- 요청에서 사용



### Server : 요청을 처리하는 ORIGIN 서버의  SW 정보

- Server: Apache:2.2.22 (Debian)
- Server: nginx
- 응답에서 사용

### Date : 메세지가 발생한 날짜와 시간



## 특별한 정보

- **Host**
  - 요청한 호스트 정보(도메인)
  - **필수**
  - 하나의 서버가 여러 도메인을 처리해야 할 때
  - 하나의 IP 주소에 여러 도메인이 적용되어 있을 때 구분 가능(호스트 헤더 필드에 직접 입력한다)
  - TCP/IP는 IP만 활용해서 통신하기 때문에 호스트 헤더로 구분을 해야한다
- **Location:** 
  - 페이지 리다이렉션
  - 웹 브라우저는 3xx 응답의 Location 헤더가 이씅면 Location 위치로 자동 이동
  - 응답코드 3xx에서 설명
  - 201(Created) : 요청에 의해 새로 만들어진  URI 주소
- **Allow**
  - 허용 가능한 HTTP 메서드
    - 405 (Method Not Allowed)에서 응답에 포함해야함
    - Allow : GET, HEAD, PUT 지원
    - 클라가 인식하지만. 구현하진 않음~~
- **Retry-After**
  - 유저 에이전트가 당므 요청을 하기까지 기다려야 하는 시간
    - 503 : 서비스가 언제까지 불능인지 알 수 있음
    - Retry-After: 120(초단위), 혹은 날짜



## 인증

- **Authorization: 클라이언트 인증 정보를 서버에 전달**
  - Authorization: Basic xxxxxxxxx ( 어떤걸 사용하느냐에 따라 달라지는 편! )
- **WWW-Authenticate:리소스 접근시 필요한 인증 방법 정의**
  - 리소스 접근시 필요한 인정 방법 정의
  - 401 Unauthorized 응답과 함께 사용



## 쿠키

- Set-Cookie
  - 서버에서 클라이언트로 쿠키 전달(응답)
- Cookie
  - 클라이언트가 서버에서 받은 쿠키를 저장하고, HTTP 요청시 서버로 전달



HTTP : 무상태 프로토콜이기 때문에.. 이전 요청 기억 못함..!



- 서버에서 세팅할 때, sesseinId 만들엇고, expire 만들고,  path : 특정 경로 허용, domain : 이 도메인, Secure : 보안?



- 사용처
  - 사용자 로그인 세션 관리
    - 로그인 하면
    - 세션 키를 만들어서 DB에 저장시켜놓음
    - 서버에 요청할 떄 마다 SessionId를 조회하며 OK!
  - 광고 정보 트래킹
- 쿠기 정보는 항상 서버에 전송됨
  - 네트워크 트래픽 추가 유발
  - 최소한의 정보만 사용(세션 id, 인증 토큰)
  - 서버 X, 웹 브라우저 내부에 저장하고 싶으면 웹 스토리지 참고!
- 주의!
  - 보안에 민감한 데이터는 저장하면 안 됨(주민번호, 신용카드 정보 etc)



### 쿠키 생명 주기

#### Expires, max-age

- expires : (GMT 기준)
  - 만료일이 되면 쿠키 삭제
- max-age
  - 초 단위로 셋팅 가능
  - 0이나 음수를 지정하면 쿠키 삭제
- 세션 쿠키
  - 만료 날짜를 생략하면 브라우저 종료시 까지만 유지
- 영속 쿠키
  - 만료 날짜를 입력하면 해당 날짜까지 유지



#### 도메인(Domain)

- 아무 사이트에나 막 인증되면 큰일이잖아!
- **명시 : 명시한 문서 기준 도메인 + 서브 도메인 포함**
  - domain=example.org를 지정해서 쿠키를 생성하면
  - Example.org는 물론이고 dev.example.org.도 쿠키 접근 가능 
- **생략 : 현재 문서 기준 도메인만 적용**
  - example.org에서 키를 생성하고 domain 지정을 생략하면
    - example.org에서만 쿠키 접근
    - dev.example.org는 쿠키 미접근



### Path

- **이 경로를 포함한 하위 경로 페이지만 쿠키 접근**
- **일반적으로 path=/ 루트로 지정**



### 보안(Secure, HttpOnly, SameSite)

- Secure
  - 쿠키는 http, https 구분 X
  - Secure를 적용하면 https인 경우에만 전송
- HttpOnly
  - XSS 공격 방지
  - 자바스크립트에서 접근 불가(document.cookie)
  - HTTP 전송에만 사용
- SameSite
  - XSRF 공격 방지
  - 요청 도메인과 쿠키에 설정된 도메인이 같은 경우만 쿠키 전송