--2021.06.22

-- sale table
-- 판매 순으로 번호, 메뉴 이름, 가격, 날짜, 회원 아이디
-- 1 kim americano 4100 2021/06/22 kim1111
-- 2 kim latte     4600 2021/06/22 kim1111
-- 3 Lee americano 4100 2021/06/22 lee2222


create table sale(
  salecode integer constraint sale_pk primary key,
  sname varchar2(50) not null,
  price integer not null,
  saledate date default sysdate
);