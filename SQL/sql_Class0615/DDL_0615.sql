--2021.06.15

--DDL :데이터 정의어
-- 테이블 생성: create table
-- 테이블 수정: alter table
-- 테이블 삭제: drop table

--create table(
--          컬럼이름 타입(사이즈) 제약조건 정의,
--          ....
-- )

--create table(
--          컬럼이름 타입(사이즈),
--          ....
--          제약조건 정의, 
--          ....
-- )

-- 사원, 테이블과 유사한 구조의
-- 사원번호, 사원 이름, 급여 3개의 컬럼으로 구성된
-- emp01 테이블을 생성해 봅시다.

create table emp01(
    empno number(4), -- 사원번호
    ename varchar2(20), --사원의 이름
    sal number(6,2)
);


-- 서브 쿼리를 이용해서 기존 테이블의 구조를 복사하고 해당 튜플도 복사
create table emp02
as 
select * from emp;
select * from emp02;
-- emp에 있는 제약조건이 emp02에는 없다!
-- 내용은 모두 복사하지만 제약조건은 가져오지 않는다.

create table emp03
as
select empno, ename, sal from emp;
select * from emp03;

create table emp04
as
select * from emp where deptno = 30;
select * from emp04;

create table emp05 
as 
select * from emp where 1 = 2; -- 모든 행이 false
--즉 구조만 가져오고 내용이 없다
select * from  emp05;

-- 테이블의 변경 :  alter table
-- alter table {테이블 이름}add 
-- alter table {테이블 이름} modify
-- alter table {테이블 이름} drop

--emp01테이블에 job 컬럼을 추가해보자
alter table emp01
add(job varchar2 (9) );
desc emp01;

--emp01테이블의 job컬럼의 사이즈를 수정 9->30
alter table emp01
modify(job varchar2 (30) not null);

--emp01 테이블의 job컬럼을 삭제
alter table emp01
drop column job;

--테이블 삭제
drop table emp02;

--새로운 테이블 생성
create table emp02
as
select * from emp;

select * from emp02;

--모든 행을 삭제하는 truncate : 롤백이 안된다.
truncate table emp02; 
--결과: Table EMP02이(가) 잘렸습니다./스키마만 남아있다.

--테이블의 이름 변경 -> rename 현재 이름 to 새로운 이름
rename emp01 to test;


--------------------------------------------------------------------------------
drop table emp02;

create table emp02
as 
select empno, ename, sal, job from emp where 1=0;
desc emp02;

insert into emp02(empno, ename, sal, job) values (null,null,10000,'MANAGER');
insert into emp02 values (null,null,10000,'MANAGER');-- 생략가능

select * from emp02;


----------------------NEW-------------------------------------------------------
--NOT NULL
CREATE TABLE EMP02(
    EMPNO NUMBER(4) NOT NULL, --null값 넣으면 오류발생함(not null제약)
    ENAME VARCHAR2(20) NOT NULL,
    SAL NUMBER(6,2),-- 전체 6자리, 2자리는 소수점 아래 (도메인 제약)
    JOB VARCHAR(20));

insert into emp02(empno, ename, sal, job) values (1000,'SON',1000,'MANAGER');

SELECT * FROM EMP02;
--drop table emp02;

--------------------------------------------------------------------------------
--UNIQUE
CREATE TABLE EMP02(
    EMPNO NUMBER(4) NOT NULL unique, --중복된 데이터 들어오면 오류 발생
    ENAME VARCHAR2(20) NOT NULL,
    SAL NUMBER(6,2),-- 전체 6자리, 2자리는 소수점 아래 (도메인 제약)
    JOB VARCHAR(20));

insert into emp02(empno, ename, sal, job) values (1000,'SON',1000,'MANAGER');


--------------------------------------------------------------------------------
--primary key
CREATE TABLE EMP02(
    EMPNO NUMBER(4) primary key, -- 기본키: not Null_+ unique
    ENAME VARCHAR2(20) NOT NULL,
    SAL NUMBER(6,2),
    JOB VARCHAR(20));

desc emp02;
-------------------------------------------------------------------------------------
-- check/ default
CREATE TABLE EMP02(
    EMPNO NUMBER(4) primary key,
    ENAME VARCHAR2(20) NOT NULL,
    SAL NUMBER(6,2) check( sal > 500 and sal <5000), -- check: 범위 지정-> 오류 발생
    JOB VARCHAR(20) default '미지정' -- job을 입력하지 않으면 미지정으로 입력된다.
    );
    
insert into emp02(empno, ename, sal, job) values (1000,'SON',3000,'MANAGER');
insert into emp02(empno, ename, sal) values (2000,'S',3000); -- 미지정으로 입력된다.

-------------------------------------------------------------------------------
-- 외래키
CREATE TABLE EMP02(
    EMPNO NUMBER(4) primary key,
    ENAME VARCHAR2(20) NOT NULL,
    SAL NUMBER(6,2) check( sal > 500 and sal <5000),
    JOB VARCHAR(20) default '미지정',
    deptno number references dept(deptno) -- dept를 참조: references 참조테이블이름(컬럼=pk)
    );
desc dept; 

insert into emp02(empno, ename, sal, job, deptno)
values (2000,'SON',3000,'MANAGER',50); -- 에러  parent key not found

insert into emp02(empno, ename, sal, job, deptno)
         values (2000,'SON',3000,'MANAGER',40);

select * from emp02;
----------------------------------------------------------------------------------
--컬럼 레벨에서 제약 사항 정의
CREATE TABLE EMP02(
    EMPNO NUMBER(4)constraint emp02_empno_pk primary key, 
    ENAME VARCHAR2(20) constraint emp02_ename_nn NOT NULL,
    SAL NUMBER(6,2) constraint emp02_sal_ck check( sal > 500 and sal <5000),
    JOB VARCHAR(20) default '미지정',
    deptno number constraint emp02_deptno_fk references dept(deptno) 
    );
insert into emp02(empno, ename, sal, job, deptno)
         values (1000,'SON',3000,'MANAGER',40);
--------------------------------------------------------------------------------------
--테이블 레벨에서 제약 사항 정의
CREATE TABLE EMP03(
    EMPNO NUMBER(4),--constraint emp02_empno_pk primary key, 
    ENAME VARCHAR2(20)  constraint emp03_ename_nn NOT NULL,--NOT NULL 제약은 컬럼레벨에서만 정의 가능
    SAL NUMBER(6,2) constraint emp03_sal_ck check( sal > 500 and sal <5000),
    JOB VARCHAR(20) default '미지정',
    deptno number,-- constraint emp02_deptno_fk references dept(deptno),
    -------------------------------------------------------------------
    --제약 정의
    constraint emp03_empno_pk primary key(empno),-- PK 제약
    constraint emp03_deptno_fk foreign key(deptno) references dept(deptno)
 );
 
drop table emp03;