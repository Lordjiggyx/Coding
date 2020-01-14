//This is a Concrete decorator as you can see it alos takes a refernece to the component interface in the constructor

public class WingDecorator  extends AnimalDecorator {

	public WingDecorator(Animal animal) {
		super(animal);
	}

	@Override
	public void describe() {
		animal.describe();
		System.out.println("I have wings.");
		//This is where the extra functionality is added
		fly();
	}

	public void fly() {
		System.out.println("I can fly.");
	}

}
