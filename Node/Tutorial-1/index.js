// console.log('Hello from Node.js..')

// const Person = require('./person')

// const p1 = new Person('Tomi', 20)
// p1.greeting()


// //Bringing in logger class
// const Logger = require('./Logger')

// //initisalsing it
// const logger = new Logger()

// //This i assume is turning onthe logger
// logger.on('message' , (data) => console.log('Called Listener' ,  data))

// //Call the log method
// logger.log('Hello World')

const http = require('http')
const path = require('path')
const fs = require('fs')
//Create server object
const server = http.createServer((req , res)=>
{
//     //Check the url if it is a slash
//     if(req.url === '/api/users'){
    
//     const users =
//     [
//         {name:'Bob Smith' , age:40},
//         {name:'John Doe' , age:23}
//     ]
//     res.writeHead(200 , {'Content-Type': 'application/json'})
//     //change JS array into json using stringify and serve the result
//     res.end(JSON.stringify(users))
// }
    //{

    // //read the fike
    // fs.readFile(path.join(__dirname , 'Public' , 'about.html') , (err , content)=>
    // {
    //     //check fro an errir
    //     if (err) throw err
    //     //ser the status and content type
    //     res.writeHead(200 , {'Content-Type': 'text/html'})
    //     //serve the html page
    //     res.end(content)
    // })
    
    // }
    // console.log(req.url)

//Most effcient way of reading files
//chcek public folder if it is / we go to the home page else we load what the file is called
let filePath = path.join(__dirname , 'Public' , req.url ==='/' ? 'index.html' : req.url)

//Setting the content type
//getting the file extension
let extension = path.extname(filePath)
//initail contenet type
let contentType = 'text/html'
//check extension and set content type if other using switch statement
switch(extension)
{
    case ".js":
      contentType = "text/javascript";
      break;
    case ".css":
      contentType = "text/css";
      break;
    case ".json":
      contentType = "application/json";
      break;
    case ".png":
      contentType = "image/png";
      break;
    case ".jpg":
      contentType = "image/jpg";
      break;
}

 // Check if contentType is text/html but no .html file extension
 if (contentType == "text/html" && extension == "") filePath += ".html";

//reading in the file
fs.readFile(filePath , (err,content) =>
{
    //If there is an erro
    if(err)
    {
        //This is used if the file page does not exist
        if(err.code =='ENOENT')
        {
            //PAGE NOT FOUND  so you gte brought to the 404 page which means thats the page was not found
            fs.readFile(path.join(__dirname , 'public' , '404.html') , (err , content)=>
            {
                res.writeHead(200 , {'Content-Type': 'text/html'})
                res.end(content, 'utf8')
            })
        }
        else
        {
            //Some server error
            res.writeHead(500)
            //just prints out the error code 
            res.end(`Server Error:${err.code}`)
        }
    }
    //No error
    else
    {
    //Success
    //return file the same as always
    res.writeHead(200 , {'Content-Type': contentType})
    res.end(content , 'utf8')
    }

})



//Show path in console 
console.log(filePath)

})
const PORT = process.env.PORT || 5000

server.listen(PORT , () => console.log(`Server runing on port ${PORT}`))