package decorator;

public class Whip extends CondimentDecorator
{
	Beverage beverage;
	
	public Whip(Beverage beverage)
	{
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() 
	{
		return beverage.getDescription() + ", and Whip!";
	}

	@Override
	public double cost() 
	{
		return .25 + beverage.cost();
	}

}
