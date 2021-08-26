-- 회원 정보
select * from final.member;

-- insert 
insert into final.member
(memberId, memberPw, memberName,memberEmail, memberNickname)
values
('cool','1234','cool','cool@naver.com','cool1234');
insert into final.member
(memberId, memberPw, memberName,memberEmail, memberNickname)
values
('sera','1234','SeraWi','sera@naver.com','sera1234');
insert into final.member
(memberId, memberPw, memberName,memberEmail, memberNickname)
values
('son','1111','손흥민','son@naver.com','son');

-- 사진 피드
select * from final.photoboard;

insert into final.photoboard
(boardPhoto, boardDiscription, hashtag, memberIdx)
values
('default.jpg', '아름다운 북한산!!', '#등산 #오를래 #북한산 #둘레길', 1);

insert into final.photoboard
(boardPhoto, boardDiscription, hashtag, memberIdx)
values
('default2.jpg', '주말 설악산 등산', '#등산 #오를래 #설악산 #속초여행', 1);


insert into final.photoboard
(boardPhoto, boardDiscription, hashtag, memberIdx)
values
('picture.jpg', '남산~!~!', '#남산', 3);

insert into final.photoboard
(boardPhoto, boardDiscription, hashtag, memberIdx)
values
('beautiful.jpg', '주말 등산,친구들과!', '#부산여행 #황령산', 4);


-- member와 사진 게시판 조인
select * 
from final. member natural join final.photoboard;

-- 내가 올린 피드 사진만
select boardPhoto, memberName, memberId
from final.member natural join final.photoboard
where memberIdx = 3;

-- 나의 게시물 개수
select count(*)
from final.photoboard
where memberIdx =4;


-- 크루
SELECT * FROM final.crew;
-- 크루 생성
insert into final.crew
(crewName,crewPhoto,crewDiscription,crewTag, memberIdx)
values
('함께오를래','with.jpg','우리 같이 등산해요!', '#서울 #등산크루 #주말등산',1);

insert into final.crew
(crewName,crewPhoto,crewDiscription,crewTag, memberIdx)
values
('hiking together','2030.jpg','오르자!', '#북한산 #등산 #매주토요일',4);


-- crew와 member 조인 -->크루장 정보 + crew 정보
select * 
from final.member natural join final.crew;

-- 크루 가입하기
select * from final.crewReg;

-- sera 가 1번 크루에 가입
insert into final.crewReg
(memberIdx,crewIdx)
values(3,1);
insert into final.crewReg
(memberIdx,crewIdx)
values(3,2);

insert into final.crewReg
(memberIdx,crewIdx)
values(1,1);

insert into final.crewReg
(memberIdx,crewIdx)
values(4,2);

insert into final.crewReg
(memberIdx,crewIdx)
values(4,1);


-- 내가 가입한 크루 보기
-- member와 crewReg. crew natural join

-- 일단 내가 가입한 crewidx찾고
select crewIdx, memberName
from final.member natural join final.crewReg
where memberIdx =3;

-- crwidx에 해당하는 정보를 찾음
select * 
from final.crew
where crewIdx in ( select crewIdx from final.member natural join final.crewReg where memberIdx = 4);


-- 좋아요 table
select * from final.like;
select * from final.photoboard;

-- 좋아요 눌렀을 때 --> insert
insert into final.like
(memberIdx,boardIdx)
values(1,1);

insert into final.like
(memberIdx,boardIdx)
values(1,2);

insert into final.like
(memberIdx,boardIdx)
values(3,2);

insert into final.like
(memberIdx,boardIdx)
values(4,5);

insert into final.like
(memberIdx,boardIdx)
values(4,1);


-- 내가 좋아요 한 게시물
select memberIdx, boardIdx
from final.like
where memberIdx =4;

-- 내가 좋아요 한 게시물의 사진찾기
-- 게시물번호가 같은걸로 join
select final.like.memberIdx as '내 아이디', boardPhoto as'좋아요한 사진', final.photoboard.memberIdx as'내가 좋아요 누른 사람 아이디'
from final.like inner join final.photoboard
where final.like.boardIdx = final.photoboard.boardIdx
and final.like.memberIdx =4;

-- 팔로우 팔로잉 관계
select * from final.follow;

-- 내가 팔로우한 사람 :팔로잉
-- 나를 팔로우한 사람 : 팔로워

-- cool(1) 이 sera(3)을 팔로우

insert into final.follow
(memberIdx, memberIdx2)
values(1,3);

-- cool(1) 이 son(4)을 팔로우
insert into final.follow
(memberIdx, memberIdx2)
values(1,4);

-- son(4)가 cool(1)을 팔로우
insert into final.follow
(memberIdx, memberIdx2)
values(4,1);


-- cool이 팔로우 하는 사람
select * 
from final.follow
where memberIdx =1;

-- cool이 팔로잉 하는 사람
select *
from final.follow
where memberIdx2 = 1;

-- cool 1이 팔로잉하는 sera 3을 팔로우 취소하기
delete 
from final.follow
where memberIdx2 = 3;


-- 사진 피드 크게 보기 했을 때 정보 


















