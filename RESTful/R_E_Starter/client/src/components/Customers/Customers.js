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
        fetch('/api/customers')
        .then(res => res.json())
        .then(customers =>
            {
                this.setState
                ({
                    customer:customers
                },
                ()=>
                {
                    console.log("Customers Fetched......", customers)
                })
            })
        
    }
    render()
    {
        
        return(
            <div>
                <h2>Customers</h2>

                <ul>
                    {this.state.customer.map(customer =>
                    
                        <li key={customer.id}>
                            <p>
                            {customer.name}
                            <br/>
                            {customer.email}
                            </p>
                            
                        </li>
                    )}

                </ul>
            </div>
        )
    }
}

export default Customers 