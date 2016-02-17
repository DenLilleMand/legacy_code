package burgers;

public class TurkeyBacon extends ComponentDecorator{

	private Burger b;
	public TurkeyBacon(Burger b)
	{
		this.b = b;
	}
	
	@Override
	public String description() 
	{
		return b.description() + "adding turkeybacon";
	}

}
