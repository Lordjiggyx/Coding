import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class Driver here.
 * 
 * @ Tomi ilori - C16359881 
 * @
 */
public class Driver
{
    //Array list for customer class objects
    ArrayList<Customer> customers;
    //Array list for the event class objects
    ArrayList<Event> events;
    //counter for customers
    int numCustomers;

    // Constructor for objects of class Driver

    public Driver()
    {
        //Creates two arrays 
        //Customer array
        customers = new ArrayList<Customer>();
        //Events array
        events= new ArrayList<Event>();
    }

    //Method to create events
    public void makeEvent()
    {
        //clears screen
        System.out.print("\f");
        //Greeting message for user
        System.out.println("Welcome promoter please create five events");
        //loop to ensure 5 events are made
        for ( int i = 0 ; i <=4; i++)
        {
            //Variable for event comedian  name
            String name;
            //Variable for event day
            String day;
            //Variable for time event will trake place
            String time;
            //Variable for Event to set an event
            Event aEvent;
            //Tickets are set to zero as no people would have booked a ticket by now
            int tickets = 0;
            //Scanner 
            Scanner scan = new Scanner(System.in);
            //input for comedian name 
            System.out.println("What is the comedian's name");
            name = scan.nextLine(); 
            //Loop method to ensure that day is a weekday
            do
            {
                System.out.println("What is day of performance please enter a weekday");
                day = scan.nextLine();
            }while(!day.equals("monday") && !day.equals("tuesday") && !day.equals("wednesday") && !day.equals("thursday") && !day.equals("friday"));
            //Loop method to ensure that time is set to evening or late night
            do 
            {
                System.out.println("What time would you like the event to occur please select evening or night");
                time = scan.nextLine();
            }while(!time.equals("evening") && !time.equals("night"));
            //Create a new wvwnt and set parameters
            aEvent = new Event (name , day, time , tickets);
            //Event is added to array
            events.add(aEvent);
            System.out.println(" ");
        }
        //Clear Screen
        System.out.print("\f");
    }

    //Method to purchase tickets
    public void buyTicket()
    {
        //Scanner 
        Scanner scan = new Scanner(System.in);
        //Variable for event comedian  name
        String name;
        //Variable for event day
        String day;
        //Variable to check if an event was found
        boolean found = false;
        //Makes an empty event variable null as it willset later by loop
        Event theEvent = null;

        //input for comedian name 
        System.out.println("What is the comedian's name");
        name = scan.nextLine(); 

        //Loop method to ensure that day is a weekday
        do
        {
            System.out.println("What is day of performance please enter a weekday");
            day = scan.nextLine();
        }while(!day.equals("monday") && !day.equals("tuesday") && !day.equals("wednesday") && !day.equals("thursday") && !day.equals("friday"));
        //Loop searches for an event among the array
        for ( Event aEvent : events)

        {
            //Checks to see if name and day input are equal to any existing event name and day
            if (aEvent.getname().equals(name) && aEvent.getday().equals(day))
            {
                //Sets the empty event to the matching event found by the loop
                theEvent = aEvent;
                //Declares the event was found
                found = true;
            }

        }
        //If the event was not found the method ends and the customer is returned to the meneu
        if (found ==  false)
        {
            System.out.print("Event was not found you will be returned to the menu");
        }

        //if the event was found the following is carried out
        if (found == true)
        {
            System.out.println(" ");
            System.out.println("The event was found");
            //Asks user if they would like to purchase a ticket
            System.out.println("Would you like to book the ticket (yes/no)");
            //Variable that is used for answering this question
            String answer;
            answer = scan.nextLine();
            //Creates a Variable of type Customer
            Customer aCustomer;
            //If the Customer wants to buy a ticket the following is carried out
            if (answer.equals("yes"))
            {
                System.out.println(" ");
                //input for customer name
                System.out.println("Please enter your name");    
                //Variable for customer name
                String cname;
                cname = scan.nextLine();
                //input for customer email
                System.out.println("Please enter your email address ");
                //Variable for customer email
                String email;
                email = scan.nextLine();
                //input for amount of tickets they want to buy
                System.out.println("How many tickets do you wish to buy");
                //Variable for amount of tickets the customer wants to buy
                int bought;
                bought = scan.nextInt(); 
                scan.nextLine();
                //Checks if amount of tickets exceed 50
                if( theEvent.unsold() < bought)
                {
                    System.out.println("Unfourtunately there are not enough tickets for this event");
                    System.out.println("You will not be added to the customer roster as there is not enough tickets");
                    System.out.println("Please select another event or book less tickets");
                }
                else 
                {

                    //New Customer is created
                    aCustomer = new Customer (cname, email ,bought);
                    //Customer is then added to the array

                    customers.add(aCustomer);
                    numCustomers = numCustomers + 1;
                    aCustomer.setevent(theEvent);

                    //The amount of tickets booked for an event is set to the amount purchased by customer
                    theEvent.settickets(bought);
                }

            }
            //if they dont want to buy a ticket they are returned to the menu
            else {
                System.out.println("You will now be returned to the menu");
                System.out.println(" ");
            }
        }

    }

    //Method for cancelling tickets
    public void cancelTicket()

    {
        //Scanner 
        Scanner scan = new Scanner(System.in);
        //Variable for customer name
        String cname;
        //Variable to check if customer was found
        boolean found = false;
        //Variable to check if event was found
        boolean efound = false;
        //Creates an empty Variable of type Customer
        Customer theCustomer = null;
        //Creates an empty Variable of type Event
        Event theEvent = null;

        //input for customer name
        System.out.println("Please enter your name");
        cname = scan.nextLine();
        //input for customer email
        System.out.println("Please enter your email address ");
        //Variable for Customer email
        String email;
        email = scan.nextLine();
        //Checks if customer name and email match that of any created customer object by going through the array
        for ( Customer aCustomer : customers)
        {
            if (aCustomer.getcname().equals(cname) && aCustomer.getemail().equals(email))
            {
                //Sets the empty customer to the matching customer class in the array
                theCustomer = aCustomer;
                //Declares the customer was found
                found = true;
            }
        }
        //If the customer is found is found the following is carried out
        if (found == true)
        {
            //Indicates customer was found and requests for the comedian name
            System.out.println("We found your name please enter the Comedian name you were meant to watch");
            //Variable for event name
            String name;
            //Variable for event day
            String day;
            name = scan.nextLine();
            //inside a do loop to ensure a weekday is given
            do
            {
                //input for the event day
                System.out.println("What is day of performance please enter a weekday");
                day = scan.nextLine();
            }while(!day.equals("monday") && !day.equals("tuesday") && !day.equals("wednesday") && !day.equals("thursday") && !day.equals("friday"));
            //Loop searches for an event among the array
            for ( Event aEvent : events)

            {
                //Checks to see if name and day input are equal to any existing event name and day
                if (aEvent.getname().equals(name) && aEvent.getday().equals(day))
                {
                    //Sets the empty event to the matching event found by the loop
                    theEvent = aEvent;
                    //Declares the event was found
                    efound = true;
                }
            }
        }
        //If the customer name is not found the menu will automatically open
        else
        {
            System.out.println("Your name was not found you will be returned to the menu");

        }
        //If the event is found after the customer name is found the following is carried out
        if (efound == true)

        {
            //Declares that event was found
            System.out.println("The event was found your ticket has been removed");
            //This is the method that returns the tickets when a ticket is cancelled
            theEvent.removetickets(theCustomer.getbought());
            //The customer is then removed from the array
            customers.remove(theCustomer);
        }
        //If the ecent was not found the customer is returned to the menu
        if(efound == false)
        {
            System.out.println("The event was not found you will now be returned to the menu"); 
        }
    }
    //Method that displays events
    public void displayEvents()
    {
        System.out.println("Event schedule:");
        //Program searchs through the array for any events and displays them
        for (Event per : events)
        {
            System.out.println(" "); 
            per.display();
        }

    }
    //Method that displays customer bookings
    public void displayBookings()

    {
        //Scanner 
        Scanner scan = new Scanner(System.in);
        //Variable for event comedian  name
        String name;
        //Variable for event day
        String day;
        //Variable to check if customer was found
        boolean found = false;
        //Creates an empty Variable of type Event
        Event theEvent = null;
        //Creates an empty Variable of type Customer
        Customer theCustomer = null;

        System.out.println("please enter Event details");
        System.out.println(" ");
        //input for comedian name 
        System.out.println("What is the comedian's name");
        name = scan.nextLine(); 
        //inside a do loop to ensure a weekday is given
        do
        {
            //input for the event day
            System.out.println("What is day of performance please enter a weekday");
            day = scan.nextLine();
        }while(!day.equals("monday") && !day.equals("tuesday") && !day.equals("wednesday") && !day.equals("thursday") && !day.equals("friday"));
        //Loop searches for an event among the array
        for ( Event aEvent : events)

        {
            //Checks to see if name and day input are equal to any existing event name and day
            if (aEvent.getname().equals(name) && aEvent.getday().equals(day))
            {
                //Sets the empty event to the matching event found by the loop
                theEvent = aEvent;
                //Declares the event was found
                found = true;
            }
        }
        if (found == true)
        {
            System.out.println("Customer bookings:");
            //Loop searches for a customer
            for (Customer aCustomer: customers)
            {
                //Checks to see if name and day input are equal to any existing event name and day
                if (aCustomer.getevent().getname().equals(name) && aCustomer.getevent().getday().equals(day))
                {
                    //Sets the empty customer to the matching customer class in the array
                    theCustomer = aCustomer;
                    System.out.println(" ");
                    //Custmoer display method is called for the event
                    theCustomer.display();
                }
            }
        }
        //If there are no customers the customer is returned to the menu
        if (found == false)
        {
            System.out.println("There are no bookings for this event please make a purchase to view bookings");
        }
    }
    //change to rate for an event 
    public void rate()
    {
        //Scanner 
        Scanner scan = new Scanner(System.in);
        //Variable for for confirmation that the event was seen
        String answer;
        //Variable for event comedian  name
        String name;
        //Variable for event day
        String day;
        //Variable to check if event was found
        boolean found = false;
        //Creates an empty Variable of type Event
        Event theEvent = null;
        //Counter for amount of times the event was rated
        double counter = 0;
        //In a do loop to ensure only yes or no is asked
        do
        {
            //Input for answering question
            System.out.println("Have you seen any of the events before (yes/no)");
            answer = scan.nextLine();
        }while(!answer.equals("yes") && !answer.equals("no"));
        //If the customer has seen an event the following is carried out
        if( answer.equals("yes"))
        {
            //Variable for particpating in the rating
            String option1;
            do
            {
                //Asking user if they would like to rate an event
                System.out.println("Would you like to rate the event (yes/no)");
                option1 = scan.nextLine();
            }while(!option1.equals("yes") && !option1.equals("no"));
            //If they wish to rate the event the following is carried out
            if (option1.equals("yes"))
            {
                //Asks the user to input the name and day of the event they would like to rate
                System.out.println("please enter Event details of which you want to rate");
                System.out.println(" ");
                System.out.println("What is the comedian's name");
                name = scan.nextLine();
                do
                {
                    System.out.println("What is day of performance please enter a weekday");
                    day = scan.nextLine();
                }while(!day.equals("monday") && !day.equals("tuesday") && !day.equals("wednesday") && !day.equals("thursday") && !day.equals("friday"));
                //Searchs for the event by checking if name and day match any existing event
                for ( Event aEvent : events)

                {
                    if (aEvent.getname().equals(name) && aEvent.getday().equals(day))
                    {
                        theEvent = aEvent;
                        found = true;
                    }
                }
                //If event is found the following is carried out
                if (found == true)
                {
                    //Variable for the rating
                    double rate;
                    //Dome within a do loop to ensure rating is not below 0 or greater than 10
                    do
                    {
                        //Aasks for a rating
                        System.out.println("please give a rating between 0 and 10");
                        rate= scan.nextDouble();
                        //Calls the method thatsets therating for the event
                        theEvent.setrating(rate);

                    }while (rate <0 || rate >10);
                    //Sets the counter variable in the  event class
                    theEvent.setcounter(counter + 1);
                }
                else
                //if event is not found the user is returned to the menu
                {
                    System.out.println("The event was not found you will now be returned to the menu");
                }
            }
            //If they do not wish to they are returned to the menu
            if (option1.equals("no)"))
            {
                System.out.println("You will be returned to the menu");
            }
        }
        //If the customer has not seen an event they are returned to the menu with a message indicating to watvh an event
        if (answer.equals("no"))
        {            
            System.out.println("Please book a ticket and then come back after you have watched an event to rate it :)");
        }        
    }
    //Method for the quiz
    public void quiz()
    {
        //Scanner 
        Scanner scan = new Scanner(System.in);
        //Variable to answer question
        String answer;
        //Creates an empty Variable of type Customer
        Customer theCustomer = null;
        //Variable to check if customer was found
        boolean found = false;
        //Creates an empty Variable of type Event
        Event theEvent = null;
        //Variable to check if event was found
        boolean efound = false;
        System.out.println("Take this quiz and win a free extra ticket for the next events");
        System.out.println("Enter your details below:");

        //input for customer name
        System.out.println("Please enter your name");
        //Variable for customer name
        String cname;
        cname = scan.nextLine();

        //input for customer email
        System.out.println("Please enter your email address ");
        //Variable for Customer email
        String email;
        email = scan.nextLine();

        //Loop searches for a customer
        for ( Customer aCustomer : customers)
        {
            //Checks to see if name and day input are equal to any existing event name and day
            if (aCustomer.getcname().equals(cname) && aCustomer.getemail().equals(email))
            {
                //Sets the empty customer to the matching customer class in the array
                theCustomer = aCustomer;
                //Declares the customer was found
                found = true;
            }
        }
        //if customer is found the following is carried out
        if (found == true)
        {
            //done within a do loop to make sure options given are the only ones input
            do
            {
                System.out.println(" " );
                System.out.println("What is the name of the comedian who won the British GQ comedian of the year in 2015");
                System.out.println("1.Eddie Murphy");
                System.out.println("2.Will Ferrell");
                System.out.println("3.Chris Rock");
                System.out.println("Please choose between 1 - 3");
                answer = scan.nextLine();
                if (answer.equals("1"))
                {
                    System.out.println("Better luck next time your answer was wrong");
                }

                if (answer.equals("2"))
                {
                    System.out.println("You got it right well done you will be awarded a free ticket");

                }

                if (answer.equals("3"))
                {
                    System.out.println("Better luck next time your answer was wrong");
                }

            }while( !answer.equals("1") && !answer.equals("2") && !answer.equals("3"));

        }
        else
        //if customer is not found the user is returned to the menu
        {
            System.out.println("Your name was not found");
        }
    }
    //method to end program
    public void end()
    {
        //clears screen
        System.out.println("\f");
        //farewell message
        System.out.print("Thank you for using this program we hope for your return  :))"); 

    }

    public void menu()
    {

        //Variable for option
        String option;
        //done within a do loop to ensure correct answer is given
        do
        {
            //options
            System.out.println(" " );
            System.out.println("1.Display full event schedule");
            System.out.println("2.Buy a ticket");
            System.out.println("3.Cancel a ticket");
            System.out.println("4.Display all customer bookings");
            System.out.println("5.Rate an event");
            System.out.println("6.Take a quiz and win a free ticket");
            System.out.println("7.exit ");
            System.out.println("Please input your menu choice:");
            //scanner
            Scanner scan = new Scanner(System.in);

            option = scan.nextLine();
            //displays events
            if(option.equals("1"))
            {
                System.out.println(" ");
                displayEvents(); 
            }
            //buys tickets
            if(option.equals("2"))
            {
                System.out.println(" ");
                buyTicket(); 
            }
            //cancel tickets
            if(option.equals("3"))
            {
                System.out.println(" ");
                cancelTicket(); 
            }
            //displays customer bookings
            if(option.equals("4")) 
            {
                System.out.println(" ");
                displayBookings(); 
            }
            //rates an event
            if(option.equals("5"))
            {
                System.out.println(" ");
                rate();
            }
            //Calls for the quiz
            if(option.equals("6"))
            {
                System.out.println(" ");
                quiz();
            }
        }while(option.equals("1") || option.equals("2") || option.equals("3")  || option.equals("4") || option.equals("5") || option.equals("6"));
        //ends program
        if(option.equals("7"))
        {
            System.out.print("\f");
            System.out.print("Thank you for working with us");
        }
    }
    //Main method for whole operation
    public static void main(String[] args)
    {
        //clears screen
        System.out.print("\f");
        //Calls new driver
        Driver driver = new Driver();
        //Cals for method to create events
        driver.makeEvent();
        //Greeting
        System.out.println("Welcome Customer");
        System.out.println(" ");
        //Calls menu
        driver.menu();
    }

}
