import React, { Component } from 'react'
import { Icon, Intent } from "@blueprintjs/core";
import "../../CSS/ParallaxComponents/R3.css"
import { Button } from "@blueprintjs/core";
import { motion } from "framer-motion"
import {Link} from "react-router-dom"

export default class R1 extends Component {
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

                <div className = 'R3_center'>
                
                <motion.div
                 initial="hidden"
                 animate="visible"
                 variants={top_bottom}
                 transition={{duration:1}}
                 className="welcome_center_1">
                <Icon icon="heart" iconSize={270} className="heart" />
                </motion.div>
                    
               
               
                
                <motion.div 
                 initial="hidden"
                 animate="visible"
                 variants={fade_in}
                 transition={{duration:2.5}}
                 className="welcome_center_2">
                    Healthy Spirit & Mind
                </motion.div>

                <motion.div 
                initial="hidden"
                animate="visible"
                variants={fade_in}
                transition={{duration:3.5}} className="welcome_center_3">
                    Here we try our best to promote mindfulness, your body is only a strong as your spirit.
                    Join today and tap into the best practicies for postivity and overall happiness which
                    in turn will result in you becoming a more mentally reinforced indiviual.
                </motion.div>

                <Button className="bp3-minimal right" rightIcon="arrow-right" >Sign Up</Button>

                <Link to ="/">
                <Button className="bp3-minimal left" icon="arrow-left" >Home</Button>
                </Link>

                </div>


                </div>

           
        )
    }
}