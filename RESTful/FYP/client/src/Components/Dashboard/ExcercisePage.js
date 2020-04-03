import React, { Component  ,useState } from 'react'
import Navabr from '../General/Navabr';
import {Link} from "react-router-dom";
import {
    Card, CardImg, CardText, CardBody,
    CardTitle, CardSubtitle, Button,Modal, ModalHeader, ModalBody, ModalFooter ,  InputGroup, InputGroupAddon, InputGroupText , Form, FormGroup, Label, Input, FormText 
  } from 'reactstrap';

  import {Chart} from 'primereact/chart';
  import axios from "axios"
  import "../../../node_modules/primeflex/primeflex.css"
  import 'bootstrap/dist/css/bootstrap.min.css';
  import "../../CSS/DashboardComponents/UserDashboard/Fitness.css"


export class ExcercisePage extends Component {

    state = 
    {
        m1:false,
        m2:false,
        m3:false,
        m4:false,
        Name:"",
        Description:"",
        Category:"Aerobic",
        Rating:"1",
        
    }


    m1Toggle =()=>
    {
        this.setState({
            m1:!this.state.m1
        })
    }
    m2Toggle =()=>
    {
        this.setState({
            m2:!this.state.m2
        })
    }

    handleChange = input => e =>{
        this.setState({
            [input]:e.target.value
        })
        
    }

    addExercise = async e =>
    {
        e.preventDefault();

        const excercise =
        {
            name:this.state.Name,
            desc:this.state.Description,
            cat:this.state.Category,
            rate:this.state.Rating,
            createdBy:localStorage.getItem("Email")

        }

        const response = await fetch("/Routes/API//excercise/add", {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify(excercise)
        })
        console.log(response.text())

        this.setState({
            Name:"",
            Description:"",
            Category:"Aerobic",
            Rating:"1",
        })

        document.getElementById("form1").reset();
    }

    render() {

        const linedata = {
            labels: ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'],
            datasets: [
                {
                    label: 'Calories Burned Each Day',
                    data: [65, 59, 80, 121,100,12,98,,],
                    fill: false,
                    backgroundColor: '#D976ED',
                    borderColor: '#D976ED'
                },
            ]
        };

        const piedata = {
            labels: ['Calories Burned:','Calories Remaining'],
            datasets: [
                {
                    data: [2000,  95],
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



        return (
            <div>
                <Navabr/>
                <div className="p-grid">
                <div className="p-col-12 heading1"><h1>Fitness Tracker</h1></div>

                </div>

                <div className="p-grid">
                <div className="p-col-5 p-offset-1 block1">

                <Card >
                <Chart type="line" data={linedata} options={options1}/>
                </Card>
                </div>

                <div className="p-col-5  block2">

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
                <Button style ={buttonstyle}
                onClick={this.m1Toggle}>
                    
                Add Excercise
                
                </Button>
    
                <Button style ={buttonstyle}
                 onClick={this.m2Toggle}
                 >Set Weekly Target</Button>
                <Button style ={buttonstyle}>Why Fitness Matters</Button>
                <Button style ={buttonstyle}>Workout</Button>
                
                </div>

                </div>
                

                <Modal isOpen={this.state.m1}
                toggle={this.m1Toggle}>
                <ModalHeader >Add Excercise</ModalHeader>
                <ModalBody>
                <InputGroup>
                <Form className="addExcercise" id="form1">
                    <FormGroup>
                        <Label for="ExName">Name</Label>
                        <Input type="text" name ="name" id="ExName" placeholder="Name" onChange={this.handleChange("Name")}/>

                        <Label for="ExDesc">Description</Label>
                        <Input type="textarea" name ="ExDesc" id="ExDesc" placeholder="Describe This Excercise" onChange={this.handleChange("Description")}/>

                        <Label for="ExCat">Category</Label>
                        <Input type="select" name ="ExCat" id="ExCat" onChange={this.handleChange("Category")}>
                            <option>Aerobic</option>
                            <option>Strength</option>
                            <option>Flexibility</option>
                        </Input>
                        <Label for="ExRate">Rating</Label>
                        <Input type="select" name ="ExRatee" id="ExRate"  onChange={this.handleChange("Rating")}>
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </Input>        
                  
                    </FormGroup>
                </Form>
                </InputGroup>                  
                </ModalBody>
                <ModalFooter>
                    <Button style={buttonstyle} onClick={this.addExercise}>Add</Button>
                    <Button style={buttonstyle} onClick={this.m1Toggle}>Cancel</Button>
                </ModalFooter>
                </Modal>


                <Modal isOpen={this.state.m2}
                toggle={this.m2Toggle}>
                <ModalHeader >Weekly Target</ModalHeader>
                <ModalBody>
                <InputGroup>
                <Form className="addExcercise" id="form2">
                    <FormGroup>
                        <Label for="Target">Target</Label>
                        <Input type="text" name ="Target" id="Target" placeholder="Set Your Target For The Week"/>          
                    </FormGroup>
                </Form>
                </InputGroup>                  
                </ModalBody>
                <ModalFooter>
                    <Button style={buttonstyle}>Save</Button>
                    <Button style={buttonstyle} onClick={this.m2Toggle}>Cancel</Button>
                </ModalFooter>
                </Modal>


            </div>
        )
    }
}

export default ExcercisePage
