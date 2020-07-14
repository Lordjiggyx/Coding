package Example_1;


//Converts integer to Binary
public class ObserverB  implements Observer{

	//The subject class that the observer will attach itself too
	ExampleSubject sub ;
	
public ObserverB(ExampleSubject s )
{
	this.sub = s;
	//This attaches the Observer class to the subjects list of observers
	this.sub.addObserver(this);
}
	
	@Override
	public void doUpdate() {
	      System.out.println( "Binary String: " + Integer.toBinaryString( sub.getState() ) ); 
	}

}
