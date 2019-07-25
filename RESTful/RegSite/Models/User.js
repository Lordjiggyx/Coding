//Requiring Mongoose
const mongoose = require("mongoose")


//User Scehema for user fields

const UserSchema = new mongoose.Schema(
    {
        name:{
            type:String,
            required :True
        },
        email:{
            type:String,
            required :True
        },
        Passowrd:{
            type:String,
            required :True
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