import  React from "react"
import TodoItem from "./TodoItem"
//Importing the todos data
import todosData from "./TodoData"
function Todo()
{
    //We will map the inofrmation from todos data into a new array returning a new item at the same time we will make a new todoitem passing in the todos that are read from this array as a prob to the todo compoenent as an object hence te use of curly braces
    
    
    const todoitems = todosData.map(item => <TodoItem key = {item.id} item = {item}/>)
    return(
        <div className = "todo-list">
            {todoitems}
        </div>
    )
}

export default Todo