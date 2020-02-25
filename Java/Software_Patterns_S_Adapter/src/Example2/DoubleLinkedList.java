package Example2;
//This is the adaptee
import java.util.NoSuchElementException;

/**
 * Underlying class based on one from java2novice
 *
 */

public class DoubleLinkedList<T> {

	protected Node head;
	protected Node tail;
	protected int size;

	public DoubleLinkedList() {
		size = 0;
	}

	protected class Node {
		T element;
		Node next;
		Node prev;

		public Node(T element, Node next, Node prev) {
			this.element = element;
			this.next = next;
			this.prev = prev;
		}
	}

	/**
	 * returns the size of the linked list
	 */

	public int size() { return size; }

	/**
	 * returns whether the list is empty or not
	 */

	public boolean isEmpty() { return size == 0; }

	/**
	 * adds element at the start of the linked list
	 */

	public void insertHead(T element) {
		Node tmp = new Node(element, head, null);
		if(head != null ) {head.prev = tmp;}
		head = tmp;
		if(tail == null) { tail = tmp;}
		size++;
		System.out.println("adding: " + element);
	}

	/**
	 * adds element at the end of the linked list
	 */

	public void insertTail(T element) {

		Node tmp = new Node(element, null, tail);
		if(tail != null) {tail.next = tmp;}
		tail = tmp;
		if(head == null) { head = tmp;}
		size++;
		System.out.println("adding: " + element);
	}

	/**
	 * this method walks forward through the linked list
	 */

	public void iterateForward(){

		System.out.println("iterating forward..");
		Node tmp = head;
		while(tmp != null){
			System.out.println(tmp.element);
			tmp = tmp.next;
		}
	}

	/**
	 * this method walks backward through the linked list
	 */

	public void iterateBackward(){

		System.out.println("iterating backword..");
		Node tmp = tail;
		while(tmp != null){
			System.out.println(tmp.element);
			tmp = tmp.prev;
		}
	}

	/**
	 * this method removes an element from the start of the linked list
	 */

	public T removeHead() {
		try {
			if (size == 0) throw new NoSuchElementException();
			Node tmp = head;
			head = head.next;
			head.prev = null;
			size--;
			System.out.println("deleted: " + tmp.element);
			return tmp.element;
		}
		catch (NoSuchElementException e) {
			System.out.println("Error - outside bounds of list");
			return null;
		}
	}

	/**
	 * this method removes an element from the end of the linked list
	 */

	public T removeTail() {
		try {
			if (size == 0) throw new NoSuchElementException();
			Node tmp = tail;
			tail = tail.prev;
			tail.next = null;
			size--;
			System.out.println("deleted: "+tmp.element);
			return tmp.element;
		}
		catch (NoSuchElementException e) {
			System.out.println("Error - outside bounds of list");
			return null;
		}
	}
	
	/**
	 * this method inserts an element after a specified position in
	 * the linked list
	 */

	public void insert(int pos, T element) { 
		try {
			if (pos < 0 || pos > (size - 1)) throw new NoSuchElementException();
			if (pos == 0) 
				insertHead(element);
			else if (pos == (size - 1)) 
				insertTail(element);
			else {
				int counter = 0;
				Node tmp = head;
				while (counter < pos) {
					tmp = tmp.next;
					counter++;
				}
				Node nextNode = tmp.next;
				Node newNode = new Node(element, tmp, nextNode);
				tmp.next = newNode;
				nextNode.prev = newNode;
			}
		}
		catch (NoSuchElementException e) {
			System.out.println("Error - outside bounds of list");
		}
	} 

	/**
	 * this method removes and returns the element at a specified
	 * position in the linked list
	 */
	
	public T remove(int pos) { 
		try {
			if (pos < 0 || pos > (size - 1)) throw new NoSuchElementException();
			if (pos == 0) return removeHead();
			if (pos == (size - 1)) return removeTail();

			int counter = 0;
			Node tmp = head;
			while (counter < pos) {
				tmp = tmp.next;
				counter++;
			}
			Node prevNode = tmp.prev;
			Node nextNode = tmp.next;
			prevNode.next = nextNode;
			nextNode.prev = prevNode;
			System.out.println("deleted: " + tmp.element);
			return tmp.element;
		}
		catch (NoSuchElementException e) {
			System.out.println("Error - outside bounds of list");
			return null;
		}
	} 

	/**
	 * this method returns the value in the head without
	 * removing it
	 */
	
	public T getHead() {
		System.out.println("head is: " + head.element);
		return head.element;
	} 

	/** 
	 * this method returns the value in the tail without
	 * removing it
	 */
	
	public T getTail() { 
		System.out.println("tail is: " + tail.element);
		return tail.element; 
	} 


}