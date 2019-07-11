import React from "react"

class StateApp extends React.Component
{
    constructor()
    {
    super()
    this.state = {
        answer :"yes"
    }
    }




    render()
    {
        return(
            <div>
                <p>Is state important to know</p>
                <p>{this.state.answer}</p>
            </div>
        )
    }
}

export default StateApp