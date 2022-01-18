# TIL(Today I Learned)

## 2022.01.12

해야할 것들 

​	 Java => HTML, CSS => ASP(IM) => DB(mySQL, MariaDB) => ASP(A) => Spring => Vue.js)

***

전자정부 표준프레임워크 ( Typora, Java, Eclipse : 다 download - old version - 검색해서 다운)

- Java Version : 8 (1.8(?) **VIA Zulu**, jdk-8u311-windows-x64))
- Eclipse Version : 2018-09

---

다운로드 후 설정

- 내 PC -> 속성 -> 고급 시스템 설정 -> 환경 변수
- 새로 만들기 -> JAVA_HOME : C:\위치\Zulu\zulu-8
  - 시스템 변수 Path 설정 : 기존 -> %JAVA_HOME%\bin\ 
    - %JAVA_HOME% 은 만들었던 시스템 변수 JAVA_HOME의 경로를 따온 것
    - 나중 다른 버전 사용 시 JAVA_HOME 시스템 변수의 경로만 바꾸면 돼

- Eclipse 설치 후 : Workbench 지정하라 나오는데 그냥 임의의 폴더 만들어서 하면 자동 생성
- 강사님은 Dropbox 폴더 자체를 WorkBench로 지정하여 알아서 저장 될 듯 (신기)

---

+ Vue.js, Spring, Java 등등, 홈페이지 기본 document를 많이 봐서 이해하는걸 연습하자..

---

자바 단축키

- ctrl + shift + f : 공백 {} 맞춰줌!



## 2022.01.13

- Eclipse Default Encoding 바꾸는 법

​		eclipse 설치 폴더 -> eclipse.ini(우클릭 - 메모장) ->"-Dfile.encoding=UTF-8"

---

- 조건문에서 {}
  - 코드 블럭의 내용이 한 줄이라면 중괄호 생략 가능

---

- switch - case 문

~~~ java
switch (N) {
    case 1:   // 만약 이 코드가 참이면
        sysout();//실행
    case 2:
        ...;//실행
    default:
        ...//실행, 즉 case, defaut 아래에 있는 실행문 전부 실행, 그래서 break사용
}
~~~

---

- APS 중 필요한 기능(switch - case 필요한 때 대충 느낌)

기능 1 : 내 아래만 검사        (case 맨아래)

기능 2 : 기능 1 + 좌.우 검사 ( case 중간)

기능 3: 기능 2 : +기능 상 검사 (case 맨 위)     => 하면 원하는 기능 수행 가능!(switch-case 사용)

---

++ APS 중 ++

- 다른 사람 코드 적어도 3개 이상 열어볼것.

---

- **continue** : 코드 맨 아래에 넣지 마(애초에 필요 없잖아...)

---

+ 라벨링 하는 이유(반복문) -> 만약에 여러개를(2,3차원 배열) 동시에 하는 경우 ..!!

~~~ java
outer: for (int i = 2; i < 10; i++) {         //바깥 for문을 outer로 정의!
			for (int j = 1; j < 10; j++) {
				if (i > 5)
					break outer;
				System.out.println(i + " * " + j + " = " + i * j);
			}
		}
		System.out.println();
~~~

---

https://www.w3schools.com/html/ => HTML, CSS 배우는 곳

https://developer.mozilla.org/ko/ => Front-End => 제일 많이 봐야하는 곳

ex) google : HTML 궁금한거( input ) mdn

https://ko.javascript.info/ => 나중에 자바스크립트를 혼자 하고싶을 떄(무료)

---

- HTML 기본 만들기(뼈대)
  - ! + tab

---

- git 초기설정

  

~~~bash
git config --global user.name "MINGYUN KIM"
git config --global user.email "mingyun0324@gmail.com"

확인

git config --global -1

git init -> 시작.
~~~

## 2022.01.14

---

- eclipse : ctrl + space 로 자동완성 -=> import까지 다 해줌... 신기신기

- ctrl + shfit + o : 알아서 import

~~~Java
import java.util.List;
<List>Webelements news = ... // : 이 또한 자료형이다..
~~~



## 2022.01.16 

- dl이미 알고있는 객체에 .찍으면 메서드들 나오잖아, 그걸 해주는게 Boxing



## 2022.01.17

- 컴퓨터 기초
  - x86 : 옛날에 컴퓨터(인텔)은 cpu명이 286 386 .. 등으로 나왔따
  - 팬티엄 2? 부터 32bit(4byte)를 기본, 애초에 ip도 4바이트
  - 그래서 x86 ~ 써있으면 대충 32bit, 나중에 x64

- 1KB => 1024Byte

- 1 MB => 1024KB

- 1 GB => 1024MB  

  - 따라서 램 4Gb => 4,294,967,296 바이트  == 2^32, 즉 32비트 체제의 한계는 렘 4기가
  - *** 주소는 1씩 증가할때마다 1byte, 데이터는 1씩 증가할때마다 1bit 증가***

  

- 잡지식
  - 1G : 아날로그 통화
  - 2G : 문자
  - 3G : 영상통화
  - 4G : IP통신, ALL IP(통화하고 바로끄면 기록이 안 남는데, IP로 지정되면 남아.)
- 키보드
  - 보통 키보드가 7비트(128개 정도 써,) => 그래서 ASCII코드가 나온 것



- String 자료형은 특이하다. 분명 참조형인데 syso가 가능하다...

---

- Scanner

~~~java
// 입력을 받기 위해 입력을 도와줄 객체가 필요
		// ctrl + space + o : import
		Scanner sc = new Scanner(System.in); 
		
		// bool
		boolean flag = sc.nextBoolean();
		// 문자 하나만 불가, 
		// char a = sc.nextChar()????
		
		// 정수형 입력
		byte bnum = sc.nextByte();
		short num = sc.nextShort();
		int age = sc.nextInt();
		long money = sc.nextLong();
		
		// 실수형 입력
		float fnum = sc.nextFloat();
		double dnum = sc.nextDouble();
		
		// 문자열 종류 파악하기
		String name = sc.next();
		
		//문자 하나만을 입력받고싶으면
		char c = sc.next().charAt(0);
		
		System.out.println();
~~~

---

- Java에서 / 기호는 몫이다.
- 그래서 1의 자리수 내림을 한다면, 

~~~java
int a = 27;
age = a / 10 * 10(20대);
age = a - (a % 10)
~~~

- 반올림 쉽게 하려면, 5를 더한 후 내림을 한다(원하는 자릿수)

---

- do - while 문:
  - 조건문에서 쓰이는 변수가 반복문 안에서 결정될때?(여러번 인풋 받고싶어!)

---

- class 이름 바꾸기 
  - 우클릭 - refactor - rename, 나중에 모든걸 다 한번에 바꿀 수 도 있음....

---

- codeup.kr 코드업 기초100제! (C언어 들어가서 JAVA로!)

---

- 3항 연산자(자주 쓴다네!)

~~~java
String message = (sth == 1) ? "해삼" : "멍개";
//반환 type = (조건) ? 참일때 return : 거짓일 때 return;
~~~

---

## 2022.01.18

- APS 만들어야 할 습관
  - 문제 제대로 읽어 이해하기 
  - (필기구로 끄적끄적) 해야할 일 정리
  - IDE에서 주석 넣으며 정리한 일들 쓰며 할 일 정해서 해보기.

- for문의 종류 : (자료형 변수명 : 반복할 수 있는 것) = (for each 문이라고도 불린다)
  - 이건 값을 수정할 수 없는 단점이 있다ㅣ

---

- 단축 평가
  - 논리합 || 
    - a || b , a가 참이면 b 볼 필요 없다
  - 논리곱 &&
    - a && b , a가 거짓이면 b 볼 필요 없다

- 비트연산자 &, | => 컴퓨터니까 그냥 가능해버림!

---

- 블록 안에서 { int a = 0 ;  명령문} 하면 a는 } 만나면 못 쓰지만, 메모리에는 Garbage Collecter 가 돌아야 사라짐

---

- switch case : break문 없으면, 해당 case 밑에 모든 명령문들 다 실행돼(default 포함!)



codeup : 1166 1172 / 1257 1259 1271  1274  1278 / 1353 1354 1355 1380

import 까지 있어야하고

class 이름은 Main

