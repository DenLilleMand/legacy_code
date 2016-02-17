package synchronizeAccessToSharedMutableData;

import java.util.concurrent.atomic.AtomicLong;

public class RunOgNoter {
	/**
	 * Synchronize access to shared mutable data
	 * 
	 * tl;dr;
	 * In summary, 
	 * When multiple threads share mutable data, each thread that 
	 * reads or writes the data must perform synchronization. Without synchronization, there
	 * is no guarantee that one thread's changes will be visible to another.
	 * The penalities for failing to synchronize shared mutable data are liveness and safety 
	 * failures. These failures are among the most difficult to debug. They can be intermittent and
	 *  time-dependant, and program behavior can vary radically from one VM to another. If you need only inter-thread communication,
	 *  and not mutal exclusion, the volatile modifier is an acceptable form of synchronization, but it 
	 *  can be tricky to use correctly.
	 * 
	 * ---------------
	 * Noter:
	 * s� der er et kode eksempel som ikke bruger synchronized i bogen,
	 * omkring side 284, som bare er et uendeligt loop som vi plejer at f�,
	 * n�r vi s�tter en boolean med true ind i et while(loop),
	 * hvad der er mere vildt er den klasse som hedder StopThread i den her pakke,
	 * �benbart s� selvom det er et uendeligt loop vi starter, s� k�rer den bare videre og rammer de metoder den skal,
	 * pga B�DE setteren og getteren er synchronized p� det boolean flag der styrer det. 
	 * hvis enten setteren eller getteren ikke havde v�ret synchronized havde det ikke fungeret - s� 
	 * det er vigtigt.
	 * 
	 * Der er en anden version af stopThread som m�ske er lidt bedre performance,
	 * m�ssigt, ikke specielt meget - men alts�, har lavet en klasse der hedder 
	 * StopThreadVersionTwo - den bruger bare et volatile field, hvilket jeg enlig
	 * tror at jeg er mere til end synchronized.
	 * 
	 * Men kode eksempel 1, viser hvorfor man skal passe lidt p� med volatile.
	 * Det er meningen at den skal give en et unikt serial nummer,
	 * ved at s�rge for at alle threads har den samme variable,
	 * problemet er bare at increment operatoren (++) ikke er atomic, s� den
	 * laver 2 operationer, f�rst s� l�ser den v�rdien og s� bagefter 
	 * skriver den til v�rdien, s� hvis der er en tr�d der l�ser variablen
	 * imens vi er igang med at skrive, s� f�r den den gamle v�rdi, og returnere det samme
	 * id, s� lige pludseligt er det ikke unikt mere,
	 * m�den at fixe dette p� er at fjerne volatile modifieren og s� tilf�je
	 * synchronized til metoden i stedet for.
	 * , men man kan ogs� lave en AtomicLong() som er en del af util.concurrent pakken,
	 * og det er en variable der g�r pr�cis som vi gerne vil have(endnu en grund til at kende
	 * de forskellige java biblioteker).
	 * Kode kommer til at se ud som i kode eksempel 2.
	 * 
	 * En god ide for at undg� dette er at man bare ikke skal dele mutable data,
	 * del immutable data, men ikke mutable - begr�ns mutable data til en
	 * tr�d.
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * Kode eksempel 1:
		 */
		//Broken - requires synchronization!
	
	
		private static volatile int nextSerialNumber = 0;
		
		public static int generateSerialNumber()
		{
			return nextSerialNumber++;
		}
	
		/**
		 * Kode eksempel 2:
		 */
		private static final AtomicLong nextSerialNum = new AtomicLong();
		
		public static long generateSerialNumber()
		{
			return nextSerialNum.getAndIncrement();
		}
		
		
	
	
	}

}
