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
	 * når en String er concatenated så er deres indhold kopieret.
	 * i kode eksempel 1 kan man se hvordan man ikke skal gøre :)
	 * Det her stykke kode er tydeligvis forfærdeligt hvis mængden er items
	 * er rigtig stor, men personligt synes jeg ikke at et lille antal gør det meget bedre,
	 * en StringBuilder ville jo sikre metoden på længere sigt. Hvilket
	 * er bogens næste foreslag:
	 * 
	 * 'To achive acceptable performance, use a StringBuilder in place of a String'
	 * i kode eksempel 2 kan man se denne.
	 * hvis man gør dette 100 gange, altså concatenater en String,
	 * så er vores StringBuilder 85x hurtigere end 
	 * den første. og det er effekten af at den ene er kvadratisk i dens udregning
	 * imens den anden er lineær.
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
