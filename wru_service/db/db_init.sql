--�û���
create table user (
	id integer primary key autoincrement,
	phone_num char(11),
	user_name varchar(50),
	comments varchar(100));
	
insert into user(phone_num, user_name) values('13817024379', '���ֶ�');
insert into user(phone_num, user_name) values('13916253764', '������');
	
--���ѱ�
create table friend (
	id integer primary key autoincrement,
	phone_num1 char(11),
	phone_num2 char(11)
);

insert into friend(phone_num1, phone_num2) values('13817024379', '13916253764');

--λ�ñ�
create table location (
	id integer primary key autoincrement,
	phone_num char(11),
	record_time datetime,
	latitude double,
	longitude double
);