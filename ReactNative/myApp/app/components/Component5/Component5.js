import React , {Component} from 'react'
import {AppRegistry , Text , View , StyleSheet , ListView , TouchableHighlight} from 'react-native';

export default class Component5 extends Component
{
    constructor()
    {
        super()
        const ds = new ListView.DataSource({rowHasChanged: (r1, r2) => r1 !== r2});
        this.state = {
          dataSource: ds,
        };
    }
 componentDidMount()
{
    this.fetchUsers()
}

    fetchUsers()
    {
        console.log('Here')
        fetch('https://jsonplaceholder.typicode.com/users')
        .then((response) => response.json())
        .then((response) =>
        {
            this.setState(
                {
                    dataSource:this.state.dataSource.cloneWithRows(response)
                }
            )
        })
    }


    onPress(user)
    {
        this.props.navigator.push(
            {
                id:'component6',
                user:user
            }
        )
    }

    renderRow(user)
{
    return(
    <TouchableHighlight onPress={() => {this.onPress(user)}}>
    <View style = {styles.row}>
    <Text style = {styles.rowText}>
        {user.name}
    </Text>
    
    </View>
    </TouchableHighlight>
    )
    
}
 
    render()
    {
        return(
            <ListView
            dataSource={this.state.dataSource}
            renderRow={this.renderRow.bind(this)}
            />
        )
    }
}

const styles = StyleSheet.create({

    row:
    {
        flexDirection:'row',
        justifyContent:'center',
        padding:10,
        backgroundColor:'#f4f4f4',
        marginBottom:3
    },

    rowText:
    {
        flex:1
    }


}
)

AppRegistry.registerComponent('Component5' , () => Component5)