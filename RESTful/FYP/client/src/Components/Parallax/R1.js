import React, { Component , useState } from 'react'
import { Icon, Intent } from "@blueprintjs/core";
import { useSpring, animated as a } from "react-spring";
import { Button } from "@blueprintjs/core";
import {Link} from "react-router-dom";
import { motion } from "framer-motion"

import "../../CSS/ParallaxComponents/R1.css"
import Navabr from '../General/Navabr';

export default class R1 extends Component {
    render() {
        const top_bottom=
        {
            hidden:{marginTop:"-0%"},
            visible:{marginTop:"32%"},
            
        }
        
        
        const left_right=
        {
            hidden:{marginLeft:"-100%"},
            visible:{marginLeft:"50%"}
            
        }

        const fade_in=
        {
            hidden:{ opacity:0},
            visible:{opacity:1},
            
        }



        return (

            <div>
                <Navabr/>
                <div className = 'split left'>
                <motion.div
                 initial="hidden"
                 animate="visible"
                 variants={left_right}
                 transition={{duration:1}}
                 className = 'R1_image'>
                <Icon icon="learning" iconSize={270} className="hat"/>
                    </motion.div>
               
                    </div>
                
                    
                    <div className = 'split r1_right'> 
                    
                    <motion.div
                    initial="hidden"
                    animate="visible"
                    variants={top_bottom}
                    transition={{duration:1}}
                    className="Reason1">
                         Powerful Information</motion.div>


                    <motion.div
                    initial="hidden"
                    animate="visible"
                    variants={fade_in}
                    transition={{duration:2.5}}
                    className="motion1"
                    >
                    <p
                    className="Reason1_Text">
                    Educate yourself about what causes cancer,the muations involved and treatments avaliable.The informtion we provide covers a wide array of tumor types and the genetics behind them. Delve into the history of cancer or find yourself inmmersed in statiscal graphs and real time articles providing the most up to date news about cancer.
                    </p>
                    
                    </motion.div>

                    <Link to="/why/R2">
                    <Button className="bp3-minimal r1" rightIcon="arrow-right" >Next</Button>
                    </Link>
                   
                </div>

            </div>
        )
    }
}
