## 들어가기 전에

### 깨어나는 절차 지향

순서가 중요.

SQL은 디자인적으로 순서가 없음(반복문이 없는 이유)

최근 순서와 순번을 다룬다.

- ROW NUMBER(), SEQUENCE 객체를 만든 이유!



## 23강_레코드에 순번 붙이기

### 1. 기본 키가 한 개의 필드일 경우

#### 윈도우 함수 사용

- 필드키가 하나인 경우엔 그냥 
- ROW_NUMBER() OVER ( ORDER BY 뭐시기) 하면 자연스럽게

#### 상관 서브쿼리 사용

재귀집합

``` sql
SELECT student_id,
	(SELECT COUNT(*)
  FROM Weights W2
  WHERE w2.student_id <= W1.student_id) AS seq
FROM Weights W1;
```

- **성능은 윈도우 함수가 좋다**



### 2. 기본 키가 여러 개의 필드로 구서오디는 경우

학급 + 학생이 기본키

#### 윈도우 함수

ORDER BY의 ㅣ에 필드를 추가하기만 하면 OK

- ``` sql
  SELECT student_id, ROW_NUMBER() OVER ( ORDER BY KEY1, KEY2)
  FROM Weights2;
  ```

#### 상관 서브쿼리

- **다중 필드 비교**

- ``` sql
  #서브쿼리 속 WHERE 절
  WHERE (W2.class, W2.student_id) <= (Wq.class, W1.student_id)
  ```

### 3. 그룹마다 순번을 붙이는 경우

#### 윈도우 함수

- Partition By로 함 나눠주고 그 다음 ORDER BY 떄림

#### 상관 서브쿼리

- ```sql
  WHERE W2.class = W1.class AND (student id 비교)
  ```



### 4. 순번과 갱신

- seq 필드 만들어놓고

#### 윈도우 함수 사용

``` sql
UPDATE Weights3
SET seq = ( SELECT seq
          	FROM (
            	SELECT class, student_id, ROW_NUMBER() OVER (PARTITION BY
                                                          class ORDER BY
                                                          student id) AS seq
            FROM Weights) SeqTbl
        WHERE Weights3.class = SeqTbl.class 
          AND Weights3.student_id = SeqTbl.student_id)
```



SeqTbl이라는 서브쿼리를 만들어서 해야함(윈도우 함수)

#### 상관 서브쿼리

``` sql
UPDATE Weights3
	SET seq = ( SELECT COUNT(*)
            	FROM Weights3 W2
            	WHERE W2.class = Weights3.class
            	AND We.student_id <= Weights3.student_id);
```



## 24강_레코드에 순번 붙이기 응용

자연수의 성질인 **연속성**과 **유일성**을 사용해보자

### 1. 중앙값 구하기

짝수, 홀수 다르다

#### 집합 지향적인 방법

좀 어렵다. 성능도 나쁘다.

#### 절차 지향적 방법(1) - 세계의 중심을 향해

ROW_NUMBER() 를 활용해서, 오름차순 내림차순 같은 부분

짝수 : hi = lo+1 AND hi = lo - 1 (WHERE hi IN ( lo-1, lo, lo+1))

ORDER BY에 student_id도 들어가야 함(결과가 null)

#### 절차 지향적 방법(2) -  2 빼기 1 은 1

diff가  0~2인거 찾기

그럼 정렬을 한 번만 한다



### 2. 순번을 활용한 테이블 분할

단절 구간 찾기 (1,3,4,6,7,8,9,12)

비어있는 구간 찾기

#### 집합 지향적 - 집합의 경계선

N1과  MIN(N2) 이런식으로 비교하기(어렵다)

#### 절차 지향적 - '다음 레코드'와 비교

이전과 차이가 1이 아니라면 비어있는 레코드 있음

FOLLOWING 활용



### 3. 테이블에 존재하는 시퀸스 구하기

**친구 또는 가족 인원수에 맞게 자리를 에약**

어렵다



## 25강. 시퀸스 객체, IDENTITY 필드, 채번 테이블

​	**사실, 모두 최대한 사용하지 않기**

그냥 알아만 두자

### 1. 시퀸스 객체

CREATE 구문으로 정ㅁ

문제점들이 많으니까 넘어가자.



## 마치며

- SQL 절차 지향형 -> 윈도우 함수라는 형태로 부활
- 코드 간결 -< 가독성 향상
- 결합, 테이블 접근을 줄임 - > 성능 ㅎㅇ상



**결합을 먼저 하고, 집약을 나중에!**