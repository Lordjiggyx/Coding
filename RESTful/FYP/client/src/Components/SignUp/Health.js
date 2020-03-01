
import React, { Component } from 'react'
import Header from "../Parallax/Header"
import Navabr from '../General/Navabr';
import {Slider} from "@blueprintjs/core";
import { Close, Send, User , FormNext ,FormPrevious } from "grommet-icons";
import {
    Box,
    Button,
    CheckBox,
    Grommet,
    Form,
    FormField,
    MaskedInput ,
    RadioButtonGroup,
    RangeInput,
    Select,
    TextArea
    ,TextInput
  } from "grommet";




export class Health extends Component {
  

    bmi = () =>
    {
        const {values :{height , weight,bmi }} =this.props

       var  num = this.props.values.height * this.props.values.weight
        var result = Math.pow(num , 2)
        this.setState(
            {
                bmi:result
            }
        )
    } 

    continue = e =>
    {
        //Prevent default behaviour of event
        e.preventDefault();
        //calls the next method on the userfrom component
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
    
            //Get the values from the user from
            const {values , handleChange } = this.props;
    
            const levels =["Sedentary - Little to no regular exercise" 
            , "Lightly Active - Intensive exercise for at least 20 minutes 1 to 3 times per week." 
            , "Active - Intensive exercise for 60 minutes or greater 5 to 7 days per week" ,
             "Very Active - Exceedingly active and/or very demanding activities"]
            //Icons
            // const at = <Icon icon="envelope"  size={Icon.SIZE_STANDARD}/>
            // const person = <Icon icon="person"  size={Icon.SIZE_STANDARD}/>
            // const eye = <Icon icon="eye-open"  size={Icon.SIZE_STANDARD}/>
            // const lock = <Icon icon="lock"  size={Icon.SIZE_STANDARD}/>
    
    
            return (
                <div>
                   <Navabr/>
                   <Grommet>
                   <Box fill align="center" justify="center">
                    
                   <h1>Health Information</h1>
                   <div className="Body">
                   <Box width="medium">
                       <Form>

                            <FormField label="Height" help = "Meters"name="height"  onChange = {handleChange("height")}/>
                            <FormField label="Weight" help = "Kilograms"name="weight"  onChange = {handleChange("weight")}/>

                            {/* <FormField label="BMI" help = "Body Mass Index"name="bmi" on/> */}

                            
                            
                            {/* <FormField label="Physical level of Activity" >
                                <Select
                                placeholder="Select Appropriate Level"
                                options={levels}
                                onChange={handleChange("active")}/>
                            </FormField> */}
                               

                           
                           

                            <div className = "next">
                            <Button plain icon={<FormNext />} onClick={this.continue} />
                        </div>
                        <div className = "back">
                            <Button plain icon={<FormPrevious />} onClick={this.back} />
                        </div>
        
                       </Form>
                      
                   </Box>
                   </div>
                   </Box>
               </Grommet>
             
{/*                
               <FormGroup
               labelFor= "first_input"
               label = "First Name">
               <InputGroup
               id ="first_input"
               placeholder = "Enter First Name.."
               leftIcon={person}
               onChange = {handleChange("firstName")}
               defaultValue={values.firstName}
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
                   <Button rightIcon="arrow-left" onClick={this.back}>Next</Button> */}
    
                 
                </div>
            )
        }
}

export default Health
