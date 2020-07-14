package Example_1;

//Converts integer to hectal
public class ObserverH implements Observer{

	//The subject class that the observer will attach itself too
	ExampleSubject sub ;
	
public ObserverH(ExampleSubject s )
{
	this.sub = s;
	//This attaches the Observer class to the subjects list of observers
	this.sub.addObserver(this);
}
	
	@Override
	public void doUpdate() {
	      System.out.println( "Hex String: " + Integer.toHexString( sub.getState() ) ); 
	}

}

