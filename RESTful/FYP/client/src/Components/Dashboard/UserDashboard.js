import React, { Component } from 'react'
import Navabr from '../General/Navabr';
import axios from "axios"
import "../../../node_modules/primeflex/primeflex.css"
import "../../CSS/DashboardComponents/UserDashboard/Home.css"
import 'bootstrap/dist/css/bootstrap.min.css';
import {
    Card, CardImg, CardText, CardBody,
    CardTitle, CardSubtitle, Button
  } from 'reactstrap';

import workout from "../../Images/workout.png"
import calender from "../../Images/calender.png"
import diary from "../../Images/diary.png"
import diet from "../../Images/diet.png"
import emotions from "../../Images/emotions.png"
import research from "../../Images/mResearch.png"
import {Link} from "react-router-dom";
export class UserDashboard extends Component {



    
    state = {
        email:localStorage.getItem("Email"),
        user:{}
    }

    componentDidMount()
{
    
    axios.get(`/Routes/API//users/getUser/${this.state.email}`)
    .then(res => {
        this.setState(
            {
                user:res.data
                
            }
        )
        console.log(this.state.user)
      })
}



    render() {
        const buttonstyle=
        {
            backgroundColor:"#D976ED"
        }
        

        const user = this.state.user
        return (
            <div>
                <Navabr/>
                <div className="p-grid">
                <div className="p-col-12 heading"><h1>Greetings {user.FirstName}</h1></div>

                </div>

                <div className="p-grid">
                <div className="p-col-12 mid"><h4>Welcome To Your Dashboard Please select one of the following options below</h4></div>

                </div>

                <div className="p-grid">

                <div className="p-col-6 p-offset-3 bottom"> 
                
                <Card body className="text-center">
                    <CardImg  top width="10%" src={research} alt="Card image cap" />
                    <div className= "boldText">
                    <CardTitle>Understanding Your Cancer Type</CardTitle>
                    </div>
                    <CardText>Cancer is more complicated than you could possibly imagine we want to provide you the most accurate and reliable information about your cancer type and genes that cause  it  </CardText>
                    <Link to = "/Research">
                    <Button style={buttonstyle}>Get To It</Button>
                    </Link>
                   
                </Card>
      
            </div>
                    
                <div className="p-col-6 bottom"> 
                <Card body className="text-center">
                    <CardImg  top width="100px" src={workout} alt="Card image cap" />
                    <div className= "boldText">
                    <CardTitle>Excercise Tracker</CardTitle>
                    </div>
                    <CardText>Set fitness goals for yourself and track your progress!!</CardText>
                    <Link to = "/Fitness">
                    <Button style={buttonstyle}>Let's Do It</Button>
                    </Link>
                   
                </Card>
      
            </div>
            {/* <div className="p-col-6 bottom"> 
                <Card body className="text-center">
                    <CardImg  top width="100px" src={diet} alt="Card image cap" />
                    <div className= "boldText">
                    <CardTitle>Diet Tracker</CardTitle>
                    </div>
                    <CardText>Track your daily intake and manage your calories!!</CardText>
                    <Link to = "/Food">
                    <Button style={buttonstyle}>Bite Me</Button>
                    </Link>
                </Card>
      
            </div> */}

            <div className="p-col-6 bottom"> 
                <Card body className="text-center">
                    <CardImg top width="100%" src={diary} alt="Card image cap" />
                    <div className= "boldText">
                    <CardTitle>Diary</CardTitle>
                    </div>
                    <CardText>Don't bottle in your feelings let us know how you feel!!</CardText>
                    <Link to ="/Diary">
                    <Button style={buttonstyle}>Let It Out</Button>
                    </Link>
                </Card>

                
      
            </div>

            <div className="p-col-6 bottom"> 
                <Card body className="text-center">
                    <CardImg top width="100%" src={calender} alt="Card image cap" />
                    <div className= "boldText">
                    <CardTitle>Calendar</CardTitle>
                    </div>
                    <CardText>Track events in your life and create schdules!!</CardText>
                    <Link to = "/Calender">
                    <Button style={buttonstyle}>Get It Done</Button>
                    </Link>
                   
                </Card>
            </div>


            <div className="p-col-6 bottom"> 
                <Card body className="text-center">
                    <CardImg top width="100%" src={emotions} alt="Card image cap" />
                    <div className= "boldText">
                    <CardTitle>Emotional Awareness</CardTitle>
                    </div>
                    <CardText>Understand your emotions better and how they may be affecting you!!</CardText>
                    <Link to = "/Emotion">
                    <Button style={buttonstyle}>We Feel You</Button>
                    </Link>
                   
                </Card>
            </div>

                </div>
                
               
            </div>
        )
    }
}

export default UserDashboard
