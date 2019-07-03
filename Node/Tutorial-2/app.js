/**UNCOMMENT TO TEST */
/*
 
=====Modules======
const tutorial = require('./tutorial') 


console.log(tutorial)

console.log(tutorial.sum(1,1))
console.log(tutorial.PI)
console.log(new tutorial.SomeMathObject())
*/


/*=====Event Emitter=======
//Requireing the event module
const EventEmitter = require('events')
//Creating an instance of the event emitter class
const eventEmitter = new EventEmitter()
const eventEmitterParam = new EventEmitter()
//Adding a listener onto the eventemitter instance
eventEmitter.on('tutorial' , ()=>
{
    console.log("Event has occured")
})
eventEmitterParam.on('addition' , (num1,num2)=>
{
    console.log(num1 + num2)
})
//Emitting a tutorial event
eventEmitter.emit('tutorial')
eventEmitterParam.emit('addition' , 10 , 23)

//Creating an object that ecentds from the events emitter class
class Person extends EventEmitter
{
    constructor(name)
    {
        super();
        this.name = name
    }

    getName()
    {
        return this.name
    }
}

let p1 =  new Person('Tomi');

//adding a listener to the object as it extends the event emmitter object
p1.on('display' ,() =>
{
    console.log(p1.name)
})

//Then we emit the event
p1.emit('display')
*/

/*Readline Module 

//reequireing the readline module
const readline = require('readline');

//Creating an indtance of the createINterfcae method
const rl = readline.createInterface
(
    {
        input:process.stdin,
        output:process.stdout
    }
)

//Two numbers for the question
num1 = 20;
num2 = 30;
answer =num1 + num2

//The readline has the question method  which takes in two parameters the question and the function that should happen when the question is answered
rl.question(`What is ${num1} + ${num2}?\n`,
    (userInput)=>
    {
        //If the answer the quetsion correctly we will close the application
       if(userInput.trim() == answer)
       {
        rl.close()
       }
       else
       {
           //This takes an argument of srting to get what you wnat to know from the user
           //You must first set the prompt
           rl.setPrompt('incorrect response try again\n')
           //Then you must call the prompt
           rl.prompt()
           rl.on('line',(userInput)=>
               {
                   if (userInput == answer) 
                   {
                       rl.close()
                   }
                   else
                   {
                       rl.setPrompt("Your answer is wrong\n Try again\n")
                       rl.prompt()
                   }
               }
           )}
       }
)

    //Just lets the user know that the event is finished as it listens for the close event
    //
    rl.on('close' , ()=>
    {
        console.log("Correct!!!!!!!!")
    })
*/

/*File System Module ----files
// const fs = require('fs')

// //Create a file takes in three paramters file name content and error
// fs.writeFile('example.txt' , 'This is an example' , (err) => 
// {
// if(err)
// {
//     console.log(err)
// }
// else
// {
//     console.log('File successfully created')
//     //Reading the file
    
// fs.readFile('example.txt' ,'utf-8' ,(err,file)=>
// {
//     if(err)
// {
//     console.log(err)
// }
// else
// {
//     console.log(`File Successfully read \n ${file}`)
// }
// })
// }
// })

//renaming a file
// const fs = require('fs')

// fs.rename('example.txt' , 'example2.txt' , (err)=>
// {
//     if(err)
//     {
//         console.log(err)
//     }
//     else
//     {
//         console.log('File name successfully change')
//     }
// })


//Appending a file

// fs.appendFile('example2.txt' , 'Appended Data' , (err)=>
// {
//     if(err)
//     {
//         console.log(err)
//     }
//     else
//     {
//         console.log('File  successfully appended')
//     }
// })


//deleting a file
const fs = require('fs')
fs.unlink('example2.txt' , (err) =>
{
    if(err)
    {
        console.log(err);
    }
    else
    {
        console.log('File deleted')
    }
})
 */

/*File System Module ----folders */

//const fs = require('fs');

// //Creating a folder & creating a file upon creating the folder
// fs.mkdir('New Folder', (err) =>
// {
//     if(err)
//     {
//         console.log(err);
//     }
//     else
//     {
//         console.log('Folder created Now Writing File.....')
//         fs.writeFile('./New Folder/example.txt' , 'This was created in a file' ,(err)=>
//         {
//             if (err)
//             {
//                 console.log(err)
//             }
//             else
//             {
//                 console.log("File Created")
//             }
//         })

//     }
// })


//Deleting a folder
// fs.rmdir('New Folder', (err) =>
// {
//     if(err)
//     {
//         console.log(err);
//     }
//     else
//     {
//         console.log('Folder Deleted')
//     }
// })

//Reading in the contents of a folder
// fs.readdir('New Folder', (err , files) =>
// {
//     //If therer is an error log it out
//     if(err)
//     {
//         console.log(err);
//     }
//     else
//     {
//         for ( let file of files)
//         {
//             fs.unlink('./new folder/' + file , (err)=>
//             {
//                 if(err)
//                 {
//                     console.log(err)
//                 }
//                 else
//                 {
//                     console.log('File Deleted')
//                 }
//             })
//     }
// }})


/*read and write streams 

// requiring the file system module and storing in a local varibale
const fs = require('fs')
//requiring a Zlib module for file compression and storing in a variable
const zlib = require('zlib')

//Creating transform stream
const gunzip = zlib.createGunzip()

//Create a readble stream
const readStream=fs.createReadStream('example2.txt.gz')
//Creating a writable stream
const writeStream = fs.createWriteStream('uncompressed.txt')



//Using a listener rather then a pipe
// readStream.on('data' , (chunk)=>
// {
//     console.log(chunk)
//     writeStream.write(chunk)
// })

//Using the pipe method instead
//readStream.pipe(writeStream)

//We can then compreess this by first piping it into the gzip and then into our write stream

readStream.pipe(gunzip).pipe(writeStream)
*/


/**HTTP Module 

//require http module
const http = require('http')

//Creating a web server with a response
const server = http.createServer((req , res)=>
{
    if(req.url ==='/')
    {
    res.write("Hello World")
    res.end()
    }
    else
    {
        res.write('Other domain not root')
        res.end()
    }
})

//Make server listen on the port
server.listen('5500')

*/


/**Serving Static Files with Http and File System Module */

//require http module
const http = require('http')

//requiring the file system module and storing in a local varibale
const fs = require('fs')

//Creating a server
// const server = http.createServer((req , res)=>
// {
//     //Reading in an html file
//     const readStream=fs.createReadStream('./static/index.html')
//     //Creating a header for the response letting the client know            that the data will be html
//     res.writeHead(200 , {'Content-type':'text/html'})
//     //We can then pipe this response to the user
//     readStream.pipe(res)
// }).listen('5500')

// const server = http.createServer((req , res)=>
// {
//     //Reading in an Json file
//     const readStream=fs.createReadStream('./static/example.json')
//     res.writeHead(200 , {'Content-type':'application/json'})
//     readStream.pipe(res)
// }).listen('5500')


// const server = http.createServer((req , res)=>
// {
//     //Reading in an img file
//     const readStream=fs.createReadStream('./static/example.png')
//     res.writeHead(200 , {'Content-type':'image/png'})
//     readStream.pipe(res)
// }).listen('5500')



/**Node Package Manager */
// const lo = require('lodash')

// //This fill method is used to fill the array with from certain index points with a differnt value for example postion 1 to 3 has been replaced with banana
// var example = lo.fill([1 ,2 ,3, 4,5] , "banana" , 1 , 4)

// console.log(example)




