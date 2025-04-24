import { MaterialTopTabScreenProps } from '@react-navigation/material-top-tabs';
import React from 'react';
import { Text, StyleSheet, ScrollView } from 'react-native';
import { AppContainerTabParamList } from '../../../navigation/AppContainer/types';

type Props = MaterialTopTabScreenProps<AppContainerTabParamList, 'Dieta'>;

export default function DietaSection({ navigation, route }: Props) {
  return (
    <ScrollView style={styles.sectionContainer}>
      <Text>Conteúdo específico de DIETAS</Text>
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  sectionContainer: {
    flex: 1,
    padding: 16,
    backgroundColor: '#f5f5f5',
  },
});