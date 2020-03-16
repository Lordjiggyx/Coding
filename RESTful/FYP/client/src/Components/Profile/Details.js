import React, { Component  , useState } from 'react'
import Navabr from '../General/Navabr';
import "../../CSS/ProfileComponents/Profile.css"
import { Grommet, Box, Button, Grid, Text, List } from "grommet";
import SideMenu from './SideMenu';
import HealthInfo from './HealthInfo';
import PersonalInfo from "./PersonalInfo"
import UserInfo from './UserInfo';
import axios from "axios"


export class Details extends Component {

state =
{
    step:1,
    email:""
}


componentDidMount =  ()=>
{
    this.setState(
        {
            //Should make call to back end getting user object based on this email then 
            email:localStorage.getItem("Email")
        }
    )
    

    // const response = await fetch('/Routes/API//users/login')
    // .then(res =>res.json())
    // .then((r)=>console.log(r))

    axios.get('/Routes/API//users/hello')
    .then(res => {
        console.log(res)
      })

}

goTo = number => e =>
{
    this.setState({
        step:number
    })
}




    render() {
        const email = this.state.email

      
        const {step} = this.state;

        switch(step)
        {
            case 1:
                return(
                    <div>
                    <Navabr/>
                    <div className="sideMenu">
                    <SideMenu
                    goTo = {this.goTo}/>
                    </div>
    
                    <div className="main">
                    <UserInfo/>
                    
                    </div>
                    
                </div>
            )
            case 2:
                    return(
                        <div>
                        <Navabr/>
                        <div className="sideMenu">
                        <SideMenu
                         goTo = {this.goTo}/>
                        </div>
        
                        <div className="main">
                        <PersonalInfo/>
                        
                        </div>
                        
                    </div>
                )

                case 3:
                        return(
                            <div>
                            <Navabr/>
                            <div className="sideMenu">
                            <SideMenu
                             goTo = {this.goTo}/>
                            </div>
            
                            <div className="main">
                            <HealthInfo/>
                            
                            </div>
                            
                        </div>
                    )

                    case 1:
                            return(
                                <div>
                                <Navabr/>
                                <div className="sideMenu">
                                <SideMenu/>
                                </div>
                
                                <div className="main">
                                <HealthInfo/>
                                
                                </div>
                                
                            </div>
                        )

        }
        }


        // return (
        //     <div>
        //         <Navabr/>
        //         <div className="sideMenu">
        //         <SideMenu/>
              
             
                



        //         </div>

        //         <div className="main">

                
        //         </div>
                
        //     </div>
        //)

        
    }
    
   
          
//}


const SidebarButton = ({ label, ...rest }) => (
    <Button plain {...rest}>
      {({ hover }) => (
        <Box
          background={hover ? "accent-1" : undefined}
          pad={{ horizontal: "large", vertical: "medium" }}
        >
          <Text size="large">{label}</Text>
        </Box>
      )}
    </Button>
  );

// const AppGrid = () => {
//     const [sidebar, setSidebar] = useState(true);
  
//     return (
//       <Grommet >
//         <Grid
//           fill
//           rows={["auto", "flex"]}
//           columns={["auto", "flex"]}
//           areas={[
//             { name: "header", start: [0, 0], end: [1, 0] },
//             { name: "sidebar", start: [0, 1], end: [0, 1] },
//             { name: "main", start: [1, 1], end: [1, 1] }
//           ]}
//         >
//           <Box
//             gridArea="header"
//             direction="row"
//             align="center"
//             justify="between"
//             pad={{ horizontal: "medium", vertical: "small" }}
//             background="dark-2"
//           >
//             <Button onClick={() => setSidebar(!sidebar)}>
//               <Text size="large">Title</Text>
//             </Button>
//             <Text>my@email</Text>
//           </Box>
//           {sidebar && (
//             <Box
//               gridArea="sidebar"
//               background="dark-3"
//               width="small"
//               animation={[
//                 { type: "fadeIn", duration: 300 },
//                 { type: "slideRight", size: "xlarge", duration: 150 }
//               ]}
//             >
//               {["First", "Second", "Third"].map(name => (
//                 <Button key={name} href="#" hoverIndicator>
//                   <Box pad={{ horizontal: "medium", vertical: "small" }}>
//                     <Text>{name}</Text>
//                   </Box>
//                 </Button>
//               ))}
//             </Box>
//           )}
//           <Box gridArea="main" justify="center" align="center">
//             <Text>main</Text>
//           </Box>
//         </Grid>
//       </Grommet>
//     );
//   };




export default Details
