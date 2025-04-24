import React from 'react';
import { Text, StyleSheet, ScrollView } from 'react-native';
import { AppContainerTabParamList } from '../../../navigation/AppContainer/types';
import { MaterialTopTabScreenProps } from '@react-navigation/material-top-tabs';

type Props = MaterialTopTabScreenProps<AppContainerTabParamList, 'Treino'>;

export default function TreinoSection({ navigation, route }: Props) {
  return (
    <ScrollView style={styles.sectionContainer}>
        <Text>Conteúdo específico de Treinos</Text>
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