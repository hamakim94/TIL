# git intro

1. 초기화`$ git init`          ctrl+enter 빠져나오기, tab들여쓰기, 

   1. 실제로는폴더에  .git/ 폴더가 생성됨
   2. 버전관리가 시작됨
   3. 리포(repository)라고 부름

2. 서명 설정

   ```
   1. $ git config --global.user.name "name"
   
   2. $ git config --global.user.email "email@email"
   ```

3. 리포의 상태 보기 ` $ git status ` 
4. stage에 올리기!! $ git add ` 
   1. 특정 파일만 올리기 `$ git add <filenames>`
   2. 내 위치(폴더) 다 올리기 `git add .`
5. snapshot 찍기 `$ git commit` 
6.  로그 보기(찍어놓은 사진첩!) `git log` 



- 사실 깃은 카메라라고생각하면 된다..

  | working directory             | stage                                              | History                             |
  | ----------------------------- | -------------------------------------------------- | ----------------------------------- |
  빨간색 : 바뀌었는데 스테이지에 안 올라와있어.

  초록색 : 스테이지에 올라와있어..





untraking - 새로운 사람이 왔어, 누군지 몰라, 그냥 모른척 할 래 .. 누군지 알려주기 전 까지 .!

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









