package avoidCreatingUnnecessaryObjects;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Person1 {
	/**
	 * birthDate bliver tydeligvis aldrig instansieret, det er vel et problem,
	 * men birthDate er jo nok noget der skal besluttes af noget user input, 
	 * så det er lidt svært at fixe i et compact eksempel :)
	 *
	 *
	 * * --- følgende skal læses efter alt det andet:
		 * på side 46 bliver der bla. nævnt at man ikke skal være bange
		 * for lave et nyt objekt når man skal bruge et nyt objekt,
		 * at reuse objekter som ikke skal reuses straffer meget hårdere
		 * end det gør at lave 2 objekter når man ville kunne genbruge den ene,
		 * det bliver forklaret nærmere i item 39 i bogen hvordan det hænger sammen
		 * og hvorfor reuse af objekter kan give sikkerheds trusler. emnet 
		 * i item 39 er 'Defensive copying'. grunden til dette er at
		 * der er et par ting som er virkelig seriøse hvis man reuser objekter,
		 * og at reuse objekter handler "blot" om style & performance.
		 */
	 *
	 */
	private final Date birthDate;
	
	//other fields, methods, and constructor omitted
	
	/**
	 * The starting and ending dates of the baby boom.
	 */
	private static final Date BOOM_START;
	private static final Date BOOM_END;
	
	/**
	 * vi kan se her hvordan vi kun instansiere
	 * de her objekter 1 gang, istedet for Person klassen
	 * hvor de bliver instansieret hver gang man kører metoden.
	 * dette gør det relativt light-weight sammenlignet
	 * med det andet, specielt når objekter kommer op på en hvis 
	 * størrelse som Date og Calendar.
	 * på den her persons computer der skriver bogen, er 
	 * denne metode 250x hurtigere end det andet.
	 * Det giver selF sig selv at vi loader de her objekter
	 * lige så snart der er en reference til den her klasse,
	 * og det er jo unødvendigt hvis metoden isBabyBoomer() aldrig bliver
	 * kaldt, det kan man fixe ved at lave lazy initialization når
	 * isBabyBoomer bliver kaldt første gang, men dette er ikke
	 * altid specielt godt, det gør koden ekstra kompliceret, 
	 * og det giver ikke nogen rigtige udslag i performance om man laver
	 * et enkelt objekt mere eller mindre.
	 * Det er bla. også mere tydeligt at det er konstanter når man
	 * sætter dem i en statisk block og initailisere dem 1 gang.
	 * 
	 */
	static
	{
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(1946, Calendar.JANUARY,1,0,0,0);
		BOOM_START = gmtCal.getTime();
		gmtCal.set(1965, Calendar.JANUARY,1,0,0,0);
		BOOM_END = gmtCal.getTime();
		
	}
	
	public boolean isBabyBoomer()
	{
		return birthDate.compareTo(BOOM_START) >= 0 &&
				birthDate.compareTo(BOOM_END) < 0;
	}
}
