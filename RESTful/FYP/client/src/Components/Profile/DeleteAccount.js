import React, { Component } from 'react'
import axios from "axios"
import { Redirect   } from "react-router-dom";

import {
    Box,
    Button,
    Grommet,
    List
  } from "grommet";

export class DeleteAccount extends Component {
    state=
    {
        redirect:null,
        email:this.props.email,
        user:{
            firstname:"",
            lastname:"",
            email:"",
            dob:"",
            gender:"",
            height:"",
            weight:"",
            
            phone:""
        }
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
                         { name: `Email : ${user.Email}` },
                         { name: `Phone Number : ${user.Phone}` },
                         { name: `Date of Birth : ${user.DOB}` },
                         { name: `Gender : ${user.Gender}` },
                         
                         { name: `Height : ${user.Height} meters ` },
                         { name: `Weight : ${user.Weight} kg`},
                         
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
        else if(this.state.redirect === true)
        {
            return <Redirect to = "/SignUp"/>
        }

    }
}

export default DeleteAccount
