//Array of questions

const questions = [
    {Question:"What is your name"},
    {Question:"How old are you"},
    //Using regex to make sure it's an emai;
    {Question:"What is your email" , pattern: /\S+@\S+\.\S+/},
    //make the values entered hiddem
    {Question:"Create A passoword" , type:'password'}
]

//Transition times

//variable for shake
const shakeTime =65;
//variable to switch of question
constswithTime = 200
//The position of the question initialised to the first one
let position = 0

//DOM elements - all the id fields
const formBox = document.querySelector('#form-box');
const nextBtn = document.querySelector('#next-btn');
const prevBtn = document.querySelector('#prev-btn');
const inputGroup = document.querySelector('#input-group');
const inputField = document.querySelector('#input-field');
const inputLabel = document.querySelector('#input-label');
const inputProgress = document.querySelector('#input-progress');
const progress = document.querySelector('#progress-bar');


//Events

//This loads the first question
document.addEventListener('DOMContentLoaded' , getQuestions)

//Next Button click
nextBtn.addEventListener('click' , validate)

//enter eventyy
inputField.addEventListener('keyup', e => 
{
    if(e.keyCode ==13)
    {
        validate()
    }
})



//Functions

//get question from array an add to mark up
function getQuestions()
{
//Get the current question
inputLabel.innerHTML = questions[position].Question


//Get current type
inputField.type = questions[position].type || 'text'


//Get the current answer
inputField.value = questions[position].answer || ''

//focus on current element
inputField.focus();

//Set progress bar width - variable to the questions array length
progress.style.width =[position * 100] / questions.length + '%'

//Add user icon or back arrow depending on questions
prevBtn.className = position ? 'fas fa-arrow-left' : 'fas fa-user';

showQuestion()
}


//Display question to user
function showQuestion()
{
    inputGroup.style.opacity = 1;
    inputProgress.style.transition = ''
    inputProgress.style.width = '100%'
}

//Hide question 
function hideQuestion()
{
    inputGroup.style.opacity = 0;
    inputLabel.style.marginLeft=0;
    inputProgress.style.width=0;
    inputProgress.style.transition='none';
    inputGroup.style.border=null;
}

//Function for tranformation that creates shake motion
function transform(x ,y)
{
    formBox.style.transform = `translate(${x}px , ${y}px)`
}



//validate field
function validate()
{
    //ensure pattern matches if there is one 
    if(!inputField.value.match(questions[position].pattern || /.+/))
    {
        inputFail()
    }
    else
    {
        inputPass()
    }
}


//Field input fail
function inputFail()
{
    formBox.className = 'error'
    //repeat shake motion usinf for loop using i as the numbe rof shakes

    for(let i =0; i <6; i++)
    {
        setTimeout(transform, shakeTime * i, ((i % 2) * 2 - 1) * 20, 0);
    setTimeout(transform, shakeTime * 6, 0, 0);
        inputField.focus()
    }


}

//field input sucess
function inputPass()
{
    formBox.className = ''
    setTimeout(transform, shakeTime * 0 , 0 ,10);
    setTimeout(transform, shakeTime * 1 , 0 ,0);


    
//Store answer in array
questions[position].answer = inputField.value
    //Increment Postion
position++;




//If new question hide ciurrent and get next
if(questions[position])
{
    hideQuestion()
    getQuestions()
}
else
{
    //remove if no more questions left
    hideQuestion();
    formBox.className = 'close'
    progress.style.width ='100%'


    //Form complete
    formComplete()
}
}


//All fields complete ending message

function formComplete()
{
    console.log(questions)
    const h1 = document.createElement('h1')
    h1.classList.add('end');
    h1.appendChild(document.createTextNode(`Thanks ${questions[0].answer} You will get a conformation email shortly`))
    setTimeout(()=>
    {
        formBox.parentElement.appendChild(h1)
        setTimeout(()=> (h1.style.opacity = 1) , 50)
    },1000)
}