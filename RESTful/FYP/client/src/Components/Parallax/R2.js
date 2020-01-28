import React, { Component } from 'react'
import { Icon, Intent } from "@blueprintjs/core";
import "../../CSS/ParallaxComponents/R2.css"
import { motion } from "framer-motion"
import { Button } from "@blueprintjs/core";
import {Link} from "react-router-dom";


export default class R2 extends Component {
    render() {

        const top_bottom=
        {
            hidden:{marginTop:"-0%"},
            visible:{marginTop:"32%"},
            
        }

        const left_right=
        {
            hidden:{marginLeft:"-100%"},
            visible:{marginLeft:"25%"},
            
        }

        const right_left=
        {
            hidden:{right:"-100%"},
            visible:{right:"20%"},
            
        }

        return (

            <div>

                <div className = 'split left'>
                <motion.div
                    initial="hidden"
                    animate="visible"
                    variants={top_bottom}
                    transition={{duration:1}}
                    className="Reason2">Unique Dashboard</motion.div>

                    <motion.p 
                    initial="hidden"
                    animate="visible"
                    variants={left_right}
                    transition={{duration:1}}
                    className="Reason2_Text">
                    Signing up gives you the chance to create your own unique dashboard. This will become "your" space, create diet and excersie plans that will enable you to become a healthier version of yourself, calendar events to mark the days that are important to you and so much more.......
                    </motion.p>

            
               
                
              

                    <div className = 'split r1_right'> 
                    <motion.div
                    initial="hidden"
                    animate="visible"
                    variants={right_left}
                    transition={{duration:1}}
                    className = 'R2_image'>
                     <Icon icon="control" iconSize={270} className="board" />
                    </motion.div>
               
                    </div>
                    <Link to="/why/R3">
                    <Button className="bp3-minimal r2" rightIcon="arrow-right" >Next</Button>
                    </Link>
                </div>

            </div>
        )
    }
}