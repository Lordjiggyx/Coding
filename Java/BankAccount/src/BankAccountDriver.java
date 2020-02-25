import java.util.Scanner;


public class BankAccountDriver
{
	public static void main (String[] args) {
	
	BankAccount myAccount;
	myAccount = new BankAccount("tomi" , 1000);
	
	myAccount.deposit(505.22);
	System.out.println("Balance:" + myAccount.getbalance());
	
	
	myAccount.withdraw(100);
	System.out.println("Balance:" + myAccount.getbalance());
	
	myAccount.loanApproved();
	
		
		
		
		
		
	}
	
}