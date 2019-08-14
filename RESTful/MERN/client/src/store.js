import {createStore , applyMiddleware ,compose} from "redux"
import thunk from "redux-thunk"
import rootReducer from "./Reducers/index"

//Variable to represnet initial state
const initialState = {}

//Varible for middleware stored in array
const middleware = [thunk]

//vairable for our store being set to our create store function
const store = createStore(rootReducer , initialState , compose(
    applyMiddleware(...middleware),  window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
))

//Exporting the store
export default store