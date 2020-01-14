package Example_1;

public class Meal {

	public String main;
	public String drink;
	public String side;
	
	
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getDrink() {
		return drink;
	}
	public void setDrink(String drink) {
		this.drink = drink;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	
	public String toString()
	{
		return "Drink:" + this.drink +", Main Course:" + this.main + ", side:" + this.side;
	}

}
