import React, { Component } from "react";
import {
    View,
    Text,
    StyleSheet,
    Button,
    TouchableOpacity,
    StatusBar
} from "react-native";

import Icon from 'react-native-vector-icons/Ionicons'


class OpenScreen extends Component {

    static navigationOptions = {
        header: null
    }

    render() {
        return (
            <View style={styles.container}>

                <Text style={styles.titleText}>
                    CarSearch
            </Text>

                <StatusBar
                />
                <TouchableOpacity onPress={() => this.props.navigation.navigate('Home')}>
                    <Text style={styles.text}><Icon name="ios-car" size={150} /></Text>
                </TouchableOpacity>

                <View>
                    <Text style={styles.classText}>
                        2XB3 Group 2
            {/* </Text>
                    <Text style={styles.namesText}>
                        Nico Stepan
            </Text>
                    <Text style={styles.namesText}>
                        Anant Jain
            </Text>
                    <Text style={styles.namesText}>
                        Kuber Khanna
            </Text>
                    <Text style={styles.namesText}>
            Karanjot Sahni */}
            </Text>
                </View>

            </View>
        );
    }
}
export default OpenScreen;

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#336dce',
        alignItems: 'center',
        justifyContent: 'center'
    },
    text: {
        fontSize: 100,
        color: '#ffffff',
        marginBottom: 200,
    },
    titleText: {
        fontSize: 60,
        color: '#ffffff',
        marginBottom: 20,
    },
    classText: {
        fontSize: 30,
        color: '#ffffff',
        marginBottom: 10,
    }
});

