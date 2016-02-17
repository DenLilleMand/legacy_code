package throwExceptionsAppropriateToTheAbstraction;

public class RunOgNoter {
	/**
	 * 
	 * tl;dr;
	 * If it isn't feasible to prevent or to handle
	 * exceptions from lower layers, use exception translation, unless the lower-level method happens to 
	 * guarantee that all of its exceptions are appropriate to the higher level. Chaining provides
	 * the best of both worlds: it allows you to throw an appropriate higher-level
	 * exception, while capturing the underlying cause for failure analysis.
	 * 
	 * ---------
	 * Noter:
	 * Hvilket betyder at hvis vi har en low level implementation,
	 * som s� smider en exception hele vejen op igennem implementationen
	 * og s� kommer den til udtryk i vores API, s� vil vi
	 * f� en af de her exceptions hvor den ikke giver nogen mening for den
	 * person der skriver client koden, lige pludselig giver vi dem
	 * noget information om hvordan det her er implementeret, hvilket vi ikke har lyst
	 * til at give.
	 * 
	 * For at fixe dette kan man se den Exception translation der foreg�r
	 * i kode eksempel 1.
	 * 
	 * i Kode eksempel 2, kan man se hvordan AbstractSequentialList, som er en skeletal implementation
	 * af List interface.  her kan man se hvordan
	 * det fungerer i de rigtige biblioteker, at overs�tte s�dan noget her.
	 * 
	 * Der er ogs� noget som hedder 'exception chaining' som kan bruges
	 * n�r en eller anden sidder og debugger det problem som for�rsagede en high-level exception.
	 * 
	 * det g�r man ved at passe low-level exceptionen til higher-level exceptionen, som s�
	 * giver en accessor metode i form af Throwable.getCause() for at fremskaffe lower-level exceptionen.
	 * 
	 * kode eksempel 3 viser dette.
	 * 
	 * neden under kan man se en exception chaining aware constructor,
	 *	de fleste exceptions har chaining aware constructors, og hvis de ikke har
	 * s� kan man s�tte Throwables initCause metode,
	 * ikke nok med at vi kan programmere vores adgang til en lower-level 
	 * exception, s� kan vi ogs� integrerer den ind i vores stacktrace hos den 
	 * Higher-Level exception.
	 * 
	 * kan ogs� bruge klasser som java.util.logging
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * Kode eksempel 1:
		 */
		//Exception translation
		try
		{
			//use lower-level abstraction to do our bidding
			...
		}catch(LowerLevelException e)
		{
			throw new HigherLevelException(...);
		}
	
	
		/**
		 * Kode eksempel 2:
		 */
		/**
		 * Returns the element at the specified position in this list.
		 * @throws IndexOutOfBoundsException if the index is out of range 
		 *({@code index < 0 || index >= size()}).
		 */
		public E get(int index)
		{
			ListIterator<E> i = listIterator(index);
			try
			{
				return i.next();
			}catch(NoSuchElementException e)
			{
				throw new IndexOutOfBoundsException("Index: " + index);
			}
		}
	
			/**
			 * Kode eksempel 3:
			 */
		//Exception chaining
		try
		{
			...//Use lower-level abstraction to do our bidding
		}catch(LowerLevelException cause)
		{
			throw new HigherLevelException(cause);
		}
	
		//Exception with chaining aware constructor:
		class HigherLevelException extends Exception
		{
			HigherLevelException(Throwable cause)
			{
				super(cause);
			}
		}
	
	}

}
