USE scott;

-- 카타시안 곱

-- 14개
SELECT 
    empno, ename, job
FROM
    emp;

-- 4개
SELECT 
    deptno, dname
FROM
    dept; 

-- 56개 만들어짐, 원하는 결과가 나오지 안흔다
SELECT 
    empno, ename, job, emp.deptno, dname
FROM
    emp,
    deptSELECT ename, job, emp.deptno, dname;

-- where절 사용하자

SELECT empno, ename, job, emp.deptno, dname
FROM emp, dept
WHERE emp.deptno = dept.DEPTNO;

-- 조인 X 해서 가져오자
SELECT 
    ename, job, emp.deptno, dname
FROM
    emp,
    dept
WHERE
    emp.DEPTNO = dept.deptno
        AND empno = 7788;

-- inner join 조건 on
SELECT 
    e.ename, e.job, e.deptno, d.dname
FROM
    emp e
        INNER JOIN
    dept d ON e.deptno = d.deptno
WHERE
    e.empno = 7788;

-- outer join

-- 부서가 없는 직원을 넣어보자

INSERT INTO emp 
VALUES (4885, '윤일준', 'MANAGER', 7839, '2022-03-16', 6000, NULL, NULL);

-- 동등 조인을 하니 4885가 조회되지 않음(deptno가 없기 때문)
SELECT e.ename, e.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- 기준을 한 군데에 두고 너 붙어! 
-- 사원이룸, 부서번호, 부서이름
SELECT e.ename, e.deptno, d.dname
FROM emp e LEFT OUTER JOIN dept d
on e.deptno = d.deptno;

-- 기준을 부서 기준으로 사원을 붙여보자
-- 해당 부서에서 일하는 사원들을 가져와봐~

SELECT d.deptno,  d.dname, e.empno, e.ename
FROM emp e RIGHT OUTER JOIN dept d
on e.deptno = d.deptno;

-- 셀프 조인 안 쓰고
-- 모든 사원번호, 이름, 매니저 번호, 매니저 이름
SELECT e1.empno, e1.ename, e2.empno, e2.ename
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno;

-- INNER JOIN
SELECT 
    e1.empno, e1.ename, e2.empno, e2.ename
FROM
    emp e1
        LEFT OUTER JOIN
    emp e2 ON e1.mgr = e2.empno;
    
-- 비동등 조인 (Non-Equi JOIN)
-- 모든 사원의 사번, 이름, 급여, 급여 등급을 조회
-- SELECT e.empno, e.ename, e.sal
-- FROM emp e

SELECT e.empno, e.ename, e.sal as "급여", sg.grade as "급여등급"
FROM emp e, salgrade sg
WHERE e.sal  >= sg.LOSAL AND e.sal <= sg.HISAL
-- WHERE e.sal  BETWEEN sg.LOSAL AND sg.HISAL;
ORDER BY sg.grade DESC, e.sal DESC;





