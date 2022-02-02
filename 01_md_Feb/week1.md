# 22/02/01

## 다른사람 코드 보며 느낀점

- 열심히 해야겠다.. (너무잘하네)
- MainUI -> 다른 UI로 넘어갈 때, 0 입력받으면 return => 해당 while문 종료

### 지-경

~~~ java
// sel == 0일때, 모든 값 
MainUI.getInstance().service();
	break;
// 보통 return을 쓰는데, 순서때문에 이렇게 하신건가요?(신기)
~~~

~~~ java 
Type mapTokenType = new TypeToken<Map<Integer, VideoReview[]>>(){}.getType();
Map<Integer, VideoReview[]> jsonMap = gson.fromJson(jsonStr, mapTokenType);
// 이렇게 한 이유가 arraylist는 못 넣어서??
~~~

#### 최고 - 1줄컷!

~~~ java
videoReviewDb = gson.fromJson(str, new TypeToken<HashMap<String, ArrayList<VideoReview>>>() {}.getType());
~~~

- type 받기 : import java.lang.reflect.Type; // 고급기능, 메타데이터

- 임포트 된거 , (+) 눌러서 펼치면 예쁘게 나온다.

### Reflection이란?

- JVM에서 실행되는 애플리케이션의 런타임 동작을 검사/수정할 수 있는 기능이 필요한 프로그램에서 사용됩니다.
- 이걸 사용해 스프링에서 런타임 시에 개발자가 등록한 bin을 애플리케이션에서 가져와 사용하는 것.
- 잘 모르지만, 쓰면 보통 느려진대
- 실행시 액세스 권한 필요 / 캡슐화 저해까지 할 수 있어 주의해서 사용해야 한다.

# 22/02/02

## Threads

### 익명 객체란

- 프로그램에서 일시적으로 한 번만 사용되고 버려짐(재사용 X)
  - UI 이벤트처리, 스레드 객체 등

~~~java
//상속
부모클래스 변수 new 부모클래스 () {};
//구현
인터페이스 변수 = new 인터페이스 (){};
~~~

- 클래스 로더?에서, $클래스명 으로 익명객체를 만든다

### 스레드 우선순위

### 동시성 & 병렬성

- 동시성
  - 멀티 작읍을 위해 하나의 코어에서 멀티 스레드가 번갈아 실행
- 병렬성
  - 멀티 작업을 위해 멀티 코어에서 개별 스레드를 동시에 실행

| 우선순위 방식                          | 순환 할당(Round-Robin) |
| -------------------------------------- | ---------------------- |
| 우선순위를 정해(1~10) 1이 낮아(기본 5) | 우리가 설정 불가       |

- 우선순위 : Thread.setPriority()

  - 코어의 개수(스레드)보다 스레드가 많을 때 우선순위가 의미가 있음

- 여러 스레드 공유 객체 사용시 주의.. => 객체 잠금 가능

  ~~~java
  Public synchronized void method(){
      임계 영역; // 단 하나의 스레드에서만 실행 가능, 외부 막아
  }
  
  public void method(){
      // 여러 스레드 실행 가능
      synchronized(공유객체){
         //임계 영역
      }
  }
  ~~~

### 스레드 상태

- run()하면 사실 실행이 아니라, 실행 대기 상태(RUNNABLE)가 돼
- run() 하면 뺴꼼 실행 <=> RUNNALBLE로 (다른스레드 실행)
- 이러다가 뿅 하고 끝남
  - 일시 정지 상태가 되기도 하는데, 다시 실행 대기 상태로 돼야 실행 가능
  - getState() 메소드가 추가됨

기타 기능들이 참 많다. 다음에 알아보자



## 람다식

- 익명 함수를 생성하기 위한 식(OOP보다 함수 지향 언어에 가까움)
- " (매개변수) -> {실행코드} ", 인터페이스의 익명 구현 객체로 생성

~~~ java
// 기존
Runnable runnable = new Runnable(){
    public void run(){ ... }
}
~~~

~~~java
// 람다식
Runnable runnable = () -> { ... } // ?????
~~~

### 식 형태

- (타입 매개변수 ... ) -> {실행문 ; ... }
  1. (타입 매개변수 ... ) 는 오른쪽 중괄호 블록을 실행하기 위해 필요한 값 제공
  2. **매개변수 타입은 런타임시 대입되는 값에 따라 자동으로 인식, 지정 X** 
  3. 하나씩 있다면 괄호 생략가능..
  4. 매개변수 없어
  5. 리턴값 가능, 리턴문만 있으면 그냥 다음같이

~~~java
1. (int a) -> {syso(a);}
2. (a) -> {syso(a);}
3. a -> sysout(a)
4. () -> {실행문;}
5.(x,y) -> {return x+y;}; // -> (x,y) -> x+y
~~~

### 타겟 타입, 함수적 인터페이스

~~~ java
@FunctionalInterface
public interface MyFunctionalInterface{
    public void method(int x); // 매개변수가 없기도 있기도..
}
~~~



- 람다식은 인터페이스 변수에 대입됨(인터페이스의 익명 구현 객체 생성)
- 람다식은 구현 클래스를 생성하고 객체화 
- 인터페이스의 종류에 따라 작성 방법이 달라져 이를 람다식의 타겟 타입이라고 함.

#### 타입에 따라 신경쓸 점

- 람다식은 오직 하나의 메소드 정의.(2개 이상 X)
- 오직 하나의 추상 메소드가 선언된 인터페이스만이 람다식의 타깃 가능
  - @FunctionalInterface => Annotation으로 체크 가능
- 매개변수는 오직 1개만,

- 클래스의 멤버 사용 -> 외부 객체를 참조할 때는 외부.this.멤버변수
- 로컬 변수 사용은 final만 가능
- THread 되는 이유 : Thread 인터페이스는 리턴값이 없는 void만 함수가있어서.

### 표준 API의 함수적 인터페이스

- Counsumer : 그냥 소비
- Supplier : getXXX메소드 있어, 호출한 곳으로 값을 돌려줌
- Function
  - 매가값과 리턴값이 있는 applyXXX() 메소드
  - 매개값을 리턴값으로 매핑(타입 변환)하는 역할
- Operator
  - applyXXX()메소드, 매개값을 이용해 연산후 동일한 타입으로 리턴값을 제공 역할.
- Predicate
  - boolean 리턴값이 있는 testXXX() 메서드
  - 매개값을 조사해서 true / false 반환..
- 등등.. 기능이 많다!

