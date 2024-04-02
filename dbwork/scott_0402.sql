
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

--1
select job,avg(sal) as "평균급여" From emp
group by job
order by avg(sal) desc;
--2
select ename,job,mgr from emp
where job = 'MANAGER' or JOB = 'CLERK';
--3
select ename,TO_CHAR(HIREDATE,'YYYY-MM-DD'), sal from emp
where TO_CHAR(HIREDATE,'YYYY-MM-DD')between TO_CHAR('1981-01-01') and TO_CHAR('1983-12-31')
order by TO_CHAR(HIREDATE) asc;
--4
select MAX(SAL)-MIN(SAL) AS "급여 차이" from emp;
--5
select ename,job,sal from emp
where MGR in (7902,7839,7788) AND sal>=2000
order by sal desc;


--1
select ename, sal from emp
where sal >= avg(sal)
order by desc;
--2
select ename,sal from emp
where sal > (select sal from emp
                where ename = 'JAMES')
order by sal desc;
--3
select ename, deptno, sal from emp
where deptno = 30 AND sal = (select Max(sal) from emp
                                where deptno = 30);
--4
select ename,job from emp
where empno != MGR;
--5
select ename,TO_CHAR(HIREDATE,'YYYY-MM-DD'),sal from emp
where TO_CHAR(HIREDATE,'YYYY') = 1981 AND sal = (select Max(SAL) from emp
                                                 where TO_CHAR(HIREDATE,'YYYY') = 1981);


