//There are a lot of ways to write js code


//First we will seclect the DOM elements

const time=document.getElementById('time'),
      greeting = document.getElementById('greeting'),  
      name = document.getElementById('name') , 
      focus = document.getElementById('focus'); 



//Create a function to show the time 
function showTime()
{
    //let today =new Date(),
    let today =new Date(),
    hour=today.getHours(),
    min=today.getMinutes(),
    seconds=today.getSeconds();


//Set AM / PM
//To do this we will assign am/pm ot a variable depending on a condition
const amPm = hour>= 12 ? 'PM' : 'AM'

//12HR FORMAT
hour = hour % 12 || 12

//Output Time
time.innerHTML = `${hour}<span>:</span>${addZero(min)}<span>:</span>${addZero(seconds)} ${amPm}`;

//This method takes in a function and an intervak of time to repeat the method
setTimeout(showTime , 0.5)


}


//Add Zero's
function addZero(n)
{
    //If the current value of the time is less then 10 we must add a zero
    //else it remains the same 
    return(parseInt(n , 10) < 10 ? '0' : '') +n
}


//Set thebackground and greeting depending on time of day 
function setbgGreet()
{
    let today = new Date(),
    hour = today.getHours();

if(hour < 12)
{
    //Morning
    document.body.style.backgroundImage = "url(https://source.unsplash.com/1600x900/?sun)"
    greeting.textContent = 'Good Morning'
}
else if(hour<18)
{
    //Afternoon
    document.body.style.backgroundImage = "url(https://source.unsplash.com/1600x900/?clouds)"
    greeting.textContent = 'Good AfterNoon'
    document.body.style.color = 'white';
}
else
{
    //Evening
    document.body.style.backgroundImage = "url(https://source.unsplash.com/1600x900/?stars)"
    greeting.textContent = 'Good Evening'
    document.body.style.color = 'white';


}
}

//Get Name 
function getName()
{
    //This checks if there is an element that exists in the local storage called name
    if(localStorage.getItem('name') === null)
    {
        name.textContent = 'Please Enter Name....'
    }
    else
    {
        name.textContent = localStorage.getItem('name')
    }
}

//Set the name
function setName(e)
{
    //Check to see if it is a keypress
    if(e.type === 'keypress')
    {
        //Ensure the enter key is press 13 is the code for th enter key
        if(e.which == 13 || e.keyCode==13)
        {
            localStorage.setItem('name' , e.target.innerText)
            //exit the state
            name.blur()
        }
    }
    else
    {
        //Used to store the name variable
        //the second value is the text of the element being grabbed
        localStorage.setItem('name' , e.target.innerText)
    }
}



//Get foucs
function getFocus()
{
    //This checks if there is an element that exists in the local storage called name
    if(localStorage.getItem('focus') === null)
    {
        focus.textContent = 'Enter Focus...'
    }
    else
    {
        focus.textContent = localStorage.getItem('focus')
    }
}

//Set the focus
function setFocus(e)
{
    //Check to see if it is a keypress
    if(e.type === 'keypress')
    {
        //Ensure the enter key is press 13 is the code for th enter key
        if(e.which == 13 || e.keyCode==13)
        {
            localStorage.setItem('focus' , e.target.innerText)
            //exit the state
            focus.blur()
        }
    }
    else
    {
        //Used to store the name variable
        //the second value is the text of the element being grabbed
        localStorage.setItem('focus' , e.target.innerText)
    }
}


//Event listeners

//Two events that call the same method
//If the user hits enter it will update
name.addEventListener('keypress' , setName)
//if they type and click off it will update
name.addEventListener('blur' , setName)

//If the user hits enter it will update
focus.addEventListener('keypress' , setFocus)
//if they type and click off it will update
focus.addEventListener('blur' , setFocus)


//RUN
showTime()
setbgGreet()
getName()
getFocus()