package factoryPatternForDucks;

import ducks.DuckCall;
import ducks.MallardDuck;
import ducks.RedheadDuck;
import ducks.RubberDuck;
import interfaces.Quackable;

public class DuckFactory extends AbstractDuckFactory
{
	@Override
	public Quackable createMallardDuck() 
	{
		return new MallardDuck();
	}

	@Override
	public Quackable createRedheadDuck() 
	{
		return new RedheadDuck();
	}

	@Override
	public Quackable createDuckCall() 
	{
		return new DuckCall();
	}

	@Override
	public Quackable createRubberDuck() 
	{
		return new RubberDuck();
	}
}
