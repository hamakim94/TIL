import { View, Text, StyleSheet, Image, TouchableOpacity } from 'react-native'
import React from 'react'
import FormicPostUploader from './FormicPostUploader'


const AddNewPost = ({navigation}) => {
  return (
    <View style={styles.container}>
        <Header navigation={navigation}></Header>
        <FormicPostUploader navigation= {navigation}></FormicPostUploader>
    </View>
  )
}

const Header = ({navigation}) => (
    <View style={styles.headerContainer}>
        <TouchableOpacity onPress={ () => navigation.goBack()}>
            <Image 
                source={{ uri : 'https://img.icons8.com/ios-glyphs/90/ffffff/back.png'}}
                style={{width : 30, height : 30}}/>
        </TouchableOpacity>
        <Text style={styles.headerText}>NEW POST</Text>
        <Text></Text>
    </View>
)
const styles = StyleSheet.create({
    container : {
        marginHorizontal: 10,
    },

    headerContainer : {
        marginTop : 10,
        flexDirection : 'row',
        justifyContent : 'space-between',
        alignItems : 'center',
    },

    headerText : {
        color : '#fff',
        fontWeight : '700',
        fontSize : 20,
        marginRight : 25,
    }

})

export default AddNewPost