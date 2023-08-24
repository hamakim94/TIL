import { View, Text, StyleSheet, Pressable, TouchableOpacity } from 'react-native'
import React , {useState} from 'react'
import { TextInput } from 'react-native-gesture-handler'

import { Formik } from 'formik'
import * as Yup from 'yup'

const LoginForm = () => {
    const LoginFormSchema = Yup.object().shape({
        email : Yup.string().email().required('An email is required'),
        password : Yup.string()
            .required()
            .min(6, 'Your password has to have at least 6 characters')
    })

    const Valiadator =  (text) => {
        const reg = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
        return reg.test(text)
    }

    return (
        <View style={styles.wrapper}>
            <Formik
            initialValues={{email : '', password : ''}}
            onSubmit={ (values) => console.log(values)}
            validationSchema={LoginFormSchema}
            validateOnMount={true}
            >
            {({handleChange, handleBlur, handleSubmit, values, isValid}) => 
            (
                <>
                    <View style={[
                        styles.inputField,
                            {
                                borderColor :
                                    values.email.length < 1 || Valiadator(values.email)
                                    ?'#ccc' 
                                    :'red'
                            },
                        ]}
                        >
                        <TextInput
                            placeholderTextColor='#444'
                            placeholder='Phone number ,username, or email'
                            autoCapitalize='none'
                            keyboardType='email-address'
                            textContentType='emailAddress'
                            autoFocus={true}
                            onChangeText={handleChange('email')}
                            onBlur={handleBlur('email')}
                            value = {values.email}
                        />
                    </View>
                    <View style={[
                        styles.inputField, {
                            borderColor : 
                                1 > values.password.length  || values.password.length >= 6
                                ?'#ccc' 
                                :'red'
                            },
                        ]}>
                        <TextInput
                            placeholderTextColor='#444'
                            placeholder='password'
                            autoCapitalize='none'
                            autoCorrect={false}
                            secureTextEntry={true}
                            textContentType='password'
                            onChangeText={handleChange('password')}
                            onBlur={handleBlur('password')}
                            value = {values.password}
                        />
                    </View>
                    <View style={{ alignItems:'flex-end', marginBottom:10}}>
                        <Text style={{color:'#6BB0F5'}}>Forgot password</Text>
                    </View>
                    
                    <Pressable  
                    titleSize={20} 
                    style={styles.button(isValid)} 
                    onPress= { handleSubmit }
                    disabled={!isValid}>
                        <Text style = {styles.buttonText}>Log in</Text>
                    </Pressable>

                    <View style={styles.signupContainer}>
                        <Text>Don't have an account? </Text>
                        <TouchableOpacity>
                            <Text style={{color : '#6BB0F5'}}> Sign in</Text>
                        </TouchableOpacity>
                    </View>
                </>
            )}
            </Formik>
        </View>
    )
}
const styles = StyleSheet.create({
    wrapper : {
        marginTop : 60,
    },
    inputField : {
        borderRadius:4,
        borderColor:'gray',
        backgroundColor:'#FAFAFA',
        marginBottom:10,
        borderWidth:1,
        minHeight:40
    },
    button : (isValid) => ({
        backgroundColor: isValid ? '#0096F6' : '#9ACAF7',
        alignItems : 'center',
        justifyContent : 'center',
        minHeight : 42,
        borderRadius : 10,
    }),
    buttonText : {
        fontWeight : '600',
        color : '#fff',
        fontSize : 20,
    },
    signupContainer : {
        flexDirection :'row',
        width : '100%',
        justifyContent : 'center',
        marginTop : 50,
    },
})

export default LoginForm