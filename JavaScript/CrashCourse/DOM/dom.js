//PART 1 

//Used to show all the properties attached to the document
//console.dir(document.domain);

//Gives us an html collection of eveerything in the dom
//console.log(document.all)

//There are a number of properties that can be selected 
//not all of them wil be covered


//*****GETELEMENTBYID******//

console.log(document.getElementById('header-title'));
//Can create a variable with this method
const headerTitle = document.getElementById('header-title');
//const header = document.getElementById('mainHeader');
console.log(headerTitle);

//can change text
//headerTitle.textContent = "Hello";
//inner text pays attention to style
//headerTitle.innerText  = 'Goodbye';

//can add html with innerHtml
//headerTitle.innerHTML = "<h1> Bye</h1>"

//Style changes to css
//headerTitle.style.borderBottom ='Solid 3px black'


//*****GETELEMENTSBYCLASSNAME******//
/*
const items = document.getElementsByClassName('list-group-item');
items[1].textContent = 'hELLO 2'
items[1].style.fontWeight = 'bold'
items[1].style.backgroundColor = 'yellow'


//Loop through list and cdhange colour
for(const i = 0 ; i<items.length; i++)
{
 items[i].style.backgroundColor= "#f4f4f4"
}
*/


//*****GETELEMENTSBYTAGNAME******//
/*
const li = document.getElementsByTagName('li');
li[1].textContent = 'hELLO 2'
li[1].style.fontWeight = 'bold'
li[1].style.backgroundColor = 'yellow'


//Loop through list and cdhange colour
for(const i = 0 ; i<li.length; i++)
{
 li[i].style.backgroundColor= "#f4f4f4"
}
*/

//*****QUERYSELECTOR******// Only for one item can select anything can use any css selector
//esstentially your using the document. to grab a property the using the value to edit it
/*
const header = document.querySelector("#main-header");
header.style.borderBottom='solid 4px grey';

const input = document.querySelector('input');
input.value = 'Hello World';

const submit = document.querySelector('input[type ="submit"]')
submit.value = 'Send'

const item = document.querySelector('.list-group-item')
item.style.color = 'red'

const last = document.querySelector('.list-group-item:last-child')
last.style.color = 'blue'
*/


//*****QUERYSELECTORALL******//
/*
//CSS Selectors can be used aswell
const titles = document.querySelectorAll('.title')

console.log('titles')

const odd = document.querySelectorAll('li:nth-child(odd)');
const even = document.querySelectorAll('li:nth-child(even)');
for(let i = 0; i<odd.length; i++)
{
    odd[i].style.backgroundColor = '#f4f4f4'
}

for(let i = 0; i<even.length; i++)
{
    even[i].style.backgroundColor = 'blue'
}
*/

//Part 2

///Traversing the Dom//

//PARENT NODES///

const itemlist = document.querySelector('#items')
//parent node
/*
//Gives the parent node of items which is the div
console.log(itemlist.parentNode);
//Can be use as a selector 
itemlist.parentNode.style.backgroundColor = '#f4f4f4'
//Gives the parent node of the div whichc is container
console.log(itemlist.parentNode.parentNode)
*/

////ParentElement// - same as parent node
/*
console.log(itemlist.parentElement);
itemlist.parentElement.style.backgroundColor = 'aqua'
console.log(itemlist.parentElement.parentElement)
*/

//CHILD NODES//
//console.log(itemlist.childNodes);
/*
console.log(itemlist.children)

//firstchild

console.log(itemlist.firstChild);
//first elementchild - gets teh actual li
console.log(itemlist.firstElementChild);
//changing first item in the list
itemlist.firstElementChild.textContent = 'Hello World'

//changing last item in the list
itemlist.lastElementChild.textContent = 'Goodbye World'
*/

//SIBLINGS//
/*
//next sibling 
console.log(itemlist.nextSibling)
//next element sbling
console.log(itemlist.nextElementSibling)

//previousSibling
console.log(itemlist.previousSibling);

//previous element sibling
console.log(itemlist.previousElementSibling)
itemlist.previousElementSibling.style.color = 'green'
*/

///Creating Dom elements///
/*
 const newDiv = document.createElement('div');

 //adding a class to it
 newDiv.className = 'Hello'

//adding an id to it
newDiv.id = 'Hello1'

//adding an attribute e.g. a title
newDiv.setAttribute('title' , 'Hello Div')

//Create a text node
const newDivText = document.createTextNode('Hello World');

//add text to the div
newDiv.appendChild(newDivText);

//Placing the text in the header container
const container = document.querySelector('header .container');
const h1 = document.querySelector('header h1');

container.insertBefore(newDiv , h1)


//Change font size
newDiv.style.fontSize='30px'

console.log(newDiv);
*/

//PART THREE EVENTS//////

//ADDING AN EVENT LISTENER
https://www.w3schools.com/jsref/dom_obj_event.asp- list of html dom event listeners

///Button event///
/*
const button = document.getElementById('button').addEventListener
('click' , buttonClick)

//passing the e means that it is listening for an event
function buttonClick(e)
{
   // console.log("Button clicked")
 //document.getElementById('header-title').textContent = 'Changed by button';
 //document.querySelector('#main').style.backgroundColor = 'red'

 //Output items into the dom for example printing the the type of element being clicked
//onst output = document.getElementById('output');
//output.innerHTML = '<h3>' +e.target.id + '</h3>';

//Type of action
//console.log(e.type)

//Location of the mouse on the x axis can do y aswell form the windpw
//console.log(e.clientX)

//Actual element
//console.log(e.offsetX)
}
*/

///Mouse Listener////
//button = document.getElementById('button').addEventListener
//('click' , runEvent)

//Chcek that the mouse netered the box
 //const box = document.getElementById('box')

 //box.addEventListener('mousemove', runEvent)

//Input Listener//
 itemInput = document.querySelector('input[type = "text"]');
 form = document.querySelector('form');
 select = document.querySelector('select');

//itemInput.addEventListener("keydown" , runEvent)

//Focus when something is active
//itemInput.addEventListener("focus" , runEvent)

//Blur is when you leave an active area by clicking away
//itemInput.addEventListener("blur" , runEvent)

//input tells when your working withh anything that is an input field
//itemInput.addEventListener("input" , runEvent)

//To listen if theres a change with the select box
select.addEventListener("change" , runEvent)

//To listen if theres an input  with the select box
select.addEventListener("input" , runEvent)


//Submit listener on the form
form.addEventListener("submit" , runEvent)
function runEvent(e)
{
    //Prevents the default behaviour
    e.preventDefault();
    console.log('EVENT TYPE:' +e.type);

    //fIND MOUSE POSTION CHANGE LISTENER TO  MOUSE MOVE
   // output.innerHTML = '<h3>MouseX: '+e.offsetX+ ' </h2><h3> MouseY: ' + e.offsetY+ '</h3>'

    //Change the color of box
   //box.style.backgroundColor = "rgb("+e.offsetX+","+e.offsetY+",40)";
  
   //Change the color of the body of the document
  // document.body.style.backgroundColor = "rgb("+e.offsetX+","+e.offsetY+",40)";

  console.log(e.target.value);
  document.getElementById('output').innerHTML = '<h3>'+e.target.value+'</h3>'
}