const mongoose = require("mongoose")

const EntrySchema = new mongoose.Schema({
    Title:
    {
        type:String
    },
    SubTitle:
    {
        type:String
    },
    Body:
    {
        type:String
    },
    Author:
    {
        type:String
    },
    Date:{
        type: String
    },
    E_id:
    {
        type:Number
    },
    DateTime:
    {
        type:Date
    },
    Sentiment_Score:
    {
        type:Number
    },
    Sentiment:
    {
        type:Boolean
    }
})

let Entry = mongoose.model("Entry" , EntrySchema)

module.exports = Entry