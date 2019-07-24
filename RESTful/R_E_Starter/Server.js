
//Brininging in the express module
const express = require("express")

//We need an object to represnt our express app
const app = express();

//Giving our port a value of 5000
const port =5000


//Creating route to point at index page



app.get("/api/customers" ,(req , res)=>
{
    //Hardcoded array
    const customers=[{
        "id":1,
        "name":"Tomi Ilori",
        "email":"Tomiilori123@gmail.com"
    },

    {
        "id":2,
        "name":"Tom Ilor",
        "email":"Tom@gmail.com"
    },

    {
        "id":3,
        "name":"jim Steff",
        "email":"jim123@gmail.com"
    }]
    
    res.json(customers)
})




///This tells the application to listen on the value of whatwvwer we assigned to port
app.listen(port , ()=>
{
    console.log(`Server Started on port ${port}`)
})