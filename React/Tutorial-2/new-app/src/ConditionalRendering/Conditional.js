import React from "react"

//This function takes  prop
function Conditional(props)
{
    console.log(props.isLoading)
    //Checks if props.isloading is true telling the user it's loading
    if(props.isLoading === true)
    {
        return(
        <h1>Loading</h1>
        )
    }
    //When this runs again it will notice that the props.isoading is false and then change the value being displayed on the page
    
    //This return will only run if the if the first condition does not pass as true
    {
    return(
        <h1>Finished</h1>
    )
    }
}

export default Conditional