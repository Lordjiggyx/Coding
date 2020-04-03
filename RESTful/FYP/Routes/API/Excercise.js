//Bringing in express
const express = require("express")
//Using express router 
const router = express.Router()
const User = require("../../Models/user")
const Excercise = require("../../Models/Excerise")

router.post("/excercise/add" , (req,res)=>
{
    const{name , desc , cat , rate , createdBy} = req.body

    const newExc = new Excercise();

    newExc.Name = name;
    newExc.Description = desc;
    newExc.cat = cat;
    newExc.Rating = rate
    newExc.CreatedBy = createdBy

    newExc.save()
    .then(exc =>
        {
            console.log("Excercise added")
            return res.status(200).json({msg:"Success"})
        })
})

module.exports = router