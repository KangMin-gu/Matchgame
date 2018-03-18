유저테이블
CREATE TABLE users (
num integer PRIMARY KEY AUTO_INCREMENT,
id varchar(100) UNIQUE,
pwd varchar(100),
lolid varchar(100) UNIQUE,
name varchar(20),
email varchar(100) UNIQUE,
phone varchar(30),
post varchar(20),
addr varchar(200),
detailaddr varchar(200),
regdate DATE
);