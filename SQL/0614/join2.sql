--2021.06.14
-- non equi join
--동등 비교가 아닌 크다 작다와 같은 비교로 조인의 조건을 작성

select * from salgrade;

select *
from emp e, salgrade s
order by e.ename;

select e.ename, e.sal, s.grade, s.losal,s.hisal
from emp e, salgrade s
where e.sal >= s.losal and e.sal <= s.hisal
order by e.ename;