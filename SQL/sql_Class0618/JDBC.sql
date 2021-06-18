--2021.06.18

-- JDBC 


select
e.ename, e.ename, e.job, e.sal, d.dname,d.loc
from emp e, dept d;

----------------------------------------------------------------------------------
create table dept01
as
select * from dept where 1 =0;

select * from dept01;


-- dept01 테이블에 deptno에 입력할 일련 번호 -> SEQUENCE
create sequence dept01_deptno_seq
start with 10
increment by 10;

insert into dept01 values(dept01_deptno_seq.nextval, 'dev', 'SEOUL');
