import {GET_USERS} from "../types/types"

const userReducer = function(state={} , actions)
{
    switch(actions.type)
    {
        case GET_USERS:
            return  actions.payload
            
        default:
            return state
    }
}

export default userReducer