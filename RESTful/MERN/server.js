//Required dependencies
const express = require("express")
const mongoose = require("mongoose")
const config = require("config")


//Including the items route
const Items = require("./Routes/api/items")
const Users = require("./Routes/api/users")
const Auth = require("./Routes/api/auth")


//Initialise express
const app = express()

//Body Parser MiddleWare
app.use(express.json())



//Creating Database variable
const db = config.get("MongoUrl")
//Connecting to database
mongoose
.connect(db , {useNewUrlParser:true ,useCreateIndex:true})
.then(()=> console.log("Connected To Database..."))
.catch(err => console.log(err))

//Create a port Variable
const port = process.env.PORT || 5000


//Use Routes
app.use("/Routes/api/", Items)
app.use("/Routes/api/", Users)
app.use("/Routes/api/", Auth)


//app.listen() used ot start the server
app.listen(port , ()=>
{
    console.log(`Server strated on port ${port}`)
   
})