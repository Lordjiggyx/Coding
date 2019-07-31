//Brininging in the express module
const express = require("express")

//Creating express router 
const router = express.Router()

//Bringing in authentication object in order to protect files
const {ensureAuthenticated} = require("../Config/auth")

//Route for the index page 
router.get("/" , (req , res)=>
{
    res.render("welcome")
})

//route for index page upon login
//we passsed in the ensureAuthenticated to protect the page from being accesse without login
router.get('/dashboard',  (req, res) =>
{
  res.render('dashboard', 
  {
    user: req.user
  })
}
  
);

//Mkaing index page accesible

module.exports = router