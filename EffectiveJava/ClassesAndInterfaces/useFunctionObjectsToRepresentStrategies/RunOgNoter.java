package useFunctionObjectsToRepresentStrategies;

import java.io.Serializable;
import java.util.Comparator;

public class RunOgNoter 
{
	/**
	 * tl;dr;
	 * A primary use of function pointers is to implement
	 * the Strategy pattern. To implement this pattern in Java, declare
	 * an interface for each concrete strategy.
	 * When a concrete strategy is used only once, it is
	 * typically declared and instantiated as an anonymous class(?-undersøg hvad en anonymous class er). When a concrete strategy is designed
	 * for repeated use, it is generally implemented as a private static member class and exported in a public
	 * static final field whose type is the strategy interface.
	 * --------
	 * Noter:
	 * Det her er faktisk et eksempel
	 * på strategy pattern og man kan finde et
	 * kode eksempel på dette nedenfor-
	 * kode eksempel 1 er hvad man kalder for en 'concrete strategy'
	 * for string sammenligning, vores klasse er stateless i den forstand
	 * at den ikke har nogen attribut felter, men blot metoder
	 * der tager objekter ind, sammenligner dem og så returnere den et resultat,
	 * det er jo sådan normalt at metoder man kalder på objekter oftest
	 * redigere 'det' objekts state, imens dette ikke er tilfældet her.
	 * 
	 * Og fordi dette objekt ikke har noget state, kan man lige så godt
	 * lave det til en singleton klasse faktisk.
	 * 
	 * Udover dette så taler bogen om dette stykke kode 
	 * som om den her comparator burde gives ind som parameter,
	 * så derfor giver vi alle comparators den samme interface,
	 * sådan at vi kan give forskellige comparators ind, iforhold
	 * til hvad vi har brug for... det er nok noget der giver
	 * mere mening når vores arkitektur ikke er
	 * fuldstændig håbløst.
	 * 
	 * vores Comparator interface er tydeligvis fra java.util pakken
	 * så den findes allerede, som vi godt vidste, men der er intet magisk ved den
	 * andet end den er generic i den forstand at man godt kan give den andet input
	 * end Strings.  
	 * 
	 * Hvilket bringer os hen til noget andet -
	 * og det er at 'concrete strategies' ofte er implementeret 
	 * med generiske klasser,
	 * 
	 * 
	 *  * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * kode eksempel 1:
		 * @author DenLilleMand
		 *
		 */
		class StringLengthComparator
		{
			public int compare(String s1, String s2)
			{
				return s1.length() - s2.length();
			}
		}
		/**
		 * kode eksempel 2:
		 */
		//strategy interface
		public interface Comparator <T>
		{
			public int compare(T t1, T t2);
		}
		
		/**
		 * Kode eksempel 3:
		 */
		//Exporting a concrete Strategy(exportere det i den forstand at vi kan Serialize den og sende den? ved ikke lige hvornår
		//jeg får brug for at sende en comparator over et netværk lol)
		class Host
		{
			private static class StrLenCmp implements Comparator<String>, Serializable
			{
				public int compare(String s1, String s2)
				{
					return s1.length() - s2.length();
				}
			}
			
			//returned comparator is serializable(Hvilket er underligt fordi den er statisk, men måske
			//har vi lavet en forkert fortolkning af om statiske ting kan blive Serialized.)
			public static final Comparator<String> STRING_LENGTH_COMPARATOR = new StrLenCmp();
			
			//...Bulk of class omitted
		}
	}

}
