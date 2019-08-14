import React, { Component } from 'react'
import {
    Button,
    Modal,
    ModalHeader,
    ModalBody,
    Form,
    FormGroup,
    Label,
    Input
  } from 'reactstrap';

import { connect } from 'react-redux';
import { addItems } from "../actions/itemActions"
//import uuid from "uuid"
class ItemModal extends Component {
   
    //Setting the state of our component 
    state = {
        modal: false,
        name : " "
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

       //Creating a new Item
       const newItem = 
       {
        name:this.state.name
       }

       //add item via addItems action
       this.props.addItems(newItem)
       //Closing the modal
       this.toggle()
   }
   
   
   
   
   
    render() {
        return (
            <div>
                <Button 
                color = "dark"
                style={{marginBottom:"2rem"}}
                onClick ={this.toggle}
                >
                Add Item
                </Button>

                <Modal
                isOpen = {this.state.modal}
                toggle = {this.toggle}
                >
                    <ModalHeader toggle = {this.toggle}>
                        Add to Shopping list
                    </ModalHeader>

                    <ModalBody>
                        <Form onSubmit = {this.onSubmit}>
                            <FormGroup>
                                <Label for = "item">
                                    Name
                                </Label>
                                <Input
                                type = "text"
                                name = "name"
                                id = "item"
                                placeholder = "Enter Item"
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
    item: state.item
  });


export default connect(
    mapStateToProps,
    { addItems }
  )(ItemModal);