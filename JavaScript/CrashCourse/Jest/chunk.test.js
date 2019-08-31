const chunkArray = require("./chunk")


//Check that chunk array exists
test("Reverse String should exist" , ()=>
{
    expect(chunkArray).toBeDefined()
})

//Chunk an array of 10 values with a lenght of 2
test("Chunk an array of 10 values with a lenght of 2" , ()=>
{
    //Creating array
    const numbers = [1,2,3,4,5,6,7,8,9,10];

    //varibale to set length
    const len = 2;

    //calling the function
    const chunkedArr = chunkArray(numbers , len)

    //Expetation

    expect(chunkedArr).toEqual([[1,2],[3,4],[5,6],[7,8],[9,10]])
})


//Chunk an array of 3 values with a lenght of 1
test("Chunk an array of 10 values with a lenght of 2" , ()=>
{
    //Creating array
    const numbers = [1,2,3];

    //varibale to set length
    const len = 1;

    //calling the function
    const chunkedArr = chunkArray(numbers , len)

    //Expetation

    expect(chunkedArr).toEqual([[1],[2],[3]])
})