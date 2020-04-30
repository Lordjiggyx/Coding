//Bringing in express
const express = require("express")
//Using express router 
const router = express.Router()
const mail = require("nodemailer")
const crypto = require("crypto")
// models
const User = require("../../Models/user")
const FitnessData = require("../../Models/FitnessData")
const ET = require("../../Models/EmailToken")
const request = require("request")
const cheerio = require("cheerio")
const brain = require("brain.js")
const natural = require("natural")
const fs = require('fs')
const path = require('path');
//const hbs = require("nodemailer-express-handlebars")
// const ch = require("../../Views/")


router.get("/users/getUser/:email" , (req , res)=>

{
    console.log(req.params)

     const{email} = req.params
    
    User.findOne({Email:email}).then(user=>
        {
            
           res.send(user)
        })
})

router.get("/users/hello" , (req , res)=>
{
    console.log("request Reavched");
 
    res.send("Hello")
})




router.post("/users/register" , (req ,res)=>
{
     const {firstName , lastName , email , password ,gender ,  DOB  , height , weight ,phone } =req.body
     console.log(req.body)

// const firstname = req.body.firstName
// const email = req.body.email

    const newUser = new User()


    newUser.FirstName = firstName
    newUser.LastName = lastName
    newUser.Email = email
    newUser.Password = password
    newUser.Gender=gender;
    newUser.Height = height;
    newUser.Weight = weight;
    newUser.DOB = DOB
    newUser.Phone = phone
    newUser.Cancer_Location = ""

   

    console.log("here")
    newUser.save()
    .then(user=>
        {
            const crypt = crypto.randomBytes(16).toString('hex')
            const host = req.get('host')
            const link = `http://${host}/Routes/API/users/verify?token=${crypt}&&Email=${user.Email}`

            const fitnessdata = new FitnessData(
                {
                    userId:user.id,
                    CalorieTarget:0,
                    CaloriesRemaing:0,
                    dailyInfo:[0,0,0,0,0,0,0]
                }
            )
            fitnessdata.save()

            RegToken = new ET(
                {
                    userId:user.id,
                    token:crypt
                }
            )

            RegToken.save()
            .then(err =>
                {
                    const transporter = mail.createTransport(
                        {
                            service:"gmail",
                            auth:{
                                user:"tomiiloriponc@gmail.com",
                                pass:"123."
                            }
                            
                        }
                    )      
        
                    const mailOptions = 
                    {
                        from:"tomiiloriponc@gmail.com",
                        to:user.Email,
                        subject:"Confirmation Email",
                        html:"Hello,<br> Please Click on the link to verify your email.<br><a href="+link+">Click here to verify</a>",
                        template:"email"
                    }
                    
                    transporter.sendMail(mailOptions, function(error, info){
                        if (error) {
                          console.log(error);
                        } else {
                          console.log('Email sent: ' + info.response);
                        }
                      });
                })

            console.log("User Added")
            return res.status(400).json({msg:`User:${user.FirstName} Has Been Created Check Email to verify account`})
        }).catch((err)=>
        {
            console.log(err)
        })

        


})

//Need to reverse 
// Find user first based off email passed in through req.query.Email
//then find token and see if there is a token that has a user id that matches the user id coming in
//if user token found verify user else display user not found
router.get("/users/verify/", (req , res)=>
{
    console.log(req.query.token)
    console.log(req.query.Email)
    
    //Search for Email token in V link
    ET.findOne(
        {
            token:req.query.token
        }
    )
    .then(token=>
        {
            //Token not found
            if(!token)
            {
                return res.status(400).json({msg:`Token Not Found`})
            }
            else
            {
                //Search for User with email in V link
                User.findOne({
                    Email:req.query.Email
                })
                .then(user=>
                    {
                        //User not found
                        if(!user)
                        {
                            return res.status(400).json({msg:`User Not Found`})
                        }
                        else
                        {
                            //Updated user verified value to true 
                            user.Verified = true
                            user.save()
                            return res.status(400).json({msg:`Account Verfied Proceed to Login`})
                        }
                    })
            }
        })
})


router.post("/users/login" , (req,res)=>
{
    console.log(req.body)
    const { email , password} =req.body

    User.findOne({Email:email})
    .then(user=>
        {
            if(!user)
            {
                console.log("User Does not exist")
               res.status(400).json({msg:"User Does not exist"})
                
            }
            if(password === user.Password)
            {
                
            }
            if(password != user.Password)
            {
                console.log("Invalid credientials")
                return res.status(400).json({msg:"Invalid credientials"})
            }
            if(user.Verified ==false) 
            {
                console.log("Account Not verified please Check Email and verify")
                return res.status(400).json({msg:"Account Not verified please Check Email and verify"})
            }
            else
            {
                console.log("User Logged In")
                return res.status(400).json(
                    {msg:"User Account Verified Logging in....."})
            }

        })
})

router.post("/users/update/:email",(req,res)=>
{

    console.log(req.body)
    const {dob , height , weight , firstname ,lastname, gender ,email ,password , phone} = req.body
    

    User.findOne({Email:req.params.email})
    .then(user=>
        {
            user.FirstName = firstname,
            user.LastName = lastname,
            user.DOB = dob,
            user.Weight=weight,
            user.Height=height,
            user.Password=password,
            user.Gender=gender,
            user.Email=email,
            user.Phone = phone
            user.save()
        })

})

router.post("/users/setCancer/:email",(req,res)=>
{

    console.log(req.body)
    const {location } = req.body
    

    User.findOne({Email:req.params.email})
    .then(user=>
        {
            user.Cancer_Location=location
            user.save()
        })

})


router.get("/users/delete/:email" , (req , res)=>
{
    User.findOne({Email:req.params.email})
    .then((user=>
        {
            user.remove()
            console.log("User Removed")
        }))

    // console.log(req.params)
    // User.findOneAndDelete({})
    // res.send("User Deleted")
})



router.get("/users/tumorDef/:type", (req , res)=>
{
    //User cancer type
    tumor = req.params.type.toLowerCase()
    //request made ro irish cancer society
    request(`https://www.cancer.ie/cancer-information-and-support/cancer-types/${tumor}-cancer`,(error , response , html)=>
    {
        //if there is no error
        if(!error && response.statusCode==200)
        {
            //dollar sign variable acts as it would in JQuery allowing me to manipulate the dom
            const $ = cheerio.load(html)
           
            

        //Find h3 tags
        $("h3" ).each((i , el)=>
        {
            //The first h3 element contained the information i need
           if(i == 0){
            //Two pieces if information are taken from the next elements
            const def1 = $(el).next().text()
            const def2 = $(el).next().next().text()
            //content stored in an object
            const definitons = {
                def1:def1,
                def2:def2
            }
            //object sent back to front end
            res.send(definitons)
    }
        })

        
        }
    })
})


router.get("/users/getGenes/:type", (req , res)=>
{
    tumor = req.params.type
   
    const net = new brain.recurrent.LSTM()

    net.train([
       { input:"Breast" ,output:["TP53 " , "KMT2C " ,"PIK3CA " , "GATA3 " , "CDH1 "]},
       { input:"Bladder" ,output:["TP53 " , "KDM6A " ,"PIK3CA " , "KMT2D " , "ARID1A "]},
       { input:"Prostate" ,output:["TP53 " , "SPOP " ,"AR " , "FOXA1 " , "KMT2D "]},
       { input:"Skin" ,output:["BRAF " , "NRAS " ,"FAT3 " , "CDKN2A " , "PTPRB "]},
       { input:"Lung" ,output:["TP53 " , "KRAS " ,"KEAP1 " , "EGFR " , "STK11 "]},
       { input:"Pancreas" ,output:["KRAS " , "TP53 " ,"SMAD4 " , "CDKN2A " , "ARID1A "]},
       
    ],{iterations:200})


    const output = net.run(tumor)

    const { WordTokenizer } = natural;
    const tokenizer = new WordTokenizer();
    const genes = tokenizer.tokenize(output);

    
    console.log(genes)
    res.send(genes)
})


router.get("/users/getGeneData/:type", (req , res)=>
{
    tumor = req.params.type
   
    
   let folderPath = `C:/Users/ilori/Desktop/Tomi/Coding/RESTful/FYP/Data/${tumor}.csv`

   const csv=require('csvtojson')
    csv()
    .fromFile(folderPath)
    .then(jsonObj=>{
    
       res.send(jsonObj)
})
 
})





module.exports = router
