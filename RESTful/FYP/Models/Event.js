const mongoose = require("mongoose")

const EventSchema = new mongoose.Schema({
    Title:
    {
        type:String
    },
    Duration:
    {
        type:String
    },

    Email:
    {
        type:String
    },
    E_id:
    {
        type:Number
    },
    StartDate:
    {
        type:Date
    },
    EndDate:
    {
        type:Date
    },
    url:
    {
        type:String
    },
    Importance:
    {
        type:String
    },
    ReminderDT:
    {
        
    }
} , {strict: false})

let Event = mongoose.model("Event" , EventSchema)

module.exports = Event