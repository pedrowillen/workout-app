import { StyleSheet, View, Text, TouchableOpacity, ScrollView, StatusBar } from "react-native";
import React from "react";
import { Avatar } from 'react-native-paper';
import Icon from 'react-native-vector-icons/MaterialIcons';
import { SafeAreaView } from "react-native-safe-area-context";

export default function AppContainerScreen({ children }: { children: React.ReactNode }) {
    return (
        <View style={styles.mainContainer}>
            {/* StatusBar (android/ios) */}
            <StatusBar 
                translucent 
                backgroundColor="transparent" 
                barStyle="light-content" 
            />
            
            <View style={styles.statusBarBackground} />
            
            <SafeAreaView style={styles.contentContainer} edges={['bottom', 'left', 'right']}>
                <View style={styles.header}>
                    <View style={styles.headerLeft}>
                        <Avatar.Image 
                            size={50} 
                            source={require('../../../assets/avatar-example.png')} 
                            style={styles.avatar}
                        />
                        <Text style={styles.greeting}>Olá, Pedro.</Text>
                    </View>

                    <View style={styles.headerRight}>
                        <TouchableOpacity style={styles.iconButton}>
                            <Icon name="notifications" size={26} color="#fff" />
                        </TouchableOpacity>
                        <TouchableOpacity style={styles.iconButton}>
                            <Icon name="settings" size={26} color="#fff" />
                        </TouchableOpacity>
                    </View>
                </View>
                
                {/*  */}
                {children}
            </SafeAreaView>
        </View>
    );
}

const styles = StyleSheet.create({
    mainContainer: {
        flex: 1,
        backgroundColor: '#f5f5f5',
    },
    statusBarBackground: {
        position: 'absolute',
        top: 0,
        left: 0,
        right: 0,
        height: StatusBar.currentHeight,
        backgroundColor: '#000',
    },
    contentContainer: {
        flex: 1,
    },
    header: {
        flexDirection: 'row',
        justifyContent: 'space-between',
        alignItems: 'center',
        paddingHorizontal: 16,
        paddingTop: StatusBar.currentHeight ? StatusBar.currentHeight + 12 : 24,
        paddingBottom: 12,
        backgroundColor: '#000',
    },
    headerLeft: {
        flexDirection: 'row',
        alignItems: 'center',
    },
    headerRight: {
        flexDirection: 'row',
        gap: 16,
    },
    avatar: {
        marginRight: 10,
        backgroundColor: '#e0e0e0',
    },
    greeting: {
        fontSize: 18,
        fontWeight: '500',
        color: '#fff',
    },
    iconButton: {
        padding: 4,
    },
});