package Example4;

public class MargheritaPizza extends PizzaBuilder {
	Pizza pizza = new Pizza();
	public MargheritaPizza(String s)
	{
		pizza.setType(s);
	}
	
	@Override
	void rollDough() {
		// TODO Auto-generated method stub
		System.out.println("Dough Rolled");
	}

	@Override
	void addTomato() {
		// TODO Auto-generated method stub
		System.out.println("Tomatao Sauce added");
		pizza.addToppoing("Tomato Sauce");
	}

	@Override
	void SprnikleCheese() {
		// TODO Auto-generated method stub
		System.out.println("Cheese Sprinkled");
		pizza.addToppoing("Mozzerella Cheese");
	}

	@Override
	void addToppings() {
		// TODO Auto-generated method stub
		pizza.addToppoing("Tomato");
		pizza.addToppoing("Basil");
		
	}
	@Override
	void viewToppings() {
		// TODO Auto-generated method stub
		System.out.println(pizza.type +" toppings:");
		for(int i = 0; i<pizza.toppings.size();i++)
		{
			System.out.println(pizza.toppings.get(i));
		}
	}
	public Pizza getPizza()
	{
		return this.pizza;
	}

}
