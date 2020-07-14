import java.util.Scanner;

public class BankAccount {
	private String name;
	private double balance;
	
	//constructor
	public BankAccount(String n, double b)
	{
		this.name = n;
		this.balance = b;
	}
	
	//getters and setter
	public String getName()
	{
		return this.name;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void deposit(double money)
	{
		this.balance = this.balance + money;
	}
	
	public void withdraw(double money)
	{
		this.balance = this.balance - money;
	}
	
	public boolean loanApproved()
	{
		Scanner scan = new Scanner(System.in);
		double amount;
		
		System.out.print("How much money do you wish to borrow? ");
		amount = scan.nextDouble();
		
		if (amount > (this.balance * .8))
			return false;
		else
			return true;
	}
	
	public String toString()
	{
		return "Name = " + this.name + " Balance = " + this.balance;
	}
	
}
