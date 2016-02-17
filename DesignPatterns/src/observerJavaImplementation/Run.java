package observerJavaImplementation;


/**
 * The observer pattern:
 * åbenbart er det her pattern det mest brugte i JDK, 
 * @author DenLilleMand
 *
 */

/*
 * 
 * 	Det her er java implementationen af Observer pattern ...  definitionen på et Observer pattern lyder:
 * "Observer - defines a one-to-many dependency between objects so that when one object changes state, all it's
 * dependents are notified and updated automatically".
 *  
 *  Det er en vigtig detalje at vores egen implementation af det her, i pakken Observer faktisk giver en anden
 *  rækkefølge af notifications, det betyder simpelt nok, at man ikke skal lave udregninger der afhænger
 *  af hvilken rækkefølge objekter får sine notifikationer. 
 *  
 *  Det er også vigtigt at kunne gennemskue at vores Observer implementation extender Observable, hvilket selF
 *  betyder at Observable er en klasse, så vi kan f.eks ikke tilføje Observable til klasse som allerede
 *  extender noget. Dette bestrider det 'Design princip' der lyder :"Favor composition over inheritance" 
 *  ... vores egen implementation derimod bruger interfaces.. så det betyder at vi også bestrider det
 *  design råd der hedder  "Program towards interfaces, instead of implementations"  eller noget i den stil.
 *  
 *  
 *  Super relevante definitioner:
 *  
 *  Design Principle:"Identify the aspects of your application that vary and seperate them from what stays
 *  the same." : The thing that varies in the Observer Pattern is the state of the Subject and the number
 *  and types of Observers. With this pattern you can vary the objects that are dependent on the state of the
 *  subject, without having to change that subject that's called planning ahead!.
 *  
 *  
 *  Design Principle:"Program to an interface, not an implementation": Both the subject and Observer use 
 *  interfaces. The subject keeps track of objects implementing the Observer interface, while the observers
 *  register with, and get notified by, the subject interface. As we've seen, this keeps things nice
 *  and loosely coupled.
 *  (Hvilket netop er det vi IKKE gør når vi bruger java's implementation i stedet for vores egen).
 *  
 *  
 *  Design principle:"Favor composition over inheritance": The Observer Pattern uses composition to compose
 *  any number of Observers with their Subjects. These relationships aren't set up by some kind of 
 *  inheritance hierarchy. No, They are set up at runtime by composition ! 
 *   
 */

public class Run 
{

	public static void main(String[] args) 
	{
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		
		//StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		//ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		
		weatherData.setMeasurements(80, 65, 30.f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);

	}

}
