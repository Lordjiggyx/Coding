const axios = require("axios")

//Dummy funcions
function initDatabase()
{
    console.log("Databsae initialized....")
}
function closeDatabase()
{
    console.log("Databsae Closed....")
}

//initialse DB before each test
// beforeEach(() => console.log(initDatabase))
// afterEach( () => console.log(closeDatabase))

// beforeAll(() => console.log(initDatabase))
// afterAll( () => console.log(closeDatabase))

const nameCheck = () => console.log("Checking names....")

describe('Checking names', () => {
    beforeEach(()=> nameCheck())
    
    test('User is Jeff' , ()=>
    {
        const user = "jeff"
        expect(user).toBe("jeff")
    })
    test('User is Karen' , ()=>
    {
        const user = "Karen"
        expect(user).toBe("Karen")
    })
});

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
        axios.get("https://jsonplaceholder.typicode.com/users/1")
        .then(res => res.data)
        .catch(err => "error")
    

   
    
}

module.exports = functions