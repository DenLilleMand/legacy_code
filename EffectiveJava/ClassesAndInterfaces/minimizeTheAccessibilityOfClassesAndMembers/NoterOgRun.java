package minimizeTheAccessibilityOfClassesAndMembers;

public class NoterOgRun 
{
	/**
	 * Det her kapitel skal l�rer os
	 * hvordan man lave nogle robuste, flexible og brugbare
	 * interfaces og klasser.
	 * 
	 * okay s�, Minimize the accessibility of classes and members
	 * 
	 * den faktor som indikere aller bedst 
	 * om det er d�rligt eller godt programmerings design
	 * er om ens module gemmer dens interne data og andre
	 * implementerings detaljer fra andre moduler. Et godt-designet
	 * modul sepererer rent sin API fra sin implementation.
	 * 
	 * Der er mange grunde til at man skal gemme informationen,
	 * de fleste af dem stammer fra det faktum at det 'decoupler'
	 * de moduler som skaber systemet, hvilket tillader dem at blive udviklet, tested,optimeret,
	 * brugt, forst�et og redigeret i isolation.
	 * Dette g�r system udviklingen hurtigere fordi
	 * moduler kan blive skabt i paralel. det g�r
	 *  det ogs� lettere at velligeholde fordi modulerne
	 * lettere kan forst�s og debugges uden frygt for at breake et andet modul.
	 * 
	 * s� de skal gemme deres implementation, encapsulere den -
	 * men have deres API synlig s�dan at man kan bruge den, uden n�dvendigvis
	 * at vide hvordan den internt ser ud.
	 * det concept er kendt som 'information hiding' eller 'encapsulation' og er
	 * en af de fundamentale beboere i software design.
	 * 
	 * videre til at tale om private/public/protected,
	 * og at 'rule of thumb' er:"Make each class or member as 
	 * inaccessible as possible", s� man skal v�lge den mindst �bne 
	 * access modifier for hver implementation, og det er selF den mindst mulige,
	 * fordi nogen gange skal ting bare v�re public.
	 * 
	 * de 4 modifiers :
	 * private: the member is accessible only from the top-level class
	 * where it is declared.
	 * 
	 * package-private- The member is accessible from any class in the package
	 * where it is declared. Technically known as default access, this is the access level
	 * you get if no access modifier is specified.
	 * 
	 * protected -- The member is accessible from subclasses of the class
	 * where it is declared and from any class in the package where it is declared.
	 * 
	 * public -- The member is accessible from anywhere.
	 * 
	 * 
	 * efter man har declared ens klasses public api,
	 * s� skulle ens reflex v�re at lave alt andet private.
	 * kun hvis en klasse i den samme pakke virkelig har brug for at have adgang til et member
	 * skal man fjerne private modiferen og lave den package-private.
	 * Hvis man finder sig selv hvor man ofte skal g�re dette,
	 * burde man g� tilbage og lave design igen.
	 * 
	 * de taler nogengange om at n�r man s�tter en ting public, s� skal 
	 * man yde support p� den forevigt, og det samme siger de om en
	 * protected member, i mods�tning til package-private, 
	 * brugen for protected members skal v�re relativt sj�ldent.
	 * fordi man garantere at der er en implementation bag ved et protected member
	 * ligesom med public fordi protected members er en del af den eksporterede API.
	 * 
	 * der er en enkelt regel, der stopper en i at lave accessibility lav,
	 * det er hvis man @Overrider en superklasses metode, s� m� man ikke
	 * lave en access modifier som har lavere access end dens super metode.
	 * dette er lavet for at sikre at en subclass kan blive brugt der hvor en superklasse
	 * ogs� bliver brugt. hvis man bryder denne regelt giver det en compile error.
	 * 
	 * En speciel afdeling af denne regel er hvis en klasse implementere
	 * en interface s� skal alle klasse metoder som ogs� er tilstede i ens interface,
	 * public, det er s�dan fordi alle members af en interface er givet, til at v�re public.
	 * 
	 * n�r man skal teste et modul er det i orden at lave et member fra private til package-private 
	 * men aldrig h�jere end dette access niveau.
	 * 
	 * sagt med andre ord s� er det ikke i orden at lave en klasse,interface eller member
	 * en del af pakkes eksportede API for at facilitere testing.
	 * 
	 * leder os videre til det n�ste, et instance field m� 
	 * aldrig v�re public, hvis et instance field er non-final  eller er en final reference
	 * til et mutable object, s� ved at g�re feltet public, opgiver vi muligheden for at
	 * begr�nse de v�rdier der kan v�re i feltet.
	 * og videre 'this means you also give up the ability to enforce invariants involving the field,
	 * Also, you give up the ability to take any action where the field is modifed,
	 * so classes with public mutable fields are not thread-safe.' osv. osv (side 92)
	 * 
	 * et interessersant potentielt sikkerheds hul,
	 * er et:
	 * public static final Thing[] VALUES = {...};
	 * 
	 * fordi et non-zero array altid er mutable. s� clients
	 * kan �ndre v�rdierne i dette array.
	 * 
	 * kan fixe det ved at lave:
	 * private static final Thing[] PRIVATE_VALUES = {...};
	 * public static final List<Thing> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));
	 * 
	 * en anden mulighed er:
	 * private static final Thing[] PRIVATE_VALUES = {...};
	 * public static final Thing[] values()
	 * {
	 * 	return PRIVATE_VALUES.clone();
	 * }
	 * 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{

	}

}
