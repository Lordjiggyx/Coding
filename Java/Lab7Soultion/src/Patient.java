


public class Patient {
	
	private static int uniqueID; // static allows it to be global
	private int patientID;
	String name;
	String surname;
	String dob;
	
	Patient(){
		
		patientID = createID();
	}
	
	Patient(String n, String s, String d){
		name = n;
		surname = s;
		dob = d;
		patientID = createID();
	}
	
	public static int createID(){
		return uniqueID++;
	}
	
	public String toString(){
		return "Patient: " + patientID +". \nName:"+ name +" "+ surname +" \nDOB: "+dob;
	}

}
