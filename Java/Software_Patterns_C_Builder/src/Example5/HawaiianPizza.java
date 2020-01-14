package Example5;

public class HawaiianPizza extends PizzaBuilder {
	Pizza pizza = new Pizza();
	public HawaiianPizza(String s)
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
		pizza.addToppoing("Cheeder Cheese");
	}

	@Override
	void addToppings() {
		// TODO Auto-generated method stub
		pizza.addToppoing("Pineapple");
		pizza.addToppoing("Ham");
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
