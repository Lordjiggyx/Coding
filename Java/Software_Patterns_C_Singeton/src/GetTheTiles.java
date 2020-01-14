import java.util.LinkedList;

public class GetTheTiles  implements Runnable {

	public GetTheTiles(){
		// TODO Auto-generated constructor stub
	}
	//Method to run thread
	@Override
	public void run() {
		//Create the singleton
		SingletonThread newInstance = SingletonThread.getInstance();
		
		//Get the letter list
		System.out.println(newInstance.getLetterList());
		
		
		//Create the List of tiles for the first player and pick 5 tiles
		LinkedList<String> PlayerTiles = newInstance.getTiles(5);
		//Get instance id
		System.out.println("Instance Id:" + System.identityHashCode(newInstance));
		//Get the players tiles
		System.out.println("Player  Tiles:" + PlayerTiles);
		//Get the letter again
		System.out.println(newInstance.getLetterList());
	}

}
