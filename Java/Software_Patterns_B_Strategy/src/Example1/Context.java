package Example1;

public class Context {
	
	//Local reference to a strategy object
	Strategy s;
	
	//Constructor takes in a strategy
	public Context(Strategy s)
	{
		this.s = s;
	}
	
	//Method to set strategy
	public void setStrategy(Strategy s )
	{
		this.s = s;
	}
	
	//method to et result of the startegy
	public Double getResult(Double a , Double b)
	{
		return s.operation(a, b);
	}

}
