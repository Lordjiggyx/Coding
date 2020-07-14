package Example1;

//This is a Concrete State object
public class AngryState implements State {

	@Override
	public String SayHello(Person p) {
		// TODO Auto-generated method stub
		//Because this method takes in a context object we call the setsState method on the Context object setting it to this

		p.setState(this);
		return "Fuck Off";
	}

	@Override
	public String SayGoodbye() {
		// TODO Auto-generated method stub
		return "Fuck Off";
	}

	
	public String myState()
	{
		return "Angry State";
	}

}
