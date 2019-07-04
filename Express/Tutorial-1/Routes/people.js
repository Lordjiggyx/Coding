const express = require('express')
const route = express.Router();


route.get("/" , (req , res)=>
{
    res.send('/ being hit')
})

route.get("/example" , (req , res)=>
{
    res.send('/ example being hit')
})


module.exports = route