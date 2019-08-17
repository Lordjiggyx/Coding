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

//Bringing in Login action from the the auth actions file
import {login} from "../../actions/authActions"

//Bringing in clearerror action from the the error actions file
import {clearErrors} from "../../actions/errorActions"

//import uuid from "uuid"
class Login extends Component {

    
   
    //Setting the state of our component 
    state = {
        modal: false,
        email: " ",
        password: " ",
        msg:null
    }

    //Setting the prop types
    static propTypes = 
    {
        isAuthenticated:PropTypes.bool,
        login: PropTypes.func.isRequired,
        error: PropTypes.object.isRequired,
        clearErrors: PropTypes.func.isRequired
    }

    //If there is a cahnge and it is an error we call componentdidupdate
    componentDidUpdate(prevProps) {
        //This pulls the error from props
        const { error  , isAuthenticated} = this.props
        //If the  current state of error is not the same as the previous state of errpr
        if (error !== prevProps.error) {
          // Check for error id and if it matches LOGIN Fail we send the error message
          if (error.id === 'LOGIN_FAIL')
           {
            this.setState({ msg: error.msg.msg })
          }
          //If it is not LOGIN fail we leave the message null
           else
           {
            this.setState({ msg: null })
          }
        }

        //Checking that the modal is open
        if(this.state.modal)
        {
            //Check that were authenticated and if we are the modal will be closed
            if(isAuthenticated)
            {
                this.toggle()
            }
        }
    }
    
   
   //Toggle method for the modal 
   
   toggle = () =>
   {
    //Clearing the errors once modal has been closed
    this.props.clearErrors()
    //Setting the state of the modal to be the opposite of it's current state
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

       //Get email and password from the state
       const {email , password} = this.state

       //Create a user object to submit the email and password
        const user = {email , password}

       //Then we will call the login action and pass in the user
        this.props.login(user)
     
   }
   
   
   
   
   
    render() {
        return (
            <div>
               <NavLink onClick={this.toggle} href = "#">
                    Login
               </NavLink>

                <Modal
                isOpen = {this.state.modal}
                toggle = {this.toggle}
                >
                    <ModalHeader toggle = {this.toggle}>
                       Login
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
                                Login
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
    { login , clearErrors}
  )(Login);