//Brininging in the express module
const express = require("express")

//We need an object to represnt our express app
const app = express();

//Path
const path = require('path')


//Load view engine
app.set("views", path.join(__dirname, "views"))
app.set("view engine ","pug")

// we use process.env.port in the case that we deploy or we use 5000 onour local host
const port =process.env.PORT||5000


//static sarray for test

let articles = [
    
   { id:1,
    title:"A1",
    User:"Template",
    body:"This is article one"},
   { id:2,
    title:"A2",
    User:"Template",
    body:"This is article two"},
   { id:3,
    title:"A3",
    User:"Template",
    body:"This is article three"},
    
]



app.get("/" , (req , res)=>
{
    res.render("index.pug"  ,
    {
        title:"Home page",
        articles:articles
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