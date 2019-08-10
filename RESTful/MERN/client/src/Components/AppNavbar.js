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

 //Toggle Function for the hamburger menu
 toggle()
 {
     this.setState({
         isOpen: !this.state.isOpen
     })
 }



    render()
    {
        
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
                                <NavItem>
                                    <NavLink href= "https://youtube.com">
                                        Click To Go to Youtube
                                    </NavLink>
                                </NavItem>
                            </Nav>
                        </Collapse>
                    </Container>
                </Navbar>
            </div>
        )
    }
}

export default AppNavbar