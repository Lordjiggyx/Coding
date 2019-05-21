const url = require("url")

const myUrl = new URL ('http://mywebsite.com/hello.html?id=200&status=active')

//Serialized Url
console.log(myUrl.href)

//Host / root domain
console.log(myUrl.host)

//Hostname - does not get port
console.log(myUrl.hostname)

//pathname
console.log(myUrl.pathname)

//serialized query
console.log(myUrl.search)

//Params object
console.log(myUrl.searchParams)

//Add paramans
myUrl.searchParams.append('abc' , '123')
console.log(myUrl.searchParams)

//Loop through params
myUrl.searchParams.forEach((value , name) => console.log(`${name} : ${value}`))