package Example1;

public class Client {

	public static void main(String[] args)
	{
		//Create Our context objects
		
		//Example of a context object with no state
		Person p = new Person();
		
		//In the second one we will pass in a State object
		//CREATE STATE OBJECT
		AngryState as = new AngryState();
		//Pass in the state
		Person p1 = new Person();
		
		//Conversation between Context objects
		
		//For the first context object we must set the state first then call methods
		
		//Person 1 is happy
		p.setState(new HappyState());
		//Greets Happily
		System.out.println(p.getState().SayHello(p));
		
		//Person 2 Greets angrliy
		as.SayHello(p1);
		System.out.println(p1.getState().SayHello(p1));
		
		//Person 1 is now sad so we set the state to sad
		p.setState(new SadState());
		//Person 1 says bye
		System.out.println(p.getState().SayGoodbye());
		//Person 2 is still mad
		System.out.println(p1.getState().SayGoodbye());
		//Now that person 1 is gone person 2 is happy
		p1.setState(new HappyState());
		
		//Person 2 greets hapiily
		System.out.println( p1.getState().SayHello(p1));
		
		//Check states of both people
		System.out.println("Current State Of Person:" +p.getState().myState());
		System.out.println("Current State Of Person 1:" + p1.getState().myState());


		
		
		
	}
}
