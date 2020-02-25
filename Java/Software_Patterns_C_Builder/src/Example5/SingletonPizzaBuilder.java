package Example5;


public class SingletonPizzaBuilder {

	private static SingletonPizzaBuilder instance;
	private String type;
	
	public SingletonPizzaBuilder()
	{
		
	}
	
	public static SingletonPizzaBuilder getInstance()
	{
		if (instance != null) {
			System.out.println("Object Already Exists");
			return instance;
		}
		else 
			instance = new SingletonPizzaBuilder();
		return instance;
	}
	
	public PizzaBuilder returnBuilder(String s)
	{
		PizzaBuilder p=null ;
		if(s.equals("Hawaiian"))
		{
			p = new HawaiianPizza(s);
			
		}
		if(s.equals("Pepporoni"))
		{
			p = new PepporoniPizza(s);
		}
		if(s.equals("Margherita"))
		{
			p = new MargheritaPizza(s);
		}
		return p;
	}
}
