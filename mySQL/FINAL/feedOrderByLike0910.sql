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


-- ----------------------------------------
-- 해시태그 검색
select * from final.photoBoard;
select *
from final.photoBoard
where hashtag like '#%여행%';

select P.boardIdx, P.boardPhoto, P.boardDate, M.memberIdx, M.memberNickname
from final.photoBoard as P natural join final.member as M
where hashtag like '#%c%'
order by P.boardIdx DESC;


-- -----------------------------------------------
-- 닉네임으로 검색
select memberIdx, memberNickname, memberProfile
from final.member
where memberNickname like '%s%';



