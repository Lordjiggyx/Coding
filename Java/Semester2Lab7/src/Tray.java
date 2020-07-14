
public class Tray{
	
	int drink;
	boolean isFull = false;

	public Tray() {
		
	}
	
	public synchronized int getDrink(){
		ensureFull(true);
		setFull(false);
		return drink;
	}
	
	public synchronized void setDrink(int drink){
		ensureFull(false);
		this.drink = drink;
		setFull(true);

	}
	
	private void ensureFull(boolean howTheyWantIt){
		while (howTheyWantIt != isFull){
			//TODO: wait
		}
	}

	
	private void setFull(boolean b){
		isFull = b;
		//TODO: What do you need to do with the lock?

	}

}
