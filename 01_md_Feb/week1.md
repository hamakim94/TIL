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

# 22/02/03

cf) main함수

​	public static void main(String[] args){}



## HTML 기초	

### HyperTextMarkupLanguage

-  하이퍼텍스트 : 뭐 누르면 다른거 읽어지고, 다른거 읽어지고,, 왔다갔다
- 마크업 : 웹 브라우저에게 웹 페이지 내의 글자나 이미지를 어떻게 나타낼 것인가에 대해 알려줌
  - 역할 부여

~~~ html
<html>
    <head> 다양한 설정, 정보
        <title>
            사이트탭쪽 글자가 바뀜
        </title>
    </head>
    <body> # 실제 내용을 작성
        
    </body>
    
</html>
~~~

### 특징

- **태그는 대소문자 구분이 없다**
- 확장자는 html (htm을 쓸 순 있지만 주로 html!)
- 엔터, 스페이스바, 탭이 적용되지 않는다

### 모르는거 생기면

- a tag html mdn라고 검색하기

#### vscode

- alt + b -> 알아서 실행(open in browser)
- ㅁ html5 클릭 -> 알아서 init

### \<a tag>

- href 속성 필수

- target 
  - _self : 내 창에서 해당 url 보여줌 ( default )
  - _blank : 새 탭에서 해당 url 보여줌
  
- 상대경로 이동, 팝 위치에 해당하는곳으로 옮겨주는 기능도 있다.

  ~~~html
  <h1 id = "top"></h1>
  수많은 줄들, 
  <a href = "#top">위로</a>
  ~~~

  

---

### 대표적 block, inline 태그

- block : 
  - div : 단락 구분 태그(block)
  - 문서 왼쪽부터 끝까지 공간을 차지
  - p, h1~h6

- inline : 엘리먼트의 내용만큼만 영역 ( 크기설정 불가 )
  - span : 하나의 단락 내에 영역을 구분
  - 내가 작성한 내용만큼의 공간을 차지함
  - img, 
    - 기타 mdn 보기


---

### 줄넘김 : \<br>

자세한건 예시(실습)들 보면서 하자..(테이블, border, 등등 )

---

### Table 

- 그림 먼저 그리고 테이블을 만드는게 좋다
-  \<thead>, \<tbody>, \<tfoot> 명시를 해주는게 좋다
  - 장점 : 코드에 위치에 상관없이 테이블 밑에, 위치에 넣어줌!
- \<tr> : 행, \<td>  : colspan, rowspan , \<th> head 

---

### \<form> 태그!

- HTML의 꽃
  - action : action에 적혀진 url로 정보를 보냄.
  - method : 브라우저가 http 요청을 보낼때 사용하는 HTTP Method(GET, POST)
    - Get : 우리가 보이는 url에 폼에 실어서 보냄 ( 보이기 떄문에, 다른사람이 봐도 괜찮은 정보)
      - 주소에 넣기 때문에 넣을수 있는 한계가 있다
      - CRUD 중, R만 Get
    - Post : 안 보이는 곳에 폼을 통해 서버로 보냄.(회원가입 등등, 안전하게 처리 )
      - 여긴 더 많은것을 넣을 수 있다.
      - CUD 다 포스트
  - enctype : 파일업로드 기능 구현 시 반드시 설정해야 할 속성

- \<input>
  - name 속성 : url에 등록될 이름
  - value 속성 : 기본적으로 가지고 있을 값
- \<select name = "", id = " ">
  - \<option value="">/\</option>
  - \<option value="">/\</option>
  - \<option value="">/\</option>   : key, value 형태로 전달해

- \<textarea>
  - 여러줄 입력 받을 떄



ctrl + alt : 멀티커서



## CSS

### Selector   속성 : 값 속성 : 값

h1 {color : blue; font-size = 12px;}

<style>
    p{
        color : red;
        etc..
        /* 주석이다 */
    }
</style>

### CSS 적용방식

- 1. inline style
     - 태그에서 스타일 속성을 직접 사용
     - 스타일이 바꿀 부분이 많지 않아
     - 형식 : <태그명 style = "속성명 : 값;, 속성명 : 값; "
- 2. Internal Style :내부에 임의로 지정
- 3. External Style : 외부 CSS 파일
  4. 엄청많다..

---

### 선택자 

- #test > .memo : 자식( 내 바로 밑에 잇는 태그들만 해당)
- #test .memo    : 자손( 내가 포함하고 있는 모든 것들, 다 나와!)
- #test > .memo.bi : id가 테스트 바로 밑, 메모 클래스와 bi 클래스 모두 갖고 있는것다 나와!

---

### CSS 크기 지정 단위

- px : 픽셀 단위의 해상도에 점 하나에 해당하는 절대 크기 지정
- % : 부모 기준 상대 크기
- em  : 1em : 부모와 동일, 2em 부모의 2배(배수)
- rem : 루트 태그(16px) 기준 size 

---

### CSS 속성

- background-... : 배경의 스타일을 변경할 떄

- border-... : 엘리먼트의 테두리 스타일 변경
- text-... : 텍스트의 스타일을 변경할 때 

---

### CSS 적용 우선순위

- **!important > inline style> id > class > tag**
- style 지정할 떄 나중에 적용된게 우선 순위야(같은 클래스에서,)
  - id : 무적권 하나만 써!

---

#### CSS Selector Game

CSS Selector Game 하기!

CSS Selector 관련 문서 찾아보면서 공부하기

- CSS로 못만드는건 없어! 방법을 모를뿐!

---

### HTML의 태그는

**content < padding <  border < margin**

- content : 글이나 이미지 등 요소의 실제 내용
- padding : 테두리 안 쪽의 내부 여백
  - 엘리먼트와 컨텐츠 사이의 간격 ( 위족 오른쪽 아래쪽 왼쪽)
  - 요소에 적용된 배경색, 이미지는 padding까지 적용..
- border : 테두리 영역.

- margin : 테두리 바깥의 외부 여백
  - 엘리먼트와 엘리먼트간 간격..
  - 배경색을 지정할 수 없다.
  - 마진상쇄(더 큰걸로 마진이 챱챱)

---

### Layer 개요

- 단순히 영역만 만들어줌
- 겹쳐 쌓기 가능
- 위치 조정 가능
- 가시성 조절 가능 등

# 22/02/04

## Quiz후기

~~~java
String a; // 이렇게 하면 초기값 설정 안 돼, String에 대한 이해가 부족하다
String[] arr = new String[2];
arr[1] = "Name";
system.oyt.println(arr[0] + arr[1]); // 결과 nullName, 배열로 만들면 힙, 초기값 저장돼
~~~

- OOP is A PIE 다시정리
  - A:
  - P:
  - I:
  - E:


---

- try문에 여러개 에러가 발생할 떄

  ~~~ java
  int[] arr1 = new int[3];
      try {
          arr1[1] = arr1[1] / 0;
          arr1[3] = 0;
      } catch (ArrayIndexOutOfBoundsException e) {
          System.out.println(2);
      } catch (ArithmeticException e) {
          System.out.println(1);
      }
  // 결과 : 1
  // 먼저 일어난 에러에 대해서 처리해주나봐.. 몰랐네..
  ~~~

---

- Switch - Case
  - break문 없으면, 해당 case 아래에 있는 모든거 실행

---

- Object는, java.lang.Object

  - java.lang 패키지는 자바 프로그래밍에 기본이 되는 클래스들
  - import문 없이도 사용 가능

  

- HashSet 
  - equals 재정의 할 때
  - Hashcode라는게 없으면 다 다르게 인식함



## HTML+CSS

- favicon : 탭 옆에 있는 그림
- \<img>에, alt ? => 이미지가 깨졌을 떄 나오는 명칭(시각장애분 위해서도 설정)
  - alternative

---

### BootStrap

- install 맨오른쪽 링크 클릭 -> 그냥 아이콘 사용 가능!
- 아이콘이 아니라 텍스트, 그래서 텍스트 컬러 지정 가능

---

### Layer

#### static(default, fixed, absolute, relative)

- static :
  -  좌표를 설정하더라도 값이 반영 X(일반적인 요소의 배치 순서를 따름)
  - 부모 요소 내에서 배치될 때는 부모요소 위치를 기준으로 배치됨
- fixed : 위치 고정
  - 공간 차지 X
  - 부모요소 관계 없음.
    - 우리가 보고있는 화면 기준이다.
    - 스크롤시 위치고정
- absolute : 절대좌표  (top right bottom left 계산)
  - 공간 차지 X
  - 요소를 일반적인 문서 흐름에서 제거 후 레이아웃 
  - **스태틱이 아닌 요소**를 찾아감(body - 부모요소)
- relatvie : 
  - 공간 차지 O
  - 정상 흐름,  
  - 상대적인 거리 (top right bottom left 계산)
  - 레이아웃에서 요소가 차지하는 공간은 static일때와 같음

​	html 태그는, 왼쪽 위로 가고싶어해!!

---

#### z - index

- 박스가 겹쳐져 있는 경우 보여주는 순서!
- 값이 큰게 위로 올라간다!!
  - 입체적으로 봐야한다
  - z축을 컨트롤해서 원하는 높이에 원하는걸 쌓겠다!

---

### float : 추후 공부

- 특정 요소를 둥둥 떠다니게 해서 공간을 차지하지 않게돼

## FLEXBOX

- flexbox 인터페이스 내의 아이템 간 공간 배분과 강력한 정렬 기능을 제공하기 위한 1차원 레이아웃 모델

### 주요 개념

- 주축(Main Axios), 교차축(Cross Axios)
  - 주축을 column 하면 교차축이 row가 돼
-  시작선(start), 끝선(end)
-  container와 item

---

### FLEX CONTAINER ( 부모 요소 )

#### display가 Flex-Container 정의하는것

- display 속성 이용, container를 생성
- display : flex ; -block 성격의 container            (끝까지 영역 차지 )
- display : inline-flex : - inline성격의 container (끝까지 영역 차지 X)

---

#### container 주요 속성

- **flex-direction** : container안의 item들이 나열되는 방향

  - row (default)| column | row-reverse | column | column-reverse

  ---

- **flex-wrap** : container안의 item의 크기가 container보다 크기보다 클때 줄 넘김

  - nowrap : 한줄로 다넣어 (default) | wrap : 줄바꿈 | wrap-reverse: 밑에서부터 쌓아서 위로 넘겨줄게~

  ---

- **flex-flow** : 방향과 줄 넘김을 동시에 설정

  - 위에 두개 조합, 총 12가지 (상상해보고 직접 타이핑 확인)
  - flex-flow : row-reverse nowrap

  ---

- **justify-content** : **메인축** 정렬 제어

  - flex-start : 메인축 시작쪽 정렬(row면, 좌측으로)
  - flex-end : 메인축 끝 쪽 정렬(row면, 우측으로)
  - center : 중앙 정렬
  - space-between : 양 사이드를 끝으로 보내고, 나머지를 가운대로
  - space-evenly : 남아있는 여백을, 공간 자체를 딱 떨어지게
  - space-around : 남아있는 여백을, 모든 아이템 요소 왼,오른쪽 정확하게 똑같이 분배

  ---

- **align-items** : 교차축 정렬 제어 (만약 주축 row:)

  - stretch(default) : 교차축 방향으로 쭉 늘려놔
  - flex-start : 세로 위로 붙어!
  - flex-end
  - center : 교차축 기준 중앙! 
  - baseline : 글자 끝선에 맞춰서 정렬하게됨(컨텐츠)

  ---

- **align-content** : wrap속성에 의해 여러 줄이 발생한 경우 **교차축** 정렬

  - 교차축인데 두 줄이 된 친구가 있다면 쓸 수 있음

  - (123

       45)

  - flex-start : 교차축 위로(크기 그대로)

  - flex-end : 교차축 아래로(크기 그대로)

    - 중력 작용 X, 그대로 밑으로 내려오지 땡겨지지 않아

  - center : 중앙정렬
  - space-around, space-between , space-evenly : 위에 있어 

---

### FLEX ITEM에 사용하는 주요 특성

컨테이너에 작성하는게 아니라, 아이템에 직접 데이터를 작성

- **order** : 숫자(기본값 0 )
  - 낮은거 -> 큰거로 배치 순서 바꿀 수 있다
- **flex-basis** : 크기 ( 너비만 바꿀 수 있다. )
  - 주축 기준 크기로?
- **flex-grow** : 팽창(기본값0), 음수 불가능, 양수 가능
  - 기준 잡기가 애매하다
  - 남아있는 여백을 가지고 비율로 나눠먹기
- flex-shrink (잘 안 써)
- **flex: ** grow, basis, shirnk 한 번에 쓸 수 있음.
- **align-self** : 각각 요소에 접근에서 **교차축**을 이용해 정렬을 할게!
  - auto
  - stretch
  - flex-start
  - flex-end
  - center

---

emmet : html 마법의 워드
