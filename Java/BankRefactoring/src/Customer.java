import java.util.ArrayList; 

public class Customer {

	String PPS ="";
	String surname = "";
	String firstName = "";
	String DOB ="";
	String customerID = "";
	String password = "";
	
	ArrayList<CustomerAccount> accounts = new ArrayList<CustomerAccount> ();

	//Blank constructor
	public Customer()
	{
		this.PPS = "";
		this.surname = "";
		this.firstName = "";
		this.DOB = "";
		this.customerID = "";
		this.password = "";
		this.accounts = null;
	}
	
	//Constructor with details
	public Customer(String PPS, String surname, String firstName, String DOB, String customerID, String password, ArrayList<CustomerAccount> accounts)
	{
		this.PPS = PPS;
		this.surname = surname;
		this.firstName = firstName;
		this.DOB = DOB;
		this.customerID = customerID;
		this.password = password;;
		this.accounts = accounts;
	}
	
	//Accessor methods
	public String getPPS()
	{
		return this.PPS;
	}
	
	public String getSurname()
	{
		return this.surname;
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public String getDOB()
	{
		return this.DOB;
	}
	
	public String getCustomerID()
	{
		return this.customerID;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public ArrayList<CustomerAccount> getAccounts()
	{
		return this.accounts;
	}
	
	//mutator methods
	public void setPPS(String PPS)
	{
		this.PPS = PPS;
	}
	
	public void setSurname(String surname)
	{
		this.surname = surname;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public void setDOB(String DOB)
	{
		this.DOB = DOB;
	}
	


	
	public void setCustomerID(String customerID)
	{
		this.customerID = customerID;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public void setAccounts(ArrayList<CustomerAccount> accounts)
	{
		this.accounts = accounts;
	}
	
	public String toString()
	{
		return "PPS number = " + this.PPS + "\n"
				+ "Surname = " + this.surname + "\n"
				+ "First Name = " + this.firstName + "\n"
				+ "Date of Birth = " + this.DOB + "\n"
				+ "Customer ID = " + this.customerID;
			
	}
	
}
