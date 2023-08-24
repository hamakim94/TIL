## 맨 위로 갔을 때 세팅

- refreshing이라는 변수 useState로 선언
- 비동기 데이터 가져오기 함수로 만들기
    - 여기서 조건 : 새로고침중이면 하지말고, 새로고침중 아니면 해
- FlatList props에 추가!

```jsx
const [refreshing, setRefreshing] = useState(false);

const getData = () => {
    setRefreshing(true);                                  //이거!
    UseAxios.get('/boards/list', {
      params: {categorycode: filterToCode[filterName]},
    })
      .then((res) => {
        setBoards(res.data);
      })
      .then(() => setRefreshing(false));                  // 이거
  };
```

```jsx
const onRefresh = () => {
    if (!refreshing) {
      getData();                    // 비동기 데이터 가져오는 함수!
    }
  };
```

```jsx
<FlatList
            showsVerticalScrollIndicator={false}
            removeClippedSubviews={true}
            legacyImplementation={true}
            data={boards}
            renderItem={renderItem}
            keyExtractor={keyExtractor}
            maxToRenderPerBatch={10}
            initialNumToRender={10}
            disableVirtualization={true}
            onRefresh={onRefresh}                       // 이 두줄 추가하면
            refreshing={refreshing}></FlatList>         // 자동으로 데이터 가져와줌
```