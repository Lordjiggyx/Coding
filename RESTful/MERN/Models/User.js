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
            required :true,
            unique:true
        },
        password:{
            type:String,
            required :true
        },
        RegDate:
        {
            type:Date,
            default:Date.now()
        }
        
    }
)

let User = mongoose.model("User" , UserSchema)

module.exports = User