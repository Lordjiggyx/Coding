import React, { Component  , useState} from 'react'
import { grommet, Box, Button, Grommet, Nav, Text } from "grommet";
import "../../CSS/ProfileComponents/Profile.css"

export class SideMenu extends Component {
    
    state = 
    {
        active:"",
        label:" "
        
    }
    render() {
      const {goTo} = this.props;

      const sideMenuData= ["User Information", "Personal Information" , "Health Information" ,"Create Dashboard" ]

      const customTheme = {
          button: {
            border: {
              radius: "100px",
              color: 'white',
              Text:'#FFFFFF'
            },
            color:"#FFFFFF"
           
          },
        };

        return (
          <div>

          <Grommet theme={customTheme}>
                    <ul>
                        <li>
                        <Button label={sideMenuData[0]}
                        onClick={goTo(1)} />
                        </li>

                        <li>
                        <Button label={sideMenuData[1]}
                        onClick={goTo(2)}/>
                        </li>

                        <li>
                        <Button label={sideMenuData[2]}
                        onClick={goTo(3)}/>
                        </li>

                        <li>
                        <Button label={sideMenuData[3]}/>
                        </li>
                    </ul>
                    </Grommet>
          </div>
        )
    }
}



export default SideMenu
