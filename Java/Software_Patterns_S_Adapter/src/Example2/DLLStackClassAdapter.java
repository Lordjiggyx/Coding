package Example2;

//Here we extend the adaptee and implememt the target
//The most confusing part about this one was the use of T which is a special element for linkeed lists

public class DLLStackClassAdapter<T> extends DoubleLinkedList implements MyStack<T> {

	//Not neccessary
	public DLLStackClassAdapter() {
		super();
	}

	@Override
	//Now we adapt the stack methods to work with the linked list methods 
	//we call the corresponding add delete get and view methods
	
	//add
	public void push(T object) {

		insertHead(object);
		
	}
	
	//remove
	@SuppressWarnings("unchecked")
	@Override
	public T pop() {

		return (T)removeHead();

	}
//gets first
	@SuppressWarnings("unchecked")
	@Override
	public T top() {

		return (T)getHead();
	}
//view contemys
	@Override
	public void displayContents() {

		iterateForward();
		
	}

}
