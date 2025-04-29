import { StyleSheet, Text } from 'react-native';
import { NativeStackScreenProps } from '@react-navigation/native-stack';
import React from 'react';
import { OnboardingStackParamList } from '../../navigation/Onboarding/types';
import UserInfoLayout from './layout/UserInfoLayout';

type Props = NativeStackScreenProps<OnboardingStackParamList, 'UserInfoBody'>;

export default function UserInfoGoal( {navigation} : Props ) {
    const NavigatetoUserInfoWorkoutPlanScreen = () => {
        navigation.navigate('UserInfoWorkoutPlan');
    }

    return (
        <UserInfoLayout onPressBttn={NavigatetoUserInfoWorkoutPlanScreen}>
            <Text>USER INFO GOAL</Text>
        </UserInfoLayout>
    );
}

const styles = StyleSheet.create({
});