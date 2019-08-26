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

module.exports = isAnagram