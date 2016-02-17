package decorator;

public class Soy extends CondimentDecorator
{
	Beverage beverage;
	
	public Soy(Beverage beverage)
	{
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() 
	{
		return beverage.getDescription() + ", and Soy";
	}

	@Override
	public double cost() 
	{
		return .20 + beverage.cost();
	}

}
