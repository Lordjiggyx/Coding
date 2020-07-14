package Example1;

public class Client {
	
	public static void main (String[] args)
	{
		//Declare Strategies
		add a = new add();
		sub s = new sub();
		mul m = new mul();
		div d = new div();
		
		
		//VARIABLES FOR OPERATION
		double firstnum = 9;
		double secondnum = 5;
		
		//Declare context object - pass in intial strategy
		Context con = new Context(a);
		
		System.out.println("Your numbers are 9 and 5");
		
		//Call first operation
		System.out.println("When you add these 2 numbers you get:" + con.getResult(firstnum, secondnum));
		
		
		//Change Strategy and call again
		con.setStrategy(s);
		System.out.println("When you Subtract these 2 numbers you get:" + con.getResult(firstnum, secondnum));

		//Change Strategy and call again
		con.setStrategy(m);
		System.out.println("When you multiply these 2 numbers you get:" + con.getResult(firstnum, secondnum));

				
		//Change Strategy and call again
		con.setStrategy(d);
		System.out.println("When you div these 2 numbers you get:" + con.getResult(firstnum, secondnum));

	}

}
