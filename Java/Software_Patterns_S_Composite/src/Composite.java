import java.util.ArrayList;
import java.util.List;

//This is a composite class
public class Composite implements Component {

	//Here we have alist of components that are esstentialy the children of the composite
	List<Component> components = new ArrayList<Component>();

	//Methods implemented from the component class
	@Override
	public void sayHello() {
		//gets each component in the list of components and carries out the hello method of them
		for (Component component : components) {
			component.sayHello();
		}
	}

	@Override
	public void sayGoodbye() {
		//gets each component in the list of components and carries out the hello method of them

		for (Component component : components) {
			component.sayGoodbye();
		}
	}

	//Methods to manipulate the compposite class and it's childrem
	public void add(Component component) {
		components.add(component);
	}

	public void remove(Component component) {
		components.remove(component);
	}

	public List<Component> getComponents() {
		return components;
	}

	public Component getComponent(int index) {
		return components.get(index);
	}

}