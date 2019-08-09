//Brininging in the express module
const express = require("express")

//Creating express router 
const router = express.Router()

//user model
const User = require("../Models/User")

//bringing in bcrypt
const bcrypt = require("bcrypt")

//Bringing in passport
const passport = require("passport")


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
router.get("/getUser" , (req , res)=>
{
    User.find()
    .then(item =>res.send(item))
})


//Route for making registration post request === esstentially acting like a method
router.post("/register", (req,res)=>
{
    //de-structuring
   const {name , email , password , password2} = req.body
   console.log(password)

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
if(password.length <6 )
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
  
    //Validation passed
    User.findOne(
        {
            
            email:email
        }
    )
    .then(user =>
        {
            //User with same passwword exists
            if(user)
            {
                //passing on a message to  indicate exitsting user
                errors.push({
                    msg: "User with this email already exists"
                })
                //Re rendering the form
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
                //Creating a new user
                const newUser = new User({
                    name,
                    email,
                    password
                })
               
                console.log(newUser)

                //Hash passowrd

                bcrypt.genSalt(10 , (err ,salt)=>
                {
                bcrypt.hash(newUser.password , salt ,(err , hash)=>{
                   if(err)
                  throw err

                  //set passowrd to hashed
                  newUser.password =hash
                  //save User
                  newUser.save()
                  .then(user=>
                    {
                        //creating the success message 
                        req.flash('success_msg','You have been registered and can now log in!!!!!')
                       // req.flash('success_msg','You are now registered and can log in');
                        //redirecting the user to the login page
                        res.redirect("/users/login")
                        console.log(req.flash("success_msg"))
                    })
                  .catch(err =>
                    {
                        throw err
                    })
                        
                    })
                })
            }
           
        })
}

})


//Route to handle login
router.post('/login', (req, res, next) => {
    //Calling the authenticate method on the passport object
    //Passing in lcila as our localStrategy
    passport.authenticate('local', {
    //Success redirect is the page you wnat to go to if the the login is successful
      successRedirect: '/dashboard',
      //Failure redirect is the page you want to go to if the login is failed
      failureRedirect: '/users/login',
      //This is the flash message that is dsiplayed when a failure occurs
      failureFlash: true
    })(req, res, next);
    //These are parameters that are meant to be included as req.login is used to establish a sesison
  });

//Logout route
router.get("/logout" , (req , res)=>
{
    req.logout()
    req.flash("success_msg" , "You are Logged out")
    res.redirect("/users/login")
})


//Maling  pages accesible
module.exports = router
