# 22/05/06

## Module 정의 및 사용

- 가져오기 : import
- import 모듈 명 from 모듈 위치



- 내보내기 : export
- export
- export default

~~~js
export const title = '계산기 모듈'
export function add(i,j){
    return i + j;
}
export function sub(i,j){
    return i-j;
}

import {title, add, sub} from '파일명'
~~~

~~~ javascript
export const title = '계산기 모듈'
export function add(i,j){
    return i + j;
}
export function sub(i,j){
    return i-j;
}

import {title, add, sub} from '파일명'
~~~

- default 사용도 가능!



---

## Vue CLI

### vue cli(Command Line Interface : 명렬 줄 인터페이스)

- vue js 개발 표준도구
- Vue.js공식으로 제공
- 개발의 필수 아님, 개발의 편리성을 위해 필수처럼 사용한다
- Vue프로젝트 ㅅ빠르게 구성할 수 있는 스캐폴딩 사용
- Vue와 관련된 모든 오픈 소스들이 나옴!

---

### npm 명령어

- npm init : 새로운 프로젝트나 패키지를 만들 때 사용(package.json이 생성됨)
- npm install 패키지 : 생성되는 위치에서만 사용 가능한 패키지로 설치
- npm install -g 패키지 : 글로벌 패키지 추가, 모든 프로젝트에서 사용 가능한 패키지

---

### @vul/cli 프로젝트 생성

- vue create <project-name>
- ex) vue create vue-first-app
- 실행 중지 : ctrl +c
- 프롲게트 실행 npm run serve



vscode

ctrl + `

---

### Babel

- Babel is a JavaScript compiler
- ECMA2015+(ES6) 의 문법을 ES5의 자바스크립트 코드로 변경핟는 도구

---

### Webpack

- 오픈 소스 자바스크립트 모듈 번들러
- 모듈 간의 의존성 문제를 해결하기 위한 도구
- 프로젝트에 필요한 모든 모듈을 매핑하고 내부적으로 종속성 그래프로 빌드함
  - mvn 같은 느낌이다..

---

### Vue Project 구조

- node_modules
  - node.js 환경의 여러 의존성 모듈
- public
  - index.html : Vue앱의 뼈대가 되는 파일 / 단일 html 파일
  - favicon.ico : Vue 아이콘
- src/assets
  - webpack에 의해 빌드 된 정적 파일
- src/component
  - 하위 컴포넌트들이 위치
- src/App.vue
  - 최상위 컴포넌트!

- src/main.js
  - webpack이 빌드를 시작할 때 가장 먼저 불러오는 entry point
  - 실제 단일 파일에서 DOM과 데이터를 연결했던 것과 동일한 작업이 이뤄짐
  - Vue 전역에서 활용 할 모듈을 등록할 수 있는 파일

- babel.config.js
  - babel 관련 설정

- package-json
  - 프로젝트의 종속성 목록과 지원되는 브라우저에 대한 구성 옵션

- package-lock.json
  - node_modules에 설치되는 모듈과 관련된 모든 의존성을 설정/관리
  - 팀원 및 배포 환경에서 정확히 동일한 종속성을 설치하도록 보장
  - 사용한 패키지의 버전을 고정
  - 개발 과정 간의 의존성 패키지 충돌 방지


---

## Vue SFC

### SFC (Single File Component)

- 확장자가 .vue 인 파일
- template + script + style = .vue(html,css,js 코드를 하나의 파일에서 관리)
- 구문 강조가 가능
- 컴포넌트에만 CSS의 범위를 제한할 수 있음
- 전처리기를 사용해 기능의 확장이 가능

---

### SRC - \<template>

- 기본 언어 : HTML
- 각 *.vue 파일은 한번에 최대 하나의 \<template>블록을 포함할 수 있음
- 내용은 문자열로 추출돼, 컴파일 된 Vue 컴포넌트의 template 옵션으로 사용
- root element가 하나 필요함(대충 div 감싸)

---

### SFC - \<script>

- 기본 언어 : CSS
- 각 *.vue 파일은 한번에 최대 하나의 <script> 블록을 포함할 수 있음
- ES2015+지원 => import, export 사용 가능!

---

### SFC - \<style>

- 기본 언어 : CSS
- 각 *.vue 파일은 여러 개의 \<style>태그를 지원
- scoped 속성을 이용하여 현재 컴포넌트에서만 사용 가능한 CSS 지정 가능

---

## Vue Router

### Vue router

- 라우팅 : 웹 페이지간의 이동 방밥
- Vue.js  : 공식 라우터
- 라우트(route)에 컴포넌트를 매핑한 후, 어떤 주소에서 렌더링할 지 알려줌.
- SPA 상에서 라우팅을 쉽게 개발할 수 있는 기능을 제공
- URL에 따라 컴포넌트를 연결하고 설정된 컴포넌트를 보여줌

---

### 설치

- NPM

  - npm install vue-router

- Vue CLI

  - vue add router

  - 프로젝트를 진행하던 중에 추가를 하면 App.vue를 덮어쓰므로 백업을 해둬ㅜ야 함!

---

### Vue Router 프로젝트 변환

- App.vue 코드
- router/index.js 생성
- views 디렉토리 생성

---

### Vue Router - index.js

- 라우트에 관련된 정보 및 설정 작성

---

### Vue Router - \<router-link>

- 사용자 네비게이션을 가능하게 하는 컴포넌트
- 목표 위치는 'to', 'prop'로 지정됨.
- 기본적으로는 올바른 href를 갖는 \<a>태그로 렌더링 되지만, 'tag' prop로 구성될 수 있음
- HTML5 히스토리 모드에서 router-link는 클릭 이벤트를 차단하여 브라우저가 페이지를 다시 로드하지 않게!!!

---

### Vue Router - \<router-view>

- 주어진 라우트에 대해 일치하는 컴포넌트를 렌더링하는 함수형 컴포넌트
- 실제 component가 DOM에 부착되어 보이는 자리를 의미
- router-link를 클릭하면 해당 경로와 연결돼있는 index.js에 정의한 컴포넌트가 위치



- app view 라우터 링크=> index.js(해당 url 매핑된 컴포넌트 가져와) => app view=>router-view에 뿅 넣어줘!

---

### Vue Router-History Mode

- vue-router의 기본 모드는 hash
- 해시를 제거하기 위해 HTML History API를 사용해서 router 구현
- 페이지를 다시 로드하지않고 URL 탐색 가능

---

### 이름을 가지는 라우트(Named Routes)

- 라우트에 이름을 명명할 수 있음
- 명명된 경로로 이동하려면 객체를 router-link 컴포넌트의 to로 전달할 수 있음

---

### 프로그래밍 방식 네비게이션(Programming Navigation)

- \<router-link>를 사용하여 선언적 네비게이션용 \<a>태그 만드는 것 외에도 router의 인스턴스 메소드를 사용하여 프로그래밍으로 이를 수행 가능
- Vue 인스턴스 내부에서 라우터 인스턴스에 $router로 접근할 수 있음
- 따라서 다른 URL로 이동하려면 this.$router.push를 호출할 수 있음
  - 해당 메서드는 새로운 항목을 히스토리 스택에 넣기 때문에 사용자가 브라우저의 뒤로 가기 버튼을 클릭하면 이전 URL로 이동하게 됨
- \<router-link>를 클릭 할 때 내부적으로 호출되는 메소드이므로
  - \<router-link :to="...">를 클릭하면, router.push(...)와 같음

**공 식 홈 피 가 !**

- 예시
  - router.push('home')
  - router.push({path : 'home'})
  - rotuer.p

---

### 동적 라우트 매칭(Dynamic Route Matching)

- 주어진 패턴을 가진 라우트를 동일한 컴포넌트에 매핑해야 하는 경우
- 동적 인자 전달
- 예를 들어 모든 User에 대해 동일한 레이아웃을 가지지만, 다른 User ID로 렌더링 되어야 하는 예시

- ~~~javascript
  const routes = [
      //동적 세그먼트는 콜론으로 시작
      {path : '/user/:id', component = User}
  ]
  ~~~

- 

- 위의 예에서 /user/foo 와 /user/bar 같은 URL은 모든 같은 경로에 매핑



- 동적 인자는 :로 시작
- 컴포넌트에서 this.$route.params로 접근 가능

| 패턴                          | 일치하는 패스       | $route.params                      |
| ----------------------------- | ------------------- | ---------------------------------- |
| /user/:username               | /user/evan          | { username : 'evan'}               |
| /user/:username/post/:post_id | /user/evan/post/123 | {username:'evan', post_id : '123'} |

---

### 중첩된 라우트(Nested Routes)

- 실제 앱 UI는 일반적으로 여러 단계로 중첩된 컴포넌트 구조임
- URL 세그먼트가 중첩된 컴포넌트 특정 구조와 일치하는 것을 활용

---

### Redirect 가능

- routes 설정
- 이름이 지정된 라우트 지정
- 동적 리다이렉트

---

### components / views

- 두 폴더는 각기 SFC 파일을 저장함
- 어느 곳에 저장해도 상관ㅇ은 없지만, 주로 아래와 같이 작성
- App.vue : 최상위 컴포넌트
- views/ : router(index.js)에 매핑되는 컴포넌트를 모아두는 폴더
- components/: router 매핑된 컴포는트 내부에 작성하는 컴포넌트를 모아두는 폴더

---

