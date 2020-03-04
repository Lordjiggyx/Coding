import React, { Component } from 'react'
import Header from "../Parallax/Header"
import Navabr from '../General/Navabr';
//import {Button , InputGroup , Radio ,RadioGroup , Slider , Label , Icon , FormGroup} from "@blueprintjs/core";
import "../../CSS/SignUpComponents/SignUp.css"
import { motion } from "framer-motion"
import {Link} from "react-router-dom";



import { Close, Send, User , FormNext , } from "grommet-icons";
import {
    Box,
    Button,
    CheckBox,
    Grommet,
    Form,
    FormField,
    RadioButtonGroup,
    RangeInput,
    Select,
    TextArea
    ,TextInput
  } from "grommet";


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
        // const at = <Icon icon="envelope"  size={Icon.SIZE_STANDARD}/>
        // const person = <Icon icon="person"  size={Icon.SIZE_STANDARD}/>
        // const eye = <Icon icon="eye-open"  size={Icon.SIZE_STANDARD}/>
        // const lock = <Icon icon="lock"  size={Icon.SIZE_STANDARD}/>

        const fade_in=
        {
            hidden:{ opacity:0},
            visible:{opacity:1},
            
        }
        
        const icon = <FormNext/>
        return (
            <div>
               <Navabr/>
               <motion.div
                initial="hidden"
                animate="visible"
                variants={fade_in}
                transition={{duration:1.5}}>
               <Grommet>
                   <Box fill align="center" justify="center">
                    
                   <h1>Account Information</h1>
                   <div className="Body">
                   <Box width="medium">
                       <Form>
                            <FormField
                            Icon = {icon}
                            label="Username"
                            name="userName"
                            required
                            onChange = {handleChange("userName")}
                            />

                            <FormField label="Email" name="email" type="email" onChange = {handleChange("email")}required />

                            <FormField label="Password" name="Password" type="password" required onChange = {handleChange("password")} />


                           


        
                       </Form>
                       <div className = "next1">
                            <Button plain icon={<FormNext />} onClick={this.continue} />
                        </div>
                   </Box>

                    <Box align="center" pad="medium">
                    <h3>Have an account?</h3>
                    <Link to= "/Login">
                    <Button label="Login" />
                    </Link>
                    </Box>
                   </div>
                   </Box>
               </Grommet>
               </motion.div>
               {/* <h1>Enter User Details</h1>
                   
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
                */}
             
            </div>
        )
    }
}

export default AccountDetails
