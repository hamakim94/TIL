# 구문에서 식으로

- 생각보다 CASE 식 보다, UNION을 자주 활용한다.
- 그러나 CASE 식이 더 좋은 편..!



## 8강, UNION을 사용한 쓸데없이 긴 표현



### 1. UNION 활용하면 쉽지만 코드 길어

- 같은 테이블에 TABLE ACCESS FULL 2 번

### 2. WHERE구에서 조건 분기를 하는 사람은 초보자

EXPLAIN 후 SELECT 명령어 쓰면 실행 계획 볼 수 있다(mysql)

1번만 접근 가능!



### 3. SELECT 구를 사용한 조건 분기의 실행 계획

- 1번만
  - UNION은 SELECT 구문 자체를 하나의 분기로 사용한다, 식으로 봐야한다.
- 절차 지향형 IF문을 SQL의 CASE로는 어떻게 해결할 수 있지 인식하기
- 이것이 '구문'에서 '식'으로 사고를 변경하는 팁



## 9강_집계와 조건 분기

### 1. 집계 대상으로 조건 분기

#### UNION 활용 ( 읽기만 하자)

- 원하는 결과 : 지역 별 남성, 여성의 인구수

- ``` sql
  SELECT prefecture, sum(pop_men) as pop_men, sum(pop_wom) as pop_wom
  FROM (SELECT prefecture, pop as pop_men, null AS pop_wom
  		FROM Population
  		WHERE sex = 1
  			UNION
  		SELECT prefecture, null as pop_men, pop as pop_wom
  		FROM Population
  		WHERE sex = 2) TMP
  GROUP BY prefecture;
  ```

  - 2번의 FULL SCAN

#### CASE 식

``` sql
EXPLAIN SELECT prefecture, 
	SUM(CASE WHEN sex = 1 THEN pop ELSE 0 END) AS pop_men,
	SUM(CASE WHEN sex = 2 THEN pop ELSE 0 END) AS pop_wom
FROM Population
GROUP BY prefecture;
```

- 생각 방법, CASE 하면 반환 결과가 값, 필드, 새로운 필드 만들어서 붙이는 느낌
- 이를 활용해서 집계할 수 있다



### 2. 집약 결과로 조건 분기

#### UNION

- GROUP BY 한 후 HAVING으로 COUNT가 1, 2, 3회 이상인 걸 
- UNION 해서 합치기

#### CASE

- GROUP BY로 걸러낸 후, SELECT 할 때, group-by 하지 않은 다른 컬럼은 그냥 사용 불가능

- 집계 함수로 써야해, 하나인 경우에는 뭐랄까, 그냥 MAX 써서 그거 그 자체로 써

- **HAVING 구에서 조건 분기를 하는 사람도 초보자**

  

## 10강, 그래도 UNION이 필요한 경우

### 1. UNION을 사용할 수밖에 없는 경우

**여러 개의 테이블에서 검색한 결과를 머지하는 경우**

### 2. UNION이 성능적으로 더 좋은 경우

- **인덱스**

  - 유니온을 했을 때 인덱스를 활용하지만, 이외에 경우에는 테이블 풀 스캔이 발생하는 경우

  - ``` sql
    EXPLAIN SELECT *
    FROM ThreeElements
    WHERE date_1 = '2013-11-01' and flg_1 = 'T'
    UNION
    select *
    FROM ThreeElements
    WHERE date_2 = '2013-11-01' and flg_2 = 'T'
    UNION
    select *
    FROM ThreeElements
    WHERE date_3 = '2013-11-01' and flg_3 = 'T';
    
    # 이렇게 하면 더 빠르게 찾을 수 있는 인덱스를 찾는다~
    CREATE INDEX IDX_1 ON ThreeElements (date_1, flg_1);
    CREATE INDEX IDX_2 ON ThreeElements (date_2, flg_2);
    CREATE INDEX IDX_3 ON ThreeElements (date_3, flg_3);
    ```

- OR (WHERE 3개)

  - 그냥 테이블 풀 스캔
  - 데이터 양이 달라지면, 결과가 다르겠지?
  - **3회의 인덱스 스캔 vs 1회의 테이블 풀 스캔**

- IN

  - ``` sql
    SELECT *
    FROM ThreeElements
    WHERE ('2013-11-01', 'T') IN 
    	( (date_1, flg_1), (date_2, flg_2), (date_3, flg_3));
    ```

  - OR랑 같음

이런 쿼리들은, 비즈니스 룰을 조금 변경하면 다.. 망하네?



## 11강. 절차 지향형과 선언형

### 1. 구문 기반과 식 기반

- SQL 초보 : 절차 지향에 익숙, 기본 단위는 **구문**
- SQL 중급 : 선언 세계, '식'단위

실제 UNION의 연결 대상은 SELECT 구문

- 선언형으로 발돋움하자!



- **CASE WHEN**
  - **앞 조건이 거짓이면, 뒤를 안 함.**
  - 단락 평가(단축 평가) 이기 떄문에
  - UNION과 동치인 것은 테이블 풀 스캔인 IN이나 OR다.