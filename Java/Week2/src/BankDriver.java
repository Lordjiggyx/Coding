import java.util.*;

public class BankDriver {
	
	public static void main(String[] args) {
		
		BankAccount myAccount;
		
		myAccount = new BankAccount("Joe Bloggs", 10.00);
		System.out.println("A new account has been created " + myAccount.toString());
		
		//deposit money
		myAccount.deposit(505.12);
		System.out.println("After depositing money, the account balance is \n " 
		    + myAccount.getBalance() + " Euros");
		
		//withdraw money
		myAccount.withdraw(100.00);
		System.out.println("After withdrawing money, the account details are \n " 
		                          + myAccount.toString());
		
		//Check if loan approved
		if (myAccount.loanApproved() == true)
			System.out.println("Congrats, loan has been approved");
		else
			System.out.println("Loan has not been approved");
 }
}
