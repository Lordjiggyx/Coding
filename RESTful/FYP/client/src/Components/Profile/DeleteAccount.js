import React, { Component } from 'react'
import axios from "axios"
import { Redirect   } from "react-router-dom";
import { BrowserHistory } from "react-router";

import { Close, Send, User , FormNext , } from "grommet-icons";
import {
    Box,
    Button,
    CheckBox,
    Grommet,
    Form,
    FormField,
    RadioButtonGroup,
    RangeInput,
    Select,
    TextArea
    ,TextInput
    ,List
  } from "grommet";

export class DeleteAccount extends Component {
    state=
    {
        redirect:null,
        email:this.props.email,
        user:{
            firstname:"",
            lastname:"",
            username:"",
            email:"",
            dob:"",
            gender:"",
            height:"",
            weight:""
        }
    }

componentDidMount()
{
    
    axios.get(`/Routes/API//users/getUser/${this.state.email}`)
    .then(res => {
        this.setState(
            {
                user:res.data
                // {
                //     firstname:res.data.FirstName,
                //     lastname:res.data.LastName,
                //     dob:res.data.DOB,
                //     height:res.data.Height,
                //     weight:res.data.Weight,
                //     gender:res.data.Gender,
                //     email:res.data.Email,
                //     username:res.data.UserName
                // }
            }
        )
        console.log(this.state.user)
      })
}

DeleteAccount  = async e =>
{


    axios.get(`/Routes/API//users/delete/${this.state.email}`)
    .then(res=>
        {
            console.log(res.data)
        })

        this.setState({redirect:true})
        localStorage.removeItem("Email");  
    
}



    render() {
        const user = this.state.user

        if(this.state.redirect == null)
        {
            return (
                
                <Grommet>
                    <div className="center">
                     <h1>Account Information</h1>
                    <h4>This is the information regading your account details</h4>
                    </div>
 
                    <Box fill alignContent="start" justify="start">
                        <div className="normal_list">
                    <List
                     data={[
                         { name: `Name : ${user.FirstName}  ${user.LastName} `},
                         { name: `Username : ${user.UserName}`},
                         { name: `Email : ${user.Email}` },
                         { name: `Date of Birth : ${user.DOB}` },
                         { name: `Gender : ${user.Gender}` },
                         // { name: 'Country : ', info: country },
                         { name: `Height : ${user.Height} meters ` },
                         { name: `Weight : ${user.Weight} kg`},
                         // { name: 'Activeness : ', info : active },
                     ]}
                     />
                     </div>
 
                  
                    </Box>                   
                    <Box align="center" pad="small">
                     <Button 
                     onClick={this.DeleteAccount}
                     label="Delete Account" />
                     </Box>
                </Grommet>
                 
         )
        }
        else if(this.state.redirect == true)
        {
            return <Redirect to = "/Login"/>
        }

    }
}

export default DeleteAccount
