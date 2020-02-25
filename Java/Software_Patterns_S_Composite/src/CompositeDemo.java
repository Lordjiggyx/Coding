
public class CompositeDemo {
	public static void main(String[] args) {

		//Here we create the leaves
		Leaf leaf1 = new Leaf("Bob");
		Leaf leaf2 = new Leaf("Fred");
		Leaf leaf3 = new Leaf("Sue");
		Leaf leaf4 = new Leaf("Ellen");
		Leaf leaf5 = new Leaf("Joe");

		//add leaf 1 & 2 to composite 1
		Composite composite1 = new Composite();
		composite1.add(leaf1);
		composite1.add(leaf2);
		//add leaf 3 & 4 to composite 2
		Composite composite2 = new Composite();
		composite2.add(leaf3);
		composite2.add(leaf4);
		//Capable of taking composites and leaves
		Composite composite3 = new Composite();
		composite3.add(composite1);
		composite3.add(composite2);
		composite3.add(leaf5);

		//child so only one line shown
		System.out.println("Calling 'sayHello' on leaf1");
		leaf1.sayHello();

		//both nodes are called
		System.out.println("\nCalling 'sayHello' on composite1");
		composite1.sayHello();
		//both nodes are called
		System.out.println("\nCalling 'sayHello' on composite2");
		composite2.sayHello();
		//all nodes are called
		System.out.println("\nCalling 'sayGoodbye' on composite3");
		composite3.sayGoodbye();

	}
}
