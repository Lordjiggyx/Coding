const express = require("express")
const router = express.Router()
const User = require("../../Models/user")
const Entry = require("../../Models/Entry")
const AFFIN = require("../../Sentiment/AFINN-111.json")




router.post("/Entries/add" , (req , res) =>
{
    const {title , body , author , date , e_id , stitle}  = req.body

    const newEnt = new Entry()
    
    var score = analyzeText(body)

    newEnt.Title = title
    newEnt.SubTitle = stitle
    newEnt.Body = body
    newEnt.Author = author
    newEnt.Date = date
    newEnt.E_id = e_id
    newEnt.Sentiment_Score = score
    newEnt.DateTime = new Date()
    //If score is greater than 0 user entry is marked true = postive
    if(score>0)
    {
        newEnt.Sentiment= true
    }
    //If score is less than 0 user entry is marked false = negative
    else if(score<0)
    {
        newEnt.Sentiment=false
    }
    else if(score == 0)
    {
        newEnt.Sentiment=null
    }

    newEnt.save()
    .then(ent =>
        {
            console.log("entry created")
            
        })

})


router.get("/Entries/getEntries/:email" , (req , res)=>
{
    console.log(req.params)
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

//Sentiment methods
function tokenize(text)
{
    return text
    .toLowerCase()
    .split(" ");
}

function deleteUselessWords(word)
{
    return word.replace(/[|&;$%@"<>()+,]/g, "");
}

function rateWord(word)
{
    return (word in AFFIN ) ? AFFIN[word] : 0
}

function sumText(x , y)
{
    return x+y;
}

function analyzeText(text)
{
    return tokenize(text)
    .map(deleteUselessWords)
    .map(rateWord)
    .reduce(sumText)
}


module.exports = router