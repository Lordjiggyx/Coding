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
            type:String,
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
            type:String,
            default:null
        },
        Weight:
        {
            type:String,
            default:null
        },
        Gender:
        {
            type:String,
            default:null
        },
        Verified:
        {
            type:Boolean,
            default:false
        }
        ,
        Cancer_Location:
        {
            type:String,
        },

        Cancer_Type:
        {
            type:String,
           
        },
        Phone:
        {
            type:String
        }
    
    },
    {strict:false}
)

//Createing a User Object to be manipulated based on the scehma
let User = mongoose.model("User" , UserSchema  )

//Exporting the user object
module.exports = User