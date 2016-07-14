select * from member;

create table member(
	id varchar2(20) primary key,
	pw varchar2(20),
	name varchar2(20),
	reg_date varchar2(20),
	ssn varchar2(10)
);
-- CREATE
insert into member(id,pw,name,reg_date,ssn) values('lee','1','이순신','2016-07-01','800101-1');
insert into member(id,pw,name,reg_date,ssn) values('hong','1','홍길동','2015-06-01','891201-1');
insert into member(id,pw,name,reg_date,ssn) values('hong2','1','홍길동','2014-04-01','901211-1');
insert into member(id,pw,name,reg_date,ssn) values('hong3','1','홍길동','2016-04-01','880501-1');
insert into member(id,pw,name,reg_date,ssn) values('yu','1','유관순','2014-07-01','010701-1');
insert into member(id,pw,name,reg_date,ssn) values('jang','1','장종익','2014-07-05','940729-1');
-- READ
select * from MEMBER;	-- list
select * from MEMBER where id = 'hong';	-- findByPK
select * from MEMBER where name = '홍길동';	  -- findByNotPK	
select count(*) as count from MEMBER; -- count
-- UPDATE
update member set pw = '999' where id = 'yu';
-- DELETE
delete from member where id = 'null';