import React from "react";
import ReactDOM from "react-dom"
import App from "./Parent&Child/App"
import Todo from "./Todo-components/Todo"
import "../src/style.css"
import Props from "./Props/Props"
import ContactCard from "./Props/ContactCard";
import TheAppClass from "./ClassComponents/App"
import StateApp from "./State/App"
import Event from "./EventHandling/events"
import ChangeStateApp from "./State/ChangeState"
import ConditionalApp from "./ConditionalRendering/ConditionalApp"
import Conditional from "./ConditionalRendering/Conditional";
import Fetch from "./Fetch/Fetch";
//JSX


/*PART 1 - Getting Started
ReactDOM.render(<div><h1>Hello World</h1> <p>This is a paragraph</p></div>, document.getElementById("root"))
*/


/*Part 2 - Paractice

//This proactice includes making an unoored lsit 

ReactDOM.render
(<div>
    <ul>
        <li>Item 1 </li>
        <li>Item 2 </li>
        <li>Item 3 </li>
    </ul>
</div>
, document.getElementById("root"))
 */


 /*Part 3 - Functional Components  

 //This is functional compoenent which returns jsx
function  MyApp()
{
    //returning an unordered list
  return  (
    <div>
    <ul>
        <li>Item 1 </li>
        <li>Item 2 </li>
        <li>Item 3 </li>
    </ul>
</div>
    )
}

//Calling the redner method on the ReactDOM object 
ReactDOM.render
(
    //This how we call the functional component
    <MyApp/>,
    document.getElementById("root")
)
*/

/**Part 3 continuted Practice with functional components

function MyInfo()
{
    return(
        <div>
            <h1>Tomi Ilori</h1>

            <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Laboriosam vel iure vero odio sit. Hic, quia? Reprehenderit, laborum odit. Ipsam quisquam laborum nam dicta repudiandae temporibus, velit iste recusandae est.
            </p>
            
            <ul>
            <li>Tokyo</li>
            <li>Maldives</li>
            <li>Austraila</li>
            </ul>
        </div>
    )
}

ReactDOM.render
(
    //This how we call the functional component
    <MyInfo/>,
    document.getElementById("root")
)
 */

 /**Part 4 functions acorss files 

 //Import the function form the file
 import MyInfo from "./Components/MyInfo"

 ReactDOM.render
(
    //This how we call the functional component
    <MyInfo/>,
    document.getElementById("root")
)
*/

/**Part 5 - PARENT/CHILD COMPONENTS 

//We will create a file and a component aclled App and tgis will serve as the entry point to our application 

//We must then import this app file and the component

import App from "./Parent&Child/App"

ReactDOM.render(<App/> , document.getElementById("root"))
*/

/**Part 6 - Todo pahse one done in to components just switch teh component to Todo

ReactDOM.render(<Todo/> , document.getElementById("root"))
*/

/**Part 7 Using JS in JSX
function JS()
{
    const firstname = "Tomi"
    const Secondname = "Ilori"

    return(
        <div>
            {/**We vcan use es6 js once placed in curly braces }
            <h1>Hello {`${firstname} ${Secondname}`} </h1>
         
        </div> 
    )
}
//Then the function is rendered
ReactDOM.render(<JS/> , document.getElementById("root"))
 */

 /**Using inline styles with the style property 

 function Time()
 {
     const date = new Date()
     const hours = date.getHours()
     let timeOfDay

     if(hours <12)
     {
         timeOfDay = "morning"
     }
     else if(hours >=12 && hours<17)
     {
         timeOfDay = "afternoon"
     }
     else
     {
         timeOfDay= "night"
     }

     const styles =
     {
        color:"red",
        backgroundColor:"yellow"
     }

     return(  
         <h1 style ={styles}>
            Hello Good {`${timeOfDay}`}
        </h1>
         )
     
 }

 ReactDOM.render(<Time/> , document.getElementById("root"))*/


 /**Part 8 - Todo pahse one done in to components just switch teh component to Todo

ReactDOM.render(<Todo/> , document.getElementById("root"))
*/


/**Part 9 - Props

ReactDOM.render(<Props/> , document.getElementById("root"))
*/

/**Part 10 - Classed based components*/






/**Part 11 - Classed based components practice

//Esstentially the tutorial wants you to conver functions to classes

class TimeApp extends React.Component
{
    render()
    {
        return(
            <div>
                <Header/>
                <Greeting/>
            </div>
        )
    }
}
class Header extends React.Component
{
    render()
    {
        return(
            <div>
               <header>
                   <p>Welcome </p>
               </header>
            </div>
        )
    }
}
class Greeting extends React.Component
{
    render()
    {
        const date = new Date()
        const hours = date.getHours()
        let timeOfDay

     if(hours <12)
     {
         timeOfDay = "morning"
     }
     else if(hours >=12 && hours<17)
     {
         timeOfDay = "afternoon"
     }
     else
     {
         timeOfDay= "night"
     }

        return(
            <div>
                <p>Good {`${timeOfDay}`} to you sir or madam</p>
            </div>
        )
    }
}


ReactDOM.render(<TimeApp/> , document.getElementById("root"))
*/

/**State */



//Practic Excercises

//This extends the react component bare in mind () are not needed after React.componenet as it's a class


// class StateAppPractice extends React.Component
// {
//     //The constructor is called which takes in a super eiht the react component methods
//     //
//     constructor()
//     {
//         //Super takes react component methods
//         super()
//         //This is our state which is esstenially where are properties are stored this is done in an object
//         this.state =
//         {
//             name:"Tomi",
//             age:20
//         }
//     }

//     //This render method returns the display the logic to the wbepage
//     render()
//     {   
//     return(
//         <div>
//         {/**this.state.name allows you to grab the value of the property specfied */}
//         <h1>{this.state.name}</h1>
//         <h3>{this.state.age} years old</h3>
//         </div>
//     )
// }   
    
// }




// class  StateAppPractice2 extends React.Component
// {
//     constructor()
//     {
//         super()
//         this.state = 
//         {
//             loggedIn: false,
//             userState: "in"
//         }

//         if(this.state.loggedIn == true)
//         {
//             this.state.userState = "out"
//         }
//         else
//         {
//             this.state.userState = "in"
//         }
//     }
    
    
    
    
//     render()
//     {
//     return(
//         <div>
//             <h1>You are currently logged {`${this.state.userState}`}</h1>
//         </div>
//     )
//     }
// }




/**Condtional practice
 * Given a stateless functional component
 * add state to it 
 * haev the satte keep trak of whether the user is logged in/out
 * add button that logs the user in/out
 * make button display log in if theyre logged in and out if theyre logged out 
 * display logged in/out 
 */


// class ConditionalAppPractice extends React.Component
// {
//     constructor()
//     {
//         super()
//         this.state =
//         {
//             loggedIn : false,
            
            
//         }
//         this.log = this.log.bind(this)
//     }


//     log()
//     {
//         this.setState(prevState =>
//             {
//                 //You must refer to the state of the previosu state when you want to change it
//                 return{
//                     loggedIn: !prevState.loggedIn
//                 }
//             })
//     }



//     render()
//     {
//         //Ternary operators if user is logged in or out the display and button text will change
//         let buttonText = this.state.loggedIn ? "Log Out" : "Log In"
//         let display = this.state.loggedIn ? "Logged In" : "Logged Out"

//     return(
//         <div>
//             <h1>User is  {`${display}`}</h1>
//             <button onClick = {this.log}> {`${buttonText}`}</button>
//         </div>
//     )}

// }

ReactDOM.render(<Fetch/> , document.getElementById("root"))