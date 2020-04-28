import React, { Component } from 'react'
import Navabr from '../General/Navabr';
import "../../CSS/SignUpComponents/SignUp.css"
import "../../CSS/LoginComponents/Login.css"

import { motion } from "framer-motion"
import {Link} from "react-router-dom";



import {  Checkmark , } from "grommet-icons";
import {
    Box,
    Button,
    Grommet,
    Form,
    FormField
    ,Text
  } from "grommet";
import Continue from './Continue';


export class Login extends Component {

    state={
        step:0,
        Email:"",
        Password:""
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

    login = async e =>
    {
        e.preventDefault();


        const User=
        {
            //Get rid of username 
            username:this.state.Username,
            email:this.state.Email,
            password:this.state.Password

        }

        const response = await fetch('/Routes/API//users/login', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify(User)
          });
          console.log(response.text())
          localStorage.setItem("Email" , User.email)
         this.next()
    }
    
   handleChange = input =>e =>
   {
       this.setState(
           {
               [input]:e.target.value
           }
       )
   }




    render() {
        const {step} = this.state;




        const fade_in=
        {
            hidden:{ opacity:0},
            visible:{opacity:1},
            
        }
        
        switch(step)
        {
            case 0:
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
                               <h1>Log In</h1>
                               
                               <div className="Body">
                               <Box width="medium">
                                   <Form>

            
                                        <FormField label="Email" name="email" type="email"   onChange = {this.handleChange("Email")}/>
            
                                        <FormField label="Password" name="Password" type="password"  onChange = {this.handleChange("Password")} />
            
                    
                                   </Form>
                                   <div className = "next1">
                                      
                                        <Button onClick = {this.login} >
                                        <Box pad="small" direction="row" align="center" gap="small">
                                        <Text>Login</Text>
                                        <Checkmark />
                                        </Box>
                                        </Button>
                                       
                                    </div>
                               </Box>
            
                                    <Box align="center" pad="medium">
                                    <h3>Dont have an account?</h3>
                                    <Link to= "/SignUp">
                                    <Button label="Register" />
                                    </Link>
                                    </Box>
                               </div>
                               </Box>
                           </Grommet>
                           </motion.div>
              
                        </div>
                    )
            case 1:
                return(
                    <Continue/>
                )
        }
       
    }
}

export default Login
