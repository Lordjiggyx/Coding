//Passportv variavble
const LocalStrategy = require("passport-local").Strategy

//Bring in mongoose as we need to connect to DB
const mongoose= require("mongoose")

//Bring in bcrypt as we need to decrypt our passwords
const bcrypt = require("bcrypt")


//Bring in The user model to access user parameters
const User = require("../Models/User")



//Export the strategy
module.exports = function(passport)
{
    passport.use(
        new LocalStrategy(
            {
            usernameField:"email"
            },
            (email , password , done)=>
            {
                //Matching The user by email
                User.findOne({email:email})
                .then(user =>
                {
                    //If there is no user
                    if(!user)
                    {
                        return done(null , false, 
                        {
                            message:"That email Is not registered"
                        })
                    }
                     //Matching the password
                
                //Calling the compare method on the bcrypt object
                bcrypt.compare(password , user.password , (err ,isMatch)=>
                {
                    //checking if there is an error and throwing if there is
                    if(err)
                    throw err

                    //If the passowrd mathces we return done with null for the error and the matching user object
                    if(isMatch)
                    {
                        return done(null , user)
                    }
                    else
                    {
                        return done(null , false , {message:"The password does not match "})
                    }
                })
                })
                
               
                
               
            })
    )
      //Explanation in notes.txt creates sessions
      passport.serializeUser(function(user, done)
      {
      done(null, user.id);
      });

passport.deserializeUser(function(id, done) 
  {
      User.findById(id, function(err, user)
          {
          done(err, user);
          });
  })
  
}
