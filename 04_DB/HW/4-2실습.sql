select count(*) as '행수' FROM user INNER JOIN board;

select u.id, b.title from board b inner join user u on b.writername = u.name ;

select u.id, b.title from board b inner join user u on b.writername = u.name where b.title LIKE '%헐크%' ;

SELECT u.email, b.createtime
FROM user u
INNER JOIN board b
ON u.name = b.writername
WHERE year(createtime) <= 2018
;

-- 각 년도에 몇 며의 사용자들이 board를 작성했는지. 한 명이 어떤 년도에 2개 이상 작성했으면 1번만 센다
SELECT count(DISTINCT u.name) , YEAR(b.createtime) FROM board b INNER JOIN user u  on b.writername = u.name GROUP BY YEAR(b.createtime)  ;

-- 2016년 이후 각 사용자들이 몇 개의 board를 작성했는 지알 수 있도록 id와 board개수
SELECT u.id, count(u.id) as '개수' FROM user u INNER JOIN board b on u.name = b.writername WHERE year(b.createtime) >= 2016 GROUP BY u.id;

-- id가 'blackwidow'인 사용자 보다 나이가 많은 user의 id와 age를 출력하시오.
SELECT DISTINCT u.id, u.age 
FROM user u 
INNER JOIN board b 
on u.name = b.writername
WHERE u.age > (select age 
				from user
                where id = 'BlackWidow')
;

-- 2019년에 board를 작성한 적이 있는 사용자의 id를 출력하시오
SELECT DISTINCT u.id
FROM user u 
INNER JOIN board b
on u.name = b.writername
WHERE year(b.createtime) = 2019;

-- age가 30부터 60 사이인 사람들이 작성한 board의 타이틀

SELECT b.title
FROM user u 
INNER JOIN board b
on u.name = b.writername
WHERE age >= 30 and age <= 60;

-- age가 60보다 큰 사람이 board를 작성한 적이 있다면 그 사람의 name을 출력하세요

SELECT DISTINCT u.name  FROM user u
INNER JOIN board b
ON u.name = b.writername
where u.age >= 60;


SELECT * FROM user; -- name email
SELECT * FROM board; -- writername createtime 

