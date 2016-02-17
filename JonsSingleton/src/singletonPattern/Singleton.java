package singletonPattern;

import java.io.Serializable;

/**
 * Man kan overveje hvor Lazy den her enligt initialisere, om det bliver kaldt i konstruk-
 * tøren eller statisk når man tilgår klassen er nok lidt lige meget.
 * Tror hvis man vil tale om Eager og Lazy er det bedst at sige at det mest lazy
 * ville være hvis man havde noget config kode, f.eks en database forbindelse,
 * så ligge det ind i en init() metode- og så når man gør noget der kræver en database
 * forbindelse så skaber man database forbindelsen i stedet for at have lavet den i 
 * konstruktøren.  bare en tanke.
 *
 */
public class Singleton implements Serializable{
	//Static, for metoden getSingleton() skal kunne instantiere et objekt
	//uden at klassen Singleton er instantieret endnu, derofor skal metoden være static
	private static Singleton instance;

	// privat konstruktør
	private Singleton() 
	{
		if(instance!=null){
			System.err.print("There can be one and only one!");
			throw new IllegalStateException();
		}
	}
	
	//Static metode så den kan kaldes uden at et objekt af typen Singleton er instantieret.
	//double checking.
	public static Singleton getSingleton() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if(instance == null)
				{
					instance = new Singleton();					
				}
			}
			System.out.println("Now we've created a new Singleton!");
			//lazy initialization
		}
		return instance;
	}

}
