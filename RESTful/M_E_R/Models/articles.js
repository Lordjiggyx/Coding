//requiring mongoose modules
const mongoose = require("mongoose")

let articleSchema = mongoose.Schema(
    {
        Title:
        {
            type:String,
            required:true
        },
        Author:
        {
            type:String,
            required:true
        },
        Body:
        {
            type:String,
            required:true
        }
    }
)

let Article = module.exports = mongoose.model('Article' , articleSchema)