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

      const sideMenuData= ["Acount Details", "Update Details " , "Delete Account"]

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
            <div className="menu_list">
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

                        {/* <li>
                        <Button label={sideMenuData[3]}/>
                        </li> */}
                    </ul>
                    </div>
                    </Grommet>
          </div>
        )
    }
}



export default SideMenu
