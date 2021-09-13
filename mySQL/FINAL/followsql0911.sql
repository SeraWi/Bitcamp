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
from (select * from final.follow where memberIdx2=1) as F1 left join (select * from final.follow where memberIdx=12) as F2 inner join Final.member as M
on   F1. memberIdx = F2.memberIdx2;


