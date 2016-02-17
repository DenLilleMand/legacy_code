package singleton;

public class UniqueInstance 
{
	private static UniqueInstance instance;
	
	private UniqueInstance()
	{
		//handle reflection
	}
	
	public static UniqueInstance getInstance()
	{
		if(instance == null)
		{
			instance = new UniqueInstance();
		}	
		return instance;
	}
}
