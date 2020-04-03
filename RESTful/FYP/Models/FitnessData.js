//Requiring Mongoose
const mongoose = require("mongoose")

const FDSchema = new mongoose.Schema(
   { 
       userId: 
        {
            type: mongoose.Schema.Types.ObjectId,
            required: true,
            ref: 'users'
         },
        CalorieTarget:
        {
            type:Number
            
        },
        CaloriesBurned:
        {
            type:Number
        }
    }
)