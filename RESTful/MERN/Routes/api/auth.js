//Bringing in express
const express = require("express")
//Using express router 
const router = express.Router()
//User model
const User = require("../../Models/User")

//Congi
const config = require("config")

//JWT
const jwt = require("jsonwebtoken")

//Bcrypt
const bcrypt = require("bcrypt")

//auth middleware
const auth = (require("../middleware/auth"))

//Route to authenticate the user 
router.post("/" , (req , res) =>
 {
    const {email , password} = req.body

     //Validation

   //required fields
   if( !email || !password)
   {
       return res.status(400).json({msg:"Please Enter All Fields"})
   }



   // check for user by email
   User.findOne({email:email})
   .then(user =>
    {
        //If there is no user we'll display a message indciating the use rodes not exist
        if(!user)
        {
                return res.status(400).json({msg:"User Does not exist"})
        }

        //Rtaher then generatring a hash we will compare the plain text password in the req.body to the hashed password in the DB

        //Validate Password
        
        //We call the bcrypt compare method  this takes in our plain text password and the sotred hased password 
        bcrypt.compare(password , user.password)
        //This returns a promise and gives us a boolean which we will call Match
        .then(Match =>
            {
                //If the password does not match we will send a response indicated the passwords do not match
                if(!Match)
                {
                    return res.status(400).json({msg:"Invalid Credentils"})
                }
                //If the passowrd matches we send the user and the token
                else
                {
                    //Cretaing a JWT token
            jwt.sign(
                //Passing in user id as a payload
                {id:user.id},
                //jwt secert
                config.get("jwtSecret"),
                //Toke expires in 30 minutes
                {expiresIn:1800},
                //callback
                (err , token) =>
                    {
                        if
                        (err) throw err
                         //Just sending the respnse of the user object and a token
                        res.json({
                            token,
                            user:{
                                id:user.id,
                                name: user.name,
                                email:user.email
             
                            }
                        })
                    }
            
            )
                }

            })
   
        }
   )
    })


//Gets user data from token
router.get("/auth",auth ,(req , res)=>
{
    //find the user by passing in the user id from the req.user object
    User.findById(req.user.id)
    //We do not want the password so we can use .select()
    .select("-password")
    //This will send a promise with the user and we will send a response of the user object
    .then(user =>res.json(user))
})

module.exports = router





