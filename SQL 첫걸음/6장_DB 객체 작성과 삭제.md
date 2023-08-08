# 6장_DB 객체 작성과 삭제

## 25장_DB 객체

스키마 -> 데이터베이스 객체들을 관리하는 틀(테이블, 인덱스, 뷰)





## 26장_테이블의 작성, 삭제, 변경

DDL

CREATE TABLE 테이블명 ( 열이름 속성 제약 ...)

DROP TABLE ( 테이블명) 

- 완전 삭제
- 구조는 남아 : DELETE FROM -> 연산 많아 -> TRUNCATE 사용 빨라

ALTER TABLE 테이블명

- ADD 열 제약조건, MODIFY 기존 열 제약조건, CHANGE 기존열 새로운 열 이름 제약조건, DROP 열 이름



## 27강_제약

CONSTRAINT 제약이름 () -> (테이블) 제약 조건을 다루기 쉽게 이름 짓는 것.

열 제약(modify), 테이블 제약(DROP, ADD)로 추가 혹은 삭제

기본키(유일성 ! , 검색하기 용이함)