//Brininging in the express module
const express = require("express")

//Creating express router 
const router = express.Router()


//Route for login page
router.get("/login" , (req , res)=>
{
    res.render("login")
})

//Route for registeration page
router.get("/register" , (req , res)=>
{
    res.render("register")
})


//Route for making registration post request === esstentially acting like a method
router.post("/register", (req,res)=>
{
    //de-structuring
   const {name , email , password , password2} = req.body

//===Validation===///

let errors = []

//required fields
if(!name || !email || !password || !password2)
{
    errors.push({
        msg: "Please fill in all fields"
    })
}

//Passwords match
if(password !== password2)
{
    errors.push({
        msg: "passwords dont match"
    })
}

//Check pssword lenght
if(password.lenght <6 )
{
    errors.push({
        msg: "Password should be 6 characters"
    })

}

//if there is an issue we will re render the regiseter form
if(errors.length > 0)
{
    res.render("register" , 
    {
        errors,
        name,
        email,
        password,
        password2

    })
}
else
{
    res.send("pass")
}

})

//Mkaing index page accesible

module.exports = router
