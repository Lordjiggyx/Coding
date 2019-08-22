//iMPORTING neccesary function from redux
import { createStore  , combineReducers  , applyMiddleware , compose} from 'redux'

//Importing the reducers
import gameReducer from "../Reducers/gameReducer"
import personReducer from "../Reducers/personReducer"
import userReducer from "../Reducers/userReducer"
import thunk from "redux-thunk"

//iNTIAL STATE
const initialStates =
{
    game:
    {
        name:"Jimbo"
    },
    person:
    {
        name:"Tomi",
        email:"Tomiilori123@Gmail.com"
    },
    users:[]
}




const rootReducer = combineReducers(
    {
        game:gameReducer,
        person:personReducer,
        users:userReducer
    }
)





const middleware = [thunk]



//Creating the redux store 
const store = createStore(rootReducer , initialStates , compose(
    applyMiddleware(...middleware),  window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()))

//displays an empty object
console.log(store.getState())



//displays object with the change dname 
console.log(store.getState())


//exporting the store

export default store