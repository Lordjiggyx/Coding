import React from 'react';
import ReactDOM from 'react-dom';

import {
    BrowserRouter as Router,
    Route,
  } from "react-router-dom";
import Welcome from './Components/WelcomeComponents/Welcome';
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
import DiaryPage from "./Components/Dashboard/DiaryPage"
import CalenderPage from "./Components/Dashboard/CalenderPage"
import EmotionPage from "./Components/Dashboard/EmotionPage"
import ResearchPage from "./Components/Dashboard/ResearchPage"

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
            <Route path = "/Diary" component = {DiaryPage}/>
            <Route path = "/Calender" component = {CalenderPage}/>
            <Route path = "/Emotion" component = {EmotionPage}/>
            <Route path = "/Research" component ={ResearchPage}/>

        </div>
    </Router>
  )




ReactDOM.render(routes, document.getElementById('root'));

