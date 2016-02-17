package factoryPatternForGeese;

import interfaces.Honkable;
import interfaces.Quackable;

public abstract class AbstractFactoryGoose 
{
		public abstract Quackable createGooseDuck();
		public abstract Honkable createGoose();
}
