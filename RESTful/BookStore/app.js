//Requiring the needed packages
const express = require("express")
const bodyParser = require("body-parser")
const mongoose = require("mongoose")

//including the genre file
Genre = require("./Mongooe_Models/generes")

//Includieng the book file
Book = require("./Mongooe_Models/books")
//We need an object to represnt our express app
const app = express()


//Connecting to mongoose
mongoose.connect("mongodb://localhost/bookstore")

//Creating a database object
const db = mongoose.connection

//Set up a route for the home page
app.get("/", function(req , res)
{
    res.send("Please use /api/books or /api/genres")
})


//Route to the generes page

app.get("/api/generes" , function(req,res)
{
    Genre.getBooks(function(err , generes)
    {
        if(err)
        {
            throw err
        }
        else
        {
            res.json(generes)
        }
    })
})
//Route to the books page

app.get("/api/books" , function(req,res)
{
    Book.getBooks(function(err , books)
    {
        if(err)
        {
            throw err
        }
        else
        {
            res.json(books)
        }
    })
})

//Route for grabbing a specific book page

app.get("/api/books/:_id" , function(req,res)
{
    console.log(req.params)
    Book.getBookById(req.params._id , function(err , book)
    {
        if(err)
        {
            throw err
        }
        else
        {
            res.json(book)
            
        }
    })
})


app.listen(3000)
console.log("Runing on port 3000......")