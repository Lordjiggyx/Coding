#Dictionaries are lists based on key pair values
#key is used to produce an element in the list

#This dictionary example will convert shortended months to the full month name
#Declared with open and close brace brackets {}
#All Keys must be unique
#comma after each input
#requires a colon between key and value

monthConversions= {
    "Jan": "January",
    "Feb": "February",
    "Mar": "March",
    "Apr": "April",
    "May": "May",
    "Jun": "June",
    "Jul": "July",
    "Aug": "August",
    "Sep": "September",
    "Oct": "October",
    "Nov": "Novemeber",
    "Dec": "December",
}
#Prints all values
print(monthConversions)

#Prints specific Key
print(monthConversions["Nov"])

#.get can be used if you want to specify a default value
print(monthConversions.get("luv" , "Not a valid key"))

#Adding to a dictionary
#you must state the dictionary name
#then state the name of the value in quotes
#adn then use equals to assign a va;ue

monthConversions["Tom"] = "new addition"
print(monthConversions["Tom"])

#get key values in dictionary use keys() method
print(monthConversions.keys())
#get values in dictionary using values() method
print(monthConversions.values())

#items() gets the key value pairs
for abb , month in monthConversions.items():
    print(abb , "=" , month)

#clear() empties dictionary
#pop()removes certain item
monthConversions.popitem()
print(monthConversions)
#popitem()removeslast element