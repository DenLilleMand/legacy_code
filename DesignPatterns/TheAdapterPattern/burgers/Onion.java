package burgers;

public class Onion extends ComponentDecorator{

	private Burger b;
	public Onion(Burger b)
	{
		this.b = b;
	}
	
	@Override
	public String description() 
	{
		return b.description() + " and with onions ";
		
	}

}
