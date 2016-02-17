package creatingAndDestroyingObjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleExamples 
{
	/**
	 * En metode der converter en primitiv boolean til en 
	 * Boolean med den korekte værdi. og med noget interessersant syntax må man sige
	 * , det må man hellere lige læse om på siden alle gode programmører virker til at
	 * bruge ? :  osv. 
	 * 
	 * Det her område i bogen handler om static factory methods,
	 * som skal understreges ikke er Factory Pattern fra design patterns, 
	 * en fordel ved at bruge static factory methods er at den har et navn,
	 * en constructor har jo ikke et navn man selv kan bestemme., 
	 * endnu en fordel ved at bruge dem istedet for en constructor er at
	 * de ikke er bundet af at skulle lave et objekt hver gang(hvilket constructors jo 
	 * heller ikke er hvis vi smider en exception BOOM! :) )
	 * 
	 * Jeg tror faktisk at den her metode sjovt nok returnere singleton objekter,
	 * det siger bogen hvertfald at den gør ... og de taler bla om at hvis objekter 
	 * er singleton så kan man få noget performance benefit ud af at bruge '==' operatoren
	 * istedet for object.equals(object) ... hvilket man lige skal være obs på at bruge 
	 * når vi har med singleton objekter at gøre.
	 * 
	 * Denne lille metode ligner desuden flyweight pattern.
	 * 
	 * Dette hedder desuden at objektet er Instance-controlled, når
	 * koden ser sådan her ud.
	 * 'instance control allows a class to guarantee that it is a singleton, or
	 * noninstantiable. also it allows an immutable class to make the guarantee
	 * , then its clients can use '==' instead of object.equals(object) for performance.  Emums
	 * make this guarantee aswell(operator wise).
	 * 
	 * Another advantage of the factory method
	 * is that it can return any subtype of it's return type.
	 * which allows us to make classes access private, and only
	 * have access to them through this method.
	 * which lends it self to a compact API
	 * 
	 * Siger bla. at det er god skik at henvise til et objekts interface istedet for 
	 * selve klassen. og det er jo også det vi ser i strategy pattern
	 * og adapter pattern hvor brugbart det er. 
	 * 
	 * Interfaces kan by-default ikke have statiske metoder,
	 * hvilket er et problem når man skal lave Abstract factories -
	 * måske kommer der en løsning til det senere,
	 * bogen mistede mig lige i tråden, men alt dette leder os over på
	 * noget client/service agtig tankegang ligesom vores RMI måske,
	 * og der er et stykke kode eksempel der følger med dette, så har lavet
	 * en pakke der hedder clientAndService og lagt klassen derind.
	 * 
	 * efter dette kode eksempel er der også en fire 
	 * grund til man skal bruge static method factories,
	 * hvilket er at man skal give type declarations på en 
	 * instansiering af et HashMap f.eks . hvis man har dette inde i 
	 * ens static factory så skal man jo kun declare det 1 gang og 
	 * så ordner factorien resten ... dette kaldes 'type inference' og
	 * bliver talt om midt på side 32.
	 * 
	 * 
	 * --Spring i context(Der er nogle super gode tips til hvordan
	 * man skal navngive factories ...
	 * 
	 * valueOf -- Returns an instance that has, loosely speaking, the same value as its
	 * parameters. Such static factories are effectively type-conversion methods.
	 * 
	 * of -- A concise alternative to valueOf, popularized by EnumSet.
	 * 
	 * getInstance -- Returns an instance that is described by the parameters but
	 * cannot be said to have the same value. In the case of a singleton, getInstance
	 * takes no parameters and returns the sole instance.
	 * 
	 * newInstance -- Like getInstance, except that newInstance guarantees that
	 * each instance is distinct from all others.
	 * 
	 * getType -- Like getInstance, but used when the factory method
	 * is in a different class. Type indicates the type of object returned
	 * by the factory method.
	 * 
	 * newType -- Like newInstance. but used when the factory method is in a different 
	 * class. Type indicates the type of object returned
	 * by the factory method.
	 * 
	 * Bogen siger at både public constructors og factory methods
	 * er brugbare, men langt oftest er factory methods til at foretrække,
	 * jeg tror at deres eneste argumentation for public constructors
	 * er at man kan subclasse den klasse, men det stikker jo som sagt tidligere
	 * imod vores design princip composition over inheritance.
	 * 
	 * Der er faktisk også nogle ting som begge 2 er dårlige til,
	 * og det er f.eks at håndtere et stort set af parametre,
	 * 
	 * Der er noget som hedder et 'telescoping constructor pattern' som 
	 * er blevet brugt til at håndtere dette, der bliver brugt det eksempel
	 * at hvis man skulle lave en constructor der skulle tage alle 'nutrition facts'
	 * fra en mad deklaration ind, måske er det 20 parametre... 
	 * forklaring følger .. nu skal jeg til stranden :) 
	 * 
	 * okay, så telescoping constructor pattern,
	 *  --- det er åbenbart det man IKKE skal gøre, fordi det 
	 *  scaler dårligt ...
	 *  
	 *  et alternativ er det som hedder et JavaBeans Pattern, og der laver 
	 *  man objektet - og så bruger man setters til at sætte værdierne
	 *  løbende som man skal bruge. men dette pattern tillader tydeligvis 
	 *  ikke-konsekvent kode og opfordrer til mutability(hvad end det betyder?)
	 *  Problemet med dette pattern, som har sine helt egne fejl er blandt andet
	 *  at ens javabean ikke er komplet når den bliver lavet,
	 *  man kan komme til at bruge et ½ fyldt javabean object som så giver system failures.
	 *  dette gør blandt andet at man skal bruge endnu mere energi
	 *  på thread-safety ... hvilket vel er det tilfælde
	 *  der bliver refereret til hvor man kan komme til at bruge et ½ instansieret
	 *  objekt.
	 *  
	 *  heldigvis er der en tredje løsning til dette problem:
	 *  og det er en form for 'builder pattern' det består af en 
	 *  static factory method som genererer objektet, og så sætter clienten
	 *  setter-like metoder på builder objektet for at sætte de parametre der har interesse, endelig
	 *  kalder klienten en parameter løs build metode der genererer objektet. som så er immutable.
	 *  Builderen er en static member class af den klasse den bygger.
	 * Der er noget builder kode i den pakke som hedder Builder Pattern
	 * og viser det bedre alternativ til javabean pattern og telescoping pattern.
	 * 
	 * @param b
	 * @return
	 */
	public static Boolean valueOf(boolean b) {
		return b ? Boolean.TRUE : Boolean.FALSE;
		}
	
	
	/**
	 * Eksempel på 'type inference':
	 */
	//modsatte af 'type inference(hvilket er dårligt):
	Map<String, List<String>> m = new HashMap<String, List<String>>();
	
	//'type inference':
	public static <K, V> HashMap<K,V> newInstance()
	{
		return new HashMap<K,V>();
	}
	
	//denne metode efterfulgt af måden man så kan instansiere et 
	//hasmap på giver:
	Map<String, List<String>> m = HashMap.newInstance();
	//hvilket er kortere kode, og efterhånden bliver det relativt lettere
	//at læse/overskue. det bliver foreslået at lave en utility class,
	//med den her slags metoder, men spørgsmålet er lidt om f.eks en instansiering
	//af arraylists må ligge sammen med HashMaps osv. eller om de skal have en klasse selv,
	//man kunne forestille sig at det giver mest mening at ligge dem i samme utilityClass
	//så længe det kun er dette som foregår, altså at give utility classes en lettere declaration
	//og man skal huske at det ikke kun er dette eksempel der viser hvorfor det er bedre med
	//factory method, men at de andre grunde til at factory method er bedre gælder også
	//mhs. til dette eksempel. men det fremgår tydeligt at det f.eks ikke er
	//et instans kontrolleret objekt/singleton der bliver returneret.
	/**
	 * der bliver også nævnt de ulemper der er ved static factories,
	 * og det har noget at gøre med at hvis en klasse ikke har en public constructor,
	 * så kan vi ikke sub-classe den ... og jeg er ikke helt sikker på hvad de mener med 
	 * dette, det blive diskuteret på side 32-33 vidst nok .
	 *  men så ved siden af dette så bliver der også nævnt at det måske er en god ting
	 *  sådan at folk bruger composition istedet for inheritance, som vi så ofte har hørt i design
	 *  patterns er et af  design principperne.
	 */

	
	


}
