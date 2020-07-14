package Menu_Example;

import java.util.ArrayList;



public class PancakeHouseMenu implements Collection {
        ArrayList<MenuItem> menuItems;
 
        public PancakeHouseMenu() {
                menuItems = new ArrayList<MenuItem>();
   
                addItem("K&B's Pancake Breakfast",
                        "Pancakes with scrambled eggs, and toast",
                        true,
                        2.99);
 
                addItem("Regular Pancake Breakfast",
                        "Pancakes with fried eggs, sausage",
                        false,
                        2.99);
 
                addItem("Blueberry Pancakes",
                        "Pancakes made with fresh blueberries",
                        true,
                        3.49);
 
                addItem("Waffles",
                        "Waffles, with your choice of blueberries or strawberries",
                        true,
                        3.59);
        }

        public void addItem(String name, String description,
                            boolean vegetarian, double price)
        {
                MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
                menuItems.add(menuItem);
        }
 
        public ArrayList getMenuItems() {
                return menuItems;
        }
 
        public String toString() {
                return "Pancake House Menu";
        }

        //Returns the internal iterator inside the class
		@Override
		public Iterator getIterator() {
			// TODO Auto-generated method stub
			return new iterator();
		}

        public class iterator implements Iterator
        {
        	//Current item in the list index
        	int index = 0;
        	
        	//Determins if there is a value after the current one
        	@Override
        	public boolean hasNext() {
        		
        		//if the index is greater or equal then the length of the list then there is no next item
        		//also if the current position is null then there is no next item
        		
        		if(index >= menuItems.size() || menuItems.get(index)==null)
        		{
        			return false;
        		}
        		else
        		return true;
        	}

        	
        	//This method return sthe next element in the list and then increments the index value
        	@Override
        	public Object next() {
        		
        		//Create a new Menu object being the next item and return it
        		 MenuItem m = menuItems.get(index++);
        		//Returns the current object
        		return m;
        	}
        	
        }
}

