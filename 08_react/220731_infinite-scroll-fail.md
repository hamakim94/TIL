# 220731 무한 스크롤 비스무리?

## react-native 전체 데이터 가져와 부분 렌더링 해보기

안된다. FlatList 자체가 기능이 별로라는 이야기가 많다. 앱은 실행 되고, 최적화를 여러번 시도 해 봤지만

VirtualizedList: You have a large list that is slow to update - make sure your renderItem function renders components that follow React performance best practices like PureComponent, shouldComponentUpdate, etc. {"contentLength": 9300, "dt": 856, "prevDt": 1235}

이 오류가 꼭 뜨고, useMemo, flatlist props, 다양한 시도를 해봤다..

[https://codingislove.com/optimize-react-native-flatlist-performance/](https://codingislove.com/optimize-react-native-flatlist-performance/) 여기선 1번까지만..

```jsx
const [boards, setBoards] = useState([]); // 전체게시판 가져오기
const [temp_boards, setTempBoards] = useState([]) // 부분 렌더링!
const [start_num, setStartNum] = useState(0); // 0~10깨를 배열 시작점
const [loading, setLoading] = useState(false); // 로딩인지, 안 로딩인지.

// 전체 가져온 데이터를 복사하는 함수.
  const getData = (start) => {
    if(start + 10 < boards.length ){
      console.log('복사 시작..')
      setLoading(true)
      setTempBoards(temp_boards.concat([...boards].slice(start, start+10)));
      setStartNum(start_num+10) ;
      setLoading(false)
    }
  };
// 처음 렌더링 될 떄 , 10개만 가져오기s
  if(temp_boards.length === 0){
    getData(0)
  }

const onEndReached = () => {
    // 로딩 중이면 그만하고, 로딩중이 아니라면 getData 하렴!
    if (loading) {
      return;
    } else {
      getData(start_num);
    }

<FlatList
          showsVerticalScrollIndicator={false}
          removeClippedSubviews={true}
          legacyImplementation={true}
          data={temp_boards}
          renderItem={renderItem}
          keyExtractor={keyExtractor}
          onEndReached = {onEndReached}
          onEndReachedThreshold={1}
          disableVirtualization={false} 
          ListFooterComponent={loading && <ActivityIndicator size="large" color="#00ff00"/>}
          >
        </FlatList>
```

결론 :  실행은 되는데 너무 느림, 렉걸림! 좋은 방법을 찾기

## 핸드폰으로 실행하기

- 안드로이드폰 개발자 모드 설정
- usb로 연결
- adb devices해서 뭐 뜨면 ok, 안 뜨면
- [https://gdpark.tistory.com/99](https://gdpark.tistory.com/99)
- 참고해서 환경변수 설정 해주고 npx react-native run-android하면 폰에서 실행!

C:\Users\***\AppData\Local\Android\Sdk\platform-tools