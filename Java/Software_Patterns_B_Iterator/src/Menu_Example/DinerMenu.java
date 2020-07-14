package Menu_Example;

import Menu_Example.PancakeHouseMenu.iterator;

public class DinerMenu implements Collection {
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinerMenu() {
            menuItems = new MenuItem[MAX_ITEMS];

            addItem("Vegetarian BLT",
                    "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99);
            addItem("BLT",
                    "Bacon with lettuce & tomato on whole wheat", false, 2.99);
            addItem("Soup of the day",
                    "Soup of the day, with a side of potato salad", false, 3.29);
            addItem("Hotdog",
                    "A hot dog, with saurkraut, relish, onions, topped with cheese",
                    false, 3.05);
            addItem("Steamed Veggies and Brown Rice",
                    "Steamed vegetables over brown rice", true, 3.99);
            addItem("Pasta",
                    "Spaghetti with Marinara Sauce, and a slice of sourdough bread",
                    true, 3.89);
    }

    public void addItem(String name, String description,
                         boolean vegetarian, double price)
    {
            MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
            if (numberOfItems >= MAX_ITEMS) {
                    System.err.println("Sorry, menu is full!  Can't add item to menu");
            } else {
                    menuItems[numberOfItems] = menuItem;
                    numberOfItems = numberOfItems + 1;
            }
    }

    public MenuItem[] getMenuItems() {
            return menuItems;
    }

    public String toString() {
            return "Diner Menu";
    }
    // other menu methods here

    //Returns the internal iterator inside the class
	@Override
	public Iterator getIterator() {
		// TODO Auto-generated method stub
		return new iterator();
	}
	
	
	public class iterator implements Iterator
	{
		//Gets index of current postion
		int index;
		
		@Override
		public boolean hasNext() {
			//If the index is lower then the size of the array then there is a next element otherwise there is not
			if(index<menuItems.length)
			{
				return true;
			}
			else 
				return false;
		}

		@Override
		public Object next() {
			//If there is a next item
			if(this.hasNext())
			{
				//returen the next item in the list
				return menuItems[index++];
			}
			return null;
		}
		
	}
	
	
	
}