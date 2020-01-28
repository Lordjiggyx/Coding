import React, { Component } from 'react'
import "../../CSS/ParallaxComponents/Header.css"
import {Navbar , NavbarHeading , NavbarDivider , NavbarGroup , Button} from "@blueprintjs/core"
import crab from "../../Images/Crab.png"
import{Link} from "react-router-dom"

import R1 from './R1';
import R3 from './R3';
import R2 from './R2';

class Header extends React.Component {
    render() {
        return (
            <div>

                <div className="nav-container">
               <Navbar fixedToTop = "true">
                    <Link to ="/">
                    <img src={crab} alt="Logo" className="crab"/>
                    </Link>
               </Navbar>
               </div>

            <div className="Main">
            <R1/>
            </div>
            </div>
        )
    }
}

export default Header