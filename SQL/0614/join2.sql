--2021.06.14
-- non equi join
--동등 비교가 아닌 크다 작다와 같은 비교로 조인의 조건을 작성

select * from salgrade;

select *
from emp e, salgrade s
order by e.ename;

--sal에 따라 등급 알아보기
select e.ename, e.sal, s.grade, s.losal,s.hisal
from emp e, salgrade s -- 새로운 테이블이다!!
--where e.sal >= s.losal and e.sal <= s.hisal
where sal between s.losal and s.hisal
order by e.ename;


-- ansi cross join
select * 
from emp cross join  dept;

-- 구매내역(orders), 구매자 이름(customer), 책이름(book)
select  * from customer;
select * from orders;
select * from book;

-- 책 구매한 사람 주문 번호, 구매자 이름, 구매한 책
select o.orderid, c.name, b.bookname
from orders o, customer c, book b
where o.custid = c.custid and o.bookid = b. bookid
order by o.orderid;

--ansi inner join
-- oracle equi join과 같다.
--EQUI
select *
from emp, dept
where emp.deptno = dept.deptno;

--ANSI
select *
from emp e inner join dept d
on e.deptno = d.deptno;


--이름이 SCOTT인 사람의 부서명을 출력해봅시다.
--출력해야하는 컬럼을 가지는 테이블을 확인해보자
-- 이름: emp 부서명: dept

--EQUI
select ename,dname
from emp e, dept d
where e.deptno = d.deptno and ename ='SCOTT'
order by d.dname, e.ename;

--ANSI
select *
from emp e inner join dept d
on e.deptno = d.deptno
where e.ename ='SCOTT';--이름이 SCOTT인 사람

--비교하는 컬럼의 이름이 같을 때
--on 절을 생략하고 -> using 을 이용하면 조건식을 간략하게 처리할 수 있다.
select *
from emp e inner join dept d
--on e.deptno = d.deptno
using (deptno)
where e.ename ='SCOTT';--이름이 SCOTT인 사람


-- NATURAL JOIN
select *
from emp NATURAL JOIN dept; -- 결과: deptno가 하나만 나온다

-- self Join
select e.empno,e.ename,e.mgr, m.ename
from emp e, emp m
where e.mgr = m.empno(+); 
--> 표현하고자 하는 컬럼이 테이블의 반대쪽, null값을 가지는 위치에(+)

-- Outer JOIN
-- [left|right|full] outer join

select e.ename, e.mgr, m.ename as "관리자"
from emp e left outer join emp m
on e.mgr = m.empno;


--회원별
select c.name, count(o.orderid)as "구매횟수", avg(saleprice)
from orders o, customer c
where o.custid(+) = c.custid --order 쪽에 null이 들어갈 수 있다.
group by c.name
order by c.name;









