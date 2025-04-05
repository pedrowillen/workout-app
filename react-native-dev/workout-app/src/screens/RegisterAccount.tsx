import { NativeStackScreenProps } from "@react-navigation/native-stack";
import { RootStackParamList } from "../../App";
import { SafeAreaView } from "react-native-safe-area-context";
import { StyleSheet, View, Text, TouchableOpacity } from "react-native";
import { TextInput } from "react-native-paper";
import React from "react";

type Props = NativeStackScreenProps<RootStackParamList, 'Login'>;

export default function RegisterAccount({ navigation }: Props) {
    const [text, setText] = React.useState('');
    const [nameText, setNameText] = React.useState('');
    const [showPassword, setShowPassword] = React.useState(false);
    const [password, setPassword] = React.useState('');

    const handleLoginScreen = () => {
        console.log("Navegar para login screen");
        navigation.navigate('Login');
    }

    const handleRegister = () => {
        console.log("Registrar");
        // navigation.navigate();
    }

    const togglePasswordVisibility = () => {
        setShowPassword(!showPassword);
    };

    return (
        <SafeAreaView style={styles.container}>
            <View style={styles.textContainer}>
                <Text style={styles.text}>Registre a sua Conta</Text>
            </View>

            <View style={styles.inputContainer}>
                <TextInput
                    style={styles.input}
                    mode="outlined"
                    placeholder="Nome e Sobrenome"
                    placeholderTextColor="#777"
                    underlineColor="#777"
                    selectionColor="#fff"
                    activeOutlineColor="#fff"
                    textColor="#fff"
                    value={nameText}
                    onChangeText={text => setNameText(text)}
                    left={<TextInput.Icon icon="account" color="#fff" />}
                />
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
                    left={<TextInput.Icon icon="email" color="#fff" />}
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
                // onPress={() => navigation.navigate('UserInfo')}
            >
                <Text style={styles.bttnText}>Criar conta</Text>
            </TouchableOpacity>

            <View style={styles.footer}>
                <Text style={styles.footerText}>Já possui conta? </Text>
                <TouchableOpacity onPress={handleLoginScreen}>
                    <Text style={styles.anchorLink}>Faça login aqui.</Text>
                </TouchableOpacity>
            </View>
        </SafeAreaView>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#000',
        alignItems: 'center',
        justifyContent: 'center'
      },
      textContainer: {
        width: '80%',
        marginBottom: 24
    },
    text: {
        color: '#fff',
        fontSize: 36,
    },
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
    anchorLink: {
        color: '#b4d343',
        fontSize: 16,
        fontWeight: 'bold',
        textDecorationLine: 'underline',
    },
    inputContainer: {
        flexDirection: 'row',
        alignItems: 'center',
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