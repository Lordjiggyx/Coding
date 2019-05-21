#List essentially like any other collection in programming 

#Lists are declared the same as any other variable they just get [] brackets
friends = ["Wez" , "Ish" , "adindu" , "bob" , "tim" ,"bob", "bob"]
lucky_number = [1 , 914 , 8, 56 , 615, 2,16 , 23 , 3, 12, 42]
#Lists can take any type of variable into the list
types = ["Shane" , 20 , False]

#You can Access the index value of lists like any other collection
print(friends[1])
#To Access the last index just do the -1 in the square brackets or just backwards
print(friends[-1])
#Selecting a portion of the list(anything after a certain index)
print(friends[1:])
#Selecting a range of a list
print(friends[2:5])
#Update value
friends[2] = "jimmy"
print(friends)

#List Functions

#append Function- allows you to appened another list to the current list
friends.append(lucky_number)
print(friends)
#Can also be used to add extra values
friends.append("Tomi")
print(friends)

#Insert - inserts an item at a given index will push all elements
friends.insert(1 , "Tobi")
print(friends)

#Remove - Allows you to remove an element
friends.remove("Tobi")
print(friends)

#Clear - Allows you to clear the list
#friends.clear()
#print(friends)

#pop - Will pop the last element
friends.pop()
print(friends)

#index - used to get index of a element
print(friends.index("bob"))

#count - gets the number of instances of a certain occurence of a element
print(friends)
print(friends.count("bob"))

#Sort - sorts the list in ascending order
lucky_number.sort()
print(lucky_number)

#Reverse - revereses the order of trhe list
lucky_number.reverse()
print(lucky_number)

#Copy - allows you to copy a list
friends2 = friends.copy()
print(friends2)

