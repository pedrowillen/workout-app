import { StyleSheet, TouchableOpacity, Text, View, StatusBar } from 'react-native';
import React from 'react';
import { SafeAreaView } from 'react-native-safe-area-context';

export default function UserInfoLayout ({ children, onPressBttn }: { children: React.ReactNode; onPressBttn: () => void }) {
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
            <View style={styles.textContainer}>
                <Text style={styles.textTitle}>Conte-nos sobre você</Text>
                <Text style={styles.textDesc}>Para uma melhor experiência, forneca as
                seguintes informações abaixo, isso será importante para o seu desempenho e rendimento para alcançar os seus objetivos!</Text>
            </View>
            <View style={styles.mainContent}>
                { children }
            </View>
            <View style={styles.footer}>
                <TouchableOpacity style={styles.bttn} onPress={onPressBttn}>
                    <Text style={styles.bttnText}>Continuar</Text>
                </TouchableOpacity>
            </View>
        </SafeAreaView>
    
    </View>
    );
}

const styles = StyleSheet.create({
    mainContainer: {
        flex: 1,
        backgroundColor: '#000',
    },
    contentContainer: {
        flex: 1,
        paddingTop: StatusBar.currentHeight ? StatusBar.currentHeight + 12 : 24,
        alignItems: 'center',
    },
    statusBarBackground: {
        position: 'absolute',
        top: 0,
        left: 0,
        right: 0,
        height: StatusBar.currentHeight,
        backgroundColor: '#000',
    },
    bttn: {
        backgroundColor: '#b4d343',
        width: '80%',
        padding: 12,
        borderRadius: 50,
        marginTop: 12
    },
    bttnText: {
        textAlign: 'center',
        fontWeight: '500',
        fontSize: 18,
    },
    textContainer: {
        width: '80%',
        marginBottom: 24,
        // backgroundColor: '#770000'
    },
    textTitle: {
        color: '#fff',
        fontSize: 32,
        fontWeight: 500
    },
    textDesc: {
        color: '#fff',
        fontSize: 18,
        textAlign: 'center',
    },
    mainContent: {
        flex: 1,
        width: '100%',
        backgroundColor: '#770000',
    },
    footer: {
        paddingVertical: 20,
        width: '100%',
        alignItems: 'center',
    },
});