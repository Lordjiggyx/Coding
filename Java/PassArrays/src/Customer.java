
public class Customer {
	
	private static int uniqueID; // static allows it to be global
	private int customerID;
	String name;
	String surname;
	String dob;
	
	Customer(){
		
		customerID = createID();
	}
	
	Customer(String n, String s, String d){
		name = n;
		surname = s;
		dob = d;
		customerID = createID();
	}
	
	public static int createID(){
		return uniqueID++;
	}
	
	public String toString(){
		return "Customer: " + customerID +". \nName:"+ name +" "+ surname +" \nDOB: "+dob;
	}
}


