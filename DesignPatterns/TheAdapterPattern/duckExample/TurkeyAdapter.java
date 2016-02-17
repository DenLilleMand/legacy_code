package duckExample;

public class TurkeyAdapter implements Duck{
	Turkey turkey;
	/**
	 * den her klasse er grund princippet i en adapter.
	 * 
	 * @param turkey
	 */
	public TurkeyAdapter(Turkey turkey)
	{
		this.turkey = turkey;
	}

	@Override
	public void quack() 
	{
		turkey.gobble();
	}

	@Override
	public void fly() 
	{
		turkey.fly();		
	}
	
}
