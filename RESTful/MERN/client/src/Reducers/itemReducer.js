//import uuid from "uuid"
import {GET_ITEMS ,ADD_ITEMS , DEL_ITEMS , ITEMS_LOADING} from "../actions/types"


//Creatinhg our initial state 
const initialState= 
{
    items:
         [
             ///******Static Data not neccessary *********/
            //  {id:uuid() , name: "Chicken"},
            //  {id:uuid() , name: "Pudding"},
            //  {id:uuid() , name: "Rice"},
            //  {id:uuid() , name: "Chicken"}
         ],
    isloading:false 
    
}

//This fucntion sets the state that it takes in to the atate current state
export default function (state =initialState , action)
{
    //switch statement to heck for the action tyupe
    switch(action.type)
    {
        case GET_ITEMS:
            return {
                //Using spread operator to return the state which is the list of items
                ...state,
                //Then we want to get the items array and set it to be the data coming from actons.payload
                items:action.payload,
                //Now that we have fetched the data we will set the loading value to be false 
                isloading:false
            };
            case DEL_ITEMS:
                    return {
                        //we use spread to get current state 
                        ...state,
                        //then we set the items in the state to be a new filtered array were the item ID does not equal the id being passed in from the action.payload value 
                        items: state.items.filter(item => item._id !== action.payload )
                    }
            case ADD_ITEMS:
                    return {
                        //we use spread to get current state 
                        ...state,
                        //We then set the items in our state to be the new item thata is obtained from the action.payload and then using the spread operator we can just add the array of items to this 
                        items: [action.payload , ...state.items]
                    }
        
            case ITEMS_LOADING:
                    return {
                        //we use spread to get current state 
                        ...state,
                        //Then we can just set the state of the loading value to eqaul true 
                        loading:true
                    }
        

        default:
            return state;
    }
}