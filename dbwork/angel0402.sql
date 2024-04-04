--시퀀스 생성
--기본 1부터 1씩 증가하는 시퀀스는 생략하고 기본명령어만 주면됌
CREATE SEQUENCE SEQ1;
--전체 시퀀스 조회
select * from seq;

--다음 시퀀스값 발생: nextval
select seq1.nextval from dual; --1씩 증가된 값이 발생한다

--10부터 5씩 증가하는 시퀀스를 생성해보자, 캐쉬가 기본20인데 없애보자
create sequence seq2 start with 10 increment by 5 nocache;
--seq2 값으로 발생시켜보
select seq2.nextval from dual;

--1부터 3씩 증가, 캐쉬0 맥스 100
create sequence seq3 start with 1 increment by 3 nocache maxvalue 100;
select seq3.nextval from dual;

drop sequence seql;
drop sequence seq1;
drop sequence seq2;
drop sequence seq3;

--최종 테이블에서 사용할 시퀀스 생성 (1부터 1씩 증가(생략), cache 0)
create sequence seq_text nocache;

create table hello
( idx varchar(10), irum varchar(40));

insert into hello values(seq_text.nextval, 'lee');

select * from hello;

alter table hello add blood varchar2(5);

insert into hello values(seq_text.nextval, 'lee', 'A');

update hello
set blood = 'B'
where idx = 2;

update hello
set irum = 'do', blood = 'A'
where idx = 1;


drop table hello;


create table student(
    num number(3) constraint pk_num primary key,
    stuname  varchar2(20) constraint nn_name not null,
    score number(3) constraint ck_score check(score >=1 and score <= 100),
    birthday date);

    
drop table student;
drop table hello;
    
    
    
    
    
    
    
    
    




