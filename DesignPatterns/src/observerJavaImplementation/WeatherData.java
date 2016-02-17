package observerJavaImplementation;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class WeatherData  extends Observable
{
	//instance variable declarations
	private float temperature;
	private float pressure;
	private float humidity;
	
	public WeatherData()
	{
		
	}
	
	public float getTemperature()
	{
		return temperature;
	}
	
	public float getHumidity()
	{	
		return humidity;
	}
	
	public float getPressure()
	{
		return pressure;
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
		setChanged();
		notifyObservers();
	}
}
