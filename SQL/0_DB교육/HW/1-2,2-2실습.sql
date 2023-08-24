SELECT * FROM USER;

SELECT NAME FROM USER;

SELECT * FROM board ORDER BY createtime;

SELECT * FROM user WHERE name = '울트론';

SELECT * FROM user WHERE name LIKE '토%';

SELECT * FROM board WHERE title LIKE '%헐크%';

SELECT * FROM user WHERE id = 'Ironman' OR id = 'CaptainAmerica';

SELECT * FROM user WHERE age > 50 AND name LIKE '%토%';

SELECT * FROM board ORDER BY createtime DESC LIMIT 3 OFFSET 0;

SELECT * FROM board ORDER BY YEAR(createtime) DESC, num ASC;

SELECT * FROM user WHERE substr(id, 3, 1) = 'o';

SELECT replace(content, ' ', '+') AS '치환' FROM board;

SELECT DISTINCT(writername) FROM board;


SELECT count(*) '사용자 수' FROM user;

SELECT avg(age) '평균' FROM user;

SELECT sum(age) '총 합' FROM user;

SELECT round( avg(age), 2)  FROM user WHERE age >= 35;


SELECT writername, count(*) as 개수 FROM board GROUP BY writername ;


SELECT writername, createtime as '날짜'  
FROM board 
WHERE (writername, createtime) in (
	SELECT '토르', MAX(createtime)
    FROM board
    GROUP BY writername
    );

SELECT writername ,createtime, count(*) FROM board WHERE YEAR(createtime) >= 2017 GROUP BY writername;
