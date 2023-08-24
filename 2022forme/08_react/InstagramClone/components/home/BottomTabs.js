import { View,  Image, TouchableOpacity, StyleSheet } from 'react-native'
import React, {useState} from 'react'
import { Divider } from 'react-native-elements/dist/divider/Divider'

export const bottomTabsIcons = [
    {
        name : 'Home',
        active : 'https://img.icons8.com/material-rounded/60/ffffff/home.png',
        inactive : 'https://img.icons8.com/material-outlined/60/ffffff/home--v2.png',

    },
    {
        name : 'Search',
        active : 'https://img.icons8.com/material-rounded/60/ffffff/home.png',
        inactive : 'https://img.icons8.com/material-outlined/60/ffffff/home--v2.png',

    },
    {
        name : 'Reels',
        active : 'https://img.icons8.com/material-rounded/60/ffffff/home.png',
        inactive : 'https://img.icons8.com/material-outlined/60/ffffff/home--v2.png',

    },
    {
        name : 'Shop',
        active : 'https://img.icons8.com/material-rounded/60/ffffff/home.png',
        inactive : 'https://img.icons8.com/material-outlined/60/ffffff/home--v2.png',

    },
    {
        name : 'Profile',
        active : 'https://i.imgur.com/EFeEbuJ.jpeg',
        inactive : 'https://i.imgur.com/EFeEbuJ.jpeg',

    },
]

const BottomTabs = ({icons}) => {

    const [activeTab, setActiveTab] = useState('Home')

    const Icon = ({icon}) => (
        <TouchableOpacity onPress={() => setActiveTab(icon.name)}>
            <Image 
                source={{uri: activeTab === icon.name ? icon.active : icon.inactive}} 
                style={[
                    styles.icon, 
                    icon.name === 'Profile' ? styles.profilePic() : null,
                    activeTab === 'Profile' && icon.name === activeTab
                        ? styles.profilePic(activeTab)
                        : null

                ]} 
            />
        </TouchableOpacity>
    )
        
    return (
        <View style={styles.wrapper}>
            <Divider height={1} orientation='vertical' style={{ backgroundColor: 'gray' }}/>
        
            <View style={styles.container}>
                { icons.map((icon, index) => (
                    <Icon key={index} icon ={icon}></Icon>
                    ))}
            </View>
        </View>
    )
}

const styles = StyleSheet.create({
    wrapper : {
        position :'absolute',
        width :'100%',
        bottom :'0%',
        zIndex : 999,
        backgroundColor: "#000",
    },
    container : {
        flexDirection:'row',
        justifyContent: 'space-around',
        height:50,
        paddingTop:10,

    },
    icon : {
        width : 30,
        height : 30,
    },
    profilePic : (activeTab = '') => ({
        borderRadius : 50,
        borderWidth: activeTab === 'Profile' ? 2:0,
        borderColor : '#fff'
    })
})

export default BottomTabs