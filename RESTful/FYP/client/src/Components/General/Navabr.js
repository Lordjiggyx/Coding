import React, { Component } from 'react'
import "../../CSS/ParallaxComponents/Header.css"
import {Navbar} from "@blueprintjs/core"
import crab from "../../Images/Crab.png"
import{Link} from "react-router-dom"
import { Redirect   } from "react-router-dom";


export class Navabr extends Component {

    state={
        userLogged:localStorage.getItem("Logged")
    }


    logout()
    {
        localStorage.setItem("Logged" , "false")
        localStorage.setItem("Email" , "")

    }

    render() {
        return (
            <div>
                {this.state.userLogged=="false" ?

                <div className="nav-container">
                <Navbar fixedToTop = "true">

                <div class="bp3-navbar-group bp3-align-right">
                <Link to ="/">
                    <img src={crab} alt="Logo" className="crab"/>
                    </Link>

                   

                    <Link to ="/SignUp">
                    Register
                    </Link>
                    <span class="bp3-navbar-divider"></span>
                    <Link to ="/Login">
                    Login
                    </Link>
                </div>
            
                    
                </Navbar>
                </div>
                
            :
            <div className="nav-container">
            <Navbar fixedToTop = "true">

            <div class="bp3-navbar-group bp3-align-right">
            <Link to ="/">
                <img src={crab} alt="Logo" className="crab"/>
                </Link>

               

                <Link to ="/" onClick={this.logout}>
                Logout
                </Link>
                <span class="bp3-navbar-divider"></span>
                <Link to ="/UserDashboard">
                My Dashboard
                </Link>
                <span class="bp3-navbar-divider"></span>
                <Link to ="/Profile" >
                My Profile
                </Link>
                
            </div>
        
                
            </Navbar>
            </div>

            }
                
            </div>
        )
    }
}

export default Navabr
