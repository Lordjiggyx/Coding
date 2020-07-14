import java.util.Scanner;

public class BankDriver2 {
	BankAccount[] accounts;
	final int SIZE = 5;
	
	public BankDriver2() {
		//create a blank array of 5 accounts
		accounts = new BankAccount[SIZE];
	}
	
	public void createAccounts() {
		Scanner scan = new Scanner(System.in);
		double balance;
		String name;
		BankAccount anAccount;
		
		//1. Use a loop to iterate 3 times
		//2. Inside loop, ask user to input a balance and a name
		//3. Inside loop, create anAccount with those details
		//4. Add anAccount to the array
	}
	
	
	public void displayAccounts() {
		//1. Use a loop to access each of the 3 accounts in turn and call 
		// toString() inside a System.out.println to display the account details
	}
	
	public static void main(String[] args){
		
		BankDriver2 driver = new BankDriver2();
		driver.createAccounts();
		driver.displayAccounts();
	}
}
