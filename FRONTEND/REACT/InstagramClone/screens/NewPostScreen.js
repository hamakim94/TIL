import { SafeAreaView } from 'react-native'
import React from 'react'
import AddNewPost from '../components/newPost/AddNewPost'
import { GestureHandlerRootView } from 'react-native-gesture-handler'

const NewPostScreen = ({navigation}) => {
  return (
      <SafeAreaView style={{backgroundColor:'black', flex:1}}>
          <AddNewPost navigation={navigation}></AddNewPost>
      </SafeAreaView>

  )
}

export default NewPostScreen