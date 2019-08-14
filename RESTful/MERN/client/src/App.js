import React from 'react';
import "../../client/node_modules/bootstrap/dist/css/bootstrap.css"
import './App.css';

//Importing Components 
import AppNavbar from "../src/Components/AppNavbar"
import ShoppingList from './Components/ShoppingList';
import ItemModal from './Components/ItemModal';
import {Container} from "reactstrap"

//Redux 
import {Provider} from "react-redux"
import store from "./store"


function App() {
  return (
    <Provider store = {store}>
    <div className="App">
      <Container>
      <AppNavbar></AppNavbar>
    <ItemModal></ItemModal>
      </Container>
    
    <ShoppingList></ShoppingList>
    
    </div>
    </Provider>
  );
}

export default App;
