-- guest book 계정만들기
create user 'guest'@'%' identified by '1234';

-- guest 권한 부여
grant all privileges on guestbook_db.* to 'guest'@'%';
flush privileges;

-- 데이터 베이스 생성
create database guestbook_db
			default character set utf8mb4
	collate utf8mb4_general_ci
    default encryption='n'
;
-- drop database guestbook_db;
-- 테이블 만들기
create table guestbook(
		no  integer  auto_increment  primary key,
        name varchar(80),
        password varchar(20),
        content varchar(2000),
        reg_date datetime
);

-- drop table guestbook;

insert into guestbook
values(null, '잉잉잉', '1234', '안녕하세요 반갑습니다', now());

select no
			,name
            ,password
            ,content
            ,reg_date
from guestbook;