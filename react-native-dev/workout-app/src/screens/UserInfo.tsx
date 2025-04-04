import { View, Text, Button, StyleSheet } from 'react-native';
import { NativeStackScreenProps } from '@react-navigation/native-stack';
import { RootStackParamList } from '../../App';

type Props = NativeStackScreenProps<RootStackParamList, 'UserInfo'>;

export default function UserInfo({ navigation }: Props) {
    return (
      <View style={styles.container}>
        <Text>User Info Screen</Text>
        <Button
          title="Voltar para Login"
          onPress={() => navigation.goBack()}
        />
      </View>
    );
  }
  
  const styles = StyleSheet.create({
    container: {
      flex: 1,
      justifyContent: 'center',
      alignItems: 'center',
    },
  });