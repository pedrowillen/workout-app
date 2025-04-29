import { StyleSheet, TouchableOpacity, View, Text, SafeAreaView } from 'react-native';

export default function UserInfoLayout({ children }: { children: React.ReactNode }) {
    return (
        <SafeAreaView style={styles.container}>
            <View style={styles.header}>
                <Text style={styles.headerTextTitle}>Conte-nos sobre você</Text>
                <Text style={styles.headerTextDesc}>Para uma melhor experiência, forneca as
                seguintes informações abaixo, isso será importante para o seu desempenho e rendimento para alcançar os seus objetivos!</Text>
            </View>

            <View>
                { children }
            </View>

            <View style={styles.footer}>    
                <TouchableOpacity 
                    style={styles.bttn}
                    // onPress={() => navigation.navigate('AppContainer')}
                >
                    <Text style={styles.bttnText}>Login</Text>
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
    header: {
        backgroundColor: '#800',
        position: 'absolute',
        top: 20,
        marginTop: 25,
        width: '100%',
        marginBottom: 10,
    },
    headerTextTitle: {
        color: '#fff',
        fontSize: 22,
        fontWeight: 'bold',
    },
    headerTextDesc: {
        color: '#fff',
        fontSize: 18,
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
    },
    footer: {
        backgroundColor: '#800',
        flexDirection: 'row',
        justifyContent: 'center',
        alignItems: 'center',
        marginTop: 20,
        position: 'absolute',
        bottom: 20,
        width: '100%',
        marginBottom: 10,
    },
});