const reverseString = require("./revString")


//Test to see if the funciton exists
test("Reverse String should exist" , ()=>
{
    expect(reverseString).toBeDefined()
})

//Test to see if the string reverses
test("String input should reverse" , ()=>
{
    expect(reverseString("hello")).toEqual("olleh")
})

//Test to ensure that string can be returned with capital letter
test("String input should reverse with uppercase" , ()=>
{
    expect(reverseString("Hello")).toEqual("olleh")
})
