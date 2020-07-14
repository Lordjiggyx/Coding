
public class MyThreadTester
{

	public MyThreadTester() 
	{
		MyThread  a = new MyThread();
		MyOtherThread b = new MyOtherThread();
		Thread one = new Thread(a);
		Thread two = new Thread(b);
		one.start();
		two.start();
	}
	public static void main(String[] args)
	{javax.swing.SwingUtilities.invokeLater(new Runnable(){

		@Override
		public void run()
		{
			MyThreadTester a = new MyThreadTester();
		}
});
	}
}