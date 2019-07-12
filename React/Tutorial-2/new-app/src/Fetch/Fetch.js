import React from "react"

class Fetch extends React.Component
{
    constructor()
    {
    super()
    this.state = {
        
        Users:[],
        isLoading:false
    }
   
  
    }



    //
    componentDidMount()
    {   
        //Set this to true to before the inforation is loaded
        this.setState({isLoading:true})
        fetch("https://jsonplaceholder.typicode.com/users")
        .then(res => res.json())
        .then((data)=>
        {
            this.setState(
                {
                    Users:data,
                    //Once information has been loaded we can set it back to false
                    isLoading:false
                }
            )
        })
       

    }


    render()
    {
        //Variable for load screen
        let text = ""
        //IF the data is still being loaded return the following text otherwise load the users
    if(this.state.isLoading)
    {
        return(
        text = "lOADING PLEASE WAIT"
        )
    }  
    else{
       console.log(this.state.Users)
        return(
            <div>
              {this.state.Users.map(User=>
                <div key ={User.id}>
                    
                   User Id: {User.id}
                   <br/>
                   User Name: {User.name}
                   <br/>
                   User Username: {User.username}
                   <br/>
                   User email: {User.email}
                   <br/>
                   User phone: {User.phone}
                   <br/>
                   <hr/>
                </div>
                )}
            </div>
        )
    }
}
}

export default Fetch