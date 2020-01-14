import java.util.LinkedList;
public class Client {

	public static void main(String[] args)
	{
		
		//***************Normal Singleton**************/
		//Get the only object avaliable through the method that returns the instance of it
		Singleton object = Singleton.getInstance();
		
		//call the method from this object
		object.Message();
		
		//***************Lazy Singleton**************/
		//Get the only object avaliable through the method that returns the instance of it
		SingletonLazy objectLazy = SingletonLazy.getInstance();
		
		//cal the method from this object
		objectLazy.Message();
		
		//***************Thread Singleton**************/
		
		//First Thread
		//Get the only object avaliable through the method that returns the instance of it
		SingletonThread objectThread = SingletonThread.getInstance();
		
		//Print out the Singleton with a unique id
		System.out.println("Instance Id:" + System.identityHashCode(objectThread));
		
		//Get all letters from the linked list
		System.out.println(objectThread.getLetterList());
		
		//Create the List of tiles for the first player and pick 5 tiles
		LinkedList<String> Player1Tiles = objectThread.getTiles(5);
		
		//Print out player 1 tiles
		System.out.println("Player 1 Tiles:" + Player1Tiles);
		
		//Print out list of Letters to see change
		System.out.println(objectThread.getInstance().getLetterList());
		
		//Second Thread - repeat
		SingletonThread objectThread1 = SingletonThread.getInstance();
		System.out.println("Instance Id:" + System.identityHashCode(objectThread1));
		System.out.println(objectThread1.getLetterList());
		LinkedList<String> Player2Tiles = objectThread.getTiles(9);
		System.out.println("Player 2 Tiles:" + Player2Tiles);
		System.out.println(objectThread1.getInstance().getLetterList());
		
		//Returns the same singleton thread


	}

}
