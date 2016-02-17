package singleton;

public class ChocolateBoiler 
{
	private static ChocolateBoiler instance;
	private boolean empty;
	private boolean boiled;
	
	
	private ChocolateBoiler()
	{
		empty = true;
		boiled = false;
	}
	
	public static synchronized ChocolateBoiler getInstance()
	{
		if(instance == null)
		{
			instance = new ChocolateBoiler();
		}
		return instance;
	}
	
	public void fill()
	{
		if(isEmpty())
		{
			empty = false;
			boiled = false;
			//fill the boiler with a milk/chocolate mixture.
		}
	}
	
	public void drain()
	{
		if(!isEmpty() && isBoiled())
		{
			//drain the boiled milk and Chocolate
			empty = true;
			
		}
	}
	
	public void boil()
	{
		if(!isEmpty() && isBoiled())
		{
			//Bring the contents to a boil
			boiled = true;
			
		}
	}

	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	public boolean isBoiled() {
		return boiled;
	}

	public void setBoiled(boolean boiled) {
		this.boiled = boiled;
	}
}
