package Applications;

	import java.util.Scanner;
	import generics.ArrayList; //IMPORTANT:we’re NOT using Java’s ArrayList but our own version.
	
	public class bookShelfArrayList
	{
	// declare an ArrayList of Books
	ArrayList<Book> list;
	final int capacity = 3; // this is the capacity of the array
	
	 //Constructor
	 public bookShelfArrayList() 
	 {
	//create the blank ArrayList to store the books
	list = new ArrayList<Book>();
		
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
		
		System.out.println("What is the name of the book");
		title = scan.nextLine();
		
		System.out.println("What is the name of author of the book");
		author = scan.nextLine();
		
		System.out.println("What year was the book made");
		Yop = scan.nextLine();
		
		aBook = new Book ( title , author , Yop);
		list.add(aBook);
		
	}//end addABook
	
	
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
		bookShelfArrayList driver = new  bookShelfArrayList();
	} // end main
	} //end BookShelfArrayList

