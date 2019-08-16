import {combineReducers} from "redux"
import itemReducer from "./itemReducer"
import AuthReducer from "./AuthReducer"
import ErrorReducer from "./ErrorReducer"



export default combineReducers(
    {
        item:itemReducer,
        auth: AuthReducer,
        Error: ErrorReducer
    }
)