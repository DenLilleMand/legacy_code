package dontUseRawTypesInNewCode;

public class RunOgNoter {
/**
 * en enkelt tanke jeg fik selvstændigt af det her, er at det selvfølgelig er Generics der også bliver brugt
 * i SwingWorker til at specificere return typen på done() og publish() - og den brug af generics kan jeg entlig 
 * godt lide, SwingWorker klassen er jo bare et API, vi har jo ikke adgang til den interne implementation,
 * så en måde at specificere overfor implementationen hvad de skal returnere er Generics.
 * ---------
 * Noter:
 * pointen med denne sektion er at få folk til at stoppe
 * med at bruge typeless ArrayLists og whatnot, man må nød til at give den en type,
 * ellers kan man tilføje, som i bogen, en  mønt til en collection af svampe, uden at den brokker 
 * sig og det giver selF en runtime error i stedet for en compiletime error som vi foretrækker, det er altid
 * bedst at opdage fejl hurtigst muligt(tydeligvis?).
 * 
 * Der er et interessersant kode eksempel indenfor i kode eksempel 1.
 * 
 * De nævner bla. at det er muligt at ligge en java.util.Date
 * objekt ind i en collection af java.sql.Date Collection, hvilket tydeligvis
 * ville give nogle kompabilitets problemer.
 * 
 * Hvis man ALDRIG skal lade være med at bruge generics
 * når man laver en collection eller noget andet, hvorfor har java
 * så tilladt at man kan gøre det uden at give en compile time fejl?
 * Det er faktisk rimelig simpelt pga. eksisterende kode der ikke bruger generics skal selF
 * stadig kunne kører, specielt den kode som er blevet lavet før Generics kom til.
 * Dette fenomen hedder 'migration compatibility'
 * 
 * Der er ting som f.eks List(unparamerterized)- og så List<Object>
 * og så kan man så spørge hvad forskellen er,
 * men f.eks tager List imod List<String> imens List<Object> ikke gør,
 * fordi List<String> er en subtype af den rå type List
 * hvilket bringer os hen til den pointe der lyder:
 * 'You lose type safety if you use a raw type like List, but
 * not if you use a parameterized type like List<Object>.'
 * Jeg er ikke helt sikker på jeg forstår hvordan typen List<String> kan være
 * en subtype af den rå type List .. men altså.. det er den åbenbart :)
 * Men det er vel bare vigtigt at vide at det IKKE er muligt,
 * og at det smider en ClassCastException -
 * jeg har lavet noget kode nedenfor i kode eksempel 2 der demonstrerer dette.
 * 
 * 
 * Hvis man har et stykke kode, hvor man ikke ved
 * hvilken parameter den skal bruge før runtime,
 * eller hvor det er umiddelbart ligegyldigt,
 * så brug hellere det som hedder en 
 * 'unbounded wildcard type'
 *	
 *der er et kode eksempel på hvordan man ville gøre
 *hvis man var ligeglad med at bruge generics på side
 *136, og så nedenunder den wild card type som vi har i kode
 *eksempel 3-. 
 *Forskellen på disse 2 kan siges som, 'the wildcard type is safe
 *and the raw type isn't. You can put
 *any element into a collection with a raw type, easily corrupting the collection's
 *type invariant (as demonstrated by the unsafeAdd method on page 112);
 *You can't put any element(other than null) into a Collection<?>, Attempting to do so will
 *generate a compile-time error message like this:
 *
 *WildCard.java:13:cannot find symbol
 *symbol : method add(String)
 *location interface Collection<capture#825 of?>
 *c.add("verboten");
 *
 *Der er problemer med instanceof
 *operatoren når man har med generic typer at gøre,
 *kode eksempel 4 viser hvordan man skal håntere dette(side 137 i bogen).
 * 
 * på side 138 nederst er der faktisk et meget
 * fedt table over alle terms/eksempler/items(i bogen)
 * som bliver nævnt i Generics kapitlet, både indtil
 * tablet kom, og lidt af de udtryk der er på vej).
 * 
 * 
 * @param args
 */
	public static void main(String[] args) 
	{
		/**
		 * Kode eksempel 1:
		 */
		//for loop with parameterized iteratoe declaration - typesafe
		for(Iterator<Stamp> i = stamps.Iterator(); i.hasNext();)
		{
			Stamp s = i.next(); // no cast nessecery
			...//Do something with the stamp.
		}
		
		/**
		 * Kode eksempel 2:
		 *	Hvis vi nu lavede vores List parameter om til 
		 *List<Object> så ville vi få en compiletime error,
		 *Hvilket tydeligvis hjælper en hel del siden vi kan fixe det
		 *før runtime.
		 */
		//Uses raw type(List) - fails at runtime!
		List<String> strings = new ArrayList<String>();
		unsafeAdd(strings, new Integer(42));
		String s = strings.get(0); //Compiler-generated cast
		
		private static void unsafeAdd(List list, Object o)
		{
			list.add(0);
		}
		
		/**
		 * kode eksempel 3:
		 * En bounded wildcard type - som er langt
		 * mere favorable end ingen.
		 */
			
		//unbounded wildcard type - typesafe and flexible
		static int numElementsInCommon(Set<?> s1, Set<?> s2)
		{
			int result = 0;
			for(Object o1 : s1)
			{
				if(s2.contains(o1))
				{
					result++;
				}
				
			}
			return result;
		}
	
	}
	
	/**
	 * Kode eksempel 4:
	 */
	
	//Legitimate use of raw type - instanceof operator
	if(o instanceof Set) //Raw type
	{
		Set<?> m = (Set<?>) o; //Wildcard type
	}
	

}
