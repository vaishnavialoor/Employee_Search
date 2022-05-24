DROP DATABASE IF EXISTS employee;
CREATE DATABASE employee;
use employee;
DROP TABLE IF EXISTS EMPLOYEE;


DROP TABLE IF EXISTS department;
CREATE TABLE department (
  dept_id    int not null, 
  dept_name    varchar(30),
  constraint pk_dept primary key (dept_id) 
);

DROP TABLE IF EXISTS location;
CREATE TABLE location (
  loc_id    int not null, 
  loc_name    varchar(30),
  constraint pk_loc primary key(loc_id) 
);

drop table  if exists employee;
CREATE TABLE EMPLOYEE (
  emp_id    int not null, 
  emp_name    varchar(30),
  emp_salary   int,
  emp_dept_id     int, 
  emp_loc_id    int ,
  emp_joining_date datetime,

  constraint pk_emp primary key (emp_id),
  constraint fkey_emp_dept foreign key (emp_dept_id) references department(dept_id),
   constraint fkey_emp_loc foreign key (emp_loc_id) references location(loc_id)
);

insert into location values ('1','Hyderabad');
insert into location values ('2','Bangalore');
insert into location values ('3','Pune');
insert into location values ('4','Mumbai');


insert into department values ('1','IT');
insert into department values ('2','Operations');
insert into department values ('3','Admin');


insert into employee values ('3201','Ramu','20000','1','2','2020-08-06');
insert into employee values ('3202','Shantha','30000','2','2','2015-07-08');
insert into employee values ('3203','Vikram','40000','3','3','2017-12-10');
insert into employee values ('3204','Balu','50000','2','1','2019-11-06');
insert into employee values ('3205','Mahesh','70000','3','1','2021-09-03');
insert into employee values ('3206','Ranjit','30000','3','4','2021-08-06');
insert into employee values ('3207','Lokesh','60000','3','4','2020-08-06');


insert into employee values ('3201','Ramu','20000','1','2');
insert into employee values ('3202','Shantha','30000','2','2');
insert into employee values ('3203','Vikram','40000','3','3');
insert into employee values ('3204','Balu','50000','2','1');
insert into employee values ('3205','Mahesh','70000','3','1');
insert into employee values ('3206','Ranjit','30000','3','4');
insert into employee values ('3207','Lokesh','60000','3','4');



select * from employee;
select * from department;
select * from location;
select * from employee where emp_salary>50000;
select * from employee e inner join location l on e.emp_loc_id=l.loc_id where loc_name='Mumbai';
select * from employee where emp_join_date >'2021-01-01';



