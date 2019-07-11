//Always import react
import React from "react"
//Importing the footer file
import Footer from "./Footer"
import MainContent from "./MainContent"
import Navbar from "./Navbar"
function App()
{
    return(
        <div>
        {/**Creating a JSX component of footer */}
        <Navbar></Navbar>
        <MainContent></MainContent>
        <Footer></Footer>
        </div>
    )
}



//Alwts export the functino
export default App