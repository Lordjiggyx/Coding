/*We want to do the following things
1.Add an item
2.Remove an item - Take the item list and add an event listener
3.Filter the items

*/
///VARIABLES///

//Variable to manipulate form to add items
var form = document.getElementById('addForm')

//Variable that represents the items in the html file which will allow 
//us to delete items
var itemList = document.getElementById('items');

//Variable for filtering items represents the fitler bar at the top
var filter = document.getElementById('filter')


///EVENT LISTENERS///

//Delete event listener for deleting elements
itemList.addEventListener('click' , removeItem)

//form submit event for submiting elements
form.addEventListener("submit" , addItem)

//Filter event listener 
//The keyup event occurs when a keyboard key is released
filter.addEventListener("keyup" , filterItems)



//Function to add item
function addItem(e)
{
    //To prevent default behaviour
    e.preventDefault();

    //Testing to see if submit function works
    //console.log(1)

    //Get input value making reference to input id in htmk file
    var newItem = document.getElementById("item").value

    //Create a new li element
    var li = document.createElement('li');
    //Also add class
    li.className = 'list-group-item'
    //Test to see if a new li element is added
    console.log(li)

    //Add text node with input value from the form and append
    //Takes in value which is newItem value
    li.appendChild(document.createTextNode(newItem))

    //Create a detlete button element
    var btnDelete = document.createElement('button');
    //Add delete button classes
    btnDelete.className="btn btn-danger btn-sm float-right delete";
    //Append the text node which is the x inside the button
    btnDelete.appendChild(document.createTextNode('X'))
    //Append the button to the list item
    li.appendChild(btnDelete);

    //list item with text entered and button added to the list of items
    itemList.appendChild(li)
}

//Function to remove an item
function removeItem(e)
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
        var li = e.target.parentElement;
        //The li is a child of the itemlist which is the ul which we 
        //can remove using the removechild methd
        itemList.removeChild(li)
    }

    }

}

//Function to filter items
function filterItems(e)
{
    //Convert text to lower case
    var text = e.target.value.toLowerCase();
    //Test
    //console.log(text)

    //Grab all the li's within the item list
    var items = itemList.getElementsByTagName('li')

    //convert an array to be able to loop through
    //pass html collection into Array.from() method
    //create a function that makes an 'item' variable for every 
    //li object found in the array
    Array.from(items).forEach(function(item)
    {
        //create a variable for the item name 
        var itemName = item.firstChild.textContent;
        //This is a test to see that the elements in the array are printed out
        console.log(itemName)

        //Compare to see if item name is = to searchbox text 
        //if it is not a match it will equal -1 
        //so if it doesnt equal -1 then thaht means its true
        if(itemName.toLowerCase().indexOf(text) != -1)
        {
            //We want the item to show
            item.style.display = 'block';
        }
        else
        {
            //We dont want it to show if it is not true
            item.style.display = 'none';
        }


    });

}