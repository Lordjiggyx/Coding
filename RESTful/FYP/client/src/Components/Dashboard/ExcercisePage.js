import React, { Component  ,useState } from 'react'
import Navabr from '../General/Navabr';
import {Link} from "react-router-dom";
import {
    Card, CardImg, CardText, CardBody,
    CardTitle, CardSubtitle, Button,Modal, ModalHeader, ModalBody, ModalFooter ,  InputGroup, InputGroupAddon, InputGroupText , Form, FormGroup, Label, Input, FormText ,Row,Col , Alert
 ,Nav , NavItem ,NavLink ,TabContent, TabPane } from 'reactstrap';

  import {Chart} from 'primereact/chart';
  import axios from "axios"
  import "../../../node_modules/primeflex/primeflex.css"
  import 'bootstrap/dist/css/bootstrap.min.css';
  import "../../CSS/DashboardComponents/UserDashboard/Fitness.css"
import { pbkdf2 } from 'crypto';


export class ExcercisePage extends Component {

    
    state = 
    {
        email:localStorage.getItem("Email"),
        weight:0,
        m1:false,
        m2:false,
        m3:false,
        m4:false,
        m5:false,
       // CurrentDay:'',
        SelectedExcercise:'Cycling',
        Excercises:[],
        Duration:0,
        CaloriesBurnedWorkout:0,
        WeeklyTarget:0,
        DateStarted:"",
        Week:"",
        TodaysCalories:"",
        lineChartData:[ 0,0,0,0,0,0,0],
        pieChartData:[0,0],


        
    }

    shouldComponentUpdate()
    {
        if(this.state.render== false)
        {
            return false
        }
        if(this.state.render==true)
        {
            return true
        }
        else
        {
            return true
        }
    }

componentDidMount = () =>
{
    this.getCurrentDay()
    this.getExcercies()
    this.getUser()
    this.getWeeklyTarget()
    this.getWeek()
    this.setTarget = this.setTarget.bind(this)
    this.getTodaysCalories()
    

}


alertHandler=()=>
{
    this.setState({alertVis:!this.state.alertVis})
}


getTodaysCalories=()=>
{
    axios.get(`/Routes/API//fitness/getCalories/${this.state.email}`)
    .then(res =>
        {
            this.setState({TodaysCalories:res.data})
           // this.populateLineChart()
            this.populatePieChart(this.state.WeeklyTarget)
            console.log(this.state.TodaysCalories)
            this.setDailyProgress()
        }

    )
    }


getWeeklyTarget=() =>
{
    axios.get(`/Routes/API//fitness/getTarget/${this.state.email}`)
    .then(res=>
        {
            console.log(res.data)
           
            this.setState({
                WeeklyTarget:res.data.CalorieTarget,
                DateStarted:res.data.DateSet,
                lineChartData:res.data.dailyInfo
            })
        })
}
getUser = () =>
{
    axios.get(`/Routes/API//users/getUser/${this.state.email}`)
    .then(res => {
        this.setState(
            {
                weight:res.data.Weight
            }
        )
        console.log(this.state.weight)
      })
}
    
    getCurrentDay = () =>
    {
        var d = new Date();
        var d7 = new Date(d)
        d7.setDate(d7.getDate()+ 7)
        var weekday = new Array(7);
        weekday[0] = "Sunday";
        weekday[1] = "Monday";
        weekday[2] = "Tuesday";
        weekday[3] = "Wednesday";
        weekday[4] = "Thursday";
        weekday[5] = "Friday";
        weekday[6] = "Saturday";
        console.log(d7.getDate())
        this.setState({
            CurrentDay:weekday[d.getDay()]
        })
    }
    

    getWeek =() =>
    {
        const date = new Date()
         // ISO week date weeks start on Monday, so correct the day number
  var nDay = (date.getDay() + 6) % 7;

  // ISO 8601 states that week 1 is the week with the first Thursday of that year
  // Set the target date to the Thursday in the target week
  date.setDate(date.getDate() - nDay + 3);

  // Store the millisecond value of the target date
  var n1stThursday = date.valueOf();

  // Set the target to the first Thursday of the year
  // First, set the target to January 1st
  date.setMonth(0, 1);

  // Not a Thursday? Correct the date to the next Thursday
  if (date.getDay() !== 4) {
    date.setMonth(0, 1 + ((4 - date.getDay()) + 7) % 7);
  }

  
  // The week number is the number of weeks between the first Thursday of the year
  // and the Thursday in the target week (604800000 = 7 * 24 * 3600 * 1000)
  const week= 1 + Math.ceil((n1stThursday - date) / 604800000);
  console.log(`Week ${week}/52`)
  this.setState({Week:week})
    }
    getExcercies= () =>
    {
        axios.get("/Routes/API//fitness/getExcercises")
        .then(res =>{
            let excerciseAPi = res.data.map(exc=>
                {
                    return {id:exc._id , name:exc.Name , MET:exc.MET} 
                })
                this.setState({Excercises:excerciseAPi})
            console.log(this.state.Excercises)
        })
    
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

    m3Toggle =()=>
    {
        this.setState({
            m3:!this.state.m3
        })
    }
    m4Toggle =()=>
    {
        this.setState({
            m4:!this.state.m4
        })
    }

    m5Toggle =()=>
    {
        this.setState({
            m5:!this.state.m5
        })
    }


    handleChange = input => e =>{
        this.setState({
            [input]:e.target.value
        })
        
    }

    addWorkout = async e =>
    {
        e.preventDefault();

        const d = new Date();
        let year = d.getFullYear();
        let month = (1 + d.getMonth()).toString().padStart(2, '0');
        let day = d.getDate().toString().padStart(2, '0');

        const date = `${day}/${month}/${year}`

        const workout =
        {
            excercise:this.state.SelectedExcercise,
            date:date,
            duration:this.state.Duration,
            calories:this.state.CaloriesBurnedWorkout,
            email:this.state.email,
            today:this.state.TodaysCalories
        }
        console.log(workout)

        const response = await fetch(`/Routes/API//fitness/saveWorkout/${this.state.email}`, {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
           body: JSON.stringify(workout)
        },
        this.setState({
            SelectedExcercise:"",
            Duration:0,
            CaloriesBurnedWorkout:0,
            m1:!this.state.m1,
         
        }),this.getWeeklyTarget(),this.getTodaysCalories(),this.getWeeklyTarget()
        )
        console.log(response.text())
        
        
        
        // this.populateLineChart()
        // this.populatePieChart(this.state.WeeklyTarget)

         document.getElementById("form1").reset();
        
    }

    setDailyProgress= async e=>
    {       
        
        const progress=
        {
            value:this.state.TodaysCalories
        }
        console.log(progress.value)
        const response = await fetch(`/Routes/API//fitness/setDailyProgress/${this.state.email}`,
        {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body:JSON.stringify(progress)
        },this.getWeeklyTarget())
    }   


    setTarget = async e =>
    {
        e.preventDefault()
        e.persist()
        const dbv =document.getElementById("Target").value
        var d = new Date();
        this.populatePieChart(dbv)
        const data = 
        {
            target:dbv,
            dateSet:d
        }
 
        const response = await fetch(`/Routes/Api//fitness/saveTarget/${this.state.email}`,
        {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body:JSON.stringify(data)
        }
        ,this.setState({
            m2:!this.state.m2,
            WeeklyTarget:dbv
        }), this.alertHandler())
       
    }

    caloriesBurned =()=>
    {
        const se = this.state.SelectedExcercise
        // console.log(se)
        const found  = this.state.Excercises.find(e => e.name == se)
        // console.log(found)
        // console.log(found.MET)

        const caloriesPerHour = this.state.weight * found.MET
        // console.log(caloriesPerHour)

       const percentOfMet = this.state.Duration/60

        // console.log(percentOfMet)

       const  cb = caloriesPerHour * percentOfMet

       const num =cb.toFixed(1)
        this.setState({
            CaloriesBurnedWorkout:num
        })

        // console.log(this.state.CaloriesBurnedWorkout)
    }

    populateLineChart=() =>
    {
        axios.get(`/Routes/API//fitness/getTarget/${this.state.email}`)
        .then(res=>
            {
                console.log(res.data)
               
                this.setState({
                    lineChartData:res.data.dailyInfo
                })
    
                this.populateLineChart(this.state.lineChartData)
            })
    }

    populatePieChart = (dbv) =>
    {
        var burnt = this.state.TodaysCalories
        var remaining = 0
        remaining = dbv- this.state.TodaysCalories
        console.log("burnt:"+burnt)
        console.log("remain:"+remaining)
        
        if(burnt>dbv)
        {
            var pdata= [burnt]
        }
        else 
        {
            var pdata= [burnt , remaining]
        }
        this.setState({pieChartData:pdata})
    }


    render() {

        const durations=[0,10 ,20 ,30 ,40 , 50 ,60 ,70 ,80 , 90 ,100 ,110 ,120]

        const linedata = {
            labels: ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'],
            datasets: [
                {
                    label: 'Calories Burned Each Day',
                    data: this.state.lineChartData,
                    fill: false,
                    backgroundColor: '#D976ED',
                    borderColor: '#D976ED'
                },
            ]
        };

        const piedata = {
            labels: [`Calories Burned Today`,`Calories Remaining `],
            datasets: [
                {
                    data: this.state.pieChartData,
                    backgroundColor: [
                        "#FF8598",
                        "#C1FCF6",
                      
                    ],
                    
                }]
            };

        
            const options = {
                title: {
                    display: true,
                    text: `Current Daily Target  : ${this.state.WeeklyTarget} kcal`,
                    fontSize: 16
                },
                legend: {
                    position: 'bottom'
                },
                animation: {
                    duration: 20
                }
            };
        
            const options1 = {
                title: {
                    display: true,
                    text: `Daily Progress: Week: ${this.state.Week} of 2020`,
                    fontSize: 16
                },
                legend: {
                    position: 'bottom'
                }
                ,    animation: {
                    duration: 20
                }
            };
        



        const buttonstyle=
        {
            backgroundColor:"#D976ED",
            width:"47%",
            marginTop:"10px",
        
        }
        const buttonstyle2=
        {
            backgroundColor:"#D976ED",
            width:"100%",
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
                <div className="p-col block3  ">

                    <div className="p-col ">
                    <div>
                        {/* <Alert color="success" isOpen={this.state.alertVis} toggle={this.alertHandler}>
                        Target set
                    </Alert> */}
    </div>
                    
                    <Button style ={buttonstyle} onClick={this.m1Toggle}>Log Workout </Button>
                    <Button style ={buttonstyle}onClick={this.m2Toggle}>Set Daily Target</Button>
                    <Link to="/UserDashboard">
                    <Button style ={buttonstyle}>Back</Button>
                    </Link>
                    <Button style ={buttonstyle}onClick={this.m3Toggle}>More Information</Button>
                    
                    </div>

                    

                    

            
                </div>



                </div>
                

                <Modal isOpen={this.state.m1}
                toggle={this.m1Toggle}>
                <ModalHeader >Log Workout</ModalHeader>
                <ModalBody>
                <InputGroup>
                <Form className="addExcercise" id="form1">
                    <FormGroup>
    

                        <Label for="SelectWorkout">Select Excercise</Label>
                        <Input type = "select" name ="SelectWorkout" id = "SelectWorkout" onChange={this.handleChange("SelectedExcercise")}>
                        {this.state.Excercises.map((exc , i) => <option key={i}>{exc.name}</option>)}
                        </Input>

                        <Label for="ExCat">Duration in Minutes</Label>
                        <Input type="select" name ="ExCat" id="ExCat" onChange={this.handleChange("Duration")}>
                        {durations.map((time , i) => <option key={i}>{time}</option>)}
                        </Input>
                        <Label for="ExRate">Calories Burned </Label>
                        <Input plaintext value={`${this.state.CaloriesBurnedWorkout} Calories Burned`} onChange={this.handleChange("CurrentDay")}/>

                        <Button style={buttonstyle} onClick={this.caloriesBurned}>Calculate Calories</Button>
                  
                    </FormGroup>
                </Form>
                </InputGroup>                  
                </ModalBody>
                <ModalFooter>
                    <Button style={buttonstyle} onClick={this.addWorkout}>Save</Button>
                    <Button style={buttonstyle} onClick={this.m1Toggle}>Cancel</Button>
                </ModalFooter>
                </Modal>


                <Modal isOpen={this.state.m2}
                toggle={this.m2Toggle}>
                <ModalHeader >Weekly Target</ModalHeader>
                <ModalBody>
                <InputGroup>
                <Form className="addExcercise" id="form2" >
                    <FormGroup>
                        <Label for="Target">Target</Label>
                        <Input type="text" name ="Target" id="Target" placeholder="Set Your Target For The Week" ref="targ" />          
                    </FormGroup>
                </Form>
                </InputGroup>                  
                </ModalBody>
                <ModalFooter>
                    <Button style={buttonstyle} onClick={this.setTarget.bind(this)} >Save</Button>
                    <Button style={buttonstyle} onClick={this.m2Toggle}>Cancel</Button>
                </ModalFooter>
                </Modal>


            <Modal isOpen={this.state.m3} toggle={this.m3Toggle}>
            <ModalHeader >More Information</ModalHeader>
                <ModalBody>
                <Row>
            <Col sm="6">
              <Card body>
                <CardTitle>Why Fitness Matters</CardTitle>
                <CardText>Find out why your fitness matters in your fight with cancer</CardText>
                <Button style={buttonstyle2} onClick={this.m4Toggle}>Click Here</Button>
              </Card>
            </Col>
            <Col sm="6" >
              <Card body>
                <CardTitle>Calorie Calculator</CardTitle>
                <CardText>Understand how we calculate the calories your burnt calories</CardText>
                <Button style={buttonstyle2}  onClick={this.m5Toggle}  >Click Here</Button>
              </Card>
            </Col>
            <Col  >
              <Card body>
                <CardTitle>More Information</CardTitle>
                <CardText>Click below to find out more about why fitness matters</CardText>
                <Button style={buttonstyle2} href="https://www.cancer.ie/cancer-information-and-support/cancer-prevention/physical-activity-and-cancer" target="_blank" >Click Here</Button>
              </Card>
            </Col>
           
          </Row>

            </ModalBody>
            <ModalFooter><Button style={buttonstyle2} onClick={this.m3Toggle}>Close</Button></ModalFooter>
            </Modal>


            <Modal size = "lg"isOpen={this.state.m4} toggle={this.m4Toggle}>
            <ModalHeader >Why Fitness Matters</ModalHeader>
                <ModalBody>

                <h4 className ="info-title">Why Fitness Matters?</h4>

                <p>Evidence linking higher physical activity to lower cancer risk comes mainly from observational studies, in which individuals report on their physical activity and are followed for years for diagnoses of cancer. Although observational studies cannot prove a causal relationship, when studies in different populations have similar results and when a possible mechanism for a causal relationship exists, this provides evidence of a causal connection.</p>

                <p>It is advised to excercise for at least 150 miunutes a week, with this follows benefits these include:</p>
                <li>Improve quality of life during and after cancer treatment</li>
                <li>Prevent or improve lymphoedema (a type of swelling caused by treatment to lymph nodes)</li>
                <li>Improve general physical functioning</li>
                <li>Lower the risk of being anxious and depressed</li>
                <li>Keep muscles from wasting due to inactivity</li>


                <ModalFooter>
                    <Button style={buttonstyle2} onClick={this.m4Toggle}>Close</Button>
                </ModalFooter>
            </ModalBody>
            </Modal>

            <Modal size = "lg"isOpen={this.state.m5} toggle={this.m5Toggle}>
            <ModalHeader >Calorie Calculator</ModalHeader>
                <ModalBody>

                <h4 className ="info-title">How We Calculate Your Calories?</h4>

                <h6 className ="info-title">What Are calories?</h6>
                <p>A calorie is a measure of energy expenditure and stored energy. The calories referred to in diet (calories eaten) and exercise (calories burned) are kilocalories (kcal).</p>

                <h6 className ="info-title">Calories & Excercise?</h6>
                <p>Physical activity burns calories beyond the basal metabolic rate. Your muscles use both readily available and stored energy sources in your body.Depending on the duration and intensity of exercise, your body burns available blood sugar, glycogen stored in the muscles and liver, fat and, if required, even begins to burn muscle protein.</p>

                <h6 className ="info-title">How We Do It?</h6>
                <p>Now that you understand what a calorie is and how it fits into your life in relation to physical activity, we'll explain how we calculate the calories you burn during excercise</p>

                <p>Every activity has a value called a "MET value" which calculates the energy required for that activity,which stands for metabolic equivalent. This is considered to be 1kcal/kg/hour. For example sitting down has a value of one MET so if you weighed 70kg and sat for an hour you would burn 70 calories.</p>

                <p>When you registered you infomred us on your current weight we take this value and multiply it by the MET value of your selected excercise, we then get the percentage of an hour that you did this excercise and multiply it by this value, whihc gives you the calores burned doing a certain excercise. </p>

                <ModalFooter>
                    <Button style={buttonstyle2} onClick={this.m5Toggle}>Close</Button>
                </ModalFooter>
            </ModalBody>
            </Modal>

            </div>
        )
    }
}

export default ExcercisePage
