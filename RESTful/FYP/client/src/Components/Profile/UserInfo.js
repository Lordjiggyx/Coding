import React, { Component } from 'react'
import axios from "axios"


import {
    Box,
    Grommet
    ,List
  } from "grommet";





export class UserInfo extends Component {


    state=
    {
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



    render() {
        const user = this.state.user
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

               </Grommet>
                
        )
    }
}

export default UserInfo
