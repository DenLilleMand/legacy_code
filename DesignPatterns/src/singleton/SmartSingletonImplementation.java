package singleton;

public class SmartSingletonImplementation {
	/**
	 * Volatile keyworded sikrer at flere tråde håndtere vores instance
	 * variable korrekt når den bliver initialiseret til vores Sintleton instans.
	 */
	private volatile static SmartSingletonImplementation instance;
	
	private SmartSingletonImplementation()
	{
		//handle reflection
	}
	/**
	 * Jeg tror at det ekstra tjek på null har noget at gøre med at tjekke
	 * imens det er et ThreadSafeMiljø istedet for at tjekke når andre ting
	 * kan gøre tæt på parallelt. 
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
