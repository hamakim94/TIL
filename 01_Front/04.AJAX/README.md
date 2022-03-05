# 22/03/04

## Ajax : Asynchronous JavaScript and XML

- 비동기 방식의 자바스크립트 XML 

  - 페이지 전채를 새로고침 안 해도 수행된다고

- Apps:

  - 구글맵, VIBE, 네이버 검색 등..

- 직관적이고 자연스런 사용자 상호액션 방식

  - 기존 클릭 필요 X

- 화면의 일부분의 변경:

  - 기존 - 서버 요청, 대기, 전체화면 새로고침
  - AJAX - 업데이트가 필요한 부분만 변경

  

  

- 기존 : 서버에 요청한 데이터가 도착할 때까지 클라이언트는 대기

- AJAX : 서버에 요청한 데이터가 도착할 동안 클라이언트를 **멈추지 않고** 동작

---

### XMLHttpRequest

- JS객체
- 대부분 브라우저 지원
- 표준 HTTPS(GET/POST) 으로 서버와 통신 ( HTTP : 약속! )
- 서버와 통신시 비동기적으로 작업
  - 백그라운드에서 작업

---

#### 메또드

- open("HTTP method", "URL", **sync/async**)
  - 요청의 초기화 작업
  - GET / POST 지정
  - 서버 URL 지정
  - 동기 / 비동기 설정   => 설정만 해놓고 send가 보냄, 일종의 명세서

- send(content)
  - GET 방식은 URL에 필요정보를 추가 하기 때문에 null 적용 (content에 null을 쓰면 된다)
  - POST 방식에서 파라미터 설정 처리

---

#### 속성  : http response status mdn

- onreadystatechange
  - 서버에서 응답이 도착했ㅇ르 때 호출될 콜백함수 지정
    - 콜백함수 : 작업 요청을 보내놓고, 그게 끝나고 나서 할 작업들
  - 콜백함수는 상태(readyState)가 변경될 떄 마다 호출
- status ( 크게 5가지 : 100, 200, 300, 400, 500번대)
  - 서버 처리 결과 상태 코드
  - 200 (요청 성공)
  - 404 (Not Found)
  - 500 : Server Error
- responseText
  - 서버의 응답 결과를 텍스트로
- responsXML
  - 서버의 응답 결과를 XML로



### Ajax 프로그래밍 서순

1. 클라이언트 이벤트 발생
2. XMLHttpRequest 객체 생성  -new / open
3. XMLHttpRequest 객체 콜백함수 설정 - onreadyChangee => fucntion하나 만들어
4. XMLHttpRequest 객체를 통한 비동기화 요청 - send
5. 서버 응답 결과를 생성해 클라이언트로 전송
6. XMLHttpRequest객체는 서버 결과를 처리할 콜백함수 호출
7. 결과를 클라이언트 화면에 반영



ovenapp - 프로토타입

---

header

main

footer