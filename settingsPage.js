/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 */

import React, { Component } from 'react';

import {
  AppRegistry,
  Button,
  NativeModules,
  Platform,
  StyleSheet,
  Text,
  TextInput,
  View
} from 'react-native';

const activityStarter = NativeModules.ActivityStarter;

export default class settingsPage extends Component {
  constructor(props) {
    super(props);
    this.state = { text: 'Demo text for custom edit menu' };
  }

  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome to React Native ({this.props.buildType})!
        </Text>
        <Text style={styles.instructions}>
          <Text>To get started, edit </Text>
          <Text style={styles.bold}>index.android.js</Text>
          <Text>.</Text>
        </Text>
        <Text style={styles.instructions}>
          Double tap R on your keyboard to reload,{'\n'}
          Shake or press menu button for dev menu
        </Text>
        {
          Platform.select({
            android: (
              <TextInput
                style={styles.textInput}
                value={this.state.text}
                onChangeText={(text) => this.setState({text})}
              />)
          })
        }
        <View style={styles.buttonContainer}>
          <Button
            onPress={() => activityStarter.navigateToExample()}
            title='Start example activity'
          />


        </View>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  bold: {
    fontWeight: "bold",
  },
  buttonContainer: {
    height: 300,
    width: "80%",
    justifyContent: 'space-between',
    marginTop: 30,
  },
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#E5ECFF',
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
  textInput: {
    backgroundColor: 'white',
    borderColor: 'gray',
    borderWidth: 1,
    height: 40,
    marginTop: 20,
    textAlign: "center",
    width: "80%",
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
});
