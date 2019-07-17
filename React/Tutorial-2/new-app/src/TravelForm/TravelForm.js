import React from "react"



class TravelForm extends React.Component
{

    constructor()
    {
        super()
        this.state = {
                firstname:"",
                lastname:"",
                age:" ",
                gender:"",
                Location:"",
                nuts:true,
                lactose:false,
                Shellfish:false
                

            
        }
        //Binding the handle method to the class so it can be used
        this.handle = this.handle.bind(this)
    }
    handle(event)
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
        <main>
            <form>
            <br/>
            <input
             type ="Text" 
             value = {this.state.firstname} 
             name = "firstname"
             onChange = {this.handle}
             placeholder = "Enter First Name..."
             />
            <br/>
            <input
            type ="Text"
            value = {this.state.lastname} 
            onChange = {this.handle}
            name = "lastname"
            placeholder = "Enter Last Name..."
            />
            <br/>
            <input 
            type= "number"
            value = {this.state.age} 
            onChange = {this.handle}
            name = "age" 
            placeholder = "How old are you.."/>
            <br/>

        {/*Wrapping radio bbuttons with a label tag allows the text to be clicked  */}
            <label>
                <input 
                type = "radio" 
                checked={this.state.gender ==="male"}
                name = "gender"
                onChange = {this.handle}
                value = "male"
                />Male
     </label>

             <label>
                <br/>
                <input 
                type = "radio" 
                checked={this.state.gender ==="female"}
                name = "gender"
                onChange = {this.handle}
                value = "female"
                />Female
          </label>
<br/>       


                <select 
                name = "Location"
                value = {this.state.Location}
                onChange = {this.handle}
                >
                     <option value = "">-----Choose A Destination----</option>
                    <option value = " Brazil">Brazil</option>
                    <option value = " Tokyo">Tokyo</option>
                    <option value = " USA">USA</option>
                    <option value = " UK">UK</option>
                 

                </select>


                <br/>

                <label>
                <input 
                    type = "checkbox" 
                    name = "nuts"
                    onChange = {this.handle}
                    checked ={this.state.nuts}
                />
                Nuts
                </label>
               
                <label>
                <input 
                    type = "checkbox" 
                    name = "lactose"
                    onChange = {this.handle}
                    checked = {this.state.lactose}
                />
                lactose
                </label>
               
                <label>
                <input 
                    type = "checkbox" 
                    name = "Shellfish"
                    onChange = {this.handle}
                    checked = {this.state.Shellfish}
                />
                Shellfish
                </label>
               

                <br/>


                <button>Submit</button>
            </form>

            <hr/>

            <h2>Entered Information</h2>
            <p>Your First Name:{this.state.firstname}</p>
            <p>Your Last Name:{this.state.lastname}</p>
            <p>Your Gender:{this.state.gender}</p>
            <p>Your Age:{this.state.age}</p>
            <p>Your Location:{this.state.Location}</p>
            <p>Your Dietary Restrctions:
            <br/>
            nuts:{this.state.nuts ? "Yes" : "No"}
            <br/>
            lactose:{this.state.lactose ? "Yes" : "No"}
            <br/>
            Shellfish:{this.state.Shellfish ? "Yes" : "No"}
            <br/>
            </p>
        </main>
        )
    }
}

export default TravelForm