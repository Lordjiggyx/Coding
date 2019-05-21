// CHALLENGE 1: REVERSE A STRING -done
// Return a string in reverse
// ex. reverseString('hello') === 'olleh'

function reverseString(str) 
{
  var revstr = ''

  for(var i = str.length-1; i >= 0; i--)
  {
    revstr = revstr + str[i];
    
  }
  return revstr;
 
}



// CHALLENGE 2: VALIDATE A PALINDROMEdone
// Return true if palindrome and false if not
// ex. isPalindrome('racecar') === 'true', isPalindrome('hello') == false

function isPalindrome(str) 
{
  var palindrome = ''

  for(var i = str.length-1; i >= 0; i--)
  {
    palindrome = palindrome + str[i];
    
  }
  
  if(palindrome.toLowerCase() ===str.toLowerCase())
  {
    return true
  }
  else
  {
    return false
  }
}


// CHALLENGE 3: REVERSE AN INTEGER - done
// Return an integer in reverse
// ex. reverseInt(521) === 125

function reverseInt(int) 
{
  //Convert number ot string
  var str = int.toString()
  //create variable to reverse string
  rev = ''
  //confirm string is present
 console.log(typeof str)

 //Reverse string
 for(var i = str.length-1; i >= 0; i--)
  {
    rev = rev + str[i];
    
  }
  //Chnage to number
  rev = parseInt(rev)
  //confirm it's a number
  console.log(typeof rev)
  //return reveresed number
  return rev
}



// CHALLENGE 4: CAPITALIZE LETTERS
// Return a string with the first letter of every word capitalized
// ex. capitalizeLetters('i love javascript') === 'I Love Javascript'
function capitalizeLetters(str) 

{

return str.
//conevrt to lowercase
toLowerCase()
//Space is used as delimiter to seperate by words
.split(' ')
//Takes function
 //changes first character to uppercase and adds everyhting following the uppercase letter 
.map((word) => word[0].toUpperCase() + word.substr(1))
//Put it back into a string
.join(' ')
}



// CHALLENGE 5: MAX CHARACTER
// Return the character that is most common in a string
// ex. maxCharacter('javascript') == 'a'
function maxCharacter(str)
{
 //use object as a map
 const charMap={}
 var maxNum = 0
 var maxChar = ""
 //loop through string as an array
 //use for each and pass in function 
 //We want to look at each key value pair e.g
//  a:1
//  b:2
//  c:3
str.split('').forEach(function(char) {
if(charMap[char])
{
  //if it exists we add 1 to it 
  charMap[char]++
}
 //if it hasn't been found
else{charMap[char] = 1}
});

 console.log(charMap)

 //For i loop used to loop 
 //through an object rather than loop through an array
 for(let char in charMap)
 {
  if(charMap[char]> maxNum)
  {
    maxNum = charMap[char]
    maxChar = char;
  }
 }
 return maxChar
}



// CHALLENGE 6: FIZZBUZZ
// Write a program that prints all 
// the numbers from 1 to 100. For multiples of 3,
// instead of the number, print "Fizz", for multiples
// of 5 print "Buzz". For numbers which are multiples
// of both 3 and 5, print "FizzBuzz".
function fizzBuzz() {
 

   for(var i = 1 ; i <= 100 ; i++)
   {
     //console.log(i)
     if(i%3 === 0 && i%5 === 0)
     {
       console.log(`${i}:FizzBuzz`)
     }
     else if(i%3 === 0)
     {
       console.log(`${i}:Fizz`)
     }
     else if(i%5 === 0)
     {
       console.log(`${i}:Buzz`)
     }
     else
     {
       console.log(`${i}:Neither`)
     }
     
   }

}

////Session 2/////
// CHALLENGE 1: LONGEST WORD
// Return the longest word of a string
// ex. longestWord('Hi there, my name is Brad') === 'there,'

function longestWord(str) {
   var longestWord  = ""
  var largest = 0;
  var splitWords = str.split(' ').map((word) => word)
  var Wordengths  = splitWords.map((word) => word.length)
  
  for (i = 0; i < Wordengths.length; i++) {
    if (Wordengths[i] > largest)
     {
        largest = Wordengths[i];
    }
}
for(i = 0; i<splitWords.length;i++)
{
  if(splitWords[i].length == largest)
  {
    return splitWords[i]
  }
}
 console.log(longestWord)
 
}

// CHALLENGE 2: ARRAY CHUNKING
// Split an array into chunked arrays of a specific length
// ex. chunkArray([1, 2, 3, 4, 5, 6, 7], 3) === [[1, 2, 3],[4, 5, 6],[7]]
// ex. chunkArray([1, 2, 3, 4, 5, 6, 7], 2) === [[1, 2],[3, 4],[5, 6],[7]]
// CHALLENGE 3: FLATTEN ARRAY
// Take an array of arrays and flatten to a single array
// ex. [[1, 2], [3, 4], [5, 6], [7]] = [1, 2, 3, 4, 5, 6, 7]
function chunkArray(arr, len) 
{
// Init chunked arr
const chunkedArr = [];

// Loop through arr
arr.forEach(val => {
  // Get last element
  const last = chunkedArr[chunkedArr.length - 1];
   // Check if last and if last length is equal to the chunk len
   if (!last || last.length === len) {
    chunkedArr.push([val]);
  } else {
    last.push(val);
  }
});
return chunkedArr;
}




function flattenArray(arrays)
// CHALLENGE 3: FLATTEN ARRAY
// Take an array of arrays and flatten to a single array
// ex. [[1, 2], [3, 4], [5, 6], [7]] = [1, 2, 3, 4, 5, 6, 7]
 {
   //a is the starting point and b is each iteration so you just want to concatinate b onto a
   //reduce reduces an array into a single value
  return arrays.reduce((a, b) => a.concat(b));
 }

// CHALLENGE 4: ANAGRAM
// Return true if anagram and false if not
// ex. 'elbow' === 'below'
// ex. 'Dormitory' === 'dirty room##'

function isAnagram(str1, str2)
 {
  //we need to format the strings
  //strip out punctuation
  //turn to lowercase
  //split into an array
  //sort and join back

  return formatstr(str1) === formatstr(str2);


 }
 //used ot format strings
function formatstr(str)
{
//replace takes in regular expression
  return str
  //Anything that is not a word character and replace it with an empty string
  .replace(/[^\w]/g , '')
  .toLowerCase()
  //We need to turn into an array where each array value is a character
  .split('')
  .sort()
  //turn it back into a strin
  .join('')
}


function letterChanges(str) 
{
// CHALLENGE 5: LETTER CHANGES
// Change every letter of the string to the one that follows it and capitalize the vowels
// Z should turn to A
// ex. 'hello there' === 'Ifmmp UIfsf'{}
  function letterChanges(str) {
    let newStr = str.toLowerCase().replace(/[a-z]/gi, char => {
      if (char === 'z' || char === 'Z') {
        return 'a';
      } else {
        return String.fromCharCode(char.charCodeAt() + 1);
      }
    });
  
    newStr = newStr.replace(/a|e|i|o|u/gi, vowel => vowel.toUpperCase());
  
    return newStr;
}


// Call Function
const output = isAnagram("elbow" , "below")

console.log(output);
}