import java.util.Scanner;
/**
 * Write a description of class Customer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Customer
{
    // instance variables - replace the example below with your own
    private String cname;
    private String email;
    private int bought;
    private Event event;

    /**
     * Constructor for objects of class Customer
     */
    public Customer(String n, String e , int b)
    {
        this.cname = n;
        this.email= e;
        this.bought = b;

    }

    //Getter methods for each variable}
    public String getcname()
    {
        return this.cname;
    }

    public String getemail()
    {
        return this.email;
    }

    public int getbought()
    {
        return this.bought;
    }

    public Event getevent()
    {
        return this.event;
    }

    //Setter methods for each variable
    public void setcname(String cname)
    {
        this.cname = cname;
    }

    public void setemail(String email)
    {
        this.email = email;
    }

    public void setbought(int bought)
    {
        this.bought = bought;
    }

    public void setevent(Event event)
    {
        this.event = event;
    }
    
    //Function to check if an event has been booked
    public boolean booked()
    {
        boolean booked = false;
        if(event != null)
        {
            booked = true;
            System.out.println("You have registered for an event");
        }
   
        return booked;
    }
  
 
    
    //Display method for Customer details
    public void display()
    {
        System.out.println("Name of customer:" + this.cname);
        System.out.println("Email of customer:" + this.email);
        System.out.println("Tickets bought by customer:" + this.bought);
        

    }
}