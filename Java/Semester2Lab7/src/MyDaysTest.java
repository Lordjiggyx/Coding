
public class MyDaysTest 
{
	
	public static void main(String[] args)
	{javax.swing.SwingUtilities.invokeLater(new Runnable(){

		@Override
		public void run()
		{
			MyDays Aday = new MyDays(5 , 5, 5);
			MyDaysThreadA a = new MyDaysThreadA(Aday);
			MyDaysThreadB b = new MyDaysThreadB(Aday);
			Thread one = new Thread(a);
			Thread two = new Thread(b);
			one.start();
			two.start();
			
		}
});
	}
}