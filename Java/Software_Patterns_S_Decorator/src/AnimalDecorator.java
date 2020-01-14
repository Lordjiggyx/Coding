//This is our abstract class for the decorator here it takes in a refernence to the animal component in the ocnstructor
public abstract class AnimalDecorator implements Animal {
	Animal animal;

	public AnimalDecorator(Animal animal) {
		this.animal = animal;
	}
}
