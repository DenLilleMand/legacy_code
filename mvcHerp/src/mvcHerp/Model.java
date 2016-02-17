package mvcHerp;

import java.util.Observable;

public class Model extends Observable{
	private String herpderp;
	
	public void messageReceived() 
	{
		herpderp = "lol";
		measurementsChanged();
	}

	private void measurementsChanged() 
	{
		setChanged();
		notifyObservers(herpderp);
	}
	
	
	
	

}
