//webstorage
//localstorage
//sessionstorage
//json


window.localStorage.setItem("user" , "Tomi Ilori")


let user = window.localStorage.getItem("user")
console.log(user)

//You can set the value of a key once the key has been instantiated you just 
//need to refer to it in the set item method

let key = 'User_Number'
window.localStorage.setItem(key , '12344552')


//When using JSON values must use double quotes
let users = [
    {"name":"bobby" , "Age:":"21" , key:"123456"},
    {"name":"Tomi" , "Age:":"20" , key:"1236"},
    {"name":"Jami" , "Age:":"31" , key:"12356"},
]

let usersString = JSON.stringify(users)

window.localStorage.setItem("user" , usersString)

let orginal = localStorage.getItem("user")
let obj = JSON.parse(orginal)


console.log(obj)