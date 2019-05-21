const fs = require('fs')
const path = require('path')


//Create a folder

//mkdir has three properties , the path , any options then a callback
// fs.mkdir(path.join(__dirname, '/test') ,{} , err=>{
//     if(err) throw err
//     console.log('Folder created')
// })

// //Create and write to files firts parameteris the path the second paramter is the content you want to write to it the third parameter again is an error
// fs.writeFile(path.join(__dirname, '/test' , 'Hello.txt') ,'Hello World' , err=>{
//     if(err) throw err
//     console.log('File written to')

// //Allows thhe file to be appended to
// //Can be placed in the callback as they are async
// fs.appendFile(path.join(__dirname, '/test' , 'Hello.txt') ,' I love node.js' , err=>{
//     if(err) throw err
//     console.log('File written to')
// })
// })

//Read file - first parameter path second parameter is the character encoding 
// fs.readFile(path.join(__dirname, '/test' , 'Hello.txt') ,'utf8' , (err ,data)=>{
// if(err) throw err
// console.log(data)
// })

//Rename file - second parameter in this case is the new namee of the file being renamed
fs.rename(path.join(__dirname, '/test' , 'Hello.txt') ,path.join(__dirname, '/test' , 'HelloWorld.txt')  , (err ,data)=>{
    if(err) throw err
    console.log(data)
    })