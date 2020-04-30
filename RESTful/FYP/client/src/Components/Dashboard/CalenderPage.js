import React, { Component } from 'react'
import Navabr from '../General/Navabr';
import {Link} from "react-router-dom";
import axios from "axios"
import {
     Button,Modal, ModalHeader, ModalBody, ModalFooter  , Form, Label,
 Container} from 'reactstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

import FullCalendar from '@fullcalendar/react'
import dayGridPlugin from '@fullcalendar/daygrid'
import timeGridPlugin from '@fullcalendar/timegrid'
import interaction from "@fullcalendar/interaction"
import googleCalendarPlugin from '@fullcalendar/google-calendar';
import '@fullcalendar/core/main.css'
import '@fullcalendar/daygrid/main.css'
import '@fullcalendar/timegrid/main.css'
//Used Google maps api


export class CalenderPage extends Component {

    state= {

        gcsync:false,
        email:localStorage.getItem("Email"),
        title:"",
        startDate:"",
        endDate:"",
        importance:"Casual",
        content:"",
        aeModal:false,
        eecModal:false,
        eeModal:false,
        reModal:false,
        optionsModal:false,
        viewModal:false,
        editEvent:false,
        SyncModal:false,
        id:0,
        gcid:"",
        gcidconfirm:"",
        calendarEvents:[

          ]
    }


  componentDidMount()
  {
    this.getAllEvents()
    this.getUser()
  }

    getAllEvents()
    {
      axios.get(`/Routes/API//Events/getAll/${this.state.email}`)
      .then(res =>
         {
           let eventsdb = res.data.map((eve) =>
            {
               return this.formatEvent(eve)
            })
           console.log(eventsdb)
           this.setState({calendarEvents:eventsdb})
        }
         )

      
    }

    getUser = () =>
{
    axios.get(`/Routes/API//users/getUser/${this.state.email}`)
    .then(res => {
        
        if(res.data.Gcsync ===true)
        {
          this.setState({gcidconfirm:res.data.gcEmail , gcsync:true})
        }
        
      })
}


    handleChange = input => e =>{
        this.setState({
            [input]:e.target.value
        })
        
    }

    SyncModal=()=>
    {
      this.setState({SyncModal:!this.state.SyncModal})
    }

        
        aeModal=(id)=>
        {
          
           this.setState({
            aeModal:!this.state.aeModal
            
           })
        }

        reModal=()=>
        {
          this.setState({
            reModal:!this.state.reModal,
           
           
           })
        }

        ViewEvent=()=>
        {
          this.setState({
            viewModal:!this.state.viewModal,
         
           
           })
        }

        EditEvent=()=>
        {
          this.setState({
            editEvent:!this.state.editEvent,
           })
        }

        eeModal=(s , e , id)=>
        {
          this.setState({
            eeModal:!this.state.eeModal,
            id:id,
            startDate:s,
            endDate:e 
           })
        }

        
        optionsModal=(arg)=>
        {   
          if(arg == null)
          {
            this.setState({
              optionsModal:!this.state.optionsModal,
              id:0,
              startDate:"",
              endDate:"",
              title:"",
              importance:"Casual"
              
          })}
          else{
          if(arg.event.backgroundColor=== "green")
          {
            this.setState({importance:"Casual"})
          }
          if(arg.event.backgroundColor=== "red")
          {
            this.setState({importance:"Urgent"})
          }
          if(arg.event.backgroundColor=== "yellow")
          {
            this.setState({importance:"Important"})
          }
          console.log(arg.event)
          this.setState({
            optionsModal:!this.state.optionsModal,
            id:arg.event.id,
            startDate:arg.event.start.toISOString(),
            endDate:arg.event.end.toISOString(),
            title:arg.event.title
            
            
           })
          }
        }

        format= (da) =>
        {
            const d = new Date(da);
            let year = d.getFullYear();
            let month = (1 + d.getMonth()).toString().padStart(2, '0');
            let day = d.getDate().toString().padStart(2, '0');

           
            const duration = `${d.getHours()}:${d.getMinutes()}`
            
            const date = `${day}/${month}/${year} @ ${duration}`
            return date
           
        }


        addEvent(arg)
        {
         
          const enumb = Math.floor(Math.random() * 1000) + 1  

          const event =
          {
            title:this.state.title,
            start:this.state.startDate,
            end:this.state.endDate,
            content:this.state.content,
            importance:this.state.importance,
            id:enumb

          }

          axios.post(`/Routes/API//Events/addEvent/${this.state.email}` , {event})
          .then(res =>
            {
              this.getAllEvents()
            }).then(this.setState({aeModal:false ,title:"",startDate:"",endDate:"",importance:"Casual"})).then(this.getAllEvents())
            this.getAllEvents()
            
        }

        formatEvent=(event)=>
        {
          var bg = null
          if(event.Importance === "Casual")
          {
            bg = "green"
          }
          else if(event.Importance === "Important")
          {
            bg = "yellow"
          }
         else  if(event.Importance === "Urgent")
          {
            bg = "red"
          }


          var formatted={
            start:event.StartDate,
            end:event.EndDate,
            title:event.Title,
            id:event.E_id,
            backgroundColor:bg
            
          }
          return formatted
        }

        removeEvent=()=>
        {
          
          axios.get(`/Routes/API//Events/remove/${this.state.id}`)
          .then(this.setState({reModal:false,optionsModal:false , id:"",title:"",startDate:"",endDate:"",importance:"Casual"}))
          this.getAllEvents()
          this.getAllEvents()
          this.getAllEvents()
        }

        editEvent=()=>
        {
          console.log(this.state.startDate)
          console.log(this.state.endDate)

          const event=
          {
            start:this.state.startDate,
            end:this.state.endDate,
          }
          axios.post(`/Routes/API//Events/edit/${this.state.id}`, {event})
          .then(this.getAllEvents())

          this.setState({eeModal:false, startDate:"" , endDate:"" , id:0})
          this.getAllEvents()
        }

        editEventFull=()=>
        {
          console.log(this.state.startDate)
          console.log(this.state.endDate)
          const event=
          {
            start:this.state.startDate,
            end:this.state.endDate,
            importance:this.state.importance,
            title:this.state.title
          }
          axios.post(`/Routes/API//Events/editFull/${this.state.id}`, {event})
          .then(this.getAllEvents())

          this.setState({editEvent:false,optionsModal:false, startDate:"" , endDate:"" , id:0 , title:"" , })
          this.getAllEvents()
          
        }

        syncGC=()=>
        {
          const data =
          {
            email:this.state.gcid
          }
          axios.post(`/Routes/API//Events/saveGC/${this.state.email}`, {data})
          .then(this.getUser())
          this.setState({gcidconfirm:this.state.gcid ,SyncModal:false ,gcsync:true})
        }


    render() {


      var events = [
        this.state.calendarEvents , {googleCalendarId:this.state.gcidconfirm}]
        

        return (
            <div>
                <Navabr/>
                <div className="p-grid">
                <div className="p-col-12 heading1"><h1>Calender</h1></div>

                <div className="p-grid">
                <div className="p-offset-1 p-col-7">
                <Container >
                    <FullCalendar
                    
                     defaultView="dayGridMonth"
                     googleCalendarApiKey="AIzaSyB44pC8Ol1NZxDob1DybXZ6OwVT2C_fdRw"
                     header={{
                       left: "prev,next today, addEventButton" ,
                       center: "title",
                       right: "dayGridMonth,timeGridWeek,timeGridDay"
                     }}
                      plugins={[ dayGridPlugin , interaction , timeGridPlugin, googleCalendarPlugin ]}
                      eventClick={(arg)=>this.optionsModal(arg)}
                      // dateClick={this.handleDateClick}
                      // events={[this.state.calendarEvents]}
                      eventSources={events}
                      editable = {true}
                      
                      eventMouseEnter={this.eventRender}
                      eventDrop={(arg)=>{this.eeModal(arg.event.start.toISOString() , arg.event.end.toISOString() , arg.event.id)}}
                    
                      eventResize={(arg)=>{this.eeModal(arg.event.start.toISOString() , arg.event.end.toISOString() , arg.event.id)}}
                      height={500}/>
                    
                    </Container>
                    </div>

                    <div className=" p-col-3">
                
                  <Button  style={{width:"100%" , marginTop:"33%", backgroundColor:"#D976ED"}} onClick={this.aeModal}>Add Event</Button>
                  {this.state.gcsync === false ?<Button style={{width:"100%" ,backgroundColor:"#D976ED", marginTop:"33%"}} onClick={this.SyncModal}> Sync Google Calender</Button> : null }
                  <Link to = "/UserDashboard">
                  <Button style={{width:"100%",backgroundColor:"#D976ED" , marginTop:"33%"}}>Return To Dashboard</Button>
                  </Link>
                   
               
                    </div>



                    </div>
            
            </div>

            <Modal className="text-center" isOpen={this.state.aeModal}
                toggle={this.aeModal}>
                <ModalHeader >Create An Event</ModalHeader>
                <ModalBody>
               <Form id="f1">
                    <Label for ="sd"><strong>Start Date</strong></Label>
                    <br></br>
                    <input  type="datetime-local" name="sd"id="sd"onChange={this.handleChange("startDate")}></input>
                    <br></br>
                    <br></br>

                    <Label for ="ed"><strong>End Date</strong></Label>
                    <br></br>
                    <input type="datetime-local" name="ed"id="ed"onChange={this.handleChange("endDate")}></input>
                    <br></br>
                    <br></br>

                    <Label for ="title"><strong>TItle</strong></Label>
                    <br></br>
                    <input type="text" name="title"id="title"onChange={this.handleChange("title")} ></input>
                    <br></br><br></br>
                    

                    <Label for ="import"><strong>Importance</strong></Label><br></br>
                    <select type="select" name ="import" id="import" onChange={this.handleChange("importance")}>
                      <option>Casual</option>
                      <option>Important</option>
                      <option>Urgent</option>  
                    </select>
                    <br></br>
                    <br></br>

                    <Button onClick={()=>
                    {
                      this.addEvent()
                    }}>Create Event</Button>
                    <Button onClick={()=>{
                      this.setState({
                        duration:"",
                        startDate:"",
                        endDate:"",
                        importance:"casual",
                        content:"",
                        aeModal:false} ,document.getElementById("f1").reset())}}>Cancel</Button>
                  </Form>

                </ModalBody>
                <ModalFooter>

                </ModalFooter>
                </Modal>

                

                <Modal className="text-center" isOpen={this.state.reModal}
                toggle={()=>this.reModal()}>
                  <ModalHeader>Remove Event</ModalHeader>
                  <ModalBody>
                 <p>Would remove this event</p>
                 <Button onClick={this.removeEvent}>Yes</Button>
                 <Button onClick={()=> this.setState({reModal:false})}>No</Button>
                 </ModalBody>
                </Modal>

                <Modal className="text-center" isOpen={this.state.eeModal}
                toggle={()=>this.eeModal()}>
                  <ModalHeader>Edit Event</ModalHeader>
                  <ModalBody>
                 <p>Are you sure you want to edit this events details</p>
                 <Button onClick={this.editEvent}>Yes</Button>
                 <Button onClick={()=> this.setState({eeModal:false})} >No</Button>
                 </ModalBody>
                </Modal>

                <Modal className="text-center" isOpen={this.state.optionsModal}
                toggle={()=>this.optionsModal()}>
                  <ModalHeader>Event Details</ModalHeader>
                  <ModalBody>
                 <p>Select one of the Following Options</p>
                 <Button onClick={this.ViewEvent}>View Event Details</Button>
                 <Button onClick={ this.EditEvent}>Edit Event Details</Button>
                 <Button onClick={()=> this.reModal()}>Remove Event</Button>
                 </ModalBody>
                </Modal>
                
                <Modal className="text-center" isOpen={this.state.viewModal}
                toggle={()=>this.ViewEvent()}>
                  <ModalHeader>Event Details</ModalHeader>
                  <ModalBody>
                      <p>Title: {this.state.title}</p>
                      <p>Start: {this.format(this.state.startDate)}</p>
                      <p>End: {this.format(this.state.endDate)}</p>
                      <p>Importance: {this.state.importance}</p>
                 <Button onClick={()=>this.setState({viewModal:false})}>Close</Button>
                 </ModalBody>
                </Modal>

                <Modal className="text-center" isOpen={this.state.SyncModal}
                toggle={()=>this.SyncModal()}>
                  <ModalHeader>Connect to Google Calender</ModalHeader>
                  <ModalBody>
                      <p><strong>Steps to connect Google Calender</strong></p>
                      <p>
                      
                        <li>In the Google Calendar interface, locate the “My calendars” area on the left.</li>
                        <li>Find the Calendar you want to connect and click on the settings icon , then click settings and sharing</li>
                        <li>Go to "Access Permissons" and select "make avaliable to public"</li>
                        <li>Go to "Integrate Calendar" and copy the "Calendar ID"</li>
                        <li>Paste the contents below and click "Connect My calendar"</li>
                      </p>
                      <input  type="text" onChange={this.handleChange("gcid")}></input>
                      <br></br>
                 <Button onClick={()=>this.syncGC()}>Connect My Calendar</Button>
                 <br></br>
                 <Button onClick={()=>this.setState({SyncModal:false})}>Close</Button>
                 </ModalBody>
                </Modal>

                <Modal size = "lg" className="text-center" isOpen={this.state.editEvent}
                toggle={()=>this.EditEvent()}>
                  <ModalHeader>Edit Details</ModalHeader>
                  <ModalBody>
                      <strong>Change Event Details</strong>
                      <Form id="f2">
                    <Label for ="sd"><strong>Start Date</strong></Label>
                    <br></br>
                    <input  type="datetime-local" name="sd"id="sd"onChange={this.handleChange("startDate")}></input>
                    <br></br>
                    <br></br>

                    <Label for ="ed"><strong>End Date</strong></Label>
                    <br></br>
                    <input type="datetime-local" name="ed"id="ed"onChange={this.handleChange("endDate")}></input>
                    <br></br>
                    <br></br>

                    <Label for ="title"><strong>TItle</strong></Label>
                    <br></br>
                    <input type="text" name="title"id="title"onChange={this.handleChange("title")} ></input>
                    <br></br><br></br>
                    

                    <Label for ="import"><strong>Importance</strong></Label><br></br>
                    <select type="select" name ="import" id="import" onChange={this.handleChange("importance")}>
                      <option>Casual</option>
                      <option>Important</option>
                      <option>Urgent</option>  
                    </select>
                    <br></br>
                    <br></br>

                    <Button onClick={()=>
                    {
                      this.editEventFull()
                    }}>Submit Changes</Button>
                    
                    <Button onClick={()=>{
                      this.setState({
                        duration:"",
                        startDate:"",
                        endDate:"",
                        importance:"casual",
                        content:"",
                        editEvent:false,
                        optionsModal:false} ,document.getElementById("f2").reset())}}>Cancel</Button>
                  </Form>
                 </ModalBody>
                </Modal>
         </div>
        )
    }
}

export default CalenderPage
