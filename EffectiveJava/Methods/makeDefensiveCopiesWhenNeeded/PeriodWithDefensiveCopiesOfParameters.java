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
	 * JA! det ser underligt ud at vi laver checks på parameterne
	 * efter vi har sat dem, men det er vigtigt 
	 * at vi laver tjekket på de nye kopier vi tager,
	 * og så beskytter det klassen imod ændringer på parametrene fra
	 * en anden tråd i vores vindue af sårbarhed i den tid
	 * det tager at kopiere dem og den tid det tager at tjekke dem-
	 * 
	 * i computer security communitiet er dette kendt som 
	 * 'time-of-check/time-of-use or 'TOCTOU attack'
	 * OG ikke nok med dette så brugte vi ikke clone() metoden på Date,
	 * fordi den er non-final, så den ville måske returnere en instans
	 * af en subklasse vi ikke har tillid til(Altså ved at extende
	 * java.util.Date og overwrite metoder med HAXXOR).
	 * Denne slags metoder kan lave et objekt af alle vores klasser,
	 * i en private static arraylist, og dermed have kontrol med hele vores applikation,
	 * for at undgå dette så bruger vi ikke clone() metoden på parameter der
	 * kan subclasses(dvs. ikke final).
	 * 
	 * Der er faktisk endnu et angreb der kan udføres, som jeg viser 
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
