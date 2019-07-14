import React from "react"



class FormApp extends React.Component
{
    constructor()
    {
        super()
        this.state = {
            firstname: "",
            lastname:"",
            isFriendly: true,
            gender :" ",
            favColor: " "
        }

        this.Handle = this.Handle.bind(this)
    }



      
Handle(event)
{
//1. we want to grab the current value of the input box
//2. update state to reflect the current value of the input box is 

//This gets the name of the targeted input field and changes the value appropriatley
    

if(event.target.type ==="checkbox")
{
    this.setState({
        
    [event.target.name]:event.target.checked
    })
}

else
{
    this.setState({
        [event.target.name]:event.target.value
    })
    console.log(event.target.value)
}
}


    render()
    {
        
        return(
           <form>
               {/**A naem property is given to the input objects to be referenced in the handle method */}
               <input type ="Text"  name = "firstname"placeholder = "Enter First Name..." onChange = {this.Handle}/>
               <h4>{this.state.firstname}</h4>
               <input type ="Text"  name = "lastname"placeholder = "Enter First Name..." onChange = {this.Handle}/>
               <h4>{this.state.lastname}</h4>

               <textarea 
               
               onChange = {this.Handle}
               />

                <br/>
               <input 
                    type = "checkbox" 
                    checked={this.state.isFriendly}
                    name = "isFriendly"
                    onChange = {this.Handle}
                />
                is he freindly??

                <br/>
                <input 
                    type = "radio" 
                    checked={this.state.gender ==="male"}
                    name = "gender"
                    onChange = {this.Handle}
                    value = "male"
                />Male
                <input 
                    type = "radio" 
                    checked={this.state.gender === "female"}
                    name = "gender"
                    onChange = {this.Handle}
                    value = "female"
                />Female

            <br/>
                <select
                value = {this.state.favColor}
                onChange={this.Handle}
                name = "favColor"
                >
                    <option value = " Pink">Pink</option>
                    <option value = " Yellow">Yellow</option>
                    <option value = " Black">Black</option>
                    <option value = " Red">Red</option>

                </select>


           </form>
        )
    }
}

export default FormApp