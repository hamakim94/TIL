1. Uniform Resource Locator
2. c ( Page(pageContext) - Request(reqest) - session(session) - application(application))
3. b : WAS : Web Application Server
4. a **이게 질문점, servlet은 web server?
5. 서블릿은 Java코드 안에 HTML을 삽입하고, JSP는 HTML 코드 안에 java코드를 삽입하는 느낌
6. 동적 페이지를 만들기 위한 프로젝트
   1. (JSP와같이 동적인 웹 페이지를 가지는 웹 어플리케이션 개발 시에 사용하는 프로젝트)
7. a. 질문점 : init의 역할, 서블릿 파일을 실행한다는거의 의미?(그냥 실행하면 GET요청으로 되나요?)
8. get방식은 url에 데이터를 쿼리스트링 형태로 "key" = "value" 형태로 전달한다.
   1. 쿼리 스트링(name/value 쌍)이 URL에 포함되어 전송

9. f , h ( 정확히 잘 모르겠음)
   1. foward : 프로젝트 명까지 컨텍스트 루트 , /쓰면 컨텍스트 루트 접근, 안 쓰면 맨 끝만 수정.
   2. redirect, a : 컨텍스트 루트가 프로젝트 명 안 들어감.
10. b ( 정확히 잘 모르겠음)
11. a
12. b
13. **c ( 인터페이스를 상속받음)** 
    1. 후기 : 미쳤네. 맞네. 지렸다. 진짜. ㅋㅋㅋㅋㅋㅋ
14. **c(doInit) : 정확히 잘 모르겠음** 
    1. 질문 : 서비스 안에 (doget dopost) 등이 있었음. 
15. a
16. c
17. POST방식은 url에 정보를 직접적으로 전송하지 않기 때문에 보안상 안전하다(+ 전다 간으한 길이에서 자유)
18. f
19. 지시자 : a
20. 선언부 ( 변수 선언) : c
21. 표현식(변수 대입) : b

22. d, 태그는 지시자? 근데 태그가 정확히 뭐지 ㅠㅠ
23. **GET(정확히 모르겠음)** @ annotation : 의미가 없는거에 의미 부여.
    1. 어노테이션이였어.. 웹 소켓이 뭐지?
24. **<%-- --%> (인터넷 검색), 근데 틀림**
    1. <%-- --> : 페이지 확인 불가,   \<!-- --> : 페이지에서 확인 가능
25. d라고 생각함(ssafy null) 
    1. , getAttribute랑 getParameter랑 차이가 ㅠㅠ?
    2. request안에 param 속성(Attrubute)가 있는거.라고 쉽게만 생각하자!
26. c(세션)
27. b.(리퀘스트)
28. **b(웹소켓이랑, 프로젝트 명 경로가 너무 헷갈리네요 ㅠㅠ)** 
    1. forward는 url이 바뀌지 않는다니.. 미쳤다..
29. **2,3 이라고 생각합니다**
    1. 포워드는 절대경로를 사용할 수 없음(내 프로젝트 안에서만 움직이기 때문에)
30. b라고 생각해요 ㅠㅠ
31. c ( less even)
32. **JSP Tag Library**
    1. fuck. JSP Standard Tag Library
33. e
34. 접두사, ? 어떤 태그인지 알기 위해서?? 으어어얽 뭐라 말해야할지 모르겠음. 약어?
35. **d** Q) end 포함이군!! pdf에는 movie개수가 적어서 덜 나온거군!

## 2일차

1. HyperText Transfer Protocol

2. b(반대로 알고있습니다)

   1. 쿠키

      1. 서버가 생성하는 클라이언트 정보를 가지고 있는 파일
      2. **클라이언트 컴퓨터에 저장**, 필요에 따라 요청시 서버로
      3. key-value형태, 문자열 데이터
      4. 브라우저별로 별도 쿠키가 생성
      5. 목적
         1. 세션 관리(서버 저장 로그인, 장바구니, 게임 스코어 등)
         2. 개인화 : 사용자 선호, 테마 세팅
         3. 트래킹 : 행동 기록/분석
      6. 특
         1. 이름 값, 만료인, 경로정보 ( GET방식이네!!!! )
         2. 클라이언트 : 300개, 도메인 : 20개. 4KB까지 저장가능

   2. 세션

      1. 사용자가 웹 서버에 접속해 있는 상태를 단위보고 세션

      2. 각 세션은 sessionid를 이용해 구분

      3. WAS에 메모리에 객체 형태로 저장 : WAS 메모리 허용범위까지 저장 가능

      4. 쿠키는 클라이언트에 저장 : 공유PC위험, 세션은 서버에 저장되기 때문에 쿠키에 비해 보안 좋음

      5. 로그인/장바구니

      6. (쿠키 안에 session id가 있는지 확인)

         1. ~~~ java
            HttpSession session = request.getSession();
            session.setAttribute("userid", "Tt")
            ~~~

         2. 

3. c

   1. HTTP의 특징 : 비연결지향(connectionless), 무상태(Stateless)
      1. 지속적인 연결유지로 인한자원낭비 방지를 위한 연결 해제
      2. 연결이 해제되면 서버는 클라이언트 정보를 알 수 없음(이를 보완하기위해 쿠키, 세션 등장)

4. b. 이거 정확히 모르겠어요. POST라고 생각합니다(일단 안 보임 ㅋ)

5. **b, 서버에서 클라이언트니, response라고 생각함**

6. (악질) a

7. d

8. b라고 생각합니다

9. a라고 생각합니다

10. 

    1. 모델 1은 하나의 JSP 내에서 요청에 대한 작업을 처리하고 다시 되돌려 보냅니다(응답을 만드러어)

       1. JSP 페이지 내에 화면을 출력하는 HTML코드와 로직을 수행하는 자바 코드가 함께 존재

    2. 모델 2는 서블릿을 만들어 여러 요청에 대한 작업들을 분리해서 처리합니다

       정답 : 요청 처리는 servlet에서, 응답은 JSP에서 처리하는 구조

       요청 처리, 로직 구현, 화면 출력을 따로 처리하는 구조

11. MVC중, 모델의 역할?

    1. Model : **data를 저장하거나, 필요한 형태로 가공**하는 역할을 수행한다.
    2. VIEW : **사용자에게 응답하기 위해서 화면을 작성**하는 역할을 수행한다.
    3. 컨트롤러 : 뷰와 모델 사이의 실행 흐름을 제어. 클라이언트로부터 요청을 받아 이를 분석하고, 어떤 비즈니스 로직을 수행할지 결정한다. 이후 로직의 결과를 보여주기 위한 뷰를 선택.

---

## 틀린문제

### Servlet

- 자바를 사용하여 웹 페이지를 동적으로 생성하는 서버 프로그램, 그 사양
- 웹 서버의 성능 향상하기 위해 사용되는 자바 클래스의 일종
- 웹 기반 응용 프로그램을 구축하기 위한 구성 요소 기반의 플랫폼 독립적 방법을 제공

- **대화형 웹 응용 프로그램을 구축하는데 널리 사용**

---

- ~~~jsp
  <% for(int i=0; i<3; i++){
      out.print(i); 
  } // 결과 :  이상하게 나옴
  ~~~

- **JSP 기본 객체 영역(Scope 메서드) -> 이게 그냥 page, request, session, application 말하는거였어!**

  - **setAttribute, getAttributes, getAttributesNames, removeAttrivute(Stirng )**

---

- EL : jsp 영역 기본 객체(page, requeest, session, application ) 속성 사용 가능
- 표현언어 기본 객체 : param, paramValues!

~~~ jsp
<%= ((com.ssafy.model.MemberDto) request.gettAttribute("userinfo")).getZipDto().getAddress()%>

<%-- EL--%>
${userinfo.zipDto.address}
${sessionScope.student.id}
~~~

---

### EL, JSTL 

- EL 연산자
  - 산술 : +, -, /(div), %(mod)
  - 관계 : ==(eq), !=(nq), <(lt), >(gt), <=(le), >=(ge)
  - 조건 : expr ? val1 : val2
  - 논리 : and, or, not
  - **null : empty**
    - ${empty name}

---

### MVC Pattern

개발 영역을 모델, 뷰, 컨트롤러

- 모델 : 데이터를 저장하거나, 필요한 형태로 가공
- View: 사용자에게 응답하기위해서 화면을 작성
- 컨트롤러 : 뷰와 모델 사이의 실행 흐름을 제어하는 역할. 클라이언트로부터 요청을 받아 이를 분석하고 어떤 비즈니스 로직을 수행할지 결정. 이후 로직의 결과를 보여주기 위한 뷰를 선택한다.

---

### Cookies

- 문자열 데이터

- 동작 순서

  - Client가 요청 생성
  - WAS를 Cookie를 생성하고, Http Header에 Cookie를 넣어 응답
  - Client(Browser)를 Cookie를 저장, 해당 서버에 요청할 때 요청과 함께 Cookie 전송
  - Cookie는 브라우저가 종료되더라도 계속 저장, 만료 기간 전까지 동일 사이트 재방문 요청시 필요ㅔ 따라 Cookie가 재전송

- 특징

  - 이름(key) 값(value), 만료일(Expire date,), 경로 정보
  - 클라이언트 최대 300개
  - 하나의 돔에ㅣㄴ당 20개
  - 쿠키 하나는 4KB까지 저장 가능

- 사용법

- ~~~java
  Cookie cookie = new Cookie("userid", "ss");
  response.addCookie(cookie); // response 안에 있는거야!
  ~~~

### Session

- 특

  - 사용자가 웹 서버의 젒속해 있는 상태를 하나의 단위 보고 세셔ㅛㄴ이라고 한다
  - 각 세션은 sessionid를 이용해 구분한다
  - WAS의 메모리에 객체 형태로 저장
  - 메모리가 허용하는 용량까지 제한없이 저장
  - 쿠키는 클라이언트에 저장 -> 보안 취약, 세션은 서버에 저장(보안에 좋다)
  - 사용자 정보 및 장바구니 등록

- 동작 순서

  - 클라이언트가 페이지를 요청
  - 서버는 쿠키에 sessionid가 있는지 확인
  - session id가 존재하지 않으면 session id를 생성해 쿠키에 쓴 다음, 클라이언트로 반환
  - 생성된 session id를 이용하여, 서버 내 메모리를 생성
  - 클라이언트가 다음 요청 시 쿠키에 session id(JSESSIONID)를 포함해 전달하면 서버내에 저장된 session id와 비교하여 데이터를 조회

- session 설정

  - 브라우저 당 하나의 JSESSIONID를 할당받음
  - 아이디 또는 닉네임과 같이 로그인했을 경우 자주 사용되는 정보를 session에 저장하면 db에 접근할 필요가 없으므로 효율적.

- 사용법

  - 요청 객체로부터 session 객체를 얻어오고
  - session 데이터를 설정하여 저장

  ~~~java
  HttpSession session = requeset.getSession();
  session.setAttribute("userid", "aa");
  ~~~

  - session에서 값을 반환하는 getAttribute 메서드는 반환형이 Object이다

- ~~~java
  String userid = (String) session.getAttribute("userid");
  ~~~

- 삭제 : session.invalidate();

---

### HTTP 에러

404 : 서버는 요청받은 리소스를 찾을 수 없어

405 : 요청한 메소드는 서버에서 알고있지만, 제거되었고 사용할 수 없습니다.

​	Get method방식으로만 overriding 돼있는데 Post로 온 경우 405!

500 : 컴퓨터에서 실수

---

${msg} : 아무것도 출력되지 않는다

- sendredirect 에 있어서, 그냥 출력 자체가 안 된다.(없으면)

**Q) 컨텍스트 루트 반환하는 함수 이름**

request.getContextPath();

---

@Webservlet() : 주소에 대한 타이핑을 엄청많이해봐야한다.

- (form action / ) : 포트번호 다음부터, 안 쓰면 내 마지막주소만 갈아끼울게
- (많은 시행착오가 필요하다)

