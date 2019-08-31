
function reverseString(str) 
{
  var revstr = ''

  for(var i = str.length-1; i >= 0; i--)
  {
    revstr = revstr + str[i];
    
  }
  //REFACTORING TO MAKE TEST PASS IF THERE IS AN UPPERCASE IN THE String
  revstr = revstr.toLowerCase()

  return revstr
 
}

module.exports = reverseString