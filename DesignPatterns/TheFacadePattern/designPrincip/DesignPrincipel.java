package designPrincip;

public class DesignPrincipel {
	
	/**
	 * design princippet 
	 * 'Principle of Least Knowledge - talk only to your immediate friends'
	 * 
	 * Det her princip er ogs� kaldt 'The Law of demeter'. 
	 * @return
	 */
	
	
	/**
	 * det her er tydeligvis et eksempel p� hvad
	 * man ikke skal g�re hvis man vil overholde 
	 * det her design princip. 
	 * @return
	 */
	public float getTemp()
	{
		Thermometer thermometer = station.getThermometer();
		return thermometer.getTemperature();
	}
	
	
	public float getTemp()
	{
		return station.getTemperature();
	}
	
}


//------------------------------- Hernede er Car klassen som ikke har noget at g�re
//--------------------------------med det stykke kode ovenover, men beviser det samme-----------


class Car
{
	/**
	 * heres a component of this class. we can call its methods
	 */
	Engine engine;
	//other instance variables
	
	public Car()
	{
		//initialize engine, etc.
	}
	/**
	 * Param key - man m� godt kalde metoder
	 * p� objekter som er givet ind som parameter.
	 * @param key
	 */
	public void start(Key key)
	{
		/**
		 * here we create a new object, it's methods
		 * are legal.
		 */
		Doors doors = new Doors();
		
		/**
		 * samme som f�r, vi m� godt kalde metoder p� key
		 */
		boolean authorized = key.turns();
		
		if(authorized)
		{
			
			engine.start(); //man m� godt kalde metoder p� et objekt man har som variable.
			updateDashBoardDisplay(); // man m� kalde en metode inde i objektet.
			doors.lock();// man m� godt kalde metoder p� et objekt man har lavet eller instansieret.
			
			//indtil videre s� virker det til at den er imod statiske metoder -
			//og objekter der bliver returneret fra andre metoder - hvilket man kan sp�rge om
			//singleton enlig ikke er. 
		}
	}
	
	
	public void updateDashBoardDisplay()
	{
		//update display
	}
	
	
	
}
