import React, { Component } from 'react'
import Navabr from '../General/Navabr';

export class Success extends Component {
    render() {
        return (
            <div>
                <Navabr/>
                <h1>Congrats you have created an account You will recieve an email prompting you to verify your account </h1>
            </div>
        )
    }
}

export default Success
