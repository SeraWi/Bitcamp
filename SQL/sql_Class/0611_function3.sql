--2021.06.11

-- 그룹함수
-- 여러행을 묶어 처리하는 함수
-- sum,avg,count,max, min

-- 사원 테이블에서
-- 1. 사원의 수
-- 2. 사원의 급여 총합
-- 3. 급여 평균
-- 4. 최대 급여
-- 5. 최소 급여

select count(*)
from emp;
-- 행의 개수
select count(comm)
from emp;
-- 행에 null이 있다면 count하지 않는다.

select count(*) as "사원의 수",
        sum(sal) as "급여 총합", 
        avg(sal) as "급여 평균",
        max(sal) as "최대 급여",
        min(sal) as "최소 급여"
from emp;