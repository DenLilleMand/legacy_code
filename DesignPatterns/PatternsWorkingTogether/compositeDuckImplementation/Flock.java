package compositeDuckImplementation;

import java.util.ArrayList;
import java.util.Iterator;

import observerPatternForDucks.Observable;
import interfaces.Observer;
import interfaces.Quackable;

/**
 * Det her er composite pattern + Iterator pattern sammen,
 * som senere kommer til at arbejde sammen med alle de andre patterns i det her projekt.
 * 
 * @author DenLilleMand
 *
 */
public class Flock implements Quackable
{
	ArrayList flockList = new ArrayList();
	Observable observable;
	
	public void addQuacker(Quackable quacker)
	{
		flockList.add(quacker);
		observable = new Observable(this);
	}
	
	
	@Override
	public void quack() 
	{
		/**
		 * Det her er Iterator pattern i arbejde. 
		 */
		Iterator iterator = flockList.iterator();
		while(iterator.hasNext())
		{
			Quackable quacker = (Quackable) iterator.next();
			quacker.quack();	
			notifyObservers(); //giver det samme objekt igen og igen, fordi vi caster
							  //iterator.next() til et allerede lavet objekt 
		}
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
