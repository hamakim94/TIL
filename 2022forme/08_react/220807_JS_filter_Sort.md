## Arrays.sort(callback(a,b))

```jsx

      if (isPopular === '인기순') { // 인기순이니?
        res.data.sort(function (a, b) {
          const participantsA = a.opt1Selected + a.opt2Selected;
          const participantsB = b.opt1Selected + b.opt2Selected;
          if (participantsA > participantsB) return -1;
          if (participantsA === participantsB) return 0;
          if (participantsA < participantsB) return 1;
        });
      } else { // 최신순이니?
        res.data.sort(function (a, b) {
          if (a.boardId > b.boardId) return -1;
          if (a.boardId === b.boardId) return 0;
          if (a.boardId < b.boardId) return 1;
        });
      }
```

- 기본 골자는 Java Comparator와 비슷
- (a,b)에 관하여, 특정 조건을 걸고
    - 1이면 두개 자리 바꿔
    - -1 이면 그대로 유지해
    - 0이면
        - 추가조건 넣거나
        - 그냥 하던가..

---

## 복잡해진 useEffect(필터링 할 때 마다 axios 요청하게..)

```jsx
useEffect(() => {
    UseAxios.get('/boards/list', {
      params: {categorycode: filterToCode[filterName]},
    }).then(res => {
      if (isPopular === '인기순') { // 인기순이니?
        res.data.sort(function (a, b) {
          const participantsA = a.opt1Selected + a.opt2Selected;
          const participantsB = b.opt1Selected + b.opt2Selected;
          if (participantsA > participantsB) return -1;
          if (participantsA === participantsB) return 0;
          if (participantsA < participantsB) return 1;
        });
      } else { // 최신순이니?
        res.data.sort(function (a, b) {
          if (a.boardId > b.boardId) return -1;
          if (a.boardId === b.boardId) return 0;
          if (a.boardId < b.boardId) return 1;
        });
      }
      setBoards(res.data);
    });
  }, [filterName, userData, isFocused, isPopular]);
```

필터 이름이 바뀔 때, 

userData 바뀔때(로그인, 로그아웃), 

포커싱이 바뀔때(페이지 왔다갔다, react-navigation의 속성), 

isPopular(최신, 인기순)