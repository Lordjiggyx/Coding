import React , {Component} from 'react'
import {AppRegistry , Text , View , StyleSheet} from 'react-native';

export default class component1 extends Component
{
    constructor(props)
    {
        super(props)
        this.state = {
            name:'Brad',
            showname:false,
            message:this.props.message
        }

    }
    static defaultProps =
    {
        message:'Hi there'
    }


    render()
    {
        console.log('Hello')
        let name = this.state.showname ? this.state.name :'No Name'
        return(
            <View>
                <Text>{this.state.message} </Text>
                <Text>{name} </Text>
            </View>
        )
    }
}

AppRegistry.registerComponent('component1' , () => component1)