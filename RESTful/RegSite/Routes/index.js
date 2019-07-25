//Brininging in the express module
const express = require("express")

//Creating express router 
const router = express.Router()



//Route for the index page 
router.get("/" , (req , res)=>
{
    res.render("welcome")
})



//Mkaing index page accesible

module.exports = router