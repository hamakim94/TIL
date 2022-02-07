# 22/02/07

## JavaScript란?

- 객체 생성을 지원하는 동적 스크립트 언어
- 웹 브라우저에서 주로 사용, Node.js로 콘솔환경에서 사용
- UI 제어
- 자바와 기본 구문이 비슷(C언어 기본 구문 바탕)
- 브랜든 아이크(1995)
- Mocha -> LiveScript -> JavaScript(그 당시 자바가 잘 나가서..)

---

## 익스플로러별 엔진과 ECMA

- 크롬 : V8; IE : 차크라, FireFox : 스파이더 몽키(like JVM)
- NodeJs : 크롬 V8 엔진을 바깥에 가져와서 자바스크립트 엔진을 실행시킬 수 있게 함!

cf) MS : IE - Jscript그냥 설치해서 배포했음..근데 이건 안되고, 저건 저기서 되고

	- ECMA International : 정보통신에 대한 표준을 제정하는 비영리 표준화 기구 
	- ECMAScript : ECMA-262 기술 규격에 의해 정의된 범용 스크립트 언어!(따라야 할 규격)
 - ECMAScript6(ES6) : 2015년 발표된 6번쨰 표준 명세. -> 가장유명!!
   - cf) JS 관련 익스플로러 전쟁들이 있었다!

---

## 기본 문법

- 보통 HTML에서 자바스크립트를 주로 사용한다

~~~javascript
<script></script> 
~~~

- 문서 내 위치의 제약이 없음

- 기본적으로 크롬 - f12 - console 창에 써있음

- 보통 \<body> 맨 밑에 적는다!

---

### JS파일 별도로 생성해서 외부스크립트 참조하기

1. .js확장자를 가진 파일을 생성
2.  스크립트 파일을 작송하려는 html 문서에서 스크립트 태그 : \<script src = "외부파일위치">\<\script>사용!
   - 참조하는 script 태그 안에 내용을 작성해도 실행 X

3. 외부 js파일 참조하고, 그 안에 console.log 쓰면 출력 안 돼! 바깥 파일만!
4. 주석 사용 : // 한 줄 주석, /* 여러 줄 주석 */ 

## 변수

- 자바스크립트 변수 타입은 가리키는 값에 대한 타입을 나타냄
- var, let, const 키워드를 이용
  - var : ES6 이전 모든 변수에 모두 붙음, 중복 선언이 가능
  - 재선언 O, 재할당 O
  - Hoisting 특성이 있음 ( 없으면 맨 위에서 빈걸로 정의해..)
    - 일단 변수가 있다? 그럼 맨 위에 var 뭐시기가 먼저 있고;
    - 그 다음에 할당을 하고 다시 찍게됨 -> 나중에 이런건 없어
  - 함수 스코프 ( 함수 내에서만 살아있고, 함수 밖에서 나가면 X! 
- **let, const** : ES6 이후 나온 따끈따끈 키워드 (자주 사용)
- undefined : 변수에 아무 값도 없어서 타입을 알 수 없다.
- **동적 타입** : 대입되는 값에 따라서 용도가 변경되는 방식 =>**매우중요!!!**
- 문자,$,_로 시작 / 대소문자 구분 / 예약어 사용 X : camel case

---

### 변수명명규칙

- **클래스, 생성자 : 파스칼케이스!!(Upper-Camel_Case)**
- 일반적인 변수 : 카멜케이스
- 상수 : 대문자 스네이크 케이스(const)

---

#### let 키워드

- 재선언 X, 재할당 O
- 블록 스코프 : {}
  - 재선언과 관련 없고, 블록 안에서 잠깐 쓰고 사라진다.

#### ;

- ASI : 알아서 세미콜론 만들어줌, 근데 예외 경우 있다.

---

#### const 키워드

- 중복 선언 X, 값 변경X(재할당, 재선언 X)
- 블록 스코프
- 대문자 스네이크 케이스
- 선언시 값을 할당
- 상수로 사용

---

### 데이터 타입

- 기본 데이터 타입
  - String, Number, Boolean, null, undefined
- 객체 타입
  - Object - function, array 등 

| undefined              | null                                     |
| ---------------------- | ---------------------------------------- |
| 넌 값을 넣지 않았어 => | 사용자가 의도적으로 이건 없는거야 in JS! |

---

#### typeof

- 결과는 문자열을 반환
- null의 타입은, null이 아님 : 설계 오류(Object)
  - 이미 고치기엔 너무 많은 길을 걸어왔어..

#### 동적 데이터 타입

- 다양한 값을 대입이 가능하다

---

#### 숫자형 (number)

- 정수와 실수로 나누어 구분하지 않음(부동소수점 형식)
- 일반적인 숫자 외 특수문자 포함(Infinity, NaN)
- e를 활용해 거듭제곱 표현 O
  - 1e9 : 0이 9개!(10억!)

---

#### 문자열(string)

- " ", ' '
- \`\` 백틱으로 감쌀 수 있어
  - 여기에 변수, 문자, 뭐 다 들어가
  - ${name} 로 하면 변수 불러 => 너무 편하다!!
- .length
- [0] :            없는걸 가져오려고 하면 undefined
- .charAt() :  없는걸 가져오려고 하면 : ' '



#### 문자열 연산

- 문자 +연산 숫자 => 문자열
- 문자  ( +연산 이외) : 숫자

~~~ javascript
console.log(1+"20");
console.log("1"+"20");  // 전부 120, 하나라도 문자열이면 +연산은 다 문자열로 받아
console.log("1"+20);

console.log(2+2+"1");  // 42
console.log('1'+2+2);  // 122 계산 순서는 왼쪽에서 오른쪽!ㄴ

console.log('100' - 8);   // 92
~~~

~~~ javascript
Number('23')
Number('23nn')
Number('   0  123')
Number(false)
Number(undefined)
Number(null) // String도 있구~
~~~

#### 자바스크립트 false

- 이 5개만 false, 나머지 다 true
  - null, undefined, 0, ''(빈 문자열), NaN
  - '0' : true다..

- Boolean method가 있고 => !! 로 나타기도 해ㅎ9]60if() 안에는 알아서 boolean으로 바뀜

---

#### 연산자

- \+ 단항 사용시 Number()와 같은 역할
  - +'1' + 1 : 2가 돼
  - +'1' + +'1' : 2가 돼
-  \- \*     /     %     \*\*(거듭제곱)     \=     \+=     \++     우선순위 검색!

---

#### 일치 연산자

- 값과 타입이 일치하는지
  - ===
  - !==
  - == : 암묵적 형 변환(타입을 일치시킨 뒤에 비교연산자)
  - 

~~~ javascript
let a =100;
let b = "100";
console.log(a==b); // true
a===b // false
~~~

#### 조건문, 반복문(Java와 유사)

- for (... in 뭐시기)
  - 객체의 속성들을 순회할 떄 사용
  - 배열도 순회 가능하지만 인덱스 순으로 순회한다는 보장이 XX
- for (... of 뭐시기)
  - 반복 가능한 (iterable) 객체를 순회하며 값을 꺼낼 때 사용한다.
  - Array, Map, Set, String 등..

#### 논리 연산자

- 단축평가 지원
- 삼항 연산자 가능
- if , switch same.



#### 배열(Array)

- 생성 : [] or Array()
- 크기는 동적을 변경
- 크기 지정돼있지 않아도 데이터 입력 가능
- 배열의 길이는 가장 큰 인덱스 +1
- 여러가지 데이터 타입을 하나의 배열에 입력 가능..
  
  - push함수 : 배열의 마지막에 추가!
  - pop() : 마지막 삭제
  - shift() 배열 : 맨 앞 제거
  - unshift() : 맨 앞 추가



- 등
  - .includes()  : 특정값이 있는지 판별(true, false)
  - .indexOf  : 인덱스반환 / 없으면 -1 반환
  - .join(구분자) : 구분자로 연결하여 문자열로 반환 (default : ,)
    - 출력값 간단하게 뽑을 수 있음.
  - map, filter, 등 할 수 있는게 너무많아..



## 객체

- 문자열로 이름을 붙인 값들의 집합체 (**Key(문자열)** : Value)
  - a[age] : 오류다!
- 객체에 저장하는 값을 프로퍼티라고 한다
- 객체는 prototype이라는 특별한 프로퍼티가 있다~



- 만들기 : 객체 리터럴 {} (배열 아님..)
- Object 생성자 이용 : new Object()
- 생성자 함수 : function Member(){}

~~~ javascript
let memeber1 = {id : "shy", email : "tt@a.com"}
function Member(id, email){
    this.id = id;
    this.email = email;
}
let member2 = new Memeber("shy", "tt@a.com")
~~~

### 객체 프로퍼티

- **. or []**를 이용, 프로퍼티의 조회 및 변경을 처리한다
  - .에서는 띄어쓰기 있는 경우는 조회 못해

- key값에 띄어쓰기(특수문자)가 있으면, "favorite singer" 라고 해야 key로 인식돼

- "favorite singer" : "아이유",
  - ,찍는 이유는 추후에 다른 값이 올 수도 있어서
- 추가, 변경, 삭제, 등등..
- 객체 변수 : 주소가 저정돼 공유 가능

pythontutor : JS 변수들 예쁘게 보여줌

- 함수 안 this는 호출한 객체

- 객체 안에 함수를 넣을 수도 있어..

### JSON

- JSON.stringify(객체) : 객체를 JSON스트링으로
- JSON.parse( json data) : JSONString을 객체로

---

## 함수

- 자바스크립트에서 함수는 객체타입으로 값처럼 사용가능
  - 함수를 변수에 대입, 매개변수로다가
  - 배열의 요소에 넣거나, 객체의 프로퍼티로
- 매개변수 개수가 불일치 => 호출이 가능
  - 사실 prototype 내 argument라는 프로퍼티가 있어서 입력 개수가 일치하지 않아도 일단 갖고는 있어!
- JavaScript의 함수는 일급 객체에 해당
  - 변수 할당가능
  - 함수의 매개변수로 전달 가능
  - 함수의 반환값으로 사용 가능

- **메또드 실행 : ()**
- 기본인자 가능

~~~ javascript
function hello(name = "김ㅇㅇ"){
    console.log(name+ "님 안녕하세요") 
}
~~~



---

### 선언

- function 함수명(){}
  - 함수의 이름
  - 매개변수(가능하다고)
  - 내용
  - 호이스팅 가능
- 함수 표현식
  - let 함수명 = function(){}
    - 이건 익명 함수, 이름 생략가능
  - 매개변수
  - 내용
    - var로 호출 : 위로 올라가
    - 근데 func() 로 돼있으면 undefined, 왜냐하면 ()이니까

---

### 선언식 vs 표현식

- 선언식 함수는 호이스팅 영향을 받아 함수 선언 이전에 호출 가능
- 표현식 함수는 선언 이전에 호출 불가

---

### 함수의 리턴

- 함수의 실행 결과로 함수를 반환 가능

- 함수가 특별한 값을 리턴하지 않으면 undefined 반환

~~~ javascript
function func(callFn){
	callFn("hello")
}
function fn(msg){
	consloe.log(msg)
}

func(fn)
~~~

### 함수 매개변수

- 함수는 호출시 매개변수 영향 X

- argument라는 함수 내부의 프로퍼티를 이용해 매개변수 처리가 가능

- 오버로딩 개념 X

- 기본 인자 사용 가능

---

### 화살표 함수

- 1. function 키워드 제거
  2. () 파라미터 작성
  3. => 화살표 작성
  4. {}함수 내용작성

## DOM Document Object Model

- XML, HTML문서 각 항목을 계층으로 표현, 생성, 변형, 삭제할 수 있도록 돕는 인터페이스
- DOM은 문서 요소 집합을 트리 형태의 계층구조로 HTML 표현
- HTML 문서의 요소를 제어!
- 상단 document 노드를 통해 접근!

~~~ javascript
let arrFunc = () => {console.log("에로우펑션")}
~~~

---

### window ( 최상위 계층 : 생략가능)

- alert(알림) , confirm(확인/취소), prompt(물어볼거, 기본값) 
- open(새로운/기존의 페이지 열어버리기! / url을 보여주고, target : "\_self"/"\_blank")

- window.opener(새로 연 창에서 컨트롤 가능!)
- parseInt(값을 읽고, 정수형으로 바꾸겠다, 바꿀수 없으면 NaN), 
  - 시작이 문자거나 숫자가 아니면 애초에 NaN 뜸
  - 어떻게든 맞추려고해줌
- parseFloat(1.45abc) => 1.45로 바뀜..
- setTimeout(몇 초 뒤에 뭔갈 해줘) clearTimeout(하기로 한 거 취소)
  - handler : function
- setInterval(특정 시간에 뭐 해!) clearInterval ( 이 조건엔 하지마~)

~~~ javascript
setInterval(() => {
    let bg = document.body.style.background // 이러면 그냥 문자 받음
    if bg( === "red"){
        //bg = "yellow"
        document.body.style.background ="yellow"
    }else {
        //bg = "red"
        document.body.style.background ="red"
    }
}, 3000)
~~~

clearInterval은 다른거 하는거 있어

---

## 문서 접근 방식의 이해

### getElementByID(string)

getElementsByTagName

- 이친구는 살아있어, 그래서 뭐를 관리하기가 너무 빡세
  - 여러가지를 가져오는 경우(elements) : 다 너무 살아있어 안 쓰는게 좋다

---

### querySelector(css selector)

DOM을 통해서 현재 페이지에 속성에 접근해 바꿀 수 있다.

- let ele = document.getElementById("a");

  ele.style.color = "green" { 색 바뀜 }

- let ele2 = document.querySelector("div")

  - ele.style.background = "yellow" : 맨 위에거 하나만 하고 이제 안해! ㅃㅃ

- 여긴 읽는 곳에서 값이 fixed

---

### querySelectorAll(css selector)

- let ele3 = document.querySelectorAll("[name = 'c']")
  - ele3.style.background = "blue"
- 결과를 배열로(노드배열) 가져오기 떄문에, 인덱스로 접근할 수 있다.
  - .addEventListener : 이벤트 조작 가능

## 문서 조작 방식 이해

- createElement(name) : \<tag> 를 만들 수 있음
  - 만들면 그냥 빈 태그
  - 기존 엘리먼트 접근도 가능
- append(string | node) , appendChildNode()
  - 
- setAttrubute(name, value) / getAttribute
  - 만약 속성 추가할 때 기본적인 attribute는 .으로 접근이 가능하다!
- innerHTML : 그냥 HTML에 안에 넣어버려!
  - 그냥 다 넣어버리기

#### 주의

- 사용자 정의 특성은 .으로 접근 못하고, getAttribute / setAttribute 해야함!



## 이벤트

- 사건[일]
- 웹 페이지에서 상호 작용이 있을 때 마다 이벤트가 발생
- 마우스를 이용, 키보드 누르기 등 많은 이벤트가 존재
- JS사용 DOM에서 발생하는 이벤트를 감지하고 대응하는 작업을 수행할 수 있음.



#### 1. 고전이벤트처리 - 1 : 속성으로 정의

- 버튼클릭 -> 오류

~~~html
<button onclick = "alert('경고창')"></button>
~~~

- 버튼클릭 -> 함수 실행

~~~html
<button onclic = "doSomething()">함수 실행</button>

<script>
    let sum = 0;
    for(let i = 0; i<10 ; i++){
        sum += i
    }
    alert(sum)
</script>
~~~

#### 고전 이벤트처리 - 2 : 스크립트에서 이벤트 설정

~~~ html
<button id = "btn">버튼</button>

<script>
    let btn = document.querySelector('#btn')
    //btn.onclick = doAction();  이렇게하면 실행되는데, return값이 없으니 아무것도 X
    btn.onclick = doAction; // 이게 옳아
    function doAction(){
        alert("경고")
    }
</script>
~~~

#### 표준 이벤트 처리방식 - 3 : addEventListener

- 이벤트요소(target).addEventListener(이벤트 타입, 이벤트리스너(함수), [option])
  - 이벤트가 오기까지 귀를 기울이고있어!
- -----이가 -----하면 ----해

~~~html
<button id = "btn">버튼</button>

<script>
    let button = document.querySelector("#btn");
    button.addEventListener("click", doAction)
    
    function doAction(){
        alert("냠냠")
    }
    
</script>
~~~

- 만약 똑같은 버튼이 많아.
  - ex)찜버튼
  - buttons : queryselectall!
    - 반복을 돌면서 이벤트를 달아!
    - 한 방에 가져와서 처리해야한다구!

#### 이벤트 막기

~~~ html
<script>
    let aTag = document.querySelector("a")
    aTag.addEventListner("click", function(event){
        event.preventDefault()
    })
</script>
~~~

## Web Storage

- Web Storage API
- key / valuee
- sessionStorage : 브라우저가 켜져있을때만 저장
- localStorage : 브라우저를 껐다키더라도 변화가 남아있음.



### Local Storage

- setItem(key, value)
- getItem(key)
- removeItem(key)
- clear()
- key(index)
- length
  - **값은 반드시 문자열로 저장** : JSON.stringify() 자주 씀

~~~html
<body>
    <h1>로컬스토리지</h1>
    <input type = "text" id = "content">
    <button id = "create">등록</button>
    <button id = "read">조회</button>
    <button id = "delete">삭제</button>
    <h2>로컬스토리지에 저장된 내용</h2>
    <div id = "save">
        
    </div>
    <script>
        document.querySelector("#create").addEventListner("click", function()){
                    let input = document.querySelector("#content")
        			// 문자열로 변환
       				let jsonInput = JSON.stringify(input.value);
        			// 로컬스토리지 저장
        			localStorage.setItem("data", jsonInput);
        			// input 데이터 초기화
                    });
        document.querySelector("#read").addEventListener("click", function(){
            let jsonData = localStorage.getItem("data")
            if (!(jsonData == null )){
				let data = JSON.parse(jsonData)
                
                let DIV = document.querySelector("#Save");
                DIV.innerHTML = data;
            }
        });
        
        document.querySelector("#delete").addEventListener("click", function(){
            localStorage.removeItem("data")
        })
                    
    </script>
</body>
~~~

