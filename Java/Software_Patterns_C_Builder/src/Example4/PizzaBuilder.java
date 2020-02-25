package Example4;

public abstract class PizzaBuilder {
	protected Pizza pizza = new Pizza();
	
	abstract void rollDough();
	abstract void addTomato();
	abstract void SprnikleCheese();
	abstract void addToppings();
	abstract void viewToppings();
	abstract Pizza getPizza();
}
