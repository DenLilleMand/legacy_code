package observerPatternForDucks;

import compositeDuckImplementation.Flock;

import interfaces.Observer;
import interfaces.QuackObservable;

public class QuackoLogist implements Observer
{

	@Override
	public void update(QuackObservable duck) 
	{
		System.out.println("Quackologist: " + duck + " Just quacked.");
	}

	@Override
	public void update(Flock flock) {
		System.out.println("Quackologist: " + flock +" just quacked.");
		
	}
	
	

}
