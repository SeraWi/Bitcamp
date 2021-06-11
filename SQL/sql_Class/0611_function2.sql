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





