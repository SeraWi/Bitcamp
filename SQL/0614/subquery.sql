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

--sub QUERY
select custid, (select name from customer c where o.custid = c.custid) as "이름",
                sum(o.saleprice)as "구매액"
from orders o
group by custid;

-- 인라인 뷰 : from 절 뒤에 사용되는 부속질의, 가상  테이블 처럼 사용
-- 고객번호가 2이하인 고객의 판매액을 보이시오(결과는 고객이름과 고객별 판매액 출력)
-- 고객번호: customer, 판매액: orders

select o.custid, c.name, sum(o.saleprice)
from (select * from customer where custid<=2) c, orders o
where c.custid = o.custid
group by o.custid, c.name;


-- 중첩질의 : where 절 뒤에 사용하는 부속질의
-- 비교연산자를 이용할 때는 단일행 단일열의 결과를 같는 부속질의를 사용
-- ><= != >= <=
-- 평균 급여보다 더 많은 급여를 받는 사원을 검색

select *
from emp
where sal > (select avg(sal)from emp)
order by sal;

--평균 주문금액 이하의 주문에 대해서 주문번호와 금액을 보이시오
-- 주문번호와 금액 -> orders

select *
from orders
where saleprice <= (select avg(saleprice) from orders)
order by saleprice;

--– 각 고객의 평균 주문금액보다 큰 금액의 주문 내역에 대해서 
--주문번호, 고객번호, 금액을 보이시오

-- 다중행 연산자 IN

--3000 이상 받는 사원이 소속된 부서(10번, 20번)와 동일한 부서에서 근무하는 사원 리스트 출력

select distinct deptno
from emp
where sal >= 3000;

select *
from emp
where deptno in(10,20);

select * 
from emp
where deptno in(select distinct deptno from emp where sal >= 3000);

--대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오.





