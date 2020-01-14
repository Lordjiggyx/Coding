package Example5;

import java.util.ArrayList;

public class Pizza {
	
	
		String type;
		ArrayList<String> toppings = new ArrayList();
		
		public Pizza()
		{
			
		}
		
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}

		public ArrayList<String> getToppings() {
			return toppings;
		}

		public void setToppings(ArrayList<String> toppings) {
			this.toppings = toppings;
		}
		public void addToppoing(String s)
		{
			this.toppings.add(s);
		}
		

}
