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
import uuid from "uuid"

class ShoppingList extends Component
{

    constructor()
    {
        super()
        this.state =
    {
         items:
         [
             {id:uuid() , name: "Chicken"},
             {id:uuid() , name: "Pudding"},
             {id:uuid() , name: "Rice"},
             {id:uuid() , name: "Chicken"}
         ]
    }
    }


    render()
    {
        //Destrucuring items from this.state so we dont have to say this.state.items

        const {items} = this.state

        return(
            <Container>
                <Button 
                color = "dark"
                style={{marginBottom:"2rem"}}
                onClick = {()=>
                {
                    const name = prompt("enter Item")
                    if(name)
                    {
                        this.setState(state =>
                        (
                            {
                                items:
                                [...state.items,
                                {id:uuid() , name:name}
                                ]
                            }
                        ))
                    }
                }}>
                        Add Item
                </Button>
            </Container>
        )
    }
}

export default ShoppingList