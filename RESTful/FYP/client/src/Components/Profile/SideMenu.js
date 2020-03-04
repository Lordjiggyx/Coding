import React, { Component  , useState} from 'react'
import { grommet, Box, Button, Grommet, Nav, Text } from "grommet";
import "../../CSS/ProfileComponents/sidebar.css"
export class SideMenu extends Component {
    
    state = 
    {
        active:"",
        label:" "
        
    }
    render() {

        return (
            <Grommet>
            <Box fill direction="row">
                <div className="sideMenu">
              <Nav background="green">
                {["Dashboard", "Devices", "Settings" , "Settings" , "Settings" , "Settings" , "Settings" , "Settings"].map(label => (
                  <SidebarButton
                    key={label}
                    label={label}
                    // active={label === active}
                    onClick={() =>this.setState({active:label})}
                  />
                ))}
              </Nav>
              </div>
            </Box>
          </Grommet>
        )
    }
}


const SidebarButton = ({ label, ...rest }) => (
    <Button plain {...rest}>
      {({ hover }) => (
        <Box
          background={hover ? "#D976ED" : undefined}
          pad={{ horizontal: "large", vertical: "medium" }}
        >
          <Text size="large">{label}</Text>
        </Box>
      )}
    </Button>
  );


export default SideMenu
