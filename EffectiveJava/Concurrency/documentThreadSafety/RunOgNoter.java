package documentThreadSafety;

public class RunOgNoter 
{
	/**
	 * Document thread safety
	 * tl;dr;
	 *  Static factories skal desuden dokumentere om det returnerede objekt er thread safe
	 *  
	 * To summerize 'Every class should clearly document its thread safety properties
	 *  with a carefully worded prose description or a thread safety annotation.
	 *   The synchronized modifier plays no part in this documentation. Conditionally thread-safe classes must document
	 *   which method invocation sequences require external synchronization, and which lock to acquire when executing these sequences. If you write an unconditionally thread-safe class, consider using a private
	 *   lock object in place of synchronized methods. This protects you against synchronization interference by clients and subclasses and gives you the flexibility to adropt a more
	 *   sophisticated approach to concurrency control in a later release.'  
	 * 
	 * ---------------
	 * Noter:
	 * (misconception = synchronized er det samme som 
	 * thread safe, dette er ikke rigtigt)
	 * niveauer af thread safety:
	 *	 
	 *Immutable -- Instances of this class appear constant. No external synchronization
	 *is necessary. Examples include String, Long, and BigInteger.
	 *
	 *Unconditionally thread safe -- Instances of this class are mutable, but the class 
	 *has sufficient internal synchronization that its instances can be used 
	 *concurrently without the need for any external synchronization. Examples include Random and ConcurrentHashMap.
	 *
	 *Conditionally thread-safe -- Like unconditionally thread-safe, exception that
	 * some methods require external synchronization for safe concurrent use.
	 * Examples include the collections returned by the Collections.synchronized wrappers, whose iterators require external synchronization.
	 * 
	 * not thread-safe -- Instances of this class are mutable. To use them concurrently, clients must surround each method invocation(or invocation sequence)
	 * with external synchronization of the clients' choosing. Examples include the general-purpose collection
	 *  implementations, such as ArrayList and HashMap.
	 *  
	 *  Thread-Hostile -- This class is not safe for concurrent use even if all method invocations are surrounded
	 *  by external synchronization. Thread hostility usually 
	 *  results from modifying static data without synchronization. No one writes a thread-hostile class on purpose; such classes result from the failure 
	 *  to consider concurrency. Luckily, there are very few thread-hostile classes or methods in the Java Libraies. The System.runFianlizersOnExit method is thread-hostile and has been 
	 *  deprecated.
	 *  
	 *  Static factories skal desuden dokumentere om det returnerede objekt er thread safe
	 *  
	 * 
	 * 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{

	}

}
