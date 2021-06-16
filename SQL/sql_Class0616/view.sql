-- 2021.06.16

-- view

-- 자주 사용되는
-- 30번 부서에 소속된 사원들의 사번과 이름과 부서번호를 출력하기 위한
-- SELECT문을 하나의 뷰로 정의해 봅시다

create or replace view emp_view30
as
select empno, ename, deptno 
from emp
where deptno = 30
;

select * from emp_view30;


