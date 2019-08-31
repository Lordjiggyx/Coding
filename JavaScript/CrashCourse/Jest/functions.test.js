const functions = require("./functions")

//Add Test
test('two plus two is four', () =>
 {
  expect(functions.add(2,2)).toBe(4)
});


test('two plus two is not equal to five', () =>
 {
  expect(functions.add(2,2)).not.toBe(5)
});


// CHECK FOR TRUTHY & FALSY VALUES
// toBeNull matches only null
// toBeUndefined matches only undefined
// toBeDefined is the opposite of toBeUndefined
// toBeTruthy matches anything that an if statement treats as true
// toBeFalsy matches anything that an if statement treats as false


test('Should be null', () =>
 {
  expect(functions.isNull()).toBeNull()
});

test('Should be falsy', () =>
 {
  expect(functions.checkValue(null)).toBeFalsy()
});


//Creating a user object test
test("User object with first and last name of tomi ilori" , ()=>
{
    expect(functions.createUser()).toEqual(
        {
            firstname:"Tomi",
            lastname:"ilori"
        }
    )
})

//Less then or greater than

test("should be under 1600" , ()=>
{
    const load1 = 700
    const load2 = 500
    expect(load1 +load2).toBeLessThan(1600)
})

//Regex test

test("There is no I in team", ()=>
{
    expect('team').not.toMatch(/I/)
})


//Arrays
test("Admin should be in usernames" , () =>
{
    usernames =
    [
        "John",
        "Karen",
        "admin"
    ]

    expect(usernames).toContain("admin")
})

//Async test

test("user Fetched name should be leanne Graham" , ()=>
{
    //Expecting one object to be returned
    expect.assertions(1)
    //returning promise as test will finish before promise does
    return functions.fetchUser().then(data =>
        {
            expect(data.name).toEqual("Leanne Graham")
        })
})


// Async Await
test('User fetched name should be Leanne Graham', async () => {
    expect.assertions(1);
    const data = await functions.fetchUser();
    expect(data.name).toEqual('Leanne Graham');
  });