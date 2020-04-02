const mongoose = require("mongoose")


const ExcerciseSchema  = new mongoose.Schema({

    Name:
    {
        type:String
    },
    Description:
    {
        type:String
    },
    Category:
    {
        type:String
    },

    Rating:{
        type:String
    }


})

//Createing a User Object to be manipulated based on the scehma
let Excercise = mongoose.model("Excercise" , ExcerciseSchema)

//Exporting the user object
module.exports = Excercise