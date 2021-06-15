--2021.06.15
-- DDL QUIZ
--테이블 정의서를 보고 DDL을 완성해보기

--테이블 명: phoneInfo_basic/ phoneInfo_univ /phoneInfo_com

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
    
    fr_ref Number(6)
    constraint univ_ref_fk references phoneInfo_basic(idx)
);

create table phoneInfo_com(
    idx number(6) 
    constraint com_idx_pk primary key,
    
    fr_c_company varchar2(20) default 'N'
    constraint com_company_nn not null,
    
    fr_ref number(6)
    constraint com_ref_fk references phoneInfo_basic(idx)
);

drop table phoneInfo_basic;



