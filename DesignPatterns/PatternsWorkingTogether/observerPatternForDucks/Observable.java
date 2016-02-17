package observerPatternForDucks;

import java.util.ArrayList;
import java.util.Iterator;

import interfaces.Observer;
import interfaces.QuackObservable;

public class Observable implements QuackObservable
{
	ArrayList observerList = new ArrayList();
	QuackObservable duck;
	
	public Observable(QuackObservable duck)
	{
		this.duck = duck;
	}
	
	@Override
	public void registerObserver(Observer observer) 
	{
		observerList.add(observer);
	}

	@Override
	public void notifyObservers() 
	{
		Iterator iterator = observerList.iterator();
		while(iterator.hasNext())
		{
			Observer observer = (Observer) iterator.next();
			observer.update(duck);
		}
	}

}
