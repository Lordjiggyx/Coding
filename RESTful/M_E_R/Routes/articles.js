//Bringing in epxress
const express = require("express")
//Instantiating express router
const router = express.Router()



let Article = require("../Models/articles")
const User = require("../Models/User")



//Route for adding articles for the user
router.get("/articles/add",ensureAuthenticated , (req , res)=>
{
    res.render("add.pug"  ,
    {
        title:"Add articles"
    })
})

//Submit an article
router.post("/articles/add",(req ,res)=>
{

    //Vlaidation
    if(req.body.Title== "" ||  req.body.Body== "" )
    {
        req.flash("danger" ,"All fields must be filled")
        res.render('add.pug',
        {
            title:"Add Article",
        })
    }
    else
    {
 //We have access to the model 
        let article = new Article()
            
        // Here we assign the values from the field and the ti the object paraemters
        article.Title = req.body.Title
        article.Author = req.user.id
        article.Body = req.body.Body

        //We then call the save method which saves to a database 
        article.save((err)=>
        {
            if(err)
            {
                console.log(err)
                return
            }
            //Once the object has been saved we can redirect to the home page
            else
            {
                //showing flash message for succssful submission
                req.flash("success" , "Article added successfully!!!")
                res.redirect("/")
            }

        })
    }

   
})
//Edit an article
router.post("/articles/edit/:id" ,ensureAuthenticated ,(req ,res)=>
{
   
        let article = {}
    
        // Here we assign the values from the field and the ti the object paraemters
        article.Title = req.body.Title
        article.Author = req.body.Author
        article.Body = req.body.Body
    
        //
        let query = {_id:req.params.id}
    
       Article.update(query , article , function(err)
       {
        if(err)
        {
            console.log(err)
            return
        }
        //Once the object has been saved we can redirect to the home page
        else
        {
            req.flash("success" , "Article Updated successfully")
            res.redirect("/")
        }
       })
    }
    //We have access to the model 
   
)


//Get a single article 
router.get("/articles/:id",(req , res)=>
{
    Article.findById(req.params.id , (err , article)=>
    {
        User.findById(article.Author, (err ,user)=>
        {
        res.render("article.pug"  ,
        {
            article:article,
            author:user.name
        })
    })
    })
})

// Access Control
function ensureAuthenticated(req, res, next){
    if(req.isAuthenticated()){
      return next();
    } else {
      req.flash('danger', 'Please login To View Resource');
      res.redirect('/users/login');
    }
  }

//Edit a single article / load edit form 
router.get("/articles/edit/:id" , (req , res)=>
{
     Article.findById(req.params.id , (err , article)=>
    {
        //Checking that artcile author matches the the logged in user id befire allowing changes to be made
        if(article.Author != req.user.id)
     {
         req.flash("danger" , "Not Authorised to make changes to this article" )
         res.redirect("/")
     }
     else
     {
        User.findById(article.Author, (err ,user)=>
        {
        res.render("edit_article.pug"  ,
        {
            article:article,
            author:user.name
        })
    })
     }
    })
})


//delete route
router.delete('/articles/:id' ,  (req ,res)=>
{
    //Checking that a user is logged in 
    if(!req.user._id){
        res.status(500).send();
      }
    let query = {_id:req.params.id}

    Article.findById(req.params.id, function(err, article)
    {
        //Checking that the artocle owner is the same as the user that is logged in
        if(article.Author != req.user._id)
        {
          res.status(500).send();
        }
         else
        {     
            Article.remove(query, (err)=>
            {
                if(err)
                {
                    console.log(err)
                }
                res.send("success")
            })
    }})
})


module.exports = router;