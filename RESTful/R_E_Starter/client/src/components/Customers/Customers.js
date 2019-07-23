import React from "react"
import "../Customers/Customers.css"


class Customers extends React.Component
{

    constructor()
    {
        super()
        this.state = {
            customer:[]

            
        }

       

    }

    componentDidMount()
    {
        fetch("/api/customers" )
        .then(res => res.json()
        )
        .then(data =>
            {
                this.setState
                ({
                    customers:data
                },
                ()=>
                {
                    console.log("Customers Fetched......", data)
                })
            })
        
    }
      
    render()
    {
        
        return(
            <div>
                <h2>Customers</h2>
            </div>
        )
    }
}

export default  Customers 