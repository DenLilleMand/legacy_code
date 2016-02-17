package singletonPattern;

/**
 * Den her er så Eager som den kan blive, 
 *
 */
public class EagerSingleton 
{
	private static final EagerSingleton instance = new EagerSingleton();
	
	public static EagerSingleton getInstance()
	{
		return instance;
	}
	
	private EagerSingleton()
	{
		if(instance != null)
		{
			throw new IllegalStateException();
		}
	}
}
