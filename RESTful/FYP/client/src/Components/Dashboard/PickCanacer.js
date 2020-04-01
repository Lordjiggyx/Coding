import React, { Component } from 'react'
import Tree from 'react-d3-tree';
import "../../CSS/DashboardComponents/Dashboard.css"
import { useInvertedScale } from 'framer-motion';
import { HandleInteractionKind } from '@blueprintjs/core';
import { Redirect   } from "react-router-dom";



export class PickCanacer extends Component {


  _isMounted = false;
  
  state=
  {
    email:localStorage.getItem("Email"),
    redirect:null,
  }
  
  cancerPick= async (nodeData, evt)=>
  {
    evt.preventDefault();

    if(nodeData.depth == 2)
    {
      console.log(nodeData.parent.name)
      console.log(nodeData.name)

      // window.confirm("Are you sure this is your cancer type")

      if(window.confirm("Are your sure this is your cancer type "))
      {

        const cancerInfo=
        {
          location:nodeData.parent.name,
          type:nodeData.name
        }

        const response = await fetch(`/Routes/API//users/setCancer/${this.state.email}`, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(cancerInfo)
        },
        this.setState({redirect:true}));
       
      }
      
      
    }

  }

 

  constructor(props) {
    super(props);
    this.cancerPick = this.cancerPick.bind(this);
  } 


    render() {



        const TreeData= [
            {
              name: 'Tissue',
             
              children: [
                {
                  name: 'Breast',
                  children:[
                      {name:"Metastatic"},
                      {name:"Ductal Carcinoma"},
                      {name:"Invasive Ductal Carcinoma"},
                      {name:"Triple Negative"},
                      {name:"Male Breast Cancer"},

                    ]
                },
                {
                  name: 'Bowel',
                  children:[
                    {name:"Colorectal adenocarcinoma"},
                    {name:"Gastrointestinal carcinoid tumors"},
                    {name:"Primary colorectal lymphomas"},
                    {name:"Gastrointestinal stromal tumors"},
                    {name:"Leiomyosarcomas "},

                  ]
                },
                {
                    name: 'Prostate',
                    children:[
                        {name:"Acinar adenocarcinoma "},
                        {name:"Ductal adenocarcinoma "},
                        {name:"Squamous cell cancer  "},
                        {name:"Small cell prostate cancer "},
                        {name:"Transitional cell cancer "},
    
                      ]
                },
                {
                    name: 'Skin',
                    children:[
                        {name:"basal cell carcinoma"},
                        {name:"squamous cell carcinoma"},
                        {name:"Melanoma"},
                        {name:"Actinic Keratoses"},
                        {name:"Merkel cell carcinoma"},
    
                      ]
                },
                {
                    name: 'Lung',
                    children:[
                        {name:"Small cell lung cancer"},
                        {name:"NSCLC Adenocarcinoma "},
                        {name:"NSCLC Squamous cell cancer  "},
                        {name:"NSCLC Large cell carcinoma "},
    
                      ]
                },
              ],
            },
          ];

        const trans = {x:755 , y:20 }
        const node ={x:200 , y:100} 
        

        const textSize={
           transform:"scale(0.8)"
           ,x:15,
           y:5
        }

        
        const styles =
        {
            links:{},
            nodes: {
              node: {
                circle:{fill :"#D976ED"},
                name: {},
                attributes: {},
                overflow:"scroll"
              },
              leafNode: {
                circle: {fill:"#EFC4F7"},
                name: {},
                attributes: {},
              },
            },
          }
          const d = this.state.depth
          const sep={siblings: 0.85,}

          
      if(this.state.redirect == null)
      {
        return (
          <div>
              {/* <h1>Pick Cancer</h1>
              <br/> */}
              <div className= "centerdash">
              <h1>Pick Cancer</h1>
              <h3>Explore the branches and select the location of your tumor and the type of Cancer</h3>
              <Tree 
              data={TreeData}
              orientation="vertical"
              translate={trans}
              initialDepth="0"
              styles={styles}
              nodeSize={node}
              textLayout={textSize} 
              separation={sep}
              onClick={this.cancerPick} 
              shouldCollapseNeighborNodes="true"            />
              </div>
          </div>
      )
      }
      else if(this.state.redirect == true)
      {
        return <Redirect to = "/UserDashboard"/>
      }


        
    }
}

export default PickCanacer
