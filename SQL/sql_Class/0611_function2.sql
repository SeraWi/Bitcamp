--2021.06.11
--변환함수

-- 형변환 함수
-- 날짜 -> 문자, 숫자 -> 문자
-- to_char(날짜 데이터, '패턴'), to_char(숫자, '패턴')
select sysdate, to_char(sysdate,'YYYY.MM.DD. HH24:MI:SS')
from dual;
-- 결과 2021.06.11. 10:11:37

select ename, hiredate, to_char(hiredate,'YYYY.MM.DD.')
from emp;

select * from orders;
select orderid, orderdate, to_char(orderdate, 'YYYY.MM.DD.')
from orders;

-- 숫자->문자
select to_char(123456,'0000000000'), to_char(123456,'9999999999')
from dual;
--﻿결과 0000123456, 123456
select to_char(123456,'0,000,000,000'), to_char(123456,'L9,999,999,999')
from dual;

select ename, sal, to_char(sal*1100,'L999,999,999')
from emp;

-- 문자 -> 숫자
-- to_number(문자열,패턴)
select to_number('1,000,000','9,999,999'),
        to_number('1,000,000','9,999,999')+100000
from dual;

-- 문자 ->날짜
-- to_date(문자열,패턴)
select to_date('2012.05.17','YYYY.MM.DD'),trunc(sysdate- to_date('2012.05.17','YYYY.MM.DD'))/365
from dual;

--decode함수 : 분기를 위해 사용한다.switch -case 유사
--decode (컬럼, = 조건1 값, 조건1의 참일 때 사용할 값,
--               조건2 값, 조건2의 참일 때 사용할 값,
--               ...)

-- emp 테이블에서 부서번호에 맞는 부서이름을 출력한다.

select*
from dept;

 -- 10 ACCOUNTING
 -- 20 RESEARCH
 -- 30 SALES
 -- 40 OPERATIONS
 
 select ename, deptno,
        decode(deptno, 10 ,'ACCOUNTING',
                       20, 'RESEARCH',
                       30, 'SALES',
                       40,'OPERATION'
        ) as DNAME
 from emp
 order by dname;

-- 직급에 따라 급여를 인상하도록 하자
-- 직급이 'ANALYST'인 사원은 5%인상, 'SALESMAN'인 사원은 10%, 'MANAGER'인 사원은 15%
-- 'CLERK'인 사원은 20% 인상

select ename,sal,
        decode( job, 'ANALYST', sal*1.05,
                    'SALESMAN',sal*1.1,
                    'MANAGER', sal *1.15,
                    'CLERK', sal * 1.2
        ) as upsal
from emp;


