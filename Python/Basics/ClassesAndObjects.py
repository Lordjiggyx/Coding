#Uses Studnet Class
#Class of type student has been defined 
#We will now cretae an object and 
#To use the class we must import it
from Chef import Chef
from Student import Student
from ChineseChef import ChineseChef


student = Student("Tomi" , "Business" , 3.2 )
#This creates a student object

#Print Student name by using .name
print(student.name)

#Class Function
print(student.honor())

#Inheritence example
myChef = Chef()
myChef.chicken()


ChineseChef = ChineseChef()
ChineseChef.chicken()