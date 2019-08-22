#Take a list, say for example this one:
#a = [1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89]
# write a program that prints 
# out all the elements of the list that are less than 5.

a = [1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89]
b=[]

for x in a:
    if(x <10):
        b.append(x)

print(b)

#List comprehension
# A list comprehension behaves like this: [output] for [item] in [list] if [filter]
#Create a new list a
#for every element in this list
#that is less than 10
print([a for a in a if a < 10])