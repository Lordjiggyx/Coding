//requiring mongoose modules
const mongoose = require("mongoose")

//Genre Schema
const generesSchema = mongoose.Schema(
    {
        name:
        {
            type:String,
            required:true
        },
        create_date:
        {
            type:Date,
            default:Date.now
        }
    }
)

//exportable object
const genere = module.exports = mongoose.model("Genere" ,generesSchema)

//Get generes module
module.exports.getGeneres = function(callback , limit)
{
    genere.find(callback).limit(limit)
}