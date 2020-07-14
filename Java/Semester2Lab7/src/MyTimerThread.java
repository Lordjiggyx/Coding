
public class MyTimerThread implements Runnable
{
	float lapSeconds;
	float totalSeconds;
	boolean running;
	LapTimer Timer;
	
	public MyTimerThread(float sec , LapTimer a) 
	{
	 this.running = true;
	 this.lapSeconds= 0;
	 this.totalSeconds = sec;
	 this.Timer = a;
	}
	
	public void stop()
	{
		this.running = false;
	}
	
	@Override
	public void run()
	{
		
		while(running)
		{
			Timer.three.setText(String.valueOf(getLapSeconds()));
			Timer.four.setText(String.valueOf(getTotalSeconds()));
			
			try 
			{
				Thread.sleep(1000);
			} catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			++lapSeconds;
			++totalSeconds;
			
		}
	}
	public float getLapSeconds() {
		return lapSeconds;
	}
	
	public float getTotalSeconds() {
		return totalSeconds;
	}
	
}
