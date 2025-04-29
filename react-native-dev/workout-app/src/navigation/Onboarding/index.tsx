import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { OnboardingStackParamList } from './types';
import UserInfoBody from '../../screens/onboarding/UserInfoBody';
import UserInfoGender from '../../screens/onboarding/UserInfoGender';

const Stack = createNativeStackNavigator<OnboardingStackParamList>();

export default function OnboardingNavigator() {
    return (
        <Stack.Navigator screenOptions={{ headerShown: false }}>
            <Stack.Screen name="UserInfoGender" component={UserInfoGender} />
            <Stack.Screen name="UserInfoBody" component={UserInfoBody} />
        </Stack.Navigator>
    );
}