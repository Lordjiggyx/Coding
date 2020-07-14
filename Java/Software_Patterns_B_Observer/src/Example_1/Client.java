package Example_1;

public class Client {

	public static void main(String[] args) {
		//Declare subject class
	      ExampleSubject s = new ExampleSubject();
	      
	      //declare concrete observers
	      new ObserverH(s);
	      new ObserverB(s);
	      
	      //set the state in all of them
	      System.out.println("First state change: 15");	
	      s.setState(15);
	      System.out.println("Second state change: 10");	
	      s.setState(10);
	   }
}
