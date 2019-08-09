//Required dependencies
const express = require("express")
const mongoose = require("mongoose")
const bodyParser = require("body-parser")

//Including the items route
const Items = require("./Routes/api/items")

//Initialise express
const app = express()

//Body Parser MiddleWare
app.use(bodyParser.json())



//Creating Database variable
const db = require("./Config/keys").MongoUrl

//Connecting to database
mongoose
.connect(db , {useNewUrlParser:true})
.then(()=> console.log("Connected To Database..."))
.catch(err => console.log(err))

//Create a port Variable
const port = process.env.PORT || 5000


//Use Routes
app.use("/Routes/api/", Items)


//app.listen() used ot start the server
app.listen(port , ()=>
{
    console.log(`Server strated on port ${port}`)
   
})