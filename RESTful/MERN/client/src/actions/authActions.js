//Importing axios
import axios from "axios"

//importing return errors from error actions
import { returnErrors } from  "./errorActions"

//actions
import {
    AUTH_ERROR,
    LOGIN_SUCCESS,
    LOGIN_FAIL,
    LOGOUT_SUCCESS,
    REGISTER_SUCCESS,
    REGISTER_FAIL,
    USER_LOADING,
    USER_LOADED,
  } from '../actions/types';
  

//Check for the token and load the user

//Exportable function which will need dispatch as we are making an async request
export const loadUser = () => (dispatch , getState) => 
{
    //First we will do is dispatch user loading which changes the value of laoding form false to true

    //User loading - this will call the case of user loading in our auth reducer
    dispatch({type:USER_LOADING})


  //Fetching the usser using axios.get request  
  axios
  //TARGERT THE URL /routes/api/auth we must also pass in our token which
  .get('/routes/api/auth', tokenConfig(getState))
  //We will dispatxh user loaded
  .then(res =>
    dispatch({
      type: USER_LOADED,
      //The payload will be the user object and the token object
      payload: res.data
    })
  )
  //If there is an issue
  .catch(err => {
    //We dispatch return errors , which returns an object 
    //This function takes in a message status and id if an eror occurs and this will be stored in the err value above m err.response.data will give us the message and err.response.status will pass in the status
    dispatch(returnErrors(err.response.data, err.response.status));
    //We will return Auth Error which will clear out the auth state 
    dispatch({
      type: AUTH_ERROR
    })
  })

}

//Funciton for regestering the user must be exported
//This takes in the name email and password and since we will be passing in an object we can destrucre it and then we must cal our dispatcg
export const register =  ({name , email, password}) => dispatch => 
{
  //We need add a headrers file of content type since we will be sending json to the server we will make a post request to our routes/api/register route

  //Headers
  const config = 
  {
     headers:
     {
         "Content-type":"application/json"
     }
  }

  //Create the requets body/data which will be the name email and password
  //we must use Json strinify to turn this data into an object
  const body = JSON.stringify({ name, email, password });

  //We will make a axios post request to the register route and then pass in the data being body and the headers
  axios.post("routes/api/register" , body , config)
  //Returns a promise
  .then(res =>
    //dispatch the register succes type and then send a payload of everything whihc is just res.data that end point returns the user and the token which will be sent to the reducer
    dispatch({
      type:REGISTER_SUCCESS,
      payload:res.data
    }))
   //If there is an issue
  .catch(err => {
    //We dispatch return errors , which returns an object 
    //This function takes in a message status and id if an eror occurs and this will be stored in the err value above m err.response.data will give us the message and err.response.status will pass in the status we will also add an ID of register fail
    dispatch(returnErrors(err.response.data, err.response.status , "REGISTER_FAIL"));
    //We will return register fail which will clear out the auth state 
    dispatch({
      type: REGISTER_FAIL
    })
  })
}


//Funciton for Logging on the user must be exported
//This takes in the  email and password and since we will be passing in an object we can destrucre it and then we must cal our dispatch
export const login =  ({ email, password}) => dispatch => 
{
  //We need add a headrers file of content type since we will be sending json to the server we will make a post request to our routes/api/auth route

  //Headers
  const config = 
  {
     headers:
     {
         "Content-type":"application/json"
     }
  }

  //Create the requets body/data which will be the email and password
  //we must use Json strinify to turn this data into an object
  const body = JSON.stringify({ email, password });

  //We will make a axios post request to the register route and then pass in the data being body and the headers
  axios.post("routes/api/auth" , body , config)
  //Returns a promise
  .then(res =>
    //dispatch the login succes type and then send a payload of everything whihc is just res.data that end point returns the user and the token which will be sent to the reducer
    dispatch({
      type:LOGIN_SUCCESS,
      payload:res.data
    }))
   //If there is an issue
  .catch(err => {
    //We dispatch return errors , which returns an object 
    //This function takes in a message status and id if an eror occurs and this will be stored in the err value above m err.response.data will give us the message and err.response.status will pass in the status we will also add an ID of LOGIN fail
    dispatch(returnErrors(err.response.data, err.response.status , "LOGIN_FAIL"));
    //We will return register fail which will clear out the auth state 
    dispatch({
      type: LOGIN_FAIL
    })
  })

}



//Logout user
export const logout =() =>
{
  return{
    type:LOGOUT_SUCCESS
  }
}



// Setup config/headers and token
export const tokenConfig = getState => {
    //Geting token frpm local storage
    //This looks at the auth reducer
    const token = getState().auth.token

    //We can add the token to the header
    const config = 
    {
       headers:
       {
           "Content-type":"application/json"
       }
    }

    //if token exists we add it to the headers 
    if(token)
    {
        //We want to set our headers token to the token in our state which will be ultimately the token stored in loclastorage
        config.headers["x-auth-token"] = token
    }
    return config;
}

