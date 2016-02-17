package factoryPatternForGeese;

import adapter.GooseAdapter;
import gooses.Goose;
import interfaces.Honkable;
import interfaces.Quackable;

/**
 * så det her er vel en kombination af adapter pattern og abstract factory
 * @author DenLilleMand
 *
 */
public class GeeseFactory extends AbstractFactoryGoose
{
	@Override
	public Quackable createGooseDuck() 
	{
		return new GooseAdapter(new Goose());
	}

	@Override
	public Honkable createGoose() 
	{
		return new Goose();
	}

}
