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
	 * navn er når man laver det med en constructor.
	 * vi kan se et konkret eksempel med Vector i eksempel 1.
	 * 
	 * grunden til at dette er bedre, er at hvis vi gør det til en vane,
	 * så vil vores programmer blive meget mere flexible, og jeg tror ikke at vores
	 * 10k linjer programmer vil mærke den store forskel, men man kan da sagtens se 
	 * at i et eksempel som List og Vector, at vi måske har lyst til at bruge en anden ting end
	 * Vector som parameter eller intialisere et felt til noget andet, og selvom man ikke har tænkt sig
	 * at gøre det, så er det da stadig dumt hvis man kan få noget
	 * gratis functionalitet.
	 * 
	 * 'If you get into the habit of using interfaces as types, your program
	 *  will be much more flexible'
	 *  
	 *  som bogen siger- man kan bare skifte new Vector ud med new ArrayList 
	 *  senere hvis man har lyst. og det er jo sandt.
	 *  
	 *  Den ene ting der er med det er at hvis man laver det til interfaces, så betyder det at man ikke 
	 *  kan kalde en eller anden specifik Vector metode på dette stykke kode, så ville det jo breake hvis 
	 *  man initialisere variablen til noget andet- så man skal selvfølgelig have
	 *  en generisk metode for øje hvis man bruger interfaces.
	 *  
	 *  de bruger igen ThreadLocal som exempel, den har løbende fået dens Map
	 *  udskiftet fra HashMap til IdentityHashMap og noget andet, ved bare at ændre
	 *  en enkelt linje kode, det er optimering på højt niveau.
	 *  
	 *  'It is entirely appropriate to refer to an object by a class rather than an interface if 
	 *  no appropriate interface exists'
	 *  specielt gælder dette for 'value' klasser som String og BigInteger
	 *  
	 *  Ellers bliver der talt om at det også er lovligt for klasser som er med i et Frame
	 *  -work der fundamentalt er opbygget af klasser - der er det relevant at referer den med dens base-class som oftest
	 *   er abstract, så dvs. at i Arv burde man måske også referer til deres interfaces(ikke java's interface).
	 *   
	 *   den sidste grund til ikke at referer med et interface, er hvis klassen har nogle metoder som ikke er med i sit interface,
	 *   så har man jo tydeligvis ikke adgang til disse uden at (caste) et objekt, hvilket 
	 *   ødelægger vores pointe.
	 *   
	 *   så det betyder nærmest at, man skal altid bruge
	 *   tophierarchy ting, så længe de giver en den funktionalitet man har brug for,
	 *   men jeg kunne forestille mig for -readabilities sake at de ikke mener top-container 
	 *   i den strengeste forstand fordi så havde det gået amok.
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
