--2021.06.11

--JOIN

-- CROSS JOIN
-- 단순히 스키마의 합: 집합의 곱 연산과 같다.

select * 
from emp,dept;

--이름이 SCOTT인 사람의 부서명을 출력해봅시다.
--출력해야하는 컬럼을 가지는 테이블을 확인해보자
-- 이름: emp 부서명: dept
select ename,dname
from emp e, dept d
where e.deptno = d.deptno --and ename ='SCOTT'
order by d.dname, e.ename;

--self JOIN : 자기 자신을 조인 (참조)
-- emp -> mgr컬럼이 emp.empno 참조

select e.empno,e.ename,e.mgr, m.ename
from emp e, emp m
where e.mgr = m.empno;

select *
from emp e, emp m
where e.mgr = m.empno;



