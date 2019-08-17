
//Imporing our actions 
import {GET_ITEMS ,ADD_ITEMS , DEL_ITEMS  , ITEMS_LOADING} from "./types"

//Importing axios
import axios from "axios"


//Importing tokenconfig which is the helper function in the auth.js which gets the token
import {tokenConfig} from "./authActions"

//Be abvle to access the error state 
import {returnErrors} from "./errorActions"

//Exporting our function which will return the type type to the reducer

//Function for grabbing items
export const getItems = ()=> dispatch =>
{
    //calling the setLoading method as the loading wull be set to true while fetching data
   dispatch(setLoading())

   //making our axios get request  to our end point
    axios.get("/routes/api/items")
    //return a promise which returns a response object and then we will return dispatch 
    .then(res => 
        //Inside dispatch we will set the type to be GET_ITMES and then set the payload to be res.data which is th data given to us from the backend 
        dispatch(
            {
                type:GET_ITEMS,
                payload: res.data
            }
        )
        )
        .catch(err => {
            dispatch(returnErrors(err.response.data, err.response.status));
          })
}

//Function for deleting items

export const delItems = (id) =>(dispatch ,getState)=>
{
    //This also attches the tokem too the request in hte header which will authorize the action
    axios.delete(`/routes/api/${id}` , tokenConfig(getState))
    .then(res =>
        dispatch(
            {
               type:DEL_ITEMS,
               payload:id
            }
        ))
        .catch(err => {
            dispatch(returnErrors(err.response.data, err.response.status));
          })
        
}


//Funciton for adding items
export const addItems = (item)=>(dispatch ,getState) =>
{
    //This also attches the token too the request in hte header which will authorize the action
    axios.post("/routes/api/" , item , tokenConfig(getState))
    .then(res => 
        //Inside dispatch we will set the type to be addItmes and then set the payload to be res.data which is th data given to us from the backend 
        dispatch(
            {
                type:ADD_ITEMS,
                payload: res.data
            }
        )
        
        )
        .catch(err => {
            dispatch(returnErrors(err.response.data, err.response.status));
          })
}
export const setLoading = () =>
{
    return{
        type:ITEMS_LOADING
    }
}
