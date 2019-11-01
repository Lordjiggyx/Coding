//Requiring Mongoose
const mongoose = require("mongoose")


//User Scehema for user fields
const UserSchema = new mongoose.Schema(
    {
        FirstName:{
            type:String,
        },
        LastName:{
            type:String,
        },
        DOB:
        {
            type:Date,
            default:null
        },
        Email:{
            type:String,
            unique:true
        },
        Password:{
            type:String,
        },
        Height:
        {
            type:Number,
            default:null
        },
        Weight:
        {
            type:Number,
            default:null
        },
        Ethnicity:
        {
            type:String,
            default:null
        },
        Activity_Level:
        {
            type:String,
            default:null
        },
        Cancer_Type:
        {
            type:String,
            default:null
        },
        Smokes:
        {
            type:Boolean,
            default:false
        },
        Verified:
        {
            type:Boolean,
            default:false
        }
    }

)

//Createing a User Object to be manipulated based on the scehma
let User = mongoose.model("User" , UserSchema)

//Exporting the user object
module.exports = User