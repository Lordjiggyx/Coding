import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.util.Random;
public class MasterDessert
{
    //Array list for business made products
    ArrayList<Dessert> desserts;
    //Array list for customer made products
    ArrayList<Dessert> dailys;
    //variable for Staff pin
    String pin;
    //Variable for Staff question
    String Question;
    //Variable for amount of prosucts stored
    int numberOfDesserts;
    //variable for changing pin
    String newPin;

    //Method that creates array list
    public MasterDessert()
    {
        //Initialisation of array lists
        desserts = new ArrayList<Dessert>();
        dailys= new ArrayList<Dessert>();
    }

    //Method for creating a oin and an answer for staff memembers
    public void createPin()
    {
        //Scanner
        Scanner scan = new Scanner(System.in);
        //Greeting message
        System.out.println("Greeting user before you can use this program we would like you to input a pin and answer a security question");
        System.out.println("We are doing this to ensure that no unauthorised personnel access the staff menu");
        System.out.println("Please rememeber this pin");
        //Loop ensures that pin begins with "DG" and is followed by numbers
        do
        {
            //Asking for pin
            System.out.println("Please enter your desired Pin (Please ensure that DG is at the start of the pin followed by any amount of numbers) ");
            //Setting pin to user input
            pin = scan.nextLine();
        }while(!pin.matches("DG[0-9]*"));

        //Asking for Security question
        System.out.println("What was your favourite place to visit as a child");
        System.out.println("Please rememeber your answer");
        //Settinh answer to user input
        Question= scan.nextLine();
        System.out.print("\f");
    }

    //Method for displaying cakes
    public void displayCakes()
    {
        //loop Goes through the array looking for objects of type dessert
        for (Dessert adessert : desserts) 
        {
            //In this case especially and only Desserts that are of type Cake
            if( adessert instanceof Cake)
            {
                //Display method for Cake is called
                adessert.display();
                //Space
                System.out.println( " ");
                if (adessert == null)
                {
                    System.out.println("There are no cakes at the moment");
                }
            }
        }
    }

    //Method for displaying cookies
    public void displayCookies()
    {
        //loop Goes through the array looking for objects of type dessert
        for (Dessert adessert : desserts) 
        {
            //In this case especially and only Desserts that are of type Cookie
            if( adessert instanceof Cookie)
            {
                //Display method for Cookie is called
                adessert.display();
                //Space
                System.out.println( " ");
            }
            if (adessert == null)
            {
                System.out.println("There are no cakes at the moment");
            }
        }
    }

    //Method For Creating a new cake
    public void makeCake()
    {
        //Variable for name of Cake
        String name;
        //Variable for price of cake
        double price;
        //Variabele for Ckae stock
        int stock;
        //variable for Cake Flavour
        String flavour;
        //Variable for Cake layers
        int layers;

        //Scanner
        Scanner scan = new Scanner(System.in);
        //Greeting
        System.out.println("Hello user guess you want to make a cake hmmm?");

        //Asking for name of the cake
        System.out.println("What will be the name of this amazing cake??");
        name = scan.nextLine(); 

        //Asking for price of the cake
        System.out.println("How much will the cake be?");
        price = scan.nextDouble();
        scan.nextLine();

        //Asking for flavour of cake
        System.out.println("What flavour will the cake be?");
        flavour = scan.nextLine();

        //Loop ensures that layers do not exceed 7
        do
        {
            System.out.println("How many layers will this cake have (Max. 7 Layers!");
            layers = scan.nextInt(); 
        }while (layers > 7 );

        //Asking for amount of stock 
        System.out.println("How many of this type cake will be ordered in");
        stock = scan.nextInt(); 
        scan.nextLine();

        //Creates a new Cake object and sets the variables listed below
        Cake aCake = new Cake ( name, price , stock , layers ,flavour );
        //adds this cake to Array
        desserts.add(aCake);
        //Space
        System.out.println(" ");
    }

    public void buycake()

    {
        //Space
        System.out.println("");
        //Empty Cake variable used in search method
        Cake theCake = null;
        //variable for user answer
        String answer;
        //variable for the name of the cake used in search method
        String name;
        //Variable to check if cake was found
        boolean found = false;
        //scanner
        Scanner scan = new Scanner(System.in);
        //Asking the user if they would like to purchase a cake
        System.out.println("would you like to buy a cake (yes/no)");
        answer = scan.nextLine();

        //If the user wants to buy a cake
        if (answer.equals("yes"))
        {
            //Asking for name of the cake
            System.out.println("Okay cool whats the name of the cake you would like to buy??");
            name = scan.nextLine();
            //loop Goes through the array looking for objects of type dessert
            for (Dessert adessert : desserts)
            {
                //In this case especially and only Desserts that are of type Cake
                if (adessert instanceof Cake)
                {
                    //Creates a new variable of type cake
                    Cake aCake = (Cake) adessert;
                    //If the name of the cake entered by the user is equals the name of an existing cake
                    if (aCake.getname().equals(name))
                    {
                        //The empty cake variable is set to the new Cake variable
                        theCake = aCake;
                        //if the cake is found
                        found = true;
                    }
                }
            }
            //Once the cake has been found
            if (found == true)
            {
                //Telling user teh cake was found
                System.out.println("Cake was found");
                //Asking the user for how much of the cake they would like to buy
                System.out.println("How many Cakes woukd you like to buy?");

                //Variable for the stock (in this case it is used to indicate amount of stock purchased
                int stock;
                stock = scan.nextInt();
                scan.nextLine();
                //S
                if(theCake.stockremaining() < stock)
                {
                    System.out.println("Unfourtunately we do not have enough of this product in stock at the moment please choose another cake from our menu");
                }
                else
                {
                    //Method that removes the stock
                    theCake.stockremover(stock);
                }
            }
            //If the cake was not found the user will be sent back to the menu
            if (found ==  false)
            {
                System.out.print("Sorry your cake was not found you will be returned to the menu");
            }

        }
        //If the user does not wnat to buy a cake they will be returned to the menu
        if(answer.equals("no"))
        {
            System.out.println("You will now be returned to the menu");
            System.out.println(" "); 
        }
    }

    public void buycookie()

    {
        //Space
        System.out.println("");
        Cookie theCookie = null;

        //variable for user answer
        String answer;
        //variable for the name of the cake used insearch method
        String name;
        //Variable to check if cake was found
        boolean found = false;
        //scanner
        Scanner scan = new Scanner(System.in);

        //Asking user if they would like to buy cookies
        System.out.println("would you like to buy cookies (yes/no)");
        answer = scan.nextLine();

        //If the user says yes
        if (answer.equals("yes"))
        {
            //Asking for the name of the cookie
            System.out.println("Okay cool whats the name of the cookie you would like to buy??");
            name = scan.nextLine();
            //loop Goes through the array looking for objects of type dessert
            for (Dessert adessert : desserts)
            {
                //In this case especially and only Desserts that are of type Cookie
                {
                    //Creates a new variable of type cake
                    Cookie aCookie = (Cookie) adessert;
                    if (aCookie.getname().equals(name))
                    {
                        //The empty cake variable is set to the new Cake variable
                        theCookie = aCookie;
                        //If the cookie is found
                        found = true;
                    }
                }
            }
            //If the cookie is found
            if (found == true)
            {
                //indicating cookies were found
                System.out.println("Cookie was found");
                //Asking how many cakes the user would like to purchase
                System.out.println("How many Cookie woukd you like to buy?");

                //Variable for the stock (in this case it is used to indicate amount of stock purchased
                int stock;
                stock = scan.nextInt();
                scan.nextLine();
                if(theCookie.stockremaining() < stock)
                {
                    System.out.println("Unfourtunately we do not have enough of this product in stock at the moment please choose another cake from our menu");
                }
                else
                {
                    //Method that removes stock
                    theCookie.stockremover(stock);
                }
            }
            //If the cookie is not found
            if (found ==  false)
            {
                System.out.print("Sorry your cookie was not found you will be returned to the menu");
            }

        }
        //If the user does not wnat to buy cookies they are retturned to the menu
        if(answer.equals("no"))
        {
            System.out.println("You will now be returned to the menu");
            System.out.println(" "); 
        }
    }
    //Method used to add stock
    public void addstock()

    {
        //Variable for cakes name
        String name;
        //Variable for cookie name
        String name2;
        //Variable to check if cake was found
        boolean found = false;
        //Empty Cookie variable ised in search method
        Cookie theCookie = null;
        //Empty Cake variable used in search method
        Cake theCake = null;
        //Variable for if the user wants to add a cake or cooking
        String option;
        //Scanner
        Scanner scan = new Scanner(System.in);

        //Loop enuures that only option is cake or cookies
        do
        {
            System.out.println("What product do you wish to add stock to (Cake/Cookie)");
            option = scan.nextLine();
        }while (!option.equalsIgnoreCase("Cake") && !option.equalsIgnoreCase("Cookie"));     
        //Same search Method used earlier to find a cake (See ********)
        if (option.equals("Cake"))
        {
            System.out.println("What is the name of the cake you would like to add stock to");
            name = scan.nextLine();
            for (Dessert adessert : desserts)
            {
                if (adessert instanceof Cake)
                {
                    Cake aCake = (Cake) adessert;
                    if (aCake.getname().equals(name))
                    {
                        theCake = aCake;
                        found = true;
                    }
                }
            }

            if (found == true)
            {
                System.out.println("Cake was found");
                System.out.println("How many Cakes would you like to add");

                int stock;
                stock = scan.nextInt();
                //*********ONLY DIFFERENCE IS THE METHOD CALLED ADDS STOCK INSTEAD OF REMOVING STOCK
                theCake.stockadder(stock);
            }

            if (found ==  false)
            {
                System.out.print("Sorry your cake was not found you will be returned to the menu");
            }
        }
        //Same search Method used earlier to find a cake (See ********)
        if (option.equals("Cookie"))
        {
            System.out.println("What is the name of the cookie you would like to add stock to");
            name2 = scan.nextLine();
            for (Dessert adessert : desserts)
            {
                if (adessert instanceof Cookie)
                {
                    Cookie aCookie = (Cookie) adessert;
                    if (aCookie.getname().equals(name2))
                    {
                        theCookie = aCookie;
                        found = true;
                    }
                }
            }
            if (found == true)
            {
                System.out.println("Cookie was found");
                System.out.println("How many Cookie woukd you like to buy?");

                int stock;
                stock = scan.nextInt();
                scan.nextLine();
                //*********ONLY DIFFERENCE IS THE METHOD CALLED ADDS STOCK INSTEAD OF REMOVING STOCK
                theCookie.stockadder(stock);
            }

            if (found ==  false)
            {
                System.out.print("Sorry your dessert was not found you will be returned to the menu");
            }
        }
    }

    public void makeCookie()
    {
        //Variable for cookie name
        String name;
        //Variabkle for cookie price
        double price;
        //Variable for cookie stock
        int stock;
        //Variable for cookie sides
        int sides;

        //Scanner
        Scanner scan = new Scanner(System.in);
        //Greeting
        System.out.println("Hello guess you want to make a cookie hmmm?");

        //Asking for cake name
        System.out.println("What will be the name of this delicious cookies??");
        name = scan.nextLine(); 

        //Asking for cake price
        System.out.println("How much will the cookie be?");
        price = scan.nextDouble(); 

        //Asking for cookie stock
        System.out.println("How many of this type cookie will be ordered in");
        stock = scan.nextInt(); 

        //Asking for cookie sides
        System.out.println("How many sides do you want on the cookie...yes we do sides!");
        sides = scan.nextInt();
        //Creates a new cookie 
        Cookie aCookie = new Cookie ( name, price , stock , sides);
        //New cookie is added to the array
        desserts.add(aCookie);
        //Space
        System.out.println(" ");

    }
    //Customer menu
    public void cMenu()
    {
        //Vraiable for user opiton
        String option;
        //Loop to ensure that menu comes back once a method is completed unless user picks to  exit
        do
        {
            //Customer options
            System.out.println(" ");
            System.out.println("1. Browse our marvellous cakes");
            System.out.println("2. Browse our stupendous cookies");
            System.out.println("3. Purchase a cake");
            System.out.println("4. Purchase a cookie");
            System.out.println("5. Customise your own product and possibly be sold on our official system");
            System.out.println("6. View our customer made products");
            System.out.println("7. Exit the customer menu");

            //Scanner
            Scanner scan = new Scanner(System.in);

            //Ensures options given are chosen
            do
            {
                System.out.println("Please input your menu choice:");
                option = scan.nextLine();
            }while (!option.equals("1")  &&  !option.equals("2")  && !option.equals("3")  && !option.equals("4") && !option.equals("5") && !option.equals("6") && !option.equals("7"));

            //IF STATEMENTS TO CALL CORRESPONDING METHOD WITH MENU OPTION

            if(option.equals("1"))
            {
                System.out.println(" ");
                displayCakes();
            }

            if(option.equals("2"))
            {
                System.out.println(" ");
                displayCookies();
            }            

            if(option.equals("3"))
            {
                System.out.println(" ");
                buycake();
            }      

            if(option.equals("4"))
            {
                System.out.println(" ");
                buycookie();
            }      

            if(option.equals("5"))
            {
                System.out.println(" ");
                customProduct();
            }      

            if(option.equals("6"))
            {
                System.out.println(" ");
                customerMadeProducts();
            }   
        }while(!option.equals("7"));
    }
    //Staff menu
    public void sMenu()
    {
        //Variable for user option
        String option;
        //Loop to ensure that menu comes back once a method is completed unless user picks to  exit
        do
        {
            //Staff Options
            System.out.println(" ");
            System.out.println("Staff Menu ");
            System.out.println("1. Add a new cake to the stock");
            System.out.println("2. Add a new cookie to the stock");
            System.out.println("3. Order additional amounts of existing products");
            System.out.println("4. Change pin number");
            System.out.println("5. Exit Staff menu");
            Scanner scan = new Scanner(System.in);
            //Ensures options given are chosen
            do
            {
                System.out.println("Please input your menu choice:");
                option = scan.nextLine();
            }while (!option.equals("1")  &&  !option.equals("2")  && !option.equals("3")  && !option.equals("4") && !option.equals("5"));

            if(option.equals("1"))
            {
                System.out.println(" ");
                makeCake();
            }

            if(option.equals("2"))
            {
                System.out.println(" ");
                makeCookie();
            }            

            if(option.equals("3"))
            {
                System.out.println(" ");
                addstock();
            }   

            if(option.equals("4"))
            {
                System.out.println(" ");
                resetPin();
            }   

        }while(!option.equals("5"));
    }
    //Home Menu
    public void gMenu()
    {
        //Variable for user options
        String option;
        String pin1;
        //Loop to ensure that menu comes back once a method is completed unless user picks to  exit

        do
        {
            System.out.println(" ");
            //Menu ootions
            System.out.println("Desserts Galore - Stock Control System");
            System.out.println("1. Customer menu");
            System.out.println("2. Staff menu");
            System.out.println("3. Exit System");

            Scanner scan = new Scanner(System.in);
            //Ensures options given are chosen
            do
            {
                System.out.println("Please input your menu choice:");
                option = scan.nextLine();
            }while (!option.equals("1")  &&  !option.equals("2")  && !option.equals("3"));

            if(option.equals("1"))
            {
                System.out.println(" ");
                cMenu(); 
            }

            if(option.equals("2"))
            {
                System.out.println(" ");
                System.out.println("Enter pin");
                pin1 = scan.nextLine();
                if (pin1.equals(pin))
                {
                    System.out.println("***Access Granted***");
                    System.out.println(" ");
                    sMenu();
                }
                if (!pin1.equals(pin) && !newPin.equals(pin))
                {
                    System.out.println("You failed to give the correct pin and will be now be returned to the menu");
                }
            }
        }while(!option.equals("3"));
        //clears screen
        System.out.print("\f");

    }
    //Method for Customer created products
    public void customProduct()
    {
        //Greeting
        System.out.println("Great we would love to see what our customers product would  be like");
        //Variable for stock
        int stock = 3;
        //Variable for price
        double price = 15;
        //Empty Cake variable
        Cookie theCookie = null;
        //Empty Cookie variable
        Cake theCake = null;
        //Variable for option
        String option;
        //Scanner
        Scanner scan = new Scanner(System.in);
        //Loop ensures options given are the only ones selected
        do
        {
            System.out.println("What product do you wish to add stock to (Cake/Cookie)");
            option = scan.nextLine();
        }while (!option.equalsIgnoreCase("Cake") && !option.equalsIgnoreCase("Cookie"));     
        //If customer wants to buy a cake the same method from the intial buy cake function is used(See ***)
        if (option.equals("Cake"))
        {
            String name;

            String flavour;
            int layers;

            System.out.println("What will be the name of this amazing cake??");
            name = scan.nextLine(); 

            System.out.println("We make the base price of the cake 15 euro");
            System.out.println("We allow 3 of your cake to sold in store");

            System.out.println("What flavour will the cake be?");
            flavour = scan.nextLine();

            do
            {
                System.out.println("How many layers will this cake have");
                layers = scan.nextInt(); 
            }while (layers > 7 );

            Cake aCake = new Cake ( name, price , stock , layers ,flavour );
            //****ONLY DIFFERENCE IS THE CAKE IS ADDED TO THE CUSTOMER ARRAY RATHER THEN THE SYSTEM ARRAY
            dailys.add(aCake);
            System.out.println("your cake was added to our system");
        }
        //If customer wants to buy a cookie the same method from the intial buy cookie function is used(See ***)
        if (option.equals("Cookie"))
        {
            String name2;

            int sides;

            System.out.println("What will be the name of this delicious cookies??");
            name2 = scan.nextLine(); 

            System.out.println("We make the base price of the cake 15 euro");
            System.out.println("We allow 3 of your cookie to sold in store");

            System.out.println("How many sides do you want on the cookie...yes we do sides!");
            sides = scan.nextInt();

            Cookie aCookie = new Cookie ( name2, price , stock , sides);
            //****ONLY DIFFERENCE IS THE COOKIE IS ADDED TO THE CUSTOMER ARRAY RATHER THEN THE SYSTEM ARRAY
            dailys.add(aCookie);
            System.out.println(" ");
            System.out.println("your cookie was added to our system");
        }
    }
    // Viewing and purchsing customer made products - Follows the same search and purchase methods from orther functions
    public void customerMadeProducts()
    {
        System.out.println("\nDisplaying all Customer made desserts..");
        //Displays all objects
        for (Dessert adessert : dailys) 
        {
            adessert.display();
        }

        String option;
        String option2;
        Scanner scan = new Scanner(System.in);
        boolean found = false;
        boolean found2 = false;
        Cookie theCookie = null;
        Cake theCake = null;
        String name;
        String name2;
        do
        {
            System.out.println("By any chance would you like to buy these cakes or cookies (yes/no)??"); 
            option = scan.nextLine();
            System.out.println(" ");
        }while ( !option.equalsIgnoreCase("yes") && !option.equalsIgnoreCase("no"));

        if (option.equalsIgnoreCase("yes"))
        {
            do
            {
                System.out.println("What product do you wish to by (Cake/Cookie)");
                option2 = scan.nextLine();
            }while (!option2.equalsIgnoreCase("Cake") && !option2.equalsIgnoreCase("Cookie"));     

            if (option2.equalsIgnoreCase("Cake"))
            {
                System.out.println("What is the name of the cake you would like to buy");
                name = scan.nextLine();
                for (Dessert adessert : dailys)
                {
                    if (adessert instanceof Cake)
                    {
                        Cake aCake = (Cake) adessert;
                        if (aCake.getname().equals(name))
                        {
                            theCake = aCake;
                            found = true;
                        }
                    }
                }
                if (found == true)
                {
                    //Telling user teh cake was found
                    System.out.println("Cake was found");
                    //Asking the user for how much of the cake they would like to buy
                    System.out.println("How many Cakes woukd you like to buy?");

                    //Variable for the stock (in this case it is used to indicate amount of stock purchased
                    int stock;
                    stock = scan.nextInt();
                    scan.nextLine();
                    if(theCake.stockremaining() < stock)
                    {
                        System.out.println("Unfourtunately we do not have enough of this product in stock at the moment please choose another cake from our menu");
                    }
                    else
                    {
                        //Method that removes the stock
                        theCake.stockremover(stock);
                    }
                }
                //If the cake was not found the user will be sent back to the menu
                if (found ==  false)
                {
                    System.out.print("Sorry your cake was not found you will be returned to the menu");
                }
            }

            if (option2.equalsIgnoreCase("Cookie"))

            {
                System.out.println("Whats the name of the cookie you would like to buy??");
                name = scan.nextLine();
                //loop Goes through the array looking for objects of type dessert
                for (Dessert adessert : dailys)
                {
                    //In this case especially and only Desserts that are of type Cookie
                    {
                        //Creates a new variable of type cake
                        Cookie aCookie = (Cookie) adessert;
                        if (aCookie.getname().equals(name))
                        {
                            //The empty cake variable is set to the new Cake variable
                            theCookie = aCookie;
                            //If the cookie is found
                            found2 = true;
                        }
                    }
                }
                //If the cookie is found
                if (found2 == true)
                {
                    //indicating cookies were found
                    System.out.println("Cookie was found");
                    //Asking how many cakes the user would like to purchase
                    System.out.println("How many Cookie woukd you like to buy?");

                    //Variable for the stock (in this case it is used to indicate amount of stock purchased
                    int stock;
                    stock = scan.nextInt();
                    scan.nextLine();
                    if(theCookie.stockremaining() < stock)
                    {
                        System.out.println("Unfourtunately we do not have enough of this product in stock at the moment please choose another cake from our menu");
                    }
                    else
                    {
                        //Method that removes stock
                        theCookie.stockremover(stock);
                    }
                }
                //If the cookie is not found
                if (found2 ==  false)
                {
                    System.out.print("Sorry your cookie was not found you will be returned to the menu");
                }
            }
        }
        if (option.equalsIgnoreCase("no"))
        {
            System.out.println("you will now be rreturned to the menu");
        }
    }
    //Save/write dessert objects to a file
    public void saveToFile()
    {
        //variabl for name of file
        String fileName;
        //Creating a new output Stream
        ObjectOutputStream fileOut;

        //Try-Catch used to have a less violent crash
        try{
            //Output stream is set to a new output stream which is named 
            fileOut = new ObjectOutputStream(new FileOutputStream("Dessert3.dat"));
            //loop goes through array
            for (Dessert adessert : desserts)
            {
                //Ensures only dessert objects are stored
                fileOut.writeObject(adessert);
            }
            //Ends saving process
            fileOut.close();
            System.out.println(" ");
            //indicates files were saved
            System.out.println("Dessert contents saved");
        }
        catch (IOException e)
        {
            //if no desserts were  made instead of violently  crashing  a message indicating this is displayed
            System.out.println("There are no desserts listed");
        }
    }
    //Read/copy desserts to array list
    public boolean readFromFile()
    {
        //used to indicate when file copying should end
        int index=0;
        //variable for filename
        String fileName;
        //new object input stream
        ObjectInputStream fileIn;
        //Empty Dessert variable
        Dessert aDessert;

        //Try-Catch used to have a less violent crash
        try{
            //input stream is set to a new input stream which is named 
            fileIn = new ObjectInputStream(new FileInputStream("Dessert3.dat"));
            //indicates file was opened
            System.out.println("Opened file successfully");
            //Sets empty dessert variable to object being copied into the program
            aDessert = (Dessert) fileIn.readObject();

            index = 1;
            //Objects will continued to be copied over as long as thier is an object to set the empty dessert to
            while (aDessert != null)
            {
                //adds found object to array
                desserts.add(aDessert);
                //Sets empty dessert variable to object being copied into the program
                aDessert = (Dessert) fileIn.readObject();
                index++;
            }
            //Ends copying process
            fileIn.close();
            //indicates all objects were copied over
            return true;
        }
        catch (IOException e)//this will be called if a) file doesn't exist or
        //b) it has reached the end of the file
        {
            if (index > 0) //there were accounts in the file 
            {
                this.numberOfDesserts = index;  //this takes note of how many accounts were copied over.
                return true; 
            }
            else //file doesn't exist
            { System.out.println("Desserts Have not been made yet please create a few");
                return false;
            }
        }
        //Used in the case of no objects being found
        catch (ClassNotFoundException e)
        {
            System.out.println("Class Error : " + e.getMessage());
            return false;
        }
    }
    //Main method for whole operation
    public static void main(String[] args)
    {
        //clears screen
        System.out.print("\f");
        //Calls new driver
        MasterDessert driver = new MasterDessert();
        driver.createPin();
        if (driver.readFromFile()== true)  //Desserts have already been created
        {
            System.out.println("System is packed with Desserts");

        }
        else //there are no Desserts to be found so user has to input them
        {

            System.out.println("\n********Create and Store Desserts*************");

        }   
        //Calls main  mmenu
        driver.gMenu();
        //Ends program
        driver.end();
        //Savin method
        driver.saveToFile();
    }
    //Method to reset pin
    public void resetPin()
    {
        //Scaner
        Scanner scan = new Scanner(System.in);
        //Variablr for user opiton
        String option;
        //Variable to match current pin
        String oldPin;
        //Variable to answer queestiob
        String answer;
        //Used if answer or pin is wrong
        int index = 0;
        //Used if answer or pin is wrong
        int index2 = 0;

        //loop ensures options given are chosen
        do
        {
            System.out.println("Do you remember the pin you entered At the start ( yes/no)");
            option = scan.nextLine(); 
        }while (!option.equalsIgnoreCase("yes") && !option.equalsIgnoreCase("no"));
        //If user still knows pin
        if(option.equals("yes"))
        {
            //Asks for old/current pin
            System.out.println("Please Enter your old pin"); 
            oldPin = scan.nextLine();
            //If the is correct the pin is changed
            if(oldPin.equals(pin))
            {
                System.out.println("The pin you have entered is correct now change your pin");
                newPin = scan.nextLine();
                //Setting of the new pin
                pin = newPin;
                System.out.println("Your pin has been reset");
                //setin of index to one indicates no errors were made
                index = 1;

            }
            //loop if user fails to enter correct pin
            while(index == 0)
            {
                System.out.println("You have failed to enter the correct pin please try again");
                oldPin = scan.nextLine();
                if(!oldPin.equals(pin))
                {
                    //indicates user failed again
                    index = 2;
                }
            }
            //when the user fails they answer a seccurity question
            if (index == 2)
            {
                //Asks security question
                System.out.println("You have failed to enter the correct pin please answer the security question");
                System.out.println("What was your favourite place to visit as a child");
                answer = scan.nextLine();
                //If answer is crrect pin is reset
                if (answer.equalsIgnoreCase(Question))
                {
                    System.out.println("You have answered correctly please change your pin");
                    newPin = scan.nextLine();
                    pin = newPin;
                    System.out.println("Your pin has been reset");
                }
                //If the answer is incorrect they are asked again
                if (!answer.equalsIgnoreCase(Question))
                {
                    System.out.println("You have failed to answer the security question correctly please try again");
                    answer = scan.nextLine();
                    if (!answer.equalsIgnoreCase(Question))
                    {
                        //indicates user failed again
                        index2 = 1;
                    }
                }
                //User is returned to the menu
                if (index2 == 1)
                {
                    System.out.println("You have completely failed to enter the correct information and will now be returned to the menu");
                }
            }
        }
        //if user does not remember pin they are asked for the security question
        if (option.equalsIgnoreCase("no"))
        {
            System.out.println("That is fine if you dont remember your pin please answer the security question");
            System.out.println("What was your favourite place to visit as a child");
            answer = scan.nextLine();
            //if answer is correct pin gets rest
            if (answer.equalsIgnoreCase(Question))
            {
                System.out.println("You have answered correctly please change your pin");
                newPin = scan.nextLine();
                pin = newPin;
                System.out.println("Your pin has been reset");
                index2 = 1;
            }
            //if user fails they are adked again
            while(index2 ==0)
            {
                System.out.println("You have failed to answer the security question correctly please try again");
                answer = scan.nextLine();
                if (!answer.equalsIgnoreCase(answer))
                {
                    //indicates user failed to answer correctly
                    index2 = 2;
                }
            }
            //User is returned to menu
            if (index2 == 2)
            {
                System.out.println("You have completely failed to enter the correct information and will now be returned to the menu");
            }

        }
    }
    // method to end 
    public void end()
    {
        //farewell message
        System.out.print("Thank you for working with us");

    }
}
