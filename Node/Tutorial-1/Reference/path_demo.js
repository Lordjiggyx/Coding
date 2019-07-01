const path = require('path')

//BASE FILE NAME
console.log(path.basename(__filename));

//Directory name
console.log(path.dirname(__filename))

//File extension
console.log(path.extname(__filename))

//Create path object - done with parse
console.log(path.parse(__filename))
console.log(path.parse(__filename).base)

//Concatenate paths
console.log(path.join(__dirname , 'test' , 'hello.html'))