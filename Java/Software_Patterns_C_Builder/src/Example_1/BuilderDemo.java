package Example_1;

public class BuilderDemo {

	public static void main(String[] args) {
		
		//Create a Mealbuilder object and allow it to be one of the concrete builders
		MealBuilder mealbuilder = new ItalianMeal();
		//Create a Meal Director and ten allow this to take in the meal builder 
		MealDirector mealDirector = new MealDirector(mealbuilder);
		//Use the makeMeal method on this object in order to create a meal
		mealDirector.MakeMeal();
		//Create a meal object and allow it to be the result of the meal created by the meal director
		Meal meal = mealDirector.getMeal();
		//Print out result
		System.out.println("The meal is " + meal.toString());
		System.out.println("  " );
		
		//Create a Mealbuilder object and allow it to be one of the concrete builders
		MealBuilder mealbuilder1 = new JapaneseMeal();
		//Create a Meal Director and ten allow this to take in the meal builder 
		MealDirector mealDirector1 = new MealDirector(mealbuilder1);
		//Use the makeMeal method on this object in order to create a meal
		mealDirector1.MakeMeal();
		//Create a meal object and allow it to be the result of the meal created by the meal director
		Meal meal1 = mealDirector1.getMeal();
		//Print out result
		System.out.println("The meal is " + meal1.toString());

	}

}
