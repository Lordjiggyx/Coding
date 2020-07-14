package Applications;
import java.util.Scanner;

import dataStructures.*;
public class BookShelfLinked 
{
	
	//Declare a LinkedList of books
	
	LinkedList<Book> list;
	final int capacity = 3 ; // capacity of the linked list
	
	public BookShelfLinked()
	{
	list = new LinkedList<Book>();
	
	for (int i = 0; i<3; i++)
		addABook();
		System.out.println("The books are: ");
		displayBooks();
			
		//delete the 3rd book and display
		removeBook();
		System.out.println("After removal, the books are: ");
		displayBooks();
		}//end constructor
	

public void addABook () 
{
	Scanner scan = new Scanner(System.in);
	//instance variables for user input		
		 String title;
		 String author;
		 String Yop;
		 Book aBook;
	
	//now input 3 books into the ArrayList
	
	
	System.out.println("");
	do
	{
	System.out.println("What is the name of the book");
	title = scan.nextLine();
	
	System.out.println("What is the name of author of the book");
	author = scan.nextLine();
	
	System.out.println("What year was the book made");
	Yop = scan.nextLine();
	
	aBook = new Book ( title , author , Yop);

	if(!list.contains(aBook))
	{
	  	    list.add(aBook);
	}
	else
	{
		System.out.println("Error this book is already contained");
	}
	
}while(!list.contains(aBook));

}

public void displayBooks() 
{
	System.out.println("Books:");
	System.out.println(list.toString());
} //end display

public void removeBook() 
{
	list.remove();
}

public static void main(String[] args)
{
	BookShelfLinked driver = new  BookShelfLinked();
} // end main
} //end BookShelfLinked

	
	
	
	
