import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
/**
 * Bank Driver Class which uses an ArrayList to hold a series of bank accounts
 */
public class BankDriver
{

    //Global Variables
    ArrayList <BankAccount> bank;
    //number of bank accounts
    int numberAccounts;

    //constructor
    public BankDriver()
    {
        bank = new ArrayList<BankAccount>();
    }

    /******* Method 1 - ask user for number of accounts ********/
    public void getNumberAccounts()
    {
        //local variable
        Scanner scan = new Scanner(System.in);
        System.out.println("Start of this bank doing business. You need to input the customer accounts. \n But first, how many accounts are there?");
        numberAccounts = scan.nextInt(); //accessing the global variable
        scan.nextLine(); //delete enter character from scanner

    }//end getNumberAccounts

    /**** Method 2 - get user to input that number of accounts and add to ArrayList *****/
    public void createAccounts()
    {
        //local variables
        String accNum, name, accType;
        double balance;
        Scanner scan = new Scanner(System.in);
        BankAccount anAccount;

        for (int i = 0; i < numberAccounts; i++)
        {
            //1. Input details from user
            System.out.println("\n Input Details for account " + (i + 1));
            System.out.print("Enter account number : ");
            accNum = scan.nextLine();
            System.out.print("Enter name : ");
            name = scan.nextLine();
            System.out.print("Enter balance : ");
            balance = scan.nextDouble();
            scan.nextLine();
            do
            {
                System.out.print("Enter account type (deposit or current) : ");
                accType = scan.nextLine();
            }while (!accType.equals("deposit") && !accType.equals("current"));

            //2. Create a new bank account
            anAccount = new BankAccount(accNum, name, balance, accType);

            //3. Add account to the ArrayList
            bank.add(anAccount);
        }//end for
    }//create accounts

    /**** Method 3 - display all of the accounts *****/
    public void displayAccounts()
    {
        for (BankAccount account : bank)
        {
            account.display();
        }//end for
    }//end displayAccounts

    /**** Method 4 - save/write the account objects to a file *****/
    public void saveToFile()
    {
        String fileName;
        ObjectOutputStream fileOut;
        /*System.out.print("Enter filename: ");
        Scanner scan = new Scanner(System.in);
        fileName = scan.nextLine(); */
        try{
            fileOut = new ObjectOutputStream(new FileOutputStream("bank.dat"));
            for (BankAccount account : bank)
            {
                fileOut.writeObject(account);
            }
            fileOut.close();
            System.out.println("Bank contents saved");
        }
        catch (IOException e)
        {
            System.out.println("No room on your H: drive, talk to help desk");
        }
    }//end saveToFile

    /**** Method 5 - read/copy the account objects to an ArrayList in memory *****/
    public boolean readFromFile()
    {
        int index=0;
        String fileName;
        ObjectInputStream fileIn;
        BankAccount anAccount;

       /* System.out.print("Enter filename: ");
        Scanner scan = new Scanner(System.in);
        fileName = scan.nextLine();*/

        try{
            fileIn = new ObjectInputStream(new FileInputStream("bank.dat"));
            System.out.println("Opened file successfully");
            anAccount = (BankAccount) fileIn.readObject();
            index = 1;
            while (anAccount != null)
            {
                bank.add(anAccount);
                anAccount = (BankAccount) fileIn.readObject();
                index++;
            }
            fileIn.close();
            return true;
        }
        catch (IOException e)//this will be called if a) file doesn't exist or
                             //b) it has reached the end of the file
        {
            if (index > 0) //there were accounts in the file 
            {
                this.numberAccounts = index;  //this takes note of how many accounts were copied over.
                return true; 
            }
            else //file doesn't exist
            { System.out.println("Bank Accounts have not been created yet, you will need to input it\n");
                return false;
            }
        }

        catch (ClassNotFoundException e)
        {
            System.out.println("Class Error : " + e.getMessage());
            return false;
        }
    }//end saveToFile

    public static void main(String[] args)
    {   
        System.out.print("\f"); 
        System.out.println("Welcome to the Bank of DIT");
        BankDriver driver = new BankDriver();

        if (driver.readFromFile()== true)  //bank account have already been created
        {
            System.out.println("Bank is populated with accounts");

        }
        else //there are no bank accounts to be found so user has to input them
        {
            driver.getNumberAccounts();
            System.out.println("\n********Create and Store Account Details*************");
            driver.createAccounts();
        }     
        System.out.println("\n********Display all Accounts*************");
        driver.displayAccounts();

        System.out.println("\n********Saving bank account details*************");
        driver.saveToFile();

    }//end main
}//end BankDriver
