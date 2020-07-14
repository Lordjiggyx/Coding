package Example_1;

import java.util.ArrayList;

public class ExampleSubject implements Subject {
	
	//List of observers
	private ArrayList<Observer> obs = new ArrayList<Observer>();

	//variable to represent state
	private int state;
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		//Calls the do notify 
		doNotify();
	}

	@Override
	public void addObserver(Observer o) {
		// TODO Auto-generated method stub
		obs.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		obs.remove(o);
	}

	@Override
	public void doNotify() {
		//Call the update methdos on each observer
		for(Observer o : obs)
		{
			o.doUpdate();
		}
		
	}

}
