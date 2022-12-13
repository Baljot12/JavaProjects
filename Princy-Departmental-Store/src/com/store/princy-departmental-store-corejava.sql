create database depart_store;
use depart_store;
create table product
(
productid int  primary key  auto_increment not null,
productName varchar(100) not null unique,
sellingPrice decimal(7,2),
availableQuantity decimal (5,2)
);
alter table product modify availableQuantity decimal (7,2);
show databases;
#FOREIGN KEY (PersonID) REFERENCES Persons(PersonID)
select * from  product;
select * from product order by sellingPrice;
create table item
(
itemname varchar(100) primary key,
category varchar(100) not null,
buyingPrice decimal(7,2) ,
FOREIGN KEY (itemname) REFERENCES  product(productName)
);
select * from item;       
delete from product where productName ="notebook";      
insert into product values(1,"da",100,1000);   
insert into item values("da","set",1200);   
delete from item where itemname ="notebook";   
#delete 3 4 5
select sum(availableQuantity) from product;
select sum(buyingPrice) from item;
select product.availableQuantity ,item.buyingPrice, (availableQuantity*buyingPrice) from product inner join item on product.productName = item.itemname;
create table user
(
uid int primary key auto_increment ,
userName varchar(100) ,
emailId varchar(100) unique,
password varchar(100),
supercoins int default 100
);
select * from user;