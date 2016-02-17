package eliminateUncheckedWarnings;

public class RunOgNoter 
{
	/**
	 * Eliminate unchecked warnings.
	 * 
	 * tl;dr;
	 * Brug kun @Supresswarning("unchecked");
	 * Hvis man har gennemtestet sit software for at v�re typesafe,
	 * og tilf�j en kommentar der indikere hvorfor det er sikkert for andre programm�rers
	 * skyld.
	 * Ignorer aldrig en warning, man skal ikke undervurderer
	 * et typesafe program.
	 * 
	 * Desuden s� @SuppressWarning, hvis det bliver brugt, s� brug det i det smalleste scope 
	 * muligt, m�ske p� en enkelt linje kode inde i en metode.
	 * -----
	 * Noter:
	 * Den f�rste sektion er hvordan compileren
	 * vil fort�lle en om relativt lette warnings,
	 * f.eks  Set<Lark> exaltation = new HashSet();
	 * har selF brug for en type declaration efter new Hashset
	 * Og hvis man s�tter en supress warning tag p� s�dan en, og andre warnings
	 * s� vil man stadig f� en ClassCastException
	 * , s� det er vigtigt at man tester og beviser at ens kode er typesafe
	 * f�r man s�tter et supressWarning tag p� ens 
	 * ting, og vi ved jo allerede fra erfaring at supress warning virker bare dirty
	 * p� en eller anden m�de :).
	 * 
	 * Grunden til at man vil fjerne alle warnings i ens program er at man har lyst til
	 * at have et komplet type-safe program tydeligvis.
	 * 
	 * foresl�r bla. at man tilf�jer en comment og siger hvorfor
	 * det er i orden at g�re det, hver gang man bruger en @SuppressWarnings("unchecked") annotation.
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
