
/**
 * Write a description of class cake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cake extends Dessert
{
    private int layers;
    private String flavour;

    public Cake()
    {
        super();
        this.layers = 0;
        this.flavour = " ";    
    }

    public Cake( String name , double price , int stock , int layers , String flavour)
    {
        super( name , price , stock);
        this.layers = layers;
        this.flavour = flavour;
    }
    
    public int getlayers()
    {
        return this.layers ;
    }
    
    public String getflavour()
    {
        return this.flavour;
    }

    public void setlayers( int layers)
    {
       this.layers = layers;
    }
    
    public void setflavour(String flavour)
    {
        this.flavour = flavour;
    }
    
    public void calculatePrice()
    {
        double layersp;
        layersp = layers * 1.50;
        System.out.println("Price of layers:" + layersp);
        double newPrice = price + layersp;
        System.out.println("Total Price:"+newPrice );
        
        
    }
    
    public void display()
    {
        super.display();
        System.out.println("Number of layers:" + this.layers);
        System.out.println("Flavour of cake:" + this.flavour);
        calculatePrice();
    }
}