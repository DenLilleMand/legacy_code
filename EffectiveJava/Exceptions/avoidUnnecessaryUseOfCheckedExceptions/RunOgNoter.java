package avoidUnnecessaryUseOfCheckedExceptions;

public class RunOgNoter {
	/**
	 * Avoid unnecessary use of checked exceptions
	 * 
	 * tl;dr;
	 * 
	 * 
	 * 
	 * -------------
	 * Noter:
	 * Kan se i vores kode eksempel 1, at ingen 
	 * af disse 2 ting er specielt nyttige reaktioner p� exceptionen,
	 * s� n�r man skriver en checked exception s� skal man overveje
	 * hvordan Client koden har t�nkt sig at h�ndtere ens Exception,
	 * og hvis de ser ud som de g�r i det her kode eksempel,
	 * s� skal man overveje om det ikke er mere rigtigt at smide en unchecked
	 * exception.
	 * 
	 * Det vi skal kigge p� i vores kode eksempel 2, er hvordan
	 * man kan ende op med p�nere kode hvis man ikke bare smider en exception
	 * til vores client, men istedet giver en metode vi ogs� talte om tidligere,
	 * som sp�rg vores klasse om preconditions er opfyldt-
	 * 
	 * Eller det er ikke rigtig p�nnere, men det g�r vores API lidt 
	 * mere fleksible, det tillader ogs� at hvis clienten f�ler sig sikker nok
	 * til at bruge metoden, at han bare kan kalde den direkte uden at h�ndtere
	 * nogle exceptional cases i en if-else heller.
	 * 
	 * men alts�, det er jo den person der laver API'en som skal vurdere om
	 *  man skal belaste en client med exception handling, om det er det v�rd.
	 *  �g s� om det skal v�re en checked eller unchecked.
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
		}catch(theCheckedException e)
		{
			throw new AssertionError(); // Can't happen!
		}
		
		//How about this?
		
		}(TheCheckedException e)
		{
			e.printStackTrace(); //Oh well, we lost
			System.exit(1);
		
		}
		
		/**
		 * Kode eksempel 2:
		 */
		//Invocation with checked exception
		try
		{
			obj.action(args);
		}catch(TheCheckedException e)
		{
			//Handle exceptional condition
			//...
		}
		
		//to this...
		
		//Invocation with state-testing method and unchecked exception
		if(obj.actionPermitted(args))
		{
			obj.action(args);
		} else 
		{
			//Handle exceptional condition
		}

	}

}
