#  2장, SQL 기초



## 6강_SELECT 구문



### SELECT

- 하나의 함수
- 입력값도 테이블, 반환값도 테이블
  - **폐쇄성**(나중에 뷰나 서브쿼리를 이해할 떄 필요)



### WHERE

- 거대한 벤 다이어그램
- OR조건이 너무 많아서 쓰기 힘들어서 만든게 IN





### GROUP BY

- 보통 GROUP BY가 생략되면, GROUP BY () 라고 생각하면 좋다(그냥 하나로)



### HAVING

- WHERE : 레코드에 조건을 지정
- HAVING : '집합'에 조건 지정

``` sql
SELECT address, COUNT(*)
FROM Address
GROUP BY address
HAVING COUNT(*) = 1; # 이렇게 조건 지정 가능
```



### ORDER BY

- ASC(기본), DESC



### 뷰와 서브쿼리

- 자주 사용하는 SELECT 구문 자체를 DB 안에 저장 => **View(뷰)**
- SELECT 구문을 저장하는 것 뿐



만들기

```sql
CREATE VIEW [뷰이름] ([필드이름1], [필드이름2], ...) AS

CREATE VIEW CountAddress (v_address, cnt)
AS
	SELECT address, COUNT(*)
  FROM Address
  GROUP BY address
```

```sql
SELECT v_address, cnt
FROM CountAddress; # (테이블 데신 뷰를 FROM 구에 지정)
```

### 익명 뷰

- 뷰에서 데이터를 선택하는 SELECT 구문은

- '추가적인 SELECT 구문 실행'

- ```sql
  SELECT v_address, cnt
  FROM (SELECT address AS v_address, COUNT(*) AS cnt
  			FROM ADDRESS
        GROUB BY address) AS CountAddress;
  ```

- FROM 구에 직접 지정하는 SELEC 구문 -> **서브쿼리(subquery)**

##### 

#### 서브쿼리 활용 편리한 조건 지정

WHERE구의 조건에 섭3ㅡ쿼리 활용

SQL은 서브쿼리부터 순서대로 실행

**서브쿼리를 쓰면 하드코딩할 일이 줄어든다*



## 7강_조건 분기, 집합 연산, 윈도우 함수, 갱신



### 1. SQL과 조건 분기

- 조건 분기를 '문장'단위로 하지 않음
- '식'을 기준, -> CASE 식



#### CASE 식의 구문

- 단순 CASE식 , **검색 CASE 식**

- ``` sql
  CASE WHEN [평가식] THEN [식]
  		 WHEN [평가식] THEN [식]
  		 생략
  		 ELSE [식]
  END
  ```

  - WHEN에 있는 평가식 - '필드 = 값'



#### CASE 식의 작동

switch와 유사, 차이점 : **리턴값**

SQL의 조건 분기는 특정한 값(상수)를 리턴

``` sql
SELECT name, address,
	CASE WHEN address = '서울시' THEN 경기
  CASE WHEN address = '서울시' THEN 경기
  CASE WHEN address = '서울시' THEN 경기
  CASE WHEN address = '서울시' THEN 경기
  ...
  ELSE NULL END AS district
FROM Address;
```

- 위 구문과 같이 반환 값(상수) 를 새로운 필드로 저장할 수 있다.

**CASE의 가장 강력한 점 : 식**\

- SELECT, WHERE, GROUP BY, HAVING, ORDER BY, 구와 같은 곳 어디에나 저장
- 성능과도 큰 관련이 있다!



### 2. SQL의 집합 연산

#### UNION으로 합집합 구하기

```sql
SELECT *
	FROM Address
UNION
SELECT *
	FROM Address2
```

테이블을 하나로 합침 -> 중복된 레코드 제거

중복을 제외하고 싶지 않으면 UNION ALL

#### INTERSECT로 교지합 구하기

공통으로 존재하는 레코드만 출력

#### EXCEPT : 차집합

INTERSECT의 결과만 ㅓ없어짐

**순서 주의**(밸셈이니까)



### 3. 윈도우 함수

- 데이터 가공 + 성능
- **집약 기능이 없는 GROUP BY 구**
- 자르기만 하고(케이크 조각으로) 집약하는게 없음
- 출력 결과의 레코드 수 = 입력되는 테이블의 레코드 수

```sql
SELECT address
	COUNT(*) OVER(PARTITION BY address)
FROM Address;
```

그야말로, 파티션 한 결과만 나오네..

사용할 수 있는 함수

- COUNT, SUM, RANK(DENSE_RANK), ROW_NUMBER

``` sql
SELECT name, age,
			 RANK() OVER(ORDER BY age DESC) AS rnk
FROM Address;
```



### 4. 트랜잭션과 갱신

1. **삽입(insert)**
2. **제거(delete)**
3. **갱신(update)**



#### INSERT: 데이터 삽입

등록 단위 : 레코드

```sql
 INSERT INTO [테이블 이름] ([필드1], [필드2], ...)
 			VALUES ([값1], [값2], ...)
```

문자형 자료는 작은따옴표 필수



#### DELETE : 데이터 제거

``` sql
DELETE FROM [테이블 이름] WHERE 식; 
```

- DELETE는 테이블이 사라지진 않음



#### UDPATE로 데이터 갱신

```sql
UPDATE [테이블 이름]
	SET [필드 이름] = [식];
	WHERE 식
```

필드를 쉼표로 구분해서 나열 가능~



SELECT RANK() OVER(PARTITION = 'sex') as RANK

FROM  ADDRESS;





## 연습문제

Address 테이블에서 성별 별로 나이 순위(건너뚜기 있게)를 매기는 SELECT 구문 생각

- 우선, 순위를 하나씩 다 구해야하니, 윈도우 함수를 생각
- 윈도우 함수는 GROUP BY 대신에, PARTITION BY, ORDER BY 사용 가능
- 윈도우 함수 + OVER() 를 사용한다.



정답 : 

select  name,age,sex, RANK() OVER(PARTITION BY sex ORDER BY age DESC) rnk_desc from address;

OVER 안에서 중처비 가능하다고 생각하기