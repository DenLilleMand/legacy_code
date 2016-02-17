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
	 * Man kan åbenbart lave sin egen
	 * Generic type, man kan sagtens bruge de
	 * generic typer fra JDK'en uden problemer, men det er
	 * da meget sjovt at vide hvordan man gør.
	 * 
	 *  Der er et kæmpe kode eksempel på side 147,
	 *  men som ikke er selve hvordan man implementere
	 *  generics, det er bare et kode eksempel
	 *  hvor bogen har tænkt sig at redigere i det senere.
	 *  
	 *  Når en klasse bliver lavet om til at kunne bruge generics
	 *  til dets fordel så hedder det 'Generification'
	 *  
	 *  det kode eksempel der er på side 148, hvor generics har taget fat
	 *  har vi tilføjet i en klasse for sig der hedder Stack i den her pakke.
	 *  Men det er ikke et eksempel der kan compiles, pga. vi laver noget som vi ikke må, som vidst nok
	 *  at lave et Generic Array som de næste par sider så handler om...
	 *  
	 *  ehm, noget som er mere interessersant, så er det f.eks at der er en klasse
	 *  som ser sådan her ud:
	 *  class DelayQueue<E extends Delayed> implements BlockingQueue<E>;
	 *  
	 *  og hvad der er interessersant her er, at vi kun tillader
	 *  typer som er subtyper af Delayed, hvilket gør at vi kan bruge
	 *  metoder fra Delayed super klassen som vi har lyst til.
	 *  selF uden at caste + få en ClassCastException.
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
