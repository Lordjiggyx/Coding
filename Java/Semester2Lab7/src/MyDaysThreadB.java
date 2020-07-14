
public class MyDaysThreadB extends Thread
{
	MyDays days;
	public MyDaysThreadB(MyDays Day1) 
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