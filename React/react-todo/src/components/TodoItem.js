import React, { Component } from 'react'
import PropTypes from 'prop-types'
{/**/}
export class TodoItem extends Component {
  //method styling
  getStyle = () =>
  {
  //     if(this.props.todo.completed)
  //     {
  //         return {
  //             textDecoration: 'line-through',
  //             backgroundColor: 'red'
  //         }
  //     }
  //     else
  //     {
  //         return{
  //             textDecoration: 'none'
  //         }
  //     }
  // }

  //Using a tenary operator
  return{
    textDecoration: this.props.todo.completed === true ?
    'line-through' : 'none',
    backgroundColor: this.props.todo.completed === true?
    'red' : 'beige',
    padding : '10px',
    borderBottom: '1px #ccc dotted'
  }
}

//Creating checbox method
// markComplete = (e)=>
// {
//   console.log(this.props.todo.title)
// }

  render() {

    {/*destructuring*/}
    const {id , title} = this.props.todo

    return (
      <div style = {this.getStyle()} >
        <p>
        {/*adding a checkbox same as js using input type*/}
        {/*also adding events*/}
        {/*after the this.probs the method naemis placed*/}
        {/*To make access the todos we must pass the id */}
        {/*done by using .bind and then using this. whatever you require*/}
        {/*We can pull variables out of the object using destructring*/}
        <input type = "Checkbox" onChange={this.props.markComplete.bind
        (this , id)} />{' '}
    
        {title}

        {/*Adding a button*/}
         
          {/*Button style done using variable*/}
          {/*same process sending to the state using onclick*/}
        <button onClick={this.props.delTodo.bind(this,id)} style = {btnStyle}>X</button>
        
        </p>
      </div>
    )
  }
}

TodoItem.propTypes = 
{
  todo :  PropTypes.object.isRequired,
  markComplete : PropTypes.func.isRequired,
  delTodo: PropTypes.func.isRequired
}

// Variable styling
// const itemstyle = {
//   backgroundColor: 'grey'
// }

const btnStyle =
{
  background: "red",
  color: "white",
  border: "none",
  padding: '5px 8px',
  borderRadius: "50%",
  cursor:'pointer',
  float : "right"
}

export default TodoItem
