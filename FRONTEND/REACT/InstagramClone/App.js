import { View, Text } from 'react-native'
import React from 'react'
import HomeScreen from './screens/HomeScreen'
import NewPostScreen from './screens/NewPostScreen'
import SignedInStack from './navigation'

const App = () => {
  return (
    <SignedInStack></SignedInStack>
  )
}

export default App