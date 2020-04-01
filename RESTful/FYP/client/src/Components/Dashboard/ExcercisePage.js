import React, { Component } from 'react'
import Navabr from '../General/Navabr';
import {Link} from "react-router-dom";
import {
    Card, CardImg, CardText, CardBody,
    CardTitle, CardSubtitle, Button
  } from 'reactstrap';

  import {Chart} from 'primereact/chart';
  import axios from "axios"
  import "../../../node_modules/primeflex/primeflex.css"
  import 'bootstrap/dist/css/bootstrap.min.css';
  import "../../CSS/DashboardComponents/UserDashboard/Fitness.css"


export class ExcercisePage extends Component {



    
    render() {

        const linedata = {
            labels: ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'],
            datasets: [
                {
                    label: 'First Dataset',
                    data: [65, 59, 80, 121,],
                    fill: false,
                    backgroundColor: '#D976ED',
                    borderColor: '#D976ED'
                },
            ]
        };

        const piedata = {
            labels: ['Calories Burned','Calories Remaining'],
            datasets: [
                {
                    data: [300,  100],
                    backgroundColor: [
                        "#D976ED",
                        "#FFFFFF",
                        "#FFCE56"
                    ],
                    hoverBackgroundColor: [
                        "#FF6384",
                        "#36A2EB",
                        "#FFCE56"
                    ]
                }]
            };

        
            const options = {
                title: {
                    display: true,
                    text: 'Calories Burned',
                    fontSize: 16
                },
                legend: {
                    position: 'bottom'
                }
            };
        
            const options1 = {
                title: {
                    display: true,
                    text: 'Daily Progress',
                    fontSize: 16
                },
                legend: {
                    position: 'bottom'
                }
            };
        



        const buttonstyle=
        {
            backgroundColor:"#D976ED",
            width:"47%",
            marginTop:"10px",
            

        }

        const cardStyle=
        {
            height:"100%"
        }

        return (
            <div>
                <Navabr/>
                <div className="p-grid">
                <div className="p-col-12 heading1"><h1>Fitness Tracker</h1></div>

                </div>

                <div className="p-grid">
                <div className="p-col-5  block1">

                <Card >
                <Chart type="line" data={linedata} options={options1}/>
                </Card>
                </div>

                <div className="p-col-5 p-offset-1 block2">

                <div className="cardHeight">
                <Card >
                <Chart type="pie" data={piedata} options={options}/>
                </Card>
                </div>
                
                </div>

                </div>

                <div className="p-grid">
                <div className="p-col-3  block3">

                <Link to="/UserDashboard">
                <Button style ={buttonstyle}>Back</Button>
                </Link>
                </div>

                <div className="p-col-3 p-offset-5 block4">
                <Button style ={buttonstyle}>Add Excercise</Button>
                <Button style ={buttonstyle}>Create Excersise Plan</Button>
                <Button style ={buttonstyle}>Why Fitness Matters</Button>
                <Button style ={buttonstyle}>Daily Log</Button>
                </div>

                </div>
                
            </div>
        )
    }
}

export default ExcercisePage
