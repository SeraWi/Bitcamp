-- 2021.06.10
-- function : 단일행 함수, 집합(다중행)함수
-- 단일행 함수 : 하나의 행이 포함하는 특정 컬럼의 값 하나를 처리하고 반환
-- 다중행(집합) 함수 : 여러 행의 특정 컬럼 값들을 대상으로 연산하고 반환

-- 숫자함수
select 'Oracle'
from dual;

select * 
from dual;

select abs(10), abs(-10)
from dual;

select FLOOR(15.7) -- 소수점 이하 자르기 floor() 결과 15
from dual;

select ROUND(15.193,1), ROUND(15.193,-1) -- 소수 첫째자리까지 표현
from dual;

select TRUNC(15.79,1)  -- 소수첫째자리 표현, 나머지 자르기
from dual;

select MOD(11,4) -- 4로 나눈 나머지
from dual;

-- 사원 들의 급여
select sal, mod(sal,2)
from emp
where mod(sal,2) = 1;


-- 문자 함수
-- concat(문자, 문자) -> '' || ''
select concat('abc','efg'), 'abc'||'efg'
from dual;

-- substr : 문자열 추출
-- substr( 문자열, 시작 위치, 길이 )
select substr('apple',1,3)
from dual;

select substr('apple',-3)
from dual;



