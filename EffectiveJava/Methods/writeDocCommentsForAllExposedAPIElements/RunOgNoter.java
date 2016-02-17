package writeDocCommentsForAllExposedAPIElements;

public class RunOgNoter {
	/**
	 * Write doc comments for all exposed API elements
	 * tl;dr;
	 * 
	 * 
	 * 
	 * ----------
	 * Noter:
	 * Hvis man skal kunne bruge en api, s� skal den v�re documenteret,
	 * Sun har en javadoc-guide man burde kigge igennem, bliver
	 * der foresl�et.
	 * 
	 * 'To document your API properly, you must precede
	 * every exported class, interface, constructor, method and field with a doc comment'.
	 * Hvis en klasse er Serializeable burde man ogs�
	 * dokumentere dens serialized form.
	 * 
	 * for velligeholdelsens skyld burde man ogs� dokumentere hvad bogen
	 * kalder for 'unexported' klasser, interfaces konstrukt�rer, metoder og felter,
	 * og jeg tror at unexported mener de at det er implementationen, der gemmer sig bag ved ens API,
	 * som man nok kun selv skal rode i.
	 * 
	 * 'The doc comment for a method should describe succincly the contract
	 * between the method and its client'.
	 * som regel burde documentationen p� en metode fort�lle hvad den g�r, 
	 * i stedet for hvordan den g�r det, bortset fra metoder lavet til arv.
	 * javadoc burde ogs� enumerate alle de preconditions der skal v�re 
	 * sande f�r en client kan invoke ens metode.
	 * og s� de postconditions der vejer til at v�re sande
	 * efter man har kaldt metoden, man kan dog sige at 
	 * @throws tag  forklare preconditions, fordi der vil blive smidt en forskellig exception for hver
	 * precondition. udover preconditions/conditions burde man ogs� 
	 * skrive om de forskellige side-effects, dette er en effekt
	 * der �ndre det state som er i programmet, f.eks hvis der bliver startet en baggrunds tr�d op
	 * pga. ens metode s� er det noget man nok gerne ville kende til. 
	 * Endelig burde dokumentationen beskrive 'thread safety' af en
	 * klasses metode.
	 * 
	 * Der burde ogs� v�re et @param tag  for hver parameter, og et @return tag der beskriver 
	 * repr�sentationen hos v�rdien.
	 * Bagefter er der @throws tag, burde starte med en given exception,
	 * hvorefter 'if'  og s� en s�tning der beskriver de forhold der skal v�re opfyldt
	 * for at en bestemt exception bliver smidt.
	 * 
	 * et eksempel p� javadoc er kode eksempel 1.
	 * 
	 * Hvis man kigger p� det her java doc kode 
	 * s� kan man se html tags med <p> og <i>, det er fordi
	 * java doc kode bliver oversat til html, dvs. at i ens javadoc
	 * kan man sidde og skrive html kode for at format det
	 * ordentligt, der er endda nogen som g�r s� langt som at s�tte html tables ind
	 * i deres java doc.
	 * 
	 * {@code} tagget til sidst g�r 2 ting, det g�r at koden bliver rendered 
	 * i "code font", 'and it suppresses processing
	 * of HTML markup and nested Javadoc tags in the code fragment.'
	 * 
	 * vi har ogs� indsat tagsne <pre> og </pre>, er ikke helt
	 * sikker p� hvad dette g�r, men man kan jo pr�ve sig frem.
	 * godt v�re at det var i stedet for html escape characters- som bogen
	 * sagde noget om at man plejede at bruge.
	 * 
	 * hvis man vil have metacharacters ind i ens html
	 * dokument, alts� (?), (<) og (>) s� skal man bruge {@literal} tag, det er ligesom
	 * vores {@code} tag, den render bare ikke font i code font.
	 * et eksempel hvor man bruger det er:
	 * 
	 * 'The triangle inequality is {@literal |x + y| < |x| + |y|}'
	 * 
	 * producere "The triangle inequality is |x + y| < |x| + |y|"
	 * vores {@literal} kunne self ogs� bare n�jes med at surrounde vores <  tegn.
	 * Men det ville m�ske have gjort det mindre l�sbart.
	 * 
	 * desuden s� l�s den s�tning der starter med 'Returns' i vores java doc,
	 * det er den f�rste s�tning, s� det er vores 'summary description',
	 * og den er unik igennem vores program, eller det skal den v�re i hvertfald,
	 * ellers forvirre det andre programm�rer.
	 * Man skal derfor ogs� v�re bange for at s�tte sit 
	 * punktum for tidligt i ens summary description, fordi
	 * det ville afslutte vores definition, et eksempel der bliver givet i bogen 
	 * er:
	 * 
	 * "A college degree, such as B.S., M.S. or PH.D."
	 * 
	 * S� det betyder at vores definition i ditte tilf�lde stopper
	 * alt alt for tideligt, men det man kan g�re er at
	 * putte ens punktummer ind i et {@literal} tag.
	 * 
	 * og s� vidt jeg forst�r s� er det kun det punktum som bliver efterfulgt af et 
	 * mellemrum. s� dvs at den del der skal i et literal tag her er:
	 * 
	 *	"A college degree, such as B.S., {@literal M.S.} or Ph.D."
	 * 
	 * en summary description for  metoder og constructors burde det v�re en hel
	 * 'verb' s�tning inkluderet ethvert objekt dvs.
	 * at det ligner dette:
	 * 
	 * ArrayList(int initialCapacity - Constructs an empty list with the specified initial capacity
	 * 
	 * Collection.size() -- Returns the number of elements in this collection.
	 * 
	 * 
	 * og for klasser, interfaces og felter (den engelske version af dette):
	 * 'For classes, interfaces, and fields, the summary description should be a noun
	 * phrase describing the thing represented by an instance of the class or interface or 
	 * by the field itself, forexample:'
	 * 
	 * TimerTask -- A task that can be scheduled for one-time or repeated execution
	 * by a Timer
	 * 
	 * Math.PI -- The double value that is closer than any other to pi, the ratio of the
	 * circumference of a circle to its diameter.
	 * 
	 * Der er 3 nye ting man skal holde �je med efter de ting der blev
	 * released i 1.5 som kr�ver speciel opm�rksomhed i doc comments:
	 * Generics, enums og annotations. 'When documenting a generic type
	 * or method, be sure to document all type parameters:'(kode eksempel 2)
	 * 
	 * 'When documenting an enum type, be sure to document the constants as well
	 *  as the type and any public methods. Note that you can put an entire doc comment on one line
	 *  if it's short: (Kode eksempel 3)'
	 *  
	 *  
	 *  'When documenting an annotation type, be sure to document any members as well 
	 *  as the type itself. Document members with noun phrases, as if they
	 *  we're fields. For the summary description of the type, use a verb phrase that says
	 *  what it means when a program element has a annotation of this type:'
	 * (kode eksempel 4)
	 *  
	 *  Med release 1.5 s� skal package-level doc comments
	 *  placeres i en fil der hedder package-info.java i stedet for package.html. 
	 *  yderligere til package level doc comments, s� kan package-info.java 
	 *  (men er ikke obligeret til at)indeholde en pakke declaration og pakke annotationer.
	 *  
	 *  
	 *  P� side 231 er der yderligere information om Serializeable og Thread safety,
	 *  det vi allerede har om disse emner er at man skal dokumentere den
	 *  u-serialized form, OG den Serialized form af et objekt hvis den implementere denne interface,
	 *  og mhs. til ThreadSafety, s� er det noget der skal med i java-doc om ens metode er ThreadSafe,
	 *  (og der m� vi nok hellere l�se op, p� hvad ThreadSafety enlig er, fordi den volatile variable er n�ppe
	 *  nok til at g�re det ThreadSafe.)
	 * @param args
	 */
	public static void main(String [] args)
	{
		/**
		 * Kode eksempel 1:
		 */
		/**
		 * Returns the element at the specified positon in this list.
		 * 
		 * <p> This method is <i>not</i> guaranteed to run in constant
		 *	time. In some implementations it may run in time proportional to the element position.
		 *@param index index of element to return; must be
		 *	non-negative and less than the size of this list
		 *@return the element at the specified position in this list
		 *@throws IndexOutOfBoundsException if the index is out of range(<pre>{@code index < 0 || index >= this.size()}</pre>)
		 *
		 */
		E get(int index);
		
		
		/**
		 * Kode eksempel 2:
		 */
		
		/**
		 * An object that maps keys to values.  A map cannot contain
		 * duplicate Keys; each Key can map to at most one value.
		 * 
		 * (Remainder omitted)
		 * 
		 * @param <K> the type of keys maintained by this map
		 * @param <V> the type of mapped values
		 */
		public interface Map<K,V>
		{
			...//Remainder omitted
		}
		
		/**
		 * Kode eksempel 3:
		 */
		
		/**
		*  An instrument section of a symphony orchestra.
		*/
		public enum OrchestraSection
		{
			/** Woodwinds, such as flute, clarinet, and oboe. */
			WOODWIND,
			
			/** Brass instruments, such as french horn and trumpet. */
			BRASS,
			
			/** Percussion instruments, such as timpani and cymbals */
			PERCUSSION,
			
			/**Stringed instruments, such as violin and cello. */
			STRING;
			
		}
		
		/**
		 * Kode eksempel 4:
		 */
		/**
		 * Indicates that the annotated method is a test method that must
		 * throw the designated exception to succeed.
		 */
		@Retention(RetentionPolicy.RUNTIME)
		@Target(ElementType.METHOD)
		public @interface ExceptionText
		{
			/**
			 * The exception that the annotated test method
			 * must throw in order to pass.(The test is permitted to throw
			 * any subtype of the type described by this class object.)
			 */
			Class<? extends Exception> value();
		}
		
	}
}
