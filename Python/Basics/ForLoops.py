#Created using for
#for looop requires a value
# needs "in" to look through a collection
#needs a ":" and indentation

#String
for letter in "Tomi Ilori":
    print(letter)

#A list
friends = ["Wez" , "Ish" , "adindu" , "bob" , "tim"]

for friend in friends:
    print(friend)



#Range
for index in range(2 , 10):
    print(index)

for index in range(len(friends)):
    print(index)

#Exponent function
def raise_power(base_num , power):
    print("Function")
    result = 1
    for index in range(power):
        result = result * base_num
    return result

print(raise_power(2 , 3))