import java. io.*;
/**
 * Write a description of class Dessert here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Dessert implements Serializable
{
    //instance variables
    protected String name;
    protected double price;
    protected int stock;
    
    //Empty constructor
    public Dessert()
    {   
        this.name = " ";
        this.price = 0;
        this.stock = 0;
    }
    //Constructor with variables
    public Dessert(String name , double price , int stock)
    {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    //Getter methods
    public String getname()
    {
        return this.name = name;
    }

    public double getprice()
    {
        return this.price = price;
    }

    public int getstock()
    {
        return this.stock = stock;
    }
    //Setter methods
    public void setname(String name)
    {
        this.name = name;
    }

    public void setprice(double price)
    {
        this.price = price;
    }

    public void setstock(int stock)
    {
        this.stock = stock;
    }
    //Function for removing stock
    public void stockremover(int stock)
    {
        this.stock = this.stock - stock;
    }
    //Function for adding stock
    public void stockadder(int stock)
    {
        this.stock = this.stock + stock;
    }
    //Function to keep track of stock
    public int stockremaining()
    {
        int remaining;
        remaining = stock - this.stock;
        return stock;
    }
    //display method
    public void display()
    {
        System.out.println("Name:" + this.name);
        System.out.println("Base Price:" + this.price);
        System.out.println("Stock present:" + stockremaining());
    }
}