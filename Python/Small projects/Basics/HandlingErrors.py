number = int(input("Enter A number"))
print(number)

#Try-Execpt Block like a try catch block
#Requires a ":"

try:
    number = int(input("Enter A number"))
    print(number)
except:
    print("You Fucked Up")

#Can handle specfic errors
try:
    number = int(input("Enter A number"))
    print(number)
except ZeroDivisionError:
    print("You Tried to divide by zero ")
except ValueError:
    print("You must enter a number")
