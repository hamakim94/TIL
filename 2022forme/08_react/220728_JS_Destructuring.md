# 220728 javascript destructuring & useEffect

## 이상한 자바스크립트

```jsx
const a = function(){};
a();
// 이걸 한방에?
()()
```

- 참 묘하다, (함수)(매개변수) 하면 실행돼…
- 아래 예시를 들어가보자
- 자바스크립트는, ( 함수 ) 로 묶으면 함수 자체, 즉 myFunc라고 선언한게 ( myfunc ) 로 사용

## destructuring

```jsx
const [boards, setBoards] = useState([]);
(async ()=> {
      const {data} = await axios.get("님들 서버 URL");
      setBoards(data);
    })  ()

//원래라면
const myFunc = async function(){
	return(
		const {data} = await axios.get("URL"); // destructuring, 원래 axios의
											                     // 첫번째 return 값은 data 라는 이름
																				   // 근데 그걸 그냥 data라는 이름으로 가져옮.
    setBoards(data); 
	)                                        
}
```

- axios.get(”URL”) 하면 첫 번쨰 리턴값이 data로 들어오는데, 그걸 {data}로 받으면 추후 사용 가능

## 무한렌더링

```jsx
const [boards, setBoards] = useState([]);
(async ()=> {
      const {data} = await axios.get("님들 서버 URL");
      setBoards(data);
    })  ()
```

- 이렇게 실행하면 함수가 위에서 아래로 내려가며 실행되는데
- setBoards를 만나는 순간 다시 위로 올라가서 무한반복… 이를 방지하기 위한 useEffect

## useEffect

```jsx
const [boards, setBoards] = useState([]);
  
useEffect(() => {
  (async ()=> {
    const {data} = await axios.get("님들 서버 URL");
    setBoards(data);
  })  ()
}, [boards])
```

- 첫 실행 때 딱 막아줌
- [boards], 즉 우리가 state에 선언한 변수를 useEffect 함수 인자로 넣어 등록을 해줘
- 냄새가 진한편

## 객체 여러 값 동시에 수정

onPress={() ⇒[ set함수1, set함수2]}| , ⇒ 뒤에 것만 적용이 되는 문제가 있다.

set함수 자체를 prev값 갖게 함수형으로 하거나,

아래처럼 ,를 활용해 붙일 수 있다. 

```jsx
const setOpt2Selected = () => {
    setBoards(boards.map(item => item.board_id === board.board_id
      ? {...item, opt2_selected: item.opt2_selected + 1, user_vote : 2} 
      : item))           
  };
```