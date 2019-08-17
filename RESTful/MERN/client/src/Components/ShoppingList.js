//Importing react and the components
import React , {Component} from "react"

//Reactstrap components
import {
    Container,
    ListGroup,
    ListGroupItem,
    Button
} from "reactstrap"

//React transitions 
import { CSSTransition , TransitionGroup} from "react-transition-group"

//UUID
//import uuid from "uuid"

//Bringing in redux into the compoenentr
import {connect} from "react-redux"


//Bringing in actions from itemactions file
import {getItems , delItems} from "../actions/itemActions"


//Importing our prop type 
import PropTypes from "prop-types"

class ShoppingList extends Component
{

//This is for when thw component is rendered it grabs all items 
componentDidMount()
{
this.props.getItems()
}

//This function is for the click when an item is mean tot be deleted
onDeleteClick = (id) =>
{
    this.props.delItems(id)
}


    // constructor()
    // {
    //     super()
    // //     this.state =
    // // {
    // //      items:
    // //      [
    // //          {id:uuid() , name: "Chicken"},
    // //          {id:uuid() , name: "Pudding"},
    // //          {id:uuid() , name: "Rice"},
    // //          {id:uuid() , name: "Chicken"}
    // //      ]
    // // }
    // }


    render()
    {
        //Destrucuring items from this.state so we dont have to say this.state.items

        const {items} = this.props.item

        return(
            //Place the items in a container 
            <Container>
                {/**Button to add the item we add style and colouring */}
                {/* <Button 
                color = "dark"
                style={{marginBottom:"2rem"}}
                //The on click will be an arrow function 
                //At the moment we will just use a prmpt to get the name of the object
                onClick = {()=>
                {
                    const name = prompt("Enter Item Name...")
                    //If the nanme is filled then we will set the state , so we will taje the current state and use the spread operator to add a new objeect taking in the name passed in from the prompt
                    if(name)
                    {
                        this.setState(state =>
                        (
                            {
                                items:
                                //This is the spread operator which takes the array of items in the state and then adds on the new object 
                                [...state.items,
                                {id:uuid() , name:name}
                                ]
                            }
                        ))
                    }
                }}>
                        Add Item
                </Button> */}
                <ListGroup>
                    <TransitionGroup className= "shopping-list">
                        {/*De-structuring the itma object and grabbing the name and id values */}
                        {items.map(({_id , name})=> (
                        //The css transtion needs a key time out and classnames values for the attributes
                        <CSSTransition key = {_id} timeout= {500} classNames= "fade">
                        {/*The list group item will just display the name of the item  */}
                        <ListGroupItem>
                        {/**The button for delete an item */}
                        {this.props.isAuthenticated ? (
                            <Button
                            className='remove-btn'
                            color='danger'
                            size='sm'
                            onClick={this.onDeleteClick.bind(this, _id)}
                            >
                            &times;
                            </Button>
                        ) : null}
                             {name}
                        </ListGroupItem>
                        
                        </CSSTransition>
                        ))}
                    </TransitionGroup>
                </ListGroup>
            </Container>
        )
    }
}


//MapStatToProps function takes satet from reducer and allows us to access from this.props
const mapStateToProps = (state) =>
({
    item:state.item,
    isAuthenticated:state.auth.isAuthenticated
})

//Mapping getItems and item to our props
ShoppingList.propTypes = 
{
    getItems: PropTypes.func.isRequired,
    //This is our state which is an obejct
    item: PropTypes.object.isRequired,
    isAuthenticated: PropTypes.bool
}


//We need to export connect eith the function mapsToStateProps along with wahetever action we are calling and then also export the shoppinglist calss
export default connect(mapStateToProps , {getItems , delItems})(ShoppingList)