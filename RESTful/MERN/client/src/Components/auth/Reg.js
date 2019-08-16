import React, { Component } from 'react'
import {
    Button,
    Modal,
    ModalHeader,
    ModalBody,
    Form,
    FormGroup,
    Label,
    Input,
    NavLink,
    Alert
  } from 'reactstrap';

import { connect } from 'react-redux';

//Bring in proptypes to set proptypes
import PropTypes from "prop-types"

//Bringing in register action from the the auth actions file
import {register} from "../../actions/authActions"

//import uuid from "uuid"
class Reg extends Component {

    
   
    //Setting the state of our component 
    state = {
        modal: false,
        name : " ",
        email: " ",
        password: " ",
        msg:null
    }

    //Setting the prop types
    static propTypes = 
    {
        isAuthenticated:PropTypes.bool,
        register: PropTypes.func.isRequired,
        error: PropTypes.object.isRequired
    }

    //If there is a cahnge and it is an error we call componentdidupdate
    componentDidUpdate(prevProps) {
        //This pulls the error from props
        const { error } = this.props
        //If the  current state of error is not the same as the previous state of errpr
        if (error !== prevProps.error) {
          // Check for error id and if it matches Register Fail we send the error message
          if (error.id === 'REGISTER_FAIL')
           {
            this.setState({ msg: error.msg.msg })
          }
          //If it is not register fail we leave the message null
           else
           {
            this.setState({ msg: null })
          }
        }
    }
    
   
   //Toggle method for the modal 
   
   toggle = () =>
   {
       this.setState(
           {
               modal: !this.state.modal
           })
   }
   

   //method for when theere is a chnage in input for the input box
   onChange = (e) =>
   {
       this.setState(
           {
              [ e.target.name]:e.target.value
           }
       )
   }
   
   
   //on submit function for when a value is entered

   onSubmit = (e) =>
   {
       e.preventDefault()

      //Getting naem email and password from state 
      const {name , email,password} = this.state

      //Creating new user 
      const newUser = {
          name,
          email,
          password
      }

      //Register user
      this.props.register(newUser)

       //Closing the modal
       //this.toggle()
   }
   
   
   
   
   
    render() {
        return (
            <div>
               <NavLink onClick={this.toggle} href = "#">
                    Register
               </NavLink>

                <Modal
                isOpen = {this.state.modal}
                toggle = {this.toggle}
                >
                    <ModalHeader toggle = {this.toggle}>
                        Add to Shopping list
                    </ModalHeader>

                    <ModalBody>
                        {/**Ternary operator if there is a message in the state place it in an alert tag and show the msg or else make it null */}
                        {this.state.msg ?
                        (
                            <Alert color= "danger">
                              {this.state.msg}
                            </Alert>
                        )
                        :
                        null}
                        <Form onSubmit = {this.onSubmit}>
                            <FormGroup>
                                <Label for = "name">
                                    Name
                                </Label>
                                <Input
                                type = "text"
                                name = "name"
                                id = "name"
                                placeholder = "Enter Your Name"
                                onChange = {this.onChange}
                                />

                                <Label for = "email">
                                    Email
                                </Label>
                                <Input
                                type = "email"
                                name = "email"
                                id = "email"
                                placeholder = "Enter Your Email"
                                onChange = {this.onChange}
                                />

                                <Label for = "password">
                                    Password
                                </Label>
                                <Input
                                type = "password"
                                name = "password"
                                id = "password"
                                placeholder = "Enter Your Password"
                                onChange = {this.onChange}
                                />
                                
                                <Button
                                 color = "dark"
                                 style={{marginTop:"1rem"}}
                                 block
                                 >
                                Submit
                                </Button>
                            </FormGroup>
                        </Form>
                    </ModalBody>


                </Modal>
            </div>
        )
    }
}
const mapStateToProps = state => ({
    //These values are being taken from the rootreducer so refer to them exact the mistake you mad was that you put a "e" intead of "E" when typing error
    isAuthenticated: state.auth.isAuthenticated,
    error: state.Error
  });


export default connect(
    mapStateToProps,
    { register}
  )(Reg);