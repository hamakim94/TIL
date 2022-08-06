
# 가짜 복사법
- 10개씩만 렌더링하고싶었음
- FlatList 끝자락에 가서, 10개 복사해서, boards에 붙여놓고, 추가하는 방식
- OnEndReached를 사용해서, get(10개 복사)하는 메서드 추가
- 로딩 하는걸 보여줌(getData : loading 변수가 false일 때만 실행)
- 추후 : FlatList maxToRenderPerBatch 이용해서 10개만..

```jsx
// 전체 가져온 데이터를 10개보다 작으면 그 개수만큼, 아니면 10개씩 복사
  const getData = start => {
    if (boards.length > start + 10) {
      setLoading(true);
      setTempBoards(temp_boards.concat([...boards].slice(start, start + 10)));
      setStartNum(start_num + 10);
      setLoading(false);
    } else if (boards.length > start) {
      setLoading(true);
      setTempBoards(temp_boards.concat([...boards]));
      setStartNum(start_num + boards.length);
      setLoading(false);
    }
  };
  // 여기서 board가 바뀌면 temp_board 복사를 딱 해야해!
  // 처음 렌더링 될 떄 , 10개 이하만 가져오기

  const onEndReached = () => { // 끝을 만나면.
    if (loading) {             // 로딩 중이면 그만하고, 로딩중이 아니라면 getData 하렴!
      return;
    } else {                   // 아니면 그만
      getData(start_num);
    }
  };

  // 나중에 코드
  <SafeAreaView style={{flex: 1, backgroundColor:'white' }}>
      <View style={{flex: 1, padding: 16}}>
        <LogoSearch navigation={navigation}></LogoSearch>
        <Divider width={0.5}></Divider>
        <FilterButtonTabs setFilterName={setFilterName} />
        <Divider width={0.5}></Divider>
        <FlatList
          showsVerticalScrollIndicator={false}
          removeClippedSubviews={true}
          legacyImplementation={true}
          data={[...boards].filter(board => board.categoryCode === filterToCode[filterName] )}
          renderItem={renderItem}
          keyExtractor={keyExtractor}
          onEndReached={onEndReached}
          onEndReachedThreshold={1}
          ListFooterComponent={
          loading && <ActivityIndicator size="large" color="#00ff00" />
          }
        ></FlatList>
      </View>
    </SafeAreaView>
```