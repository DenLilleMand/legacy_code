package christiansGennemGangAdapterPattern;

public class Monitor extends ComponentDecorator
{
	private Computer c;
	
	public Monitor(Computer c)
	{
		this.c = c;
	}

	@Override
	public String description() {
		return c.description() + " and a monitor";
	}
	
	
}
