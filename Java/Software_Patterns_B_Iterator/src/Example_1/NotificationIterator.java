package Example_1;

import java.util.ArrayList;

//This is your concrete Iterator class

public class NotificationIterator implements Iterator {
	
	//Instance of the list
	public ArrayList<Notification> nlist = new ArrayList<Notification>();
	//Indec variable
	int index = 0;

	//Constructor takes in list of collection it will iterate over 
	public NotificationIterator(ArrayList<Notification> nlist) {
		this.nlist = nlist;
	}

	//Determins if there is a value after the current one
	@Override
	public boolean hasNext() {
		
		//if the index is greater or equal then the length of the list then there is no next item
		//also if the current position is null then there is no next item
		
		if(index >= nlist.size() || nlist.get(index)==null)
		{
			return false;
		}
		else
		return true;
	}

	
	//This method return sthe next element in the list and then increments the index value
	@Override
	public Object next() {
		
		//Create a new Notifictaion object
		Notification n = nlist.get(index);
		//Increments the position of the index
		index+=1;
		//Returns the current object
		return n;
	}

}
