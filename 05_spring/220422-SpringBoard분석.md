## SpringBoard분석

### 1. sql 자료구조 분석

~~~sql
CREATE TABLE board (
	id INT AUTO_INCREMENT UNIQUE, #id는 게시판 고유번호, 유니크, 0 넣으면 알아서 증가
    writer VARCHAR(30) NOT NULL, # writer : 작성자
    title VARCHAR(200) NOT NULL, # 제목
    content TEXT,                # 내용
    view_cnt INT DEFAULT 0,      # 조회수. 나중에 상세보기하면 1증가, 수정하면 아니야
    reg_date TIMESTAMP DEFAULT now(), #현재 시간이 default로 돼, 읽을 때 date로..
    file_name VARCHAR(50),       # 파일 이름, 같은 파일이 있으면 어떻게?
    file_uri VARCHAR(500),       # 같은 이름이여도 uri 경로가 다르면 okay - UUID 활용!!
    PRIMARY KEY (id)
);

# User 라는 클래스를 받으면 결국 안에 seq있으니까 이를 활용할 수 있다고!
CREATE TABLE b_user (
    seq INT AUTO_INCREMENT,         # sequence, 그냥 고유키 번호
    id VARCHAR(30) NOT NULL UNIQUE,  # id : 유저 아이디, 고유해야함
    pw VARCHAR(64) NOT NULL,         # pw : 비밀번호, 그냥저장하면 위험, 
    								 #    Hash함수의 결과인 비둘기집을 등록!
    username VARCHAR(30) NOT NULL,   # 사용자 이름
    PRIMARY KEY(seq) 
);
~~~

---

### 2. DTO 분석

DTO는 sql 데이터를 담을 자료구조, 변수명을 정말 조심하자.

- Board.java

  변수명 : id, writer, title, content, viewCnt, regDate, fileName, fileUri

  viewCnt, regDate, fileName, fileUri가 다 다르네 ? -> mapper에서  resultMap을 등록하여 반환받자.

  

- User.java

  변수명 : seq, id, pw, username

  여긴 다른거 없으니 편하게 들어가자

---

### 3. DAO 분석 - mapper 분석

DAO는 DB에 직접 왔다갔다'만' 하는 인터페이스(매퍼를 통해 메또드 구현), 

#### 3.1 BoardDao

#### 3.2 UserDao

---

### 4. Spring settings 분석

### 5. Service 분석

---

### 6.View.jsp들 분석

### 7.Controller 분석