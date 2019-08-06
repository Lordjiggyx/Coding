//Brininging in the express module
const express = require("express")

//We need an object to represnt our express app
const app = express("");

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


//Connecting to dtaabase 
mongoose.connect('mongodb://localhost/MER')
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


// //static sarray for test

// let articles = [
    
//    { id:1,
//     title:"A1",
//     User:"Template",
//     body:"This is article one"},
//    { id:2,
//     title:"A2",
//     User:"Template",
//     body:"This is article two"},
//    { id:3,
//     title:"A3",
//     User:"Template",
//     body:"This is article three"},
    
// ]



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

///This tells the application to listen on the value of whatwvwer we assigned to port
app.listen(port , ()=>
{
    console.log(`Server Started on port ${port}`)
})

//Route for adding articles for the user
app.get("/articles/add" , (req , res)=>
{
    res.render("add.pug"  ,
    {
        title:"Add articles"
    })
})

//Submit an article
app.post("/articles/add" ,(req ,res)=>
{

    //Vlaidation
    if(req.body.Title== "" || req.body.Author== "" || req.body.Body== "" )
    {
        req.flash("danger" ,"All fields must be filled")
        res.render('add.pug',
        {
            title:"Add Article",
        })
    }
    else
    {
 //We have access to the model 
        let article = new Article()
            
        // Here we assign the values from the field and the ti the object paraemters
        article.Title = req.body.Title
        article.Author = req.body.Author
        article.Body = req.body.Body

        //We then call the save method which saves to a database 
        article.save((err)=>
        {
            if(err)
            {
                console.log(err)
                return
            }
            //Once the object has been saved we can redirect to the home page
            else
            {
                //showing flash message for succssful submission
                req.flash("success" , "Article added successfully!!!")
                res.redirect("/")
            }

        })
    }

   
})
//Edit an article
app.post("/articles/edit/:id" ,(req ,res)=>
{
   
        let article = {}
    
        // Here we assign the values from the field and the ti the object paraemters
        article.Title = req.body.Title
        article.Author = req.body.Author
        article.Body = req.body.Body
    
        //
        let query = {_id:req.params.id}
    
       Article.update(query , article , function(err)
       {
        if(err)
        {
            console.log(err)
            return
        }
        //Once the object has been saved we can redirect to the home page
        else
        {
            req.flash("success" , "Article Updated successfully")
            res.redirect("/")
        }
       })
    }
    //We have access to the model 
   
)


//Get a single article 
app.get("/article/:id" , (req , res)=>
{
    Article.findById(req.params.id , (err , article)=>
    {
        res.render("article.pug"  ,
        {
            article:article
        })
    })
})

//Edit a single article / load edit form 
app.get("/article/edit/:id" , (req , res)=>
{
    Article.findById(req.params.id , (err , article)=>
    {
        res.render("edit_article.pug"  ,
        {
            title:"Edit Article",
            article:article
        })
    })
})


//delete route
app.delete('/article/:id' ,  (req ,res)=>
{
    let query = {_id:req.params.id}

    Article.remove(query, (err)=>
    {
        if(err)
        {
            console.log(err)
        }
        res.send("success")
    })
})