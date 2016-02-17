package singleton;

public class SmartSingletonImplementation {
	/**
	 * Volatile keyworded sikrer at flere tr�de h�ndtere vores instance
	 * variable korrekt n�r den bliver initialiseret til vores Sintleton instans.
	 */
	private volatile static SmartSingletonImplementation instance;
	
	private SmartSingletonImplementation()
	{
		//handle reflection
	}
	/**
	 * Jeg tror at det ekstra tjek p� null har noget at g�re med at tjekke
	 * imens det er et ThreadSafeMilj� istedet for at tjekke n�r andre ting
	 * kan g�re t�t p� parallelt. 
	 * @return
	 */
	public static SmartSingletonImplementation getInstance()
	{
		if(instance == null)
		{
			synchronized(SmartSingletonImplementation.class)
			{
				if(instance == null)
				{
					instance = new SmartSingletonImplementation();
				}
			}
		}
		return instance;
	}
}
