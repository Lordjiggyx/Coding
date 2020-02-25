package Example_1;

public class ItalianMeal implements MealBuilder {

	private Meal meal;
	
	public ItalianMeal() {
		this.meal = new Meal();
	}

	@Override
	public void buildDrink() {
		this.meal.setDrink("Red Wine");

	}

	@Override
	public void buildMain() {
		this.meal.setMain("Chicken Pizza");

	}

	@Override
	public void buildSide() {
		this.meal.setSide(" Bread ");

	}

	@Override
	public Meal getMeal() {
		return this.meal;
	}

}
