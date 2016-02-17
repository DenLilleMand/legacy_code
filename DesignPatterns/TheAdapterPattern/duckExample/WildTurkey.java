package duckExample;

public class WildTurkey implements Turkey
{
	public WildTurkey()
	{
		
	}
	
	@Override
	public void gobble() 
	{
		System.out.println("Wild Turkey: Gobble Gobble");
	}

	@Override
	public void fly() 
	{
		System.out.println("WildTurkey: I'm flying a short distance");
	}

}
