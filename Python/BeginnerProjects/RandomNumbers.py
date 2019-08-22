#Generate a random number between 1 and 9 (including 1 and 9)
#Ask the user to guess the number, 
# then tell them whether they guessed too low, too high, or exactly right

import random

a = random.randint(1,9)

input = input("Guess The number")

if(int(input) == a):
    print("Guess correct")
elif(int(input) > a):
    print("Guess Too high")
elif(int(input) < a):
    print("Guess Too low")

print("The number was:" + str(a))