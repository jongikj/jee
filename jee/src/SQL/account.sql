select * from tab;

create table account(
	account_no int primary key,  
	id varchar2(20),
	money int, 
	constraint account_member_fk foreign key (id) references member(id) on delete cascade
);

select * from account;

drop table account;

drop view account_member;

create view account_member as --view는 조회만 가능 insert.
select 
	a.account_no as account_no,
	a.money as money,
	a.id as id,
	m.pw as pw,
	m.name as name,
	m.reg_date as reg_date,
	m.ssn as ssn
from member m, account a 
where m.id = a.id;

select * from account_member;