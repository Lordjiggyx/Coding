import java.util.*;

public class Client {
	
	
	public static void main (String[] args)
	{
		String option;
		
		
		Scanner scan = new Scanner(System.in);
		
		//Factory class
		EnemyShipFactory fac = new EnemyShipFactory();
		//Abstract class
		EnemyShip theEnemy = null;
		
		//Asking for user input
		System.out.println("Wwhat Ship do you want u/r/b");
		option= scan.nextLine();
		
		//Set instance of abstract class to become a subclass being created by the fcatory class method
		theEnemy = fac.makeEnemyShip(option);
		
		//Method to use ship
		EnemyActions(theEnemy);

	}
	
	//Method to control enemy ship
	public static void EnemyActions(EnemyShip es)
	{
		es.DisplayShip();
		es.FollowHero();
		es.shootHero();
	}
}
