## React native Dimensions

- 각 기기의 사이즈 높이를 픽셀로 나타내주는 것!

```jsx
const windowHeight = Dimensions.get('window').height * 0.935;
```

이런식으로 커스텀해서 쓴다(바텀탭의 높이가 0.065 인 경우

---

## FlatList Pagination Props

### 1. snapToAlignment="start"

### 2. snapToInterval={windowHeight}

### 3. decelerationRate={"fast"}

- 이 세게 prop으로 추가하면, 빠르게 화면 이동돼서 다음으로 가짐
snapToInterval={windowHeight}
decelerationRate={"fast"}

---

## FlatList Performance

### maxToRenderPerBatch

- 최대 몇개 렌더링 할껀지, 2개면 딱 2개만

### renderItem, keyExtractor 따로 뺴고, useMemo 활용해 renderItem에 넣기

```jsx
const memoizedItem = useMemo(() => renderItem, [boards]);
```

### 전체 코드(민균버전) ⇒ 한 화면에 하나씩 휘릭(like youtube shorts)

```jsx
import React, {useCallback, useEffect, useMemo, useState} from 'react';
import {View, FlatList, Dimensions} from 'react-native';
import Flows from '../../components/flow/Flows';
import UseAxios from '../../util/UseAxios';

const windowHeight = Dimensions.get('window').height * 0.935;

function FlowScreen({navigation}) {
  const [boards, setBoards] = useState([]);

  useEffect(() => {
    UseAxios.get('/boards/flow').then(res => {
      setBoards(res.data);
    });
  }, []);

  const renderItem = ({item}) => (
    <Flows board={item} navigation={navigation}></Flows>
  );

  const memoizedItem = useMemo(() => renderItem, [boards]);

  const keyExtractor = useCallback(item => item.boardId, []);

  const snapToOffsets = useMemo(
    () =>
      Array.from(Array(boards.length)).map((_, index) => index * windowHeight),
    [boards],
  );
  return (
    <View style={{flex: 1}}>
      <FlatList
        showsVerticalScrollIndicator={false}
        removeClippedSubviews={true}
        legacyImplementation={true}
        maxToRenderPerBatch={1}
        initialNumToRender={1}
        windowSize={2}
        data={boards}
        renderItem={memoizedItem}
        keyExtractor={keyExtractor}
        snapToAlignment="start"
        snapToInterval={windowHeight}
        decelerationRate={"fast"}
        //snapToOffsets={snapToOffsets}
        disableIntervalMomentum={true}></FlatList>
    </View>
  );
}
export default FlowScreen;
```