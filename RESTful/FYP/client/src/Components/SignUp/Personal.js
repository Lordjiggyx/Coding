import React, { Component } from 'react'
import {Calendar} from 'primereact/calendar';
import 'primereact/resources/primereact.min.css';
import Header from "../Parallax/Header"
import Navabr from '../General/Navabr';
import { motion } from "framer-motion"

// import {Button , InputGroup , Radio ,RadioGroup , Slider , Label , Icon , FormGroup} from "@blueprintjs/core";


import { Close, Send, User , FormNext ,FormPrevious } from "grommet-icons";
import {
    Box,
    Button,
    CheckBox,
    Grommet,
    Form,
    FormField,
    MaskedInput ,
    RadioButtonGroup,
    RangeInput,
    Select,
    TextArea
    ,TextInput
    
  } from "grommet";

export class Personal extends Component {
    continue = e =>
    {
        //Prevent default behaviour of event
        e.preventDefault();
        //calls the next method on the userfrom component
        this.props.next();
    }
    
    back = e =>
{
    //Prevent default behaviour of event
    e.preventDefault();
    //calls the next method on the userfrom component
    this.props.previous();
  
}



        render() {
            
            var countries = ["Afghanistan","Albania","Algeria","Andorra","Angola","Anguilla","Antigua & Barbuda","Argentina","Armenia","Aruba","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bermuda","Bhutan","Bolivia","Bosnia &amp; Herzegovina","Botswana","Brazil","British Virgin Islands","Brunei","Bulgaria","Burkina Faso","Burundi","Cambodia","Cameroon","Cape Verde","Cayman Islands","Chad","Chile","China","Colombia","Congo","Cook Islands","Costa Rica","Cote D Ivoire","Croatia","Cruise Ship","Cuba","Cyprus","Czech Republic","Denmark","Djibouti","Dominica","Dominican Republic","Ecuador","Egypt","El Salvador","Equatorial Guinea","Estonia","Ethiopia","Falkland Islands","Faroe Islands","Fiji","Finland","France","French Polynesia","French West Indies","Gabon","Gambia","Georgia","Germany","Ghana","Gibraltar","Greece","Greenland","Grenada","Guam","Guatemala","Guernsey","Guinea","Guinea Bissau","Guyana","Haiti","Honduras","Hong Kong","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Isle of Man","Israel","Italy","Jamaica","Japan","Jersey","Jordan","Kazakhstan","Kenya","Kuwait","Kyrgyz Republic","Laos","Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macau","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Mauritania","Mauritius","Mexico","Moldova","Monaco","Mongolia","Montenegro","Montserrat","Morocco","Mozambique","Namibia","Nepal","Netherlands","Netherlands Antilles","New Caledonia","New Zealand","Nicaragua","Niger","Nigeria","Norway","Oman","Pakistan","Palestine","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland","Portugal","Puerto Rico","Qatar","Reunion","Romania","Russia","Rwanda","Saint Pierre &amp; Miquelon","Samoa","San Marino","Satellite","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","South Africa","South Korea","Spain","Sri Lanka","St Kitts &amp; Nevis","St Lucia","St Vincent","St. Lucia","Sudan","Suriname","Swaziland","Sweden","Switzerland","Syria","Taiwan","Tajikistan","Tanzania","Thailand","Timor L'Este","Togo","Tonga","Trinidad &amp; Tobago","Tunisia","Turkey","Turkmenistan","Turks &amp; Caicos","Uganda","Ukraine","United Arab Emirates","United Kingdom","Uruguay","Uzbekistan","Venezuela","Vietnam","Virgin Islands (US)","Yemen","Zambia","Zimbabwe"];

    
            //Get the values from the user from
            const {values , handleChange } = this.props;
    
            // //Icons
            // const at = <Icon icon="envelope"  size={Icon.SIZE_STANDARD}/>
            // const person = <Icon icon="person"  size={Icon.SIZE_STANDARD}/>
            // const eye = <Icon icon="eye-open"  size={Icon.SIZE_STANDARD}/>
            // const lock = <Icon icon="lock"  size={Icon.SIZE_STANDARD}/>
    
            
        const fade_in=
        {
            hidden:{ opacity:0},
            visible:{opacity:1},
            
        }
    
            return (
                <div>
                   <Navabr/>
                   <motion.div
                    initial="hidden"
                    animate="visible"
                    variants={fade_in}
                    transition={{duration:1.5}}>
                   >
                   <Grommet>
                   <Box fill align="center" justify="center">
                    
                   <h1>Personal Information</h1>
                   <div className="Body">
                   <Box width="medium">
                       <Form>
                            <FormField
                            label="First name"
                            name="firstname"
                            required
                            onChange = {handleChange("firstName")}
                            />

                            <FormField label="Last Name" name="lastName"  onChange = {handleChange("lastName")}/>

                            <FormField label="Gender" >
                            <RadioButtonGroup
                            
          name="radio"
          options={[
            { label: "Male", value: "Male" },
            { label: "Female", value: "Female" }
            
          ]}
          // value={value}
          // onChange={event => setValue(event.target.value)}
          // {...props}
          onChange = {handleChange("gender")}/>                      
                            </FormField>

                            <FormField label="Date of Birth" name="Dob">
                            {/* <DateMaskedInput
                            handleChange = {handleChange}
                            /> */}

                            {/* <Calendar  onChange={handleChange("DOB")} /> */}
                            <input type="date" id="birthday" onChange={handleChange("DOB")}></input>
                            </FormField>

                            {/* <FormField label="Country" name="Country">
                                <Select
                                placeholder="Select Country of Residence"
                                options={countries}
                                onChange = {handleChange("country")}/>
                            </FormField> */}

                           

                            <div className = "next">
                            <Button plain icon={<FormNext />} onClick={this.continue} />
                        </div>
                        <div className = "back">
                            <Button plain icon={<FormPrevious />} onClick={this.back} />
                        </div>
        
                       </Form>
                     
                   </Box>
                   </div>
                   </Box>
               </Grommet>


                   </motion.div>
  
                   {/* <h1>Enter Personal Details</h1>
               
               <FormGroup
               labelFor= "first_input"
               label = "First Name">
               <InputGroup
               id ="first_input"
               placeholder = "Enter First Name.."
               leftIcon={person}
               onChange = {handleChange("firstName")}
               defaultValue={values.firstName}
               />
               </FormGroup>
    
                   <hr/>
    
                   <FormGroup
                   labelFor= "username_input"
                   label = "Username">
                   <InputGroup
                   id ="username_input"
                   placeholder = "Enter Username.."
                   leftIcon={person}
                   onChange = {handleChange("userName")}
                   defaultValue={values.userName}
                   />
                   </FormGroup>
    
                   <hr/>
    
                   <FormGroup
                   labelFor= "password_input"
                   label = "Password">
                   <InputGroup
                   id ="password_input"
                   placeholder = "Enter Password.."
                   leftIcon={eye}
                   onChange = {handleChange("password")}
                   defaultValue={values.password}
                   />
                   </FormGroup>
    
                   <hr/>
    
                   <FormGroup
                   labelFor= "Confirm_input"
                   label = "Password Confirmation">
                   <InputGroup
                   id ="Confirm_input"
                   placeholder = "Confirm Pssword.."
                   leftIcon={eye}
                   onChange = {handleChange("password")}
                   defaultValue={values.password}
                   />
                   </FormGroup>
    
                   <hr/>
                   
                   <Button rightIcon="arrow-right" onClick={this.continue}>Next</Button>
                   <Button rightIcon="arrow-left" onClick={this.back}>Next</Button> */}
    
                 
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
            value={this.state.value}
            onChange={handleChange("DOB")}
          />
        </Box>
      </Box>
    </Grommet>
    )
  }
}




export default Personal
