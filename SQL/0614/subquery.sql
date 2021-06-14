--2021.06.14
--sub query

--스칼라 부속 질의  : select 절 이후에 사용
-- 단일 행 단일 열 값이 사용된다.
select *
from orders;

select o.custid , (select c.name from customer c where o.custid = c.custid) as "name"
from orders o;

--emp 테이블만 사용해서 사원이름과 부서이름을 출력
select e.ename, (select d.dname from dept d where e.deptno = d.deptno) as"dname"
from emp e;

select ename, dname
from emp, dept
where emp.deptno = dept.deptno;

--마당서점의 고객별 판매액을 보이시오(결과는 고객이름과 고객별 판매액을 출력)
-- 고객 이름: customer
-- 판매액 : orders

--JOIN
select c.custid, c.name, sum(o.saleprice) as "판매액"
from orders o, customer c
where o.custid = c.custid
group by c.custid,c.name;





