//Bringing config and jwt
const config = require("config")
const jwt = require("jsonwebtoken")

//midlleware function - gets token a


//takes in req res and next
function auth(req , res ,next)
{
    //Variable to represent sent token which is stored in the header value in the request object whihc is x-auth-token
    const token = req.header("x-auth-token")

    //Check for token

    if(!token)
    
        //sending a 401 status - whihc means that you don not have the correct authorizations
       return res.status(401).json({msg: "No Token Acesss Denied"})

try{
        //if there is a token we need to verify it we create a vvariable called decoded which called the jwt.verify method on the token and this also takes in the jwt secret
        const decoded = jwt.verify(token , config.get("jwtSecret"))

        //We wnat to take the user from the token and place this in req.user
        //add user from payload 
        req.user = decoded
        //finally we call next
        next()}
        catch(e)
        {
            //bad request
            res.status(400).json({msg: "Token Invalid "})
        }
    
}

//exporting the module 
module.exports = auth