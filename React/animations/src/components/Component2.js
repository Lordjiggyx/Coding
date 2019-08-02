import React from "react"
import { Spring } from 'react-spring/renderprops';


class Component2 extends React.Component
{

    constructor()
    {
        super()
        this.state = {}
    }


    render()
    {
        return(
        <Spring
        from={{opacity:0}}
        to={{opacity:1}}
        config={{delay:1000 , duration:500}}
        >
            {props =>
            (
                <div style ={props} >
                    <div style = {c2style}>
                    <h1>Component 2</h1>
                    <p>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                    </p>
                    <button
                    onClick = {this.props.toggle}
                    style = {btn}
                    >Toggle button 3</button>
                    </div>
                   
                </div>
            )}
       
        </Spring>)
    }
}


const c2style = 
{
    background:"lightgreen",
    color:"white",
    padding:"1.5rem"
}

const btn = {
    background: "#333",
    color: "#fff",
    padding: "1rem 2rem",
    border: "none",
    textTransform: "uppercase",
    margin: "15px 0"
  };

export default Component2