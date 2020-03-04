import React, { Component } from 'react'
import { Icon, Intent } from "@blueprintjs/core";
import "../../CSS/ParallaxComponents/R3.css"
import { Button } from "@blueprintjs/core";
import { motion } from "framer-motion"
import {Link} from "react-router-dom"
import Navabr from '../General/Navabr';

export default class Success extends Component {
    render() {

        
        const top_bottom=
        {
            hidden:{marginTop:"-100%"},
            visible:{marginTop:"0%"},
            
        }

        const left_right=
        {
            hidden:{marginLeft:"-100%"},
            visible:{marginLeft:"25%"},
            
        }

        const right_left=
        {
            hidden:{right:"-0%"},
            visible:{right:"20%"},
            
        }

        const fade_in=
        {
            hidden:{ opacity:0},
            visible:{opacity:1},
            
        }
        return (


            <div>
                <Navabr/>
                
                <div className = 'R3_center'>
                
                <motion.div
                 initial="hidden"
                 animate="visible"
                 variants={top_bottom}
                 transition={{duration:1}}
                 className="welcome_center_1">
                <Icon icon="envelope" iconSize={270} className="envelope" />
                </motion.div>
                    
               
               
                
                <motion.div 
                 initial="hidden"
                 animate="visible"
                 variants={fade_in}
                 transition={{duration:2.5}}
                 className="welcome_center_2">
                   Successful Registration
                </motion.div>

                <motion.div 
                initial="hidden"
                animate="visible"
                variants={fade_in}
                transition={{duration:3.5}} className="welcome_center_3">
                   Thank you for Registering with us you will soon receive an email to verify your account once you have verified your account please click the button below to login

                
                </motion.div>

                <Link to ="/Login">
                <Button className="bp3-minimal bottom" >Login</Button>
                </Link>


                </div>


                </div>

           
        )
    }
}