--用户表
create table user (
	id integer primary key autoincrement,
	phone_num char(11),
	user_name varchar(50),
	comments varchar(100));
	
insert into user(phone_num, user_name) values('13817024379', '刘林栋');
insert into user(phone_num, user_name) values('13916253764', '孟祥令');
	
--好友表
create table friend (
	id integer primary key autoincrement,
	phone_num1 char(11),
	phone_num2 char(11)
);

insert into friend(phone_num1, phone_num2) values('13817024379', '13916253764');

--位置表
create table location (
	id integer primary key autoincrement,
	phone_num char(11),
	record_time datetime,
	latitude double,
	longitude double
);