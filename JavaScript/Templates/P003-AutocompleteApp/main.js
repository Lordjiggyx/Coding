//Grab any DOM elements

let search = document.getElementById('search')
let match = document.getElementById('match-list')

//Event listeners - arrow function
search.addEventListener('input' , () => searchStates(search.value))


//Searvh the states.json and filter it
//This will use fecth api which returns a promise
//use async await when dealing with promises so it loads asynchrousnously
const searchStates = async searchText =>
{
    //Variable for response
    const res = await fetch('./data/states.json')
    //Array of states
    const states = await res.json()

   //console.log(states);

    //Gte matches to current text input
    let matches = states.filter(state =>
        {
            //Matches whwter it is uppercase or lowercase
            const regex = new RegExp(`^${searchText}` , 'gi')
            //Return the array on name and abb
            return state.name.match(regex) ||state.abbr.match(regex)

        })

    //clears html if there is no text in the input
    if(searchText.length===0)
    {
        matches = []
        match.innerHTML=''
    }



//create empty array incase there is no input
if(searchText.length ===0)
{
    matches=[]
}
ouputHtml(matches)
}

//Show results in HTML
const ouputHtml = matches =>
{
    if(matches.length > 0)
    {
        //Map through matches array and use join to take the html and turn it into a string
        const html = matches.map(match=>`
        <div class ="card card-body mb-4">
        <h4>${match.name}(${match.abbr}) <span class = "text-primary">${match.capital}</span></h4>
        <small>Latitude: ${match.lat} / Longitude${match.long}</small>
        </div>`).join('')
       
       match.innerHTML = html
    }
    
    
}