--2021.06.06
--DML 퀴즈 리뷰

-- INSERT : C REATE
-- SELECT : R EAD
-- UPDATE : U PDATE
-- DELETE : D ELETE
--------------------------------------------------------------------------------
create table phoneInfo_basic(
    idx number(6) 
    constraint basic_idx_pk primary key,
    
    fr_name varchar2(20) 
    constraint basic_name_nn not null,
    
    fr_phonenumber varchar2(20)
    constraint basic_phonenumber_nn not null,
    
    fr_email varchar2(20),
    fr_address varchar2(20),
    fr_regdate date default sysdate
);

create table phoneInfo_univ(
    idx number(6) 
    constraint univ_idx_pk primary key,
    
    fr_u_major varchar2(20)  default 'N'
    constraint univ_major_nn not null,
   
    fr_u_year number(1)  default 1 
    constraint univ_year_nn not null
    constraint univ_year_ck check( 0< fr_u_year  and fr_u_year <5),
    
    fr_ref Number(6)not null
    constraint univ_ref_fk references phoneInfo_basic(idx)
);

create table phoneInfo_com(
    idx number(6) 
    constraint com_idx_pk primary key,
    
    fr_c_company varchar2(20) default 'N'
    constraint com_company_nn not null,
    
    fr_ref number(6)not null -- 반드시 참조하려면 NOT NULL써야 한다.
    constraint com_ref_fk references phoneInfo_basic(idx)
);
--------------------------------------------------------------------------------
-- INSERT : CREATE
desc phoneInfo_basic;
insert into phoneinfo_basic
values(pi_idx_nextval, 'KING', '010-0000-0000', 'king@gmail.com', 'KOREA',sysdate)
;

insert into phoneinfo_basic (idx, fr_name, fr_phonenumber)
values(2,'SCOTT','010-9999-9999');


--UPDATE : UPDATE
--SCOTT 의 이메일을 업데이트, 주소도 업데이트하기
--SCOTT의 idx -> 2
update phoneInfo_basic
set fr_email= 'scott@naver.com', fr_address = '서울'
where idx = 2;
-- idx : pk

--DELETE : DELETE
delete from phoneinfo_basic
where idx = 1
;

-- SELECT : READ
select * from phoneInfo_basic;
select * from phoneinfo_basic where idx = 2;

--------------------------------------------------------------------------------
--INSERT : CREATE 
--대학친구의 정보를 입력

-- 1. basic 정보 입력
insert into phoneinfo_basic
values(3, 'SON', '010-1111-1111', 'son@gmail.com', 'KOREA',sysdate)
;
-- 2. univ정보 입력
insert into phoneinfo_univ
values(1,'COMPUTER',4,3)
;


-- SELECT : READ
select fr_name, pu.fr_u_major, pu.fr_u_year
from phoneinfo_basic pb, phoneinfo_univ pu
where pb.idx= pu.fr_ref;

--UPDATE : UPDATE 데이터 수정
-- 전공과 학년을 수정, idx 또는 외래키
update phoneinfo_univ
set fr_u_major = 'KOR', fr_u_year =4
where idx = 1;

select * from phoneinfo_univ;

--DELETe :DELETE
delete from phoneinfo_univ
where idx = 1;
delete from phoneinfo_basic
where idx = 3;


--------------------------------------------------------------------------------

-- INSERT : CREATe
insert into phoneinfo_basic
values(4, 'PARK', '010-7777-7777', 'park@gmail.com', 'LONDON', sysdate)
;
insert into phoneinfo_com
values(1, 'NAVER', 4)
;

--SELECT: READ
select fr_name, pb.fr_phonenumber, pb.fr_email, pb.fr_address, pc.fr_c_company
from phoneinfo_basic pb , phoneinfo_com pc
where pb.idx=pc.fr_ref
;

--UPDATe : UPDATE
--회사정보를 수정
update phoneinfo_com
set fr_c_company='GOOGLE'
where idx=1
;

--DELETE : DELETE
delete from phoneinfo_com
where idx=1
;
delete from phoneinfo_basic
where idx=4
;


--------------------------------------------------------------------------------
--전체 친구 정보
select * 
from phoneinfo_basic pb, phoneinfo_univ pu, phoneinfo_com pc
where pb.idx = pu.fr_ref(+) and pb.idx = pc.fr_ref(+);
--univ가 null이라도, com이 null이더라도 결과가 나오도록한다.

----------------------2016.06.17-------------------------------------------------
--대학친구, 회사친구 테이블 -> 기본키(대리키) -> sequence 생성 ->insert 개선
create sequence pi_idx_pk;
create sequence pi_u_idx_pk start with 1 increment by 1;
create sequence pi_c_idx_pk start with 1 increment by 1;













