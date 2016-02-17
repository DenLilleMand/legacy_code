package interfaces;

import compositeDuckImplementation.Flock;

public interface Observer 
{
	public void update(QuackObservable duck);
	public void update(Flock flock);
}
