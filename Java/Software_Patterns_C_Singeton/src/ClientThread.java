
public class ClientThread {

	public static void main(String[] args)
	{
		//Create a thread usin the runnable interface whihc will execute the code that creates the singleton classes
		Runnable getTiles = new GetTheTiles();
		
		//Create anothe thread 
		Runnable getTiles1 = new GetTheTiles();
		
		//Call for the code to execute in the threads
		new Thread(getTiles).start();
		new Thread(getTiles1).start();
	}

}
