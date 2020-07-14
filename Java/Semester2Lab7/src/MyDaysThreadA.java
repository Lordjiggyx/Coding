
public class MyDaysThreadA implements Runnable 
{
	MyDays days;
	public MyDaysThreadA(MyDays Day1) 
	{
		days = Day1;
	}

	@Override
	public void run()
	{
		days.TotalDays();
		System.out.println(days.TotalDays());
	}

}
