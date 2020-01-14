//This is a Concrete decorator as you can see it alos takes a refernece to the component interface in the constructor
public class LegDecorator extends AnimalDecorator {
	public LegDecorator(Animal animal) {
		super(animal);
	}

	@Override
	public void describe() {
		animal.describe();
		System.out.println("I have legs.");
		//This is where the extra functionality is added
		dance();
	}

	public void dance() {
		System.out.println("I can dance.");
	}
}
