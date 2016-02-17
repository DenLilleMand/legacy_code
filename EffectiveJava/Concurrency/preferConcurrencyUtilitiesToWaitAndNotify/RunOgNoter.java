package preferConcurrencyUtilitiesToWaitAndNotify;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public class RunOgNoter 
{
	/**
	 * Prefer concurrency utilties to wait and notify
	 * tl;dr;
	 * 
	 * 
	 * ---------------
	 * Noter:
	 * 'Given the difficulty of using wait and notify
	 *  correctly, you should use the higher-level concurrency utilities instead.'
	 *  "java.util.concurrent" går ind under 3 kategorier ,
	 *  Executor Framework(Som var gennemgået i sidste afsnit), concurrent collections
	 *   og synchronizers.
	 *   
	 *   'Use ConcurrentHashMap in preference to Collections.synchronizedMap or Hashtable.
	 *   
	 		I kode eksempel 1, kan man se noget af det nonsens der 
	 		står i den her sektion.
	 *  
	 * 'Note that the method uses three countdown latches. The first, ready, is used
	 * by worker threads to tell the timer thread when they're ready. The worker threads
	 *  then wait on the second latch, which is start. When the last worker thread
	 *   invokes ready.countDown, the timer thread records the start time and invokes start.countDown, allowing all of the worker threads to proceed. Then the timer
	 *    thread waits on the third latch, done, until the last of the worker threads finishes running the action and calls done.countdown
	 *    As soon as this happens, the timer thread awakens and records the end time.'
	 * 
	 * 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//Simple framework for timing concurrent execution
	
		public static long time(Executor executor, int concurrency,final Runnable action) throws InterruptedException
		{
			final CountDownLatch ready = new CountDownLatch(concurrency);
			final CountDownLatch start = new CountDownLatch(1);
			final CountDownLatch done = new CountDownLatch(concurrency);
			for(int i = 0; i < concurrency; i++)
			{
				executor.execute(new Runnable()
				{
					public void run()
					{
						ready.countDown(); //Tell timer we're ready
						try
						{
							start.await(); // wait till peers are ready
							action.run();
						} catch(InterruptedException e)
						{
							Thread.currentThread().interrupt();
						} finally
						{
							done.countDown(); // Tell timer we're done
						}
						
					}
				});
			}
			ready.await(); //wait for all workers to be ready
			long startNanons = System.nanoTime();
			start.countDown(); // And they're off!
			done.await(); //wait for all workers to finish
			return System.nanoTime() - startNanos;
		
		}
	
	
	}

}
