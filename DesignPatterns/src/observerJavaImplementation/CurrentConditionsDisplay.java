package observerJavaImplementation;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement 
{

	Observable observable;
	private float temperature;
	private float humidity;
	
	public CurrentConditionsDisplay(Observable observable)
	{
		this.observable = observable;
		observable.addObserver(this);
	}
	
	@Override
	public void display() 
	{
		System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");		
	}

	/**
	 * Denne metode bliver automatisk kaldt når vi kalder setChanged() og notifyObservers()
	 * ovre i vores WeatherData object.  den giver det observable object med ind som parameter, og et object
	 * som man selv kan vælge at give med, f.eks i vores server/client system kunne det være en besked, eller 
	 * et opdateret array af users. 
	 */
	@Override
	public void update(Observable obs, Object arg) 
	{	
		if(obs instanceof WeatherData)
		{
			WeatherData weatherData = (WeatherData)obs;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}
	}
	
}
