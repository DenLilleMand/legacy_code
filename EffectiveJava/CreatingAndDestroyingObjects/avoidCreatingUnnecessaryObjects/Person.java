package avoidCreatingUnnecessaryObjects;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
/**
 * Jeg laver en anden klasse som hedder
 * Person1  som har den kode man rigtigt skal bruge.
 * grunden til at dette er dårlig kode er skrevet
 * som blå skrift ovenover isBabyBoomer metoden.
 * @author DenLilleMand
 *
 */
public class Person {
	private final Date birthDate;
	
	//other fields,methods, and constructor omitted
	
	//DONT DO THIS!
	/**
	 * Because, the isBabyBoomer method unnessarily creates
	 * a new Calendar, TimeZone, and two Date instances each time it is
	 * invoked. The version that follows avoids this inefficiency with a 
	 * static initializer(klassen Person1)
	 * @return
	 */
	public boolean isBabyBoomer()
	{
		//Unnecessary allocation of expensive object
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		
		gmtCal.set(1946, Calendar.JANUARY,1,0,0,0);
		Date boomStart = gmtCal.getTime();
		gmtCal.set(1965, Calendar.JANUARY,1,0,0,0);
		Date boomEnd = gmtCal.getTime();
		return birthDate.compareTo(boomStart) >= 0 &&
				birthDate.compareTo(boomEnd) < 0;
	}
}
