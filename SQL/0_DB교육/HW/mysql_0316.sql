
-- mysql 숫자관련함수
select POW(2,3) FROM DUAL;

SELECT round(1526.159), round( 1526.159,1), round(1526.159,2), round(1526.159,-1), round(1526.159,3) FROM DUAL;

-- mysql 문자 관련함수
SELECT ename FROM emp WHERE job = 'PRESIDENT';

SELECT length('ssafy');

SELECT locate('abc', 'ababcabc');

SELECT left('hello ssafy', 5);
SELECT right('hello ssafy', 5);

-- 날짜관련함수
SELECT now(), DAY(now());
SELECT datediff('2022-12-31', date(now()));

-- 집계함수

-- 모든 사원에 대하여 사원수, 급여 총액, 펴균 급여,
SELECT 
    COUNT(*) 사원수,
    SUM(sal) 급여총액,
    AVG(sal) 평균급여,
    MAX(sal) 최고급여,
    MIN(sal) 최저급여
FROM
    EMP;

-- 모든 사원에 대하여 사원수, 급여 총액, 펴균 급여, 등 부서 별로
SELECT 
	deptno,
    COUNT(*) 사원수,
    SUM(sal) 급여총액,
    AVG(sal) 평균급여,
    MAX(sal) 최고급여,
    MIN(sal) 최저급여
FROM
    EMP
GROUP BY deptno;

SELECT 
	deptno 부서번호,
    job 직업,
    COUNT(*) 사원수,
    SUM(sal) 급여총액,
    AVG(sal) 평균급여,
    MAX(sal) 최고급여,
    MIN(sal) 최저급여
FROM
    EMP
GROUP BY deptno, job;

-- 이름까지 하면? => 생각보다 필요 없는 경우 있으니 조심해라.. 관련 없는 데이터가 하나의 레코드로
SELECT 
	ename '이름',
	deptno 부서번호,
    job 직업,
    COUNT(*) 사원수,
    SUM(sal) 급여총액,
    AVG(sal) 평균급여,
    MAX(sal) 최고급여,
    MIN(sal) 최저급여
FROMbonus
    EMP
GROUP BY deptno, job;

-- 급여 : 커피션 포험, 평균이 2000이상 부서번호, 부서별 사원수, 평균 급여(커미션 포함), 급여 소수 2째점 반올림
SELECT deptno as '부서번호', count(*) as "사원수", ROUND( AVG(sal +ifnull(comm, 0) ), 2) as "평균급여(커미션포함)"
FROM emp GROUP BY deptno 
HAVING AVG(sal +ifnull(comm, 0)  ) >= 2000;

