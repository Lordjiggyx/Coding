const EventEmitter = require('events')

//Cretae class
class MyEmitter extends EventEmitter{}

//init object
const myEmitter = new MyEmitter();

//create listener = first paramenter is event second is the a callback  to any function
myEmitter.on('event',() => console.log('event Fired!!'))

//init event
myEmitter.emit('event')