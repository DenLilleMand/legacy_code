package singleton;

public class ThreadSafeSingleton 
{
	/**
	 * I denne implementation stoler p� at vores JVM opretter objektet f�r nogen
	 * tr�de f�r adgang til det. 
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
