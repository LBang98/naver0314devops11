-- 계정 생성(system 에서만 가능)
create user angel identified by a1234;
-- 최신버전에서는 앞에 공통문자 c##을 붙여서 계정생성을 해야만 한다
create user c##angel identified by a1234;
--system 계정에 생성된 계정 확인하기
select username from dba_user;
--c##angel 계정 삭제하기
drop user c##angel;
--c## 공통문자를 안붙이고 계정생성을 하려면 세션변경을 해야만 한다
alter session set "_ORACLE_SCRIPT"=true;
--angel 계정을 생성해보자(비번은 a1234)
create user angel identified by a1234;
--angel 계정에 기본권한을 주자(connect(연결), resource(테이블생성)
grant connect,resource to angel;
--scott/tiger 계정에 비번으로 user 를 생성 후 기본권한을 추가해주세요
create user scott identified by tiger;
grant connect,resource to scott;

alter user angel default tablespace users quota unlimited on users;
alter user scott default tablespace users quota unlimited on users;
됨
commit; --추가된 데이타 커밋, 커밋 안할 시 추가된 데이타가 취소됌

--emp 테이블의 구조 확인
desc emp;


