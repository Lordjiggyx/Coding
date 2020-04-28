import React, { Component   } from 'react'
import Navabr from '../General/Navabr';
import "../../CSS/ProfileComponents/Profile.css"
import SideMenu from './SideMenu';
import UpdateInfo from './UpdateInfo';

import UserInfo from './UserInfo';
import axios from "axios"


import { Icon } from '@blueprintjs/core';
import DeleteAccount from './DeleteAccount';



export class Details extends Component {

state =
{
    step:1,
    email:localStorage.getItem("Email"),
    user:{
        firstname:"",
        lastname:"",
        username:"",
        email:"",
        dob:"",
        gender:"",
        height:"",
        weight:""
    }
}


componentDidMount =  ()=>
{


        console.log(this.state.email)
        const email = this.state.email



      axios.get(`/Routes/API//users/getUser/${email}`)
    .then(res => {
        this.setState(
            {
                user:
                {
                    firstname:res.data.FirstName,
                    lastname:res.data.LastName,
                    dob:res.data.DOB,
                    height:res.data.Height,
                    weight:res.data.Weight,
                    gender:res.data.Gender,
                    email:res.data.Email,
                    username:res.data.UserName
                }
            }
        )
        console.log(res.data)
      })

}

goTo = number => e =>
{
    this.setState({
        step:number
    })
}




    render() {
        const email = this.state.email

      const {user} = this.state
        const {step} = this.state;

        switch(step)
        {
            case 1:
                return(
                    <div>
                    <Navabr/>
                    <div className="sideMenu">
                    <SideMenu
                    goTo = {this.goTo}/>
                    </div>
    
                    <div className="main">
                    <UserInfo
                    userObject={user}
                    email = {email}
                    />
                    <div className="avatar"><Icon icon="user" iconSize={300}/></div>
                    </div>
                    
                </div>
            )
            case 2:
                    return(
                        <div>
                        <Navabr/>
                        <div className="sideMenu">
                        <SideMenu
                         goTo = {this.goTo}/>
                        </div>
        
                        <div className="main">
                        <UpdateInfo
                         email = {email}/>
                        
                        </div>
                        
                    </div>
                )

                case 3:
                        return(
                            <div>
                            <Navabr/>
                            <div className="sideMenu">
                            <SideMenu
                             goTo = {this.goTo}/>
                            </div>
            
                            <div className="main">
                            <DeleteAccount
                             email = {email}/>
                              <div className="avatar"><Icon icon="user" iconSize={300}/></div>
                            </div>
                            
                        </div>
                    )

                    case 1:
                            return(
                                <div>
                                <Navabr/>
                                <div className="sideMenu">
                                <SideMenu/>
                                </div>
                
                                <div className="main">
                                <UpdateInfo/>
                                
                                </div>
                                
                            </div>
                        )

        }
        }

        
    }
    
   





export default Details
