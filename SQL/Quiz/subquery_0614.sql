--2021.06.14
--subquery quiz

--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
select * from orders order by custid;
select * from customer;
select * from book;


--(5) 박지성이 구매한도서의 출판사수

select count(publisher)
from book
where bookid = ( select bookid
                 from customer c , orders o
                 where c.custid= o.custid and c.name = '박지성')
order by publisher;

select bookid
from customer c , orders o
where c.custid= o.custid and c.name = '박지성';

--6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이
-- 박지성: customer
-- 도서이름, 가격-> book
-- 판매가격 -> orders

select c.name, b.price, b.price-o.saleprice
from customer c, orders o, book b
where c.custid = o.custid and o.bookid = b.bookid and c.name= '박지성';

--(7) 박지성이 구매하지 않은 도서의이름
--박지성이 구매한거->orders에서 custid = 1인거 /bookid 1,3,2
--구매하지 않은거-> not in(1,2,3)

select  bookname
from book
where bookid not in(select distinct bookid
                    from orders
                    where custid = 1);


--select distinct bookid
--from orders
--where custid = 1;


--2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.

--(8) 주문하지않은 고객의 이름(부속질의사용)
--주문하지 않은: orders에 custid없다 -> not in( 주문고객 아이디)
-- 고객 이름: customer

select name
from customer
where custid  not in(select distinct custid from orders);

--select distinct custid
--from orders;

--(9) 주문금액의총액과 주문의평균금액
--주문 금액: orders
--주문의 평균금액: 주문한 사람들 평균(박세리 빠진다)

select sum(saleprice) as "TOTAL"
      
from orders;


--(10) 고객의이름과고객별구매액
--고객의 이름: customer
--구매액:sum(saleprice),orders

select *
from orders
orderby 




