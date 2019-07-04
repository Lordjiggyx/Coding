
/**Getting started */

const express = require('express');

//This returns a function  which must be called
//This function returns an object with a lot of methids so it's best to store in a variable
const app = express()

//requiring the path module
const path = require('path');

//Requirung the body parser
const bodyParser = require('body-parser')

//Requiriung the people module where our routes are stored
const people = require('./Routes/people')

//Calling the get method
//This will send a response of hello world
// app.get('/' , (req,res)=>
// {
//     res.send('Hello World')
// })

//Addinf anothe route
// app.get('/example', (req , res)=>
// {
//     res.send('You have reached the example route')
// })


/**Route parameters - used to get data from user */
// app.get('/example/:name/:age', (req , res)=>
// {
//     console.log(req.params);
//     res.send(`Your name is ${req.params.name} and you are ${req.params.age} old`)
// })

/**Query parameters - used to get data from user */

// app.get('/example/:name/:age', (req , res)=>
// {
//     console.log(req.params);
//     res.send(`Your name is ${req.params.name} and you are ${req.params.age} old`)
//     console.log(req.query)
// })



/*Serving static files



//This use method means that middleware is being used
//IN this case three parameters are passed in the alias
//The express.static method which takes in the directory name
app.use('/public', express.static(path.join(__dirname , 'static')))
app.use(bodyParser.urlencoded({extended:false}));

//using body parser for data transfer


app.get('/' , (req,res)=>
{
    //We then send this path to the user
    res.sendFile(path.join(__dirname , 'static' , 'form.html'))
})

//use app.post as this was what was stated in the form.html file
app.post('/' , (req , res)=>
{
    console.log(req.body)
    res.send("Data Saved")
})


//Then we msut have the object leisten on a port
app.listen(5500)
*/


/*Express Templates and EJS*/

app.use('/public', express.static(path.join(__dirname , 'static')))


//Setting the application view to ejs
app.set("view engine" , "ejs")

/*
app.get('/:UserQuery' , (req,res)=>
{

    res.render('index' , 
    {data:
    {
    UserQuery:req.params.UserQuery,
    searchresults :['Book1' , 'Book2', 'Book3'],
    loggedIn:true,
    username:"Tomi Ilori"

    }
    })
})
*/

app.use('/people' , people)


app.listen(5500)