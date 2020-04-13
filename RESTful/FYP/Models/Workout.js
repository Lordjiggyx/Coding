const mongoose = require("mongoose")

const WorkoutSchema =  new mongoose.Schema({
    Date:{
        type: String
    },
    userId: 
        {
            type: mongoose.Schema.Types.ObjectId,
            required: true,
            ref: 'users'
    },
    Duration:
    {
        type:String
    },
    CaloriesBurned:{
        type:String
    },
    Excercise:
    {
        type:String
    }

})

let Workout = mongoose.model("Workout" , WorkoutSchema)

module.exports = Workout