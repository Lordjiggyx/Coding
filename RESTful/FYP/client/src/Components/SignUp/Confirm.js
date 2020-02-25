import React, { Component } from 'react'
import Navabr from '../General/Navabr';
import {Button , InputGroup , Radio ,RadioGroup , Slider , Label , Icon , FormGroup} from "@blueprintjs/core";


export class Confirm extends Component {

    continue =async e =>
    {
        //Prevent default behaviour of event
        e.preventDefault();
        //calls the next method on the userfrom component
        //Process form

        const {values :{firstName , lastName , email ,ethnicity
            , gender ,  DOB , country , height , weight  , password}} =this.props


        const User = 
        {
            firstName:this.props.values.firstName,
            email:this.props.values.email
        }

        const response = await fetch('/Routes/API//users/register', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify(User)
          });
          console.log(response.text())
        //const response = await fetch('/Routes/API/users/hello')
        this.props.next();
    }

    back = e =>
    {
        //Prevent default behaviour of event
        e.preventDefault();
        //calls the next method on the userfrom component
        this.props.previous();
    }


  

    render() {

        const {values :{firstName , lastName , email ,ethnicity
            , gender ,  DOB , country , height , weight  , password}} =this.props
        
        return (
            <div>
                <Navabr/>
                 <h1>Confirm User Information</h1>
                 <li>
                    First Name : {firstName}
                 </li>
                 <li>
                    Email  : {email}
                 </li>

                                    
                 <Button rightIcon="arrow-right" onClick={this.continue}>Confirm & Continue</Button>
                   <Button rightIcon="arrow-left" onClick={this.back}>Next</Button>
    
                 
            </div>
        )
    }
}


function Listitem(props)
{
    const value = props.value
    return(
        <li>
            {value}
        </li>
    )
    
}
export default Confirm
