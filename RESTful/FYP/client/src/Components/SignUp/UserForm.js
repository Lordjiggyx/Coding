import React, { Component } from 'react'
import AccountDetails from "./AccountDetails"
import Personal from './Personal';
import Health from "./Health"
import Confirm from "./Confirm"
import Success from './Success';
export class UserForm extends Component {

    //State of the component
    state = 
    {
        //step for which step of the form we are on
        step:1,

        //User information
        firstName : "",
        userName : "",
        lastName :"",
        email : "",
        gender : "",
        DOB : "",
        country: "",
        height :"",
        weight : "",
        //come back and add
        password : "",
        user: "",
        active:""


    }


    //Method to go to next step 
    next = ()=>
    {
        //get step from state
        const {step} = this.state;

        this.setState({
            step: step+1
        })
    }


    //Method to go to previous step 
    previous = ()=>
    {
        //get step from state
        const {step} = this.state;

        this.setState({
            step: step-1
        })
    }

    //Handle fields change takes in an input and an event parameter
    handleChange = input => e =>
    {
        this.setState({
            //take in the input and then set it to the value of the satet being changed
            [input]:e.target.value
        })
    }
    

    render() {
        //get step from state
        const {step} = this.state;

        //get fields
        const {firstName , lastName , email ,ethnicity , userName
         , gender ,  DOB , country , height , weight  , password} = this.state;

        //Values holds all the variables which can be passed into each component
        const values =
        {
            firstName , lastName , email ,ethnicity , userName
         , gender ,  DOB , country , height , weight  , password
        }

        {/*Going to use switch to change the page based on the step */}
        switch(step)
        {
            case 1:
                return(
                <AccountDetails
                //use props to access methods
                next = {this.next}
                handleChange = {this.handleChange}
                values = {values}
                />
                )
            case 2:
                return(
                <Personal
                next = {this.next}
                handleChange = {this.handleChange}
                previous = {this.previous}
                values = {values}/>
                )
            case 3:
                return(
                    (
                        <Health
                        next = {this.next}
                        handleChange = {this.handleChange}
                        previous = {this.previous}
                        values = {values}/>
                        )
                )
            case 4:
                return(
               <Confirm next = {this.next}
               previous = {this.previous}
               values = {values}/>
                )
            case 5:
                return(
                 <Success/>
                )
            
        }
    }
}

export default UserForm
