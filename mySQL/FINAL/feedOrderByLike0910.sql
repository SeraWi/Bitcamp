SELECT * FROM final.like;
-- 좋아요 갯수가 많은 순으로 정렬

select * from final.member;
select * from final.photoBoard;


select * 
from final.member as M inner join final.photoBoard as P
on  M.memberIdx = P.memberIdx;

-- 좋아요 수가 많은 순으로 boardIdx 정렬
select count(*), boardIdx
from final.like 
group by boardIdx
order by count(*) DESC;

select count(*), P.boardIdx, P.boardPhoto, P.memberIdx
from final.like as L inner join final.photoBoard as P
on L.boardIdx = P.boardIdx
group by P.boardIdx
order by count(*) DESC;

-- 인기순 정렬
select count(*), P.boardIdx, P.boardPhoto,P.boardDate, P.memberIdx, M.memberNickname
from final.like as L inner join final.photoBoard as P inner join final.member as M
on L.boardIdx = P.boardIdx and P.memberIdx = M.memberIdx
group by P.boardIdx
order by count(*) DESC, boardIdx DESC;








-- 인기순 정렬 2, count(*) 없이
select P.boardIdx, P.boardPhoto,P.boardDate, P.memberIdx, M.memberNickname
from final.like as L inner join final.photoBoard as P inner join final.member as M
on L.boardIdx = P.boardIdx and P.memberIdx = M.memberIdx
group by P.boardIdx
order by count(*) DESC; 


select B.boardIdx, B.boardPhoto, B.boardDate, M.memberIdx, M.memberNickname
from final.photoBoard as B natural join final.member as M
order by B.boardIdx DESC;




-- 인기순 0도 나오도록 정렬 0915 수정-------------------------------------------------------

-- countLike view
create view final.countLike as
select count(*) as count, boardIdx
from final.like
group by boardIdx
order by count(*) DESC;

drop view final.countLike;

-- 수정 전 정렬 count 0은 안나옴
select P.boardIdx, P.boardPhoto,P.boardDate, P.memberIdx, M.memberNickname
from final.like as L inner join final.photoBoard as P inner join final.member as M
on L.boardIdx = P.boardIdx and P.memberIdx = M.memberIdx
group by P.boardIdx
order by count(*) DESC; 

-- 인기순 정렬 0915 수정 ( view 만들고 count=0) , count 갯수도 나오게
select L.count, P.boardIdx, P.boardPhoto,P.boardDate, P.memberIdx, (select M.memberNickname from final.member as M where P.memberIdx = M.memberIdx) as memberNickname
from final.photoBoard as P left join final.countLike as L
on L.boardIdx = P.boardIdx 
order by L.count DESC; 

-- count 갯수 안나오게!
select P.boardIdx, P.boardPhoto,P.boardDate, P.memberIdx, 
(select M.memberNickname from final.member as M where P.memberIdx = M.memberIdx) as memberNickname
from final.photoBoard as P left join final.countLike as L
on L.boardIdx = P.boardIdx 
order by L.count DESC; 


