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
        password:{
            type:String,
            required :true
        },
        date:{
            type:Date,
            //This creates a default value for the date if it is not set
            default :Date.now
        }
    }
)

const User = mongoose.model("User" , UserSchema)

module.exports = User