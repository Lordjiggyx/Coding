import React, { Component } from 'react'
import "../../CSS/ParallaxComponents/Header.css"
import {Navbar} from "@blueprintjs/core"
import crab from "../../Images/Crab.png"
import{Link} from "react-router-dom"


export class Navabr extends Component {
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
            </div>
        )
    }
}

export default Navabr
