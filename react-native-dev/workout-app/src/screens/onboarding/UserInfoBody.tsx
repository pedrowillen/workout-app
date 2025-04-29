import { StyleSheet, TouchableOpacity, Text, View } from 'react-native';
import { NativeStackScreenProps } from '@react-navigation/native-stack';
import React from 'react';
import { OnboardingStackParamList } from '../../navigation/Onboarding/types';
import UserInfoLayout from './layout/UserInfoLayout';

type Props = NativeStackScreenProps<OnboardingStackParamList, 'UserInfoBody'>;

export default function UserInfoBody( {navigation} : Props ) {
    const NavigatetoUserInfoGoalScreen = () => {
        navigation.navigate('UserInfoGoal');
    }

    return (
        <UserInfoLayout onPressBttn={NavigatetoUserInfoGoalScreen}>
            <View style={styles.container}>
                <View>

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
    
});