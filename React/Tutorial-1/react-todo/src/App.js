import React , {Component} from 'react';
import Todos from './components/Todos'
import Header from './components/Layout/Header'
import AddTodo from './components/AddTodo'
import about from './components/pages/about'
import{BrowserRouter as Router , Route} from 'react-router-dom'
import './App.css';

import axios from 'axios'
//UUID used for generating random ids
//import uuid from 'uuid'

class App extends Component {
state = 
{
  todos: 
  [ ]
}
 
componentDidMount() {
  axios.get('https://jsonplaceholder.typicode.com/todos?_limit=10')
  .then(res => this.setState({todos:res.data}))
}


markComplete = (id)=>
{
 //Changing the state of the object using setState

 this.setState({todos: this.state.todos.map((todo)=>
  {
    //check to see if current todo id is = to the id passed into the function
    if(todo.id === id)
    {
      //Rather than setting it to true we allow it to toggle by setting it to the opposite value
      todo.completed = !todo.completed
    }
    return todo
  })})
}

delTodo = (id)=>
{//delete request to the server
axios.delete(`https://jsonplaceholder.typicode.com/todos/${id}`)
.then(res => this.setState({todos: [...this.state.todos.filter(todo=> todo.id !== id)]}))


  //Using filter method
  //Loops through and returns another array based on a condition
  //We only want to return todos that dont match the id passed in
  // this.setState(
  //   {
  //     //copy every item using the spread operatoer which is 3 dots
  //     //The call this.state.todos to get the state of the todos list
  //     //Then filter 
  //     //condition states that a new array should be produceded with only the todos
  //     //That match the current id
  //     todos:[...this.state.todos.filter(todo=> todo.id !== id)]
  //   }
  // )
}

addTodo = (title)=>
{
  //We need to add to our state
  //Use set state
  //and also the spread operator
  //this.setState({todos:[...this.state.todos , newTodo]})

  //Making a post request to the json placeholder
  axios.post("https://jsonplaceholder.typicode.com/todos",
  {
    //data that we are sending
    title,
    completed:false
  })
  //gives us a promise
  //again we are using set state to set the state
  .then(res =>this.setState({todos:[...this.state.todos , res.data]}))
}



render()
{

  return (
    <Router>
    <div className="App">
     <div className="Container">
     <Header>


     </Header>
     <Route exact path = "/" render = {props =>(
    <React.Fragment>
    <AddTodo addTodo = {this.addTodo}/>
    <Todos todos = {this.state.todos} markComplete = {this.markComplete}
    delTodo ={this.delTodo}/>
    </React.Fragment>
)}/>
    <Route path = "/about" component = {about}/>
    </div>
    </div>
    </Router>
  );
}
}

export default App;
