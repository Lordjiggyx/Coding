//This is to import the actual package to let us have user input
import java.util.ArrayList;
import java.util.Scanner;

//Creation of the actual class itself
public class BankDriver2
{
//Declaration of the array itself
	//BankAccount [] accounts ; 
	ArrayList <BankAccount> accounts;
//The size of the array is set
	final int SIZE = 5;
//Method that calls the array into existence 
	public BankDriver2()
	{
		//accounts = new BankAccount[SIZE];
		accounts = new ArrayList<BankAccount>();
	}
	
//Method used to create accounts
	public void createAccount()
	{
		//Ask user for name of the account user
		System.out.println("Welcome please enter account details");
		//Variable for the account name
		String name;
		//Variable for the user balance
		double balance;
		//Declaration of the actual bank account class and set to a new account 
		BankAccount aBankAccount;
		//Scanner
		Scanner scan = new Scanner(System.in);
		//Loop used to create multiple accounts
		for (int i = 0 ; i <=0; i++)
		{
			System.out.println("What is thhe name of the the account user");
			name = scan.nextLine();
			
			System.out.println("Please enter the current balance of the user");
			balance = scan.nextDouble();
			scan.nextLine();
			//The bank account variable is set with the parameters entered by the user		
			aBankAccount = new BankAccount (name , balance);
			//The account is then added to the array
			accounts.add(aBankAccount);
			
		}
	}
	
	
	//Method for searching and depositing into the account
			public void deposit()
			{
			String fname;
			Scanner scan = new Scanner(System.in);
			//Scanner
			
			//variable to check if event was found 
			boolean found = false ;
			//Makes an empty account variable to be used in accordance to finding the name
			BankAccount theBankAccount = null;
			//input for name		
	        System.out.println("What is the Account holders's name that youw ould like to deposit for");
	        fname = scan.nextLine();
	     
	        //Loop method used in order to search for th name
	        
	        //for(BankAccount aBankAccount : accounts)
	        for(int i = 0; i<accounts.size();i++)
	        {
	        	System.out.println(accounts.get(i).getname());
	        	//if(accounts[i].getname().equals("te"))
	        		//found = true;
	        	/*if (aBankAccount.getname().equals(fname))
			{
				System.out.println("Here");
	        	//theBankAccount = aBankAccount;
				found = true;
			}*/
	        }
	        	
	        if (found == true)
	        {
	        	double amount;
	        	
	        	System.out.println("How much would the user like to add to the account");
	        	amount = scan.nextDouble();
	        	theBankAccount.deposit(amount);
	        	
	        	System.out.println("Your transcation was made successfully");
	        }
	      
			   if (found == false)
		        {
		        	System.out.println("The name of this user does not exist");
		        }
			   
			}
			
			public void displayAccounts()
			{
				System.out.println("Account Details");
				for(BankAccount per : accounts)
				{
					System.out.println(" ");
					per.tostring();
				}
				
				}
			
				public void applyforLoan()
				{
					for(BankAccount per : accounts)
						per.loanApproved();
				}
			

				public static void main (String[] args)
				{
					BankDriver2 driver = new BankDriver2();
					driver.createAccount();
					driver.deposit();
					/*driver.displayAccounts();
					driver.applyforLoan();*/
				}
}

		

