# 22/02/01

## 다른사람 코드 보며 느낀점

- 열심히 해야겠다.. (너무잘하네)
- MainUI -> 다른 UI로 넘어갈 때, 0 입력받으면 return => 해당 while문 종료

### 지-경

~~~ java
// sel == 0일때, 모든 값 
MainUI.getInstance().service();
	break;
// 보통 return을 쓰는데, 순서때문에 이렇게 하신건가요?(신기)
~~~

~~~ java 
Type mapTokenType = new TypeToken<Map<Integer, VideoReview[]>>(){}.getType();
Map<Integer, VideoReview[]> jsonMap = gson.fromJson(jsonStr, mapTokenType);
// 이렇게 한 이유가 arraylist는 못 넣어서??
~~~





