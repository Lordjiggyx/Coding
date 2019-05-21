
#can wrap user input with float to turn the string to a number

num1 = float(input("Enter First number:"))
op = input("Enter Operator :")
num2 = float(input("Enter Second number:"))

if op == "+":
    print(num1 +num2)
elif op =="-":
    print(num1 - num2)
elif op =="*":
    print(num1*num2)
elif op =="/":
    print(num1/num2)
else :
    print("Invalid input")
#LASt Time NOW BOOOOI