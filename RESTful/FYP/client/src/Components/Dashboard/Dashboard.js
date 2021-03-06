import React, { Component } from 'react'
import PickCancer from "./PickCanacer"
import Navabr from '../General/Navabr';
import "../../CSS/DashboardComponents/Dashboard.css"
import axios from "axios"
import UserDashboard from "./UserDashboard"


export class Dashboard extends Component {


    state = {
        email:localStorage.getItem("Email"),
        cancer:{
        }
    }



componentDidMount()
{
    
    axios.get(`/Routes/API//users/getUser/${this.state.email}`)
    .then(res => {
        this.setState(
            {
                cancer:res.data.Cancer_Location
                
            }
        )
        console.log(this.state.cancer)
      })
}


    render() {
        const cancer = this.state.cancer
        const email = this.state.email


        if(cancer == "")
        {
            return (
                <div>
                    <Navabr/>
                   {/* <h1>DashBoard Home</h1>  */}
    
                  
                   <PickCancer/>
                   
                </div>
            )
        }
        else
        {
            return (
                <div>
                    <Navabr/>
                   {/* <h1>DashBoard Home</h1>  */}
    
                  
                   <UserDashboard
                   email={email}
                   />
                   
                </div>
            )
        }

        
    }
}

export default Dashboard
