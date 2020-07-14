package Example1;

//This is a Concrete State object

public class SadState implements State {

	@Override
	public String SayHello(Person p) {
		// TODO Auto-generated method stub
		//Because this method takes in a context object we call the setsState method on the Context object setting it to this

		p.setState(this);
		return "Hi there Im Sad";
	}

	@Override
	public String SayGoodbye() {
		// TODO Auto-generated method stub
		return "Bye i'll try be better....";
	}

	
	public String myState()
	{
		return "Sad State";
	}

}
