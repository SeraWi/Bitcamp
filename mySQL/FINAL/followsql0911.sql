select * from final.follow;

insert into final.follow
(memberIdx,memberIdx2)
values(11,1);

-- 1을 팔로우 하는 사람 12 , 17
select *
from final.follow
where memberIdx2 =1;

-- 내가 팔로우 하는 사람(나=12) 1,2,3,4,5
select * 
from final.follow
where memberIdx =12;

-- 남을 팔로워하는 사람 중에 내가 팔로우 하는지 안하는지 확인
select F1.memberIdx as '남의 팔로워리스트',F2.memberIdx as '내가 팔로우하는지'
from (select * from final.follow where memberIdx2=1) as F1 left join (select * from final.follow where memberIdx=12) as F2
on   F1. memberIdx = F2.memberIdx2;

select *
from (select * from final.follow where memberIdx2=1) as F1 left join (select * from final.follow where memberIdx=12) as F2 
on   F1. memberIdx = F2.memberIdx2; 


-- 완성, 닉네임도 같이! 남의 팔로워 명단 중에 내가 팔로워 하는지 안 하는지 (null이면 내가 팔로우 하지 않는 상태)
select F1.memberIdx as'남을 팔로우하는 사람들', F1.memberIdx2 as '남',
	(select memberNickname  from final.member as M where M.memberIdx = F1.memberIdx) as '닉네임', 
	(select memberProfile from final.member as M where M.memberIdx= F1.memberIdx) as '프로필 사진',
    F2.memberIdx as '내 idx', 
    F2.memberIdx2 as '내가 팔로우하는지 확인'
from (select * from final.follow where memberIdx2=1) as F1 left join (select * from final.follow where memberIdx=12) as F2 
on   F1. memberIdx = F2.memberIdx2;

-- 남을 팔로우하는 명단에 내 아이디가 있을 때...-> 나도 팔로우 하는 중인지 아닌지
-- 나는 나를 팔로우 하지 않는다. 상태를 없이..

-- F1: memberIdx 남을 팔로워하는 사람 idx, memberIdx2 : 남 idx
-- F2: memberIdx 나의 idx, memberIdx2 : f1의 memberIdx2 에 매칭되는 idx, 내가 팔로우하면 값이 나오고 없으면 null 
-- 받아야 하는 값, 나의 memberIdx , 남의 memberIdx
-- 결과 : f1.memberIdx, f1.memberNickname, f1. memberProfile, f2.meberIdx2

select * 
from final.member
where memberIdx =14;




