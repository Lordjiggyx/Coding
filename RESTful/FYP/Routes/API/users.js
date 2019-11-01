//Bringing in express
const express = require("express")
//Using express router 
const router = express.Router()
const mail = require("nodemailer")
const crypto = require("crypto")
// models
const User = require("../../Models/user")
const ET = require("../../Models/EmailToken")


router.get("/getUsers" , (req , res)=>
{
    User.find({}).then(user=>
        {
            res.send(user)
        })
})

router.post("/register" , (req ,res)=>
{
    const {FirstName , LastName , Email , Password} =req.body

    const newUser = new User()


    newUser.FirstName = FirstName
    newUser.LastName = LastName
    newUser.Email = Email
    newUser.Password = Password

    newUser.save()
    .then(user=>
        {
            const crypt = crypto.randomBytes(16).toString('hex')
            const host = req.get('host')
            const link = `http://${host}/Routes/API/verify?token=${crypt}&&Email=${user.Email}`
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
                                pass:"Lordjiggy123."
                            }
                            
                        }
                    )
        
                    const mailOptions = 
                    {
                        from:"tomiiloriponc@gmail.com",
                        to:user.Email,
                        subject:"Confirmation Email",
                        html:"Hello,<br> Please Click on the link to verify your email.<br><a href="+link+">Click here to verify</a>"
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

router.get("/verify/", (req , res)=>
{
    console.log(req.query.token)
    //console.log(req.query.Email)
    

    ET.findOne(
        {
            token:req.query.token
        }
    )
    .then(token=>
        {
            if(!token)
            {
                return res.status(400).json({msg:`Token Not Found`})
            }
            else
            {
                User.findOne({
                    Email:req.query.Email
                })
                .then(user=>
                    {
                        if(!user)
                        {
                            return res.status(400).json({msg:`User Not Found`})
                        }
                        else
                        {
                            user.Verified = true
                            user.save()
                            return res.status(400).json({msg:`Account Verfied Proceed to Login`})
                        }
                    })
            }
        })
})


router.post("/login" , (req,res)=>
{
    const { Email , Password} =req.body

    User.findOne({Email:Email})
    .then(user=>
        {
            if(!user)
            {
                console.log("User Does not exist")
                return res.status(400).json({msg:"User Does not exist"})
                
            }
            if(Password === user.Password)
            {
                console.log("User Logged In")
            }
            if(Password != user.Password)
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
                return res.status(400).json(
                    {msg:"User Account Verified Logging in....."})
            }

        })
})

router.post("/update/:id",(req,res)=>
{

    const {DOB , Height , Weight , Ethnicity , Activity_Level , Cancer_Type , Smokes , Verified} = req.body


    User.findByIdAndUpdate(req.params.id , req.body)
    .then(user=>
        {
            user.DOB = DOB
            user.Height = Height
            user.Weight = Weight
            user.Ethnicity = Ethnicity
            user.Activity_Level = Activity_Level
            user.Cancer_Type = Cancer_Type
            user.Smokes = Smokes
            user.Verified = Verified
           
            console.log("User Values Updated")
            User.update(user)
            return res.status(400).json({msg:"User Values Updated"})
        })
})

module.exports = router
