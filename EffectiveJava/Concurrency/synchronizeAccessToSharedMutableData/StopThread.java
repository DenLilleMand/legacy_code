package synchronizeAccessToSharedMutableData;

import java.util.concurrent.TimeUnit;

//Properly synchronized cooperative thread termination
public class StopThread 
{
	private static boolean stopRequested;
	
	private static synchronized void requestStop()
	{
		stopRequested = true;
	}
	
	private static synchronized boolean stopRequested()
	{
		return stopRequested;
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		Thread backgroundThread = new Thread(new Runnable()
		{
			public void run()
			{
				int i = 0;
				while(!stopRequested())
				{
					System.out.println(i++);
				}
			}
		});
		
		backgroundThread.start();
		
		TimeUnit.SECONDS.sleep(1);
		requestStop();
	}
	
	
	
	
	
	
	
}
