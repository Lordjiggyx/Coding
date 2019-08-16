import React from 'react';
import "../../client/node_modules/bootstrap/dist/css/bootstrap.css"
import './App.css';

//Importing Components 
import AppNavbar from "../src/Components/AppNavbar"
import ShoppingList from './Components/ShoppingList';
import ItemModal from './Components/ItemModal';
import {Container} from "reactstrap"
import {loadUser} from "./actions/authActions"
//Redux 
import {Provider} from "react-redux"
import store from "./store"


class App extends React.Component{
  componentDidMount() 
  {
    //since we have access to the store we can access dispatch and dispatch loadUser Action
    store.dispatch(loadUser())
  }

  render() {
    return (
      <Provider store={store}>
        <div className='App'>
          <AppNavbar />
          <Container>
            <ItemModal />
            <ShoppingList />
          </Container>
        </div>
      </Provider>
    );
  }
}

export default App;
