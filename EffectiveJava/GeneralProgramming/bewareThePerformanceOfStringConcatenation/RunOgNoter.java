package bewareThePerformanceOfStringConcatenation;

public class RunOgNoter 
{

	/**
	 * Beware the performance of string concatenation
	 * tl;dr;
	 * 
	 * 
	 * -----------------
	 * Noter:
	 * 
	 * 'Using the string concatenation operator
	 * repeatedly to concatenate n strings
	 * requires time quadratic in n' , det er en side effekt
	 * til det faktum at strings er immutable.
	 * n�r en String er concatenated s� er deres indhold kopieret.
	 * i kode eksempel 1 kan man se hvordan man ikke skal g�re :)
	 * Det her stykke kode er tydeligvis forf�rdeligt hvis m�ngden er items
	 * er rigtig stor, men personligt synes jeg ikke at et lille antal g�r det meget bedre,
	 * en StringBuilder ville jo sikre metoden p� l�ngere sigt. Hvilket
	 * er bogens n�ste foreslag:
	 * 
	 * 'To achive acceptable performance, use a StringBuilder in place of a String'
	 * i kode eksempel 2 kan man se denne.
	 * hvis man g�r dette 100 gange, alts� concatenater en String,
	 * s� er vores StringBuilder 85x hurtigere end 
	 * den f�rste. og det er effekten af at den ene er kvadratisk i dens udregning
	 * imens den anden er line�r.
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * Kode eksempel 1:
		 */
		public String statement()
		{
			String result = "";
			for(int i = 0; i <numItems(); i++)
			{
				result += lineForItem(i); // String concatenation
			}
			return result;
		}
		
		/**
		 * Kode eksempel 2:
		 */
		public String statement()
		{
			StringBuilder b = new StringBuilder(numItems() * LINE_WIDTH);
			for(int i = 0; i < numItems(); i++)
			{
				b.append(lineForItem());
			}
			return b.toString();
		}
	}

}
