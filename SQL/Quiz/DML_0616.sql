--2021.06.16

-- DML
-- 앞에서 생성한 전봐번호부 테이블을 기준으로 DML을 작성해봅시다.

--1. phoneInfo_basic 테이블의 select, update, delete, insert하는 sql
desc phoneInfo_basic;
select * from phoneInfo_basic;
drop table phoneInfo_basic;
delete from phoneInfo_basic;

-- INSERT

desc phoneInfo_basic;
insert into phoneInfo_basic (idx, fr_name,FR_PHONENUMBER,FR_EMAIL,FR_ADDRESS,FR_REGDATE)
                values      (1111, 'KIM', '010-1111-1111', 'KIM1111', 'SEOUL', '2015/05/05'); -- 모든 데이터 입력
insert into phoneInfo_basic (idx, fr_name,FR_PHONENUMBER,FR_EMAIL,FR_ADDRESS)
                values      (2222, 'PARK', '010-2222-2222', 'PARK2222', 'BUSAN');--FR_REGDATE,입력하지 않으면 default로 sysdate 
insert into phoneInfo_basic (idx, fr_name,FR_PHONENUMBER,FR_EMAIL,FR_ADDRESS)
                values      (3333, 'LEE', '010-3333-3333', 'LEE3333', 'NEW YORK');
insert into phoneInfo_basic (idx, fr_name,FR_PHONENUMBER,FR_EMAIL,FR_ADDRESS)
                values      (4444, 'LEE', '010-4444-4444', 'LEE3333', 'ULSAN');
insert into phoneInfo_basic (idx, fr_name,FR_PHONENUMBER,FR_EMAIL,FR_ADDRESS)
                values      (5555, 'TOM', '010-5555-5555', 'TOM5555', 'LONDON');
insert into phoneInfo_basic (idx, fr_name,FR_PHONENUMBER,FR_EMAIL,FR_ADDRESS)
                values      (6666, 'LEA', '010-6666-6666', 'LEA6666', 'NEW YORK');
                

--UPDATE
-- KIM의 ADDRESS를 SEOUL에서 BUSAN으로 변경하기

update  phoneInfo_basic
set FR_ADDRESS = 'BUSAN'
where fr_name = 'KIM';

--DELETE
-- idx가 3333인 LEE를 삭제하기,
delete from phoneInfo_basic
where fr_name = 'LEE' and idx = 3333;

--SELECT
--이름과 전화번호만 볼 수 있는 table 보기

create table Basic_Info
as
select  fr_name, FR_PHONENUMBER from phoneInfo_basic;

select * from Basic_Info;
drop table Basic_Info;
---------------------------------------------------------------------------------
-- 2. phoneInfo_univ 테이블의 select, update, delete, insert하는 sql

--INSERT
desc phoneInfo_univ;

insert into  phoneInfo_univ (idx, FR_U_MAJOR,FR_U_YEAR,FR_REF )
                  values    (1, 'English', 2 , 1111);
insert into  phoneInfo_univ (idx, FR_U_MAJOR,FR_U_YEAR,FR_REF )
                  values    (2, 'Business', 4 , 2222;
insert into  phoneInfo_univ (idx, FR_U_MAJOR,FR_U_YEAR,FR_REF )
                  values    (3, 'Music', 3 , 3333); --에러: parent key not found, 위에서 LEE 3333 delete 해서 에러
insert into  phoneInfo_univ (idx, FR_U_MAJOR,FR_U_YEAR,FR_REF )
                  values    (4, 'ART', 1 ,4444);
                  
select * from phoneInfo_univ ;

--UPDATE
-- idx= 1학생이 전공을 Business로 바꿈
update phoneInfo_univ
set FR_U_MAJOR = 'Business'
where idx = 1;

--DELETE
-- idx가 4인 학생 삭제하기
delete from phoneInfo_univ
where idx = 4;

--SELECT
-- 학생 id와 전공만 볼 수 있는 새로운 테이블 보기
create table Univ_basicInfo
as
select idx, FR_U_MAJOR from phoneInfo_univ;

select * from Univ_basicInfo;
drop table Univ_basicInfo;

--------------------------------------------------------------------------------
--3. phoneinfo_com 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL
desc phoneInfo_Com;
drop table PhoneInfo_Com;
--Insert
insert into phoneInfo_Com (IDX,FR_C_COMPANY,FR_REF)
            values        (1, 'GOOGLE',5555);

insert into phoneInfo_Com (IDX,FR_C_COMPANY,FR_REF)
            values        (2, 'GOOGLE',6666);
            
select * from phoneInfo_Com;

--Update
-- idx 1의 직장을 SAMSUNG으로 바꾼다
update phoneInfo_Com
set FR_C_COMPANY = 'SAMSUNG'
where idx = 1;

--DELETE
--idx GOOGLE에 다니는 회사원을 삭제한다.
delete from phoneInfo_com
where FR_C_COMPANY = 'GOOGLE';

-- SELECT
-- 테이블 조인해서 보기, 대학친구의 모든 정보보기
select *
from phoneInfo_basic b, phoneInfo_univ u
where b.idx = u.fr_ref;


