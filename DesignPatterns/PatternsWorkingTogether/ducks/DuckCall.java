package ducks;

import observerPatternForDucks.Observable;
import interfaces.Observer;
import interfaces.Quackable;

public class DuckCall implements Quackable
{
	Observable observable;
	
	public DuckCall()
	{
		observable = new Observable(this);
	}
	
	@Override
	public void quack() 
	{
		System.out.println("Kwak");
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
