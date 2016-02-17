package decorator;

import observerPatternForDucks.Observable;
import interfaces.Observer;
import interfaces.Quackable;
/**
 * så det her er decorator patternet som bliver
 * nu bliver brugt i samarbejde med hvad jeg tror er vores
 * strategy pattern(det der med delte interfaces) og et adapter pattern.
 * 
 * @author DenLilleMand
 *
 */
public class QuackCounter implements Quackable
{
	Quackable duck;
	Observable observable;
	
	static int numberOfQuacks = 0;
	
	public QuackCounter(Quackable duck)
	{
		this.duck = duck;
		observable = new Observable(this);
	}
	
	@Override
	public void quack() 
	{
		duck.quack();
		numberOfQuacks++;
	}
	
	public static int getQuacks()
	{
		return numberOfQuacks;
	}

	@Override
	public void registerObserver(Observer observer) 
	{
		observable.registerObserver(observer);
	}

	@Override
	public void notifyObservers() 
	{
		observable.notifyObservers();
	}
	
}
