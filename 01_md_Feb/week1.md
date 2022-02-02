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



