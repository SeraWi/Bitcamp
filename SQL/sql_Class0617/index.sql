--2021.06.17

--INDEX 
-- 검색을 빠르게 하기위한 객체
-- 물리적인 저장 공간이 필요
-- 생성할 때 시간 필요
-- 많은 인덱스는 DML 작업이 많은 경우 성능 저하 발생!!!!


--emp01 테이블을 복사 -> 로우들을 계속 복사

drop table emp01;

create table emp01
as select * from emp;

insert into emp01 select * from emp01; --계속복사


insert into emp01(empno, ename) values ( 7777, 'KING');
insert into emp01(empno, ename) values ( 7777, 'SON');

select * from emp01 where ename = 'SON';

--emp01 테이블에 ename 컬럼을 index 설정

create index index_emp01_ename
on emp01(ename);












