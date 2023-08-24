# 0724 react-navigation

[https://reactnavigation.org/](https://reactnavigation.org/)  docs 공부..

# 왜 쓸까??

- 웹 브라우저는 a 태그로 해당 URL을 browser history stack에 push함
- 백 버튼을 누르면 스택에서 하나 back 함
- 리액트 네이티브는 global history stack이 없기 때문에 만들어짐

## 웹이랑 차이점?

- React Navigation’s native stack navigator는 스택의 경로들을 왔다갔다할 때 제스쳐와 애니메이션을 인식함

```jsx
// app.js

import * as React from 'react';
import { View, Text } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

const Stack = createNativeStackNavigator();

function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Home" component={HomeScreen} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

export default App;
```

- Stack.Screen 이라는 컴포넌트를 통해서 왔다, 2가지 prop : 이름, 해당 컴포넌트!
    - name, component prop!
- We prefer capitalizing our route names.
- **주의** component props는 component를 반환하지 함수형으로 return된걸 반환하진 않아!
    - component = { () ⇒ <HomeScreen /> }
    - render를 만나는 순간 모든 데이터가 날아간다고 보면된다.

# 페이지 이동

- naviagtion.navigate(’RouteName’)

```jsx
function HomeScreen({ navigation }) {
  return (
    <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
      <Text>Home Screen</Text>
      <Button
        title="Go to Details"
        onPress={() => navigation.navigate('Details')}
      />
    </View>
  );
}
```

- Stack.navigator 안에 들어가 있으면 {navigator} 객체를 prop해서 쓸 수 있는듯!

## 이름이 같은 페이지를 여러번 이동하기?

같은 페이지 여러 개 움직이는 방법

```jsx
<Button
  title="Go to Details... again"
  onPress={() => navigation.push('Details')}
/>
```

push하면 naviagation stack에 새로운 루트를 쌓음. navigate로 같은걸 들어가면 이미 그 페이지에 있기 때문에 안 들어가지는데, push 하면 가진다

## 뒤로 가기?

```jsx
// 물론, 컴포넌트는 naviagtion을 prop으로 받아야 함
<Button title="Go back" onPress={() => navigation.goBack()} />
```

## 첫 페이지로 가는 법

```jsx
<Button
        title="Go back to first screen in stack"
        onPress={() => navigation.popToTop()}
      />
```

- 스택에 첫 스크린으로 간다, push가 아니라 stack에 안 쌓일듯

# navigation 활용 전달하기

## 사용법

```jsx
navigation.navigate('RouteName', { paramName: 'value' }).
```

- screen 안에서, ({ navigation, route}) 로 위에서 받고
    - route.params 로 접근 가능
- setParams를 활용해 바꿀 수 있다. `navigation.setParams`

## 주의점

- navigation 자체를 url이라고 생각하기
- 최소한의 정보만 담아서 받아와야 한다
1. IDs like user id, item id etc., e.g. `navigation.navigate('Profile', { userId: 'Jane' })`
2. Params for sorting, filtering data etc. when you have a list of items, e.g. `navigation.navigate('Feeds', { sortBy: 'latest' })`
3. Timestamps, page numbers or cursors for pagination, e.g. `navigation.navigate('Chat', { beforeTime: 1603897152675 })`
4. Data to fill inputs on a screen to compose something, e.g. `navigation.navigate('ComposeTweet', { title: 'Hello world!' })`

# HeaderBar 만들기

```jsx
<Stack.Screen
          name="Home"
          component={HomeScreen}
          options={{ title: 'My home' }}
        />
```

- options prop을 활용해 제목을 달 수 있음
- options를 함수로 만들면 무언갈 받아서 제목에 넣을 수 도 !
- screenOption을 활용해 ㅅ택 네비게이터를 꾸밀 수도 있어.

```jsx
function StackScreen() {
  return (
    <Stack.Navigator
      screenOptions={{
        headerStyle: {
          backgroundColor: '#f4511e',
        },
        headerTintColor: '#fff',
        headerTitleStyle: {
          fontWeight: 'bold',
        },
      }}
    >
      <Stack.Screen
        name="Home"
        component={HomeScreen}
        options={{ title: 'My home' }}
      />
    </Stack.Navigator>
  );
}
```

# 사용하기

npm install @react-navigation/native

npm install react-native-screens react-native-safe-area-context

## prob1. formik - Alert 동시 사용 불가능

- 가설 1. handleSubmit 이라는 자체 메서드 → formik 상단 부분에 onSubmit에서알림창 띄우면 되려나 → 정.답.

## prob2. npm dependencies

'@react-navigation/bottom-tabs’ import error

- 대부분 dependencies 오류는 yarn을 통해 해결 가능한 것 같다..
- yarn add @react-navigation/bottom-tabs

하니까 vector-icon 이랑 충돌

- yarn add react-native-vector-icons
- 그다음 실행하니 bottomtabs 사용 가능

### cf) npm vs yarn?

- npm은 하나의 패키지를 한 번 씩 설치
- yarn은 동시에 여러개 설치 가능, 보안성이 뛰어나다고 함

clonecoding 강의에선 yarn쓰면 대부분 dependencies 문제 해결된다고 해서 써봤는데 됐다..