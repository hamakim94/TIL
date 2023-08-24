# 220325

## Spring Web MVC 활용

이제 마이바티스 쓸건데, mybatis만 활용할 때 어땠는지!



 루트컨테이너 ( dao, service, 빈 객체들 ) : 

서블릿 컨테이너(IRVR : viewResolver, MyController) : 여기서 의존성 주입으로 루트컨테이너를 참조

(다른 컨테이너가 생겼을 때도 루트컨테이너를 참조해서 데이터 등록 가능)

---

#### 순서

1. web.xml에 서블릿(MVC), 리스너(Service이하), 필터(한글) 등록
2. 서블릿 컨테이너에서 읽힌 컨트롤러 컴포넌트 스캔 및 컨트롤러 구현
3. 리스너에서 읽힌 루트컨테이너에서 서비스 이하 컴포넌트 스캔 및 구현

---

#### #{}, ${}

\# : 타입에 맞게 꺼냄 #{} : '나는'

\$ : 그냥 꺼냄     : ${} 나는 

-> sql문에서 변수명 얻을땐 $로, 컬럼명은 #으로

---

## Spring Legacy Project

## AOP(Aspect Oriented Programming)

- 관점에 따라서 코드를 분리하자

- OOP에서 모듈화의 단위는 클래스, AOP에서 모듈화의 단위는 Aspect
- Aspect는 여러 타입과 객체에 거쳐서 사용되는 기능(Cross Cutting, 트랜잭션 관리 등)의 모듈화
- SpringFramework의 필수 요소는 아니지만, AOP프레임워크는 SpringIoC를 보완함.

---

logging                         

security (Active X.. )

예금 인출 / 예금 송금 (하는데 공통 단계가 있네!)

transaction                 => 이렇게 여러 객체 거치는걸 재사용하자는게 AOP



- 프록시 : 중개기늠 서버

	// 입실체크             (before) : 핵심관심사항 전
	// 소와같이 공부를 합니다 (핵심관심사항)
	// 코로나 발생 : 임의 퇴실 (after-throwing) : 핵심관심사항 후 문제 발생
	// 퇴실 체크를 합니다.     (after-returning) : 핵심관심사항 후 일
	// 달달한 저녁시간을 보냅니다. ( after) : 아에 따 끝.
		
	// 취직 후
	
	// 입실체크
	// 소와같이 공부를 합니다. (핵심관심사항)
	// 코로나 발생 : 임의 퇴실
	// 퇴실 체크를 합니다.
	// 달달한 저녁시간을 보냅니다.

---

### 프록시 패턴!

A : implements~인터페이스

​        (핵심관심사항만 구현)

B : implements~인터페이스

​	    공통관심사항

​	    new A()

​		공통관심사항

---

### AOP 용어

- Aspect : (Advice + PointCut)
  - 여러 클래스에 공통적으로 구현되는 관심사(Concern)의 모듈화  -> PersonProxy
- Join Point 
  - 메서드 실행이나 예외처리와 같은 프로그램 실행중의 특정 지점(a 함수 호출, b 함수 콜 ..), Spring에서는 메서드 실행을 의미한다.
- Advice 
  - 특정 조인트포인트(join Point)에서 Aspect에 의해서 취해진 행동, Around, Before, After 등의 Advice 타입이 존재
  - ex) 입실체크 + before, 퇴실체크 + after-returning
  - 언제, 어떤 코드를
- PointCut 
  - Join Point에 Aspect를 적용하기 위한 조건 서술. Aspect는 지정한 pointcut에 일치한는 모든 joint point에서 실행된다.
  -  기준 시점
  - (Advice + PointCut : Aspect)
- Target 객체 
  -  하나이상의 advice가 적용될 객체. SpringAop는 Runtime Proxy를 사용하여 구현되므로 객체는 항상 Proxy객체가 된다.
  - Student or Worker
- AOP Proxy 
  - AOP를 구현하기 위해 AOP 프레임워크에 의해 생성된 객체. Spring Framework에서 AOP프록시는 JDK dynamic proxy(동적바인딩) 또는 CGLIB proxy이다.
- Weaviing : Aspect를 다른 객체와 연결하여 Advice 객체를 생성. 런타임 또는 로딩시 수행할 수 있지만 Spring AOP는 런타임에 위빙을 수행

**Aspect를 정의하기 위해 Advice(어떤 코드를 언제)와 PointCut(어떤 녀석이 호출될 때)을 지정할거야.**

입실체크를 부를때, dosomting이 실행될때

---

### Spring AOP Proxy

- 실제 기능이 구현된 Target객체를 호출하면, Target이 이 호출되는 것이 아니라 advice가 적용된 proxy 객체가 호출됩니다.
  - Target 호출 -> PROXY { advice (Target) advice} 
  - Proxy라는 틀 안에, target주위 advice들이 실행된다고
- SpringAOP는 기본값으로 표준 JDK dynamic proxy를 사용.
- 인터페이스를 구현한 클래스가 아닌 경우 CGLIB 프록시를 사용

---

### Spring AOP

- @AspectJ : 일반 Java 클래스를 Aspect로 선언하는 스타일, AspectJ 프로젝트에 의해 소개됨
- Spring AOP에서는 pointcut 구문 분석, 매핑을 위해서 AspectJ 라이브러리를 사용함
- 하지만 AOP runtime은 순수 Spring Aop이며, AsepctJ에 ㅇ대한 종속성은 없음

---

### Spring AOP 시작하기 - xml

- #### Aspect 선언하기 - xml 방식

- Aspect는 핵심 관심사항 (Core Concern)

- @Aspect annotation 또는 xml bean 등록

  1. pom.xml에 dependencies tag에 aspectj 등록
  2. com.ss.aop에 , 어떻게 쓸지 대략 등록
     1. MyAspect.java( 공통관심사항, 우리가 바꿀거)
     2. 핵심관심사항의 Interface 만들기(Person, 바꿔끼울거)
     3. 클래스로 implemens Inerface 해서 바꿔 끼울 핵심관심사항 생성(student, worker)
     4. 예외 처리할거 생성
     5. 이제 bean으로 등록(applicationContext.xml에서 등록)

  ~~~ xml
  <bean class="com.ss.aop.MyAspect" id="myAspect"></bean>
  <bean class="com.ss.aop.Student" id="student"></bean>
  <bean class="com.ss.aop.Worker" id="worker"></bean>
  ~~~


     6. Testfile 생성

        ~~~java
        ApplicationContext context =
        new GenericXmlApplicationContext("applicationContext.xml");
        // context.getbean("text", Interface.class) 를 통해서 bean 갈아끼움		
        Person ss = context.getBean("student", Person.class);
        try {
            ss.doSometing();
        } catch( CoronaException e) {
        }
        ~~~

        ---

- 포인트 컷은 어떤 조인트포인트를 사용할지 결정한다. Spring AOP는 메서드 실행만 지원한다

  - 포인트 컷 선언은 두 내용을 포함한다
    - 조인포인트에대한 표현식
    - 포인트 컷의 이름

- ~~~ xml
  <aop:config>
  		<!-- AOP 패키지에 있는 모든 클래스에 doSomething()이 불릴 떄.. -->
      	<!-- 여기선. 패키지명, *(모든 클래스).doSomething 메또드-->	
  		<aop:pointcut
  			expression="execution(public void com.ss.aop.*.doSometing())"
  			id="mypt" />
      	<!-- 여기선. 패키지명, *(모든 클래스).doSomething 메또드-->	
  		<aop:aspect ref="myAspect">
              <!-- before : target method 실행 전-->
  			<aop:before method="before" pointcut-ref="mypt" />
              <!-- before : target method returning -->            
  			<aop:after-returning method="after_rt"
  				pointcut-ref="mypt" />
              <!-- before : target method 실행 throw. -->
  			<aop:after-throwing method="after_th"
  				pointcut-ref="mypt" />
  			<aop:after method="after" pointcut-ref="mypt" />
  		</aop:aspect>
  	</aop:config>
  ~~~

- 종류
  - before -
    - target 메서드 호출 이전
  - after
    - target 메서드 호출 이후, java exception 문자의 finally와 같이 동작
  - after returning
    - target 메서드 **정상** 도착 후
  - after throwing - 
    -  target 메서드 에러 발생 후
  - around 
    - target 메서드의 실행 시기,

