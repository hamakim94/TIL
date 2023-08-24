# 22/05/11 Vue - Axios

## AJAX (Asynchronous JavaScript and XML)

#### 개념

- 비동기식 JavaScript와 XML

- 서버와 통신을 하기 위해서 XMLHttpRequest 객체를 사용
- JSON, XML, HTML 그리고 일반 텍스트 형식 등을 초함한 다양한 포맷을 주고 받을 수 있음
- 페이지 전체를 '새로고침' 하지 않고서도 수행되는 **비동기성**, 일부분만 업데이트 가능

---

#### 동작방식(비동기, 동기)

- 동기 
  - 서버에 요청한 데이터가 도착할 때까지 클라이언트 대기
- 비동기
  - 서버에 요청한 데이터가 도착할 동안 클라이언트는 멈추지 않고 동작

---

#### XMLHttpRequest객체

- JS Object
- 서버와 상호작용하기 위해 사용
- 전체 페이지의 새로고침 없이도 URL로 부터 데이터를 받아 올 수 있음
- 사용자의 작업을 방해하지 않고 페이지의 일부를 업데이트 할 수 있음
- AJAX 프로그래밍에 주로 사용
- XML이라는 이름과는 다르게 모든 종류의 데이터를 받아 오는데 사용 가능
- http 이외의 프로토콜도 지원)(file, htp 포함)

---

#### XMLHttpRequest 생성자

- XMLHttpReqeust() : 객체를 초기화 함, 다른 모든 메소드 호출 이전에 호출되어야 함

#### Method

- open( "HTTP method", "URL", sync/async)
  - 요청의 초기화 작업
  - GET / POST 지정
  - 서버 URL 지정
  - 동기 / 비동기 설정
- send(content)
  - GET 방식은 URL에 필요정보 추가하기 떄문에 null 적용
  - POST 방식에선 파라미터 설정 처리

#### Properties

- onreadystatechage
  - 서버에서 응답이 도착했을 때 호출될 콜백함수 지정
  - 콜백함수는 상태(readyState)가 변경될 때 마다 호출
- readyState : 요청의 현재 상태
  - 0 (UNSERT) : uninitialized (객체 생성 후 open 메서드 호출 전)
  - 1 (OPENED) : loading (open 메서드가 호출되고 send 호출 전)
  - 2 (HEADERS_RECEIVED) : loaded (send 메서드가 호출되었지만 서버 응답 전)
  - 3 (LOADING) : interactive : (response에서 데이터 다운로드중)
  - **4 (DONE)0 : completed ( 모든 데이터 전송 완료)**

- status (서버 처리 결과 상태 코드)
  - 200 : OK
  - 404 : Not Found(페이지 못 찾아)
  - 500 : Server Error (서버에서 결과 생성 시 오류 발생)
  - +...
- responseText
  - 서버의 응답 결과를 문자열로 받기
- responseXML
  - 서버의 응답 결과를 XML로

---

#### AJAX 프로그래밍 순서

1. 클라이언트 이벤트 발생
2. XMLHttpRequest 객체 생성
3. XMLHttpRequest 객체 콜백함수 설정
4. XMLHttpRequest 객체를 통한 비동기화 요청
5. 서버 응답 결과를 생성하여 클라이언트로 전송
6. XMLHttpRequest 객체는 서버 결과를 처리할 골백함수 호출
7. 결과를 클라이언트에 반영

---

#### JavaScriptsms Single thread

- 이벤트를 처리하는 Call Stack이 하나!
- 즉시 처리하지 못하는 이벤트들을 (Web API)로 보내서 처리 => 브라우저에서 제공하는 영역이다~
- 처리된 이벤트들은 처리된 순서대로 (Task queue) 에 저장
- Call Stack이 공백이 되면 (Event Loop)가 대기 줄에서 가장 오래된 이벤트를 Call Stack으로 보냄

---

#### 순차적인 비동기 처리하기

- Web API로 들어오는 순서는 중요하지 않고, 어떤 이벤트가 먼저 처리되느냐가 중요(실행 순서 불명확)



1. Async Callbacks
   - 백그라운드에서 실행을 시작할 함수를 호출할 떄 인자로 지정
   - 데이터 받아와 -> 가져왔으면 콜백함수 실행해!( like action - mutation)
   - ex) addEventListener()의 두 번째 인자
2. ** Promise - Style**
   - Modern Web API에서의 새로운 코드 스타일
   - XMLHttpRequest 객체를 사용하는 구조보다 조금 더 현대적인 버전

---

## Promise

### Promise Object

- 비동기 작업을 마치 동기 작업처럼 값을 반환해서 사용 형태
- **미래의 완료 또는 실패와 그 결과 값을 나타냄**
- 미래의 어떤 상황에 대한 약속
- new Promise(function (resolve, reject) {} )
- resolve(성공시)
- reject(실패시)

~~~ javascript
const promise = new Promise((resolve, reject) => {
    resolve('resolve');   // then 부분을 실행
    // reject('reject));  // catch 부분을 실행
})

promise
    .then( (data) => {
        console.log(data);
    })
     .catch( (data) => {
    	console.log(data);
}))
~~~

---

### Promise Methods

- .then(callback)
  - Promise 객체를 리턴하고, 두 개의 콜백 함수를 인수로 받는다 (이행 / 거부)
  - 콜백 함수는 이전 작업의 성공 결과를 인자로 전달 받음
- .catch(callback)
  - .then이 하나라도 실패하면(거부) 동작 (예외 처리 구문과 유사)
  - 이전 작업의 실패로 인해 생성된 error 객체는 catch 블록 안에서 사용 가능
- .finally(callback)
  - promise 객체 반환
  - 결과 상관없이 무조건 실행
- 체이닝 가능

---

## Axios

### axios

- 브라우저와 node.js에서 사용할 수 있는 Promise 기반 HTTP 클라이언트 라이브러리
- Vue에서 권고하는 HTTP 통신 라이브러리

- 특징
  - 브라우저를 위해 XMLHttpRequest 생성
  - node.js를 위해 http 요청 생성
  - Promise API를 지원
  - 요청 및 응답 인터셉트
  - 요청 및 응답 데이터 변환
  - 요청 취소
  - JSON 데이터 자동 변환
  - XSRF를 막기 위한 클라이언트 사이드 지원
    - CSRF

---

### axios API

- axios(config)
- axios(url, [, config])   => URL은 대충 필수!
- axios.get( url, [, config])
- axios.delete( url, [, config])
- axios.post( url, [, data [,config]])
- axios.put( url, [, data [,config]])

----

**꼮 공식문서 가서 보기**
