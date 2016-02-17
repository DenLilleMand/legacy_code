package burgers;

public class Cheese extends ComponentDecorator
{
	private Burger b;
	public Cheese(Burger b)
	{
		this.b = b;
	}
	
	@Override
	public String description() 
	{
		return b.description() + " with cheese ";
	}

}
