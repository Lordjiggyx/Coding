package Example_1;

public interface MealBuilder {
	//Methods that any class the implements this interface must have
	public void buildDrink();
	public void buildMain();
	public void buildSide();
	public Meal getMeal();
}
