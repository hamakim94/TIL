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

# 22/04/15

### 재귀 쓸 때, 중간중간 배열 저장하는 경우

- #### 얕은 복사, 깊은 복사 - 메서드 따로 만들어놔

# 22/04/26

- DP(점화식, bottom - top)
  - 초기 조건들을 활용해서 다음 조건 무 조 건 생각하기.

# 22/05/30 APS 정수

#### 1. 바르게 읽기

- 어려운 문제가 안 풀린다 -> 쉬운걸 많이 풀어봐야, 요구하는 바를 이해해야한다.

#### 2. 제대로 이해하기

- 내가 이해한 말로 바꾸기(최솟값 찾는 문제구나.. 뭐 이런느낌)

#### 3. 무엇이든 코딩하기 

- 내가 아는 걸로 최대한 해보기!!

#### 4. 손으로 눈으로 마음으로 디버깅하기

- IDE를 사용한 디버깅은 초보!
- 직접 로그를 찍기~
- 원시적일수록 고급! 불멍이라고 생각하고 그냥 하나씩 해보기~

---

### 문제내기

- 지문/그림
- 입력/출력/예제 설명
- 입력 생성 프로그램
- 샘플/평가용 데이터(10/50)
- 결과 생성 프로그램(풀이 코드)
- 문제 풀이 및 해설
  -  ㅇㅇ 1244. 최대 상금



# 22.06.03

### 내약점 

#### 1. 소수, 소수 출력

#### 2. 가지치기

#### 3. 값을 들고다니는 재귀.

# 22.06.04

## 실수

### 1. for문 안에 제한조건 : que.size()를 저장하고 조건에 넣기
- que.size()를 넣으면 길이가 poll 할 때마다 변하므로 원하는 결과가 안 나와
### 2. 굳이 ArrayList.sort(new comparater) 안 해도 돼
- 그냥 for문 2번 돌려서, 가장 작은 값 찾고, 그 중에서 최소값 구하는 공식 또 구하면 돼

---

# 22.06.23

## BFS 실수

- 시작과 끝 점이 같은 경우... 무적권 edge case에 대한 생각(2시간 out)

---

# 22.08.31

### Strings.replace( str1, str2)

~~~ java
String str = "abccccddabcdf";
System.out.println(str.replace("abc", "z")); //zcccddzdf
~~~

문자열에서 매칭되면, 바꿔주는 함수

만약 특정 문자열을 숫자로 바꿔야 한다면..

~~~ java
String[] nums = {"zero", "one", ..., "nine"} // 0부터 9까지 매칭
string input = "one3threezero";
for(int i=0; i<10; i++){
    input = input.replace(nums[i], Integer.toString(i));
}
~~~

- 중간중간 결과를 저장하기!

### String.replaceAll(String regex, String replacement)

- 정규표현식을 쓴다.
- regex 자체에 문자가 들어가도 ok야!



# 22.09.02 PGS_체육복

- 문제에서 조건이 있으면, 꼭 읽도록 하자..
- 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
  -  단순하게 설정하면 안 되는 이유!
