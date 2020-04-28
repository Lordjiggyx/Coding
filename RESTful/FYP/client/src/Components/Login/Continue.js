import React, { Component } from 'react'
import { Icon } from "@blueprintjs/core";
import "../../CSS/ParallaxComponents/R3.css"
import { Button } from "@blueprintjs/core";
import { motion } from "framer-motion"
import {Link} from "react-router-dom"
import Navabr from '../General/Navabr';

export class Continue extends Component {
    render() {
       
        

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
             variants={fade_in}
             transition={{duration:1}}
             className="welcome_center_1">
            <Icon icon="tick-circle" iconSize={270} className="heart" />
            </motion.div>
                
           
           
            
            <motion.div 
             initial="hidden"
             animate="visible"
             variants={fade_in}
             transition={{duration:2.5}}
             className="welcome_center_2">
                Successful Login
            </motion.div>

            <motion.div 
            initial="hidden"
            animate="visible"
            variants={fade_in}
            transition={{duration:3.5}} className="welcome_center_3">
                You have successfully logged click on the options below to proceed!!!
            </motion.div>

            <Link to = "/Profile">
            <Button className="bp3-minimal right" rightIcon="arrow-right" >View My Profile</Button>
            </Link>

            <Link to = "/Dashboard">
            <Button className="bp3-minimal left" icon="arrow-left" >Dashboard</Button>
            </Link>


            </div>


            </div>

        )
    }
}

export default Continue
