#Ask the user for a number. 
# Depending on whether the number is even or odd,
#  print out an appropriate message to the user


number = input("Hello User enter a number:")

if(int(number) % 2 == 0):
    print("This number is even")
else:
    print("This number is odd")

num =input("Try again enter a number:")
check = input("Now try this check enter a number")

if(int(num) % int(check) == 0):
    print("The second number divides evenly into the first number")
else:
    print("The second number does not divide even")