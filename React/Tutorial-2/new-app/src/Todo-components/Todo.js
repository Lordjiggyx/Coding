import  React from "react"
import TodoItem from "./TodoItem"
//Importing the todos data
import todosData from "./TodoData"


class Todo extends React.Component
{
    constructor()
    {
        super()
        this.state = 
        {
            todos:todosData
        }

        this.handleChange = this.handleChange.bind(this)
    }
  
    
handleChange(id)
{
    
    //We care about the previous state so we use the prev state function to update the array
    this.setState(prevState =>
        {
            //This will be the old version of the todos and look through it howvwer using the map method we are creating an updated array
            const updatedTodos = prevState.todos.map(todo =>
                {
                    //Here we are sying if we have an item that matches the id of the item clicked we will change the completed value to the opposite of its current value
                    if(todo.id===id)
                    {
                        todo.completed = !todo.completed
                    }
                    //We will retun the todo which will be  in the same index as the previous state
                  
                    return todo
                   
                })

                //The set state actually need to return the todos but will equal the new verison of todos that we cretae
                return{
                    todos:updatedTodos
                }
        })

}



    render()
{
     //We will map the inofrmation from todos data into a new array returning a new item at the same time we will make a new todoitem passing in the todos that are read from this array as a prob to the todo compoenent as an object hence te use of curly braces
    const todoitems = this.state.todos.map(item => 
    <TodoItem 
       
        key = {item.id} 
        item = {item} 
        //Passing in the handle change
        handleChange = {this.handleChange}
    />)
    return(
        <div className = "todo-list">
            {todoitems}
        </div>
    )
}
}

export default Todo