//Brininging in the express module
const express = require("express")

//We need an object to represnt our express app
const app = express();

//Path
const path = require('path')

//Mongoose
const mongoose = require("mongoose")

//Body parser
const bodyParser = require("body-parser")

//For flash messages
const flash = require('connect-flash');

//For express sessions
const session = require('express-session');

//Linking mongodb path to this file to be used to connect to db
const config = require("./config/database")

//Bringing in passport
const passport = require("passport")
//Bringing in passport configuration and be able to use the value as so 
require("./Config/passport")(passport)

// parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: false }))
 
// parse application/json
app.use(bodyParser.json())

//Set public folder
app.use(express.static(path.join(__dirname , "public")))

// Express session middleware
app.use(
    session({
      secret: 'secret',
      resave: true,
      saveUninitialized: true
    })
  )

// Express Messages Middleware
app.use(require('connect-flash')());
app.use(function (req, res, next) {
  res.locals.messages = require('express-messages')(req, res);
  next();
});


//Passport confuration
app.use(passport.initialize());
app.use(passport.session());

//Set global varibale 
app.get("*" , (req , res , next)=>
{
    res.locals.user = req.user || null
    next()
})


//Connecting to dtaabase 
mongoose.connect(config.database)
//creating database object to be referneced in the applciation
let db = mongoose.connection

//Chcek connection 
db.once('open' , ()=>
{
    console.log("Conncted to Database")
})

//Chceking for errors on db
db.on("error", (err)=> 
{
    console.log(err)
})

//Bringing in models
let Article = require("./Models/articles")


//Load view engine
app.set("views", path.join(__dirname, "views"))
app.set("view engine ","pug")

// we use process.env.port in the case that we deploy or we use 5000 onour local host
const port =process.env.PORT||5000


app.get("/" , (req , res)=>
{
    //Article.find is used to grab objects based on a {} for the query and a functino to occur wheen tan object is found
    Article.find({}, (err , articles)=>
    {
        if(err)
        {
            console.log(err)
        }
        else
        {
        //When an object is found we render the index page passing the articles from the function into the view 
        res.render("index.pug",
        {
            title:"Home page",
            articles:articles
            
        })
        
        }
        
    })
   
})

//Route files
//For article file and it's routes
let articles = require("./Routes/articles")
app.use(articles)

//For user file and it's routes
let users = require("./Routes/users")
app.use(users)



///This tells the application to listen on the value of whatwvwer we assigned to port
app.listen(port , ()=>
{
    console.log(`Server Started on port ${port}`)
})

