package christiansGennemGangAdapterPattern;

public class Disk extends ComponentDecorator
{
	private Computer c;
	public Disk(Computer c)
	{
		this.c = c;
	}

	@Override
	public String description() {
		return c.description() + " and a disk";
	}
}
