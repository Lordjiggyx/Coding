#Get input from user asking from name
name = input("Enter your name: ")
print("Hell0 " + name )
age = input("Enter your age: ")
print("You Are: " + age )

#When you get input from a user Python converts it to a string automatically
#When taking in numbers must convert the string to a number to do math operations
num1 = input("Enter one number")
num2 = input("Enter Another number")

#For Whole Numbers
result = int(num1) + int(num2)
print(result)

num3 = input("Enter one number")
num4 = input("Enter Another number")

#For decimals Numbers
result = float(num3) + float(num4)
print(result)