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
	 * eksempel 1, viser skræk eksemplet, så vidt
	 * vi kan se så bliver exceptionen ignoreret,
	 * vi ved ikke hvor det gik galt osv. osv.
	 * 
	 * Kode eksempel 1 er faktisk et forsøg
	 * på at efterligne et standard for-each loop,
	 * for(Mountain m : range)
	 * {
	 * 	m.climb();
	 * }
	 * 
	 * den med exception er doublet så langsomt,
	 * ca, det er svært at læse hvad den gør,
	 * et while() loop der bliver brydt af en exception når
	 * det når slutningen af arrayet[] er ikke helt til at forstå
	 * ved første øjekast.
	 * 
	 * Og det er jo ikke en exceptionel condition, det her virker til at misbruge
	 * Exceptions til alment brug, hvilket de ikke er optimeret eller designet til,
	 * udover dette er det heller ikke garanteret at fungere!.
	 * 
	 * Arrayet kunne også bugge og smide en anden slags exception, hvilket ville
	 * ødelægge det hele, hvilket aldrig ville ske i en almindelig for-each,
	 * 
	 *  så moralen i historien lyder:'Exceptions are, as their names implies, to
	 *  be used only for exceptional conditions; they should never be used for ordinary
	 *  control flow.
	 *  
	 *  Det er bedre at bruge de standard måder at gøre tingne på, igen fordi man måske
	 *  får noget ud af det i senere implementationer og releases, og samtidigt kan andre folk
	 *  læse ens kode.
	 *  
	 *  (OBS!) 'This principe also has implications for API design. A well-designed API
	 *  must not force its clients to use exceptions for ordinary control flow' hvis man har en metode
	 *  der kræver at nogle preconditions er opfyldt for at kunne gøre sit arbejde,
	 *   er det alment at også give en metode der tjekker på om dette
	 *   state er opfyldt, ligesom list.isEmpty() i kombination med en
	 *   metode som list.remove(). mere om dette nederst på side 265.
	 *   Der er desuden et eksempel på hvis f.eks Iterator ikke havde
	 *   sin  hasNext() metode, hvordan kode ville se ud. i kode 
	 *   eksempel 2.
	 *   
	 * Midt for på side 266 står der noget om hvordan man laver sådan en metode
	 * som  list.isEmpty(), det virker til at der er 2 måder at gøre det på, umiddelbart -
	 * og det har noget at gøre med ThreadSynchronization der gør det besværligt,
	 * måske er det lettere at læse denne paragraph som er ca midt-for på siden,
	 * efter man har læst conccurency sektionen i denne bog.
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
