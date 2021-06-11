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





-- 문자 -> 숫자, 문자 -> 날짜