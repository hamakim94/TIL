import { View, Text, StyleSheet, Image } from 'react-native'
import React from 'react'
import LoginForm from '../components/loginScreen/LoginForm'

const INSTAGRAM_LOGO = 'https://cdn2.iconfinder.com/data/icons/social-icons-33/128/Instagram-256.png'

const LoginScreen = () => (
    <View style={styles.container}>
        <View style={styles.logoContainer}>
            <Image source={{uri:INSTAGRAM_LOGO, height:70, width:70}}></Image>
        </View>
        <LoginForm></LoginForm>
    </View>
)


const styles = StyleSheet.create({
    container: {
        flex:1,
        backgroundColor:'white',
        paddingTop:30,
        paddingHorizontal:12
    },
    logoContainer : {
        alignItems : 'center',
        marginTop:30,
    },

})

export default LoginScreen