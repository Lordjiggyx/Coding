import java.util.Scanner;
public class BankAccount 
{	
	private String name;
	private double balance;
	
	public BankAccount( String a , double b)
	{
		this.name = a;
		this.balance = b;
	}
	
	public String getname()
	{
		return this.name;
	}
	
	public double getbalance()
	{
		return this.balance;
	}
	
	public void setname(String name)
	{
		this.name = name;
	}
	
	public void setbalance( double balance)
	{
		this.balance = balance;
	}
	
	public void deposit ( double money )
	{
		this.balance = this.balance + money ;
	}
		
	public void withdraw (double money)
	{
		this.balance = this.balance - money;
		
	}

	public boolean loanApproved()
	{
		Scanner scan = new Scanner (System.in);
		double amount; 
		boolean approved = false ;
		System.out.println("How much do you wish to withdraw");
		amount = scan.nextDouble();
		scan.nextLine();
	if(amount  >= balance * 0.8)
	{
		approved = true;
		System.out.println("Loan Approved");
	}
	else
	{
		System.out.println("Loan Denied");
	}
		return approved;
	}
	
	public String tostring()
	{
		return "Account Owner:" + this.name +
				"\n" + "Account Balance:"+ this.balance;
	}
	
	

	
}


