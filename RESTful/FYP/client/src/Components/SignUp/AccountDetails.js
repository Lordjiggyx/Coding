import React, { Component } from 'react'
import Header from "../Parallax/Header"
import Navabr from '../General/Navabr';
import {Button , InputGroup , Radio ,RadioGroup , Slider , Label , Icon , FormGroup} from "@blueprintjs/core";





export class AccountDetails extends Component {

   

continue = e =>
{
    //Prevent default behaviour of event
    e.preventDefault();
    //calls the next method on the userfrom component
    this.props.next();
}



    render() {

        //Get the values from the user from
        const {values , handleChange} = this.props;

        //Icons
        const at = <Icon icon="envelope"  size={Icon.SIZE_STANDARD}/>
        const person = <Icon icon="person"  size={Icon.SIZE_STANDARD}/>
        const eye = <Icon icon="eye-open"  size={Icon.SIZE_STANDARD}/>
        const lock = <Icon icon="lock"  size={Icon.SIZE_STANDARD}/>


        return (
            <div>
               <Navabr/>
               <h1>Enter User Details</h1>
                   
                   <FormGroup
                   labelFor= "email_input"
                   label = "Email">
                   <InputGroup
                   id ="email_input"
                   placeholder = "Enter Email Address.."
                   leftIcon={at}
                   onChange = {handleChange("email")}
                   defaultValue={values.email}
                   />
                   </FormGroup>

               <hr/>

               <FormGroup
               labelFor= "username_input"
               label = "Username">
               <InputGroup
               id ="username_input"
               placeholder = "Enter Username.."
               leftIcon={person}
               onChange = {handleChange("userName")}
               defaultValue={values.userName}
               />
               </FormGroup>

               <hr/>

               <FormGroup
               labelFor= "password_input"
               label = "Password">
               <InputGroup
               id ="password_input"
               placeholder = "Enter Password.."
               leftIcon={eye}
               onChange = {handleChange("password")}
               defaultValue={values.password}
               />
               </FormGroup>

               <hr/>

               <FormGroup
               labelFor= "Confirm_input"
               label = "Password Confirmation">
               <InputGroup
               id ="Confirm_input"
               placeholder = "Confirm Pssword.."
               leftIcon={eye}
               onChange = {handleChange("password")}
               defaultValue={values.password}
               />
               </FormGroup>

               <hr/>
               
               <Button rightIcon="arrow-right" onClick={this.continue}>Next</Button>
               
             
            </div>
        )
    }
}

export default AccountDetails
