import React from "react"

function Event()
{
    return(
        <div>
            <img onMouseOver={() => console.log("Hovered over image")} src = "https://source.unsplash.com/1670x900/?mouse"></img>
            <br/>
            <br/>
            <button onClick = {()=> console.log("Button Clicked")}>Click Me</button>
        </div>
    )
}

export default Event