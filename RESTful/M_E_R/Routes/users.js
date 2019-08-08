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



//Route to registration form 
//Route for registeration page
router.get("/users/register" , (req , res)=>
{
    res.render("reg.pug")
    console.log("page live")
})


router.post("/users/register", (req,res)=>
{
    //de-structuring
   const {name , email ,username, password , password2} = req.body


   //Validation

   //required fields
    if(!name || !email || !username|| !password || !password2)
    {
        req.flash("danger" ,"All fields must be filled")
        res.render('reg.pug')
    }
   //Password Matches
   else if(password !== password2)
   {
    req.flash("danger" ,"Passwords do not match please try again")
    res.render('reg.pug')
   }
  else
  {
    const newUser = new User({
        name:name,
        email:email,
        username:username,
        password:password
    })
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
            req.flash('success','You have been registered and can now log in!!!!!')
           // req.flash('success_msg','You are now registered and can log in');
            //redirecting the user to the login page
            res.redirect("/users/login")
            console.log(req.flash("success"))
        })
      .catch(err =>
        {
            throw err
        })
            
        })
    })
  }
})

router.get('/users/login' , (req , res)=>
{
    res.render("login.pug")
})

//Route for login process

router.post('/users/login', (req, res, next) => {
    //Calling the authenticate method on the passport object
    //Passing in local as our localStrategy
    passport.authenticate('local', {
        if(successRedirect = true)
        {
          req.flash("success" , "Login")
        },
    //Success redirect is the page you wnat to go to if the the login is successful
      successRedirect: '/',
      //Failure redirect is the page you want to go to if the login is failed
      failureRedirect: '/users/login',
      //This is the flash message that is dsiplayed when a failure occurs
      failureFlash: true,

     
    })(req, res, next);
    //These are parameters that are meant to be included as req.login is used to establish a sesison
   
  });

  //Logout route
router.get("/users/logout" , (req , res)=>
{
    req.logout()
    req.flash("success_msg" , "You have Logged out")
    res.redirect("/users/login")
})


module.exports = router