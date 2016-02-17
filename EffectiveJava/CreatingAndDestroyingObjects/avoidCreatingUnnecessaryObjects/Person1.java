package avoidCreatingUnnecessaryObjects;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Person1 {
	/**
	 * birthDate bliver tydeligvis aldrig instansieret, det er vel et problem,
	 * men birthDate er jo nok noget der skal besluttes af noget user input, 
	 * s� det er lidt sv�rt at fixe i et compact eksempel :)
	 *
	 *
	 * * --- f�lgende skal l�ses efter alt det andet:
		 * p� side 46 bliver der bla. n�vnt at man ikke skal v�re bange
		 * for lave et nyt objekt n�r man skal bruge et nyt objekt,
		 * at reuse objekter som ikke skal reuses straffer meget h�rdere
		 * end det g�r at lave 2 objekter n�r man ville kunne genbruge den ene,
		 * det bliver forklaret n�rmere i item 39 i bogen hvordan det h�nger sammen
		 * og hvorfor reuse af objekter kan give sikkerheds trusler. emnet 
		 * i item 39 er 'Defensive copying'. grunden til dette er at
		 * der er et par ting som er virkelig seri�se hvis man reuser objekter,
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
	 * hvor de bliver instansieret hver gang man k�rer metoden.
	 * dette g�r det relativt light-weight sammenlignet
	 * med det andet, specielt n�r objekter kommer op p� en hvis 
	 * st�rrelse som Date og Calendar.
	 * p� den her persons computer der skriver bogen, er 
	 * denne metode 250x hurtigere end det andet.
	 * Det giver selF sig selv at vi loader de her objekter
	 * lige s� snart der er en reference til den her klasse,
	 * og det er jo un�dvendigt hvis metoden isBabyBoomer() aldrig bliver
	 * kaldt, det kan man fixe ved at lave lazy initialization n�r
	 * isBabyBoomer bliver kaldt f�rste gang, men dette er ikke
	 * altid specielt godt, det g�r koden ekstra kompliceret, 
	 * og det giver ikke nogen rigtige udslag i performance om man laver
	 * et enkelt objekt mere eller mindre.
	 * Det er bla. ogs� mere tydeligt at det er konstanter n�r man
	 * s�tter dem i en statisk block og initailisere dem 1 gang.
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
