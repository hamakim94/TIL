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

## Java HashMap Key 값 변경법

~~~java
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

arr[ inputString.charAt(i) - 'a'] // 0번쨰 index로 가짐
~~~

#### Int이하의 변수 타입을 사용하는 경우, 연산 시 int로 자동변환

cf) 아스키 코드

- 알파벳 개수 26개

  - 소문자 a = 97~122 
  - 대문자 A 65~90 

- 숫자 0 ~ 9 : 48 ~ 57

  

