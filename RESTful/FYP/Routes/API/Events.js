const express = require("express")
const router = express.Router()
const User = require("../../Models/user")
const Event = require("../../Models/Event")
var messagebird = require('messagebird')("nDOG8S1CCzJZEpO7A2yYqp1V3");
const moment = require("moment")


router.post("/Events/addEvent/:email" , (req,res)=>
{
     const {id , title , start , end  , importance  , content} = req.body.event

    const newEvent = new Event()

  


    User.findOne({Email:req.params.email})
    .then(user =>
        {


            newEvent.Title = title
            newEvent.E_id = id
            newEvent.StartDate = start
            newEvent.EndDate = end
            newEvent.Importance = importance
            newEvent.Email = req.params.email
        
            newEvent.save()
            .then(ent =>
                {
                    console.log("Entry Saved")
 
                    var EventReminderStart = moment(req.body.StartDate).add({hours:1 , minutes:2})
                    var rem = EventReminderStart.clone().subtract({hours:1})

                    console.log(EventReminderStart)
                    console.log(rem)

                    messagebird.messages.create({
                        originator:"Ponc.ie",
                        recipients:[user.Phone],
                        scheduledDatetime :rem.format(),
                        body:`Hi ${user.FirstName} here's a reminder that you have the following event "${newEvent.Title}" scheduled for ${EventReminderStart.format("HH:mm")} see you soon`
                    },function(err,response)
                    {
                        console.log(err)
                        
                    })

                    });
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
    //find user
    User.findOne({Email:req.params.email})
    .then(user=>
        {
            
            console.log(req.body)
            //Add attributes to indicate user has a google account synced
            user.set("Gcsync" , true)
            user.set("gcEmail" , req.body.data.email)
            //Updated user
            user.save()
            
        }
    )
})


module.exports = router