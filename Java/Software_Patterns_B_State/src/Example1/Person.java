package Example1;

//This is the context object

public class Person {
	
	State state ;

	//A constructor that takes in a context object
	public Person(State s)
	{
		this.state = s;
	}
	
	//A constructor that does not take in a context object
	public Person()
	{
		this.state = null;
	}
	
	
	//Getters and setters for state
	
	public State getState() {
		return state;
	}

	public void setState(State s) {
		this.state = s;
	}
	

}
