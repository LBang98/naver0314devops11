
commit; --추가된 데이타 커밋, 커밋 안할 시 추가된 데이타가 취소됌

--emp 테이블의 구조 확인
desc emp;

--전체 컬럼으로 emp 테이블 조회
select * from emp;

--ename, job 컬럼만 조회, ename의 오름차순(asc) 또는 내림차순으로 조회(desc)
select ename, job from emp order by ename asc;
select ename, job from emp order by ename desc;

commit;


select Distinct job from emp order by job asc;
select * from emp where ename = 'WARD';

--컬럼에 제목붙이
select ENAME "사 원 명", SAL "급 여" From EMP;

--여러컬럼을 합해서 하나의 컬럼으로 출력할 경우,
select '내 이름은 ' || ENAME|| '이고 직업은' ||JOB|| '입니다' "사원" from emp;

-- 예) SMITH 님의 연봉은 800만원입니다 : 제목은 "연봉"
select ENAME|| '님의 연봉은' ||SAL|| '만원입니다.' "연봉" from emp
where ENAME = 'SMITH';

--SAL 연봉이 2000~3000 사이 조회(컬럼은 ENAME,SAL)
select ENAME, SAL from emp
where SAL>= 2000 AND SAL <=3000;
--Between을 이용해서 조회할 수도 있다
select ENAME, SAL from emp
Where SAL between 2000 AND 3000;

--직업이 SALESMEN, MANAGER, CLERK  조회
select ename, job from emp
where job = 'SALESMEN' or job = 'MANAGER' or job = 'CLERK';

select ename, job from emp
where job in('SALESMEN','MANAGER','CLERK');

--MGR 이 7902, 7839, 7788 조회(컬럼은 ENAME, JOB, MGR) - IN 사용
select ename, job, mgr from emp
where mgr in(7902,7839,7788);

--MGR 이 7902, 7788, 7566 이 아닌 (Not) 사람을 조회(IN)
select ename, job, mgr from emp
where mgr not in(7902,7839,7788);

--COMM, COMM+1000 의 결과 출력
select comm, comm+1000 from emp;

--함수 중 NVL(컬럼명, 널일경우 초기값), MYSQL은 infull이다
select nvl(comm,0), nvl(comm,0)+1000 from emp; --null일 경우 0으로 출력 또는 계산

--SAL 이 2000~3000 이 아닌경우 조회, 두가지 방법으로 해보기
select ename, sal from emp where sal<2000 or sal>3000;
select ename, sal from emp where sal not between 2000 and 3000;

-- group 합수 (count, max, min, avg, sum)
select count(*) from emp;
select max(sal) from emp;
select min(sal) from emp;
select avg(sal) from emp;

--직업별 인원수와 최고연봉을 구하는데 직업별 인원수가 3명 이상인 경우만 조회
select job, count(*), MAx(Sal) AS "최고연봉" from emp
group by job
having count(job) >=3;

--오라클에서는 현재날짜를 구할때 SYSDATE,MYSQL은 NOW()
select SYSDATE from DUAL;
--3일뒤
select SYSDATE+3 from DUAL;
--30일
select SYSDATE+30 from DuAL;

--날짜타입을 문자열로 변환 TO_CHAR : 기호 Y,M,D,HH,HH24,MI,SS,AM/PM등
select TO_CHAR(SYSDATE,'YYYY') from dual;
select TO_CHAR(SYSDATE,'YEAR') from dual; --영문자로 나옴, 잘안씀

select TO_CHAR(SYSDATE,'MM') FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD HH:MI') FROM DUAL;

--EMP에서 HIREDATE(날짜타입) 를 이용해서 출력해보자
SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD') HIREDATE FROM EMP;

--고용년이 1987년인 사람 출력
SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD') FROM EMP
WHERE TO_CHAR(HIREDATE, 'YYYY') = 1987;

--고용월이 5월인 사람 출력
SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD') FROM EMP
WHERE TO_CHAR(HIREDATE,'MM') = 5;

--SUBQUERY (SELECT 문 안에 또 select 문이 있는경우)
--SCOTT 의 연봉과 같은 연봉을 갖는 사람을 구하시오
select * from emp
where sal = (select sal from emp
        where ename = 'SCOTT');
        
--평균연봉보다 많이 받는 사람의 정보를 출력
select * from emp
where sal >= (select avg(sal) from emp);

--ename 이 'A'나 'S'로 시작하는 사람의 ENAME, SAL, COMM 조회
select ENAME,SAL,COMM from emp
where ename = 'A%' or ename = 'S%';
--COMM 이 NULL 이 아닌사람마다 조회
select * from emp
where COMM is not null;
--MGR 이 7689,7566,7788 인 사람 조회 (IN)
select * from emp
where MGR in(7689,7566,7788);
--SAL 이 2500부터 3000까지 사람 조회 (AND)
select SAL from emp
where sal>=2500 AND SAL <= 3000;
--SAL 이 2500부터 3000까지 사람 조회 (AND)
select SAL from emp
where SAL between 2500 AND 3000;

--서브쿼리문제
--ALLEN 의 직업과 같은 직업을 가진 사람들을 조회하시오
select * from emp
where job = (select job from emp
                where ename = 'ALEN');
--SOCTT 의 MGR 과 같은값으로 가진 사람의 정보를 조회
select * from emp
where MGR = (select MGR from emp
                where ename = 'SCOTT');
--숫자함수, 문자함수 연습
select ABS(-5),ABS(5) from DUAL; --ABS : 절댓값
select CEIL(3.1),CEIL(3.9) from DUAL; --CELL : 무조건 올림
select FLOOR(3.1), FLOOR(3.5) from DUAL; --FLOOR : 무조건 내림
SELECT MOD(3,7), MOD(9,5) from DUAL; -- MOD: 나머지
select POWER(2,3),POWER(3,4); --POWER : 지수승

--문자함수
select CONCAT('HAPPY','DAY') from dual;
select 'HAPPY'||'DAY' from dual; --위의 결과와 같다
SELECT INITCAP('hello'),INITCAP('HAPPY') from dual; -- 첫글자만 대문자
select lower('heLLodAy'), upper('hellODay') from dual;
select lpad(sal,10,'*') from emp; -- 왼쪽으로 * 채우기
select rpad(sal,10,'*') from emp; --오른쪽으로 * 채우기
select substr('happy day',2,3) from dual; --2번 인덱스부터 3글자(첫글자 인덱스는 1) : app
select ename, length(ename) 글자수 from emp; --length : 길이, 글자수
select replace('Happy','a','*') from dual; --a를 *로 대체

select NVL(COMM,100) from emp; --null일 경우 100 출
--decode : 값에 따라 다른값을 출력할때명
select ename 사원명, deptno 부서코드, 
decode(deptno,10,'홍보부',20,'교육부',30,'인사부')부서 from emp;

--조인
-- inner join , equi join
select 
    EMP.empno, emp.ename, emp.job, dept.dname,dept.loc
from emp,dept
where emp.deptno = dept.deptno;

--방법2, 두 테이블에 공통적으로 있는 컬럼일 경우에만 앞에 테이블명을 붙이고 나머지는 생략가능
select EMPNO, ENAME, JOB, DNAME,LOC
FROM EMP,DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO;
--방법3, 테이블명이 너무 길 경우 별칭을 사용할 수 있다
SELECT
    E.NAME,ENAME, JOB, DNAME, LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO;





