import  React from "react"

function TodoItem(props)
{
    console.log(props.item.title)
    return(
        <div className = "todo-item">
        <span> {props.item.title} </span><input type = "checkbox" />
        </div>
    
    )
}





export default TodoItem