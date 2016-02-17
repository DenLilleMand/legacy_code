package model.db;

public class GraphDb implements IGraphDb{
	private static GraphDb instance = new GraphDb();
	
	private GraphDb()
	{
		if(instance != null)
		{
			throw new IllegalStateException();
		}
	}
	
	public static GraphDb getInstance()
	{
		return instance;
	}
}
