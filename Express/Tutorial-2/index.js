//Creating the express server//

//Bringing Express into the project
const express = require('express')

//Initialise a variable called app with express this allows us to access methods that express uses
const app = express()

//We create a variable that checkes the environenr variable for the port and if it is not avaliable we run it on whatever port we require e.g. 5000
const PORT = process.env.PORT || 5000

//We need a port for the server to act upon
//AN arrow function is added to check port is 
app.listen(PORT , ()=>console.log(`Server started on ${PORT}`))

//We can bring in the path modiule to deal with filepaths
const path = require("path")


//We get a message saying "cannot find / this is the index page it is looking for so we must create a route ""

//We can install nodemon  this allows us to make changes to our server  without having to start and stop using npm i -D nodemon


//To  use it we need to create scripts in the scripts object                                
/*  "start": "node index",
    "dev": "nodemon index"*/

//And then we can use npm run start to start the server and npm run dev to run nnodemon


//Creating a Route///

//To create a route we need to use the app and the type of request 
//we use .get() as we aree obtaining a page
//Tkaes in two parameters 1. the route / and 2. a function cna do a proper one or just use an arrow function

//we can use the sendFile() method to send a file 
//The path.joib method goes into the current directory then the folder public and then the file index.hrtml


//This method is not ideal sa we would have to write a route for everypage

// app.get("/" , (req, res)=>
// {
//     res.sendFile(path.join(__dirname  , "public" , "index.html"))
// })


//Instead we will set a static folder

//We will use the app.use to include middleware

//This line sets our public folder ot our static folder
app.use(express.static(path.join(__dirname, 'public')))

//we can now place the in the url localhost:5000/blog.html and this will load it 



//Midlleware is prety much software that servedsother software esstentially just an api

//creating a logger middleware
//middle ware calls have three parameters request response and next , next must always be last 

const logger = (req , res , next)=>
{
    console.log(`${req.protocol}://${req.get('host')}${req.originalUrl}`)
    next()
}

//To use the middle ware you must initialise it and then call a request for it to see it work this is done bu saying app.use()

app.use(logger)