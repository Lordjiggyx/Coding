import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import * as serviceWorker from './serviceWorker';
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
  } from "react-router-dom";
import Welcome from './Components/WelcomeComponents/Welcome';
import Header from './Components/Parallax/Header';
import R1 from './Components/Parallax/R1';
import R2 from './Components/Parallax/R2';
import R3 from './Components/Parallax/R3';
import UserForm from './Components/SignUp/UserForm';
import Login from "./Components/Login/Login"
import Details from "./Components/Profile/Details"
import Dashboard from "./Components/Dashboard/Dashboard"
import UserDashboard from "./Components/Dashboard/UserDashboard"
import FoodPage from "./Components/Dashboard/FoodPage"
import ExcercisePage from "./Components/Dashboard/ExcercisePage"

  const routes = (
    <Router>
        <div>
            <Route exact path = "/" component = {Welcome}/>
            <Route path = "/why" component = {R1}/>
            <Route path = "/why/R2" component = {R2}/>
            <Route path = "/why/R3" component = {R3}/>
            <Route path = "/SignUp" component = {UserForm}/>
            <Route path = "/Login" component = {Login}/>
            <Route path = "/Profile" component = {Details}/>
            <Route path = "/Dashboard" component = {Dashboard}/>
            <Route path = "/UserDashboard" component = {UserDashboard}/>
            <Route path = "/Food" component = {FoodPage}/>
            <Route path = "/Fitness" component = {ExcercisePage}/>

            
        </div>
    </Router>
  )




ReactDOM.render(routes, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
