const express = require("express")
const router = express.Router()
const User = require("../../Models/user")
const Entry = require("../../Models/Entry")
const AFFIN = require("../../Sentiment/AFINN-111.json")

const MonkeyLearn = require('monkeylearn')
const pd = require('paralleldots');
pd.apiKey = "rVP1o1KSEQmPRvZTYOv71esPwFmxlZJ2yGv0P3o21Os";
const ml = new MonkeyLearn('7607d89b56eac6e67a52706e684d56854bf22a11')
let model_id = 'cl_pi3C7JiL'




router.post("/Entries/add" , (req , res) =>
{
    const {title , body , author , date , e_id , stitle}  = req.body


        //Change text into json string
        var text_array=JSON.stringify([body]);
    
        //First Algorithm gets emotion for the content
         pd.emotionBatch(text_array,'en')
        .then((response) => 
        {
          let data = JSON.parse(response)
          let emotions = data.emotion[0]
          let emotionFound=getHighestEmotion(emotions , 1)
              //Second algorithm gets sentiment and confidence
          
          let data1 = [body]
          ml.classifiers.classify(model_id, data1).then(res => {

            const newEnt = new Entry()

            newEnt.Title = title
            newEnt.SubTitle = stitle
            newEnt.Body = body
            newEnt.Author = author
            newEnt.Date = date
            newEnt.E_id = e_id
            newEnt.DateTime = new Date()
            newEnt.Sentiment_Score = res.body[0].classifications[0].confidence *100
            newEnt.Sentiment= res.body[0].classifications[0].tag_name
            newEnt.Sentiment_Emotion = emotionFound

            newEnt.save()
            .then(ent => console.log("entry saved"))

          })
    
         
    })

})


router.get("/Entries/getEntries/:email" , (req , res)=>
{

    Entry.find({Author:req.params.email})
    .sort({"DateTime" :-1})
    .then(ent =>res.json(ent))

})

router.get("/Entries/getEntry/:id" , (req, res) =>
{
    Entry.findOne({E_id:req.params.id})
    .then(ent => res.json(ent))
})


router.get("/Entries/delEntry/:id" , (req, res) =>
{
    Entry.findOne({E_id:req.params.id})
    .then(ent => ent.remove())
})

router.post("/Entries/saveEntry/:id" , (req, res) =>
{
    Entry.findOne({E_id:req.params.id})
    .then(ent => 
        {
        ent.Title=req.body.title,
        ent.SubTitle=req.body.stitle,
        ent.Body = req.body.body

        ent.save()
    }
        )
        console.log("entry updated")
})


router.get("/Entries/getED/:email" , (req, res)=>
{
    var ed = 
    {
        postive:0,
        negative:0,
        neutrual:0
    }

    Entry.find({Author:req.params.email})
    .then(ent =>
        {
            
            ent.forEach(entry => {
               
                if(entry.Sentiment == false)
                {
                    ed.negative+=1
                }
                else if(entry.Sentiment == true)
                {
                    ed.postive+=1
                }
                else if(entry.Sentiment == null)
                {
                    ed.neutrual+=1
                }
            });
            console.log(ed.negative)
            console.log(ed.postive)
            res.json(ed)
        }
       
    )
})


function getHighestEmotion(obj ,n)
{
    var keys = Object.keys(obj);
    keys.sort(function(a,b){
        return obj[b] - obj[a];
      })
      return keys[0];
}




module.exports = router