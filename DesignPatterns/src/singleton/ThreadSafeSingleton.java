package singleton;

public class ThreadSafeSingleton 
{
	/**
	 * I denne implementation stoler på at vores JVM opretter objektet før nogen
	 * tråde får adgang til det. 
	 */
	private static ThreadSafeSingleton instance = new ThreadSafeSingleton();
	
	private ThreadSafeSingleton()
	{
	}
	
	public static ThreadSafeSingleton getInstance()
	{
		return instance;
	}
	
	
}
