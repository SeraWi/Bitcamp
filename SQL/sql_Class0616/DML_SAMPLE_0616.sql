--2021.06.06
--DML 퀴즈 리뷰

-- INSERT : C REATE
-- SELECT : R EAD
-- UPDATE : U PDATE
-- DELETE : D ELETE

-- INSERT : CREATE
desc phoneInfo_basic;
insert into phoneinfo_basic
values(1, 'KING', '010-0000-0000', 'king@gmail.com', 'KOREA',sysdate)
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
where 





