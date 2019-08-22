#Alloes you constrcut a list in one line
#rather then writing data there is an expression with for loops and if clauses
#[expression for value in collection]
#[expression for val in collection if <test>]
#Expressions return values thus we can put a simple expression at the at the start of the list

#Adds th square value to a list of 1 - 100
squares = []
for i in range(1,101):
    squares.append(i**2)

print(squares)

#Comprehension
squares2 =[i**2 for i in range(1,101)]
print(squares2)

remainder5 = [x**2 % 5 for x in range(1,101)]
print(remainder5)

#Get movies with letters that begin with G
movies =["Star wars"  , "Gandhi" , "Casablanca" , 
"Toy Story" , "Gone with the wind", "Ghostbusters", "SpaceOdessy"]
#Get movies with letters that begin with G
gmovies = [title for title in movies if title.startswith("G")]
print(gmovies)

#Get movies that were made before 2000
#When getting values tuples or multiple values the values go in brackets
yearmovies =[("Star wars" , 1941) , ("Gandhi", 2001) , ("Casablanca", 1987) , 
("Toy Story",2004) , ("Gone with the wind" , 2008), ("Ghostbusters", 1990), ("SpaceOdessy", 2012)]
oldmovies = [title for (title , year) in yearmovies if year<2000]
print(oldmovies)

#Multiple numbers by 4
v = [1 , 2, 3, 4,5]
w = [4*x for x in v ]
print(w)

#Cartsian product
A = [1 , 3, 5 , 7]
B = [2 , 4, 6 , 8]

cartesian_product =[(a,b) for a in A for b in B]
print(cartesian_product)

#Essentially you create a value or a pair on the left
#Then you create a loop indictaing that the value is in the list
