package makeDefensiveCopiesWhenNeeded;

import java.util.Date;



//Broken "immutable" time period class
public class PeriodWithDefensiveCopiesOfParameters {

	private final Date start;
	private final Date end;
	
	/**
	 * @param start the beginning of the period
	 *@param end the end of the period; must not precede start
	 *@throws IllegalArgumentException if start is after end
	 *@throws NullPointerException if start or end is null
	 *
	 */
	/**
	 * JA! det ser underligt ud at vi laver checks p� parameterne
	 * efter vi har sat dem, men det er vigtigt 
	 * at vi laver tjekket p� de nye kopier vi tager,
	 * og s� beskytter det klassen imod �ndringer p� parametrene fra
	 * en anden tr�d i vores vindue af s�rbarhed i den tid
	 * det tager at kopiere dem og den tid det tager at tjekke dem-
	 * 
	 * i computer security communitiet er dette kendt som 
	 * 'time-of-check/time-of-use or 'TOCTOU attack'
	 * OG ikke nok med dette s� brugte vi ikke clone() metoden p� Date,
	 * fordi den er non-final, s� den ville m�ske returnere en instans
	 * af en subklasse vi ikke har tillid til(Alts� ved at extende
	 * java.util.Date og overwrite metoder med HAXXOR).
	 * Denne slags metoder kan lave et objekt af alle vores klasser,
	 * i en private static arraylist, og dermed have kontrol med hele vores applikation,
	 * for at undg� dette s� bruger vi ikke clone() metoden p� parameter der
	 * kan subclasses(dvs. ikke final).
	 * 
	 * Der er faktisk endnu et angreb der kan udf�res, som jeg viser 
	 * i NoterOgRun.
	 */
	public PeriodWithDefensiveCopiesOfParameters(Date start, Date end)
	{
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
		
		if(this.start.compareTo(this.end) > 0)
			throw new IllegalArgumentException (start + " after "+ end);
	
	}
	
	
	public Date start()
	{
		return start;
	}
	
	public Date end()
	{
		return end;
	}
	
	//... remainder omitted
	
	
}
