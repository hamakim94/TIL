# 1장_데이터베이스와 SQL





## 1강_데이터베이스

### 1.데이터베이스란?

데이터의 집합



#### 2. DB와 DBMS

DBMS

- Database Management System(**데이터베이스 관리 시스템**)
- DB를 관리하는 SW



#### 3. 데이터베이스를 조작하는 언어 SQL

RDBMS를 관리할 때 사용하는 언어



**종류**

- DML(Data Manipulation Language)
  - DB 데이터 추가, 삭제, 내용 갱신 등, 데이터를 조작할 때 사용
  - SQL의 가장 기본이 되는 명령어는 셋(set)
  - CRUD
- DDL(Data Definition Language)
  - 데이터베이스는 **데이터 베이스 객체**로 데이터를 관리
  - 객체를 만들거나 삭제하는 명령어
- DCL(Data Control Language)
  - 트렌젝션 제어
  - 데이터 접근 권한 제어



## 2강_다양한 데이터베이스

#### **1. DB 종류**

- 계층형 DB

  - 폴더나 파일 등의 계층 구조

- **관계형 DB**

  - 행과 열을 가진 표 형식 데이터로 저장
  - 엑셀과 유사한 테이블들을 다룬다.

- 객체지향 DB

  - 객체지향 언어에서 사용되는 객체 그대로를 DB에 사용하기 위함

- XML DB

  - HTML과 흡사하게 데이터를 저장하는 DB

- KVS(Key-Value Store), NoSQL

  - 키와 그와 대응되는 값만을 저장하는 DB

    

#### 2. RDBMS 사용 시스템

다양한 기기에서 사용한다. -> 클라이언트-서버구조 , 웹 시스템과 연동



#### 3.RDBMS 제품 종류

Oracle, DB2, SQL Server, PostgreSQL, MySQL, SQLite



#### 4. 방언

특정 DBMS에만 사용되는 방언같은게 있다

표준 SQL을 사용하자



## 3강_데이터베이스 서버

#### 1. 클라이언트/서버 모델

클라이언트(요청, request)와 서버(응답, response)로 구성.



**RDBMS 클라이언트 / 서버**

- **사용자 인증이 필수(ID, PW)**
- 인증 후 SQL 명령을 사용해 서버에 보낼 수 있음



#### 2. 웹 애플리케이션의 구조

웹 서버 + 데이터베이스



**CGI(Common Gateway Interface)**

- 응용 프로그램과 웹 서버 간을 연동 / 통신(예전 방식)
- cf) CGI 단점 보완하고자 Java로 웹을 구동할 수 있는 서블릿이 등장



**실제로 DB의 클라이언트는 웹 서버의 CGI가 된다.**



### 3. MySQL 서버 / mysql 클라이언트

MySQL 서비스 -> 서버

mysql 커맨드 -> 클라이언트

cf) 루프 백 접속 : 네트워크를 경유해 PC의 서버로 되돌아오는 것

