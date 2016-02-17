package mvc;

import java.util.Observable;

public class Model extends Observable{

	Integer lol = 0;
	public void messageWasReceived() 
	{
		System.out.println("Model: received Message");
		setLol(20);
	}
	
	public void setLol(Integer integer)
	{
		this.lol = integer;
		setMeasurementsChanged();
	}

	private void setMeasurementsChanged() 
	{
		setChanged();
		notifyObservers(lol);
	}
}
