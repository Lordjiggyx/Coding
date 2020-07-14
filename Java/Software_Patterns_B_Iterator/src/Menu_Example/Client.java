package Menu_Example;



public class Client {
    //Declare the Aggregate/Collection classes
	DinerMenu dm = new DinerMenu();
	PancakeHouseMenu phm = new PancakeHouseMenu();
	
	//get iterator of both classes
	Iterator dmi = dm.getIterator();
	Iterator phmi = phm.getIterator();
		
	//Method to print both menus
	public void printMenu()
	{
		System.out.println("==========Diner Menu=========");
		while(dmi.hasNext())
		{
			//Represents each item in the list
			MenuItem m = (MenuItem) dmi.next();
			//calls the print method
			m.print(); 
		}
		
		System.out.println("==========Pancake Menu=========");
		while(phmi.hasNext())
		{
			//Represents each item in the list
			MenuItem m = (MenuItem) phmi.next();
			//calls the print method
			m.print(); 
		}
	}

	public void printBMenu()
	{
		System.out.println("==========Pancake Menu=========");
		while(phmi.hasNext())
		{
			//Represents each item in the list
			MenuItem m = (MenuItem) phmi.next();
			//calls the print method
			m.print(); 
		}
	}
	
	
	public void printLMenu()
	{
		System.out.println("==========Diner Menu=========");
		while(dmi.hasNext())
		{
			//Represents each item in the list
			MenuItem m = (MenuItem) dmi.next();
			//calls the print method
			m.print(); 
		}
	}
	
	public void VegMenu()
	{
		System.out.println("==========Diner Veg Menu=========");
		while(dmi.hasNext())
		{
			//Represents each item in the list
			MenuItem m = (MenuItem) dmi.next();
			//calls the print method if item is vegetarian
			if(m.isVegetarian())
			{
				m.print();
			}
			 
		}
		
		System.out.println("==========Pancake Veg Menu=========");
		while(phmi.hasNext())
		{
			//Represents each item in the list
			MenuItem m = (MenuItem) phmi.next();
			//calls the print method if item is vegetarian
			if(m.isVegetarian())
			{
				m.print();
			} 
		}
	}
	
	
	public void isItemVeg()
	{
		System.out.println("==========Is it Vegetarian????=========");
		while(dmi.hasNext())
		{
			//Represents each item in the list
			MenuItem m = (MenuItem) dmi.next();
			//Displa
			if(m.isVegetarian())
			{
				System.out.println(m.getName() + " Is Vegetarian");
			}
			else
			{
				System.out.println(m.getName() + " Is not Vegetarian");

			}
			 
		}
		while(phmi.hasNext())
		{
			//Represents each item in the list
			MenuItem m = (MenuItem) phmi.next();
			//calls the print method if item is vegetarian
			if(m.isVegetarian())
			{
				System.out.println(m.getName() + " Is Vegetarian");
			}
			else
			{
				System.out.println(m.getName() + " Is not Vegetarian");

			}
		}
	}
	
	
	
		public static void main(String args[]) 
		{ 
			Client c = new Client();
			//c.printMenu();
			//c.printBMenu();
			//c.printLMenu();
			c.isItemVeg();
			//c.VegMenu();
		} 
}
