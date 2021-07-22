drop table if exists project.member;

create table project.member(
idx int auto_increment,
memberid varchar(14) not null,
password varchar(20) not null,
membername varchar(20)not null,
memberphoto varchar(30) default 'photo.png',
regdate timestamp default current_timestamp,
constraint member_idx_pk primary key(idx),
constraint member_memberid_uq unique (memberid)
);

-- select
select * from project.member;

-- insert
insert into project.member
(memberid, password, membername)
values
('cool','1111','cool');

-- update
update project.member
set
password ='0000' , membername ='tester'
where idx=1
;

-- delete
delete from project.member where idx=1;


