package includeFailureCaptureInformationInDetailMessages;

public class RunOgNoter 
{

	/**
	 * 
	 * tl;dr;
	 * in summary:
	 * 'As suggested, it may be appropriate for an exception to provide 
	 * accessor methods for its failure-capture information(lowerbound,
	 * upperbound, and index, but it is more important to provide
	 * such accessor methods on checked exceptions than on unchecked exceptions,
	 *  because the failure-capture information can be useful in recovering from the failure
	 *  . It is rare (although not) inconceivable that a programmer might want 
	 *  programmatic access to the details of an unchecked exception. Even for unchecked exceptions.
	 *  How ever, it seems advisable to provide these accessors on general principle.'
	 * 
	 * ---------
	 * Noter:
	 * hmm - åbenbart er det også normalt 
	 * at når man extender en exception,
	 * og ændre dens ting, at man også skriver 
	 * ting som værdierne på forskellige parametre 
	 * da det gik galt.
	 * f.eks kunne en IndexOutOfBoundsException indeholde
	 * lower bound, upper bound og den index værdi der fejlede
	 * at ligge i mellem disse.
	 * 
	 * Det er dog ikke godt at skrive alt for meget text, 
	 * folk bliver jo bragt til det linje nummer hvor det gik galt,
	 * og hvad der smed exceptionen, så der er ikke nogen grund itl at skrive en 
	 * roman.
	 * 
	 * kode eksempel 1 viser hvordan ArrayIndexOutOfBoundsExceptions
	 * konstruktør måske burde have set ud. Men den fulgte ikke dette Idiom,
	 * det gør den ikke dårlig ubrugelig, men når vi skal bygge vores egne exceptions,
	 * er dette noget man kan gå efter.
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
		/**
		 * Construct an IndexOutOfBoundsExcepion
		 *
		 *@param lowerbound the lowest legal index value.
		 *@param upperbound the highest legal index value plus one.
		 *@param index the actual index value
		 */
		public IndexOutOfBoundsException(int lowerBound, int upperBound, int index)
		{
			//Generate a detail message that captures the failure
			super("Lower bound: " + lowerBound + ", Upper bound: " + upperBound + ", Index: " + index);
			//Save failure information for programmatic access
			this.lowerBound = lowerBound;
			this.upperBound = upperBound;
			this.index = index;
		}
	}

}
