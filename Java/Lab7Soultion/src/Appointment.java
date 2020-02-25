

public class Appointment {
    private int id;
    private Patient patient;
    private String doctor;
    private String date; 
    private String time;  
    private int duration;
 
    private static int uniqueID; // static allows it to be global
     
     
    public Appointment(Patient p, String date, String doctor, String time, int d){ 
        this.patient = p; 
        this.date = date;
        this.doctor = doctor; 
        this.time = time; 
        this.duration = d;
        id = createID();
	}
	
	public static int createID(){
		return uniqueID++;
	} 
     
    //accessors: getters: 
      
     /**
      * An accessor method for the Appointment class 
      * @return The date of the appointment 
      */ 
    public String getDate(){ 
        return date; 
    } 
      
    /**
     * An accessor method for the Appointment class 
     * @return The id of the appointment 
     */ 
    public int getID(){ 
        return id; 
    } 
     
    /**
     * An accessor method for the Appointment class 
     * @return Mother object who the appointment will be assigned to 
     */ 
    public Patient getPatient(){ 
        return patient; 
    } 
     
      
    /**
     * An accessor method for the Appointment class 
     * @return The doctor the appointment is with 
     */ 
    public String getDoctor(){ 
        return doctor; 
    } 
    /**
     * An accessor method for the Appointment class 
     * @return The time of the appointment 
     */ 
    public String getTime(){ 
        return time; 
    } 
    
    public int getDuration(){ 
        return duration; 
    } 
     
    //mutators: setters 
     
    /**
     * A mutator method for the Appointment class 
     * @param date The date of the appointment 
     */ 
    public void setDate(String date){ 
        this.date = date; 
    } 
     
    /**
     * A mutator method for the Appointment class 
*/
    public void setPatient(Patient p){ 
        this.patient = p; 
    } 
     
 
     
    /**
     * A mutator method for the Appointment class 
     * @param id The id of the appointment 
     */ 
    public void setID(int id){ 
        this.id = id; 
    } 
     
     
    /**
     * A mutator method for the Appointment class 
     * @param doctor The doctor the appointment is with 
     */ 
    public void setDoctor(String doctor){ 
        this.doctor = doctor; 
    } 
     
    /**
     * A mutator method for the Appointment class 
     * @param time The time of the appointment 
     */ 
    public void setTime(String time){ 
        this.time = time; 
    } 
    
    public void setDuration(int duration){ 
        this.duration = duration; 
    } 
     
}
