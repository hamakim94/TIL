



# 22/01/24

## 틀린거

#### static과 private을 혼동함

- if문 반복이 좀 많으면, 배열로 받아서 while문 써서 해보자
- 기본생성자 빈칸 만들기 => 아무것도 없어도 실행 가능
  - 추후에 멤버변수 넣으면 돼/ this 굳이 안 넣어도 기본값 잡혀 실행 가능!
  - private한 멤버변수 -> 생성자로 변수 값복사-> this로 가능!!!(setter 쓸 필요 없다)

- 클래스 테이블 네모(핑크색) : private  변수
- 동그라미(녹색) : constructor
- 그냥 녹색 : 메소드

---

## 상속 & 다형성

- 기본 : 상속받은 자식클래스의 객체 -> 부모 클래스도 생성 -> 그다음 자식
- 그래서 생성자 또한 마찬가지인걸로!

---

#### 다형성

- 부모 클래스의 참조변수로 자식 클래스의 객체를 참조 가능
- 하지만 부모 영역만 접근이 가능!

~~~java
// person변수가 현재 참조하고 있는 실제 객체가 Student type으로 참조가 가능한지??
Mother mother = new mother();
if (mother instanceof Son){
    
}
~~~

- 동적바인딩 (메소드 :  부모 영역에서 호출해도 자식에서 오버라이딩된 메소드가 출력돼)

---

## 추상클래스

- 내가 분명 아무것도 안 만들건데
- 자식 클래스의 규격을 위해서 (동적 바인딩을 위해) 부모에 원형은 만들어
- 자식에선 무적권 override해서 써야해!

---

### 만들기

- => public **abstract** void cook(); => 미완성 함수, 추상 메소드
- 메소드 구현부분{} => ; 로 대체
- 추상메소드르 하나라도 가지고 있는 클래스는 
  - 의무적으로 추상클래스가 돼, 그레서 abstract 키워드가 필요

---

- 추상클래스를 만들면

  - 추상메소드를 구현해야하는 의무가 생김!!

- 추상클래스 : 미완성, 객체로 만들 수 없음.(타입으로선 동작 가능)

  - 익명클래스 문법으로 1회용 구현과 함께 객체 생성

  ~~~java
  // 원랜 abs는 추상클래스라 객체 생성이 안 돼
  kk c2 = new abs(){   // 익명클래스, anonymous class
  	@Override        // 해당 블록도 구현인데 이릉이 없음
  	public void cook(){//보통 이벤트(버튼)할 떄 이걸 만듬
  	  정의
  	}
  }
  ~~~

## 인터페이스(Interface)

**관련있는 상수와 추상클래스들을 모은 사용자 정의 자료형!**

- 클래스 : 관련있는 변수나 함수를 묶어놓은 사용자 정의 자료형

- 인터페이스 : 추상 메소드의 모임(오로지 규격을 위해 존재한다)

- '설계도'

- static final 없어도 모두 상수로 적용

- abstract 없어도 추상

- 객체 생성은 불가능하지만, type으로서는 가능하다

관련있는 상수와 추상클래스들을 모은 사용자 정의 자료형!

---

- static : 그냥 변수, 그냥 함수, 함부로 쓰면 **상속이 아에 안 돼!!**
- 규격을 잘 만들어놓으면, 분업이 가능함..!
- 규격이 있어서, interface 업데이트 -> V2라는걸로 implements 바꿔
  - 그럼 업데이트.

---

## 예외 처리

- Error(원인 : 시스템발)
  - 메모리 부족, stack overflow : 일단 발생하면 복굽 ㅜㄹ가
  - 프로그램의 비 정상적 종료를 못 막아
- Exception 
  - 읽으려는 파일 X, 네트워크 연결 X, 수습할 수 있는 상태가 약함
  - 프로그램 코드에 의해 수습
- 예외 처리(Exception Handling)
  - Checked Exception
    - 예외에 대한 대처 코드가 없으면 컴파일 진행 X
    - Exception class
  - RuntimeException ( Unchecked Exception)
    - RuntimeException의 하위 클래스
    - 예외 대처 코드 없더라도 컴파일 진행
- 공부하는 이유
  - checked Exception에 대응하기
  - unchecked - 예외 상황을 전달하기위해서(좀 어렵)

---

#### try-catch(직접 처리)

result a / b -> 위험한 코드를 try 블록에 넣고

​                         코드에서 예외가 발생했을 때 경우의 대비를 catch블록에서

~~~java
try{    //위험한 코드를 try 블록에
    result = a / b;
}
catch(Exception e){ // 발생할 때 처리방법을 써서, 그냥 밑 코드도 실행돼
    syso("예외 발생, 처리 방법")
}
~~~

- 다중 catch문
  - 상속 관계, 작은 범위(자식)에서 큰 범위(조상) 순으로.

---

## 문제풀이 틀린거

- String.isIndexOf() -> 만약 포함되지 않으면 -1반환
- instanceof 사용법 : 객체 instanceof 클래스 (연산자 느낌이 강해)

  - 일단 자료를 담을 배열은 부모클래스를 사용하고, 자식클래스인경우 Parent p = new Son s , 즉 캐스팅을 하자
  - 그 다음 instanceof를 활용해서 만약 Son의 인스턴스가 맞다면 그때 형변환해서 사용!
  - A instanceof B 은 boolean을 반환, 따라서 !(A instanceof B)
- 반복문의 조건을 활용해, 새로운 배열을 만들 때, index에 대한 혼동을 조심해야한다. 초기에 0 선언하고, 그걸 이용하면 안 돼.
- 이런,, 복붙 할 때, 어디서 가져오는지 확인해, 배열 이름 정확히 확인해 제발..(가능하면 복붙 하지 말자 ㅠㅠ)
- size 모를 땐, while문을 돌면서 하면 굳이 사이즈 가져올 필요 없음
- toString : Overridng해서 정의해야 쓰기 편해, source - generate toString 이용해서 약간씩 수정하자

# 22/01/25

## 틀린거

~~~java
Imother mother = new motherImpl();
~~~

- 인터페이스(Imother)를 implements한 motherImpl class
- 인터페이스로 구현한 객체를 사용하기 위해
  - 인터페이스 변수를 선언 
  - 구현 객체를 대입
  - 인터페이스 변수는 참조 타입이기 때문에 구현 객체가 대입될 경우 구현 객체의 번지를 저장합니다.

~~~java
public class MMImpl implements IMM{
	private static IMM instance = new MMImpl(); 
	// privte : 다른 클래스에서 변경 불가, static : 정적, 클레스 객체
    // 즉 new MMImpl의 객체는 단 1개만 이용하겠다는 뜻. 변경하거나 추가하지 못하게
    
	static IMM getInstance() {
		return instance; //new MMImpl의 객체를 하나만 쓰겠다
	}

~~~

- Size라는 배열의 개수를 세는게 있으니, 이를 새로운 배열을 만들때 활용하면 공간 절약
- 클래스를 관리하는 매니처 클래스, main 안에서 객체를 add하는데
  - 그냥 객체의 특성을 setter를 통해 변경
  - 과연 print하면 변해있을까?
    - 변한다! 왜냐하면 결국 주소만 찾고있잖아!

## 다형성

- overiding을 한마디로 ? '재정의'
- 조건 : 부모클래스에 정의, 접근제한 작아질 수 없다.. etc

- Override : 부모쪽에 있는지 없는지 확인!

~~~java
KChef k = (KChef) chefs[0];
(KChef)chef[0].posi = "해삼" // 접근 불가, 연산자 우선순위 때문에 .이 먼저
((KChef)chef[0]).posi = "멍개"  ->가능
    
syso(k.posi); // 멍개가 나온다
~~~

- 새로운 객체를 만드는 것 : new!
- new가 없으면, 클래스 내 객체의 접근할 때 주소로만 접근!
- 항상 메모리를 떠올려라!!!!

## 추상클래스

- 그런데, 부모 클래스에서 method 하나 지워
  - 그럼 자식 클래스 : if instanceof로 다 경우의 수로 받아야해
  - 특정 메서드는 자손 클래스에서 반드시 재정의!!
    - 조상의 구현이 무의미
  - 메서드의 선엄부만 남겨, 구현부는 ;로 대체
- 그래서 나온게 추상 클래스야

---

### 특징

- 상속 전용, 객체 생성 불가, 자식을 참조는 가능!
- 만약 추상클래스 상속, 재정의 x? => 또 abstract로 하던가
- 강제적으로 만들어! -> 

---

## 인터페이스

- **완벽한 추상화된 객체** : 모든 메서드가 abstract
- 설계도

---

ko.wikipedia 인터페이스

- 서로 다른 두 개의 시스템, 정보나 신호를 주고받는 경우의 접점이나 경계면이다.

- 사용자가 기계가 쉽를 동작시키는데 도움을 주는 시스템

- 컴퓨팅에서 컴퓨터 시스템끼리 정보를 교환하는 공유 경계

---

### 특징s

- 인터페이스 : 그냥 public
  - 왜냐하면, 받아 써야하니까
  - private 쓰고싶으면 구현한 클래스에서 쓰렴

**인터페이스와 클래스 이름이 같으면, 패키지명 잘 보렴**

- 인터페이스 다형성 적용
- IChef -> Interface 

---

## 예외처리

- 예외 발생 시 프로그램의 비 정상 종료를 막고, 정상 실행 상태를 유지하는 것
- 예외의 감지 / 예외 발생 시 => 동작할 코드를 작성!!

- 컴파일 : JVM에 있는 컴파일러 -> .class

  - Checked exception , Error : 빨간줄로 알려줌


  - Unchecked exception : 눈에 안 보여.

---

### 목표

---

#### **예외처리 문법 숙지 -> 예외 핸들링**

#### **사용자 정의 예외 이용 -> 특정 상황 전달**

---

### 직접 처리 try - catch - finally

~~~java
// try - catch
try{
    오류날거같은거
}catch(Exception e) {
    syso("할 말 ")
}catch( ){
    
}finally{
    syso("언제나 실행")
}

~~~

- 다중 catch
  - JVM이 던진 예외(catch!) 다형성 적용
  - 상속관계인 경우 자식클래스부터 실행.
  - 위에서 catch 발생 -> 아래 catch 실행 X
- 작성 tip
  - 클래스의 상하관계를 파악하고 작성하는게 좋다~
- finally
  - 예외 발생 여부와 관께 없이 언제나 실행
  - return을 만나도, finally 먼저 수행 후 return 실행!!
- return : 그냥 프로그램 자체를 끝내버림
  - main method 자체가 끝나 .. 

---

### 간접 처리 throws

- **예외를 호출한 곳으로 전달**(처리 위힘)
- 예외를 처리하지 않고 단순히 전달돼
  - 나는 try-catch 안 해, 날 호출한 곳에서 해~

- 예외를 전달받은 메서드는 다시 예외 처리 책임 발생

---

#### 예외처리

1. 내가 직접 처리하거나 - throw - catch
2. 던지던가. - 나를 불렀던 곳으로 예외 던져

왜?  -> 모아서 한 번에 처리하고 싶을 때 

- runtimeException은 throws 하지 않아도 전달되지만
- 결국 try-catch로 처리

---

### 메서드 재정의와 throws

- 매서드 재정의 시 조상클래스 메서드가 던지는 예외보다 부모 예외는 던질 수 없음

---

### 사용자 정의 예외

---

#### 장점

- **상황을 전달하기 위해서 사용한다**

- 객체 활용 : 필요한 추가정보, 기능 활용 
- 코드 재사용 : 비슷한 상황에서 예외 객체 재사용!
- throw 매커니즘 이용 : 중간단계 return 필요 X

### 에러 보는 법(로그 분석)

에러 -> 밑에서부터 올라가면서, 가장 위에있는 내가 짠 코드를 찾아서 문제를 해결

# 22/01/26

### 복습

#### 패키지 임포트

- 우클릭 - 임포트 -> General - Existing Project into WorkSpace -> Browse -> 해당 **프로젝트** 찾아서 Finish

#### 복구

- 프로젝트 -> Restore From Local 뭐시기 -> 살아날 가능성 있음

#### 디자인 패턴

- 특정 기능을 수행하는 가장 이상적인 객체 설계 방법들
  - 중 싱글턴 패턴이 있다.
    - 1. 나의 타입의 변수(그 객체)를 스태틱으로
      2. 생성자를 private -> 외부 생성 불가
      3. 1에 대한 getter를 작성(static)

---

여기서부턴 이용법과 활용

## Generic : 제네릭

### 정의

~~~Java
Class_Name<String> generic = new Class_Name<String>();
~~~

- 다양한 타입의 객체를 다루는 메서드
  - 컬렉션 클래스에서 컴파일시 타입 체크
- 타입에 대해 비워놨다가 객체를 생성할 떄 타입을 결정

- <>를 이용해.
  - T안에 extends 뭐시기로 해서, 상속받은것만 쓸 수도(사용 자주 x)
  - int(... a) : a[]인데, 가변길이배열
  - <>안에 들어올 수 있는건 객체, int X, wrapper class인 Integer. 

---

### 예시

- 클래스(노말박스)에서, 하위 클래스를 쓰고 싶은데
- 하위 클래스 박스들을 만들어서 거기에서 그냥 바로 꺼내서 쓰고싶어
  - 그럼 클래스 토이박스, 클래스 푸드박스를 다 만들어?
  - 꺼낼 때 인스턴스오브로 확인해서 다 해야해?

#### cf) 와일드카드

- 규칙이 있는데, 거기에서 벗어난 친구들
- GenericType 객체를 할당 받을 떄 와일드 카드처럼 이용 가능. <?> -> 제한 X

## Collection Framework( java.util)

### 정의

- 자바에서 구현해놓은 자료구조 모음(패키지?)
- 객체들을 한곳에 모아 놓고 편리하게 사용할 수 있는 환경 제공
  - 1. 어떤 특성을 가진 자료구조인지
    2. 어떻게 활용할건데?

---

### List interface

- 순서가 있는 데이터의 집합, 데이터 중복 허락(ArrayList, LinkedList)
  - 순서가 있어 -> 정렬 가능

----

#### ArrayList 

매번 만들어, 없으면 없는거 복사해서 새로 또 배열 만들어..

~~~ java
List<String> name = new ArrayList<>(); // => . 하면, List참조, ArrayList에있는거쓰여
									   //   overriding때문에
ArrayList<String> name2 = new ArrayList<>(); // . 하면, ArrayList methods                                            

ArrayList<String> list = new ArrayList<>(); 
list.add("");
~~~

---

#### LinkedList

주소기억, 

- 추가/삭제에 유리(vs ArrayList)
- 만약 for문을 돌면서 조건에 맞으면 지운다?
  - 거꾸로 돌면 깔끔하게 지나갈 수 있고
  - **아니면 list의 index만 따로 기억해서, 한 번에 지우는 것!**

#### 괄호의 유무
- nums.length; => Array                       괄호 X -> 멤버변수
- name.size(); 의 차이!!! => ArrayList   괄호(O) -> 메소드

---

### Set interface

### 순서 X, 중복 허락 X

- 데이터 자체 : key

---

#### HashSet

- Hash : 같은 input -> 같은 곳으로 들어가 ( SHA-256, SHA 512 etc)
  - input값이 같으면 같은 곳으로 받는거!
  - 원본 파일과 다운로드 파일이 같은지 확인하는 방법?(1GB)
  - 1024 * 1024 * 1024 * 8 : 한칸한칸 다 비교하는게 equals
    - 그냥 Hash가 서로 같은지만 보더라도 높은 확률로 같다~( 2^256, 2^512 로 hash 넣어)
    - 다르다는건 확신할 수 있음.
- HashSet : 우선 Hash로 거리고 그다음 equals 함(다른거 빠르게 확인 가능)
  - HashSet에 여러 원소를 넣기 위해선 new Integer(1)이런느낌
  - 같다는걸 확인하기 위해서 hashcode로 포함 => 사실 그냥 hashset 쓸 때만!
    - object equals는 주소가 같은지만 확인하기 때문! 
    - Object의 hashCode는 주소값.

---

### Map interface( - dictionary?)

- key에 바구니를 매닮, key로 데이터를 구분, key만 있으면 Set와 같다
- key는 중복 불가(unique)

~~~java
Map<String, String> map = new HashMap<>();
map.put("H", "123"); // 이런식으로~~
map.get(key값) // value로
~~~

- List가 index로 식별 -> map은 set으로

---

### Comparable Interface (나와 다른것)

- equals. (this(나)와 매개변수로운 객체를 비교)
- compareTo : 내가먼저면 -1 같으면 0 , 뒤면 +1

~~~java
// 	Comparable을 구현해서 compareTo를 만들면
Collections.sort(list) // 정렬이 가능해져
~~~

---

### Comparator (2개 입력, 비교)





## 입출력 API

### I/O와 스트림

- 데이터는 한쪽에서 주고 한 쪽에서 받는 구조
  - 입력과 출력의 끝단 : Node
  - 두 노드를 ㅇ녀결하고 데이트를 전송할 수 있는 개념 : Stream
  - 스트림 : 단방향 통신, 하나의 스트림으로 입출력 동시 불가

- 입출력 담당 최상위 클래스들

|      | byte         | Char   |
| ---- | ------------ | ------ |
| 입력 | InputStream  | Reader |
| 출력 | OutputStream | Writer |

#### InputStream의 주요 메서드

- read()
  - public abstract int read() throws IOException
    - byte 하나 읽어 int로( 읽을거 없으면 -1)
  - public int read(byte[] b) throws IO;
    - 데이터를 읽어  byte[]바가지를 채워.(개수도 알려줌)
    -  읽을거 없으면 0
- write()
  - public abstract void write(int b) throws IOException
  - public void write(byte[] b) throws IOException
    - 마지막에 바이트단위로만 읽으면, 바가지가 커서 쓰레기데이터 생성
  - public void write(byte[] b, int  off, int length) throws IOException
    - read(byte[] b ) 한 값을 length에 넣음 (필요한 byte의 개수)

### 보조 스트림

- bytestream을 char스트림으로 변환
  - InputStreamReader
  - OutputStreamWriter
- 버퍼링을 통한 속도 향상
  - buffer : 큰 바가지(바이트가 큼 : 엔터가 들어올 때 까지 한 줄을 읽음.)
  - BufferedInputStream / BufferedReader
  - BufferedOutputStream / BufferedWriter
- Scanner vs BufferedReader (둘중에 하나만 될 때가 있기도 함)

#### 객체직렬화

- 자료형이 다른 변수형을 1열로 줄세움
- 1열로 세워진 변수형들을 다시 세우는걸(클래스) : 역직렬화
- Serializble (추상 메서든데 진짜 아무것도 없는 껍데기, 그냥 표시하는거)



- 객체나 있거나 쓰려면 Serialized를 implements를 해야만 파일에 써짐

- using ObjectInputStream; ObjectOutputStream

  

보통: new new new new (메모리상 중구난방~~)

=> 연속적으로 만들어 보내주기 위해 직렬화함!



#### cf) 상대경로 절대경로

- 상대경로 : 현재 위치로부터의 경로
- 절대경로 : 루트로부터의 경로



# 요약

Generic이란?

ArrayList vs LinkedList

List Set Map이란?

Set이 해쉬코드를 사용하므로, equals만으로 안되고 hashCode 필요



입출력이란?

File복사(xor암호화)

보조스트림이란?

BufferedReader + InputStreamReader 문자열로 효율적으로 읽기

Serilizable을 implements해야 객체 직렬화가 가능

ObjectOutputStream의 writeObjcet, Ok inputstream readObjeect(형변환 필요)

# 22/01/27

- 꼭 명세서대로 하지말고, 배운거 다 써봐!

## Collection Framework

##### cf) hash

- hashtable : 내용을 챱챱 적음 (인덱스가 있음)

  값을 해쉬값으로 => hashtable 인댁스의 변환된 해쉬값으로 넣기

- 만약 같은인덱스로 -> 그 안에서 또 해쉬를 넣기 ; 이것저것 할 수 있다
  - 암호화로많이써..
  - 값 -> 해쉬값(1방향함수,) SHA256 => hash암호 => DB에 저장
  - 비밀번호는 모르나, hash값을 돌린 결과를 갖고 있음.
    - 그래서 비번 변경 -> 인증 -> 새로 비밀번호 설정(모르니까)
    - (해커)레인보우테이블 -> SHA256만들어놓음
      - 그렇지만 사이트는 salt, 비번 뒤에 (임의 문자들)을 저장해서 hash로!!

---

### Set

- 정렬 못함 => 별도의 기준이 필요함

~~~java
import java.util.Set;
import java.util.HashSet;

Set<T> set = new HashSet<>(); // generic이 들어간다

Person a = new Person("해삼");
Person b = new Person("멍개");
Person c = new Person("해삼");
//add
for(Person p : pset){
    syso(p);
}
// 하면 3줄이 나와
// new라고 만들면 주소를 새로 찍어내서..

// equals해도 안 돼, == 해도 다르대

// equals Overridng

public boolean equals(Object obj){
	if(obj != null && obj instancof Person){
        Person p = (Person)obj;
        if(this.name.equals(p.name) && this.age == p.age)
            return true;
    }
    return false;
}

// 이렇게 설정해줘도 pset에는 3개의 데이터가 들어감, 그래서 해쉬코드 재정의

public int hashcode(){
    return this.name.hashcode() + this.age; // 이런 방식으로 해쉬코드!
}
// 이거 source에서 generate equals and hashcode 있어
~~~

- 자식은 부모보다 표현을 작게할 수 없다.(public을 overrinding = 자식도 public)

---

### Map

~~~java
Map<T,T> map = new HashMap<>();
~~~

### ListSort

~~~java
List<Person> plist = new ArrayList<>();

plist.add(new("aa", 26));
plist.add(new("bb", 15));
plist.add(new("cc", 90));
plist.add(new("dd", 20));

// 입력순대로 나온다.  
for(Person p : plist){
    syso(p)   
}

// 이름순정렬?  ==> 기준이 매개변수로 들어간단다, 객체가 들어가면 너가 정해줘!
Collections.sort(plist);
for(Person p : plist){
    syso(p)   
}
// 나이순 정렬 : Comparator
Collections.sort(plist, new AgeComparator());
for(Person p : plist){
    syso(p)   
}

// 이제.. 기준 2개 짬뽕
Collections.sort(plist, new Comparator<Person>(){
 	@Ovverride
    public int compare(Person o1, Person o2){
		if (o1.age == o2.age){ // 같을 때 정렬 또 해줘
            return o1.name.compareTo(o2.name);
        }
        return Integer.compare(o1.age, o2.age)
    }
}
~~~

~~~java
public class Person implements Comparable<Person>;
 //하고 Override
@Override
public int compareTo(Person o){
    return this.name.compareTo(o.name);
}
// 내림차순
public int compareTo(Person o){
    return -this.name.compareTo(o.name);
}
~~~

#### AgeComparator : 인자가 2개

~~~java
package collection;

public class AgeComparator implements Comparator<Person>{
    
    @Override
    public int compare(Person o1, Person o2){
        //return o1.age - o2.age : 양수일 떄 자리가 바뀜
        // o2가 더 크면, 가만히 있음.	
        return Integer.compare(o1.age, o2.age)
    }
}
~~~

## I/O와 스트림

- 노드 : 키보드, 모니터, 메모리, 파일, DB, 네트워크(양끝단)

#### try-with-resources

- try (   (())   ) : 괄호 하나 더 있는거
- 자원 반납을 위해,, finally를 써서 close()를 해야하는데, 그러지 않아
- try안에다가 괄호 안에 InputStream input 받고  read함
  - 알아서 할당된 자원을 반납해

cf) inputStream -> Unicode 문제 생길 수 있음~

#### File 

- 가장 기본적인 입출력 장치중 하나, 파일과 디렉터리 다루는 클래스

#### 결정

노드가 무엇 -> 타입은 문자(R/W)? 바이트(I/O) ? -> 방향은 ? -> 추가 기능(보조)?



**ObjectInputStream - File 활용해서 실습해보기!!**

# 22/01/28 프로젝트

- 추가학습목표

  - 아 네트워크도 입출력이겠지!

  - inputstream같은 비슷한게 있겠지
  - 배웠던 개념을 토대로 학습하면(비슷한 느낌을 받아야함)

​	

## JSON 

### 개요

- 자바스크립트 오브젝트 노테이션(JS토대 개발, JS객체와 매우 유사함)
- 그냥 텍스트, 어떤 프로그래밍 언어에서도 사용 가능
- (서로 다른,이기종간) 웹클라이언트와 웹서버 간 데이터 교환에 이용

- 웹브라우저 비동기 처리에 사용되는 AJAX 데이터 교환 형식
  - Asynchronous Javascript and XML(데이터 교환 형식) 
    - XML(이전 데이터 교환 형식) => JSON으로 바뀌고이썽 
  - 주가데이터, 페이지 + 데이털를 주고받었는데
  - 데이터만 받아와서 수정 => 점점 이렇게 변해짐
  - 싱글페이지 어플리케이션을 만들기까지..(필요한 데이터만 받아서 해)

### 장점

- 주로 프런트엔드 프레임워크
- 공식포멧 => 개발자 사이에 데이터 통신가능
- 텍스트 => 읽고 쓰기 쉬윔
- XML에 비해 용량이 적고 이해하기 쉽고
- 언어와 플렛폼에 독립적 **

---

### 구조

{"key" : value , ... }

- key는 쌍따로 묶어
- Value는 String일 경우만 쌍따
  - Value(자료형) : object, array, number ,string, true, false, null ... 

---

#### Object

- 시작 Object {      String(Key) : Value ... , (key:value), or   }object종료

---

#### Array

- array [ val , val , or ]

- ["kk", "tt", "pp"]

- json array에서는 여러 자료형 담을 수 있지만, 자바에서 불러온다면? ㅎㄷㄷ

---

cf)  JS에서는 let 으로 변수 선언

​		 a = (아무거나, num, String, function() 등)

---

### 클래스 객체 JSON 변환

~~~java
class Example{
    String name;
    Address addr;
    ArrayList<String> list;
    int age;// 어레이리스트, 또다른 Object속성 와도 ok
} // 여러가지 들어갈 수 있음
~~~

== > 실제 프로그램을 이용해서 자바의 객체를 JSON, JSON을 Java 객체

### GSON

- 구글 Gson, Java객체를 JSON표현 변환
- 상호 변환도 가능 (toJson, fromJson)
- 라이브러리를 다운받고 프로젝트에 인식시켜야함

java 소스코드 .java =컴파일> 바이트코드.class

#### 라이브러리 인식

JRE SystemLibrary : 열면 .jar 파일들 엄청많음 => .class 모아놓은게 .jar

- 방법 1: JRE System Library에 끼워넣기. ( 비추천 ), JDK 폴더에 Lib에 넣어
  - 그럼 모든 프로젝트들이 GSON 라이브러리 인식
- 방법 2: 외부에 존재하는 jar파일을 인식시켜주기
  - 프로젝트 우클릭 - Profe  Propertiess add extenal jobs - gson - apply
  - 프로젝트가 다른 환경으로 이사가면 인식 X
- 방법 3(추천) : 프로젝트 내부에 jar파일 인식 / 복사
  - 프로젝트 우클릭 - new - folder(이름 lib) - 복붙 (이제 인식까지 해야함)
  - .jar파일 ctrl + c -> lib 누른 상태에서 ctrl+v
  - 프로젝트 우클릭 - Properties - Java Build Path 클릭 (좌측)- Libraries - addJars(우클릭) - lib - 폴더 들어가 Gson.jar 선택/
  - 프로젝트가 통째로 이사가도 no Problem
- 방법 4(강추) : 추후에.. => 라이브러리 관리 툴을 이용한다..!(MAVEN)
  - 나중에 jar 70몇개.. 어떤 jar는 다른 jar에 종속적
  - 근데 어떤게 문제 생겨 -> 다른거 다 바꿔야해
  - Maven 라이브러리 빌드관리 툴으로 버전 명시
  - 알아서 다 바뀜

Gson 클래스를 이용해서 사용 방법을 알아보자

#### GSON 사용법

Gson gson = new Gson();

String result = gson.toJson(객체 m)

- Map -> JSON 문자열



Test가 필요한 경우가 있어, 그럴 때 새로운 패키지 만들어서(.test 추가) 활용

## MVC 구조 이해, 프로그램에 적용

- Model <=> Controller <=> view ( 다 해줭)
- 프론트, 백앤드 별도 구성요소
- 서로 간섭 X
- 여러명의 개발자가 동시에



### M 

- 동작을 수행(Back)
- 사용자 View 어떻게 보일지 신경 X

### V

- 사용자 화면에 보이는 부분, 정보를 받아와 사용자에게 보여줌(Front)

### C ( 우리가 한 ...Manager 비슷함)

- 연결~



## Cf)

### DAO(Data Access Object)

- database의 data에 access하는 트랜젝션 **객체**
- 큰 클래스 위에, 이를 다루는 Dao패키지를 만들곤 함



# 22/01/29

### Gson TypeToken : Generic을 사용한 사용자 정의 형식을 JSON으로 저장

~~~java
// 사용법
TypeToken<List<String>> list = new TypeToken<List<String>>() {};
// Json file -> to ArrayList
// Stringbuilder에, 
// br.readline() != null 일 떄 까지
// st.append(str).append(\n)
// st.toString(); : 스트링으로 만들어야지
 gson.fromJson(jsonStr, new TypeToken<ArrayList<UserInfo>>(){}.getType())
     // TypeToken<ArrayList<UserInfo>>(){} : 익명 클래스(1회 활용) -> getType()을 통해 타입을 정의
~~~

- Gson 안에 정의된 TyptToken class, 자바의 런타임에서 제네릭을 인식할 수 없어
  그래서 Gson안에있는 TyptToken<사용자정의자료> 해서 익명 클래스로 만들어서 사용한다.
- 익명 클래스(1회 사용 클래스)
  - new class(){} -> 1회 사용 끝



- 근데 HashMap은 안 된다. Gson에서 ..정의를 하지 않았다..



# 22/01/30

- 대휴식





