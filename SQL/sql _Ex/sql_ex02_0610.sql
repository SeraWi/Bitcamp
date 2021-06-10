--2021.06.10
--sql select 추가 문제

--select * from book;
--select * from customer;
--select * from orders;


--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.

--(1) 도서번호가 1인 도서의 이름
select bookname 
from book 
where bookid =1; 

--(2) 가격이 20,000원 이상인 도서의 이름
select bookname 
from book 
where price >= 20000;

--(3) 박지성의 총구매액(박지성의고객번호는1번으로놓고작성)
select sum(saleprice) as totalsaleprice 
from orders 
where custid = 1;

--(4) 박지성이 구매한 도서의수(박지성의고객번호는1번으로놓고작성)
select count(bookid)
from orders
where custid = 1;

--2 마당서점의 운영자와 경영자가 요구하는 다음질문에 대해SQL 문을 작성하시오.
--(1) 마당서점도서의총개수
select count(bookid)
from book;

--(2) 마당서점에 도서를 출고하는 출판사의 총개수
--
--(3) 모든고객의 이름, 주소
select name, address 
from customer;

--(4) 2014년 7월4일~7월7일 사이에 주문받은 도서의 주문번호
select orderid 
from orders 
where orderdate between '2014/07/04' and '2014/7/7';

--(5) 2014년 7월4일~7월7일사이에 주문받은 도서를 제외한 도서의 주문번호
select orderid 
from orders 
where orderdate not between '2014/07/04' and '2014/7/7';
​
--(6) 성이‘김’씨인 고객의 이름과 주소
select name, address 
from customer 
where name like '김%';

--(7) 성이 ‘김’씨이고 이름이 ‘아’로 끝나는 고객의 이름과 주소
select name, address 
from customer 
where name like '김%' and name like '%아';