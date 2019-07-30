/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 */
import settingsPage from './settingsPage';
import RecipeDetailPage from './RecipeDetailPage';

import React, { Component } from 'react';

import {
  AppRegistry,
  Button,
  NativeEventEmitter,
  NativeModules,
  Platform,
  StyleSheet,
  Text,
  Dimensions,
  TextInput,
  TouchableHighlight,
  View,
} from 'react-native';

import BatchedBridge from "react-native/Libraries/BatchedBridge/BatchedBridge";

export class ExposedToJava {
  extraMessage = "Be aware that this way of calling JavaScript is officially undocumented.\n\nIf possible, use events instead!";

  setMessage(message) {
    this.extraMessage = message;
  }

  /**
   * If this is called from an activity that doesn't forward Android life-cycle events
   * to React Native, the alert will appear to do nothing.
   */
  alert(message) {
      alert(message + "\n\n" + this.extraMessage);
  }
}

const exposedToJava = new ExposedToJava();
BatchedBridge.registerCallableModule("JavaScriptVisibleToJava", exposedToJava);

const activityStarter = NativeModules.ActivityStarter;
const eventEmitterModule = NativeModules.EventEmitter;

export default class ActivityDemoComponent extends Component {
  constructor(props) {
    super(props);
    this.state = { text: 'Demo text for custom edit menu' };
  }

  render() {
    return (
      <View style={styles.container} >
      <View style={{
        flex: 1,
        flexDirection: 'column',
        justifyContent: 'center',
        alignItems: 'stretch',
      }}>
      <TouchableHighlight onPress={() => activityStarter.navigateToExample()} underlayColor="white" style={{width:Dimensions.get('window').width, height:"25%"}}>
            <Text style={styles.button}>no</Text>
      </TouchableHighlight>
      <TouchableHighlight onPress={() => activityStarter.navigateToExample()} underlayColor="white" style={{width:Dimensions.get('window').width, height:"25%"}}>
            <Text style={styles.button,backgroundColor: '#2196F3'}>no</Text>
      </TouchableHighlight>
      <TouchableHighlight onPress={() => activityStarter.navigateToExample()} underlayColor="white" style={{width:Dimensions.get('window').width, height:"25%"}}>
            <Text style={styles.button}>no</Text>
      </TouchableHighlight>
      <TouchableHighlight onPress={() => activityStarter.navigateToExample()} underlayColor="white" style={{width:Dimensions.get('window').width, height:"25%"}}>
            <Text style={styles.button}>no</Text>
      </TouchableHighlight>
      </View>


      </View>
    );
  }
}

const styles = StyleSheet.create({
  bold: {
    fontWeight: "bold",
  },
  x: {
    width: "100%",
  },
  button: {
      width: "100%",
      height:"100%",
      backgroundColor: '#C72727',
      alignItems: 'center',
      justifyContent: 'center'
    },
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#E5ECFF',
    width: "100%",
  },

});

AppRegistry.registerComponent('ActivityDemoComponent', () => ActivityDemoComponent);
AppRegistry.registerComponent('ActivityDemoComponent2', () => settingsPage);
AppRegistry.registerComponent('RecipeDetailPage', () => RecipeDetailPage);


const eventEmitter = new NativeEventEmitter(eventEmitterModule);
eventEmitter.addListener(eventEmitterModule.MyEventName, (params) => {
  exposedToJava.setMessage(params);
  alert(params);
});
