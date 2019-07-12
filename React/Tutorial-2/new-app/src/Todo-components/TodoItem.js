import  React from "react"

function TodoItem(props)
{

    const styles = 
    {
        background:"red",
        textDecoration:" line-through"
    }

    console.log(props.item.title)
    return(
        <div className = "todo-item">
        {/**This is ternary operator that applies the style if teh tosdo is done */}
        <span style={props.item.completed ? styles : null}> {props.item.title} </span>
            <input 
            type = "checkbox"
            checked ={props.item.completed}
            //Events recieve an event proprty so we can create a function that recieves the event change of handlechange and this can take in the item id
            onChange = {()=> props.handleChange(props.item.id)}/>
        </div>
    
    )
}





export default TodoItem