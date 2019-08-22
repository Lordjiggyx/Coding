#Create a program that asks the user for a number 
# and then prints out a list of all the divisors of that number.

Number = input("Hello User enter a number and i'll show the divisors:")
divisors = []

for a in range(1,int(Number)+1):
    if(int(Number) % int(a) == 0):
        divisors.append(a)
print(divisors)