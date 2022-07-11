# 22.07.11

## npm 이용 기존 project clone : npm 관련 문제들

### 시도

0. git 설치
1. node.js LTS version 설치 : v.16.16.0
2. yarn 설치 : 1.22.19(cmd)
3. git clone 완료(스켈레톤 프로젝트)
4. MINGW64 ~/Desktop/스켈레톤/skeleton-project/frontend (master)
5. npm --force 실행

--------------------------------
### 해결

- npm i --legacy-peer-deps : 의존성 무시하고 그냥 설치해버림
- 근데 수많은 의존성 문제가생긴다
  - npm, node version 낮추라는데 그런 기준을 구할 수 있는 방법이?

-------------------------------------
### 오류의 모습

$ npm i
npm WARN config global `--global`, `--local` are deprecated. Use `--location=global` instead.
npm ERR! code ERESOLVE
npm ERR! ERESOLVE unable to resolve dependency tree
npm ERR!
npm ERR! While resolving: saffy_vue@0.1.0
npm ERR! Found: eslint@5.16.0
npm ERR! node_modules/eslint
npm ERR!   dev eslint@"^5.16.0" from the root project
npm ERR!
npm ERR! Could not resolve dependency:
npm ERR! peer eslint@"^7.0.0 || ^8.0.0" from eslint-plugin-promise@6.0.0
npm ERR! node_modules/eslint-plugin-promise
npm ERR!
npm ERR! Fix the upstream dependency conflict, or retry
npm ERR! this command with --force, or --legacy-peer-deps
npm ERR! to accept an incorrect (and potentially broken) dependency resolution.
npm ERR!
npm ERR! See C:\Users\SSAFY\AppData\Local\npm-cache\eresolve-report.txt for a full report.

npm ERR! A complete log of this run can be found in:
npm ERR!     C:\Users\SSAFY\AppData\Local\npm-cache\_logs\2022-07-11T05_44_37_222Z-debug-0.log