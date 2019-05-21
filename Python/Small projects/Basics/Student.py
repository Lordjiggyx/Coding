#Classes used to define your own data strucrure 

#must use class tag and colon to create the class and the attributes it possesses
#A intialzined function must be declared in the class like a consturctor 
#After this first line the values of attributes can be input

class Student:
    def __init__(self , name , major , grade ):
        self.name = name
        self.major = major
        self.grade = grade
    def honor(self):
        if self.grade >= 3.5:
             return True
        else:
            return False



#We are going to define a function in the student class that each object has access to
#when defining a function in a class the def must be used along with self and a colon
#self.Variable_name is similar to this.name in java 
   