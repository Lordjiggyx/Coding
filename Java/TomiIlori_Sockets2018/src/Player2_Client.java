import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Player2_Client 
{
	public Player2_Client() throws UnknownHostException ,IOException
	{
		//Create a new Socket to be connected the server socket
		Socket socket = new Socket("localhost" , 3005);
		//Creates a variable that allows information to be sent over in a stream to be printed on the server side
		PrintWriter out = new PrintWriter(socket.getOutputStream() , true);
		//Creates a variable that allows information to be taken in over a stream and be read on the client side
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		Scanner scan = new Scanner(System.in);
		int inplay = 1;
		String answer;
		String inputline;
		String attempt;
		int i;
		System.out.println("Game started");
		do
		{
		for( i = 0 ; i <= 4 ; i++)
		{
		//Player 1:Guess a Leteer
		inputline = in.readLine();
		System.out.println(inputline);
		attempt = scan.nextLine();
		out.println(attempt);
		//You Guessed
		inputline = in.readLine();
		System.out.println(inputline);
		//Correct letter
		inputline = in.readLine();
		System.out.println(inputline);
		//You have guesses left
		inputline = in.readLine();
		System.out.println(inputline);
		}
		//congrats you have finished
		inputline = in.readLine();
		System.out.println(inputline);
		//you scored
		inputline = in.readLine();
		System.out.println(inputline);
		//Player Guessing The Word
		inputline = in.readLine();
		System.out.println(inputline);
		attempt = scan.nextLine();
		out.println(attempt);
		//the word was correct/incorrect
		inputline = in.readLine();
		System.out.println(inputline);
		//the word was
		inputline = in.readLine();
		System.out.println(inputline);
		//would you like to start again
		inputline = in.readLine();
		System.out.println(inputline);
		answer = scan.nextLine();
		out.println(answer);
		
		if(answer.equalsIgnoreCase("no"));
		{
			inplay = 0;
		}
		if(answer.equalsIgnoreCase("yes"));
		{
			i = 0;
			inplay= 1;
		}
		}while(inplay ==1);
		
		//game over
		
		//All Streams must be closed to prevent leak of information
				//Output stream is closed
				out.close();
				//Input stream is closed
				in.close();
				//ClientSocket is closed
				socket.close();
				//Scanner is closed
				scan.close();
	}
	public static void main(String[] args) throws IOException
	{
		new Player2_Client();
	}
	
	
}
