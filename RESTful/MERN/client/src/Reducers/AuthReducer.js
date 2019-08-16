//actions
import {
    USER_LOADED,
    USER_LOADING,
    AUTH_ERROR,
    LOGIN_SUCCESS,
    LOGIN_FAIL,
    LOGOUT_SUCCESS,
    REGISTER_SUCCESS,
    REGISTER_FAIL
  } from '../actions/types';
  

  //state
  const initialState = {
    //Token grabbed from the local storage
    token: localStorage.getItem('token'),
    //if the user is authenticated
    isAuthenticated: null,
    //if user is loading
    isLoading: false,
    user: null
  };

//This fucntion sets the state that it takes in to the atate current state
export default function (state =initialState , action)
{
    switch(action.type)
    {
        //Point of where we are trying to get the user from the backend to the point of the user being fecthed
        case USER_LOADING:
            return{
            //Return the current state
            ...state,
            //iindicates user is loading 
            isLoading:true

        }
        
        //Loaded User
        case USER_LOADED:
            return{
            //Return the current state
            ...state,
            //User was validated and obtained
            isAuthenticated:true,
            //User is loaded
            isLoading:false,
            //The user will be sent as a payload
            user:action.payload
            }

        //For login and registration success we will return the entire payload along with thr authentication and loading value
        case LOGIN_SUCCESS:
        case REGISTER_SUCCESS:
            //Here we are setting the token to the token that comes through the token payload 
            localStorage.setItem('token', action.payload.token)
             return{
             //Getting current state
             ...state,
             //Entire payload because we need the user and the token , as this is what we are sending back from backend
             ...action.payload,
             //User was validated and obtained
             isAuthenticated:true,
             //User is loaded
             isLoading:false,
                   
               }
        //This is for any case where we fail the authentication if the logout is sucessful or if the register has failed or login failed , it will turn everything to null
        case AUTH_ERROR:
        case LOGIN_FAIL:
        case LOGOUT_SUCCESS:
        case REGISTER_FAIL:
            //Clears token from localstorage if there is one
            localStorage.removeItem('token');
            return {
            //returns the state and sets all values to null
            ...state,
            token: null,
            user: null,
            isAuthenticated: false,
            isLoading: false
            };
        //Default behaviour is set to null
        default:
            return state;

    }
}