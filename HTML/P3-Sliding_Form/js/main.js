
const signupButton = document.getElementById('signUp')

const signInButton = document.getElementById('signIn')

const container = document.getElementById('container')

signupButton.addEventListener('click', ()=>
{
    container.classList.add('right-panel-active')
})
signInButton.addEventListener('click', ()=>
{
    container.classList.remove('right-panel-active')
})



