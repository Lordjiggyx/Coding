
public class EnemyShipFactory {

	
	public EnemyShip makeEnemyShip(String newShipType)
	{
		EnemyShip newShip = null;
		
		if(newShipType.equals("u"))
		{
			return new UFOEnemyShip();
		}
		if(newShipType.equals("r"))
		{
			return new RocketEnemyShip();
		}
		if(newShipType.equals("b"))
		{
			return new BigUFOEnemyShip();
		}
		else 
			return null;
	}

}
