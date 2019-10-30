//Brininging in the express module
const express = require("express")

//We need an object to represnt our express app
const app = express();

//Bringing in express layouts
const expressLayouts = require("express-ejs-layouts")

//Bringing in flash message
const flash = require("connect-flash")

//Bringing in express session
const session = require("express-session")

//Bringing in passport
const passport = require("passport")



//Passport config file
require("./Config/passport")(passport)

//Using EJS
app.use(expressLayouts)
app.set("view engine" , "ejs" )



//Bringing in mongoose
const mongoose = require("mongoose")

//Database Configuration - grabbing url from keys file
const db = require("./Config/keys").MongoUrl

//Connect to database
mongoose.connect(db , {useNewUrlParser:true ,useCreateIndex:true})
.then(()=> console.log("Connected To Database..."))
.catch(err => console.log(err))

//Bringing in body parser 
app.use(express.urlencoded({extended: true}))

// Express session
app.use(
    session({
      secret: 'secret',
      resave: true,
      saveUninitialized: true
    })
  )

  //Passport implementation
app.use(passport.initialize());
app.use(passport.session());

  // Connect flash
app.use(flash());

//global variables
app.use((req , res , next)=>
{
    res.locals.success_msg = req.flash("success_msg")
    res.locals.error_msg = req.flash("error_msg")
    res.locals.error = req.flash("error")
    next()
})


// we use process.env.port in the case that we deploy or we use 5000 onour local host
const port =process.env.PORT||5000


//Routes

//Route for index page
app.use("/" , require("./Routes/index"))

//Route for user page
app.use("/users" , require("./Routes/users"))

///This tells the application to listen on the value of whatwvwer we assigned to port
app.listen(port , ()=>
{
    console.log(`Server Started on port ${port}`)
})