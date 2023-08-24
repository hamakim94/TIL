USE scott;

-- 사번이 7788인 사원의 부서 이름을 조회하고 싶다.
SELECT deptno
FROM emp
WHERE empno = 7788;

SELECT dname
FROM dept
WHERE deptno = 20;

-- 실행 순서의 유의하며 확인하자

SELECT dname
FROM dept
WHERE deptno = (SELECT deptno
				FROM emp
				WHERE empno = 7788);

-- 매니저의 이름이 'KING'인 사원의 사본, 이름, 부서번호, 업무 조회

DESC dept;
DESC emp;

SELECT empno, ename, deptno, job
FROM emp
WHERE mgr = (SELECT empno FROM emp WHERE ename = 'KING'); 

-- 2. 7566번 사원보다 급여를 많이 받는 사원이 이름, 급여를 조회

SELECT ename, sal
FROM emp
WHERE sal > (select sal FROM emp WHERE empno = 7566);

-- 3. 20번 부서의 평균 급여보다 급여가 많은 사원의 사번, 이름, 업무, 급여 조회
SELECT empno, ename, job, sal FROM emp
WHERE sal >= (SELECT AVG(sal) FROM emp where deptno = 20);

-- 4. 업무가 'TURNER'와 같고, 사번 7934인 직원보다 급여가 많은 사원의 사번, 이름 업무를 조회
SELECT empno, ename, job
FROM emp
WHERE job = (SELECT job FROM emp WHERE ename = 'TURNER') AND sal > (SELECT sal FROM emp where empno = 7934);

-- 업무가 'salesman' 인 직원들 중 최소 한 명 이상보다 많은 급여를 받는 원의 이름, 급여 ,업무를 조회

SELECT ename, sal, job
FROM emp
WHERE sal > ANY(select sal FROM emp where job = "SALESMAN");

-- 업무가 'SALESMAN'인 모든 직원보다 급여(커미션 포함)를 많이 받는 사원의 이름, 급여, 업무, 입사일, 부서번호 조회
select * fROM emp;
SELECT ename, sal, job, DAY(HIREDATE), IFNULL(DEPTNO, 0)
FROM emp
WHERE sal > all( SELECT sal + IFNULL(comm, 0) WHERE job = "SALESMAN");

-- 직원이 최소 한 명이라도 근무하는 부서의 부서번호, 부서이름, 위치?
SELECT DISTINCT deptno
FROM emp;

SELECT deptno, dname, loc
FROM dept
WHERE deptno IN (SELECT DISTINCT deptno
				FROM emp);

-- 이름이 FORD인 사원과 매니저 및 부서가 같은 사원의 이름, 매니저번호, 부서 번호를 조회 (단, FORD의 정보는 조회 X)

SELECT ename, mgr, deptno
FROM emp
WHERE (mgr, deptno) = (SELECT mgr, deptno
						FROM emp
						WHERE ename = 'FORD')
AND ename <> 'FORD';

-- 각 부서별 입사일이 가장 빠른 사원의 사번, 이름, 부서번호, 입사일을 조회
SELECT empno, ename, deptno, hiredate
from emp
where (deptno, hiredate) in (SELECT deptno, MIN(hiredate) from emp GROUP BY deptno);

-- 상호연관 서브쿼리
-- 소속 부서의 평균 급여보다 많은 급여를 받는 사원의 이름, 급여 ,부서번호, 입사일, 업무를 조회
SELECT ename, sal, deptno, hiredate, job
FROM emp e
WHERE sal > ( SELECT AVG(sal) 
				FROM emp
				WHERE deptno = e.deptno);
                
-- 인라인 뷰( FROM절에 서브 쿼리)
-- 모든 사원의 평균급여/보다 적게 받는 사원들과 같은 부서에서 근무하는 사원의 사번, 이름, 급여, 부서번호를 조회
SELECT DISTINCT deptno
FROM emp
WHERE sal < (SELECT AVG(sal) FROM emp);

SELECT e.empno, e.ename, e.sal, e.deptno
FROM emp e, (SELECT DISTINCT deptno
			FROM emp
			WHERE sal < (SELECT AVG(sal) 
						FROM emp)) d
WHERE e.deptno = d.deptno;

-- 모든 사원의 대하여, 사원의 이름, 부서 번호, 급여, 사원이 소속된 부서의 평균 급여를 조회(단, 이름은 오름차순으로)
SELECT deptno, AVG(sal) as "avgsal"
FROM emp
GROUP BY deptno;

SELECT  e.ename, e.deptno, e.sal, d.avgsal
FROM emp e, (SELECT deptno, AVG(sal) as "avgsal"
					FROM emp
					GROUP BY deptno) d
WHERE e.deptno = d.deptno
ORDER BY e.ename;





