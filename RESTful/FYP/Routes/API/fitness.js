//Bringing in express
const express = require("express")
//Using express router 
const router = express.Router()
const User = require("../../Models/user")
const Excercise = require("../../Models/Excerise")
const FitnessData = require("../../Models/FitnessData")
const Workout = require("../../Models/Workout")

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


router.get("/fitness/getExcercises" , (req,res)=>
{
    Excercise.find()
    .then(exc =>res.json(exc));
})

router.post("/fitness/saveTarget/:email" , (req,res)=>
{
console.log(req.body)

    User.findOne({Email:req.params.email})
    .then(user =>
        {
            FitnessData.findOne({userId:user.id})
            .then(fd =>
                {
                    fd.CalorieTarget = req.body.target
                    fd.DateSet = req.body.dateSet
                    fd.save()
                })
        })
})



router.get("/fitness/getTarget/:email" , (req,res)=>
{
console.log(req.body)

    User.findOne({Email:req.params.email})
    .then(user =>
        {
            FitnessData.findOne({userId:user.id})
            .then(fd =>
                {
                    res.send(fd)
                })
        })
})

router.post("/fitness/saveWorkout/:email" , (req,res)=>
{
    console.log(req.body)
    User.findOne({Email:req.params.email})
    .then(user=>
        {
            const work= new Workout()
            work.Date = req.body.date,
            work.userId =user.id,
            work.Duration = req.body.duration
            work.Excercise = req.body.excercise
            work.CaloriesBurned = req.body.calories
            work.save()
        })
})


router.post("/fitness/setDailyProgress/:email" ,(req ,res) =>
{
    User.findOne({Email:req.params.email})
    .then(user =>
        {
            FitnessData.findOne({userId:user.id})
            .then(fd =>
                {
                    var d = new Date()
                    console.log()
                    console.log(req.body)
                    today = req.body.value
                    fd.dailyInfo[d.getDay()] = today
                    fd.markModified("dailyInfo")
                    fd.save()
                    console.log(fd.dailyInfo)
                    // fd.dailyInfo[d.getDay()] = req.body.calories
                    // fd.save()
                })
        })
})

// router.get("/fitness/getDailyProgress/:email" , (req,res)=>
// {
//     User.findOne({Email:req.params.email})
//     .then(user =>
//         {
//             FitnessData.findOne({userId:user.id})
//             .then(fd =>
//                 {
//                     res.json(fd)
//                 })
//         })
// })


router.get("/fitness/getCalories/:email" , (req,res)=>
{
    const d = new Date();
    let year = d.getFullYear();
    let month = (1 + d.getMonth()).toString().padStart(2, '0');
    let day = d.getDate().toString().padStart(2, '0');

    const date = `${day}/${month}/${year}`

    console.log(date)
    var totalToday = 0;
    workoutsfound =[]

    User.findOne({Email:req.params.email})
    .then(user =>
        {
            Workout.find(
                {
                    userId:user.id,
                    
                }
            ).then(workouts =>
                {
                   Workout.find(
                       {
                           Date:date
                       }
                   )
                   .then(workouts =>
                    {
                        var totalToday = 0;
                        for(var i in workouts)
                        {
                            
                            totalToday+=parseFloat(workouts[i].CaloriesBurned)
                            
                        }
                        // console.log(totalToday)
                        res.json(totalToday)
                    })
                }
            )
        })
    // workoutsfound.map(w => w.calories)
    // console.log(workoutsfound)

})

module.exports = router