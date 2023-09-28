## 23.09.06

- 없으면 특정 이름으로 NULL 만들기
  - NULL as '이름'
- UNION한 결과 정렬 -> 서브쿼리사용
 - 맨 마지막에 해야하고, 이름 넣어야 함

## 23.09.07
- 특정 문자열 포함'..시트'
 - options LIKE '..시트' OR options LIKE '..시트'...
- 순서 기억
 - FROM & JOIN -> WHERE -> GROUP BY -> HAVING -> SELECT - ORDER BY - LIMIT



## 23.09.28

- 보통 한 쪽에는 정보가 없고, 한 쪽에만 있는 경우는 원하지 않는다
- 그럴 땐 LEFT JOIN 쓰면 안 된다.



- GROUP BY 전에 WHERE절 쓰던가
- HAVING 쓰던가



## 23.09.29

- date_format( 열, '%Y-%m-%d') 기억하기
- 특정 유저가 특정 물건을 이전에 구입한 적 있는지 
  - **GROUP BY 유저, 물건**
  - **HAVING COUNT(*) >= 2**

**GROUP BY를 로 이으면 그룹화 된다는거 잊지 말기!**
