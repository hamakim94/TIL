# FRONT STUDY

### DOM 검색 및 조작

- 검색
  - getElementById
  - querySelector(css selector)
    - id : ''#'', class : ''.'
    - 맨 위에 하나만
    - "[name = 'c']" : 어트리뷰트(속성) 접근
  - querySelectorAll(css selector)
    - 결과를 배열처럼 사용
    - "[name = 'c']"  가능
- 조작
  - createElement(name)
  - append(string|node)
    - 생성하고(createElement), 기존 엘리먼트 접근(검색)하고, 엘리먼트 append로 추가한다
  - setAttribute(name, value)
    - 어떤 속성을 가지고 있는지 알면, 추가가 가능하다.
    - **사용자 정의 속성** "."으로 접근 불가능!
  - innerHTML
    - 아에 HTML 자체를 조작해서 챠챱 넣을 수 있음

---

### JSON 처리

- JSON 은 {"Key" : value, ... } 형식

- 2가지

- ~~~ javascript
  JSON.parse() : //JSON -> 자바스크립트 객체로
  JSON.stringify(객체) : // JS객체 -> JSON 문자열로
  ~~~

---

### js 변수초기값 .. 이부분은 잘 모르겠당

- 선언 안 하면 undefined; !! === typeof()

- cf) 거짓(false) 5종류, String, number, boolean, object, undefined
  - ''(빈 문자열), 0(-0 etc), NaN(Not a Number), null, undefined 

---

### js 문자열연산

- 문자열 + 숫자  => 문자열
- 문자열 (+이외) 숫자 => 숫자

~~~javascript
console.log(1 + "20") : 120
console.log("1" + "20") : 120
console.log("1" + 20) : 120
console.log("100" - 8) : 92
console.log("100" * 8) : 800
~~~

- 단항 사용시 +는 Number()와 동일한 역할(숫자로 형변환)
- === : type 부터 검사하고, 안에 값도 동일한지, ==은 알아서 형변환 해줘서 비교

---

### js 객체

- **문자열로 이름을 붙인** 값들의 집합체(key : value)

- 객체의 저장하는 값을 프로퍼티라고 하고. prototype이라는 특별한 프로퍼티 가짐

- 만드는 법

  - {} / new Object() / 생성자 함수 이용 

  - ~~~ javascript
    function Member(){}
    let member3 = new Member(); // 만들어줭
    ~~~

- 프로퍼티 추가 방법 2가지

  - ~~~ javascript
    let member1 = {id = "tt", email : "dd@dd.com"} // 직접 추가
    
    function Member(id, email){
        this.id = id; // this안에 객체에, id라는 key값을 매개변수 id로
        this.email = email;
    }
    let member2 = new Member("tt", "dd@dd.com")
    ~~~

- 객체 프로퍼티 접근 방법 , 값을 변경하면 새로운 값으로 저장돼

  - dot(.) / []로 조회 및 변경 가능

  - 만약 객체(myme)가 id라는 속성이 있는데,

  - myme[id] -> 오류(키 값인 id가 문자열이 아님) + 띄어쓰기가 포함된건

     myme["띄어포함키값"]  로 접근해야 함. (.)으로 접근 불가

- 객체 프로퍼티 삭제법

  - delete myme.id; -> 삭제된다

- 객체의 변수에는 **주소**가 공유된다

  - 객체 1
  - 객체 2 = 객체 1 하면 주소를 받기 때문에 공유 + 객
  - 객체 2에서 프로퍼티값 변경시 당연히 객체1의 프로퍼티도 변경(주소니까)

- 함수 안에서의 this -> **함수를 호출한 객체 그 자체**

---

### LocalStorage 이해

- setItem(key, value) : 키 : 벨류 형태로 만들어지고, 문자열 형태로 저장된다는 사실!
- getItem(key) : 키에 해당하는 벨류를 가져옴
- removeItem(key) : 해당 키 삭제
- clear() : 전체 지워지는듯
- LocalStorage.key(index) : 로컬스토리지안에있는 index번째 key 이름을 가져옴(0부터 시작)
- length : 키-value들 몇 개 있는지 알려주는 듯
  - **값은 반드시 문자열로 저장**(어떤 값이든 문자열 형태로 저장됨!)

---

### Flex의 속성 이해(4)

- 강력한 정렬기능 제공
- 요소
  - 주축, 교차축, 시작선, 끝선, Cotainer와 Item
- 선언법(flex-container)
  - display : flex  => block (like div)
  - display : flex-inline => inline(like span)
- 속성(Container)
  - flex-direction : Container안 item들의 나열되는 방향
    - row, row-reverse, column, column-reverse
  - flex-wrap : item들의 크기가 container보다 크면 줄넘김
    - nowrap(12345), wrap(123 -45), wrap-reverse(45 - 123 이런느낌!)
  - flex-flow : 방향과 줄 넘김 동시에
    - row nowrap, column wrap .. etc
  - justify-content : 메인축의 정렬을 제어(flex-direction에서 설정한 row/col)
    - flex-start, flex-end, center
    - space-around(남은 여백, 왼쪽오른쪽 동일), 
    - space-evenly(왼쪽오른쪽이아니라, 그냥 여백들 1/n해서 대충 정렬)
    - space-between (양쪽 끝에 일단 박고, 나머지 균등하게 여백 넣기)
  - align-items : 교차축의 정렬을 제어
    - flex-start, flex-end, center, baseline(안에 내용(컨텐트) 글자 밑 부분끼리 1자로), stretch(앙 교차축에 맞게 다 늘려버려!)
  - align-content : (wrap속성에 의해 여러줄이 발생할 때만) 교차축 정렬법
- 속성(Flex-Item):
  - order, flex-basis, flex-grow,flex-shrink, flex, align-self
    - order : 컨테이너 안에 아이템들에게 순서를 줘서 보여준다
    - flex-basis : 크기를 직접 지정해줘서 아이템별 크기를 다르게
    - flex-grow : 기본(0), 음수 불가, 양수 가능, 뭔가 비율로 나눠버림(꽉 차게)
    - flex-shrink : div container 크기게 맞게 주축방향으로 수축, 기본(1), 설정시 칸에 맞게 쏙 들어감(shrink 한 태그만)
    - flex : flex-grow flex-shrink flex-basis 한 번에 일열로(basis auto하면 크기맞게)
    - align-self :
      - auto : align-item과 동일하게!!
      - stretch : 교차축 전부 차지, 근데 하나씩 설정 가능
      - flext-start : 교차축 방향 시작점, 근데 하나씩 설정 가능
      - flex-end : 교차축 방향으로 끝에, 근데 하나씩 설정 가능
      - center : 교차축 방향으로 중앙에

---

### css선택자, 우선순위(3)

- !important > inline > id > class > 기본 tag(css에서 설정한거)
- style 지정할 떄 나중에 적용된게 우선 순위야(같은 클래스에서,)
  - id : 무적권 하나만 써!

~~~ html
<!DOCTYPE html>
<html lang="en">
  <head>
    <title></title>
    <style>
      div {
        width: 100px;
        height: 100px;
        background-color: orange;
        margin-bottom: 10px;
      }
      .red {
        background-color: red;
      }
      .blue {
        background-color: blue;
      }
      #green {
        background-color: green;
      }
      .yellow {
        background-color: yellow !important;
      }
    </style>
  </head>
  <body>
    <div></div> <!-- 오렌지-->
    <div class="red"></div> <!-- 빨간색 -->
    <div class="red blue"></div> <!-- 블루-->
    <div class="blue red"></div> <!-- 블루-->
    <div class="red" id="green"></div> <!-- 그린-->
    <div class="red" id="green" style="background-color: grey"></div> <!-- 그레이-->
    <div class="yellow" id="green"></div> <!-- 옐로우 => 임포텅트 --> 
    <div class="yellow" id="green" style="background-color: darkviolet"></div> <!-- 임포텅트 옐로우--> 
  </body>
</html>

~~~

---

### display와 visibility(2)

- nth-child(2n+1) : 여기서는 인엑스가 1부터 시작함.

- **none vs hidden** => 더 깊게

```css
/* 공간에서부터 빼버려, 기존 공간이 없어짐*/
.none{
    display : none;
}
/* visibility를 hidden으로 하면 공간은 차지, 가려질 뿐*/
.hidden{
    visibility : hidden;
}
```

---

### inline과 block 속성

- 외우기 : 블록디브!(단락 구분) , p도 있음(br태그 두 번, 즉 2칸 줄바꿈, 기본 정렬은 left)
- 외우기 : 인라인 스팬!(하나의 단락 내에 영역을 구분), a, 등등

---

### img 태그

- src(사진 위치) alt(사진이름?) width(너비) height(높이) border(경계선크기)
- 경로들
  - 상대경로 :  현재 웹페이지의 소속 폴더가 기준
    - "./" : 현재 웹페이지가 소속된 폴더
    - "../" : 현재 웹페이지의 부모 폴더(이전)
  - 절대경로 : 누구나 다 알고있는 동일한 위치를 기준으로 찾는 표현
  - 외부 경로 : http://(남의 사이트 주소)

---

### input 태그

- FORM 태그(action : 사용자가 submit : 호출되는 url지정, method(GET,POST) , enctype(업로드시 속성))

  - **input 태그**

    - <input type = **"text"**, name = "username", value = "..."> : 그냥 택스트들 입력받음

    - <input type = **"password"**, name = "pw", value = "..."> : 비밀번호 입력받음

    - <input type = **"hidden"**, name = "code", value = "..."> : 그냥 택스트들 입력받음

      - 주로 사용자가 변경해서는 안 되는 데이터를 함께 보낼 때 유용하게 사용됨

    - <input type = **"submit"**, value = "submit"> : 제출

    - <input type = **"reset"**, value = "reset"> : 리셋

    - <input type = **"button"**, value = "submit", onclick = "fucntion()"> :  저장

    - type : 체크박스

      -  <input type = **"checkbox"**, name = "김"/>\<br>
      - <input type = **"checkbox"**, name = "미"/>\<br>
      - <input type = **"checkbox"**, name = "조"/>\<br> 셋 중 하나 선택 가능

    - type : 라디오 : 여러 개 중 하나 선택

      - <input type = **"radio"**, name = "일치시켜야함", value = "직접지정"/> 직접지정

      - <input type = **"radio"**, name = "일치시켜야함", value = "직접지정2"/> 직접지정2

      - <input type = **"radio"**, name = "일치시켜야함", value = "직접지정3"/> 직접지정3

        

  - select 태그

    - option으로 선택할 폭을 보여줌(srt페이지 지역 선택)

  - textbox 태그

    - cols, rows : 행과열지정해서 입력 받음

---

### table 태그

- \<table>width(너비) height(높이) border(경계선 크기)
- \<tr> : 각 행의 시작과 끝
  - \<td> : 행 안에 포함되는 셀의 시작과 끝(여기서 rowspan(행합치기), colspan(열합치기) 다 설정)

---

### 주석문법(1)

- html : \<!-- 내용 --> (여러줄 적용 가능)
- js 
  - // : 한 줄에 쓰는 주석
  - /* 내용~~(여러줄) */ : 여러줄 한 번에 주석
- css
  - /* */로 한다, 여러 줄,  한 줄 다 가능

---

### HTML 시맨틱태그(Semantic Tags)

####  정의

- 시멘틱 태그는 **"의미가 있는 태그"** 라는 뜻

#### 중요한 이유 3가지

1. SEO(Search Engine Optimization)

    - 검색을 최적화하기 위해 제목, 부제목 등 다양한 시멘틱 태그 활용하면, 특정 키워드 검색했을 때 내가 만든 웹 사이트가 검색창에 노출될 수있음
    - 즉 브라우저의 검색 엔진이 내 사이트를 어떤 검색 결과에 띄워줘야 할 지 알려줄 수 있음
2. 웹 접근성
    - 시각적인 요소 + 음성으로 읽어주는 스크린리더, 키보드만을 이용해 웹사이트 이용하는 경우, 사용하기 편리해진다
3. 유지보수성
    - 단순히 div tag로만 구조를 짜는 것 보다 한 눈에 알아볼 수 있어서 다른 개발자들에게 좋음. 사실 다 div인데 이름만 붙여진거라고 생각(근데 기능이 있을지도?)



---

후기 :

nth-child : 좀 이상해. 해당 태그를 보고, 부모 태그로 가서 그냥 몇 번째 자식인지 찾는다

++a, a++ : 헷갈려서 틀림

