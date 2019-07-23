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
//add generes module
module.exports.addGenere =function(callback)  
{
	genere.create(callback);
}
//update generes module
module.exports.updateGenere =function(id, genereObject, callback)  
{
    let query = {_id:id}
    let update = {
        name:genereObject.name
    }
	genere.findOneAndUpdate(query , update ,  callback);
}
//add generes module
module.exports.deleteGenere =function(id , callback)  
{
    let query = {_id:id}
	genere.remove(query , callback);
}