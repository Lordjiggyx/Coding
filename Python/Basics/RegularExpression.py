#Regular Expression is used to search for and match specific patterns of text
#To use regular expression import re function
#Understand what a raw String is
#A raw string is a string prefix with an "r" tells python not to handle back slashes in anyway
#important as we want the regular expression to interpret the string and not have python interpret it


import re

#This is the string that will be searched
text_to_search = '''
abcdefghijklmnopqurtuvwxyz
ABCDEFGHIJKLMNOPQRSTUVWXYZ
1234567890
Ha HaHa
MetaCharacters (Need to be escaped):
. ^ $ * + ? { } [ ] \ | ( )
coreyms.com
321-555-4321
123.555.1234
cat
mat
bat
pat
rat
123*555*1234
800-555-1234
900-555-1234
Mr. Schafer
Mr Smith
Ms Davis
Mrs. Robinson
Mr. T
Tomi 
ToMi
TomI

'''
sentence = 'Start a sentence and then bring it to an end'
#Regualr expression is case sensitive

#Certain characters need to be escaped as they are special characters
#They are escaped with a backslach "\"
#e.g pattern = re.compile(r'\.')
#e.g pattern = re.compile(r'coreyms\.com')

#To match start or end of the string use the "^" for the start and "$" for the end
#e.g pattern = re.compile(r'^Start')
#e.g pattern = re.compile(r'end$)

#Types of patterns examples
#re.compile(r'\d\d\d')-gives matches with 3 numbers
# re.compile(r'\d\d\d.\d\d\d.\d\d\d\d')- matches any three numbers followed by any character followed by 3 numbers followed by a character followed by 4 numbers
#re.compile(r'\d\d\d[.]\d\d\d[.]\d\d\d\d')- a charcter set "[]" to match a specific character
#re.compile(r'\d\d\d[-.]\d\d\d[-.]\d\d\d\d') - can be used to  match multiple charcaters i this example dash and dots
#re.compile(r'[89]00[-.]\d\d\d[-.]\d\d\d\d') - can be used to matc hspecific numbers also
#re.compile(r'[1-5]) - can be used for ranges in this example -numbers from one to five
#re.compile(r'[a-z]) - can be used for ranges in this example -letters a to z
#re.compile(r'[a-zA-Z]) - can be used for ranges in this example -letters a to z and capital
#re.compile(r'[^a-zA-Z]) - can be used for ranges in this example -"^" placed in the character set negates everything in the character set
#re.compile(r'[^b]at') - used to return anything that is not b and followed by a literal of "at"
# QUNATIFIERS - USED FOR ONE OR MORE ONE OR LESS ETC
# re.compile(r'\d{3}.\d{3}.\d{4}')- curly braces determine exact number of values e.g 3 numbers followed by a charcter followed by 3 numbers again followed by a character followed by 4 characters
# re.compile(r'Mr\.?')- "?" used to say if a value is optional
#re.compile(r'Mr\.?\s[A-Z]\w*') - "*" used to say 0 or more 
#re.compile(r'Mr\.?\s[A-Z]\w+') - "+" used to say 1 or more 
#use pattern = re.compile() to preform search
#GROUPS - Created with parentheses
#re.compile(r'M(r|s|rs)\.?\s[A-Z]\w*') - Used to search for an r s or rs after the M followed by an optional character followed by a space followed by 0 or more letters
#re.compile(r'[a-zA-z]+@[a-zA-Z]+\.com') - email one
#re.compile(r'[a-zA-Z.]+@[a-zA-Z]+\.(com|edu)') - email one and two
#re.compile(r'[a-zA-Z0-9.-]+@[a-zA-Z-]+\.(com|edu|net)') - all emails
#re.compile(r'Tomi' , re.I ) - flags used to do a non case sensitive search
#bob= re.split(r'\d+', 'Words2words, words4Tomi')- Split is used to separate strings based on a pattern for example here anytime a number is encountered the string is split
#^-?\d+(,\d+)*(\.\d+(e\d+)?)?$ - matches all numbers including decimal
#1?[\s-]?\(?(\d{3})\)?[\s-]?\d{3}[\s-]?\d{4} - phone numbers
#^([\w\.]*) - begininng of an email
#<(\w+)- html tag
#='([\w://.]*)' html attribute variables
#(\w+)\.(jpg|png|gif)$ - file names
emails = '''
CoreyMSchafer@gmail.com
corey.schafer@university.edu
corey-321-schafer@my-work.net
'''

urls = '''
https://www.google.com
http://coreyms.com
https://youtube.com
https://www.nasa.gov
'''

#Method 1 of doing regex
#inside the compile method is the pattern your searching for
pattern = re.compile(r'^([\w\.]*) ')
#matches iterates through the requested string
matches = pattern.finditer(emails)
#When the loop is ran we get the index of where the match is
for match in matches:
    print(match)

#Method 2 Inside the parentheses is the pattern then the string you want to search through
match2 = re.search("Tomi" , text_to_search , re.I )
print(match2)

 
bob= re.split(r'\d+', 'Words2words, words4Tomi')
print(bob)




#Accessing groups with different groups in a regex you can access the specfic group values 
#use .group() method
#print(match.group(0))- returns all emails
#print(match.group(1))- returns the www.
#print(match.group(2))- returns website name
#print(match.group(3))- returns domain

#Can sub literals by using .sub() method to get groups and then reformat
#pass in string along with the regualr expression
#subbed_urls = pattern.sub(r'\2\3', urls)

#print(subbed_urls)