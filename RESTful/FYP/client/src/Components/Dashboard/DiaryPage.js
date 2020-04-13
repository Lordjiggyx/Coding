import React, { Component } from 'react'
import Navabr from '../General/Navabr';
import {Link} from "react-router-dom";
import axios from "axios"
import {
    Card, CardImg, CardText, CardBody,
    CardTitle, CardSubtitle, Button,Modal, ModalHeader, ModalBody, ModalFooter ,ListGroup, ListGroupItem, ListGroupItemHeading ,  ListGroupItemText,  InputGroup, InputGroupAddon, InputGroupText , Form, FormGroup, Label, Input, FormText ,Row,Col , Alert
 ,Nav , NavItem ,NavLink ,TabContent, TabPane, CardFooter } from 'reactstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import "../../CSS/DashboardComponents/UserDashboard/Diary.css"

export class DiaryPage extends Component {


    state={
        title:"",
        author:localStorage.getItem("Email"),
        body:"",
        date:this.getDate(),
        stitle:"",
        e_id:0,
        latestEntries:[],
        modalToggle:false,
        m2:false,
        m3:false,
        m4:false,
        modalData:
            {
                title:"",
                stitle:"",
                body:"",
                date:""
            }
            ,
            color:""

    }

    componentDidMount()
    {
        this.getLatestEntries()
        this.getEntryData()
    }


    handleChange = input => e =>{
        this.setState({
            [input]:e.target.value
        })
        
    }

    getDate()
    {
        const d = new Date();
        let year = d.getFullYear();
        let month = (1 + d.getMonth()).toString().padStart(2, '0');
        let day = d.getDate().toString().padStart(2, '0');

        const date = `${day}/${month}/${year}`
        return date
    }

    getEntry()
    {

    }
    
    viewEntry= (e_id)=>
    {
        console.log(e_id)
        this.setState({e_id:e_id})

        axios.get(`/Routes/API//Entries/getEntry//${e_id}`)
        .then(res =>
            {
                console.log(res.data)
                this.setState({
                    modalData:
                    {
                        title:res.data.Title,
                        body:res.data.Body,
                        stitle:res.data.SubTitle,
                        date:res.data.Date
                    }
                })
            })

        this.modal()
    }

    modal=()=>
    {
       this.setState({
        modalToggle:!this.state.modalToggle
       })
    }

    m4=()=>
    {
       this.setState({
        m4:!this.state.m4
       })
    }

    m2=(id)=>
    {
    
       this.setState({
        m2:!this.state.m2,
        e_id:id
       })
    }

    m3=(id)=>
    {
    
       this.setState({
        m3:!this.state.m2,
        e_id:id
       })

       axios.get(`/Routes/API//Entries/getEntry//${this.state.e_id}`)
       .then(res =>
           {
              document.getElementById("etitlefield").value = res.data.Title
              document.getElementById("estitle").value = res.data.SubTitle
              document.getElementById("eareafield").value = res.data.Body

              this.setState
             ( {
                  title:res.data.Title,
                  stitle:res.data.SubTitle,
                  body:res.data.Body
              })
           })
    }

    getEntryData()
    {
        axios.get(`/Routes/API//Entries/getED/${this.state.author}`)
        .then(res =>
            {
                console.log(res.data)
            }
        )
    }

    getLatestEntries()
    {
        axios.get(`/Routes/API//Entries/getEntries/${this.state.author}`)
        .then(res =>
            {
                this.setState({latestEntries:res.data})
            })
            console.log("here")
    }

    deleteEntry =  e =>
    {
        e.preventDefault()
        axios.get(`/Routes/API//Entries/delEntry/${this.state.e_id}`)
        .then(this.getLatestEntries())
        this.m2()
        this.getLatestEntries()
        this.getLatestEntries()
        
        
    }


    SubmitEntry = async e =>
    {
        e.preventDefault();

       

        const enumb = Math.floor(Math.random() * 1000) + 1  
        // this.setState({e_id:enumb})
        // console.log(enumb)
        const entry =
        {
            title:this.state.title,
            stitle:this.state.stitle,
            date:this.state.date,
            body:this.state.body,
            author:this.state.author,
            e_id:enumb,
        }
        console.log(entry)
 

        const response =  fetch(`/Routes/API//Entries/add`, {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
           body: JSON.stringify(entry)
        },
        this.setState({
            title:"",
            body:"",
            stitle:"",
            e_id:0
         
        })
        
        ).then(document.getElementById("form1").reset()).then(this.getLatestEntries()).then(this.getLatestEntries())
        
        
    }

    editEntry = e =>
    {
        e.preventDefault()
        const entry =
        {
            title:this.state.title,
            stitle:this.state.stitle,
            body:this.state.body,

        }

        
        const response =  fetch(`/Routes/API//Entries/saveEntry/${this.state.e_id}`, {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
           body: JSON.stringify(entry)
        },
        this.setState({
            title:"",
            body:"",
            stitle:"",
            e_id:0,
            m3:false,
            modalToggle:false,
            m2:false
        })
        
        )
        this.getLatestEntries() 
       
    }


    buttonColour=(score)=>
    {
         if(score < 0 && score <= -7)
         {
            return "danger"
         }
         else if(score < 0 && score > -7)
         {
             return "info"
         }
         else if(score > 0 && score < 7)
         {
             return "warning"
         }
         else if(score > 0 && score > 7)
         {
             return "success"
         }
         else
         {
             return "dark"
         }


    }
    render() {

        const buttonstyle=
        {
            backgroundColor:"#D976ED",
            width:"100%",
            marginTop:"10px",
        
        }

        const buttonstyle2=
        {
            backgroundColor:"#D976ED",
            width:"100%",
            marginTop:"10px",
        
        }

        const buttonstyle3=
        {
            
            width:"50%",
            marginTop:"10px",
        
        }

       

        return (
            <div>
                <Navabr/>
                <div className="p-grid">
                <div className="p-col-12 heading1"><h1>Diary</h1></div>

                {/* Diary block */}
                <div className="p-offset-1 p-col-5  ">
                <Form className="entryForm" id="form1">
                <h3 className="heading2">Write Something</h3>
                <FormGroup>
                    <Label  for="title"><strong>Title</strong></Label>
                    <Input  type="text" name = "titlefield "id="titlefield" placeholder="Enter A Title" onChange={this.handleChange("title")}></Input>

                    <Label  for="stitle"><strong>Sub-Title</strong></Label>
                    <Input  type="stitle" name = "stitle "id="stitle" placeholder="Give A Short Description" onChange={this.handleChange("stitle")}></Input>

                    <Label for="are"><strong>Description</strong></Label>
                    <Input type="textarea" rows ="8"id="areafield" name="areafield" placeholder="Tell Us Everything" onChange={this.handleChange("body")}></Input>

                    <Button style={buttonstyle2} onClick={this.SubmitEntry}>Submit</Button>
                </FormGroup>

                </Form>
                </div>


                {/* Entries Block */}
                <div className="p-col-4 p-offset-1   ">
                    <h3 className="heading2">Most Recent Entries</h3>
                    
            <ListGroup className="diary text-center" >
                {this.state.latestEntries.map((entry , i)=>
            
                <ListGroupItem  color={this.buttonColour(entry.Sentiment_Score)} key={i}>
                    <ListGroupItemHeading ><strong>{entry.Title}</strong></ListGroupItemHeading>
                <ListGroupItemText><strong><em>"{entry.SubTitle}"</em></strong></ListGroupItemText>
                <Button style={buttonstyle3} color={this.buttonColour(entry.Sentiment_Score)}  onClick={(e) =>this.viewEntry(entry.E_id)}>View</Button>
                <Button style={buttonstyle3} color={this.buttonColour(entry.Sentiment_Score)} onClick={(e)=> this.m2(entry.E_id)}>Delete</Button>
                </ListGroupItem>
                
                )}
            </ListGroup>

        {/* <Row>
        {this.state.latestEntries.map((entry , i) =>
        
            <Col sm="6" key={i}>
                <Card className="text-center" size="lg">
                <CardTitle style={{color:"#D976ED"}}><strong>{entry.Title}</strong></CardTitle>
                <CardSubtitle><strong><em>"{entry.SubTitle}"</em></strong></CardSubtitle>
                <CardBody>
                <Row>
                <Col sm="6">
                <Button style={buttonstyle} onClick={(e) =>this.viewEntry(entry.E_id)}>View</Button>
                </Col>
                <Col sm="6">
                <Button style={buttonstyle} onClick={(e)=> this.m2(entry.E_id)}>Delete</Button>
                </Col>
                </Row>
                <br></br>
                Date Created:{entry.Date}
                </CardBody>
                </Card>
                
            </Col>
        )}

        </Row> */}

                </div>

                <div className ="p-col-5 p-offset-1">
                <Link to="/UserDashboard">
                    <Button style ={buttonstyle}>Back</Button>
                    </Link>
                    </div>

                    <div className ="p-col-4 p-offset-1">
                
                    <Button  onClick={this.m4}style ={buttonstyle}>Why Are the Colours Different?</Button>
            
                    </div>

                </div>
                

                <Modal className="text-center"  size = "lg"isOpen={this.state.modalToggle}
                toggle={this.modal}>
                <ModalHeader >{this.state.modalData.title}</ModalHeader>
                <ModalBody>
                <h5 className="info-title">{this.state.modalData.stitle}</h5>
                <p>{this.state.modalData.body}</p>
                <p><strong>Date Created: {this.state.modalData.date}</strong></p>
                </ModalBody>
                <ModalFooter>
                <Button style={buttonstyle} onClick={(e)=>this.m3(this.state.e_id)}>Edit</Button>
                <Button style={buttonstyle} onClick={this.modal}>Close</Button>
                </ModalFooter>
                </Modal>

                <Modal className="text-center" isOpen={this.state.m2}
                toggle={this.m2}>
                <ModalHeader >Delete Entry</ModalHeader>
                <ModalBody>
               
                <p>Are You sure You Want To Delete This Entry?</p>

                </ModalBody>
                <ModalFooter>
                <Button style={buttonstyle} onClick={this.deleteEntry}>Yes</Button>
                <Button style={buttonstyle} onClick={this.m2}>No</Button>
                </ModalFooter>
                </Modal>

                <Modal className="text-center" isOpen={this.state.m3}
                toggle={this.m3}>
                <ModalHeader >Edit Entry</ModalHeader>
                <ModalBody>
               
                    <Label  for="title"><strong>Title</strong></Label>
                    <Input  type="text" name = "titlefield "id="etitlefield" placeholder="Enter A Title" onChange={this.handleChange("title")}></Input>

                    <Label  for="stitle"><strong>Sub-Title</strong></Label>
                    <Input  type="stitle" name = "stitle "id="estitle" placeholder="Give A Short Description" onChange={this.handleChange("stitle")}></Input>

                    <Label for="are"><strong>Description</strong></Label>
                    <Input type="textarea" rows ="8"id="eareafield" name="areafield" placeholder="Tell Us Everything" onChange={this.handleChange("body")}></Input>

                </ModalBody>
                <ModalFooter>
                <Button style={buttonstyle} onClick={this.editEntry}>Save</Button>
                <Button style={buttonstyle} onClick={()=>this.setState({m3:false})}>Cancel</Button>
                </ModalFooter>
                </Modal>


                <Modal  isOpen={this.state.m4}
                toggle={this.m4}>
                <ModalHeader >Why The Colours Are Different?</ModalHeader>
                <ModalBody>
                <h4 className ="info-title">Different Colours?</h4>

                <p>By now should notice that the colour of each entry is different, we designed this diary to actively read your entry and predict the mood that you may have felt at the time of entry , based on the content you wrote in your entry, your mood is placed on a score and this score is reflected in the colour of the entry</p>

                <p>Here are the meanings of each color:</p>
                <li>Green = Very Postive</li>
                <li>Yellow = Slightly Postive</li>
                <li>Grey = Neutral</li>
                <li>Blue = Slightly Negative</li>
                <li>Red = Very Negative</li>

                </ModalBody>
                <ModalFooter>
                <Button style={buttonstyle2} onClick={this.m4}>Close</Button>
               
                </ModalFooter>
                </Modal>
            </div>

            
        )
    }
}

export default DiaryPage
