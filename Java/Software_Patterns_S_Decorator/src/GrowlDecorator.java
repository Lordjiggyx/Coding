
public class GrowlDecorator extends AnimalDecorator {
	public GrowlDecorator(Animal animal) {
		super(animal);
	}

	@Override
	public void describe() {
		animal.describe();
		growl();
	}

	public void growl() {
		System.out.println("Grrrrr.");
	}

}
