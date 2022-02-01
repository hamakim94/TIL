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

#### 최고 - 1줄컷!

~~~ java
videoReviewDb = gson.fromJson(str, new TypeToken<HashMap<String, ArrayList<VideoReview>>>() {}.getType());
~~~

- type 받기 : import java.lang.reflect.Type; // 고급기능, 메타데이터

- 임포트 된거 , (+) 눌러서 펼치면 예쁘게 나온다.

### Reflection이란?

- JVM에서 실행되는 애플리케이션의 런타임 동작을 검사/수정할 수 있는 기능이 필요한 프로그램에서 사용됩니다.
- 이걸 사용해 스프링에서 런타임 시에 개발자가 등록한 bin을 애플리케이션에서 가져와 사용하는 것.
- 잘 모르지만, 쓰면 보통 느려진대
- 실행시 액세스 권한 필요 / 캡슐화 저해까지 할 수 있어 주의해서 사용해야 한다.

