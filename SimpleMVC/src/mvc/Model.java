package mvc;

import java.util.Observable;

public class Model extends Observable
{
	
	
	public void setMeasurementsChanged(ModelEvent e)
	{
		setChanged();
		notifyObservers(e);
	}
	
	
}
