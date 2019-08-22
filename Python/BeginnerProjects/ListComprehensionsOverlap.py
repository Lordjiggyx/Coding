#Take two lists, say for example these two:
#  a = [1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89]
# b = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]
#and write a program that returns a list that contains
#only the elements that are common between the lists (without duplicates)
#Make sure your program works on two lists of different sizes.
#no duplicates

a = [1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89]
b = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]
c = []
d = []
#for loop getting ridding of anything not common
#for x in a:
#    if(x in b and x in a):
 #       c.append(x)
#print(c)

#list comprehension getting ridding of anything not common
x = ([c for c in a if c in b and c in a])
print(x)

#For loop getting rid of duplicates
for a in x:
    if(a not in c):
        c.append(a)
print(c)