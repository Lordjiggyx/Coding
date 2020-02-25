
public class SingletonLazy {

	//Create an object of the class and set it to equal null 
	private static SingletonLazy first = null;
	
	//Make constructor priavte so it can be accessed outside the class
	private SingletonLazy() {
		// TODO Auto-generated constructor stub
	}

	//create method that allows this object to be accessed outside the class
	public static SingletonLazy getInstance()
	{
		if(first==null)
		{
			first = new SingletonLazy();
		}
		return first;
	
	}
	
	//Additional methods
		public void Message()
		{
			System.out.println("I am a  Lazy Singlton object");
		}

}
