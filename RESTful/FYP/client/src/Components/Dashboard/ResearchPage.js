import React, { Component } from 'react'
import Navabr from '../General/Navabr';
import {Link} from "react-router-dom";
import axios from "axios"
import {
    Card, CardText, CardBody,
    CardTitle,  ListGroupItem,  ListGroupItemText, 
Nav , NavItem ,NavLink ,TabContent, TabPane,  CardHeader , Button , ListGroup } from 'reactstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Chart} from 'primereact/chart';
import {Carousel} from 'primereact/carousel';


import 'primereact/resources/themes/nova-light/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';

export class ResearchPage extends Component {


    state = {
        tumor: "",
        genes:[],
        email:localStorage.getItem("Email"),
        def:{},
        genes:[],
        chartData:[],
        activeTab: '1'

    }


componentDidMount()
{
    this.getUser()
    this.tumorDefinition()
    this.getGenes()
    this.getGeneData()
}

toggle(tab) {
    if (this.state.activeTab !== tab) {
      this.setState({ activeTab: tab });
    }
  }

getUser = () =>
{
    axios.get(`/Routes/API//users/getUser/${this.state.email}`)
    .then(res => {
        this.setState(
            {
                tumor:res.data.Cancer_Location
            }
        )
        console.log(this.state.tumor)
      })
}

tumorDefinition()
{
    window.setTimeout(()=>{
        axios.get(`/Routes/API//users/tumorDef/${this.state.tumor}`)
        .then(res => {
            this.setState({def:res.data})
        })
    },2000)  
   
}

getGenes()
{
    window.setTimeout(()=>{
        axios.get(`/Routes/API//users/getGenes/${this.state.tumor}`)
        .then(res => {
            this.setState({genes:res.data})
        })
    },3000)  
   
}

getGeneData()
{
    window.setTimeout(()=>{
    axios.get(`/Routes/API//users/getGeneData/${this.state.tumor}`)
    .then(res => this.setState({chartData:res.data}))
},3500)  

}

geneTemplate(gene)
{
    return(
        <div>
            <Card style={{height:"150px" , margin:"5px"}}  className="text-center">
       <CardBody>
         
         <CardText><h1>{gene}</h1></CardText>
         
         <Button href={`https://ghr.nlm.nih.gov/gene/${gene}`} target="_blank" style={ {
               backgroundColor:"#D976ED",
               width:"100%",
               marginTop:"10px",
           
           }}>What is this gene?</Button>
       </CardBody>
     </Card>
        </div>
    )
}



    render() {
        
        const buttonstyle=
        {
            backgroundColor:"#D976ED",
            width:"100%",
            marginTop:"10px",
        
        }

          const WORD_COUNT_KEY = 'value';
const WORD_KEY = 'word';
        const data = this.state.chartData.slice(0,10)
        const symbols = data.map((gene , i)=>
        {
            return gene.Symbol
        })
        const data10 = data.map((gene , i)=>
        {
            
            return gene.Mutations
        })
        const barData={
            labels: symbols,
            datasets:[
                {
                    label:`Amount of samples mutated by this gene`,
                    data:data10,
                    backgroundColor: '#D976ED',
                    borderColor: '#D976ED'
                }
            ]
        }

        const options = {
            title: {
                display: true,
                text:"",
                fontSize: 16
            },
            legend: {
                position: 'bottom'
            },
            animation: {
                duration: 20
            }
        };

        return (
            <div>
                <Navabr/>
                <div className="p-grid">
                <div className="p-col-12 heading1"><h1>Cancer Type : {this.state.tumor} Cancer</h1></div>


                <div className="p-offset-1 p-col-4 " >
                <Card className="text-center">
                <CardHeader style={{backgroundColor:"#D976ED"}}><h3>What Is It?</h3></CardHeader>
                <CardTitle><h3>Explanation Of {this.state.tumor} Cancer</h3></CardTitle>
                <p>
                    {this.state.def.def1}
                </p>

                <p>
                    {this.state.def.def2}
                </p>
                </Card>
                </div>

                <div className="p-offset-1 p-col-5 ">
                
                 <Nav tabs>
          <NavItem>
            <NavLink
              onClick={() => { this.toggle('1'); }}>
              <strong>Most Prominent Genes</strong>
            </NavLink>
          </NavItem>
          <NavItem>
            <NavLink
             
              onClick={() => { this.toggle('2'); }}>
              <strong>All Genes Present in {this.state.tumor} cancer</strong>
            </NavLink>
          </NavItem>
        </Nav>
        <TabContent activeTab={this.state.activeTab}>
          <TabPane tabId="1">
            { this.state.activeTab == 1 ? <div>
                <strong>This chart shows the most recurrently mutated cancer driver genes in {this.state.tumor} Cancer . Each bar of the histogram indicates the amount of samples with the gene mutated.</strong>
                <Chart type="bar" data={barData} options ={options}height={175} />
                </div>: null }
          </TabPane>
          <TabPane tabId="2">
            { this.state.activeTab == 2 ?
             <ListGroup className="diary text-center" >
             {this.state.chartData.map((entry , i)=>
         
             <ListGroupItem  key={i}>
                 
             <ListGroupItemText><strong><em>"{entry.Symbol}"</em></strong></ListGroupItemText>
             <Button href={`https://ghr.nlm.nih.gov/gene/${entry.Symbol}`} target="_blank" style={ {
               backgroundColor:"#D976ED",
               width:"100%",
               marginTop:"10px",
           
           }}>What is this gene?</Button>
             </ListGroupItem>
             
             )}
         </ListGroup>
    
    
             :null }
          </TabPane>
        </TabContent>
                    
                </div >

                <div className="p-offset-1 p-col-3 " >
                    
                <Card style={{height:"260px" , margin:"5px"}}>
                <CardHeader style={{backgroundColor:"#D976ED"}}><h5>Top 5 Driver Genes For {this.state.tumor} Cancer </h5></CardHeader>
                <Carousel  value={this.state.genes} itemTemplate={this.geneTemplate} circular={true} numVisible={1} orientation={"horizontal"} numScroll={1}></Carousel>
                </Card>
                <Link to="/UserDashboard">
                    <Button style ={buttonstyle}>Back</Button>
                    </Link>
                </div>
                
                </div>
                </div>
            
        )
    }
}

export default ResearchPage
