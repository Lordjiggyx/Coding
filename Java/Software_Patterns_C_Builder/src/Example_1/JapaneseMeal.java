package Example_1;

public class JapaneseMeal implements MealBuilder {
	
//Instantiate a meal object to be referenced within the class
private Meal meal;
	
	//Creates a meal object 
	public JapaneseMeal() {
		this.meal = new Meal();
	}

	//These methods call the methods in the meal class to set the parameters
	@Override
	public void buildDrink() 
	{
		this.meal.setDrink("Sake");

	}

	public void buildMain() {
		this.meal.setMain("Chicken Teriyaki");

	}

	public void buildSide() {
		this.meal.setSide("Miso Soup");

	}

	@Override
	public Meal getMeal() {
		// TODO Auto-generated method stub
		return this.meal;
	}

}
