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


