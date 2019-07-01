const os = require('os')

//Platform - e,g windows mac etc

console.log(os.platform())

//Cpu Arch
console.log(os.arch())

//Cpu Core info
console.log(os.cpus())

//Free memory
console.log(os.freemem());

//total memory
console.log(os.totalmem())

//Home directory
console.log(os.homedir())

//Up time
console.log(os.uptime())