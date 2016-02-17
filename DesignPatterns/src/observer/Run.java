package observer;


/**
 * The observer pattern:
 * åbenbart er det her pattern det mest brugte i JDK, 
 * @author DenLilleMand
 *
 */

/*
 *  det her er en nogenlunde præsentation af hvordan man laver en hjemmelavet observer, jeg tror der mangler
 *  lidt hist og pist, anyway - jeg laver en ny pakke nu - til at implementere den indbyggede funktionalitet
 *  der er i java - kalder pakken  observerJavaImplementation.
 */

public class Run 
{

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		
		//StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		//ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		
		weatherData.setMeasurements(80, 65, 30.f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);

	}

}
