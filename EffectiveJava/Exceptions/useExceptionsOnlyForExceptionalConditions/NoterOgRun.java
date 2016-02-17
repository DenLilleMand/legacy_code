package useExceptionsOnlyForExceptionalConditions;

public class NoterOgRun {
	/**
	 * 
	 * tl;dr;
	 * In summary:
	 * 'Exceptions are designed for use in exception conditions.
	 * Don't use them for ordinary control flow, and don't write API's that force
	 * others to do so.'
	 * 
	 * ---------
	 * Noter:
	 * eksempel 1, viser skr�k eksemplet, s� vidt
	 * vi kan se s� bliver exceptionen ignoreret,
	 * vi ved ikke hvor det gik galt osv. osv.
	 * 
	 * Kode eksempel 1 er faktisk et fors�g
	 * p� at efterligne et standard for-each loop,
	 * for(Mountain m : range)
	 * {
	 * 	m.climb();
	 * }
	 * 
	 * den med exception er doublet s� langsomt,
	 * ca, det er sv�rt at l�se hvad den g�r,
	 * et while() loop der bliver brydt af en exception n�r
	 * det n�r slutningen af arrayet[] er ikke helt til at forst�
	 * ved f�rste �jekast.
	 * 
	 * Og det er jo ikke en exceptionel condition, det her virker til at misbruge
	 * Exceptions til alment brug, hvilket de ikke er optimeret eller designet til,
	 * udover dette er det heller ikke garanteret at fungere!.
	 * 
	 * Arrayet kunne ogs� bugge og smide en anden slags exception, hvilket ville
	 * �del�gge det hele, hvilket aldrig ville ske i en almindelig for-each,
	 * 
	 *  s� moralen i historien lyder:'Exceptions are, as their names implies, to
	 *  be used only for exceptional conditions; they should never be used for ordinary
	 *  control flow.
	 *  
	 *  Det er bedre at bruge de standard m�der at g�re tingne p�, igen fordi man m�ske
	 *  f�r noget ud af det i senere implementationer og releases, og samtidigt kan andre folk
	 *  l�se ens kode.
	 *  
	 *  (OBS!) 'This principe also has implications for API design. A well-designed API
	 *  must not force its clients to use exceptions for ordinary control flow' hvis man har en metode
	 *  der kr�ver at nogle preconditions er opfyldt for at kunne g�re sit arbejde,
	 *   er det alment at ogs� give en metode der tjekker p� om dette
	 *   state er opfyldt, ligesom list.isEmpty() i kombination med en
	 *   metode som list.remove(). mere om dette nederst p� side 265.
	 *   Der er desuden et eksempel p� hvis f.eks Iterator ikke havde
	 *   sin  hasNext() metode, hvordan kode ville se ud. i kode 
	 *   eksempel 2.
	 *   
	 * Midt for p� side 266 st�r der noget om hvordan man laver s�dan en metode
	 * som  list.isEmpty(), det virker til at der er 2 m�der at g�re det p�, umiddelbart -
	 * og det har noget at g�re med ThreadSynchronization der g�r det besv�rligt,
	 * m�ske er det lettere at l�se denne paragraph som er ca midt-for p� siden,
	 * efter man har l�st conccurency sektionen i denne bog.
	 * 
	 * 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * Kode eksempel 1:
		 */
		//Horrible abuse of exceptions. Don't ever do this!
		try
		{
			int i = 0;
			while(true)
			{
				range[i++].climb();
			}
		}catch(Exception e)
		{
			
		}
		
		/**
		 * Kode eksempel 2:
		 */
		//standard:
		for(Iterator<Foo> i = collection.iterator(); i.hasNext();)
		{
			Foo foo = i.next();
			...
		}
		//Do not use this hideous code for iteration over a collection!
		try
		{
			Iterator<Foo> i  = collection.iterator();
			while(true)
			{
				Foo foo = i.next();
				...
			}
		}catch(NoSuchElementException e) {}
	
	
	}

}
