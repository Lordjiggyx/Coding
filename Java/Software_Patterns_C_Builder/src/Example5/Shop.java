package Example5;

public class Shop {
	PizzaBuilder pb = null;
	
	public Shop(PizzaBuilder p)
	{
		this.pb =p;
	}

	public void CreatePizza()
	{
		this.pb.rollDough();
		this.pb.addTomato();
		this.pb.SprnikleCheese();
		this.pb.addToppings();
		this.pb.viewToppings();
	}
	
	public Pizza GetPizza()
	{
		return this.pb.getPizza();
	}
}
