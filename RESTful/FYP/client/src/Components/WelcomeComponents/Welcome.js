import React from "react"
import "../../CSS/WelcomeComponents/welcome.css"
import crab from "../../Images/Crab.png"
import { Button } from "@blueprintjs/core";
import {Link} from "react-router-dom";


class Welcome extends React.Component
{
componentDidMount()
{
    localStorage.setItem("Logged" , false) 
}


    render()
    {
        
        return(
            
            <div>
                    <div className = 'split left'>
                    <img src={crab} alt="Logo" className="crab"/>
                        <div className="welcome_center">
                        <div className="Ponc_header">PONC</div>
                        <p className="Ponc_slogan">A Better You</p>
                    </div>
                    </div>




                    <div className = 'split right'> 
                    <div className="Greeting">Welcome</div>
                    <p className="Greeting_Text">
                    Greetings, we pride ourselves with providing the most reliable and accurate information about cancer. We want to be able to aid individuals who suffer from this disease to feel comfortable using this website as their go to for battling cancer both physically and mentally.
                    </p>

                    <p className="Greeting_Text1">
                        Please click below to either continue onto our website home page or check out why you should register and join us.
                        </p>
                        


                        <Link to ="/SignUp">
                    <Button className="bp3-minimal continue" rightIcon="arrow-right" intent = "none">Register/Login</Button>
                    </Link>


                    <Link to ="/why/R1">
                    <Button className="bp3-minimal why" rightIcon="arrow-right">Why Join Us?</Button>
                    </Link>


                    

                    <div className = "Contact_Details">
                    <p>Email: <a href="/">Tomiilori@Ponc.ie</a></p>
                    <p>Phone: <a  href="/">083245831</a></p>
                    </div>
                </div>
            </div>
            
           
        )
    }
}

export default Welcome