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

//Route to register/create a user
router.post("/register" , (req , res) =>
 {
    const {name , email , password} = req.body

     //Validation

   //required fields
   if(name ==" "|| email == " " || password == " ")
   {
       return res.status(400).json({msg:"Please Enter All Fields"})
   }



   // check for user by email
   User.findOne({email:email})
   .then(user =>
    {
        //If user exists dispaly user exists mesage
        if(user)
        {
                return res.status(400).json({msg:"User Already Exists"})
        }
        //if user does not exist create new user with user variables name email and password
        else
        {
            const newUser = new User
            (
                {
                    name , email , password
                }
            )

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

            //Cretaing a JWT token
            jwt.sign(
                {id:user.id},
                config.get("jwtSecret"),
                {expiresIn:1800},
                (err , token) =>
                    {
                        if
                        (err) throw err
                         //Just sending the respnse of the user object
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
        })
      .catch(err =>
        {
            throw err
        })
            
        })
    })
        }
    }
   )
})

module.exports = router





