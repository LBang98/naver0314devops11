create database bit701;

use bit701;

-- 날짜함수들
SELECT year(now()) from dual; -- 2024
select MONTH (now()) from dual; -- 4
SELECT MONTHNAME(now()) from dual; -- April 
SELECT DAYNAME(NOW()) from dual; -- Thursday 
SELECT DAYOFMONTH(now()) from dual; -- 4 :일
SELECT DATE_FORMAT(NOW(), '%Y-%M-%D') from dual; -- 2024-04-04
SELECT DATE_FORMAT(now(), '%Y-%M-%D %H:%i') from dual; -- 2024-04-04 10:08
SELECT STR_TO_DATE(20240404,'%Y%M%D') from dual; -- 숫자를 날짜타입으 변환  

-- test101
create table test01(num tinyint auto_increment primary key,
					name varchar(20), age smallint, height decimal(5,1), birthday datetime, ipsaday date);

-- insert: 일부만 추가할 경우 컬럼명 기재,전체 다 줄 경우 컬럼명 생략
insert into test01(name, age, height) values ('lee', 23, 178.9)	;
insert into test01(name,birthday,ipsaday) values('LeeMJ', '2021-12-25 12:30','2018-05-10');

-- 컬럼 생략시 num 도 값을 넣어야하는데 num은 auto이므로 그냥 null로 넣으면됌
INSERT into test01 values(null, 'kim', 29, 156.9, now(), now());
INSERT into test01 values(null, 'son', 31, 167.888, now(), now());
INSERT into test01 values(null, 'sonaaa', 21, 177.9, now(), now());
INSERT into test01 values(null, 'kimbbb', 36, 17.38, now(), now());
INSERT into test01 values(null, 'ParkNamJung', 12, 123.3, now(), now());


select * from test01;
SELECT * FROM test01 WHERE name = 'son';
SELECT * FROM test01 WHERE name like 's%'; -- s로 시작하는사
SELECT * FROM test01 WHERE name like '_i%'; -- 두번째 글자가 i 인사람

SELECT UPPER(name), height from test01; -- 이름은 대문자로
SELECT UCASE(name), height from test01; -- 이름은 대문자로

SELECT LOWER(name), height from test01; -- 이름은 소문자로
SELECT LCASE(name), height from test01; -- 이름은 소문자로

-- 오라클의 NVL 이 mysql 에서는 ifull:null 일때 대체값 지정
SELECT name, IFNULL(age, 10) , IFNULL(height, 150.5) from test01 ; 

-- 컬럼명을 변경해보자
SELECT  name "이름", IFNULL(age, 10) "나이", IFNULL(height, 150.5) "키" from test01 ; 

-- 테이블 구조수정
-- 컬럼 추가
ALTER table test01 add hp varchar(20);
-- 컬럼 추가하는데 기본값 지정
ALTER table test01 add blood varchar(4) default 'b';
-- 컬럼 타입 변경
desc test01; -- 구조확인
-- name의 길이를 20에서 30으로 변경
ALTER table test01 modify name varchar(30);

-- age 컬럼 제어
ALTER table test01 drop column age;

-- 컬럼명 변명(mysql5 은 change, mysql8은 rename column (오라클하고 같다))
-- hp -> phone 으로 변경해보자
ALTER table test01 rename column hp to phone;

-- 삭제
delete from test01 where num=5;
-- 수정
update test01 set birthday = '1990-12-12', ipsaday = now(), phone='010-2222-3333' where num=1;


-- 조회
SELECT * from test01 order by num asc;

-- 부분조회
SELECT * from test01 limit 0,3; -- 첫 데이타가 0번: 0번부터 3개 조회
SELECT * from test01 limit 3,2; -- 첫 데이타가 0번: 3번부터 2개 조회
CREATE TABLE sawon (
    num TINYINT AUTO_INCREMENT,
    name VARCHAR(20),
    score SMALLINT,
    gender VARCHAR(10),
    buseo VARCHAR(10),
    PRIMARY KEY (num),
    CONSTRAINT ck_sawon_score CHECK (score BETWEEN 0 AND 100),
    CONSTRAINT ck_sawon_gender CHECK (gender IN('여자', '남자'))
);

-- 제약조건 확인
SELECT * from information_schema.table_constraints where table_name = 'sawn';


insert into sawon values(null, '이민정', 110,'여자','홍보부'); -- 에러 발생

-- 10개 데이타 넣기
insert into sawon values(null, '이진', 56,'여자','홍보부'); 
insert into sawon values(null, '유재석', 70,'남자','인사부'); 
insert into sawon values(null, '김재동', 50,'남자','홍보부'); 
insert into sawon values(null, '박재정', 100,'남자','인사부'); 
insert into sawon values(null, '이영자', 23,'여자','홍보부'); 
insert into sawon values(null, '강호동', 25,'남자','인사부'); 

-- group 함수
select count(*) from sawon;  -- 총 인원

-- 성별: 인원수 최고점수 최저점수 평균점수를 구해보자
select gender, count(*) as '인원수', max(score) as '최고점수', min(score) as '최저점수', avg(score) as '평균점수' from sawon 
group by gender;

-- 부서별 인원수와 최고점수
select buseo 부서, count(*) 인원수, max(score) 최고점수 from sawon 
group by buseo;

-- test01 삭제
drop table test01;

create table bitclass (
   idx smallint primary key,
   class varchar(30),
   price int,
   gigan smallint);

create table stu (
   num smallint auto_increment primary key,
   name varchar(20),
   idx smallint,
   sugangday date,
   constraint stu_fk_idx foreign key(idx) references bitclass(idx));

--bitclass 에 데이타 추가
insert into bitclass values (100,'Java',110000,10);
insert into bitclass values (200,'HTML5',90000,8);
insert into bitclass values (300,'jQuery',130000,12);
insert into bitclass values (400,'Oracle',180000,20);

--stu 에 데이타 추가
insert into stu (name,idx,sugangday) values ('kim',200,now());
insert into stu (name,idx,sugangday) values ('lee',100,now());
insert into stu (name,idx,sugangday) values ('son',300,now());
insert into stu (name,idx,sugangday) values ('min',400,now());

-- join

-- join 1
select * from bitclass bc,stu where bc.idx=stu.idx;

-- join 2
select name,class,price,gigan,sugangday from bitclass bc,stu
  where bc.idx=stu.idx;

-- join 3
select name,class,price,gigan,sugangday from bitclass bc 
	inner join stu on bc.idx=stu.idx;

-- 조인 연습 2 --
create table shop (
idx smallint auto_increment primary key,
sang varchar(20));

insert into shop (sang) values ('블라우스');
insert into shop (sang) values ('티셔츠');

 select * from shop;
 
 create table cart (
 num smallint auto_increment primary key,
 name varchar(20),
 idx smallint,
 foreign key(idx) references shop(idx));

 insert into cart (name,idx) values ('lee',1);
 insert into cart (name,idx) values ('kim',3);
 
 select * from cart;
 
select * from shop,cart where shop.idx=cart.idx;

SELECT *
FROM shop
INNER JOIN cart
ON shop.idx=cart.idx;


drop table stu;
drop table bitclass;
drop table cart;
drop table shop;

show tables;

-- join 연습용 테이블 2개 생성 : on delete cascade
create table shop(
	shopnum smallint auto_increment primary key,
	sangpum varchar(30),
	price int,
	color varchar(20) default 'black');

create table cart(
	cartnum smallint auto_increment primary key,
	username varchar(20),
	shopnum smallint,
	guipday datetime,
	constraint fk_shopnum foreign key(shopnum) references shop(shopnum) on delete cascade);

-- shop에 개의 상품을 등록해보자
INSERT INTO shop (sangpum, price) values('블라우스', '12000');
INSERT into shop values(null,'레이스조끼', 31000, 'yellow');
INSERT into shop values(null,'청바지', 25000, 'red');
INSERT into shop values(null,'주름스커트', 52000, 'blue');
INSERT into shop values(null,'레이스조끼', 42000, 'green');

SELECT * from shop;

INSERT into cart values(null,'이진',3,now());
INSERT  into cart values(null,'강철수',1,now());
INSERT  into cart values(null, '유재석',4,now());
INSERT  into cart values(null,'한예슬',4,now());
INSERT  into cart values(null,'강호동',5,now());

SELECT * from cart;

-- join 3
select username, sangpum, price,color, guipday from shop
inner join cart 
on shop.shopnum = cart.shopnum;


-- 문제: 아래의 결과를 자바파일로 실행해서 출력되도록 하세요
select buseo, count(*) inwon, max(score) maxscore, ceiling(avg(score)) avgscore from sawon
group by buseo;










