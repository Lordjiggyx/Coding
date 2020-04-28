import React, { Component } from 'react'
import Navabr from '../General/Navabr';
import {Link} from "react-router-dom";
import axios from "axios"
import {
    Card, CardText, CardBody,
    CardTitle, CardSubtitle, Button,Modal, ModalHeader, ModalBody, ModalFooter
} from 'reactstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Chart} from 'primereact/chart';
import {Carousel} from 'primereact/carousel';
import 'primereact/resources/themes/nova-light/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';

export class EmotionPage extends Component {
    
    
    state=
    {
        email:localStorage.getItem("Email"),
        ed:{},
        name:"",
        Sentiment:"",
        quote:"",
        m1:false,
        articles:[]
    }

    componentDidMount()
    {
        axios.get(`/Routes/API//users/getUser/${this.state.email}`)
        .then(res => {
            this.setState(
                {
                    name:res.data.FirstName
                    
                }
            )
          })
        this.getEntryData()
        this.getQuote()
        // this.getArticles()
        
    }

    getEntryData()
    {
        axios.get(`/Routes/API//Entries/getED/${this.state.email}`)
        .then(res =>
            {
                this.setState({
                    ed:res.data,
                })
            }
        )
    }

    getQuote()
    {
        axios.get("https://type.fit/api/quotes")
        .then(res => 
            
            {
                var random = Math.floor(Math.random()*1643)
                this.setState({quote:res.data[random]})
            })
        
        }

        
    m1=()=>
    {
       this.setState({
        m1:!this.state.m1
       })
    }
    
    articleTemplate(art)
    {
        return (
        <div>
        <Card style={{height:"300px" , margin:"5px"}}  className="text-center">
       
        <CardBody>
          <CardTitle><strong>{art.title}</strong></CardTitle>
        <CardSubtitle><a href={art.url} target="_blank">Website</a></CardSubtitle>
          <CardText>{art.snippet}</CardText>
          <Button href={art.url} target="_blank" style={ {
                backgroundColor:"#D976ED",
                width:"100%",
                marginTop:"10px",
            
            }}>Give It A Read</Button>
        </CardBody>
      </Card>
        </div>
        )
    }

    getArticles()
    {
        window.setTimeout(()=>{

            const  Queries=
        {
            positive:"how positivity affects health recent",
            negative:"how negativity affects health recent",
            neutrual:"how mental health affects health recent"
        }
       
        console.log(this.state.ed)
        var question =""

        if(this.state.ed.Sentiment === "positive")
        {
            question=Queries.positive
            console.log(question)
        }
        if(this.state.ed.Sentiment === "negative")
        {
            question=Queries.negative
            console.log(question)
        } if(this.state.ed.Sentiment === "neutrual")
        {
            question=Queries.neutrual
            console.log(question)
        }

       
        const params = {
        access_key: 'eb7a8e81a09f4e209081d05b0660de90',
        query: question,
        num:20
        }

        axios.get('http://api.serpstack.com/search', {params})
        .then(response =>
        {
            let apiResponse = response.data.organic_results.filter((article)=>{
                return article.snippet !== ""
            });
            this.setState({articles:apiResponse})
            console.log(apiResponse)
        })
        .catch(error =>
        {
            console.log(error);
        });

        },2000)
      
    }
    
    
    render() {
        const piedata = {
            labels: [`Positive`,`Negative` ,`Neutrual`],
            datasets: [
                {
                    data:[
                        this.state.ed.positive,
                        this.state.ed.negative,
                        this.state.ed.neutrual],
                    backgroundColor: [
                        "#00FF00",
                        "#FF0000",
                        "#00BFFF",
                      
                    ],
                    
                }],
                text:"23%"
            };


            const options = {
                title: {
                    display: true,
                    text: `Analysis Of Diary Entries`,
                    fontSize: 16
                },
                legend: {
                    position: 'bottom'
                },
                animation: {
                    duration: 20
                }
            };


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
                <div className="p-col-12 heading1"><h1>Quote of Enlightentment</h1></div>

                <div className="p-col-12 heading1"><h4><em>"{this.state.quote.text} - {this.state.quote.author}"</em></h4></div>
                


            
                  <div className="p-offset-1 p-col-5 " >
                  <Card style={{height:"400px"}} >
                <Chart type="doughnut" data={piedata} options={options} height={175} />
                </Card>
                <Button onClick={this.m1}style={buttonstyle2}>What is this chart?</Button>
                <Link to="/UserDashboard">
                    <Button style ={buttonstyle2}>Back</Button>
                    </Link>
                </div>



                <div className="p-col-5   ">
             
                <h5 className="heading2"> {this.state.name} most of your diary entries seem to be {this.state.ed.Sentiment}
                {this.state.ed.Sentiment==="negative" ? <span> here's some articles to lift your spirit</span>: null}
                {this.state.ed.Sentiment==="positive" ? <span> here's some articles to maintain that postivity</span>: null}
                {this.state.ed.Sentiment==="neutrual" ? <span> here's some intrestesting articles on emotional awareness and health</span>: null}
                </h5>
               
                {/* <ListGroup  >
                {this.state.articles.map((entry , i)=>
            
                <ListGroupItem key={i}>
                    <ListGroupItemHeading ><strong>{entry.text}</strong></ListGroupItemHeading>
                <ListGroupItemText><strong><em>"{entry.SubTitle}"</em></strong></ListGroupItemText>
                <Button  >View</Button>
                <Button >Delete</Button>
                </ListGroupItem>
                
                )}
            </ListGroup> */}
          
            <Carousel  value={this.state.articles} itemTemplate={this.articleTemplate} circular={true} numVisible={2} orientation={"horizontal"} numScroll={1}></Carousel>
          
                    

                </div>

                </div>

                <Modal  isOpen={this.state.m1}
                toggle={this.m1}>
                <ModalHeader >Chart Explanation</ModalHeader>
                <ModalBody>
                <h4 className ="info-title">What is Sentiment</h4>

                <p>A sentiment can be defined as an overall feeling or attitude regarding something, As humans, we are able to classify text into positive/negative subconsciously</p>

                <p>As mentioned earlier your diary entries are analysed and we determine if they are positive, neutrual or negative. This chart shows you the amount of entries corresponding to a certain sentiment</p>

              

                </ModalBody>
                <ModalFooter>
                <Button style={buttonstyle2} onClick={this.m1}>Close</Button>
               
                </ModalFooter>
                </Modal>

                <div className ="p-col-4 p-offset-1">
                
                    </div>
            </div>
        )
    }
}

export default EmotionPage
