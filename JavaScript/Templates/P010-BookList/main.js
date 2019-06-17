//Create book class

class Book
{
    constructor(title , author , isbn)
    {
        this.title = title;
        this.author = author;
        this.isbn = isbn
    }
}


//DOM elements

//The table in the document
var table = document.getElementById('table-body')

//This represnts where the books will be added
var bookitems = document.getElementById('books')

var Submit = document.getElementById('submit')






//Add book

function addBook(e)
{
     //To prevent default behaviour
     e.preventDefault();

     //Field value inputs
     var title = document.getElementById("title")
     var author = document.getElementById("author")
     var isbn = document.getElementById("isbn")


     //The actual book object
     var book = new Book(title.value , author.value , isbn.value)

    //This is the table row that will contain the items
    var row = document.createElement('tr')

    //These are the row items that will be created and taking in the book values
     var tdTitle = document.createElement('td');
     var tdAuthor = document.createElement('td');
     var tdIsbn = document.createElement('td');


     //Create a detlete button element
    var btnDelete = document.createElement('button');
    //Add delete button classes
    btnDelete.className="btn center-align delete";
    //Append the text node which is the x inside the button
    btnDelete.appendChild(document.createTextNode('x'))
   


     //Each item gets a class of row item
     tdTitle.className = 'row-item center-align'
     tdAuthor.className = 'row-item center-align'
     tdIsbn.className = 'row-item center-align'

   
     //The book values will be appeneded to the table items item
     tdTitle.appendChild(document.createTextNode(book.title))
     tdAuthor.appendChild(document.createTextNode(book.author))
     tdIsbn.appendChild(document.createTextNode(book.isbn))

     //Each item is added to the row
     row.append(tdTitle , tdAuthor , tdIsbn , btnDelete)
     
     console.log(row)

     table.appendChild(row)

     //Clear form fields
    title.value = ''
    author.value=''
    isbn.value=''

}


function deleteBook(e)
{
   //if statement to ensure delete only occurs when x buton is clicked
   if(e.target.classList.contains('delete'))
   {
       console.log(1)
   //Confirmation pop up box for user
   if(confirm('Are You Sure?'))
   {
       //if yes a new li variable
       //We use the parent element li as the button is part of the li family
       //thus we need to remove the child from theitem 
       var tr = e.target.parentElement;
       //The li is a child of the itemlist which is the ul which we 
       //can remove using the removechild methd
       table.removeChild(tr)
   }

}
}

Submit.addEventListener('click' , addBook)
table.addEventListener('click' ,deleteBook)
