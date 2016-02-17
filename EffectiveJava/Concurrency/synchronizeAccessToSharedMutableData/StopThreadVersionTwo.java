package synchronizeAccessToSharedMutableData;

import java.util.concurrent.TimeUnit;

//Cooperative thread termination with a volatile field
public class StopThreadVersionTwo 
{
	private static volatile boolean stopRequested;
	
	public static void main(String[] args) throws InterruptedException
	{
		Thread backgroundThread = new Thread(new Runnable()
		{
			public void run()
			{
				int i = 0;
				while(!stopRequested)
				{
					System.out.println(i++);
				}
			}
		});
		
		backgroundThread.start();
		
		TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
	}
	
	
	
	
	
	
	
}
