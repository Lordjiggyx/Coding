import React from 'react'
import { Spring } from 'react-spring/renderprops';
const Component1 = () => {
    return (
        <Spring
        from={{opacity:0 , marginTop:-500}}
        to={{opacity:1, marginTop:0}}
       
        >
            {props =>
            (
                <div style ={props} >
                    <div style = {c1style}>
                    <h1>Component 1</h1>
                    <p>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                    </p>
                    <Spring
                    from={{number:0}}
                    to={{ number:1000}}
                    config={{delay:1000 , duration:50000}}
                    >
                        {props =>
                        (
                        <div style ={props} >

                            <h1 style = {counter}>
                            {props.number.toFixed()}
                            </h1>

                        </div>
                        )}

                    </Spring>
                    </div>

                </div>
            )}
        </Spring>

        
    )
}


const c1style = 
{
    background:"lightskyblue",
    color:"white",
    padding:"1.5rem"
}
const counter = 
{
    background:"black",
    color:"white",
    padding:"1.5rem",
    textAlign:"center",
    width:"100px",
    borderRadius:"50%",
    margin:"1rem auto"
}
export default Component1