
public class MyDays
{
	int years , months , days , total ;
	
	
	public MyDays( int a , int b , int c)
	{
		 this.days = a;
		 this.months = b;
		 this.years = c;	
	}

	public int TotalDays ()
	{
		synchronized(this)
		{
	total = days;
	total = total + months* 30 ;
	total = total + years *365;
	}
		return total;
}
}