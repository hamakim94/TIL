# JIRA 및 JQL 사용법

## 1. Why JIRA?

### 1-1. Issue Traking(Project Management)

- TODO
- status라는 column 에서, 어떻게 생성 / 진행 / 완료 이런걸 하나씩 할 수 있습니다.

- Project Management
  - DashBoard 

---

### 1-2. Agile(형용사다)

- 개인과 상호작용
- 작동하는 소프트웨어
- 고객과의 협력
- 변화에 대응

#### SCRUM vs KANBAN

- SCRUM 

  - Sprint(기장) : 2~3주의 기간동안 할 일을 백로그라는 곳에 다 담아둔다.

  - 일 다 끝나면

  - 다시 Sprint 하자

- SCRUM MEETING(15분) : 빠르게 끝내고 일 하러가자(공유)

  - 내가 하는 일이 뭔지, 어떤지, 
  - Standing Meeting (서서 하거나, 플랭크 미팅 등) 빠르게 끝내고 싶다!

KANBAN

- Sprint가 따로 없고 전체 프로젝트 Issue 상태 관리만 한다..

---

### 1-3. DevOps

개발-운영의 악순환

운영 시스템 사고 발생 => 개발팀이 운영팀에 이야기해주지 않았다 => 운영팀은 항상 No라고 하기 때문이다 

=> 운영 시스템 사고 발생.

-  DevOps => 개발과 운영을 합치자!
  - 반복적인 작업들을 Tool을 이용해서 자동화
  - 팀원 모두가 알고있는 하나의 공유된 지표
  - 장애나 이슈가 있을 때 혼자만 알지 말고 팀원들과 **공유 필요**    => 공유 툴 : **JIRA!!!**

---

### 1-4. SRE : 운영을 어떻게 할까?(장애 없이)

- 구글 NEXT 발표 자료! 개발 흐름
  - class SRE implements DevOps



## 2. How - JIRA & JQL 사용 예시

### 1. Create Issue!!!

- PROJECT : 프로젝트

- ISSUE TYPE : 기본 기능만, task 등 
  - epic : 큰 틀, 스토리, task, story 묶음. 
    - issue들의 묶음
    - 회원가입+로그인 => 사용자 관리!! 단위를 직접 정해
  - story : 스토리보드 => 유저 입장 어떻게 해야할지
  - task : 해야 할 일 : 서버 생성,  
  - bug : 버그 그 자체

---

- Summary : 요약, 이슈의 제목
- Reporter : 보고자. 누가 제기 했는지
- Component : 하나의 기능 단위, 모듈화해서 만나
- Description : Issue에 대해서 ..
- Fix Version : 버전 어디에 , 어떤 버전에 쓸 껀지
- Priority : 얼마나 중요한지.
- Label : HashTag, 어떻게 관리를 할 지도 잘 설정해야해. 형식이 없음!
- Linked Issues : 연관된 문제
- Assignee : 담당자는 누구인지
- Sprint : 스크럼에서 활용할 것 ! 어떤 스프린트에 넣을 지 지정한다

---

### 2. JQL

- Jira Query Language
- Jira Issue를 구조적으로 검색하기 위해 제공하는 언어
- SQL과 비슷
- Jira의 각 필드에 맞는 특수한 예약어 사용
- 쌓인 ISSUEㄷ르을 재가공해 유의미한 데이터를 도출 : Gadget, Agile Board 등

#### Basic Query & Advanced Query

- issue - search for issue
- advanced
  - project = ** AND issuetype = Epic AND status = "in Progress"

#### JQL 연산자

- =, !=, >, >=
- in, not in
- **~ (contains), !~(not contains)**
- is empty, is not empty, is null, is not null

#### JQL Keyword

- AND, OR, NOT, EMPTY, NULL, ORDER BY

#### JQL Date

- Relative Dates
  - -2w, -w, -6d, -5d, Current, 1d 2d, 1w 2w(이전~이후)

#### JQL Function

- endOfDay(), startOfDay()
- endOfWeek (Saturday), StartOfWeek(Sunday)

- eOMonth, eOYear

- currentLogin() : 현재 로그인 한 사람들의 issue들을 사용
- currentUser() :  내 로그인.

updated > startOfWeek(1d); 월요일 이후 업데이트 된 것

---

#### Filter Share

- 필터를 공유하면 내가 만든 조건문을 팀원들이 사용할 수 있음.
- Search 상단에 save as 가능
- details -> edit permission -> 누구에게 공유할 수 있는지!
- Add viewers => ADD 직접 하고, 그 다음
  - project = MyProject AND update > startOfWeek(1d) AND update < endOfWeek(-1d) 
  - project = MyProject AND assignee = currentUser() AND resolution = Unresolved 
    - 나의 미완료 이슈.
- Find Filter 가능

---

#### 활용 : DashBoard, Agile Board

##### DashBaord

Jira home : dashboard - manage dashboard - 만들어 ADD 해주고~

DashBoard에 ㅇ들어가는걸 gadget이고, 우측 Add gadget 만들어

hitmap, 비율이 높을수록 글씨가 커짐..!

pie chart, 이번주 이슈 filter 

Assigned to me,  => 내 할댕

Filter Results = saved filter로 만들어서 저장 하면 잘 만들어짐!

KANBAN : 그냥 프로젝트 이슈 !! 왼쪽 네브바 두번째 칸.



