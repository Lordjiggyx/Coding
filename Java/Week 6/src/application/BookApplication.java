package application;
import java.util.*;

import dataStructures.*;

public class BookApplication {
    public static void main (String[] args)
    {
        String aName = new String();
        String anAuthor = new String();
        
      LinkedStack<Book> stack = new LinkedStack<Book>();
      
      Book aBook;
      Scanner scan = new Scanner(System.in);
      
      System.out.println("Enter details for 4 four books which will be stored in a stack\n");
      // push 4 books onto the stack
     for (int num = 1; num <= 4; num++)
      {
         
         System.out.println("Book " + num + " -  Enter title : ");
     	 aName = scan.nextLine();
  
       	System.out.println("Book " + num + " - Enter author : ");
         anAuthor = scan.nextLine();
         aBook = new Book (aName, anAuthor);
         stack.push (aBook);
         
      } //end for
     
     
       
      System.out.println ("Size: " + stack.size());
      System.out.println ();

      // Now pop the books
      while (! stack.isEmpty()) {
    	  System.out.print("The top book is : ");
    	  aBook = (Book) stack.peek();
    	  System.out.println(aBook.getName());
      
    	  // Now delete this book to reveal the new top item
    	  aBook = (Book) stack.pop();
      } 
    
    }
}
