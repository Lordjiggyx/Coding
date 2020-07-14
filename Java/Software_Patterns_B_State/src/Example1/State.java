package Example1;

public interface State {
	
	//The two mwthods that the concrete states will take in
	
	//Example of method taking in state
	public String SayHello(Person p);
	
	//Example of method without context
	public String SayGoodbye();
	
	public String myState();

}
