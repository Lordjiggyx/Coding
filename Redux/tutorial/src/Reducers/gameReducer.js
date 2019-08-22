import {UPDATE_GAME} from "../types/types"


//Reducer function
const gameReducer = function(state = {}, actions)
{
    //Use of swirch statemnet is better 
    //as we can check just on the action type and do it for multiple types
        switch(actions.type)
        {
            case UPDATE_GAME:
                return {
                    name: actions.payload
                }
            default:
                return state
        }
    
}
export default gameReducer