
public abstract class EnemyShip {

	private String name;
	private Double damage;
	
	public EnemyShip() {
		// TODO Auto-generated constructor stub
	}
	
	//Getters and Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDamage() {
		return damage;
	}

	public void setDamage(Double damage) {
		this.damage = damage;
	}

	//Additional Methods all Subclasses will have
	public void FollowHero()
	{
		System.out.println(this.getName() +" is following the Hero");
	}
	public void DisplayShip()
	{
		System.out.println(this.getName() +" is on the screen");
	}
	public void shootHero()
	{
		System.out.println(this.getName() +" shot the hero and does "+ this.getDamage() + " damage");
	}
}
