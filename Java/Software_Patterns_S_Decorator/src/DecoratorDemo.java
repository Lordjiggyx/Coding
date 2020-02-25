
public class DecoratorDemo {
	public static void main(String[] args) {

		//Here we declare the component and allow it to be set to our concrete component
		Animal animal = new LivingAnimal();
		animal.describe();

		//The decorator will take in this orginal concrete component and then add functionality to it
		animal = new LegDecorator(animal);
		animal.describe();

		animal = new WingDecorator(animal);
		animal.describe();

		animal = new GrowlDecorator(animal);
		animal = new GrowlDecorator(animal);
		animal.describe();
}
}
