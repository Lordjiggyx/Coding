#Same as java estentially
#or is used for || operator
#and is used or && operator
#elif is used for else if
#not keyword is the same as ! to negate a values boolean value put value in brcakets
ismale = False
istall = True
if ismale and istall:
    print("You are a male and tall or both")
elif ismale and not(istall):
    print("You are a short male")
elif not(ismale) and istall:
    print("You are not male but tall ")
else:
    print("you are not male and not tall")

#Comparisons
# normal apart from the fact == is used for comparing strings 
# examples != - not equals , >= -greater than  or equal etc
# Numbers
def max_num(num1, num2 , num3):
    if num1 >= num2 and num1 >= num3:
        return num1
    elif num2>= num1 and num2>=num3:
        return num2
    else:
        return num3

print(max_num(3,4,5))