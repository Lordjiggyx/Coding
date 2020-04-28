import React, { Component } from 'react'
import {
    Box,
    Button,
    
    Grommet,
    Form,
    FormField,
    RadioButtonGroup,
    TextInput,
    MaskedInput
  } from "grommet";
  import axios from "axios"


export class UpdateInfo extends Component {

    state=
    {
        findemail:this.props.email,
            firstname:"",
            lastname:"",
            email:"",
            dob:"",
            gender:"",
            height:"",
            weight:"",
            password:"",
            phone:""
        
    }


    update = async e =>
    {
        e.preventDefault();

        const user =
        {
            firstname:this.state.firstname,
            lastname:this.state.lastname,
            username:this.state.username,
            email:this.state.email,
            dob:this.state.dob,
            gender:this.state.gender,
            height:this.state.height,
            weight:this.state.weight,
            password:this.state.password,
            phone:this.state.phone

        }

        const response = await fetch(`/Routes/API//users/update/${this.state.findemail}`, {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify(user)
          });
          console.log(response.text())
    }

    handleChange = input => e =>
    {
        this.setState({
            //take in the input and then set it to the value of the satet being changed
            [input]:e.target.value
        })
    }

    componentDidMount()
    {
        axios.get(`/Routes/API//users/getUser/${this.state.findemail}`)
        .then(res => {
            this.setState(
                {
                    
                        firstname:res.data.FirstName,
                        lastname:res.data.LastName,
                        dob:res.data.DOB,
                        height:res.data.Height,
                        weight:res.data.Weight,
                        gender:res.data.Gender,
                        email:res.data.Email,
                         password:res.data.Password,
                        phone:res.data.Phone

                }
            )
          })
    }

    render() {
        return (
            

           

            <div>
                                          <Grommet>
                               <Box fill align="center" justify="center">
                               <h1>Update Details</h1>
                               
                               <div className="Body">
                               <Box width="medium">
                                   <Form>
                                   <FormField label="First Name"name="firstname" >
                                    <TextInput
                                    onChange={this.handleChange("firstname")} value={this.state.firstname}
                                    />
                                   </FormField>

                                   <FormField label="Last Name"name="lastname" >
                                    <TextInput
                                    onChange={this.handleChange("lastname")} value={this.state.lastname}
                                    />
                                   </FormField>


                                   <FormField label="Email"name="email" >
                                    <TextInput
                                    onChange={this.handleChange("email")} value={this.state.email}
                                    />
                                   </FormField>

                                   <FormField label="Phone Number"name="phone" >
                                    <TextInput
                                    onChange={this.handleChange("phone")} value={this.state.phone}
                                    />
                                   </FormField>

                                   <FormField label="Password"name="password" >
                                    <TextInput
                                     type="password" 
                                    onChange={this.handleChange("password")} value={this.state.password}
                                    />
                                   </FormField>


                                        <FormField label="Gender" >
                            <RadioButtonGroup
                            name="radio"
                            options={[
                                { label: "Male", value: "Male" },
                                { label: "Female", value: "Female" }
                                
                            ]}

                            onChange = {this.handleChange("gender")}
                            
                            />                      
                            </FormField>

                            <FormField label="Date of Birth" name="Dob">
                            <DateMaskedInput
                             handleChange = {this.handleChange}
                             date = {this.state.dob}
                            />
                            </FormField>

                            <FormField label="Weight"name="weight" >
                            <TextInput
                            onChange={this.handleChange("weight")} value={this.state.weight}
                            />
                            </FormField>

                            <FormField label="Height"name="height" >
                            <TextInput
                            onChange={this.handleChange("height")} value={this.state.height}
                            />
                            </FormField>
            
                    
                                   </Form>
                               </Box>

                                    <Box align="center" pad="small">
                                    
                                    <Button 
                                    onClick={this.update}
                                    label="Update Account" />
                                    </Box>
                               </div>
                               </Box>
                           </Grommet>
                
            </div>


        )
    }
}

export class DateMaskedInput extends Component {

    state = 
    {
      value:" "
    }
    
      render() {
        const date = this.props.date
        const handleChange = this.props.handleChange
        const daysInMonth = month => new Date(2019, month, 0).getDate();
    
    
        return (
          <Grommet >
          <Box fill align="center" justify="start" pad="large">
            <Box width="medium">
              <MaskedInput
                mask={[
                  {
                    length: [1, 2],
                    options: Array.from({ length: 12 }, (v, k) => k + 1),
                    regexp: /^1[0,1-2]$|^0?[1-9]$|^0$/,
                    placeholder: "mm"
                  },
                  { fixed: "/" },
                  {
                    length: [1, 2],
                    options: Array.from(
                      {
                        length: daysInMonth(parseInt(this.state.value.split("/")[0], 10))
                      },
                      (v, k) => k + 1
                    ),
                    regexp: /^[1-2][0-9]$|^3[0-1]$|^0?[1-9]$|^0$/,
                    placeholder: "dd"
                  },
                  { fixed: "/" },
                  {
                    length: 4,
                    options: Array.from({ length: 100 }, (v, k) => 2019 - k),
                    regexp: /^[1-2]$|^19$|^20$|^19[0-9]$|^20[0-9]$|^19[0-9][0-9]$|^20[0-9][0-9]$/,
                    placeholder: "yyyy"
                  }
                ]}
                value={date}
                 onChange={handleChange("dob")}
              />
            </Box>
          </Box>
        </Grommet>
        )
      }
    }

export default UpdateInfo
