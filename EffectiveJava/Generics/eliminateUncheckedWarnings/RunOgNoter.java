package eliminateUncheckedWarnings;

public class RunOgNoter 
{
	/**
	 * Eliminate unchecked warnings.
	 * 
	 * tl;dr;
	 * Brug kun @Supresswarning("unchecked");
	 * Hvis man har gennemtestet sit software for at være typesafe,
	 * og tilføj en kommentar der indikere hvorfor det er sikkert for andre programmørers
	 * skyld.
	 * Ignorer aldrig en warning, man skal ikke undervurderer
	 * et typesafe program.
	 * 
	 * Desuden så @SuppressWarning, hvis det bliver brugt, så brug det i det smalleste scope 
	 * muligt, måske på en enkelt linje kode inde i en metode.
	 * -----
	 * Noter:
	 * Den første sektion er hvordan compileren
	 * vil fortælle en om relativt lette warnings,
	 * f.eks  Set<Lark> exaltation = new HashSet();
	 * har selF brug for en type declaration efter new Hashset
	 * Og hvis man sætter en supress warning tag på sådan en, og andre warnings
	 * så vil man stadig få en ClassCastException
	 * , så det er vigtigt at man tester og beviser at ens kode er typesafe
	 * før man sætter et supressWarning tag på ens 
	 * ting, og vi ved jo allerede fra erfaring at supress warning virker bare dirty
	 * på en eller anden måde :).
	 * 
	 * Grunden til at man vil fjerne alle warnings i ens program er at man har lyst til
	 * at have et komplet type-safe program tydeligvis.
	 * 
	 * foreslår bla. at man tilføjer en comment og siger hvorfor
	 * det er i orden at gøre det, hver gang man bruger en @SuppressWarnings("unchecked") annotation.
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
