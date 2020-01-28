//Required modules
const express = require("express")
const mongoose = require("mongoose");


//Routes
const Users = require("./Routes/API/users")


//Initialise express
const app = express()

//Body Parser MiddleWare
app.use(express.json())

//Database
const db = require("./config/Keys").MongoUrl;

//Connecting to database
mongoose
.connect(db , {useNewUrlParser:true ,useCreateIndex:true , useUnifiedTopology: true})
.then(()=> console.log("Connected To Database..."))
.catch(err => console.log(err))

//Create a port Variable
const port = process.env.PORT || 5000

app.use("/Routes/API", Users);


//app.listen() used ot start the server
app.listen(port , ()=>
{
    console.log(`Server started on port ${port}`)
   
})
