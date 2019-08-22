#To Wwrite a function one must use def the keyword 
#you must have a colon to have code inside the function
#must also indent
#To use Function you must call it
def sayhi():
    print("Hello user")



#To use Function you must call it
sayhi()

#passing information to a function
def sayhi1(name , age):
    print("Hello " + name + " you are " + age )

sayhi1("Tomi" , "19")


#Lambda
#Small anonymous functions can be created with the lambda keyword
#Lambda functions can be used wherever function objects are required
#They are syntactically restricted to a single expression
#
def square_numbers(n):
    return lambda x:x*n
    
f = square_numbers(2)
print(f(10))
 