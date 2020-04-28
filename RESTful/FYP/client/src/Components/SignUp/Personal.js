import React, { Component } from 'react'

import 'primereact/resources/primereact.min.css';
import Navabr from '../General/Navabr';
import { motion } from "framer-motion"



import {  FormNext ,FormPrevious } from "grommet-icons";
import {
    Box,
    Button,
    
    Grommet,
    Form,
    FormField,
    MaskedInput ,
    RadioButtonGroup,

    
  } from "grommet";

export class Personal extends Component {
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
    

            
        const fade_in=
        {
            hidden:{ opacity:0},
            visible:{opacity:1},
            
        }
    
            return (
                <div>
                   <Navabr/>
                   <motion.div
                    initial="hidden"
                    animate="visible"
                    variants={fade_in}
                    transition={{duration:1.5}}>
                   >
                   <Grommet>
                   <Box fill align="center" justify="center">
                    
                   <h1>Personal Information</h1>
                   <div className="Body">
                   <Box width="medium">
                       <Form>
                            <FormField
                            label="First name"
                            name="firstname"
                            required
                            onChange = {handleChange("firstName")}
                            />

                            <FormField label="Last Name" name="lastName"  onChange = {handleChange("lastName")}/>

                            <FormField label="Gender" >
                            <RadioButtonGroup
                            
          name="radio"
          options={[
            { label: "Male", value: "Male" },
            { label: "Female", value: "Female" }
            
          ]}

          onChange = {handleChange("gender")}/>                      
                            </FormField>

                            <FormField label="Date of Birth" name="Dob">

                            <input type="date" id="birthday" onChange={handleChange("DOB")}></input>
                            </FormField>

                           
                           

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


                   </motion.div>
  
                  
    
                 
                </div>
            )
        }
}







export default Personal
