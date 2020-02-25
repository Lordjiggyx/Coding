
//Basic Singleton
public class Singleton {

	//Create an object of the class
	private static Singleton instance = new Singleton();
	
	//Make the constructor private so it cannot be instantiated elsewhere
	private Singleton() {
		// TODO Auto-generated constructor stub
	}
	
	//Create a method to return the instance of the object
	public static Singleton getInstance()
	{
		return instance;
	}
	
	//Additional methods
	public void Message()
	{
		System.out.println("I am a Singlton object");
	}

}
