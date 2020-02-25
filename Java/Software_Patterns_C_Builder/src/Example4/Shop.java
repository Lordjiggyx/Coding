package Example4;

public class Shop {
	PizzaBuilder pb = null;
	
	public Shop(PizzaBuilder p)
	{
		this.pb =p;
	}

	public void CreatePizza(PizzaBuilder pb)
	{
		pb.rollDough();
		pb.addTomato();
		pb.SprnikleCheese();
		pb.addToppings();
		pb.viewToppings();
	}
	
	public Pizza GetPizza()
	{
		return this.pb.getPizza();
	}
}
