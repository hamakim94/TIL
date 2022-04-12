# 22/01/25

https://www.acmicpc.net/problem/2884

- 24시간 기준으로 n분 전 : 시간, 분 나눌 떄 가장 빠르게 나눌 수 있는 기준 찾기 위해 노력
- 꼭 반대의 경우도 생각하자.

# 22/01/26

- while문에서 입력값이 없을 때
  - try-catch를 이용하면 예외상황 처리 가능

자바로 하려니 자료형 바꿔주는거 지옥이네

# 22/01/31

## 백준 15552 빠른 A+B

- br.close(), wr.close()는 마지막 한 번에, for문 안에 들어가면 계속 비워서 느려짐

## 백준 2577  숫자의 개수

-  (String.charAt(int) -'0')
  - CharAt을 하면 : String 배열에 있는 index 요소를 char형태로 되돌려준다
  - 결과 -'0' 해야 그 요소를 int로 받을 수 있다.

---

## StringTokenizer while문 사용법

~~~java
while (tokenizer.hasMoreTokens()){                     // 남은 토큰이 있다면
            tokenizer.nextToken()); // nextToken, 이거 필수다..
        }
~~~

---

## Java 데이터 타입 알아내는 법

~~~java
getClass().getSimpleName();

// ex)
String myname = "hamakim";
syso(myname.getClass().getSimpleName());
~~~

---

## Java HashMap Key 값 따라 value 변경법

~~~java
// value는 int라고 가정
hashmap.put(w, hashmap.get(w) +1);
~~~

---

## ArrayList 값 변경

~~~java
ArrayList.set(index, new_value);
~~~

## 문자열 데이터 비교

#### equals... 제기랄.. 

---

## 알파벳 활용법(char)

~~~java
// 만약 알파벳을 활용해 인덱스를 0으로 만들고 싶을 때(only 소문자)
 abc
arr[ inputString.charAt(i) - 'a'] // 0번쨰 index로 가짐
~~~

#### Int이하의 변수 타입을 사용하는 경우, 연산 시 int로 자동변환

cf) 아스키 코드

- 알파벳 개수 26개

  - 소문자 a = 97~122 
  - 대문자 A 65~90 
- 숫자 0 ~ 9 : 48 ~ 57

# 22/02/02

- DP - 일단 점화식이라고 생각하자! 그래야 빨라!
- 컴퓨터는 내 생각보다 빠름 -> 노가다 시킬 조건을 먼저 찾자

- 자존심 X, 모르면 답지 클론코딩..



# 22/02/05

## 브루트 포스 

 그냥 하나하나 다 대입해버리는거!!

## 제한조건 잘 보기

제한조건으로 갑자기 확 할 수도 있긴하네

## 반복문 돌 때

변수 미리 지정해줘(매우중요) -> 반복문 안에서 돌게하지마

그리고 string에 요소 접근할때 charAt 쓰면 엄청 편하다



# 22/02/13

## StringBuilder 활용

매번 출력하는거보다, stringbuilder에 하나씩 append하고

출력하는게 훨씬 빠르다(정렬에서, 카운팅 정렬했는데도 느려짐)



# 22/02/15

### 백만장자 프로젝트

- 각 구간별 최댓값을 찾거나 하는 문제 : 거꾸로 생각하면, 해결되는 경우가 많다.
- O(n^2) : 최대한 자제해야함.. 입력값을 보고 잘 판단해야해

# 22/04/02

### HashMap contains, Arraylis contains

- ArrayList의 contains는 indexOf를 사용하기 때문에 O(n)이고
- HashSet(map)의 contains 는 HashMap기반이고, O(1)이라고 한다

---

### Collections.sort(ans);

- 자동으로 오름차순(사전순)으로 정렬, 기본값 String정렬
- 만약 클래스에서 하려면 CompareTo나 Comparable 재정의(클래스 내부에서 )

# 22/04/04

### [], 배열 활용하기

~~~ java
List<Integer>[] list = new ArrayList[N+1];
for(int i=0; i<list.length; i++){
    list[i] = new ArrayList<>();
}
~~~

- []는 단순한 배열,  앞에 있는 건 담아놓을 자료형!
- List<>라는 인터페이스로 자료형을 설정하면, 각 배열속에 들어가 인스턴스해야함!!

# 22/04/06

### 백트래킹 잘 안 될 때

- 반대로 생각, bottom-top을 사용해..

# 22/04/07

### 재귀 (배열활용)

- 너무 어렵게 생각 하지 말기
- 한 번에 생각하지 말고, 나누고 싶은 케이스 별로 인덱스 어떻게 이동하는지, 해당 값을 어떻게 들고 다닐지만 생각. 
- 케이스가 나뉜다 -> 재귀, idx를 통해 어떻게 표현할래?

### 

### 꼭, 퍼뮤테이션 돌아야하나? 해당 단계에서 어떻게 가지가 뻗는지.

- 배열값 복사하고, 되돌릴 땐,  함부로 하면 안 됨
- 다시 되돌아가려면 새로운 배열을 만들어서 값을 복사하고 ,나중에 다시 넣어줘야함!!



# 22/04/12

### 소숫점 관련...(double)

계산을 최대한 미뤄, 그리고 가장 마지막에 소수 곱하고 결과 출력해

