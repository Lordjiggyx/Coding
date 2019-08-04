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
// parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: false }))
 
// parse application/json
app.use(bodyParser.json())


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
        console.log(articles)
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
    //We have access to the model 
    let article = new Article()
    
    article.Title = req.body.Title
    article.Author = req.body.Author
    article.Body = req.body.Body

    article.save((err)=>
    {
        if(err)
        {
            console.log(err)
            return
        }
        else
        {
            res.redirect("/")
        }

    })
})

