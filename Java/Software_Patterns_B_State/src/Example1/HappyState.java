package Example1;

//This is a Concrete State object
public class HappyState implements State {

	
	
	@Override
	public String SayHello(Person p) {
		// TODO Auto-generated method stub
		//Because this method takes in a context object we call the setsState method on the Context object setting it to this
		
		p.setState(this);
		return "Hi there Im happy";
	}

	@Override
	public String SayGoodbye() {
		// TODO Auto-generated method stub
		return "GoodBye have a lovely day";
	}
	
	public String myState()
	{
		return "Happy State";
		
	}

}
