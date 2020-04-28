import React, { Component } from 'react'
import Navabr from '../General/Navabr';
// import {Button , InputGroup , Radio ,RadioGroup , Slider , Label , Icon , FormGroup} from "@blueprintjs/core";
import { FormNext ,FormPrevious } from "grommet-icons";
import {
    Box,
    Button,
    Grommet,
    List
  } from "grommet";

  import {motion} from "framer-motion"


export class Confirm extends Component {

    continue =async e =>
    {
        //Prevent default behaviour of event
        e.preventDefault();
        //calls the next method on the userfrom component
        //Process form

        const {values :{firstName , lastName , email ,ethnicity , userName
            , gender ,  DOB , country , height , weight  , password}} =this.props


        const User = 
        {
            firstName:this.props.values.firstName,
            lastName:this.props.values.lastName,
            email:this.props.values.email,
            gender:this.props.values.gender,
            height:this.props.values.height,
            weight:this.props.values.weight,
            password:this.props.values.password,
            DOB:this.props.values.DOB,
            userName: this.props.values.userName

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

        const {values :{firstName , lastName , email 
            , gender ,  DOB  , height , weight  }} =this.props

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
                    
                   <h1>Confirm Details Entered</h1>
                   <div className="Bodycenter">
                   <Box width="medium">
                   <List
                    data={[
                        { name: `Name : ${firstName} ${lastName} `},
                        { name: `Email : ${email}` },
                        { name: `Date of Birth : ${DOB}` },
                        { name: `Gender : ${gender}` },
                        { name: `Height : ${height} meters` },
                        { name: `Weight : ${weight} kg`},
                    ]}
                    />
                      
                   </Box>
                   <div className = "next">
                   <Button plain icon={<FormNext />} onClick={this.continue} />
                </div>

                
                <div className = "back">
                <Button plain icon={<FormPrevious />} onClick={this.back} />
                </div>
                   </div>
                   </Box>
               </Grommet>
               </motion.div>


                 {/* <h1>Confirm User Information</h1>
                 <li>
                    First Name : {firstName}
                 </li>
                 <li>
                    Email  : {email}
                 </li>

                                    
                 <Button rightIcon="arrow-right" onClick={this.continue}>Confirm & Continue</Button>
                   <Button rightIcon="arrow-left" onClick={this.back}>Next</Button> */}
    
                 
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
