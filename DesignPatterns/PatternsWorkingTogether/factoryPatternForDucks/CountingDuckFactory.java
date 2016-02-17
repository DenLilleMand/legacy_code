package factoryPatternForDucks;

import interfaces.Quackable;
import decorator.QuackCounter;
import ducks.DuckCall;
import ducks.MallardDuck;
import ducks.RedheadDuck;
import ducks.RubberDuck;

public class CountingDuckFactory extends AbstractDuckFactory
{
	@Override
	public Quackable createMallardDuck() 
	{
		return new QuackCounter(new MallardDuck());
	}

	@Override
	public Quackable createRedheadDuck() 
	{
		return new QuackCounter(new RedheadDuck());
	}

	@Override
	public Quackable createDuckCall() 
	{
		return new QuackCounter(new DuckCall());
	}

	@Override
	public Quackable createRubberDuck() 
	{
		return new QuackCounter(new RubberDuck());
	}
}
