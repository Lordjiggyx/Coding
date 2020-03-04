import React, { Component } from 'react'
import Navabr from '../General/Navabr';
import SideMenu from './SideMenu';

export class Details extends Component {

state =
{
    email:""
}


componentDidMount()
{
    this.setState(
        {
            //Should make call to back end getting user object based on this email then 
            email:localStorage.getItem("Email")
        }
    )
    
}


    render() {
        const email = this.state.email

        return (
            <div>
                <Navabr/>
                
            </div>
        )
    }
}

export default Details
