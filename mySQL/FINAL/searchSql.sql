
-- 해시태그 검색
select * from final.photoBoard;
select *
from final.photoBoard
where hashtag like '#%여행%';

select P.boardIdx, P.boardPhoto, P.boardDate, M.memberIdx, M.memberNickname
from final.photoBoard as P natural join final.member as M
where hashtag like '#%c%'
order by P.boardIdx DESC;

-- 닉네임으로 검색
select memberIdx, memberNickname, memberProfile
from final.member
where memberNickname like '%s%';