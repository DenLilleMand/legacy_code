package mvcherppderp;

import java.util.Observable;

public class Model extends Observable{
	
	private int herpderp;
	
	
	public void updateMessageLabel() {
		herpderp = 20;
		setMeasurementsChanged();
	}
	
	public void setMeasurementsChanged()
	{
		setChanged();
		notifyObservers(herpderp);
	}
}
