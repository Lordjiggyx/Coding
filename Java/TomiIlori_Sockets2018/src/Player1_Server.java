
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Player1_Server 
{
	//Constructor For Server Socket
	public Player1_Server() throws IOException
	{
		//Initialising server socket and binding to a port
		ServerSocket server = new ServerSocket(3005);
	
		//Allowing the server socket to accept a client socket
		Socket clientSocket = server.accept(); 
		//Creates a variable that allows information to be sent over in a stream to be printed
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream() , true);
		//Creates a variable that allows information to be taken in over a stream and be read on the server side
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		//Scanner created for user input
		Scanner scan = new Scanner(System.in);
		int restart = 1;
		int position=0;
		do
		{
		String Word;
		int points = 0;
		//Opening Message
		System.out.println("=========================================");
		System.out.println("Welcome To Hangman To Start Enter A Word");
 		System.out.println("=========================================");
 		Word = scan.nextLine();
 		String playerinput;
 		
		//Game is Started with a Loop Player has 5 Guesses Thus loop must iterate 5 times
		
		
		//ServerSide
		System.out.println("Game Started");
		
		
		//ServerSide
		for (int i = 0 ; i <= 4 ; i++)
		{
		boolean Right = false;
		System.out.println("Player 1: Guess A letter" );
		System.out.println("Player 2 is Guessing.........." );
		//ClientSide
		out.println("Player 1: Guess A letter");
		//Reads in letter guessed by player
		playerinput = in.readLine();
		//Server Side
		System.out.println("Player 2 Guessed:" + playerinput);
		//Client Side
		out.println("You Guessed:" + playerinput);
		
		//Loop to iterate through String
		for(int a = 0;a< Word.length(); a++)
		{
				if(playerinput.charAt(0) == Word.charAt(a))
				{
					Right = true;
					position = Word.indexOf(playerinput) + 1;
				}	
		}
		
		if(Right == true)
		{
			//Server Side
			System.out.println("Correct Letter");
			System.out.println((4-i) +" Guesses Left" );
			//ClientSide
			out.println("Correct Letter At Position:"+ position);
			out.println("You have " + (4-i) +" Guesses Left");
			points = points + 1;
		}
		if(Right ==false)
		{
			//Server Side
			System.out.println("Incorrect Letter");
			System.out.println((4-i) +" Guesses Left" );
			//ClientSide
			out.println("Incorrect Letter");
			out.println("You have " + (4-i) +" Guesses Left");
			
		
		}
		}
		//Server Side
		System.out.println("Game Finished");
		//ClientSide
		out.println("Congrats You Have Finished");
		
		//Server Side
		System.out.println("Player 2 Scored:" + points + " Points out of 5");
		//ClientSide
		out.println("You Scored:" + points + " Points out of 5");
		
		//Server Side
		System.out.println("Player Guessing Word....");
		//ClientSide
		out.println("Finally Guess The Word:");
		playerinput = in.readLine();
		if(playerinput.equalsIgnoreCase(Word))
		{
			System.out.println("Player Guessed Correctly");
			out.println("You Got The Word Correct");
		}
		if(!playerinput.equalsIgnoreCase(Word))
		{
			System.out.println("Player Guessed Incorrectly");
			out.println("You Got The Word Incorrect");
		}
		
		//Server Side
		System.out.println("The Word was:" + Word);
		//ClientSide
		out.println("The Word was:" + Word);
		
		//ClientSide
		System.out.println("Would you Like to Start again");
		//Server Side
		out.println("Would you Like to Start again");
		playerinput = in.readLine();
		
		
		//if player 2 says yes game is restarted if they say no game is ended
		if(playerinput.equalsIgnoreCase("yes"))
		{
			System.out.println("Game Restarted by player 2");
			
		}
		if(playerinput.equalsIgnoreCase("no"))
		{
			restart = 0;
			System.out.println("Player Ended Game");
		}
		
		
		}while(restart == 1);
		
		out.println("Game Over");
		
		//All Streams must be closed to prevent leak of information
		//Output stream is closed
		out.close();
		//Input stream is closed
		in.close();
		//ClientSocket is closed
		clientSocket.close();
		//Server Socket is closed
		server.close();
	}
	
	public static void main(String[] args) throws IOException
	{
		new Player1_Server();
	}
}
