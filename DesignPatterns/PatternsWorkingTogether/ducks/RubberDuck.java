package ducks;

import observerPatternForDucks.Observable;
import interfaces.Observer;
import interfaces.Quackable;

public class RubberDuck implements Quackable{

	Observable observable;
	
	public RubberDuck()
	{
		observable = new Observable(this);
	}
	
	@Override
	public void quack() 
	{
		System.out.println("Squeak");	
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