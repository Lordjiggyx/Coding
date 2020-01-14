package Example_1;

public class MealDirector {
	private MealBuilder mb = null;
	
	//Allow the constructor of this class to take in  meal builder object
	public MealDirector(MealBuilder mb) {
		this.mb = mb;
	}

	public void MakeMeal()
	{
		mb.buildDrink();
		mb.buildMain();
		mb.buildSide();
	}
	
	public Meal getMeal()
	{
		return mb.getMeal();
	}
}
