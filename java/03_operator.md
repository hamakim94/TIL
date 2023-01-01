# 3장 연습문제

## 3.1

1. 연선자 우선순위 : 산술 > 이진변환?
   - 3을 왼쪽으로 한칸 -> 11 -> 110
   - 6
2. true
3. y = y + 10 - x++ = 13
4. 5
5. false
6. 2
7. 5
8. 66
9. 66 (틀림).  => char 자료형이고, 단항연산자는 자료형을 변환시키지 않음
10. 66 (틀림). => 이항연산자는 연산자 연산을 위해 '피연산자 스택'을 활용해 형변환 일어나는거
11. 67 (틀림)

## 3.2

numOfApples % sizeOfBucket > 0 ? numOfApples / sizeOfBucket + 1 : numOfApples / sizeOfBucket  

조금 아쉽다. 그냥 0, 1 만 더하는걸 분기로 하면 코드가 깔끔해질듯

## 3.3

~~~ java
num > 0 ? "양수" : num == 0 ? "0" : "음수";
~~~

## 3.4

~~~ java
num / 100 * 100;
~~~

## 3,5

~~~ java
num / 10 * 10 + 1
~~~

## 3.6

~~~ java
(num + 10) / 10 * 10 - num
  
// 훨씬 좋은 답
  10 - num % 10
  // 어차피 올리네...
~~~

## 3.7 (틀림), int 형변환, / 100f 부분

~~~ java
((5 / 9.0f * (fahrenheit - 32) ) * 100  + 0.5) / 100;
// (int) ((5/9f * (fahrenheit - 32) ) * 100  + 0.5) / 100f;
~~~

## 3.8(틀림)

~~~ java
//1
byte c = (byte) a + b;
ch = (char) (ch + 2);
float f = 3 / 2.0f * 10 / 10.0f; // 그냥 2f로 하ㅐ도 되는듯
long l = 3000L * 3000 * 3000;
double d = (float) 0.1 // 틀림 이 부분에서 말고 다른 부분에서 형환했어야함
  // boolean result = (float) d == f2
  // f2가 float이기 때문에 double을 float으로 형변환해버렸당

~~~

## 3.9(틀림)

- .. 그냥 boolean인데 뭘 값을 정해. 참이면 true 아니면 false, 명심

~~~ java
(ch >= 'a' && ch <= 'z') ? true : (ch >= '0' && ch <= '9') ? true : (ch >= 'A' && ch <= 'Z') ? true : false : false : false;   
~~~

## 3.10

~~~ java
ch >= 'A' && ch <= 'Z' ? (char) (ch + 32)
~~~



