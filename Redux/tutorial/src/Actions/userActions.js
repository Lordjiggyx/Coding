import {GET_USERS} from "../types/types"

function fetch_users(dispatch)
{
    fetch("https://jsonplaceholder.typicode.com/users")
    .then(response => response.json())
    .then(res => dispatch({
        type:GET_USERS,
        payload:res
    }))
}
export default fetch_users