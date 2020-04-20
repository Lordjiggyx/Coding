const express = require("express")
const router = express.Router()
const User = require("../../Models/user")
const Event = require("../../Models/Event")

router.post("/Events/addEvent/:email" , (req,res)=>
{
    const {id , title , start , end  , importance  , content} = req.body.event

    const newEvent = new Event()

    newEvent.Title = title
    newEvent.E_id = id
    newEvent.Body = content
    newEvent.StartDate = start
    newEvent.EndDate = end
    newEvent.Importance = importance
    newEvent.Email = req.params.email

    newEvent.save()
    .then(ent =>
        {
            console.log("Entry Saved")
            console.log(ent)
        })

})

router.get("/Events/getAll/:email" , (req , res)=>
{
    Event.find({Email:req.params.email})
    .then(events => res.json(events))
})

router.get("/Events/remove/:id" , (req , res)=>
{
    
    Event.findOne({E_id:req.params.id})
    .then(eve => eve.remove())
})

router.post("/Events/edit/:id" , (req , res)=>
{
    const {start , end  } = req.body.event
    Event.findOne({E_id:req.params.id})
    .then(eve => 
        
        {
            eve.StartDate = start
            eve.EndDate = end
            eve.save()
        })
})

router.post("/Events/editFull/:id" , (req , res)=>
{
    const {start , end , title , importance  } = req.body.event
    console.log(start)
    Event.findOne({E_id:req.params.id})
    .then(eve => 
        
        {
            eve.StartDate = start
            eve.EndDate = end
            eve.Title = title
            eve.Importance = importance
            eve.save()
        })
})

router.post("/Events/saveGC/:email" , (req,res)=>
{
    User.findOne({Email:req.params.email})
    .then(user=>
        {
            console.log(user)
            // user.GcSync = true;
            // user.gcEmail =req.body.data.email
            user.set("Gcsync" , true)
            user.set("gcEmail" , req.body.data.email)
            user.save()
            console.log(user)
        }
    )
})


module.exports = router