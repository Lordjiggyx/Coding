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


export class UserInfo extends Component {
    render() {
        return (
            <div className="center-info">
               <Grommet>
               <h1>Account Information</h1>
                   <h4>This is the information regading your account details</h4>
                   <Box fill align="center" justify="center">
                   <div className="Body">
                   <Box width="medium">
                       <Form>
                            <FormField
                            label="Username"
                            name="userName"
                            required
                            
                            />

                            <FormField label="Email" name="email" type="email" required />

                            <FormField label="Password" name="Password" type="password" required  />


                           


        
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
                
            </div>
        )
    }
}

export default UserInfo
