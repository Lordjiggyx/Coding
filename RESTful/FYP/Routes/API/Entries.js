const express = require("express")
const router = express.Router()
const User = require("../../Models/user")
const Entry = require("../../Models/Entry")
const axios = require("axios")


const natural = require("natural")
const aposToLexForm = require('apos-to-lex-form');
const SpellCorrector = require('spelling-corrector');
const spellCorrector = new SpellCorrector();
spellCorrector.loadDictionary();
const SW = require('stopword');




router.post("/Entries/add", async  (req , res) =>
{
    const {title , body , author , date , e_id , stitle}  = req.body

    const newEnt = new Entry()

   
    
    var score = getSentiment(body)

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

    Entry.find({Author:req.params.email})
    .sort({"DateTime" :-1})
    .then(ent =>res.json(ent))

})

router.get("/hellocall" , (req ,res)=>
{
    res.json({msg:"it worked"})
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
        positive:0,
        negative:0,
        neutrual:0,
        Sentiment:""
    }
    Entry.find({Author:req.params.email})
    .then(ent =>
        {
         
            
            ent.forEach(entry => {
               
                //False == negative
                if(entry.Sentiment == false)
                {
                    ed.negative+=1
                }
                //True == postive
                else if(entry.Sentiment == true)
                {
                    ed.positive+=1
                }
                //Null == neutrual
                else if(entry.Sentiment == null)
                {
                    ed.neutrual+=1
                }

                //Get Highest valued key
                var keys = Object.keys(ed);
                keys.sort(function(a,b){
                    return ed[b] - ed[a];
                  })
                  //Set sentiment to this keyy
                 ed.Sentiment= keys[0];

            });
            res.json(ed)
        }
       
    )
})


function getSentiment(body)
{
    //Convert text to lexicon
    const lexedBody = aposToLexForm(body);
    //Convert to lower case
    const casedBody = lexedBody.toLowerCase();
    //Remove non alphabetical characters
    const alphaOnlyBody = casedBody.replace(/[^a-zA-Z\s]+/g, '');

    //import tokenizer
    const { WordTokenizer } = natural;
    const tokenizer = new WordTokenizer();
    //Create a tokenized veriosn of the content from user
    const tokenizedBody = tokenizer.tokenize(alphaOnlyBody);

    //for each word corretc spelling
    tokenizedBody.forEach((word, index) => {
        tokenizedBody[index] = spellCorrector.correct(word);
      })

      //Remove stop words
      const filteredBody = SW.removeStopwords(tokenizedBody);

      //Import Sentiment analyser and Stemmer
      const { SentimentAnalyzer, PorterStemmer } = natural;
      //Create object to analyse text
      const analyzer = new SentimentAnalyzer('English', PorterStemmer, 'afinn');
      //Gets sentiment of filtered down text
      const analysis = analyzer.getSentiment(filteredBody);
      //returns value of sentiment
      return analysis
}





module.exports = router