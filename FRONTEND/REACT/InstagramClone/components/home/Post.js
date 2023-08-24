import { View, Text, Image, StyleSheet, TouchableOpacity } from 'react-native'
import React from 'react'
import { Divider } from 'react-native-elements/dist/divider/Divider'

const Post = ({ post }) => {
  return (
    <View style={{ marginBottom: 30 }}>
      <Divider width={1} height={1} orientation='vertical' style={{ backgroundColor: 'gray' }}/>
      <PostHeader post={post}></PostHeader>
      <PostImage post={post}></PostImage>
      <View style={{marginHorizontal:15, marginTop:10}}>
        <PostFooter></PostFooter>
        <Likes post={post}></Likes>
        <Caption post={post}></Caption>
        <CommentSection post={post}></CommentSection>
        <Comments post={post}></Comments>
      </View>
      
    </View>
  )
}

const postFooterIcons = [
  {
    name : 'Like',
    imageUrl:
      'https://img.icons8.com/material-outlined/60/ffffff/filled-like.png',
    likedImageUrl:
    'https://img.icons8.com/ios-glyphs/90/fa314a/filled-like.png',
  },
  {
    name : 'Comment',
    imageUrl:
      'https://img.icons8.com/material-outlined/60/ffffff/filled-topic.png',
  },
  {
    name : 'Share',
    imageUrl:
      'https://img.icons8.com/material-outlined/60/ffffff/share.png',
  },
  {
    name : 'Save',
    imageUrl:
      'https://img.icons8.com/material-outlined/60/ffffff/save.png',
  },

]

const PostHeader = ({ post }) => (
  <View style={{ flexDirection: 'row',
                 justifyContent: 'space-between', 
                 margin: 5, 
                 alignItems: 'center' 
              }}>
    <View style={{flexDirection:'row', alignItems:'center'}}>
      <Image source={{uri: post.profile_picture}} style={styles.story}></Image>
      <Text style={{ color : 'white', marginLeft : 5, fontWeight : '700'}}>{post.user}</Text>
    </View>
    <Text style={{color:'white', fontWeight:'700'}}>
      ...
    </Text>
  </View>
)
const PostImage = ({post}) => (
  <View style={{ width : '100%' , height:450}}>
    <Image  source={{uri : post.imageUrl}} 
            style={{ height:'100%', resizeMode : 'cover' }}
    />
  </View>
)


const PostFooter = () => (
  <View style={{flexDirection: 'row'}}>
    <View style={styles.leftFooterIconsContainer}>
      <Icon imgStyle={styles.footerIcon} imageUrl={postFooterIcons[0].imageUrl}></Icon>
      <Icon imgStyle={styles.footerIcon} imageUrl={postFooterIcons[1].imageUrl}></Icon>
      <Icon imgStyle={[styles.footerIcon, styles.shareIcon]} imageUrl={postFooterIcons[2].imageUrl}></Icon>
    </View>

    <View style={{flex:1, alignItems:'flex-end'}}>
      <Icon imgStyle={styles.footerIcon} imageUrl={postFooterIcons[3].imageUrl}></Icon>
    </View>
  </View>
)

const Icon = ({imgStyle, imageUrl}) => (
  <TouchableOpacity>
    <Image style = {imgStyle} source={{ uri : imageUrl}}></Image>
  </TouchableOpacity>
)

const Likes = ({post}) => (
  <View style={{flexDirection : 'row', marginTop : 4}}>
    <Text style={{color : 'white' ,fontWeight:'700'}}>{post.likes.toLocaleString('en')} likes</Text>
  </View>
)

const Caption = ({post}) => (
  <View style={{marginTop:5}}>
    <Text style={{color:'white'}}>
      <Text style={{fontWeight:'bold'}}>{post.user}</Text>
      <Text > {post.caption}</Text>
    </Text>
  </View>
)

// 0 comments : Don't render component
// 1 comment : render component without "all" and singular comment
// 2 comment : render component "all" and plural comment
const CommentSection = ({post}) => (
  <View style={{marginTop : 5}}>
     {/* javaScript !! -> not not, returns numbers into boolean */}
      { !!post.comments.length && ( 
        <Text style={{color:'gray'}}>
        View{post.comments.length > 1 ? ' all' : ''} {post.comments.length}{' '}
        {post.comments.length > 1 ? 'comments' : 'comment'}
        </Text>
        )
      }
    
  </View>
)

const Comments = ({post}) => (
  <>
    {post.comments.map((comment, index) => (
      <View key={index} style={{flexDirection:'row', marginTop:5}}>
        <Text style={{color:'white'}}>
          <Text style={{fontWeight:'600'}}>{comment.user}</Text>
          {' '}{comment.comment}
        </Text>
      </View>
    ))}
  </>
)

const styles = StyleSheet.create({
  story:{
      width:35,
      height:35,
      borderRadius: 50,
      marginLeft:6,
      borderWidth :1,
      borderColor:'#ff8501',
  },
  footerIcon : {
    width : 33,
    height : 33,
  },
  shareIcon :{
    transform:[{rotate: '320deg'}],
    marginTop : 3,
  },

  leftFooterIconsContainer:{
    flexDirection:'row',
    width:'32%',
    justifyContent:'space-between',
  },
})
export default Post;