package preferListsToArrays;

import java.util.Arrays;
import java.util.List;

public class RunOgNoter 
{
	/**
	 * Prefer lists to arrays
	 * 
	 * tl;dr
	 * 
	 * -------
	 * Noter:
	 * Arrays er 'covariant' 
	 * hvilket betyder at hvis Sub er en subklasse til
	 * Super, s� er Sub[] en subtype til Super[],
	 * Generics er i konstrast til dette p� den m�de at
	 * Type1 og Type2, List<Type1> er ikke en subtype eller
	 * en super type af List<Type2>. og det er fordi
	 * Arrays er �delagte, ikke Generics.
	 * 
	 * der er 2 kode eksempler nedenfor - som viser hvorfor
	 * Lists er bedre end Arrays.
	 * og det er i bund og grund fordi det giver en compiletime
	 * error istedet for en runtime error.
	 * 
	 * 
	 * Den anden store forskel p� Arrays og Generics er at
	 * arrays er 'reified' hvor Generics er det som hedder 'erasure'
	 * det betyder at de kun bibeholder deres type forbehold ved compile time,
	 * imens de glemmer/sletter deres forbehold ved runtime,
	 * imens 'reified' selF er det modsatte, at arrays f�rst tjekker deres typer ved
	 * runtime. Vores sidste sektion Dont use unchDont use raw types in new code,
	 * er v�rd at l�se iforhold til dette, der kan man se nogle kode eksempler der viser
	 * hvordan dette fungerer.
	 * 'Erasure' er blandt andet hvad der tillader legacy kode at k�rer
	 * uden brug af Generics.
	 * 
	 * pga. disse fundamentalle forskelle oprerer
	 * Arrays og Generics ikke specielt godt,
	 * det er f.eks ulovligt at lave et Array[] af en
	 * generic type, en parametered type, eller en type parameter.
	 * 'None of these array creation expressions are legal: new
	 * List<E>[], new List<String>[], new E[]. All will result in generic
	 * 'array creation errors' at compile time'
	 * dette er ikke tilladt pga. det ikke er typesafe,
	 * siger m�ske lidt mere at l�se det igen p� side 142 aller nederst :))
	 * 
	 * har tilf�jet et konkret kode eksempel der viser hvorfor
	 * det ikke er lovligt. i kode eksempel 3.
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * Kode eksempel 1:
		 */
		//This code fragment is legal(compiler wise):
		//Fails at runtime!
		Object[] objectArray = new Long[1];
		objectArray[0] = "i don't fit in"; // throws ArrayStoreException
	
		/**
		 * Kode eksempel 2:
		 */
		//but this one is not:
		//Won't compile!
		List<Object> ol = new ArrayList<Long>(); // Incompatible types
		ol.add("I don't fit in");
		
		
		/**
		 * Kode eksempel 3:
		 *L�g m�rke til at dette er arrays 
		 *med lister inde i sig, det er langt lettere
		 *at bare kigge p� koden og se hvad der sker
		 *iforhold til at f�lge den forklaring p� side 143.
		 *Man kan godt se at det vil g� galt, og det er derfor  
		 *  Generics giver en Compiletime error,
		 *  imens hvis vi ikke ville have haft generics ville vi bare
		 *  have f�et en Class cast Exception af en slags.
		 *  
		 *  Typer som E, List<E>, og List<String> er teknisk kendt som
		 *  non-reifiable typer. Og det er en type hvor deres
		 *  run-time representation indeholder mindre information end dets
		 *  compile-time representation. Den eneste parametered type som
		 *	som er reifiable er 'bounded wildcard types'
		 *	som List<?> og Map<?,?>, det er lovligt, selvom ikke ofte brugbart
		 *	at lave arrays med unbounded wildcard types.
		 *	
		 *    
		 */
		//Why generic array creation is illegal - won't compile!
		List<String>[] stringList = new List<String>[1];
		List<Integer> intList = Arrays.asList(42);
		Object[] objects = stringLists;
		object[0] = intLists;
		String s = stringLists[0].get(0);
	
	
	}

}
