CREATE TABLE team (
num integer primary key auto_increment,
teamname varchar(100) unique,
main varchar(100),
top varchar(100),
mid varchar(100),
bottom varchar(100),
support varchar(100),
jungle varchar(100),
win varchar(100),
lose varchar(100)
);