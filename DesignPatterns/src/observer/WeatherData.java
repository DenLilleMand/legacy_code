package observer;

import java.util.ArrayList;

public class WeatherData implements Subject
{
	//instance variable declarations
	private ArrayList observerList;
	private float temperature;
	private float pressure;
	private float humidity;
	
	public WeatherData()
	{
		observerList = new ArrayList();
	}
	
	
	public void notifyObservers()
	{
		for(int i = 0; i < observerList.size(); i++)
		{
			Observer observer = (Observer) observerList.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}
	
	public void removeObserver(Observer o)
	{
		int i = observerList.indexOf(0);
		if(i >= 0)
		{
			observerList.remove(i);
		}
	}
	
	public void registerObserver(Observer o)
	{
		observerList.add(o);
	}
	
	public float getTemperature()
	{
		
		return 20;
	}
	
	public float getHumidity()
	{
		
		return 20;
	}
	
	public float getPressure()
	{
		
		return 20;
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure)
	{
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
	
	
	public void measurementsChanged()
	{
		notifyObservers();
	}
}
