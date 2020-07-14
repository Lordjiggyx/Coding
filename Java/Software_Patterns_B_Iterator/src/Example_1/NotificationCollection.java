package Example_1;

import java.util.ArrayList;


//This is your Concrete Aggregate/Collection 
public class NotificationCollection implements Collection {

	
	//List that will store notifications
	public ArrayList<Notification> nlist = new ArrayList<Notification>();
	
	
	//Constructor
	//In this case on create it will populate the list with 4 notifications
	public NotificationCollection()
	{
		//Note how we call the class add method and not the list one
		add("Notification 1");
		add("Notification 2");
		add("Notification 3");
		add("Notification 4");
	}
	
	//Add method to add notification to the list
	public void add(String str)
	{
		Notification n = new Notification(str);
		nlist.add(n);
	}
	//remove method
	public void add(Notification n )
	{
		nlist.remove(n);
	}
	
	
	//Returns an instance of the Concrete Iterator
	@Override
	public Iterator getIterator() {
		//can take in a list
		return new NotificationIterator(nlist);
	}

}
