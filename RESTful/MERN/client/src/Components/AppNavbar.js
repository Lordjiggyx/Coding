//Importing react and the components
import React , {Component} from "react"

//Importing navvar properties from reactstrap
import
{
    Collapse,
    Navbar,
    NavbarToggler,
    NavbarBrand,
    Nav,
    NavItem,
    NavLink,
    Container,
} from "reactstrap"

//Bringing in nav links
import Reg from "./auth/Reg"
import Logout from "./auth/Logout"
import Login from "./auth/Login";


//Connect to redux by bringing in connect from react redux
import { connect } from 'react-redux'


//Bring in proptypes to set proptypes
import PropTypes from "prop-types"


class AppNavbar extends Component
{

    constructor(props)
    {
        super(props)
        this.state = 
        {
            isOpen: false
        }

        //Binding function
        this.toggle = this.toggle.bind(this)

    }

    //Bringing in our proptypes
    static propTypes = 
    {
        auth:PropTypes.object.isRequired
    }

 //Toggle Function for the hamburger menu
 toggle()
 {
     this.setState({
         isOpen: !this.state.isOpen
     })
 }



    render()
    {
        //Taking the values from the auth reducer
        const {isAuthenticated , user} = this.props.auth

        //Logged in links 
        const logLinks = (
            <div>
                <NavItem>
                    <span className='navbar-text mr-3'>
                        <strong>{user ? `Welcome ${user.name}` : ''}</strong>
                    </span>
                </NavItem>
                
                 <NavItem>
                    <Logout></Logout>
                </NavItem>
            </div>
        )

        //Guest links

        const guestLinks = (
            <div>
                 <NavItem>
                    <Login></Login>
                </NavItem>

                <NavItem>
                    <Reg></Reg>
                </NavItem>

            </div>
        )

        return(
            <div>
                <Navbar color = "success" dark expand = "sm" className="mb-5">
                    <Container>
                        <NavbarBrand href = "/">
                            The M.E.R.N Shopping List
                        </NavbarBrand>
                        <NavbarToggler onClick={this.toggle}/>
                        <Collapse isOpen = {this.state.isOpen} navbar>
                            <Nav className = "ml-auto" navbar>
                            {isAuthenticated ? logLinks : guestLinks}
                            </Nav>
                        </Collapse>
                    </Container>
                </Navbar>
            </div>
        )
    }
}


const mapStateToProps = state => ({
    //These values are being taken from the rootreducer so refer to them exact
   auth:state.auth
  });


export default connect(
    mapStateToProps,
    null
  )(AppNavbar);