# java-fullstack-cgi
create database hr;
show databases;
use hr;
 create table users (id int auto_increment,userName varchar(255),userPassword varchar(255),primary key(id) );
 insert into hr.users (userName,userPassword) values('thulasiram.managani@cgi.com','thulasiram.managani@cgi.com');
 select * from hr.users;
 
 create table hr.orders(id int auto_increment,orderName varchar(255),orderPrice int,primary key(id) );
 insert into hr.orders (orderName,orderPrice) values
 ('Mango',200),
 ('apple',300),
('Grapes',100);

select * from hr.order;

SELECT * FROM hr.orders;

delete from orders where id=1;

update hr.orders set orderName='Grapes',orderPrice=300 where id=2 ;
