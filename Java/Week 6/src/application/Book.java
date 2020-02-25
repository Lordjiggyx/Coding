// A simple Book class that contains two data attributes


package application;

public class Book {
    private String name;
    private String author;
    
    public Book (String n, String a){
        this.name = n;
        this.author = a;
    }
    
    public String getName () {
        return this.name;
    }
    
    public String getAuthor () {
        return this.author;
    }
}
