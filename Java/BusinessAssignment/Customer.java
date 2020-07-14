import java.util.Scanner;
/**
 * Write a description of class Customer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Customer
{
    private String cname;
    private String Address;
    private double owed; 
    private int newCustomer;
    public Scanner stdIn = new Scanner(System.in);
    public Customer(String cname, String Address,double owed)

    {
        this.cname= cname;
        this.Address=Address;
        this.owed=owed;
    }

    public Customer()
    {
        this.cname="";
        this.Address="";
        this.owed=0;
    }

    public String getcname()
    {
        return this.cname;
    }

    public String getAddress()
    {
        return this.Address;
    }

    public double getowed()
    {
        return this.owed;
    }

    public void setcname(String cname)
    {
        this.cname = cname;
    }

    public void setAddress(String Address)
    {
        this.Address=Address;
    }

    public void setowed(double owed)
    {
        this.owed=owed;
    }

    public void display()
    {
        System.out.println("Customer Name:" + this.cname);
        System.out.println("Customer Address:" + this.Address);
        System.out.println("Amount Owed By Customer:" + this.owed);
    }
    //Block Account method
    public void blockAccount()
    {
        System.out.println(" ");
        System.out.println("Is This A New Or Regualar Customer? ");
        System.out.println("Please enter 1 for New or 2 for Regular");
        newCustomer=stdIn.nextInt();
        if( newCustomer == 1 && owed>100)
        {
            System.out.println("This is a new customer however they owe to much to our company therfore being  illegible to do business with us");
        }
        if (newCustomer == 1 && owed<100)
        {
            System.out.println("This Customer Is Legible to do business with us");

        }

    }

    public void blockAccount1()
    {   System.out.println(" ");
        System.out.println("Is This A New Or Regualar Customer? ");
        System.out.println("Please enter 1 for New or 2 for Regular");
        newCustomer=stdIn.nextInt();
        if (newCustomer == 2 && owed>250)
        {
            System.out.println("This is a regular customer however they owe to much to our company therfore being  illegible to do business with us");
        }
        if(newCustomer == 2 && owed<250)
        {
            System.out.println("This Customer Is Legible to do business with us");
        }

    }
}