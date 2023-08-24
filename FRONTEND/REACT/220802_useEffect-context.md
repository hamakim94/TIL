
# useEffect+Axios
```jsx
const [boards, setBoards] = useState([]);

useEffect(() => {
    async function get() {
      const {data} = await axios.get( // 처음 실행하는 함수, 전체 보드를 가져온다
        '우리 주소',
        {
          params: {'param key' : 'value'},
        },
      ); //이렇게 요청하면, 매번 url에 새로운 객체 주소를 받아오기 떄문에, 계속 무한
      setBoards(data);
    }
    get();
  }, [boards]);
```

## 자바스크립트에서 배열은 객체, 즉 ‘주소’

이렇게 하면, boards에 담겨있는 주소랑, data로 얻어온 주소는 다르기 때문에

계속해서 바뀐다.

그래서 빈 배열을 등록하면, 빈 배열은 바뀌지 않기 때문에 딱 한 번만 실행된다

```jsx
const [boards, setBoards] = useState([]);

useEffect(() => {
    async function get() {
      const {data} = await axios.get( // 처음 실행하는 함수, 전체 보드를 가져온다
        '우리 주소',
        {
          params: {'param key' : 'value'},
        },
      ); //이렇게 요청하면, 매번 url에 새로운 객체 주소를 받아오기 떄문에, 계속 무한
      setBoards(data);
    }
    get();
  }, []);
```



# useContext
## 파일을 하나 만든다

```jsx
// PracticeContext.js

import React from "react";

const PracticeContext = React.createContext(); // 틀

const PracticeProvider = ({children}) => {  // 변수 제공 (함수도 가능) 
    const [val,setVal] = React.useState(0);
    const [val1,setVal1] = React.useState(1);
    const [val2,setVal2] = React.useState(2);
    
    return(
        <PracticeContext.Provider value={{
            val, val1, val2, setVal, setVal1, setVal2
        }}>
            {children}
        </PracticeContext.Provider>
    )
}

export {PracticeContext, PracticeProvider}
```

## 쓸 항목들에 감싼다

```jsx
// app.js

import React from 'react';
import {NavigationContainer} from '@react-navigation/native';
import BottomTabsNav from './navigations/BottomTabsNav';
// 임포트를 한다
import { PracticeProvider, PracticeContext } from './util/PracticeContext';

// 기존 가장 위 컴포넌트를 PracticeProvider로 감싼다
export default function App() {
  return (
    <PracticeProvider>          
      <NavigationContainer>
        <BottomTabsNav />
      </NavigationContainer>
    </PracticeProvider>
  );
}
```

## 하위 컴포넌트

```jsx
import {PracticeProvider, PracticeContext} from ...

const { val, val1, val2, setVal, setVal1, setVal2} = 
		useContext(PracticeContext);

return ( 
	<Text>{val1}</Text>
)

```

하면, 다 바뀜! !! !!