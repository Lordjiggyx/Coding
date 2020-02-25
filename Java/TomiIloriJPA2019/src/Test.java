
import java.util.ArrayList;
import java.util.List;


import DAO.AuthorDAO;
import DAO.AddressDAO;
import DAO.BookDAO;
import DAO.CustomerDAO;
import DAO.LocationDAO;
import DAO.CustomerOrderDAO;
import DAO.StoreDAO;
import Entites.Author;
import Entites.Address;
import Entites.Book;
import Entites.Customer;
import Entites.Location;
import Entites.CustomerOrder;
import Entites.Store;
import java.util.Scanner;




public class Test {

	//Global DAO Objects can be accessed in all methods
	BookDAO bDao = new BookDAO();
	AuthorDAO authDao = new AuthorDAO();
	AddressDAO addDao = new AddressDAO();
	LocationDAO ldao = new LocationDAO();
	CustomerDAO cdao = new CustomerDAO();
	CustomerOrderDAO odao= new CustomerOrderDAO();
	StoreDAO sDao = new StoreDAO();
	
	
	public void create() {
		// TODO Auto-generated constructor stub
		
		
		
		//Create Books
		//Harry Potter
		Book book1 = new Book("Harry Potter and the philopshers stone" , 1997 , 5 , "Harry Potter lives at his aunt and uncle's house.");
		Book book2 = new Book("Harry Potter and Chamber of secrets" , 2000 , 5 , " Harry Potter goes back to the Hogwarts School for Witchcraft and Wizardry.");
		Book book3 = new Book("Harry Potter and Order Of the Phoenix" , 2004 , 5 , "Harry Potter joins the order of the phoneix");

		//Percy jackson
		Book book4 = new Book("The Lightning Thief " , 2005  , 5 , "Percy Jackson is the son of the Greek god Poseidon.");
		Book book5 = new Book("Titan Curse" , 2010 , 5 , " Cursed By titans");
		Book book6 = new Book("The Lost Hero" , 2009 , 5 , "Percy finds his roman counterpart");

		//Twilight
		Book book7 = new Book("Twilight" , 2005 , 5 , "Girl meets vampire falls in love");
		Book book8 = new Book("New Moon" , 2007 , 5 , "Nobidy likes human and vampire couples");
		Book book9 = new Book("Eclipse" , 2009 , 5 , "Werewolves!!!!");

		//Persist Books
		
		bDao.persistBook(book1);
		bDao.persistBook(book2);
		bDao.persistBook(book3);
		bDao.persistBook(book4);
		bDao.persistBook(book5);
		bDao.persistBook(book6);
		bDao.persistBook(book7);
		bDao.persistBook(book8);
		bDao.persistBook(book9);
		
			List<Book> hpBooks = new ArrayList<Book>();
			hpBooks.add(book1);
			hpBooks.add(book2);
			hpBooks.add(book3);
		
		   List<Book> pjBooks = new ArrayList<Book>();
			hpBooks.add(book4);
			hpBooks.add(book5);
        	hpBooks.add(book6);
		
			List<Book> twilightBooks = new ArrayList<Book>();
		    hpBooks.add(book6);
			hpBooks.add(book7);
			hpBooks.add(book9);
		
			List<Book> BookInventory = new ArrayList<Book>();
			BookInventory.addAll(hpBooks);
			BookInventory.addAll(pjBooks);
			BookInventory.addAll(twilightBooks);
		
		//Create Authors
		Author auth1 = new Author("JK.Rowling" , 54);
		auth1.addBooks(book1);
		auth1.addBooks(book2);
		auth1.addBooks(book3);
		Author auth2 = new Author("Rick Riordan" , 55  );
		auth2.addBooks(book4);
		auth2.addBooks(book5);
		auth2.addBooks(book6);
		Author auth3 = new Author("Stephanie Meyer" , 54  );
		auth3.addBooks(book7);
		auth3.addBooks(book8);
		auth3.addBooks(book9);
		
		//Persist Authors
		authDao.persistAuthor(auth1);
		authDao.persistAuthor(auth2);
		authDao.persistAuthor(auth3);
		
//		//Create Address for Location
    	Address add1 = new Address("283" , "Blanchardstown" , "DUBLIN" , "D15" ,"Ireland" );
    	Address add2 = new Address("28" , "Galway city" , "GALWAY" , "G" ,"Ireland" );
    	Address add3 = new Address("3" , "Cork city" , "CORK" , "C" ,"Ireland" );
    	Address add4 = new Address("38" , "CastleKnock" , "DUBLIN" , "D15" ,"Ireland" );
		//Persist addresses
    	addDao.persistAddress(add1);
		addDao.persistAddress(add2);
		addDao.persistAddress(add3);
		addDao.persistAddress(add4);
		
//		//Create Store

		Store store1 = new Store("Tomi's Books Dublin , D15");
		Store store2 = new Store("Tomi's Books Galway");
		Store store3 = new Store("Tomi's Books Cork");
		Store store4 = new Store("Tomi's Books Dublin , D15");
		for(Book b: BookInventory)
		{
			//Add  books divisible by 4 to store one
			if(b.getId()%4 ==0)
			{
				if(!store1.getBooks().contains(b.getId()))
				{
					store1.addBooks(b);
					b.addstores(store1);
				}
				else
				{
					System.out.println("Book exists");
				}
				
				
			}
			//Add odd number Id books to store two
			if(b.getId()%2 !=0)
			{
				store2.addBooks(b);
				b.addstores(store2);
				
			}
			
			//Add First book to store three
			if(b.getId()==1)
			{
				store3.addBooks(b);
				b.addstores(store3);
				
			}
			
			//Add all Books to store 4
			store4.addBooks(b);
			b.addstores(store4);
			
		}
		
		//Persisting the stores
		sDao.persistStore(store1);
		sDao.persistStore(store2);
		sDao.persistStore(store3);
		sDao.persistStore(store4);
		

	
		

//		//Create Location

		Location location1 = new Location(add1);
		Location location2 = new Location(add2);
		Location location3 = new Location(add3);
		Location location4 = new Location(add4);
		
			//Add stores to the locations
			location1.addstores(store1);
			location2.addstores(store2);
			location3.addstores(store3);
			location1.addstores(store4);

		//Persist Locations
		ldao.persistLocation(location1);
		ldao.persistLocation(location2);
		ldao.persistLocation(location3);
		ldao.persistLocation(location4);
		
		
		
		
		//Create Customers
		Customer customer1 = new Customer("Tomi_Ilori" , "Cool" , "Tomiilori123@gmail.com");
		Customer customer2 = new Customer("Brian_Daly" , "hi" , "BrianDaly@gmail.com");
		

		//Create Orders
		CustomerOrder order1 = new CustomerOrder();
		CustomerOrder order2 = new CustomerOrder();
		CustomerOrder order3 = new CustomerOrder();

				//Books for the 1st Customer 1st order
				order1.addBooks(BookInventory.get(0));
				order1.addBooks(BookInventory.get(1));
				order1.addBooks(BookInventory.get(2));
				
				//Books for the 2nd Customer 1st order
				order2.addBooks(BookInventory.get(3));
				order2.addBooks(BookInventory.get(4));
				
				
				//Books for the 1st Customer 2nd order
				order3.addBooks(BookInventory.get(6));
				order3.addBooks(BookInventory.get(7));
				order3.addBooks(BookInventory.get(8));
				
				//Set order to match a single customer
				order1.SetCustomer(customer1);
				order2.SetCustomer(customer2);
				order3.SetCustomer(customer2);
				
		//Persist Customers
		cdao.persistCustomer(customer1);
		cdao.persistCustomer(customer2);
		
		//Persist the Orders
		odao.persistOrder(order1);
		odao.persistOrder(order2);
		odao.persistOrder(order3);	
	}
	
	public void getAllBooks()
	{
		//Getting all books
		List<Book> dbBooks = new ArrayList<Book>();
		dbBooks = bDao.getAllBooks();
		//Loop Through array of Database Books
		for(Book b: dbBooks){
			System.out.println("================================");
			System.out.println("Book ID:" + b.getId());
			System.out.println("Book Title:" + b.getTitle());
			System.out.println("Book Price:" + b.getPrice());
			System.out.println("Book Blurb:" + b.getBlurb());
			System.out.println("==================================   ");
			System.out.println("   ");
		}
	}
	
	public void getAllStores()
	{
		//Getting all stores
				List<Store> dbStores = new ArrayList<Store>();
				dbStores = sDao.getAllStores();
				//Loop Through array of Database stores
				for(Store s: dbStores){
					System.out.println("================================");
					System.out.println("Store ID:" + s.getId());
					System.out.println("Store Name:" + s.getName());
					System.out.println("==================================   ");
					System.out.println("   ");
				}
	}

	public void getAllAuthors()
	{
		List<Author> dbAuthors = new ArrayList<Author>();
		dbAuthors = authDao.getAllAuthors();
		//Loop Through array of Database Books
		for(Author a: dbAuthors){
			System.out.println("================================");
			System.out.println("Author ID:" + a.getId());
			System.out.println("Author Name:" + a.getName());
			System.out.println("Author Age:" + a.getAge());
			System.out.println("==================================   ");
			System.out.println("   ");
		}
	}
	
	public void getAllLocations()
	{
		List<Location> dbLocations = new ArrayList<Location>();
		dbLocations = ldao.getAllLocations();
		//Loop Through array of Database locations
		for(Location l: dbLocations){
			System.out.println("================================");
			System.out.println("Location ID:" + l.getId());
			System.out.println("==================================   ");
			System.out.println("   ");
		}
	}
	
	public void getAllAdresses()
	{
		List<Address> dbAdresses = new ArrayList<Address>();
		dbAdresses = addDao.getAllAddresses();
		//Loop Through array of Database addresses
		for(Address a: dbAdresses){
			System.out.println("================================");
			System.out.println("Address ID:" + a.getId());
			System.out.println("Address Street:" + a.getStreet());
			System.out.println("Address City:" + a.getCity());
			System.out.println("Address Postcode:" + a.getPostcode());
			System.out.println("Address County:" + a.getCounty());
			System.out.println("Address Country:" + a.getCountry());
			System.out.println("==================================   ");
			System.out.println("   ");
		}
	}
	

	
	public void getAllCustomers()
	{
		List<Customer> dbCustomers = new ArrayList<Customer>();
		dbCustomers = cdao.getAllCustomers();
		//Loop Through array of Database Books
		for(Customer c: dbCustomers){
			System.out.println("================================");
			System.out.println("Customer ID:" + c.getId());
			System.out.println("Customer Name:" + c.getUsername());
			System.out.println("Customer email:" + c.getEmail());
			System.out.println("Customer Password:" + c.getPassword());
			System.out.println("==================================   ");
			System.out.println("   ");
		}
	}
	
	public void getAllCustomerOrders()
	{
		List<CustomerOrder> dbCustomerOrders = new ArrayList<CustomerOrder>();
		dbCustomerOrders = odao.getAllCustomerOrders();
		//Loop Through array of Database Books
		for(CustomerOrder co: dbCustomerOrders){
			System.out.println("================================");
			System.out.println("Customer Order ID:" + co.getId());
			System.out.println("Customer Id:" + co.getCustomer().getId());
			System.out.println("==================================   ");
			System.out.println("   ");
		}
	}
	
	
	public void updateBookTitle(int id, String updateValue)
	{
		bDao.UpdateBookTitle(id ,updateValue );
	}
	public void updateBookPrice(int id, int updateValue)
	{
		bDao.UpdateBookPrice(id ,updateValue );
	}
	public void updateStoreName(int id, String updateValue)
	{
		sDao.UpdateStoreName(id ,updateValue );
	}
	
	public void updateAddressCity(int id, String updateValue)
	{
		addDao.UpdateAddressCity(id ,updateValue );
	}
	
	public void updateAddresPostcode(int id, String updateValue)
	{
		addDao.UpdateAddressPostcode(id ,updateValue );
	}
	
	public void updateAuthorName(int id, String updateValue)
	{
		authDao.UpdateName(id ,updateValue );
	}
	
	public void updateAuthorAge(int id, int updateValue)
	{
		authDao.UpdateAuthorAge(id ,updateValue );
	}
	
	public void updateCustomerUsername(int id, String updateValue)
	{
		cdao.UpdateCustomerUsername(id ,updateValue );
	}
	
	public void updateCustomerEmail(int id, String updateValue)
	{
		cdao.UpdateCustomerEmail(id ,updateValue );
	}

	public void deleteLocationbyID(int id)
	{
		ldao.RemoveLocationById(id);
	}
	
	public void deleteAddressById(int id)
	{
		addDao.RemoveAddressById(id);
	}
	public void deleteAuthorbyID(int id)
	{
		authDao.RemoveAuthorById(id);
	}
	public void deleteBookbyID(int id)
	{
		bDao.RemoveBookById(id);
	}
	public void deleteCustomerbyID(int id)
	{
		cdao.RemoveCustomerById(id);
	}
	public void deleteCustomerOrderById(int id)
	{
		odao.RemoveCustomerOrderById(id);
	}
	public void deleteStorebyID(int id)
	{
		sDao.RemoveStoreById(id);
	}

	
	

	
	public void updateMenu()
	{
		String option;
		int id;
		String UpdateValue;
		Scanner scan = new Scanner(System.in);
		
		   do
	        {
	           
	            System.out.println(" ");
	            System.out.println("1. Update Address City");
	            System.out.println("2. Update Address Postcode");
	            System.out.println("3. Update Book Title");
	            System.out.println("4. Update Book Price");
	            System.out.println("5. Update Store Name");
	            System.out.println("6. Update Author Name");
	            System.out.println("7. Update Author Age");
	            System.out.println("8. Update Customer Username");
	            System.out.println("9. Update Customer Email");
	            System.out.println("10. Exit");
	            //Ensures options given are chosen
	            do
	            {
	                System.out.println("Please input your menu choice:");
	                option = scan.nextLine();
	            }while (!option.equals("1")&&
	            		!option.equals("2")&&
	            		!option.equals("3")&&
	            		!option.equals("4")&&
	            		!option.equals("5")&&
	            		!option.equals("6")&&
	            		!option.equals("7")&&
	            		!option.equals("8")&&
	            		!option.equals("9")&&
	            		!option.equals("10"));

	            //IF STATEMENTS TO CALL CORRESPONDING METHOD WITH MENU OPTION

	            if(option.equals("1"))
	            {
	                System.out.println(" ");
	                
	                System.out.println("Enter Id");
	                id = scan.nextInt();
	                scan.nextLine();
	                System.out.println("Enter New Value");
	                UpdateValue = scan.nextLine();
	                
	                updateAddressCity(id ,UpdateValue );
	            }

	            if(option.equals("2"))
	            {
	                System.out.println(" ");
	                System.out.println("Enter Id");
	                scan.nextLine();
	                id = scan.nextInt();
	                System.out.println("Enter New Value");
	                UpdateValue = scan.nextLine();
	                
	                updateAddresPostcode(id ,UpdateValue );
	            }     
	            
	            if(option.equals("3"))
	            {
	                System.out.println(" ");
	                System.out.println("Enter Id");
	                id = scan.nextInt();
	                System.out.println("Enter New Value");
	                UpdateValue = scan.nextLine();
	                updateBookTitle(id , UpdateValue);
	            }  
	            
	            if(option.equals("4"))
	            {
	                System.out.println(" ");
	                System.out.println("Enter Id");
	                id = scan.nextInt();
	                scan.nextLine();
	                System.out.println("Enter New Value");
	                UpdateValue = scan.nextLine();
	                updateBookPrice(id , Integer.parseInt(UpdateValue));
	            }  
	            
	            if(option.equals("5"))
	            {
	                System.out.println(" ");
	                System.out.println("Enter Id");
	                id = scan.nextInt();
	                scan.nextLine();
	                System.out.println("Enter New Value");
	                UpdateValue = scan.nextLine();
	                updateStoreName(id , UpdateValue);
	            }  
	            
	            if(option.equals("6"))
	            {
	                System.out.println(" ");
	                System.out.println("Enter Id");
	                id = scan.nextInt();
	                scan.nextLine();
	                System.out.println("Enter New Value");
	                UpdateValue = scan.nextLine();
	                updateAuthorName(id , UpdateValue);
	            }  
	            
	            if(option.equals("7"))
	            {
	                System.out.println(" ");
	                System.out.println("Enter Id");
	                id = scan.nextInt();
	                scan.nextLine();
	                System.out.println("Enter New Value");
	                UpdateValue = scan.nextLine();
	                updateAuthorAge(id , Integer.parseInt(UpdateValue));
	            }  
	            
	            if(option.equals("8"))
	            {
	                System.out.println(" ");
	                System.out.println("Enter Id");
	                id = scan.nextInt();
	                scan.nextLine();
	                System.out.println("Enter New Value");
	                UpdateValue = scan.nextLine();
	                updateCustomerUsername(id , UpdateValue);
	            }  
	            
	            if(option.equals("9"))
	            {
	                System.out.println(" ");
	                System.out.println("Enter Id");
	                id = scan.nextInt();
	                scan.nextLine();
	                System.out.println("Enter New Value");
	                UpdateValue = scan.nextLine();
	                updateCustomerEmail(id , UpdateValue);
	            }  
	           
	        }while(!option.equals("10"));
	}
	
	public void removeMenu()
	{
		String option;
		int id;
		Scanner scan = new Scanner(System.in);
		
		   do
	        {
	           
	            System.out.println(" ");
	            System.out.println("1. Remove An Address");
	            System.out.println("2. Remove An Author  ");
	            System.out.println("3. Remove A Book");
	            System.out.println("4. Reomve A Customer");
	            System.out.println("5. Reomve A Customer Order");
	            System.out.println("6. Remove A Location");
	            System.out.println("7. Remove A Store");
	            System.out.println("8. Exit");
	            
	            //Ensures options given are chosen
	            do
	            {
	                System.out.println("Please input your menu choice:");
	                option = scan.nextLine();
	            }while (!option.equals("1")&&
	            		!option.equals("2")&&
	            		!option.equals("3")&&
	            		!option.equals("4")&&
	            		!option.equals("5")&&
	            		!option.equals("6")&&
	            		!option.equals("7")&&
	            		!option.equals("8")&&
	            		!option.equals("9"));

	            //IF STATEMENTS TO CALL CORRESPONDING METHOD WITH MENU OPTION

	            if(option.equals("1"))
	            {
	                System.out.println(" ");
	                
	                System.out.println("Enter Id");
	                id = scan.nextInt();
	                scan.nextLine();
	               deleteAddressById(id );
	            }

	            if(option.equals("2"))
	            {
	                System.out.println(" ");
	                System.out.println("Enter Id");
	                id = scan.nextInt();
	                scan.nextLine();
	               
	                
	                deleteAuthorbyID(id );
	            }     
	            
	            if(option.equals("3"))
	            {
	                System.out.println(" ");
	                System.out.println("Enter Id");
	                id = scan.nextInt();
	                scan.nextLine();
	                deleteBookbyID(id);
	            }  
	            
	            if(option.equals("4"))
	            {
	                System.out.println(" ");
	                System.out.println("Enter Id");
	                id = scan.nextInt();
	                scan.nextLine();
	                deleteCustomerbyID(id);
	            }  
	            
	            if(option.equals("5"))
	            {
	                System.out.println(" ");
	                System.out.println("Enter Id");
	                id = scan.nextInt();
	                scan.nextLine();
	                deleteCustomerOrderById(id);
	            }  
	            
	            if(option.equals("6"))
	            {
	                System.out.println(" ");
	                System.out.println("Enter Id");
	                id = scan.nextInt();
	                scan.nextLine();
	                deleteLocationbyID(id);
	            }  
	            
	            if(option.equals("7"))
	            {
	                System.out.println(" ");
	                System.out.println("Enter Id");
	                id = scan.nextInt();
	                scan.nextLine();
	                deleteStorebyID(id);
	            }  
	         
	           
	        }while(!option.equals("8"));
	}

	public void viewMenu()
	{
		String option;

		Scanner scan = new Scanner(System.in);
		
		   do
	        {
	           
	            System.out.println(" ");
	            System.out.println("1. View Addresses");
	            System.out.println("2. View Authors");
	            System.out.println("3. View Books");
	            System.out.println("4. View Customers");
	            System.out.println("5. View Customer Orders");
	            System.out.println("6. View Locations");
	            System.out.println("7. View Stores");
	            System.out.println("8. Exit");
	            
	            //Ensures options given are chosen
	            do
	            {
	                System.out.println("Please input your menu choice:");
	                option = scan.nextLine();
	            }while (!option.equals("1")&&
	            		!option.equals("2")&&
	            		!option.equals("3")&&
	            		!option.equals("4")&&
	            		!option.equals("5")&&
	            		!option.equals("6")&&
	            		!option.equals("7")&&
	            		!option.equals("8")&&
	            		!option.equals("9"));

	            //IF STATEMENTS TO CALL CORRESPONDING METHOD WITH MENU OPTION

	            if(option.equals("1"))
	            { 
	            	getAllAdresses();
	            }

	            if(option.equals("2"))
	            {
	            	getAllAuthors();
	            }     
	            
	            if(option.equals("3"))
	            {
	            	getAllBooks();
	            }  
	            
	            if(option.equals("4"))
	            {
	            	getAllCustomers();
	            }  
	            
	            if(option.equals("5"))
	            {
	            	getAllCustomerOrders();
	            }  
	            
	            if(option.equals("6"))
	            {
	            	getAllLocations();
	            }  
	            
	            if(option.equals("7"))
	            {
	            	getAllStores();
	            }  
	         
	           
	        }while(!option.equals("8"));
	}
	public void gMenu()
	{
		String option;
		Scanner scan = new Scanner(System.in);
		
		   do
	        {
	           
	            System.out.println(" ");
	            System.out.println("1. Update Entites");
	            System.out.println("2. Remove Entites");
	            System.out.println("3. View Entites");
	            System.out.println("4. Exit");
	            //Ensures options given are chosen
	            do
	            {
	                System.out.println("Please input your menu choice:");
	                option = scan.nextLine();
	            }while (!option.equals("1")  &&  !option.equals("2") &&  !option.equals("3") &&  !option.equals("4"));

	            //IF STATEMENTS TO CALL CORRESPONDING METHOD WITH MENU OPTION

	            if(option.equals("1"))
	            {
	                System.out.println(" ");
	                updateMenu();
	            }

	            if(option.equals("2"))
	            {
	                System.out.println(" ");
	                removeMenu();
	            }  
	            if(option.equals("3"))
	            {
	                System.out.println(" ");
	                viewMenu();
	            }  
 
	        }while(!option.equals("4"));
	}
	
	public Test()
	{
		//Populates Database
		create();
		
		//Calls General Menu
		gMenu();
	}	

	public static void main(String[] args) {
		new Test();
	}
}
