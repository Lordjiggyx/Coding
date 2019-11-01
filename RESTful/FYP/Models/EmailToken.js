//Requiring Mongoose
const mongoose = require("mongoose")


//User Scehema for user fields
const EmailTokenSchema = new mongoose.Schema(
    {
        userId: 
        {
            type: mongoose.Schema.Types.ObjectId,
            required: true,
            ref: 'users'
         },
        token:
         { 
            type: String,
            required: true 
        },
        createdAt: {
            type: Date,
            required: true,
            default: Date.now,
            expires: 43200 
            }
    }

)

//Createing a User Object to be manipulated based on the scehma
let ET = mongoose.model("EmailToken" , EmailTokenSchema)

//Exporting the user object
module.exports = ET