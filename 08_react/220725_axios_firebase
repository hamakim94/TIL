```jsx
const onLogin = async(email, password) => {
try{
	await firebase.auth().signInWithEmailAndPassword(email, password)
} catch (error) {
	Alert(error.message)
}

// formik 
onSubmit={ values => {
	onLogin(values.email, values.password)
}}
```

onSubmi

## 회원가입

```jsx
const onSignup = async(email, password) => {
	try{
		await firebase.auth().createUserWithEmailAndPassword(email, password)
	} catch {
		Alert.alert(error.message)
	}

// formik 
onSubmit={ values => {
	onSignup(values.email, values.password)
}}
```

## RandomUserApi

```jsx
const getRandomProfilePicture = async () => {
	const response = await fetch('https://randomuser.me/api')
	const data = await response.json()
	return data.results[0].picture.large
}
```

firebase를 사용하면 db에 넣는 방법이 간단해짐

## 로그인 돼있다면??

```jsx
export const SignedInStack = () => (
    <NavigationContainer>
        <Stack.Navigator    
            initialRouteName='HomeScreen'
            screenOptions={screenOptions}>
            <Stack.Screen name='HomeScreen' component={HomeScreen} ></Stack.Screen>
            <Stack.Screen name='NewPostScreen' component={NewPostScreen} ></Stack.Screen>
        </Stack.Navigator>
    </NavigationContainer>
)

export const SignedOutStack = () => (
    <NavigationContainer>
        <Stack.Navigator    
            initialRouteName='LoginScreen'
            screenOptions={screenOptions}>
            <Stack.Screen name='LoginScreen' component={LoginScreen} ></Stack.Screen>
						<Stack.Screen name='SignupScreen' component={SignupScreen} ></Stack.Screen>
        </Stack.Navigator>
    </NavigationContainer>
)
```

## AuthNavigation.js

```jsx
const AuthNavigation = ()=> {
	const [currentUser, setCurrentUser] = useState(null)

	const userHandler = user => 
		user ?setCurrentUser(user) : setCurrentUser(null)

	useEffect( () => 
		firebase.auth().onAuthStateChange(user => userHandler(user)),
	[])
	return <>{currentUser? <SignedInStack/> : <SignedOutStack/> }  </>
}
```

- useEffect는 global적으로 계속 듣고있어..