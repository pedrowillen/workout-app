import { StyleSheet, Text, View, ScrollView, TouchableOpacity } from "react-native";
import React from "react";
import { MaterialTopTabBarProps } from "@react-navigation/material-top-tabs";

export default function AppContainerTabBar({ state, descriptors, navigation }: MaterialTopTabBarProps) {
    return (
        <View style={styles.navBarContainer}>
            <View style={styles.navBar}>
                {state.routes.map((route, index) => {
                    const { options } = descriptors[route.key];
                    const label = 
                        typeof options.tabBarLabel === 'string' 
                        ? options.tabBarLabel 
                        : options.title || route.name;

                    const isFocused = state.index === index;

                    const onPress = () => {
                        const event = navigation.emit({
                            type: 'tabPress',
                            target: route.key,
                            canPreventDefault: true,
                        });

                        if (!isFocused && !event.defaultPrevented) {
                            navigation.navigate(route.name);
                        }
                    };

                    return (
                        <TouchableOpacity
                            key={index}
                            style={[
                                styles.tabButton,
                                isFocused && styles.activeTab
                            ]}
                            onPress={onPress}
                        >
                            <Text style={[
                                styles.tabText,
                                isFocused && styles.activeText
                            ]}>
                                {label}
                            </Text>

                            {isFocused && <View style={styles.tabIndicator} />}
                        </TouchableOpacity>
                    );
                })}
            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    navBarContainer: {
        backgroundColor: '#000',
    },
    navBar: {
        flexDirection: 'row',
        paddingVertical: 12,
    },
    tabButton: {
        paddingHorizontal: 20,
        justifyContent: 'center',
        alignItems: 'center',
    },
    activeTab: {
        backgroundColor: 'transparent',
    },
    tabText: {
        color: '#fff',
        fontWeight: '500',
        fontSize: 16,
        paddingVertical: 8,
    },
    activeText: {
        color: '#b4d343',
        fontWeight: 'bold',
    },
    tabIndicator: {
        height: 3,
        width: '70%',
        backgroundColor: '#b4d343',
        position: 'absolute',
        bottom: 0,
    },
});