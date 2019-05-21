/*console.log('Hello World');
console.error('tHIS is anN ERROR');




const name =  "John";
const age = 40;


//console.log(typeof)used to identify what type the variable is
console.log(typeof rating)

//Concatenation - old method
console.log("This is your age:" + age);

//Concatenation -new method - using template strings
//Must use back ticks to utilise the template strings
const hello = `my name is ${name} and i am ${age} old`

console.log(hello)

const s = "Hello World"

//Gets lentgh of String
console.log(s.length);

const Tech = "laptop  , hard-drive , keyboard";
//This creates an array of elements from a string using the comma as a delimiter in the string
console.log(Tech.split(","));

//Object literal
const person = {

    firstname: "Tomi",
    lastname:"Ilori",
    age: 20,
    hobbies:["Music" , "Reading" ,"Sports"] ,
    address:{
        Street:269,
        city:"Tyrrelstown",
        county:"Dublin"
  }
}

console.log(person)
//Pulling values form the object
/*const{firstname , lastname , address: {city}} = person;

console.log(city)

//Adding properties
person.email = "Tomiilori123@gmail.com"
console.log(person);
*/

/*
const todos = [
    {
    id:1,
    text:'Take out Trash',
    isCompleted:true
    },

    {
    id:2,
    text:'Metting with Boss',
    isCompleted:true
    },

    {
    id:3,
    text:'Dentist Appointment',
    isCompleted:false  
    }
]

//Getting text from the list
console.log(todos[1].text);

//We recieve a data string
const todoJSON = JSON.stringify(todos);
console.log(todoJSON)

//Loops

//FOR LOOP

for(let i  = 0; i<10 ; i++)
{
console.log(`For Loop Number:${i}`);
}

//While Loop

let i = 0;

while(i < 10 )
{
    console.log(`While loop Number:${i}`)
    i++;
}

//Looping Through Arrays Method one
for(let i  = 0; i< todos.length ; i++)
{
    console.log(todos[i].text)
}

for(let todo of todos)
    {
     console.log(todo.text)
    }

//High Order methods

//ForEach
todos.forEach(function(todo)
{
    console.log(todo.text);
});

//Map - returns an array must declare the new array
const todoText= todos.map(function(todo)
{
   return todo.text;
});
console.log(todoText);

//Filter - returns an array with a condition
const CompletedTask= todos.filter(function(todo)
{
   return todo.isCompleted ===true;
}).map(function(todo)
{
    return todo.text;
})
console.log(CompletedTask);
*/

/*
//Conditionals

const x = 2.0;
if(x == 10)
{
    console.log((`x is 10`))
}
else{
    console.log(`x is not 10`)
}

//Teneary operator
const color = x > 10 ? `red` : `blue`;
console.log(color);

//Switch
switch(color)
{
    case `red`:
    console.log('color is red');
    break;
    case `blue`:
    console.log(`color is blue`)
    break;
    default:
    console.log(`color is not red or blue`);
    break;
}*/

//Functions
/*
function addNums(x , y)
{
    console.log(x + y);
}

addNums(10 ,5);

function addNums(x , y)
{
 return x + y;
}

console.log(addNums(10 ,5));
*/

//ARRROW FUNCTIONS//
/*
const addNums = (x , y)=> console.log(x + y);

addNums(10 ,5);
*/

//Object orientated programming using prototypes
/*
function Person(firstname , lastname , dob)
{
    this.firstname = firstname;
    this.lastname = lastname;
    //uSE OF A DATE OBJECT
    this.dob = new Date(dob);
}
//Using prototypes
Person.prototype.getbirthyear = function()
{
    return this.dob.getFullYear()
}

Person.prototype.getfullname = function()
{
    return `${this.firstname} ${this.lastname}`;
}

//Instantiating the person object
//date object works by MM-DD-YYYY
const person1 = new Person(`Tomi` , `Ilori` , `4-25-1999`)

console.log(person1.getfullname());
*/

//Object oreientated programming using clases
/*
class Person
{
    constructor(firstname , lastname , dob){
    this.firstname = firstname;
    this.lastname = lastname;
    this.dob = dob;
}

getbirthyear()
{
    return this.dob.getFullYear()
}

getfullname()
{
    return `${this.firstname} ${this.lastname}`;
}

}

//INSTANTIATE
let person1 = new Person(`Tomi` , `Ilori` , `25-4-1999`)

console.log(person1.getfullname());
console.log(person1);

Subclasses - same as java 

Class Book
{
    constructor(title , author , year)
    {
        this.title = title
        this. author = author
        this.year = year
    }
}


class Magazine extends Book
{
     constructor(title , author , year , isuue  , month)
     {
         super(title , author , year)
         this.month = month
         this.issue = issue
     }
}

const mag1 = new magazine('mag one ' , 'Tomi Ilori' , 1999 , 1 , 'January')

*/

//DOM
/*
//Selecting done in two ways


//single element uses
//#1 document.getElementById()

//can be assigned to a variable

//My form taken from the html file and is logged
console.log(document.getElementById('my-form'))

//can be assigned to a variable
const form = document.getElementById('my-form')
console.log(form)

//QuerySelcector is another method
console.log(document.querySelector('.container'))


//Multiple elements
//Queryselectorall returns a node list which is very similar to an array
console.log(document.querySelectorAll('.item'))

//Loop through a list of items

const items = document.querySelectorAll('.item')

//For each item found print out the item
items.forEach((item) => console.log(item));

//Manipulation

const ul = document.querySelector(`.items`);

//can call methods on it 
//e.g. .remove method

//This removes the unordered list
//ul.remove();

//Removes the first item in the list
//ul.firstElementChild.remove();

//This changes the text contnent of the first child element
ul.firstElementChild.textContent = `Hello`;

//Also changes text acting like an array by using the index of the list
ul.children[1].innerText = `Tomi`

//Allows you to add html dynamically
ul.lastElementChild.innerHTML ='<h1>This is the last element</h1>';

//Grab the button element
const btn = document.querySelector('.btn');
//Change the css styling on the button
//btn.style.background = 'green';

//Creating an event 
//Takes in the event we want
//Then takes in the function that will be called when the event occurs
//Essentially like an actionlistener in java

btn.addEventListener('click' , (e)=>
{
//Prevents the default behaviour
e.preventDefault();

//changing background
document.querySelector('#my-form').style.background = '#ccc';

//Grabs the and adds the bg-dark class that is in the css file
document.querySelector('body').classList.add('bg-dark');

document.querySelector('.items').lastElementChild.innerHTML = '<h1>The button worked</h1>';
});
*/

//Minor application - takes in value of application and 

//Thes are variables that take the id of the elements in the html file by taking there id values
const myform = document.querySelector('#my-form');
const nameInput = document.querySelector('#name');
const emailInput = document.querySelector('#email');
const msg = document.querySelector('.msg');
const userList = document.querySelector('#users');

//Submit event
myform.addEventListener('submit' , onsubmit);

//Creating a seperate method that occurs when the button is clicked like done in java with the action listener methods
function onsubmit(e)
{
    e.preventDefault();
    //Using .value allows you to get the value passed into the parameters
    //If statement to ensure both fields are filled
    if(nameInput.value === '' || emailInput === '')
    {
        //adds error class from css
        msg.classList.add('error');
        msg.innerHTML = 'Please Enter all fields!'

        //Makes messagae go after 3 seconds
        setTimeout(()=> msg.remove  ,3000)
    }
    else
    {
        //creates a list item and then adds it to the list
        const li = document.createElement('li');
        //This adds text ro the li element which is taling the name and email
        li.appendChild(document.createTextNode(
            `${nameInput.value}:
            ${emailInput.value}`
            ));

        //append the li to the list
        userList.appendChild(li);
        

        //Clear fields
        nameInput.value = ""
        emailInput.value =""
    }
}