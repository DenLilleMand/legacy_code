package favorGenericTypes;

public class RunOgNoter 
{
	/**
	 * Favor generic types
	 * 
	 * tl;dr;
	 * 
	 * 
	 * ---------------
	 * Noter:
	 * Man kan �benbart lave sin egen
	 * Generic type, man kan sagtens bruge de
	 * generic typer fra JDK'en uden problemer, men det er
	 * da meget sjovt at vide hvordan man g�r.
	 * 
	 *  Der er et k�mpe kode eksempel p� side 147,
	 *  men som ikke er selve hvordan man implementere
	 *  generics, det er bare et kode eksempel
	 *  hvor bogen har t�nkt sig at redigere i det senere.
	 *  
	 *  N�r en klasse bliver lavet om til at kunne bruge generics
	 *  til dets fordel s� hedder det 'Generification'
	 *  
	 *  det kode eksempel der er p� side 148, hvor generics har taget fat
	 *  har vi tilf�jet i en klasse for sig der hedder Stack i den her pakke.
	 *  Men det er ikke et eksempel der kan compiles, pga. vi laver noget som vi ikke m�, som vidst nok
	 *  at lave et Generic Array som de n�ste par sider s� handler om...
	 *  
	 *  ehm, noget som er mere interessersant, s� er det f.eks at der er en klasse
	 *  som ser s�dan her ud:
	 *  class DelayQueue<E extends Delayed> implements BlockingQueue<E>;
	 *  
	 *  og hvad der er interessersant her er, at vi kun tillader
	 *  typer som er subtyper af Delayed, hvilket g�r at vi kan bruge
	 *  metoder fra Delayed super klassen som vi har lyst til.
	 *  selF uden at caste + f� en ClassCastException.
	 *  
	 *  
	 *   
	 *  
	 * 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{

	}

}
