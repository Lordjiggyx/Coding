#Create a program that asks the user to enter their name and their age.
#Print out a message addressed to them that tells them the year that they will 
# turn 100 years old.

from datetime import datetime
now = datetime.now()

name = input("Please Enter Your name:")
print("Thank you " + name )
age = input("How old are you:")
print("Thank you " + name  + " I see you are " + str(age) + " years old")
number_of_years = 100 - int(age)
year_100 = now.year + number_of_years
print("You will turn 100 in the year " +  str(year_100))