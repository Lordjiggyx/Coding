//requiring mongoose modules
const mongoose = require("mongoose")

//Book Schema
const booksSchema = mongoose.Schema(
    {
        title:
        {
            type:String,
            required:true
        },
        generes:
        {
            type:String,
            required:true
        },
        description:
        {
            type:String,
            
        },
        Author:
        {
            type:String,
            required:true
        },
        Publisher:
        {
            type:String,
          
        },
        Pages:
        {
            type:String,
            
        },
        image_url:
        {
            type:String,
            required:true
        },
        buy_url:
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
const book = module.exports = mongoose.model("Book" ,booksSchema)

//Get books module
module.exports.getBooks = function(callback , limit)
{
    book.find(callback).limit(limit)
}

//Get a single book
module.exports.getBookById = function(id,callback )
{
    book.findById(id , callback)
}

//Adding a book
module.exports.addBook =function(callback)  {
	book.create(callback);
}