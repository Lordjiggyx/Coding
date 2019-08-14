//Bringing in express
const express = require("express")
//Using express router 
const router = express.Router()

const Item = require("../../Models/Item")

//Route to rerieve all items 

router.get("/items" , (req , res)=>
{
    //Using the Item model to retrieve all items
    Item.find()
    //Using the sort method to sort all the items by date using -1 for decsending order
    .sort({date:-1})
    //Promise that returns items and we call a json response passing in the items data
    .then(item =>res.json(item))

    
   
})

//Route to Create an Item

router.post("/" , (req , res)=>
{
   const newItem = new Item(
       {
           name: req.body.name
       }
   )

   newItem.save()
   .then(item =>
    {
        res.json(item)
    })
    console.log("Page working")
})

//Route for deleting a post
router.delete("/:id" , (req , res)=>
{
    //Finiding the Item to delete by ID
   Item.findById(req.params.id)
   //This returns a promise which gives us trhe found item and then a callback of what we want to happen
   .then(item =>
    {
        //We want to use thr remove method on the model and then send a message saying the item was deleted
        Item.deleteOne()
        .then(()=> res.json({success:true}))
        //We then want a catch method this method will return an err and a callback this callback will return a 404 not found message and a messgae to indicate that there was an error
        .catch(err =>res.status(404).send("Error"))
    })
   
// console.log("Page Working")
})



module.exports = router




















