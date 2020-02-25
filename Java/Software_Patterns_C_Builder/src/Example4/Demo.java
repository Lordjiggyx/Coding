package Example4;

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
		 
		 
		 if(choice.equals("1"))
		 {
			 Type = "Hawaiian";
			 PizzaBuilder p = new HawaiianPizza(Type);
			 Shop s = new Shop(p);
			 s.CreatePizza(p);
			 Pizza pizza = s.GetPizza();
			 System.out.println("You have ordered a " + pizza.type + " Pizza");
			 
		 }
		 if(choice.equals("2"))
		 {
			 Type = "Pepporoni";
			 PizzaBuilder p = new PepporoniPizza(Type);
			 Shop s = new Shop(p);
			 s.CreatePizza(p);
			 Pizza pizza = s.GetPizza();
			 System.out.println("You have ordered a " + pizza.type + " Pizza");
			 
		 }
		 if(choice.equals("3"))
		 {
			 Type = "Margarita";
			 PizzaBuilder p = new MargheritaPizza(Type);
			 Shop s = new Shop(p);
			 s.CreatePizza(p);
			 Pizza pizza = s.GetPizza();
			 System.out.println("You have ordered a " + pizza.type + " Pizza");
			 
		 }
		 
		 
		 
		 
		 
	 }
}
