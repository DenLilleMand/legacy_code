package favorGenericMethods;

import java.util.Arrays;

public class RunOgNoter 
{
	/**
	 * 
	 * tl;dr;
	 * l�s kode eksempel 3 i denne klasse- det virker til at det er der jeg har lavet mine mest fundamentale overvejelser.
	 * 
	 * generic methods, like generic types, are safer and easier to use
	 * than methods that require their clients to cast input parameters and return values.
	 * Like types, you should make sure that your new methods can be used without casts, which will
	 * often mean making them generic. And like types, you should
	 * generify your existing methods to make life easier for new users without breaking existing clients.
	 * (Og igen tror jeg en af de mest fundamentale fordele er at man f�r fejlen at vide ved compile time, 
	 * i stedet for ved runtime. )
	 * --------------------
	 * Noter:
	 * Static utility methods, er dem der er mest oplagte til at blive 'generificated'
	 * dvs. at alle Sort og binarySearch metoder i Collections er blevet dette.
	 *  Og det vil ogs� sige, som jeg havde regnet ud
	 * lidt tidligere, at vores sort metode i Oikos projektet, og nogle af de andre utility metoder 
	 * burde v�re generic, og det tror jeg faktisk Jon allerede har lavet, hvertfald en af sort
	 * metoderne.  - men vores sort metode har vi jo ikke lavet til en statisk public utility metode,
	 * der ikke refererer fields, men blot tager nogle parametre, returnere et resultat udfra de parametre.
	 * Jon har endda ogs� f�et metoden til at extende entity, jeg tror at han har l�st EffectiveJava haha :)
	 * Ellers er det rigtig godt t�nkt. Men der er noget jeg ikke helt forst�r, i hans implementation
	 * pga Entity som bliver extended indeholder en protected id, imens vi har private id's nede i LogEntry
	 * og Customer
	 * 
	 *  Okay, s� tydeligvis s� er det igen nogle metoder, uden parametre, og det er vel d�rligt,
	 *  p� grund af de samme ting der gjore Collections farlige at bruge uden parametre,  at folk
	 *  kan proppe ind hvad de har lyst til, og vi ingen kontrol har med det, det er ALTID bedre at fange ting
	 *  ved compile time, i stedet for ved runtime. 
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
		 * (Jeg regner med at nogle af de her eksempler giver
		 * mere mening n�r vi kaster os over den n�ste bog som har noget
		 * at g�re med at sorte/collections osv.)
		 */
		//Uses raw types - unacceptable! 
		public static Set union(Set s1, Set s2)
		{
			Set result = new HashSet(s1);
			result.addAll(s2);
			return result;
		}
		
		/**
		 * kode eksempel 2:
		 */
		//Generic method
		public static <E> Set<E> union(Set<E> s1, Set<E> s2)
		{
			Set<E> result = new HashSet<E>(s1);
			result.addAll(s2);
			return result;
		}
		
		/**
		 * kode eksempel 3:
		 *(union() er de metoder vist ovenfor i 2 varianter,
		 *Som det her kode stykke viser hvor godt ser ud, uden 
		 *warnings eller noget som helst n�r man bruger den Generic version)�
		 *union concater jo bare listerne, og s� hvis man havde duplicates, s� ville de ikke
		 *blive printet ud tror jeg, p� grund af det er HashSets-- men det er vel irrelevant.
		 *anyway - hvis vi havde brugt den �verste s� ville vi kunne have givet den Sets af alt ind, nu
		 *virker den union som k�rer med generics ved compileTime effektivt som en Set<String>, og ved runtime
		 *virker den effektivt som en Object   der hvor E plejede at st�, og dette er ogs� grunden  til at generics ikke er kompatible
		 *med primitive typer som int og double men man skal istedet bruge deres Boxed typer(hvilket man er blevet frar�det at bruge
		 *hvis man kan bruge de andre, s� m�ske er der et tradeoff her som ikke er udforsket).
		 *En trist ting ved denne metode er desuden at den KUN tager imod String, pga. vi bruger E,  men hvis vi havde brugt
		 *den bounded wildcard type <?> s� ville vi kunne have haft nogle andre slags typer(Men jeg kan ikke helt huske hvad det var tidligere
		 *der var med <?> som gjore at vi ikke fik en warning eller en ClassCastException, s� n�r der er internet, 
		 *s� check lige forskellen p� E og ? i regler om typesafety, fordi lige nu er den eneste forskel at <E> kan kun v�re 1 object type, og
		 *at <?> kan tage imod hvad som helst umiddelbart.)
		 *En anden ting med <E> som jeg undrede og over tidligere var hvordan man fandt ud af hvad <E> var for en type,
		 *og det g�r compileren �benbart automatisk ved at kigge p� metode declarationerne.
		 *Det at den finder ud af det hedder type 'inference'
		 *
		 *  
		 */
		
		//Simple program to exercise generic method
		Set<String> guys = new HashSet<String>(Arrays.asList("Tom", "Dick","Harry"));
		Set<String> stooges = new HashSet<String>(Arrays.asList("Larry", "Moe", "Curly"));
		Set<String> aflCio = union(guys, stooges);
		System.out.println(aflCio);
		
		/**
		 * kode eksempel 4:
		 */
		//Parameterized type instance creation with constructor
		Map<String, List<String>> anagrams = new HashMap<String, List<String>>();
		
		//Generic static factory method 
		public static <K,V> HashMap<K,V> newHashMap()
		{
			return new HashMap<K,V>();
		}
		
		//med denne factory method kan vi f� en construction
		//til at s�dan her ud:
		
		Map<String, List<String>> anagrams = newHashMap();
		/**
		 * og igen bliver der n�vnt at det ville v�re rart hvis java selv lavede denne
		 * type af 'type inference', men som det er lige nu
		 * s� g�r den det ikke p� constructors, men den g�r det p� metoder.
		 * Et relateret pattern er 'generic singleton factory' 
		 * dette pattern kan der ses et eksempel for nedenunder
		 * (Det kunne godt ligne lidt det stykke kode man skriver n�r man laver actionlisteners
		 * osv.)
		 */
		
		/**
		 * kode eksempel 5:
		 */
		//Generic singleton factory pattern
		private static UnaryFunction<Object> IDENTITY_FUNCTION = new UnaryFunction<Object>()
		{
			new UnaryFunction<Object>()
			{
				public Object apply(Object arg)
				{
					return arg;
				}
			}
		}
		/**
		 * kode eksempel 6:
		 */
		//IDENTITY_FUNCTION is stateless and its type parameter
		//is unbounded so it's safe to share one instance across all types.
		@SuppressWarnings("unchecked")
		public static <T> UnaryFunction<T> identityFunction()
		{
			return (UnaryFunction<T>) IDENTITY_FUNCTION;
		}
		
		
		/**
		 * Kode eksempel 7:
		 * (det her hedder en 'recursive type bound', p�
		 * den m�de at det jo n�sten kun er de slags typer, der
		 * kan sammenlignes med hinanden, alts� String med String osv.
		 * men man kan hvertfald se hvordan Comparable bruger generics
		 * s� for at opsummere s� er String.Compareable<String>, Integer.Compareable<Integer> osv.)
		 * 
		 */
		public interface Comparable<T>
		{
			int compareTo(T o);
		}
		
		/**
		 * kode eksempel 8,
		 * kan se 'recursive type bounds' i aktion.
		 */
		public static <T extends Comparable<T>> T max(List<T> list)
		{
			Iterator <T> i = list.iterator();
			T result = i.next();
			while(i.hasNext())
			{
				T t = i.next();
				if(t.compareTo(result) > 0)
					result = t;
			}
			return result;
		}
		
		
		
		
	}

}
