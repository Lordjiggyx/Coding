import axios from "axios"

const functions = 
{
    //Add function
    add :(num1 , num2) =>
        num1 + num2
    ,

    //is null function
    isNull: ()=> null,

    //Check for falsey value
    checkValue:(x)=> x,

    //Creating a user 
    createUser: ()=>
    {
        const user = 
        {
            firstname: "Tomi"
        }
        //add the last name onto the user
        user["lastname"] = "ilori"
        return user
    },

    //function to fetch one user from the json placeholder
    fetchUser: ()=>
    {
        axios.get("https://jsonplaceholder.typicode.com/users/1")
        .then(res=> res.data)
        .catch(err => "error")
    }
    
}

module.exports = functions