-- 스키마 생성 했고, 스키마 이용중
USE test_movie;

-- movie라는 테이블이 존재한다면 삭제

DROP TABLE IF EXISTS movie;

-- movie 생성
CREATE TABLE movie (
	ID           INT         NOT NULL AUTO_INCREMENT,
    TITLE        VARCHAR(40) NOT NULL,
    ReleaseDate  DATE,
    RunningTime  INT         NOT NULL,
    PRIMARY KEY(ID) 
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

-- movie 테이블에 Director column 삽입 - ddl - alter
ALTER TABLE movie
ADD COLUMN Director VARCHAR(40) NOT NULL
AFTER RunningTime;

DESC movie;

-- movie 테이블 Director컬럼 아래와 같이 변경
ALTER TABLE movie 
MODIFY Director VARCHAR(32) ;

DESC movie;

ALTER TABLE movie DROP Director;

DESC movie;

-- auto increment 값을 지정할 수 있음
INSERT INTO movie (ID, Title, ReleaseDate, RunningTime)
VALUES (1000, '이터널스', '2021-11-05', 156);

INSERT INTO movie(ID, Title, ReleaseDate, RunningTime)
VALUES (0, '트랜스포터', '2002-10-02', 92),
	   (0, '해리포터와 마법사의 돌', '2001-12-14', 152),
	   (0, '해리포터와 불의 잔', '2002-12-14', 161),
       (0, '기생충', '2019-05-30', 153);
       
       
 SELECT * FROM movie;
 
 -- id가 1003인 영화의 Title을 '해리포터와 불의 잔으로 변경'
 UPDATE movie
 SET Title = '해리포터와 불의 잔'
 WHERE ID = 1003;
 
 SELECT * FROM movie;
 -- PRIMARY KEY를 사용하는 경우, 안전 모드가 걸려있어서, SET SQL_SAFE_UPDATES = 0으로 해제해야지 관ㄹ기ㅏ 된다
 SET SQL_SAFE_UPDATES = 0;
 
 -- RunningTime이 100이하인 영화를 삭제하기
 DELETE FROM movie
 WHERE RunningTime <= 100;
 
 SELECT * FROM movie;
 
 DELETE FROM movie;
 
 SELECT * FROM movie;
 
