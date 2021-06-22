--2021.06.22

-- sale table
-- 판매 순으로 번호, 메뉴 이름, 가격, 날짜, 회원 아이디
-- 1 kim americano 4100 2021/06/22 kim1111
-- 2 kim latte     4600 2021/06/22 kim1111
-- 3 Lee americano 4100 2021/06/22 lee2222
create table member (
--memcode뭔지...id+가입일??
memcode integer constraint mem_PK primary key,
name varchar2(50) not null,
id varchar2(50) unique not null,
pw varchar2(50) not null,
address varchar2(255),
phone varchar2(30) not null,
point number(10,2)default 0
);

desc member;
select * from member;
drop table member;

create sequence member_memcode_seq
start with 1;

insert into member(memcode, name, id, pw, address, phone) 
values(member_memcode_seq.nextval, 'son','son1234','son1234','Korea','01000000000');

insert into member(memcode, name, id, pw, address, phone) 
values(member_memcode_seq.nextval, 'kim','kim1234','kim1234','Korea','01000000000');

insert into member(memcode, name, id, pw, address, phone) 
values(member_memcode_seq.nextval, 'lee','lee1234','lee1234','Korea','01000000000');

rollback;

---------------------------------------------------------------------------------
create table sale (
salecode varchar2(50) constraint sale_PK primary key,
sname varchar2(50) not null,
price integer not null,
saledate date default sysdate,
memcode integer constraint sale_FK references member(memcode)
);
-- salecode
desc sale;
-- salecode 에 seqeunce넣기
create sequence sale_salecode_seq
start with 1;
drop table sale;

insert into sale (salecode, sname, price,memcode)
values(sale_salecode_seq.nextval, 'americano', 4100,1);

insert into sale(salecode, sname, price,memcode)
values (sale_salecode_seq.nextval, 'latte', 4600,2);

select * from sale;
commit;


-------------------------------------------------------------------------------
