# 2022.01.12

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

# 2022.01.13

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

+ 라벨링 하는 이유(반복문) -> 만약에 여러개를(2,3차원 배열) 동시에 하는 경우 ..!!  : 생각보다 자주 쓴다

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

# 2022.01.14

---

- eclipse : ctrl + space 로 자동완성 -=> import까지 다 해줌... 신기신기

- ctrl + shfit + o : 알아서 import

~~~Java
import java.util.List;
<List>Webelements news = ... // : 이 또한 자료형이다..
~~~

# 2022.01.16 

- dl이미 알고있는 객체에 .찍으면 메서드들 나오잖아, 그걸 해주는게 Boxing