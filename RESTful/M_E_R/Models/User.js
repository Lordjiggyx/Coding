//Requiring Mongoose
const mongoose = require("mongoose")


//User Scehema for user fields

const UserSchema = new mongoose.Schema(
    {
        name:{
            type:String,
            required :true
        },
        email:{
            type:String,
            required :true
        },
        username:{
            type:String,
            required :true
        },
        password:{
            type:String,
            required :true
        }
        
    }
)

let User = mongoose.model("User" , UserSchema)

module.exports = User