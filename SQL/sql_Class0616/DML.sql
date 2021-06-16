
-- 2021.06.16

-- DML 


-- 테스트 테이블 생성
create table dept01
as
select * from dept where 1 =0; -- 구조만 가져온다.


-- 데이터 입력 : 행단위 입력
-- insert into 테이블명 (컬럼명,....) values (데이터, 데이터,....) ;
-- 입력하고자하는 컬럼과 입력데이터의 개수는 일치
-- 컬럼의 도메인과 입력데이터의 타입이 일치
-- 기본키와 같이 not null인 경우 컬럼을 생략하면 안됨

desc dept01;
select * from dept01;

-- 10번부서 개발팀 서울 위치
insert into dept01 (deptno, dname, loc) 
            values (10, '개발팀','서울'); -- 트랜잭션 진행 중 , commit 마지막에 해줘야 한다.


insert into dept01 (deptno, dname) 
            values (10, '개발팀','서울'); --에러: too many values

insert into dept01 (deptno, dname,loc) 
            values ('삼십', '개발팀','서울');-- 에러 : invalid number
            
--- '30'은 자동 형변환으로 30!!

-- 데이터 저장할 컬럼기술을 생략 가능
-- 모든 컬럼의 데이터를 입력할 때
-- values 절의 데이터의 순서 :  테이블이 생성될 때 정의된 컬럼의 순서 -> desc 테이블 명으로 순서확인 하자
desc dept01;

insert into dept01 values(20, '마케팅','부산');
insert into dept01 values( '마케팅', 20,'부산'); --순서 바뀌면 에러

select * from dept01;

--------------------------------------------------------------------------------
desc emp;
insert into emp (empno, deptno) values (7777, 60);
select * from emp;
rollback; --7777사라짐
--------------------------------------------------------------------------------
desc orders;

insert into orders (orderid, custid, bookid) values (11,6,11);
-- 에러: parent key not found

---------------------------------------------------------------------------------
-- 서브쿼리를 이용해서 데이터 입력
drop table dept02;
create table dept02
as select * from dept where 1 =0; --구조만 생성
select * from dept02;

--데이터 입력
insert into dept02 
select * from dept;
--결과 4개 행 이(가) 삽입되었습니다.(dept 데이터 들어간다.)

insert into dept02 
select * from dept02; -- 자기 자신도 가능!!
--------------------------------------------------------------------------------




