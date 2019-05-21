import React , {Component} from 'react'
import {AppRegistry , Text , View , StyleSheet , TouchableHighlight , TouchableOpacity} from 'react-native';

//importing component 2


export default class Component2 extends Component
{
    onPress()
    {
        console.log('Space pressed')
    }

    render()
    {
        return(
<View>
    <View style = {styles.myView}>
        <Text style = {styles.myText}>Hello Brad</Text>
        </View>
                <View style = {styles.container}>
                
                <TouchableHighlight
                style = {styles.v1} 
                onPress = {this.onPress}
                underlayColor = "blue">
                <View style = {styles.v1}>
                <Text> View-1</Text>
                </View>
                </TouchableHighlight>
           
                <TouchableOpacity 
                style = {styles.v2} 
                onPress = {this.onPress}
                >
                <View style = {styles.v2}>
                <Text> View-2</Text>
                </View>
                </TouchableOpacity>
           
                <View style = {styles.v3}>
                <Text> View-3</Text>
                </View>

                </View>
                
        
</View>
        )
    }
}
const styles = StyleSheet.create(
    {
        myView:
        {
            backgroundColor:'blue'
        },
        myText:
        {
            color:'white'
        },
        container:
        {
            flexDirection:'row',
            height:100,
        },
        v1:
        {
            backgroundColor:'green',
            padding:10,
            
        },
        v2:
        {
            backgroundColor:'yellow',
            padding:10
        },
        v3:
        {
            backgroundColor:'red',
            padding:10
        }
    }
)


AppRegistry.registerComponent('Component2' , () => Component2)