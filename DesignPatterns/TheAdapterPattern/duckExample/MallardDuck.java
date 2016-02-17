package duckExample;

public class MallardDuck implements Duck 
{
	public MallardDuck()
	{
		
	}

	@Override
	public void quack() 
	{
		System.out.println("MallardDuck: I'm Quacking");
	}

	@Override
	public void fly() 
	{
		System.out.println("MallardDuck: I'm Flying!");
	}

}
