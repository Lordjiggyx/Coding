import React, { Component } from 'react'
import Header from "../Parallax/Header"
import Navabr from '../General/Navabr';
import "../../CSS/SignUpComponents/SignUp.css"
import { motion } from "framer-motion"
import {Link} from "react-router-dom";



import { Close, Send, User , FormNext , } from "grommet-icons";
import {
    Box,
    Button,
    Grommet,
    Form,
    FormField,
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

             
            </div>
        )
    }
}

export default AccountDetails
