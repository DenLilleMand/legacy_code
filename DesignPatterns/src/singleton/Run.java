package singleton;
/**
 * S� vi gennemg�r singleton i bogen selvom vi har v�ret det igennem.
 * Der er ogs� noget med hvordan netv�rks programmering fungere med singletons osv.
 * 
 * Den officielle definition p� Singleton:"Ensures a class has only one instance,
 * and provides a global point of access to it".
 * 
 * Der ligger et multi-threading problem i getInstance() metoden, fordi 2 tr�de kan
 * kalde den samtidigt, s� det tvinger os ud i at lave den synchronized, 
 * og det at g�re en metode synchronized er meget performance kr�vende, s� hvis
 * man ofte kalder getInstance() og performance betyder noget for en, s� skal man
 * kigge p� andre m�der..  vores Singleton objekt er kun non-threadsafe 
 * f�r vi har instansieret vores objekt, s� det betyder at en l�sning istedet for at g�re
 * den synchronized er at smide den op i en statisk variable der bliver instansieret
 * ved siden af andre globale variabler.  jeg har lavet endnu en uniqueSingleton klasse
 * for at vise denne implementation, den hedder ThreadSafeSingleton.
 * 
 * S� vi har nogle forskellige implementationer af singleton her, og vi skal
 * v�lge hvilken en vi har lyst til at bruge, bogen n�vner dog ogs� at 
 * man skal tage en threadSafe singleton hvis applikationen er multithreaded, og
 * siger s� bagefter at alle applikationer skal anses som multithreaded. 
 * s� vi har den synchronized  og den med double-check(SmartSingletonImplementation)
 * at v�lge imellem, jeg fandt aldrig rigtig ud af hvorfor man ikke konsekvent 
 * burde bruge double-check, fordi en konstant synchronized getInstance() har
 * meget overhead, det forv�rre performance op til x100, s� double checket
 * g�r at man kun tjekker med synchronized 1 gang ...
 * 
 * anyway, jeg har ikke internet lige nu, men det de siger at der er flere
 * classloaders i applikationen, s� kan man godt ende op med flere af ens
 * singleton objekter, men jeg kan ikke lige google hvad en classLoader er,
 * mon ikke det er reflection relateret, synes nemlig jeg husker at vi har
 * brugt classLoader til at hente billeder ind igennem en klasse, og det
 * er nemlig ogs� en del af reflection.
 * 
 * den argumentation der bliver brugt IMOD 'Double checked locking' m�den at implementere
 * vores singleton p�(SmartSingletonImplementation klassen), er
 * :"Given we have no performance concerns, double-checked locking seems a bit overkill,
 * in addition we'd have to make sure we're running atleast java5" - og ingen af disse argumenter
 * synes jeg er valid. 
 * 
 * 
 * 
 * Volatile keyword: http://blog.thesoftwarecraft.com/2014/07/javas-volatile-modifier.html
 * @author DenLilleMand
 *
 */
public class Run {
	public static void main(String [] args)
	{
		
	}
}
