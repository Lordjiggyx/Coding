
/**
 * Write a description of class Event here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Event
{
    // instance variables - replace the example below with your own
    private String name;
    private String day;
    private String time;
    private int tickets;
    private double rate = 0;
    private double counter=0;
    public Event(String n , String d, String t , int x)
    {
        this.name= n;
        this.day = d;
        this.time= t;
        this.tickets = x;
    }

    //Getter methods for each variable
    public String getname()
    {
        return this.name;
    }

    public String getday()
    {
        return this.day;
    }

    public String gettime()
    {
        return this.time;
    }

    public int gettickets()
    {
        return this.tickets;
    }

    //Setter methods for each variable
    public void setname(String name)
    {
        this.name = name;
    }

    public void setday(String day)
    {
        this.day = day;
    }

    public void settime(String time)
    {
        this.time = time;
    }

    public void settickets(int bought)
    {
        this.tickets = this.tickets + bought;
    }

    public void removetickets( int bought)
    {
        this.tickets= this.tickets - bought;
    }

    //Function for Number of tickets unsold
    public int unsold()
    {
        int unsold; 
        unsold = 50 - this.tickets;
        return unsold;
    }
    //Method to set update rating value
    public void setrating(double rate)
    {
        this.rate =  this.rate + rate;
    }
    //Method to update counter value
    public void setcounter(double counter)
    {
        this.counter = this.counter + counter;
    }
    //Method to calculate average rating of an event
    public double averagerate()
    {    
       this.rate = this.rate/this.counter;
        return this.rate;
    }


    //Display method for event class
    public void display()
    {
        System.out.println("Name of comedian:" + this.name);
        System.out.println("Day of Performance:" + this.day);
        System.out.println("Time of Performance:" + this.time);
        System.out.println("Amount of tickets booked:" + this.tickets );
        System.out.println("Tickets Remaining:" + unsold());
        if (this.rate == 0)
             System.out.println("Average rating:" +  0 + "/10");
        else
            System.out.println("Average rating:" +  averagerate() + "/10");
    }
}

    
