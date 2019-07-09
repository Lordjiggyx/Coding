import React, { Component } from 'react'
import PropTypes from 'prop-types'
export class AddTodo extends Component {
  //state for fields
  state = {
    title : ''
  }
//Component state
//Takes value from the textfield and sets the title to equal it
//[e.target.name] as long as name is equal to the field we can use this for multiple values
onChange = (e) => this.setState({[e.target.name]:e.target.value});

onSubmit = (e) =>
{
  e.preventDefault();
  //We need to pass this up
  //Must pass the title paramter up or whatver value would be changed 
  //add todo is embedded within app.js
  this.props.addTodo(this.state.title);
  //Clears the fields
  this.setState({title: " "});
}

  render() {
    return (
     <form 
     onSubmit = {this.onSubmit}
     style = {{display: 'flex'}}>
        <input type= "text" 
        name = "title"
        style={{flex:'10' , padding: '5px'}}
        placeholder= "Add Todo...."
        value ={this.state.title}
        onChange = {this.onChange}
        />

        <input 
        type= "submit" 
        value = "submit"
        className= "btn"
        style= {{flex:'1'}}
        />

     </form>
    )}
}

AddTodo.propTypes = 
{
  //addtodo :  PropTypes.func.isRequired,
  //markComplete : PropTypes.func.isRequired,
 // delTodo: PropTypes.func.isRequired
}
export default AddTodo