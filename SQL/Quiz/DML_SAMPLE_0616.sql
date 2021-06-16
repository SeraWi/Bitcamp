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







