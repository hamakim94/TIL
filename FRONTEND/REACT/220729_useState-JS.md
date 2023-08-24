# 220729 react-native useState + JS(…)

```jsx
const [tasks, setTasks] = useState('')
// api 활용 tastk라는 [ {}, {}, {} ] 배열 가져오기

// id, 즉 해당 데이터의 식별자를 활용해서
// 하나씩 돌릴건데...
// 대충 코드!

const toggleReminder = (id) => {
    setTasks([...tasks].map(task => task.id === id 
      ? {...task, reminder: !task.reminder} 
      : task))
  }
  const deleteTask = (id) => {
    setTasks([...tasks].filter(task => task.id !== id));
  }

  const addTask = (task) => {
    
    const id = Math.floor(Math.random() * 1000000);
    const newTask = {id, ...task};
    setTasks([...tasks,newTask]);
  }
```

## … 문법

- […기존배열]
    - 배열에 있는 {}, {}, {} 값들이 복사된 새로운 배열이 만들어짐
- [ … 기존배열, 새로운 값]
    - 새로운 값이 추가된 배열이 만들어짐.

 

## 작동방식

- 화면만 바꾸는 방식이 있고
- 화면을 바꿧을 때 api, 즉 서버와 통신하여 매번 데이터를 바꾸고 새롭게 갱신하는 방법이 있다

- 명언 : 성능 문제를 따져서 일을 진행하면 오히려 성능이 안 좋아진다.
- 명언2: talk is cheap, show your code

[220729 git](https://www.notion.so/220729-git-3ca947c5aad940ad9968e6d041524c16)