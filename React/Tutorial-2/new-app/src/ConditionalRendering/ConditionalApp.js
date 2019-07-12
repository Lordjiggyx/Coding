import React from "react"
import Conditional from "./Conditional"

class ConditionalApp extends React.Component
{
    constructor()
    {
        super()
        this.state = 
        {
            //This is the current version of state
            isLoading:true
        }
    }

    //Allows us to run code after a componnet is rendered on a screnn
    componentDidMount()
    {
        //faking an api callto false
        //Also there is an arrow function that changes the state of loading to false
        // esstenially saying we are no longer fetching data after the 1.5 secs 
        setTimeout(()=>
        {
            this.setState({
                isLoading:false
            })
        },1500)
    }

    //Our render method will always chnage when the state is changed 
    render()
    {
    return(
        <div>
            {/**passing a prop called is loading in */}
            <Conditional isLoading = {this.state.isLoading}/>
        </div>
    )
    }
}
export default ConditionalApp