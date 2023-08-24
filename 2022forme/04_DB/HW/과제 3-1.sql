DROP DATABASE IF EXISTS test_user ;
-- 1. test_user schema 생성
CREATE DATABASE test_user;
-- 1. 해당 스키마 사용
USE test_user;

-- 2. test_user에 다음 조건을 만족하는 user 테이블 생성
CREATE TABLE user (
    age INT NOT NULL,
    email VARCHAR(40) NOT NULL,
    id VARCHAR(40) NOT NULL,
    name VARCHAR(40) NOT NULL,
    password VARCHAR(40) NOT NULL
);
-- user 테이블에 phone number 컬럼 삽입 (int)
ALTER TABLE user ADD COLUMN phone_number int;

-- user 테이블에 phone_number 속성을 아래와 같이 변경(varchar40, nullable NO)
ALTER TABLE user MODIFY phone_number VARCHAR(40) NOT NULL;
DESC user;
-- phone_number 컬럼 삭제
ALTER TABLE user DROP phone_number;

-- user 테이블에 아래와 같은 데이터를 삽입하세요
SELECT * FROM user;
INSERT INTO user (id, password, name, email, age)
VALUES ("BlackWidow", "1278", "나타샤 로마노프", "blackwidow@ssafy.com", 38),
		("CaptainAmerica", "5678", "스티브 로저스", "Captain@ssafy.com", 30),
        ("Hulk", "2486", "브루스 배너", "hulk@ssafy.com", 54),
        ("Ironman", "1234", "토니 스타크", "ironman@ssafy.com", 53),
        ("Thor", "1111", "토르", "GodOfThunder@ssafy.com", 1500),
        ("Ultron", "2355", "울트론", "ultron@ssafy.com", 38);
        
	
SELECT id, password, name, email, age FROM user;

SET SQL_SAFE_UPDATES = 0 ;

-- 8. name이 토르 인 사용자의 이메일을 Thor@ssafy.com으로 변경
UPDATE user
set email = "Thor@ssafy.com" 
WHERE name="토르";

UPDATE user
set age = 0
WHERE name = "울트론";

-- 9. age가 1000 이상인 사용자를 삭제하세요
DELETE FROM user
WHERE age >= 1000;

-- 10. user 테이블에 있는 모든 데이터를 삭제하시오
DELETE FROM user;





