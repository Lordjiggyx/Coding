import java.io.*;

/**
* Description of a Bank Account
 */
public class BankAccount implements Serializable
{
    //instance variables
    private String accountNumber;
    private String name;
    private double balance;
    private String accountType;
    
    //constructors
    public BankAccount()
    {
         this.accountNumber = "";
         this.name = "";
         this.balance = 0;
         this.accountType = "";
    }
    
    public BankAccount(String aNum, String name, double balance, String aType)
    {
         this.accountNumber = aNum;
         this.name = name;
         this.balance = balance;
         this.accountType = aType;
    }
    
    //Add getter and setting methods
    public String getAccountNumber()
    {
        return this.accountNumber;
    }
    
    
   //Other useful methods would be methods to withdraw and deposit money
    
    public void display()
    {
        System.out.println("Account number : " + this.accountNumber);
        System.out.println("Name : " + this.name);
        System.out.println("Balance: " + this.balance);
        System.out.println("Account type: " + this.accountType);
        System.out.println();
    }//end display
}//end BankAccount
