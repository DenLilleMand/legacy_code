package preferPrimitiveTypesToBoxedPrimitives;

public class RunOgNoter {
	/**
	 * Prefer primitive types to boxed primitives
	 * tl;dr;
	 * Use primitive in preference to boxed primitivies whenever you
	 * have the choice. Primitivie types are simpler and faster. If you must
	 *  use boxed primitives be careful! 'Autoboxing reduces the verbosity, but not the danger
	 *  of using boxed primitives.' when you program compares two boxed primitives 
	 *  with the == operator, it does an identity comparison, which is almost certainly NOT what you
	 *  want. When your program does mixed-type computations involving boxed and unboxed primitives 
	 *  , it does unboxing and when your program does unboxing, it can throw a nullPointerException. Finally, when
	 *  your program boxes primitive values, it can result in costly and unnecessary object creations.
	 *  
	 * 
	 * -----------------
	 * Noter:
	 * Vi har jo set det her i aktion, i et af de tidligere
	 * eksempler, så vidt jeg husker er boxed primitives 240x langsommere
	 * end unboxed, så det er tydeligvis en god grund i sig selv,
	 * men mon ikke vi får et eksempel på hvornår det er i orden at bruge
	 * boxed primitives.
	 * Der var noget som blev tilføjet der hedder auto-boxing og auto-unboxing,
	 * hvilket gør linjerne lidt sværere at se nu, end det var før.
	 * Men man skal stadig skelne.
	 * 
	 * 'There are three major differences between primitives and
	 * boxed primitives. First  primitives have only their values,
	 *  whereas boxed primitives have identities distinct from their values.
	 *  In other words, two boxed primitive instances can have the same value 
	 *  and different identities. Second, primitive types have only
	 *   fully functional values, whereas each boxed primitive type has one nonfunctional
	 *   value, which is null, in addition to all of the functional values of its 
	 *   corresponding primitive type. Last, primitives are generally more time- and space- efficient 
	 *   than boxed primitives. All three of these differences can get you into real trouble if you aren't
	 *   careful.
	 *   
	 *   Prøv at kig i kode eksempel 1, faktisk et meget interessersant bug,
	 * 	anyway, det hele kører fint i det her eksempel og gør som det skal,
	 * men fordi vi bruger boxed primitivies, så er det objekter vi sammenligner,
	 * og ikke de primitive int værdier, dvs. at når vi kommer til '==' operatoren,
	 * så sammenligner vi lige pludselig 2 objekter i stedet for 2 primitives.
	 * 
	 * dvs.  'Applying the == operator to boxed primitivies is almost always wrong.'
	 * 
	 * i kode eksempel 2 - ser vi hvordan man kunne fixe dette.
	 * Og man ville selF også kunne fixe dette ved at lade
	 * være med at bruge boxed primitives til at starte med, men altså,
	 * når man er i situationen er det vel okay.
	 * 
	 * Der er et interessersant kode eksempel i den her pakke i en klasse for sig der kan kører,
	 *  det er en boxed-primitive Integer der ikke er blevet initialiseret, men prøvet sammenlignet med en int
	 * 'When you mix primitives and boxed primitives in a single operation, the boxed primitive is auto-unboxed, 
	 * and this case is no exception.'
	 * 
	 * men det der sker er at java prøver at unbox en null boxed-primitive,
	 * hvilket smider en nullPointerException,
	 * og dette kan jo ske hvor some helst i ens program, så er der
	 * virkelig en grund til at implementere disse muligheder for fejl i ens program?
	 * 
	 * i kode eksempel 3, kan man se det kode eksempel som vi blev
	 * vist tidligere i bogen der kørte 240x langsommere pga. den blev ved med at
	 * boxe og unboxe long, fixet er selF bare at lave en long deroppe i stedet for.
	 * 
	 * anyway, fejlne i alle 3 programmer er at programmører var ligeglade med om
	 * primitiver var boxed eller unboxed, hvilket man selF ikke skal være.
	 * 
	 * men hvornår skal man så bruge boxed primitivies? fordi de har et legitimt brug,
	 * 
	 * det første brug er til 'elements, keys and values' i Collections, fordi man ikke
	 * man proppe primitives ind i collections.
	 * 
	 * 'you must use boxed primitives as 
	 * type parameters in parameterized types, because the language does not
	 * permit you to use primitivies. forexample you cannot
	 *  declare a variable to be of type ThreadLocal<int>, so you must use ThreadLocal<Integer> instead.
	 *  Finally you must use boxed primitivies when making reflective method invocations.
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
		//Broken comparator - can you spot the flaw?
		Comparator<Integer> naturalOrder = new Comparator<Integer>()
		{
			public int compare(Integer first, Integer second)
			{
				return first < second ? -1 :(first == second? 0 : 1);
			}
		}
		
		/**
		 * Kode eksempel 2:
		 */
		Comparator<Integer> naturalOrder = new Comparator<Integer>()
		{
			public int compare(Integer first, Integer second)
			{
				int f = first; // Auto-unboxing
				int s = second; //Auto-unboxing
				return f < s ? -1 : (f == s ? 0 : 1); // No unboxing
			}
		}
		
		/**
		 * Kode eksempel 3:
		 * (Det her kode eksempel er blevet genbrugt fra tidligere i bogen.
		 * )
		 */
		
		//Hideously slow program !  Can you spot the object creation?
		Long sum = 0L;
		for(long = i = 0; i < Integer.MAX_VALUE; i++)
		{
			sum += i;
		}
		System.out.println(sum);
		
		
		
	}

}
