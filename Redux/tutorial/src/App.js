import React from 'react';
import logo from './logo.svg';
import './App.css';

//Import store to access state 
//import store from "../src/store/index"

//Importing actions
import update_person from "../src/Actions/personActions"
import update_game from './Actions/gameActions';
import fetch_users from "./Actions/userActions"

import {connect} from "react-redux"

//Funuction for dispatching the update_person action





function App(props) {
  console.log(props)
  //console.log(store.getState().person)

  return (
    <div className="App">
      <h1>Redux tutorial</h1>

              {/* Done using the reducer */}
    {/**This is obtaining the values from each reducer */}

    {/* Person Name: {store.getState().person.name} || */}
    {/* Game Name: {store.getState().game.name} */}


              {/* Done using the props */}
    Person Name: {props.person.name} ||
    {/**We set our button to call the updatePerson function */}
    <button onClick = {props.updatePerson}>Update Person</button>
    <hr/>
    Game Name: {props.game.name}
    <button onClick = {props.updateGame}>Update Game</button>
    
   <br/>
   <hr/>
   <button onClick = {props.getUsers}>Fetch users</button>

    <hr/>
   { props.users.length === 0 ? <p>"No Users found"</p> : props.users.map(user =>
    
    
      <p key = {user.id}>
        User ID: {user.id}
        <br/>
        User Name: {user.name}
        <br/>
        User Email: {user.email}
      </p>
      
    )}
    <hr/>

    </div>
  );
}

function mapStateToProps(state)
{
  return{
    game:state.game,
    person:state.person,
    users:state.users
  } 
}

function mapDispatchToProps(dispatch)
{
  return {
    updateGame: ()=>
    {
      dispatch(update_game)
    },
    updatePerson: ()=>
    {
      dispatch(update_person)
    },
    getUsers: ()=>
    {
      dispatch(fetch_users)
    }
  }
}



export default connect(mapStateToProps , mapDispatchToProps) (App);
