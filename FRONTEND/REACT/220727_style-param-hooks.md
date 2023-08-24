# 220727 react-natve style parameter

```jsx
<Text style={
            styles.leftInnerText(user_vote)}>용서 가능</Text>

leftInnerText : (user_vote) => ({
    color:'white',
    fontWeight: user_vote === 0 ? '': user_vote === 1 ? 'bold' : '',
    textAlign: 'center',
    textAlignVertical: 'center',
    fontSize: 17,
  })
```

styles.만든스타일(변수명)

만든스타일 : (변수명) ⇒ ({ 변수사용가능 })

## 중요 : setState를 event에 넣고싶을 때

```jsx
const [user_vote, setUserVote] = useState(0);

onPress={setUserVote(1)}
```

- 이렇게 하면 무한 렌더링돼

```jsx
onPress={() => setUserVote(1)}
```

- 이렇게 해야 한 번만 돼