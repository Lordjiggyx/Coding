//importing the update state action type from types

import {UPDATE_STATE} from "../types/types.js"

//Reducer function
const personReducer = function(state = {} , actions)
{

     //Use of swirch statemnet is better 
    //as we can check just on the action type and do it for multiple types
    switch(actions.type)
    {
        case UPDATE_STATE:
            //only changes the name parameter 
            return Object.assign({} , state , {name:actions.payload})
        default:
            return state
    }
}

export default personReducer