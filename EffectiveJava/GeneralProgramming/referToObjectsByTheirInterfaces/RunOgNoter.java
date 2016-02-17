package referToObjectsByTheirInterfaces;

public class RunOgNoter {
	/**
	 * Refer to objects by their interfaces
	 * tl;dr;
	 * 
	 * 
	 * -----------------
	 * Noter:
	 * 'If appropriate interface types exist,
	 * then parameters, return values, variables, and fields
	 * should all be declared using interface types.'
	 * Det eneste tidspunkt hvor man har lyst til at referer et objects
	 * navn er n�r man laver det med en constructor.
	 * vi kan se et konkret eksempel med Vector i eksempel 1.
	 * 
	 * grunden til at dette er bedre, er at hvis vi g�r det til en vane,
	 * s� vil vores programmer blive meget mere flexible, og jeg tror ikke at vores
	 * 10k linjer programmer vil m�rke den store forskel, men man kan da sagtens se 
	 * at i et eksempel som List og Vector, at vi m�ske har lyst til at bruge en anden ting end
	 * Vector som parameter eller intialisere et felt til noget andet, og selvom man ikke har t�nkt sig
	 * at g�re det, s� er det da stadig dumt hvis man kan f� noget
	 * gratis functionalitet.
	 * 
	 * 'If you get into the habit of using interfaces as types, your program
	 *  will be much more flexible'
	 *  
	 *  som bogen siger- man kan bare skifte new Vector ud med new ArrayList 
	 *  senere hvis man har lyst. og det er jo sandt.
	 *  
	 *  Den ene ting der er med det er at hvis man laver det til interfaces, s� betyder det at man ikke 
	 *  kan kalde en eller anden specifik Vector metode p� dette stykke kode, s� ville det jo breake hvis 
	 *  man initialisere variablen til noget andet- s� man skal selvf�lgelig have
	 *  en generisk metode for �je hvis man bruger interfaces.
	 *  
	 *  de bruger igen ThreadLocal som exempel, den har l�bende f�et dens Map
	 *  udskiftet fra HashMap til IdentityHashMap og noget andet, ved bare at �ndre
	 *  en enkelt linje kode, det er optimering p� h�jt niveau.
	 *  
	 *  'It is entirely appropriate to refer to an object by a class rather than an interface if 
	 *  no appropriate interface exists'
	 *  specielt g�lder dette for 'value' klasser som String og BigInteger
	 *  
	 *  Ellers bliver der talt om at det ogs� er lovligt for klasser som er med i et Frame
	 *  -work der fundamentalt er opbygget af klasser - der er det relevant at referer den med dens base-class som oftest
	 *   er abstract, s� dvs. at i Arv burde man m�ske ogs� referer til deres interfaces(ikke java's interface).
	 *   
	 *   den sidste grund til ikke at referer med et interface, er hvis klassen har nogle metoder som ikke er med i sit interface,
	 *   s� har man jo tydeligvis ikke adgang til disse uden at (caste) et objekt, hvilket 
	 *   �del�gger vores pointe.
	 *   
	 *   s� det betyder n�rmest at, man skal altid bruge
	 *   tophierarchy ting, s� l�nge de giver en den funktionalitet man har brug for,
	 *   men jeg kunne forestille mig for -readabilities sake at de ikke mener top-container 
	 *   i den strengeste forstand fordi s� havde det g�et amok.
	 *   
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * Kode eksempel 1:
		 */
		//Good - uses interface as type
		List<Subscriber> subscribers = new Vector<Subscriber>();
		
		//Rather than this:
		
		//BAD - uses class as type!
		Vector<Subscriber> subscribers = new Vector<Subscriber>();
	}

}
