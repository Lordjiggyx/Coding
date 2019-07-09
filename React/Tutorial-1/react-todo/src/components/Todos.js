import React , {Component} from 'react';
import TodoItem from './TodoItem'
import PropTypes from 'prop-types'

class Todos extends Component {

//   markComplete = (e)=>
// {
//   console.log(this.props.todo.title)
// }

    render()
    {
     //Return an array from an array to loop through and return the items on the todo
     //map creates a list and each item requires a key which should be unique
      return this.props.todos.map((todo) =>
      (
        <TodoItem key = {todo.id} todo = {todo} markComplete = {this.props.markComplete} delTodo = {this.props.delTodo} />
      ))
    }
    
  }
  
//Sets the prop type of the Todos class to the todo items and saying they are required
Todos.propTypes = 
{
  todos :  PropTypes.array.isRequired,
  markComplete : PropTypes.func.isRequired,
  delTodo:PropTypes.func.isRequired
  
}

export default Todos;