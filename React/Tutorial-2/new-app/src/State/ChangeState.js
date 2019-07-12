import React from "react"

class ChangeStateApp extends React.Component
{
    constructor()
    {
    super()
    this.state = {
        count :0
    }
    //Binds the method to the class makeing it usable
    this.handleClick = this.handleClick.bind(this)
    }


    //Methid for handling button click
    handleClick()
    {
        this.setState(prevState =>
            {
            return{
                count:prevState.count + 1
            }
            })
        
    }


    render()
    {
        return(
            <div>
                <h1>{this.state.count}</h1>
                {/**When a method os part of the class yuou must refernece it using this. */}
                <button onClick = {this.handleClick}>Click Me</button>
            </div>
        )
    }
}

export default ChangeStateApp