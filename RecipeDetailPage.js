import React, { Component } from 'react';

import {
  AppRegistry,
  Button,
  NativeEventEmitter,
  NativeModules,
  Platform,
  StyleSheet,
  Text,
  TextInput,
  View,
  ScrollView,
  Image,
  Dimensions,
} from 'react-native';

const activityStarter = NativeModules.ActivityStarter;


export default class RecipeDetailPage extends Component {
     constructor(props) {
       super(props);
       this.state = { text: 'Demo text for custom edit menu' };
       //
     }

  componentDidMount() {
     fetch(`https://www.food2fork.com/api/get?key=5e3af3fd8175a49108c8227793ab0044&rId=` + this.props.key1)
       .then(res => res.json())
       .then(json => {this.setState({ data: json })})
       .then(json => {this.setState({stringToShow : stringListToText(this.state.data.recipe.ingredients)})})
   }

render() {
  if(this.state.data)
  {
    return (<ScrollView><Image source={{uri: this.state.data.recipe.image_url.replace("http", "https"),width: 100,height: 100}} style={ styles.headerImage }></Image><Text style={{fontSize:14}}>{stringListToText(this.state.data.recipe.ingredients)}</Text></ScrollView>);
  }
  else
  {
    return (
       <ScrollView>
       <Text style={{fontSize:14}}>Loading</Text>
       </ScrollView>
    );
  }

}
}

function stringListToText(p1) {
  var stringToReturn = ""
  var index = 0;
  for (var sec in p1) {
    stringToReturn = stringToReturn + p1[sec] + "\n\n"
    index = index + 1;
  }
  return stringToReturn;
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
  headerImage: {
        width: '100%',
        height: undefined,
        aspectRatio: 1,
  }
});
