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
	 * af disse 2 ting er specielt nyttige reaktioner på exceptionen,
	 * så når man skriver en checked exception så skal man overveje
	 * hvordan Client koden har tænkt sig at håndtere ens Exception,
	 * og hvis de ser ud som de gør i det her kode eksempel,
	 * så skal man overveje om det ikke er mere rigtigt at smide en unchecked
	 * exception.
	 * 
	 * Det vi skal kigge på i vores kode eksempel 2, er hvordan
	 * man kan ende op med pænere kode hvis man ikke bare smider en exception
	 * til vores client, men istedet giver en metode vi også talte om tidligere,
	 * som spørg vores klasse om preconditions er opfyldt-
	 * 
	 * Eller det er ikke rigtig pænnere, men det gør vores API lidt 
	 * mere fleksible, det tillader også at hvis clienten føler sig sikker nok
	 * til at bruge metoden, at han bare kan kalde den direkte uden at håndtere
	 * nogle exceptional cases i en if-else heller.
	 * 
	 * men altså, det er jo den person der laver API'en som skal vurdere om
	 *  man skal belaste en client med exception handling, om det er det værd.
	 *  ög så om det skal være en checked eller unchecked.
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
