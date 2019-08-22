#Ask the user for a string and
#  print out whether this string is a palindrome or not

Word = input("Enter a Word:")

reversed_word = Word[::-1]
if(reversed_word == Word):  
    print("Palindrome Detected")
    print(reversed_word)
else:
    print("Non Palindrome Detected")
