import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class SingletonThread {

	//Create an object of the class and set it to equal null 
	private static SingletonThread first = null;
	
	//scrabble Letters held in an array
	  String[] alphabet = {"a", "b", "c", "d", "e",  
            "f", "g", "h", "i",
            "j",   "k", "l", "m", "n", "o", 
            "p", "q", "r", "s", "t",   "u", "v",
            "w", "x", "y", "z"};

	  //Create a linked list o ftype string and place the letters in the list and have it created as an array
	  private LinkedList<String> Letters = new LinkedList<String>(Arrays.asList(alphabet));
	  
	  //Create a boolean that will allow a thread to be slowed down
	  static boolean firstThread = true;
	
	//Make constructor priavte so it can be accessed outside the class
	private SingletonThread() {
		// TODO Auto-generated constructor stub
	}

	//create method that allows this object to be accessed outside the class
	public static SingletonThread getInstance()
	{
		if(first==null)
		{
			//Here we will slow down the thread
			if(firstThread)
			{
				//We will set the thread to false and then cause the current thread to sleep
				firstThread = false;
				Thread.currentThread();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
		}
			//Wrap the class in syncrhonized- forcing it to be a synchronised method until first object is created
			synchronized(SingletonThread.class)
			{
				if(first==null)
				{
				//Create the instance of the class
				first = new SingletonThread();
				//Shuffle letters
				Collections.shuffle(first.Letters);
				}
			}
			
		}
		return first;
		
	}
	
	//Methods to work with threads
	
	
	//Method to return list of avaliable letters
	public LinkedList<String>getLetterList()
	{
		return first.Letters;
	}
	
	//Method to get tiles for the player
	public LinkedList<String> getTiles(int amount)
	{
		//Create Linked list for the user to take letters
		LinkedList<String> tilesToSend = new LinkedList<String>();
		
		//cycle through linked list
		for(int i=0; i<= amount; i++)
		{
			//To get letter we call remove tis chops off whats at the front of the list and moves everythin to the right so we must always chop the front off
			tilesToSend.add(first.Letters.remove(0));
		}
		return tilesToSend;
	}
	

}
