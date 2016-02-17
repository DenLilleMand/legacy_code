package documentAllExceptionsThrownByEachMethod;

public class RunOgNoter 
{

	/**
	 * Document All Exceptions Thrown By Each Method
	 * tl;dr;
	 * Summary:
	 * 'Document every exception that can be thrown by each method
	 * that you write. This is true for unchecked as well as checked exceptions, 
	 * and for abstract as well as concrete methods. Provide individual throws clases for each checked
	 * exception and do not provide throws clauses for unchecked exceptions.
	 * If you fail to document the exceptions that your methods can throw, it will be difficult
	 * or impossible for others to make effective use of your classes and interfaces.'
	 * 
	 * ---------
	 * Noter:
	 * 'Always declare checked exceptions individually,
	 * and document precisely the conditions under which each one is thrown
	 * using the Javadoc @throws tag'
	 * 
	 * Men det er lige s� vigtigt at dokumentere
	 * alle de unchecked exceptions, unchecked exceptions
	 *  repr�sentere jo som regelt programmerings fejl, s� at hj�lpe 
	 *  programm�ren med hvilke fejl han m�ske kan lave, vil hj�lpe personen
	 *  til at forst� hvordan det skal implementeres.
	 *  
	 *  Derfor er en liste med veldokumenterede unchecked exceptions, i princippet 
	 *  en komplet liste over de 'preconditions' der skal v�re opfyldt for at komme igennem
	 *  metoden. og siden vi alligevel skal beskrive en metodes preconditions,
	 *  s� er det en smart m�de at g�re dette p�.
	 *  
	 *  Det er ogs� super vigtigt at interfaces dokumentere disse,
	 *  s�dan at alle de konkrete implementationer overholder denne kontrakt, 
	 *  ogs� bare give dem en chance for at pr�ve at overholde den.
	 *  
	 *  'Use the Javadoc @throws tag to document each unchecked exception that
	 *  a method can throw, but do not use the throws keyword to include unchecked exceptions
	 *  in the method declaration' - 
	 *  dette skal overholdes fordi det er vigtigt at programm�rerne
	 *  der bruger vores API skal v�re opm�rksom p� hvilke
	 *   exceptions der er Checked, og hvilke der er unchecked.
	 *   
	 *   Hvis en klasse har en masse metoder der smider den samme exception, s� er det
	 *   lovligt at dokumentere denne exception i klasse dokumentationen i stedet for.
	 *   
	 *   f.eks NullPointerException :"All methods in this class throw a NullPointerException if a null
	 *   object reference is passed in any parameter" - eller noget der mindre om det,
	 *   er lovligt.
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
