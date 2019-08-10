import React from 'react';
import "../../client/node_modules/bootstrap/dist/css/bootstrap.css"
import './App.css';

//Importing Components 
import AppNavbar from "../src/Components/AppNavbar"
import ShoppingList from './Components/ShoppingList';



function App() {
  return (
    <div className="App">
    <AppNavbar></AppNavbar>
    <ShoppingList></ShoppingList>
    </div>
  );
}

export default App;
