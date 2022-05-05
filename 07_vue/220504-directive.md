# 22/05/04

### 기초

#### Vue Template이란?

- 뷰의 템플릿은 HTML, CSS 등의 마크업 속성과 뷰 인스턴스에서 정의한 데이터 및 로직들은 **연결**해 브라우저에서 볼 수 있는 형태의 HTML로 변환해주는 속성

#### DOM 이란

- 문서 객체 모델(Document Object Model) : HTML, XML 문서의 프로그래밍 인터페이스
  - 프로그래밍 언어가 DOM 구조에 접근할 수 있는 방법을 제공
    - 문서 구조, 스타일, 내용 등을 변경할 수 있게 돕는 편
  - nodes, object로 문서를 표현한다
    - 이들은 웹 페이지를 스크립트/프로그래밍 언어에서 사용될 수 있게 연결해줌

#### DOM - JS

- document(문서)와 element(문서의 요소)에 직접 접근하기 위해 DOM이 사용된거!



## Vue Life Cycle

### Life Cycle Hooks (Instance)

- 각 Vue 인스턴스는 생성될 때 일련의 초기화 단계를 걸친다
  - 데이터 관찰 설정이 필요한 경우
  - 템플릿을 컴파일 하는 경우
  - 인스턴스를 DOM에 마운트 한느 겨우
  - 데이터가 변경돼 DOM을 업데이트 하는 경우 등
- 그 과정에서 사용자 정의 로직을 실행할 수 있는  Life Cycle Hooks도 호출
- 크게 4개의 파트 (생성, 부착, 갱신, 소멸)
- 모든 Life Cycle Hooks은 자동으로 this 컨텍스트를 인스턴스에 바인딩하므로 데이터, 계산된 속성 및 메소드에 접근할 수 있다
  - 화살표 함수 사용해 라이프 사이클 메소드 정의하면 X

~~~ js
new Vue({
    data : {
        a : 1
    },
    created: function() {
        // this는 vm 인스턴스를 가리킴
        console.log('a is' + this.a)
    }
})
~~~

| Life Cycle Hooks | 설명                                                         |
| ---------------- | ------------------------------------------------------------ |
| beforeCreate     | 인스턴스가 방금 초기화된 후 데이터 관찰 및 이벤트 / 감시자 설정 전에 동기적으로 호출 |
| created          | 인스턴스가 작성된 후 동기적으로 호출. 데이터 처리, 계산된 속성, 메서드, 감시/이벤트 콜백 등과 같은 옵션 처리 완료, 마운트가 시작되지 않았으므로 DOM 요소 접근 X |
| beforeMount      | 마운트가 시작되기 전에 호출                                  |
| mounted          | 지정된 엘리먼트에 Vue 인스턴스 데이터그 마운트 된 후에 호출  |
| beforeUpdate     | 데이터가 변경될 때 vitual DOM이 렌더링, 패치 되기 전에 호출  |
| updated          | Vue에서 관리되는 데이터가 변경되어 DOM이 업데이트가 된 상태  |
| beforeDestroy    | Vue 인스턴스가 제거되기 전에 호출                            |
| destroyed        | Vue 인스턴스가 제거된 후에 호출                              |

---

### Vue Method

- Vue Instance는 생성 관련된 데이터(data) 및 메서드의 정의 기능
- method 안에 data를 this.data이름 으로 접근
- @click = "함수이름()" / "함수이름" 다 가능

---

### Vue Filters

- Vue는 텍스트 형식화를 적용할 수 있는 필터를 지원함
- fitler를 이용하여 표현식에 새로운 결과 형식을 적용
- {{ mustache }} 구문 또는 v-bind 속성에서 사용이 가능
- 자바스크립트 표현식 마지막에 "|" 심볼과 함께 추가 되어야 함
- 필터는 체이닝이 가능
  - {{ msg  | 대문자로}} => HELLO

#### 전역 필터

~~~ js
Vue.filter(
	'count', (val) => {
        if(val.length == 0){
            return;
        }
        return `${val} : ${val.length}자`;
    }
);
~~~

#### 지역 필터

~~~ js
new Vue({
    el : '#app',
    filters:{
        count(val){
            return `${val} : ${val.length}자`;
        }
    }
})
~~~

---

### Vue Computed

#### Vue Computed ( v-for, v-if 동시에 쓰이는 느낌?)

- 특정 데이터의 변경사항을 실시간으로 처리할 수 있음
- 캐싱을 이용하여 데이터의 변경이 없을 경우 캐싱된 데이터를 반환
  - 자주 쓰이는 데이터를 미리 저장, 그거 요구하면 바로 딱 줘(다시 불러오는게 아님!)!
- Setter와 Getter를 직접 지정할 수 있음
- 작성은 method 형태로 정의하지만, Vue에서 프록시 처리하여 property처럼 사용
- 화살표 X

---

#### Vue computed vs Methods

- computed 속성 대신 methods에 함수 정의하여 사용 가능(최종 결과 같음)
- computed 속성은 종속 대상을 계산하여 저장해 놓는다(캐싱)
  - 종속된 대상이 변경되지 않는 한 computed에 작성된 함수를 여러 번 호출해도 계산을 다시 하지 않고, 계산되어 있는 결과를 반환
- methods를 호출하면 렌더링을 다시 할 때 마다 항상 함수를 실행

---

### Vue watch

#### Vue watch

- Vue Instance의 특정 property가 변경될 때 실행할 callback 함수 설정
- 데이터를 감시
- 화살표 함수 사용 X

---

#### Vue watch vs computed

- computed : 내가 직접
  - 특정 데이터를 직접적으로 사용/가공하여 다른 값으로 만들 때
  - 계산해야하는 목표 데이터를 정의하는 방식, SW공학에서 이야기하는 '선언형 프로그래밍' 방식
- watch : 감시
  - 특정 데이터의 변화 상황에 맞추어 다른 data등이 바뀌어야 할 떄 주로 사용
  - 감시할 데이터를 지정하고 그 데이터가 바뀌면 이런 함수를 실행하라 라는 방ㅅ힉으로 SW공학에서 이야기하는 '명령형 프로그래밍' 방식

---

## Vue Event Handling

### Vue Listening to Event(이벤트 청취)

- v-on 디렉티브를 사용하여 DOM 이벤트를 듣고 트리거 될 때 JavaScript를 실행 할 수 있음

---

### Vue Method Event Handlers

- 많은 이벤트 핸들러의 로직은 복잡하여 v-on의 속성값으로 작성하긴 어려움
- v-on이 호출하고자 하는 method의 이름을 받는 이유

---

### Vue Method in Inline Handlers

- 메소드 이름을 직접 바인딩 하는 대신 인라인 JS 구문에 메소드를 사용할 수도 있음
- 때로 인라인 명령문 핸들러에서 원본 DOM 이벤트에 엑세스 해야할 수도 있음
- $event 변수를 사용해 메소드에 전달

---

### Vue Event Modifiers

- 이벤트 핸들러 내부에서 event.preventDefault() 등을 호출하는 것은 보편적인 일이다.
- 메소드 내에서 쉽게 작업을 할 수 있지만, methods는 DOM의 이벤트를 처리하는 것 보다 data 처리를 위한 로직만 작업하는게 좋음
- v-on 이벤트에 이벤트 수식어를 제공 (.으로 표시된 접미사)
- 체이닝 가능
  - .stop : event.stopPropagation() 호출 - 클릭 이벤트 전파 X
  - .prevent : event.preventDefault 호출 - 제출 이벤트가 페이지를 다시 로드 X
  - .capture : 캡쳐 모드에서 이벤트 리스너를 추가함
  - .self : 이벤트가 이 엘리먼트에서 전달된 경우만 처리됨
  - .once : 단 한번만 처리
  - .passive : DOM 이벤트를 {passive : true}와 연결함

---

### Vue Key Modifier

- Vue는 키 이벤트를 수신할 때 v-on 에 대한 키 수식어를 추가할 수 있음
  - .enter(.13)
  - tab
  - .delete
  - .esc
  - .space
  - .up / .down / .left / .right
  - 전역 config.keyCodes 객체를 통해 설정 가능

---

## Vue Bindings

### ref, $refs

- $refs : ref 속성이 등록된 자식 컴포넌트와 DOM 엘리먼트 객체
  -  템플릿이나 계산 된 속성에서 사용 X
- ref : 엘리먼트 또는 자식 컴포넌트에 대한 참조를 등록하는데 사용.

---

### Class Bindings

- 데이터 바인딩은 **엘리먼트 클래스 목록**과 **인라인 스타일**을 조작하기 위해서 일반적으로 사용됨.
- v-bind를 사용하여 처리 가능
- 문자열 이외에 객체 또는 배열을 이용할 수 있음

---

### Form Input Bindings

- v-model 디렉티브를 사용하여 form input과 textarea 엘리먼트에 양방향 데이터 바인딩 생성 가능
- text와 textarea : value, input 이벤트 사용
- checkbox, radio : checked, change 이벤트 사용
- select : value,chagne 이벤트 사용
- v-model은 모든 form 엘리먼트의 초기  value,checked,selected 속성을 무시함

#### Form : text

~~~ html
<input v-model="message" placeholder = "여기를 수정해보새요">
<p> 메시지 : {{message}}<p>
~~~

#### Form : textarea

- 텍스트 영역의 보간은 작동 X, v-model을 사용

~~~ html
<span<여러 줄을 가지는 메시지 :</span>
<p style = "white-space : pre-line">
    {{message}}</p><br>
<textarea v-model="message" placeholder="여러줄입력"></textarea>
~~~

---

#### Form : checkbox

- 하나의 체ㅇ크박스 일 경우 boolean 값을 표현
- 여러 개의 체크박스는 같은 배열을 바인딩 할 수 있음

---

#### Form : radio

- 라디오 박스일 경우 선택된 항목의 value 속성의 값을 관리

---

#### Form : select(단일)

- select box일 경우 선택된 항목의 value 속성의 값을 관리
- v-model 표현식이 초기 값이 어떤 옵션에도 없으면  <select>엘리먼트는 '선택없음' 상태로 렌더링

---

## Vue Component

### Vue component

- Vue의 **가장 강력한 기능 중 하나** : SPA!!!!
- 기존 HTML 엘리먼트를 확장하여 재사용 가능한 코드를 캡슐화 하는데 도움 됨
-  Vue Component는 Vue Instance 이기도 함.
  - 루트에서만 사용하는 옵션을 제외하고 모든 옵션 객체 사용 가능
- Life Cycle Hook 사용 가능
- 전역 컴포넌트와 지역 컴포넌트 사용

---

### Vue component(전역)

- 전역 컴포넌트를 등록하려면 Vue.Component(tagName, options)를 사용
- 권장하는 컴포넌트 이름 : 케밥 케이스!

---

### Vue component(지역)

- 모든 컴포넌트를 전역으로 등록할 필요 X
- 컴포넌트를 components 인스턴스 옵션으로 등록함으로써 다른 인스턴스/컴포넌트의 범위에서만 사용할 수 있응!



---

### Vue Component Template

- DOM을 템플릿으로 사용할 때, Vue는 템플릿 컨텐츠만 가져올 수 있기 때문에 HTML이 작동하는 방식에 고유한 몇 가지 제한 사항이 적용됨
- 따라서 가능한 경우 항상 문자열 템플릿을 사용하는 것이 좋음
  - template tag는 루트 엘리먼트가 필요
  - template는 나중에 사라져, 그래서 div안에 감싸던가 해야함
    - 또한, 두개 이상 등록하면 안대

- data는 반드시 함수여야 한다.
- data객체를 공유하는 문제를 막고 새로운 대에티 객체를 반환해서 해결한다.

---

## Vue Component 통신

- 컴포넌트는 부모-자식 관계에서 가장 일반적으로 함께 사용하기 위한 것(tree)
- 부모는 자식에게 데이터를 전달(Pass Props)
- 자식은 부모에게 일어난 일을 알림(Emit Event)
- 부모와 자식이 **명확하게 정의된 인터페이스를 통해** 격리된 상태 유지
- props는 아래로, events는 위로!

---

### 부모 컴포넌트 -> 자식 컴포넌트

- 상위 컴포넌트에서 하위 컴포넌트로 데이터 전달
- 하위 컴포넌트는 사위 컴포넌트의 값을 직접 참조 불가능
- data와 마찬가지로 props 속성의 값을 template에서 사용 가능
  - props : 부모에서 주는 값!

---

### Dynamic Props

- v-bind를 사용하여 부모의 데이터에 props를 동적으로 바인딩 할 수 있음
- 데이터가 상위에서 업데이트 될 때마다 하위 데이터로도 전달.

~~~html
<div>
    <input v-model="parentMsg"> <br>
    <child v-bind:my-message = "parentMsg"></child>
</div>
~~~

- v-bind 단축 구문 사용 가능
- \<child :my-message = "parentMsg"></child>

---

### Dynamic Props 객체의 속성 전달

- 객체의 모든 속성을 props로 전달할 경우 인자없이 v-bind를 사용

~~~js
todo : {
    text : 'Learn Vue',
    isComplete : false
}
~~~

~~~html
<todo-item v-bind="todo"></todo-item>

---------------------------------------, 알아서 잘들어간다는뜻
<todo-item
           v-bind:text = "todo.text"
           v-bind:is-complete = "todo.isComplete"></todo-item>
~~~



---

### 단방향 데이터 흐름

- 모든 props는 하위 속성과 상위 속성 사이의 단방향 바인딩을 형성
- 상위 속성이 업데이트 되면 하위로 흐르게 되지만 반대로는 안 됨
- 하위 컴포넌트가 실수로 부모의 상태를 변경 - 앱의 데이터 흐름을 이해하기 어렵게 만드는 일 방지
- 상위 컴포넌트가 없데이트 될 때 마다 하위 컴포넌트의 모든 prop들이 최신 값으로 갱신됨

---

### 사용자 정의 이벤트

- 컴포넌트 및 props와 달리, 이벤트는 자동 대소문자 변환 제공하지 않음.
- 대소문자를 혼용하는 대신에 emit할 정확한 이벤트 이름을 작성하는 것을 권장
- DOM 템플릿의 v-on 이벤트 리스너는 항상 자동으로 소문자 변환
- 따라서 이벤트의 이름에는 kebab-case를 사용하는 것을 권장



- $on(eventName) : 이벤트 수신(아 대기중~)
- $emit(eventName) : 이벤트 발생, 추가 인자는 리스너의 콜백 함수로!



- 부모 컴포넌트가 자식 컴포넌트가 사용되는 템플릿에서 v-on을 사용하여 자식 컴포넌트가 보낸 이벤트를 청취

---

### 자식 -> 부모

- 이벤트 발생과 수신을 이용
- 자식 컴포넌트에서 부모 컴포넌트가 지정한 이벤트를 발생($emit)
- 부모 컴포넌트는 자식 컴포넌트가 발생한 이벤트를 수신(on)하여 데이터 처리

~~~ js
this.$emit("이벤트명")
~~~

~~~html
<child v-on:이벤트명="부모 컴포넌트 메서드명"></child>
~~~

### 비 부모-자식간 통신

- Vuex 써