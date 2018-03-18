CREATE TABLE facing (
num integer primary key auto_increment,
who VARCHAR (100),
witer VARCHAR(100),
title VARCHAR(100),
content VARCHAR(100),
view VARCHAR(20) DEFAULT 'N',
regdate date
);