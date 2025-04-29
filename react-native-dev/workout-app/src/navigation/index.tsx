import { createNativeStackNavigator } from "@react-navigation/native-stack";
import { NavigationContainer } from '@react-navigation/native';
import { RootStackParamList } from "./types";
import LoginScreen from "../screens/LoginScreen";
import RegisterAccount from "../screens/RegisterAccount";
import AppContainerNavigator from "./AppContainer";
import OnboardingNavigator from "./Onboarding";

const Stack = createNativeStackNavigator<RootStackParamList>();

export default function RootNavigator() {
    return (
    <NavigationContainer>
        <Stack.Navigator>
            <Stack.Screen 
                name="Login" 
                component={LoginScreen}
                options={{ headerShown: false }}
            />
            <Stack.Screen 
                name="RegisterAccount" 
                component={RegisterAccount}
                options={{ headerShown: false }}
            />
            <Stack.Screen 
                name="AppContainer" 
                component={AppContainerNavigator}
                options={{ headerShown: false }}
            />
            <Stack.Screen 
                name="Onboarding" 
                component={OnboardingNavigator}
                options={{ headerShown: false }}
            />
        </Stack.Navigator>
    </NavigationContainer>
    );
}