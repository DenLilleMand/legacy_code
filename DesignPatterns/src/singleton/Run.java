package singleton;
/**
 * Så vi gennemgår singleton i bogen selvom vi har været det igennem.
 * Der er også noget med hvordan netværks programmering fungere med singletons osv.
 * 
 * Den officielle definition på Singleton:"Ensures a class has only one instance,
 * and provides a global point of access to it".
 * 
 * Der ligger et multi-threading problem i getInstance() metoden, fordi 2 tråde kan
 * kalde den samtidigt, så det tvinger os ud i at lave den synchronized, 
 * og det at gøre en metode synchronized er meget performance krævende, så hvis
 * man ofte kalder getInstance() og performance betyder noget for en, så skal man
 * kigge på andre måder..  vores Singleton objekt er kun non-threadsafe 
 * før vi har instansieret vores objekt, så det betyder at en løsning istedet for at gøre
 * den synchronized er at smide den op i en statisk variable der bliver instansieret
 * ved siden af andre globale variabler.  jeg har lavet endnu en uniqueSingleton klasse
 * for at vise denne implementation, den hedder ThreadSafeSingleton.
 * 
 * Så vi har nogle forskellige implementationer af singleton her, og vi skal
 * vælge hvilken en vi har lyst til at bruge, bogen nævner dog også at 
 * man skal tage en threadSafe singleton hvis applikationen er multithreaded, og
 * siger så bagefter at alle applikationer skal anses som multithreaded. 
 * så vi har den synchronized  og den med double-check(SmartSingletonImplementation)
 * at vælge imellem, jeg fandt aldrig rigtig ud af hvorfor man ikke konsekvent 
 * burde bruge double-check, fordi en konstant synchronized getInstance() har
 * meget overhead, det forværre performance op til x100, så double checket
 * gør at man kun tjekker med synchronized 1 gang ...
 * 
 * anyway, jeg har ikke internet lige nu, men det de siger at der er flere
 * classloaders i applikationen, så kan man godt ende op med flere af ens
 * singleton objekter, men jeg kan ikke lige google hvad en classLoader er,
 * mon ikke det er reflection relateret, synes nemlig jeg husker at vi har
 * brugt classLoader til at hente billeder ind igennem en klasse, og det
 * er nemlig også en del af reflection.
 * 
 * den argumentation der bliver brugt IMOD 'Double checked locking' måden at implementere
 * vores singleton på(SmartSingletonImplementation klassen), er
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
