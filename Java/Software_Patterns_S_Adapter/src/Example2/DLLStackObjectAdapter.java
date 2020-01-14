package Example2;

//This is an object example 
//The most confusing part about this one was the use of T which is a special element for linkeed lists

public class DLLStackObjectAdapter<T> implements MyStack<T> {

	//Wwe create a refernece tp the adaptee
	private DoubleLinkedList<T> stack;
	
	//in the constructor we instantiate this reference to be a new adapptee class
	public DLLStackObjectAdapter() {
		stack = new DoubleLinkedList();
	}

	@Override
	//call the corresponding methods on this new object
	public void push(T o) {

		stack.insertHead(o);
		
	}

	@Override
	public T pop() {

		return stack.removeHead();

	}

	@Override
	public T top() {

		return stack.getHead();
		
	}

	@Override
	public void displayContents() {

		stack.iterateForward();

	}

}
