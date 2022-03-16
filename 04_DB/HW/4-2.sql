DROP DATABASE IF EXISTS ssafy_movie;

CREATE DATABASE ssafy_movie;

USE ssafy_movie;

DROP TABLE IF EXISTS movie;
DROP TABLE IF EXISTS cinema;


CREATE TABLE `cinema` (
	`CinemaCode` int(10) NOT NULL PRIMARY KEY,
    `CinemaName` varchar(10) CHARACTER SET utf8mb4 NOT NULL,
    `Location` varchar(10) CHARACTER SET utf8mb4 NOT NULL
)ENGINE=InnoDB;

CREATE TABLE `movie` (
	`ID` int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `CinemaCode` int(10) NOT NULL,
    `Title` varchar(40) CHARACTER SET utf8mb4 NOT NULL,
    `ReleaseDate` date,
    `RunningTime` int(3) NOT NULL,
    CONSTRAINT `movie_ibfk_1` FOREIGN KEY (`CinemaCode`) REFERENCES `cinema` (`CinemaCode`)
)ENGINE=InnoDB;



INSERT INTO `cinema` (CinemaCode, CinemaName, Location) 
VALUES
(0, 's시네마','서울'),
(1, 'G시네마','광주'),
(2, 'B시네마','부산'),
(3, 'i시네마','인천');


INSERT INTO `movie` (Id, CinemaCode, Title, ReleaseDate, RunningTime)
VALUES 
(1000, 0,'이터널스',STR_TO_DATE('5-11-2021','%d-%m-%Y'),156),
(1001, 0,'트랜스포터',STR_TO_DATE('2-10-2002','%d-%m-%Y'), 92),
(1002, 1,'해리포터와 마법사의돌',STR_TO_DATE('14-12-2001','%d-%m-%Y'),152),
(1003, 1,'해리포터와 비밀의방',STR_TO_DATE('14-12-2002','%d-%m-%Y'),162),
(1004, 2,'기생충',STR_TO_DATE('30-5-2019','%d-%m-%Y'),153);

commit;

-- 1. movie 테이블과 cinema 테이블을 조인하면 몇 개의 해이 되는지 출력
SELECT count(*) AS "행 수" FROM movie JOIN cinema;

-- 2. 모든 영화가 어떤 cinema에서 상영중인지 알 수 있또록 영화 정보와 시네마 정보를 모두 출력하시오

SELECT * FROM
movie as m join cinema as c
on m.CinemaCode = c.CinemaCode;

-- 3. 서울에 있는 시네마에서 상영하는 영화들을 조회하시오

SELECT m.ID, m.CinemaCode, m.Title, m.ReleaseDate, m.RunningTime, c.CinemaCode, c.CinemaName, c.Location
FROM movie m INNER JOIN cinema c
on m.cinemaCode = c.cinemaCode
WHERE m.cinemaCode = 0;

-- 4. 광주에 있는 시네마에서 상영하는 영화의 수
SELECT COUNT(DISTINCT Title) AS '상영 중', c.Location 
FROM movie as m  INNER JOIN cinema as c
ON m.cinemaCode = c.cinemaCode
WHERE m.cinemaCode = 1;

-- 5. cinema 이름으로 그룹팡 하여 각 시네마마다 몇 개의 영화가 상영중인지 조회하시오

SELECT c.cinemaName , COUNT(*) AS "상영 중" FROM movie m INNER JOIN cinema c 
ON m.cinemaCode = c.cinemaCode
GROUP BY c.cinemaName;

-- 6. cinema 이름으로 그룹핑 하여 각 시네마마다 몇 개의 영화가 상영중인지 출력하는데, 상영중인 영화가 0개인 시네마도 조회하시오
SELECT c.cinemaName, count(m.cinemaCode) as "상영 중" FROM cinema c  LEFT OUTER JOIN movie m 
on c.cinemaCode = m.cinemaCode
GROUP BY m.cinemaCode;

-- 7. cinema 지역으로 그루핑 하는데 상영하는 영화의 개수가 1개인 시네마의 지역

SELECT COUNT(ID) AS "상영 중", Location as "지역" FROM movie m INNER JOIN cinema c
ON m.cinemaCode = c.cinemaCode
GROUP BY c.Location
HAVING COUNT(ID) = 1;

-- 8. 영화 이름이 '이터널스'인 영화의 상영 시간 이상인 영화 이름과 상영 시간을 출력하세요

-- 8-1, 영화 이름이 이터널스인 영화의 상영 시간 뽑기
SELECT RunningTime FROM movie 
WHERE Title = '이터널스';

SELECT Title, RunningTime FROM movie
WHERE RunningTime >= (SELECT RunningTime FROM movie 
					WHERE Title = '이터널스');
                    
-- 9. 상영 시간이 156분 이상인 영화들을 상영중인 cinema 이름을 출력하시요

-- 9-1상영시간이 156분 이상인 영화들의 cinemaCode
SELECT cinemaCode FROM movie
WHERE RunningTIme >= 156;

SELECT cinemaName FROM cinema
WHERE cinemaCode IN (SELECT cinemaCode FROM movie
					WHERE RunningTIme >= 156);

-- 10. 상영시간이 156분 이상인 영화들 중 제목에 '해리포터' 라는 단어를 포함하는 영화 제목과 상영 시간을 출력하시오
SELECT m.Title  , m.RunningTime FROM (SELECT * FROM movie
								WHERE RunningTIme >= 156) m
WHERE m.Title LIKE '%해리포터%'  ;
