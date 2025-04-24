import { AppContainerTabParamList } from './types';
import TreinoSection from '../../screens/AppContainer/sections/TreinoSection';
import DietaSection from '../../screens/AppContainer/sections/DietaSection';
import AppContainerScreen from '../../screens/AppContainer/AppContainerScreen';
import { createMaterialTopTabNavigator } from '@react-navigation/material-top-tabs';
import AppContainerTabBar from '../../screens/AppContainer/AppContainerTabBar';

const Tab = createMaterialTopTabNavigator<AppContainerTabParamList>();

export default function AppContainerNavigator() {
    return (
        <AppContainerScreen>
            <Tab.Navigator
                tabBar={(props) => <AppContainerTabBar {...props} />}
                screenOptions={{
                    swipeEnabled: false,
                }}
            >
                <Tab.Screen name="Treino" component={TreinoSection} />
                <Tab.Screen name="Dieta" component={DietaSection} />
            </Tab.Navigator>
        </AppContainerScreen>
    );
}