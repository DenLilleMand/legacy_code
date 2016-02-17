package ducks;

import observerPatternForDucks.Observable;
import interfaces.Observer;
import interfaces.Quackable;

public class RedheadDuck implements Quackable
{
	Observable observable;
	
	public RedheadDuck()
	{
		observable = new Observable(this);
	}
	
	@Override
	public void quack() 
	{
		System.out.println("Quack");	
		notifyObservers();
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
