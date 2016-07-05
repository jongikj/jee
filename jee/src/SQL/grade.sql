create sequence seq increment by 1 start with 1000 nocycle;

drop table grade;

create table grade(
	seq number constraint grade_pk primary key,
	grade varchar2(1),
	java number,
	sql number,
	html number,
	javascript number,
	id varchar2(20), --member.sql의 id와 연동. 자료형, 글자수가 동일해야된다. 맨뒤로 보내준다
	constraint grade_member_fk foreign key (id) references member(id) on delete cascade --fk선언
--               변수명                      grade의 id            member의 id
);

alter table grade add exam_date varchar2(10);

--CREATE
insert into grade(
	seq, grade, java, sql, html, javascript, id, exam_date
)values(
	seq.nextval, 'C', 75, 78, 72, 70, 'hong', '2016-06'
);

--READ : list
select * from grade;

--READ : findByPK 중복이 불가능한 PK
select * from grade where seq = 1000;

--READ : findByID 중복이 가능한 FK
select * from grade where id = 'hong';

--READE : count
select count(*) from grade where exam_date = '2016-06';

--UPDATE : update
update grade set exam_date = '2016-05', java = 77 where seq = 1000;

--DELETE : delete
delete from grade where seq = 1007;

select count(*) as count from grade where exam_date = '2016-06';