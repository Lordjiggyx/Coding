
//This is the abstrcation
public abstract class Vehicle {

	//Maintaining a refernece to the an object of type implementor
	Engine engine;
	int weightInKilos;

	public abstract void drive();

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void reportOnSpeed(int horsepower) {
		int ratio = weightInKilos / horsepower;
		if (ratio < 3) {
			System.out.println("The vehicle is going at a fast speed.");
		} else if ((ratio >= 3) && (ratio < 8)) {
			System.out.println("The vehicle is going an average speed.");
		} else {
			System.out.println("The vehicle is going at a slow speed.");
		}
	}

}
