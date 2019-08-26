const isAnagram = require("./anagram")

//Check that is Anagagrma exists
test("Reverse String should exist" , ()=>
{
    expect(isAnagram).toBeDefined()
})

//Check for if cinema is an anagram of iceman
test("cinema is an anagram of iceman" , ()=>
{
    expect(isAnagram("cinema" , "iceman")).toBeTruthy()
})

//Check if dormitory is an angarma of dirty rooms
test("cinema is an anagram of iceman" , ()=>
{
    expect(isAnagram("dormitory" , "dirty room##")).toBeTruthy();
})

//Check if hello is an angram of aloha which it is not
test("cinema is an anagram of iceman" , ()=>
{
    expect(isAnagram("hello" , "aloha")).toBeFalsy();
})
