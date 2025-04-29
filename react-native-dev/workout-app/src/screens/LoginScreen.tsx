import { StyleSheet, Text, View, TouchableOpacity, SafeAreaView } from 'react-native';
import { NativeStackScreenProps } from '@react-navigation/native-stack';
import { TextInput } from 'react-native-paper';
import React from 'react';
import { RootStackParamList } from '../navigation/types';

type Props = NativeStackScreenProps<RootStackParamList, 'Login'>;

export default function LoginScreen({ navigation }: Props) {
    const [text, setText] = React.useState('');
    const [showPassword, setShowPassword] = React.useState(false);
    const [password, setPassword] = React.useState('');

    const togglePasswordVisibility = () => {
        setShowPassword(!showPassword);
    };
    const handleForgotPassword = () => {
        console.log("Navegar para tela de recuperação");
        // navigation.navigate('ForgotPassword');
    };
    const handleRegisterAccount = () => {
        console.log("Navegar para tela de registrar");
        navigation.navigate('RegisterAccount');
    }

    const handleFirstEntryOnRegister = () => {
        navigation.navigate('Onboarding');
    }

    return (
        <SafeAreaView style={styles.container}>
            <View style={styles.textContainer}>
                <Text style={styles.text}>Entre com sua Conta</Text>
            </View>

            <View style={styles.inputContainer}>
                <TextInput
                    style={styles.input}
                    mode="outlined"
                    placeholder="Email"
                    placeholderTextColor="#777"
                    underlineColor="#777"
                    selectionColor="#fff"
                    activeOutlineColor="#fff"
                    textColor="#fff"
                    value={text}
                    onChangeText={text => setText(text)}
                    left={<TextInput.Icon icon="email" color="#fff" style={styles.icon}/>}
                />
            </View>
            <View style={styles.inputContainer}>
                <TextInput
                    style={styles.input}
                    mode="outlined"
                    placeholder="Senha"
                    placeholderTextColor="#777"
                    underlineColor="#777"
                    selectionColor="#fff"
                    activeOutlineColor="#fff"
                    textColor="#fff"

                    value={password}
                    onChangeText={setPassword}
                    secureTextEntry={!showPassword}
                    left={<TextInput.Icon icon="lock" color="#fff" />}
                    right={
                      <TextInput.Icon
                        icon={showPassword ? "eye-off" : "eye"}
                        color="#fff"
                        onPress={togglePasswordVisibility}
                      />
                    }
                />
            </View>

            <TouchableOpacity 
                style={styles.bttn}
                // onPress={() => navigation.navigate('AppContainer')}
                onPress={handleFirstEntryOnRegister}
            >
                <Text style={styles.bttnText}>Login</Text>
            </TouchableOpacity>

            <TouchableOpacity 
                onPress={handleForgotPassword}
                // accessible={true}
                // accessibilityLabel="Recuperar senha"
                // accessibilityHint="Navega para tela de recuperação de senha"
            >
                <Text style={styles.forgotPasswordText}>Esqueceu sua senha?</Text>
            </TouchableOpacity>

            <View style={styles.footer}>
                <Text style={styles.footerText}>Não possui conta? </Text>
                <TouchableOpacity onPress={handleRegisterAccount}>
                    <Text style={styles.registerLink}>Registre aqui.</Text>
                </TouchableOpacity>
            </View>
        </SafeAreaView>
    );
}

const styles = StyleSheet.create({
    footer: {
        flexDirection: 'row',
        justifyContent: 'center',
        alignItems: 'center',
        marginTop: 20,
        position: 'absolute',
        bottom: 20,
        width: '100%',
        marginBottom: 10,
    },
        footerText: {
        color: '#fff',
        fontSize: 16,
    },
        registerLink: {
        color: '#b4d343',
        fontSize: 16,
        fontWeight: 'bold',
        textDecorationLine: 'underline',
    },
    forgotPasswordText: {
        color: '#b4d343',
        fontSize: 16,
        textDecorationLine: 'underline',
        marginTop: 12,
    },
    icon: {
    },
    inputContainer: {
        flexDirection: 'row',
        alignItems: 'center',
    },
    textContainer: {
        width: '80%',
        marginBottom: 24
    },
    container: {
      flex: 1,
      backgroundColor: '#000',
      alignItems: 'center',
      justifyContent: 'center'
    },
    text: {
        color: '#fff',
        fontSize: 36,
    },
    input: {
        backgroundColor: '#2e2e2e',
        display: 'flex',
        width: '80%',
        margin: 6,
      },
    bttn: {
        backgroundColor: '#b4d343',
        width: '80%',
        padding: 12,
        borderRadius: 50,
        marginTop: 12
    },
    bttnText: {
        textAlign: 'center',
        fontWeight: '500',
        fontSize: 18,
    }
});