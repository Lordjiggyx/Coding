import React from "react"
import ContactCard from "./ContactCard";


function App()
{
    return(
        <div className = "contacts">
        <ContactCard
           contact =
           {{
               name:"Tomi Ilori",
               img: "https://source.unsplash.com/1670x900/?dragon",
               phone: "08725891",
               email:"BobToss@Gmail.com"
           
           }}
        />
        <ContactCard
            contact =
            {{
                name:"Tom Jon",
                img: "https://source.unsplash.com/1670x900/?mouse",
                phone: "08725891",
                email:"BobTs@Gmail.com"

            }}
   
        />
        <ContactCard
            contact =
            {{
                name:"Tomori",
                img : "https://source.unsplash.com/1670x900/?cat",
                phone : "08725891",
                email : "Bboss@Gmail.com",

            }}
           
        />
        <ContactCard
            contact =
            {{
                name:"omi Ili",
                img : "https://source.unsplash.com/1670x900/?car",
                phone : "08725891",
                email : "Toss@Gmail.com",

            }}
        />
    </div>
    )
}

export default App