--2021.06.14
--subquery quiz

--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.

--select * from orders ;
--select * from customer;
--select * from book;

--(5) 박지성이 구매한도서의 출판사수

select count(publisher)
from book
where bookid in ( select bookid
                  from customer c , orders o
                  where c.custid= o.custid and c.name = '박지성')
order by publisher;



--6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이
-- 박지성: customer
-- 도서이름, 가격-> book
-- 판매가격 -> orders

--풀이1
select c.name, b.price, b.price-o.saleprice as pricegap
from customer c, orders o, book b
where c.custid = o.custid and o.bookid = b.bookid 
      and c.name= '박지성';
      
-- 풀이 2, NATURAL JOIN
select name, price, price - saleprice as pricegap
from customer natural join orders natural join book
where name = '박지성';

--(7) 박지성이 구매하지 않은 도서의 이름
--박지성이 구매한거->orders에서 custid = 1인거 /bookid 1,3,2
--구매하지 않은거-> not in(1,2,3)


--박지성 검색
select custid
from customer
where name ='박지성';

--박지성이 구매한 book id
select distinct bookid
from orders
where custid = (select custid
                from customer
                where name = '박지성');

--풀이:
select bookname
from book
where bookid not in(select distinct bookid
                    from orders
                    where custid = (select custid
                                    from customer
                                    where name ='박지성'));

--2 마당서점의 운영자와 경영자가 요구하는 다음 질문에 대해 SQL 문을 작성하시오.

--(8) 주문하지 않은 고객의 이름(부속질의사용)
-- 주문하지 않은 : not in( 주문한 고객 아이디)
-- 고객 이름: customer

--주문한 고객 아이디
select distinct custid
from orders;

--답
select name
from customer
where custid  not in(select distinct custid from orders);


--(9) 주문 금액의 총액과 주문의 평균금액

select sum(saleprice) as TOTAL, avg(saleprice) 
from orders;

--(10) 고객의 이름과 고객별 구매액
--고객의 이름: customer table
--구매액:sum(saleprice), orders table


select (select name 
        from customer c 
        where c.custid = o.custid)as "NAME",
        sum(saleprice)
from orders o
group by custid; 


--(11) 고객의 이름과 고객이 구매한 도서목록
-- 고객 이름: name, customer
-- 도서 목록: bookname, book 
-- 구매: order

--풀이1:
select c.name, b.bookname
from customer c, orders o, book b
where c.custid = o.custid  and o.bookid = b.bookid
order by c.name;

--풀이2,NATURAL JOIN
select name, bookname
from customer natural join orders natural join book;

--(12) 도서의 가격(Book 테이블)과 판매 가격(Orders 테이블)의 차이가 가장 많은 주문

-- 최대 가격 차이(절대값)
select  max(abs(o.saleprice- b.price))
from orders o, book b
where b.bookid = o.bookid;

--풀이1:
select *
from orders o, book b 
where b.bookid = o.bookid
and abs(o.saleprice - b.price) =  (select max(abs(o2.saleprice- b2.price))
                                   from orders o2, book b2
                                   where o2.bookid = b2.bookid);

--풀이2, NATURAL JOIN
select *
from orders natural join book
where abs(saleprice - price) = (select max(abs(saleprice - price))
                                from orders natural join book);
                               




--(13) 도서의 판매액 평균보다 자신의 구매액 평균이 더 높은 고객의 이름

-- 도서의 판매액 평균
select avg(saleprice)
from orders;
-- 11800

--고객별 구매액 평균
select custid, avg(saleprice)
from orders o
group by custid;

-- 고객의 구매액 평균 > 도서의 판매액 평균
--select c.name, avg(saleprice)
--from orders o, customer c
--where o.custid = c.custid
--having avg(saleprice) > (select avg(saleprice) from orders) -- 11800
--group by c.name;

--select c.name, avg(saleprice)
--from orders o, customer c
---where o.custid = c.custid
--group by c.name;


-- 답
select c.name
from orders o, customer c
where o.custid = c.custid
having avg(o.saleprice) > (select avg(saleprice) from orders) -- 11800
group by c.name;


--3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.

--(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 
--    도서를 구매한 고객의 이름

--박지성이 구매한 도서 book id = 1,2,3
select bookid
from orders natural join customer
where name ='박지성';

--박지성이 구매한 도서의 출판사(3군데)
select distinct publisher
from book
where bookid in (select bookid from orders where custid = 1);


--select *
--from book b, customer c, orders o
--where publisher in (박지성 구매 출판사)
--and  b.bookid = o.bookid and c.custid = o.custid
--and c.name != '박지성';

--풀이1
select name
from book b, customer c, orders o
where b.bookid = o.bookid and c.custid = o.custid AND c.name != '박지성'
     and publisher in ( select distinct publisher
                        from book
                        where bookid in(select bookid 
                                        from orders natural join customer
                                        where name ='박지성'));
                        
--풀이2 NATURAL JOIN
select name
from book natural join customer natural join orders
where name != '박지성'
      and publisher in( select distinct publisher
                    from book
                    where bookid in(select bookid 
                                     from orders natural join customer
                                     where name ='박지성'));



--(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름 

-- 고객 이름과 구매한 도서의 출판사 수(서로다른)
select c.name, count(distinct b.publisher)as "출판사수"
from customer c, orders o, book b
where c.custid = o.custid and b.bookid  = o.bookid
group by c.name;
--natural join
select name, count(distinct publisher)
from customer natural join orders natural join book
group by name;


-- 풀이1(inline view이용)
select name
from (select c.name, count(distinct b.publisher)as "출판사수"
      from customer c, orders o, book b
      where c.custid = o.custid and b.bookid  = o.bookid
      group by c.name)
where 출판사수 >= 2;

--풀이1- natral join으로 
select name
from (select name, count(distinct publisher) as "출판사수"
      from customer natural join orders natural join book
      group by name)
where 출판사수 >= 2;

--풀이2: 


