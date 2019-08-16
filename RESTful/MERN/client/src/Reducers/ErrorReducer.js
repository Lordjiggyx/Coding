import {GET_ERRORS , CLEAR_ERRORS} from "../actions/types"


//Creating our state for the reducer
const initialState =
{
    msg:{},
    status:null,
    id:null
}

//This fucntion sets the state that it takes in to the atate current state
export default function (state =initialState , action)
{
    switch(action.type)
    {
        case GET_ERRORS:
            return{
                //This will be a msg from the action payload which will be an object with a message from the server
                msg:action.payload.msg,
                //Also come from the payload
                status:action.payload.status,
                //Also from payload
                id:action.payload.id
            }
        case CLEAR_ERRORS:
            return{
                //Sets the message object to an empty object
                msg:{},
                //makes status null
                status:null,
                //makes id null
                id:null
            }
        default:
            return state
    }
}