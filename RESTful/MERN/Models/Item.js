//Requiring Mongoose
const mongoose = require("mongoose")


//Item Scehema for Item fields

const ItemSchema = new mongoose.Schema(
    {
        name:{
            type:String,
            required :true
        },
        Date:{
            type:Date,
            default:Date.now
        }
       
        
    }
)

let Item = mongoose.model("Item" , ItemSchema)

module.exports = Item