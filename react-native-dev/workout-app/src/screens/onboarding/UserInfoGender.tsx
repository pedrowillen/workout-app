import { StyleSheet, TouchableOpacity, Text, View, StatusBar } from 'react-native';
import { NativeStackScreenProps } from '@react-navigation/native-stack';
import React, { useState } from 'react';
import { OnboardingStackParamList } from '../../navigation/Onboarding/types';
import UserInfoLayout from './layout/UserInfoLayout';
import Icon from 'react-native-vector-icons/MaterialIcons';


type Props = NativeStackScreenProps<OnboardingStackParamList, 'UserInfoGender'>;

export default function UserInfoGender( {navigation} : Props ) {
    const [selectedGender, setSelectedGender] = useState<string | null>(null);


    const NavigatetoUserInfoBodyScreen = () => {
        navigation.navigate('UserInfoBody');
    }

    return (
    <UserInfoLayout onPressBttn={NavigatetoUserInfoBodyScreen}>
        <View style={styles.container}>

            <Text style={styles.mainTitle}>Selecione o seu sexo:</Text>

            <View style={styles.bttnsContainer}>
                <TouchableOpacity style={[
                        styles.bttn,
                        selectedGender === 'male' && styles.bttnActive
                    ]}
                    onPress={() => setSelectedGender('male')}
                >
                    <Icon name="male" size={80} color={selectedGender === 'male' ? '#000' : '#fff'} />
                </TouchableOpacity>
                <TouchableOpacity style={[
                        styles.bttn,
                        selectedGender === 'female' && styles.bttnActive
                    ]}
                    onPress={() => setSelectedGender('female')}
                >
                    <Icon name="female" size={80} color={selectedGender === 'female' ? '#000' : '#fff'} />
                </TouchableOpacity>
            </View>

            <View>
                <TouchableOpacity>
                    <Text style={styles.link}>Não desejo informar.</Text>
                </TouchableOpacity>
            </View>

        </View>
    </UserInfoLayout>
    );
}

const styles = StyleSheet.create({
    container: {
        backgroundColor: '#000',
        height: '100%',
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
    },
    mainTitle: {
        color: '#fff',
        fontSize: 20,
        fontWeight: '500',
        marginBottom: 24,
    },
    bttnsContainer: {
        marginBottom: 12,
    },
    bttn: {
        width: 150,
        height: 150,
        borderRadius: '50%',
        backgroundColor: '#2e2e2e',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        marginBottom: 12,
    },
    bttnActive: {
        backgroundColor: '#b4d343',
    },
    link: {
        color: '#b4d343',
        fontSize: 16,
        fontWeight: '500',
        textDecorationLine: 'underline',
    },
});