//Passportv variavble
const LocalStrategy = require("passport-local").Strategy

//Bring in config as we need to connect to DB
const config= require("../config/database")

//Bring in bcrypt as we need to decrypt our passwords
const bcrypt = require("bcrypt")

//Bring in The user model to access user parameters
const User = require("../Models/User")

module.exports = function(passport)
{
    passport.use(
        new LocalStrategy(
            (username , password , done)=>
            {
                let query = {username:username}
            //Take user model and find a user using findOne
            //pass in the query and the callback which will tak in err and user
            User.findOne(query , (err , user)=>
            {
               //checking if there is an error and throwing if there is
               if(err)
               throw err
               //If there is no user we will return done with null and false and we can create a message indicating that the user hasn't been found
               if(!user)
               {
                   return done(null , false, 
                   {
                       message:"User Not Found"
                   })
               }

               //Match the password
               //We arew passing in the password of the client input and conmparing this to the password found in the user object that was found 
               //A function will happen and this will take in error or and a true or false value being is match
               bcrypt.compare(password , user.password , (err ,isMatch)=>
               {
                   //checking if there is an error and throwing if there is
                   if(err)
                   throw err

                   //If the passowrd mathces we return done with null for the error and the matching user object
                   if(isMatch)
                   {
                       return done(null , user , {message :"Successful Login"})
                   }
                   else
                   //If the user is found but the passowrd is wrong we give a messgae 
                   {
                       return done(null , false , {message:"Wrong Passowrd "})
                   }
               })

            })
            }
        )
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