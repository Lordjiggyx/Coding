public class ATMCard {
 
	int pin;
	boolean valid;

	public ATMCard()
	{
		this.pin = 0000;
	}
	
	public ATMCard(int pin, boolean valid)
	{
		this.pin = pin;
	}
	
	public int getPin()
	{
		return this.pin;
	}
	
	public boolean getValid()
	{
		return this.valid;
	}
	
	public void setPin(int pin)
	{
		this.pin = pin;
	}
	
	public void setValid(boolean valid)
	{
		this.valid = valid;
	}
	
	public String toString()
	{
		return "Pin = " + this.pin;
			
	}
}