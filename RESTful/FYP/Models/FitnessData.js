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
        CaloriesRemaing:
        {
            type:Number
        },
        DateSet:
        {
            type:String
        },
        dailyInfo:[{type:Number}]
        
    }
)
let FitnessData = mongoose.model("FitnessData" , FDSchema)

//Exporting the user object
module.exports = FitnessData