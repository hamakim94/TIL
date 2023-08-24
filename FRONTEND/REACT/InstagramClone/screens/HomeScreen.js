import { SafeAreaView, StyleSheet, ScrollView } from 'react-native'
import React from 'react'
import Header from '../components/home/Header'
import Stories from '../components/home/Stories'
import Post from '../components/home/Post'
import { POSTS } from '../data/posts'
import BottomTabs, { bottomTabsIcons } from '../components/home/BottomTabs'

const HomeScreen = ({navigation}) => {
  return (
    <SafeAreaView style={styles.container}>
      <Header navigation={navigation}></Header>
      <Stories></Stories>
      <ScrollView>
        {POSTS.map((post, index) => (
          <Post post={post} key={index}></Post>
        ))}
      </ScrollView> 
      <BottomTabs icons={bottomTabsIcons}></BottomTabs>
    </SafeAreaView>
  )
}

const styles = StyleSheet.create({
    container: {
        backgroundColor:'black',
        flex:1,
    },
})

export default HomeScreen