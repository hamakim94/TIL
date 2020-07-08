# git intro

1. Coursera
2. Edx-C550
3. Udacity
4. K-MOOC

git -> 에서 설치
맨 마지막, 설치후
맨 위 체크
맨 아래 비우기 (2칸)

C:\Users\student
user 바로가기추가하기

til ( today i learned) 만들거야

student@M1501 MINGW64 ~
$ mkdir TIL # make directory,

student@M1501 MINGW64 ~
$ cd TIL # change dir

student@M1501 MINGW64 ~/TIL
$ls # list

student@M1501 MINGW64 ~/TIL
$ touch lunch.txt # 파일생성

((CLI, Command Line Interface)

### 텍스트 파일을5개만들고싶다
student@M1501 MINGW64 ~/TIL
$ touch a.txt b.xtx c.txt d.txt e.txt

student@M1501 MINGW64 ~/TIL
$ rm *.txt # 다지우기

유닉스에서 .하면 숨겨준다..
.hidden  unix에서 안 보이는데,
ls -a ( 옵션주기 all) 다보여
..은 내위에,  . 는 내 위cd 

~의 의미 : ==home
student@M1501 MINGW64 ~/TIL
$ cd ~  
~폴더(존재는아니지만)

student@M1501 MINGW64 ~
$ pwd # present working directory
/c/Users/student 


--------typora down-------------








-----------GIT------------

핵심 : 버전관리 VCS(Version Control System)

----------------------------

student@M1501 MINGW64 ~
$ cd TIL

student@M1501 MINGW64 ~/TIL
$ pwd
/c/Users/student/TIL

student@M1501 MINGW64 ~/TIL
$ git init                                                  # 버전관리 시작~~
Initialized empty Git repository in C:/Users/student/TIL/.git/

### repository : 리포, 저장소~ 이 폴더는 리포가 됐고 버전관리 가능~

student@M1501 MINGW64 ~/TIL (master)
$ ls

student@M1501 MINGW64 ~/TIL (master)
$ ls -a
./  ../  .git/

이제부터 폴더,디렉토리가 아닌 리포로 부르겠어!!

student@M1501 MINGW64 ~/TIL (master)
$ git status
On branch master

No commits yet

nothing to commit (create/copy files and use "git add" to track) 
### 뭐 딱히 할 일 없다~~

student@M1501 MINGW64 ~/TIL (master)
$ touch 0708_git_intro.md

student@M1501 MINGW64 ~/TIL (master)
$ git status
On branch master

No commits yet

Untracked files: # 모르겠는 파일
  (use "git add <file>..." to include in what will be committed)
        0708_git_intro.md(빨간색)

nothing added to commit but untracked files present (use "git add" to track)

student@M1501 MINGW64 ~/TIL (master)
$ git add 0708_git_intro.md

student@M1501 MINGW64 ~/TIL (master)
$ git status
On branch master

No commits yet

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)
        new file:   0708_git_intro.md(초록색)


student@M1501 MINGW64 ~/TIL (master)
$ git commit -m '깃 마크다운 생성'

*** Please tell me who you are.

Run

  git config --global user.email "you@example.com"
  git config --global user.name "Your Name"

to set your account's default identity.
Omit --global to set the identity only in this repository.

fatal: unable to auto-detect email address (got 'student@M1501.(none)')

### 최초1회설정

student@M1501 MINGW64 ~/TIL (master)
$ git config --global user.email "mingyun0324@gmail.com"

student@M1501 MINGW64 ~/TIL (master)
$ git config --global user.name "Hama"

서명하는거~~
student@M1501 MINGW64 ~/TIL (master)
$ git commit -m '깃 마크다운 생성'
[master (root-commit) b495fc1] 源?留덊겕?ㅼ슫 ?앹꽦
 1 file changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 0708_git_intro.md

### 버전 생성 완료

student@M1501 MINGW64 ~/TIL (master)
$ git status
On branch master
nothing to commit, working tree clean

student@M1501 MINGW64 ~/TIL (master)
$ git log
commit b495fc16dbd6f609c0952c664358a973de4d1bd7 (HEAD -> master) # 버전명
Author: Hama <mingyun0324@gmail.com>
Date:   Wed Jul 8 14:55:46 2020 +0900

    깃 마크다운 생성

## local git

1. git 다운로드 및 설치

2. 초기화`$ git init`          ctrl+enter 빠져나오기, tab들여쓰기, 

   1. 실제로는폴더에  .git/ 폴더가 생성됨
   2. 버전관리가 시작됨
   3. 리포(repository)라고 부름

3. 서명 설정

   ```
   1. $ git config --global.user.name "name"
   
   2. $ git config --global.user.email "email@email"
   ```

4. 리포의 상태 보기 ` $ git status ` 

5. stage에 올리기!! $ git add ` 
   1. 특정 파일만 올리기 `$ git add <filenames>`
   2. 내 위치(폴더) 다 올리기 `git add .`

6. snapshot 찍기 `$ git commit` 

7. 로그 보기(찍어놓은 사진첩!) `git log` 

### 집 컴퓨터 세팅

1.  git 다운로드 및 typora 설치
2. 윈도우키 = 로고 -> git besh 찾아서 실행(집컴의 홈폴더)
3. ` git config ..global`
4. `$ git clone <URL>`
   1.  `$ git remote -v` 입력하면 나와. 예시 : https://github.com/hamakim94/TIL.git    . git 중요! , 페이지에도 있음 code 칸 들어가면
   2.  원하는 폴더 우클릭 - Git Besh Here -> 해당되는 장소로 gi besh가 열려!







- 사실 깃은 카메라라고생각하면 된다..

  | working directory             | stage                                              | History                             |
  | ----------------------------- | -------------------------------------------------- | ----------------------------------- |
  빨간색 : 바뀌었는데 스테이지에 안 올라와있어.

  초록색 : 스테이지에 올라와있어..





untraking - 새로운 사람이 왔어, 누군지 몰라, 그냥 모른척 할 래 .. 누군지 알려주기 전 까지 .! traking함

한 번 이라도 올려줘야!!!! 하나라도 올려!

```
student@M1501 MINGW64 ~/TIL (master)
$ git status
On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        **new file:   text.txt

사진찍을준비 끝났어요~~
```

```
student@M1501 MINGW64 ~/TIL (master)
$ git commit -m 'test.txt 추가'
독사진~
```

```
student@M1501 MINGW64 ~/TIL (master)
$ git add 0708_git_intro.md

student@M1501 MINGW64 ~/TIL (master)
$ git status
On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        modified:   0708_git_intro.md(c초록)
        new file:   text.txt(초록)

```

```
중간수정

student@M1501 MINGW64 ~/TIL (master)
$ git status
On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        modified:   0708_git_intro.md
        new file:   text.txt               이미 있던거

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   0708_git_intro.md        새로운 사진
```

# GIT HUB

1. 원격 저장소(remote repository) 생성!
2. local repo => remote repo `$ git remote add origin <url> ` -> 복붙..
3. 로컬 커밋들을 리모트로 보내기 `$ git push origin master` 
   1.  만약 맨날 쓰기 싫다..!
4. `$ git push` == `$git push origin master`로 단축명령하기 `$git push -u origin master`
5. 다른 컴퓨터에서 remote repo **최초**로 받아오기 `$ git clone <url>`
6. 이후 remote repo 변경사항 을 local_repo에 반영하기 `$ git pull `





# TIL 관리 시나리오

1. 멀캠에 온다
2. `$git pull`
3. 열-공
4. 중간중간 `git add . & git commit` 
5. 집 가기전에 `$git push`
6. 집 도착
7. `$git pull `
8. 복습 및 자습
9. 마지막으로 `$ git push`
10. 1번으로..
11. yea!



