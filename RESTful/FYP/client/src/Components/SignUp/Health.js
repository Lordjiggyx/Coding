
import React, { Component } from 'react'
import Navabr from '../General/Navabr';
import { FormNext ,FormPrevious } from "grommet-icons";
import {motion} from "framer-motion"
import {
    Box,
    Button,

    Grommet,
    Form,
    FormField,

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
                    
                   <h1>Health Information</h1>
                   <div className="Body">
                   <Box width="medium">
                       <Form>

                            <FormField label="Height" help = "Meters"name="height"  onChange = {handleChange("height")}/>
                            <FormField label="Weight" help = "Kilograms"name="weight"  onChange = {handleChange("weight")}/>

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

export default Health
