
/**
 * Write a description of class cookie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cookie extends Dessert
{
    //instance variable
    private int sides;
    
    //Empty constructor
    public Cookie()
    {
        super();
        this.sides = 0 ;
        

    }
    //Constructor with variables
    public Cookie( String name , double price , int stock , int sides )
    {
        super( name , price , stock);
        this.sides = sides;
        
    }
    //getter method
    public int getsides()
    {
        return this.sides;
    }
    //setter method
    public void setsides(int sides)
    {
        this.sides = sides;
    }
    //WE had a setter methof for shape but was not needed 
    
    //Method to calculate full price
    public void calculatePrice()
    {
        double sidesp;
            if (this.sides == 1 || this.sides ==2 || this.sides > 8 )
        {
           this.sides = 0;
        }
        sidesp = sides * 0.50;
        System.out.println("Price of sides:" + sidesp);
        double newPrice = price + sidesp;
        System.out.println("Total price:" + newPrice);
    }
    //Method to identify Cookie shape
    public String shapeIdentifier()
    {
        String shape = "";
          if (this.sides == 3)
        {
            shape  = "Triangle";
        }
          if (this.sides == 4)
        {
            shape  = "Square";
        }
          if (this.sides == 5)
        {
            shape  = "Pentagon";
        }
          if (this.sides == 6)
        {
            shape  = "Hexagon";
        }
          if (this.sides == 7)
        {
            shape  = "Heptagon";
        }
          if (this.sides == 8)
        {
            shape  = "Octogon";
        }
          if (this.sides == 1 || this.sides ==2 || this.sides > 8 )
        {
           shape = "circle";
        }
        if (this.sides == 0)
        {
            shape = "circle";
        }
        return shape;
    }
    
    
    //Display method
    public void display()
    {
        super.display();
        if (this.sides == 1 || this.sides ==2 || this.sides > 8)
        {
            System.out.println("Number of sides: set to 0 as your requested dimensions aren't possible");
            this.sides = 0;
        }
        else
        {
            System.out.println("Number of sides:" + this.sides);
        }
        System.out.println("Shape of cookie:" +  shapeIdentifier() );

        calculatePrice();
    }
}