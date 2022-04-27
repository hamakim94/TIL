# 220425

##  Spring Boot

### 개념

- Spring Boot makes it easy to create stand-alone, production-grade Spring based Applicatrions that you can "just run"
- Most Spring Boot applications need **minimal** Spring configuration

---

### 생성

1. https://start.spring.io/ 

   - 사이트에서 generate라는 과정을 쓰기
   - 스프링은 자바만 할수있는거 아냐
   - jar 쓸꺼(war : tomcat에 서버를 올려서 돌리는 방식)
   - Dependencides 추가
     - DevTools(실시간으로 코드가 변경된걸 확인), Web
   - 생성 후, 파일 압축 후, 임포트!(Existing Maven Project를 사용!)

2. STS툴에서 만들기

   - 프로젝트를 만들 때 Spring Boot - Spring Starter Project가 있네!

   - 나머진 위와 같음

---

### 구조 ( 메이븐 ->  스프링 부트가 가져감)

| 프로젝트의 주요 파일                                         | 설명                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| src/main/java                                                | java source directory(controller, service, 등등)             |
| HelloSpringBootApplication.java<br />프로젝트 이름이 들어간거야 | application을 시작할 수 있는 main method가 존재하는 스프링 구성 메인 클래스. (tomcat 대신이라고 생각하기) |
| static(어디있는지 파악!)                                     | css, js, img 등의 정적 resource directory                    |
| templates(jsp말고 다른거 쓰는 경우)                          | SpringBoot에서 사용 가능한 여러가지 View Template (Thymeleaf, Velocity, FreeMarker 등) 위치 |
| **application.properties**                                   | application 및 스프링의 설정 등에서 사용할 여러가지 property를 정의한 file => 우리가 했던 xml 설정 일부를 처리할 수 있도록.. |
| src/main (/webapp)                                           | jsp등의 리소스 directory -> WepApp 만들거야~                 |

---

### 설정

- application.properties에서 suffix prefix 해야함

- jsp를 사용하려면 내장 jar를 추가해야함(왜냐하면 View Template들이 여러개 있으니까)

---

- server.servlet.context-path = /hamakim94
  - 이거 추가
- server.port = 80  
  - 포트 따로 설정

- pom.xml
  - dependecnies에서 tomcat.embed(내장된거에) jsp 처리할 수 있는 jasper 추가
  - 버전 하면 duplicate이래. 왜?
  - \<parent> 태그가 있음
    - 만들어진거 쓰겠다. artifactId부분을 파보면!

---

### SpringBoot의 특징

- Spring사용시 개발자가 직접 해야만 했던 복잡한 설정을 해결한다
- SpringBoot의 장점
  - 간편하고 자동화된 빌드 및 설정을 제공한다
  - project에 따라 자주 사용되는 library들이 미리 조합돼있다(Best Practice)
  - 복잡한 설정(XML) 하지 않아도 된다(자동)
  - 내장 서버 제공, WAS 추가 설치 X, 개발과 손쉬운 배포가 가능하다(독립실행)
  - WAS에 배포하지 않고도 실행할 수 있는 JAR파일로 Wep Application을 개발 할 수 있다.

---

### 몰랐던거

- application.properties에서, web에 대해 자세히 설정하고 싶으면
- 어노테이션 방식으로 할건데, 보통 configuration 폴더를만듦
- WebConfig.java 클래스를 만들어서
  - application.properties에 있는거 가로채서 더 설정 추가하는게 @EnableWebMvc annotation
