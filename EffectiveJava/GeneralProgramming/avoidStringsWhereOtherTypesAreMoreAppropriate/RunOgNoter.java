package avoidStringsWhereOtherTypesAreMoreAppropriate;

public class RunOgNoter {

	/**
	 * Avoid strings where other types are more appropriate
	 * tl;dr;
	 * 'Avoid the natural tendency to represent objects as strings 
	 * when better data types exist or can be written. Used inappropriately, strings
	 * are more cumbersome, less flexible slower, and more error-prone than other types.
	 * Types for which strings are commonly misused include primitive types, enums and 
	 * aggregate types.'
	 * 
	 * -----------------
	 * Noter:
	 * 'Strings are poor substitues for other value types'
	 * hvor end ens Strings kommer fra, om det er en fil, et netv�rk
	 * eller what not, s� burde man altid overs�tte det til dets rigtige form
	 * i stedet for at lade det forblive i tekst form,
	 * udover hvis det er meningen det skal v�re i tekstform selvf�lgelig.
	 * 
	 * 'Strings are poor substitues for enum types'
	 * Enums make far better enumerated type constants than Strings,
	 * mentioned earlier in this book.
	 * 
	 * 'Strings are poor substitues for aggregate types'
	 * ved sku ikke lige med den her, l�s evt mere om den p� side
	 * 247(midt for)- har ikke haft om aggregate typer.
	 * 
	 * 
	 * 'Strings are poor substitues for capabilities'
	 * problemet de beskriver, s� vidt jeg forst�r er noget der hedder en
	 * ThreadLocal, som bruger Strings til at unikt identificere dem, 
	 * men dette betyder at hvis 2 af dem hedder det samme, s� deler de deres felter,
	 * s� dette er b�de en sikkerheds risiko p� den m�de at folk 
	 * med vilje kan kalde deres tr�d det samme som din, og vel bare d�rlig
	 * programmering generalt. I stedet burde man 
	 * bruge det som hedder en 'unforgeable key(some times called a 'capability
	 * og vi viser hvordan man laver s�dan en i kode eksempel 1''
	 * 
	 * og s� et par s�tninger senere knuser de fuldst�ndig den der l�sning i 
	 * eksempel 1 - pga der alligevel ikke er brug for dem,
	 * noget med top class containers nederst p� side 249 og �verst p� 250.
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * Kode eksempel 1:
		 */
		public class ThreadLocal
		{
			private ThreadLocal() {} // Noninstantiable - except for reflection i suppose?
			
			public static class Key // (Capability)
			{
				Key();
			}
			
			//Generates a unique, unforgeable key
			public static Key getKey()
			{
				return new Key();
			}
			
			public static void set(Key key, Object value);
			public static Object get(Key key);
		
		
		
		}
	}

}
