package observer;

import java.util.ArrayList;

public class Database implements Observable{

	private ArrayList<Observer> observerList = new ArrayList<Observer>();
	
	@Override
	public void registerObserver(Observer o) 
	{
		observerList.add(o);
	}

	@Override
	public void removeObserver(Observer o) 
	{
		observerList.remove(o);
	}

	@Override
	public void notifyObservers() 
	{
		for(Observer o : observerList)
		{
			o.update(transactions);
		}
	}

}
