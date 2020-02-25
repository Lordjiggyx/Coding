package Example5;

import java.util.Scanner;

public class Demo {
	
	 public static void main(String[] args) 
	 {
		 Scanner scan = new Scanner(System.in);;
		 String choice;
		 String Type= null;
		 System.out.println("Welcome Pick a Pizza Tyepe");
		 System.out.println("1 - Hawaiian");
		 System.out.println("2 - Pepporoni");
		 System.out.println("3 - Margarita");
		 choice = scan.nextLine();
		 
		 PizzaBuilder pb;
		// PizzaBuilder pb1;
		 SingletonPizzaBuilder SPB ;
	//	 SingletonPizzaBuilder SPB1 ;
		 
		 SPB = SingletonPizzaBuilder.getInstance();
	//	 SPB1 = SingletonPizzaBuilder.getInstance();
		 
		 if(choice.equals("1"))
		 {
			 Type = "Hawaiian";
			 pb = SPB.returnBuilder(Type);
			// pb1 = SPB1.returnBuilder(Type);
			 Shop s = new Shop(pb);
			 s.CreatePizza();
			 Pizza pizza = s.GetPizza();
			 System.out.println("You have ordered a " + pizza.type + " Pizza");
			 
		 }
		 if(choice.equals("2"))
		 {
			 Type = "Pepporoni";
			 pb = SPB.returnBuilder(Type);
			 Shop s = new Shop(pb);
			 s.CreatePizza();
			 Pizza pizza = s.GetPizza();
			 System.out.println("You have ordered a " + pizza.type + " Pizza");
			 
		 }
		 if(choice.equals("3"))
		 {
			 Type = "Margherita";
			 pb = SPB.returnBuilder(Type);
			 Shop s = new Shop(pb);
			 s.CreatePizza();
			 Pizza pizza = s.GetPizza();
			 System.out.println("You have ordered a " + pizza.type + " Pizza");
			 
		 }
		 
		 
		 
		 
		 
	 }
}
