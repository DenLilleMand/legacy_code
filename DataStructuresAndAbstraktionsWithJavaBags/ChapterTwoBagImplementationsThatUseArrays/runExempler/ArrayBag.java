package runExempler;

import interfaces.BagInterface;

/**
 * A class of bags whose entries are stored in a fixed-size array.
 * 
 * @author Frank M. Carrano
 */
public class ArrayBag<T> implements BagInterface<T> {
	private final T[] bag;
	private static final int DEFAULT_CAPACITY = 25;
	private int numberOfEntries;
	
	/**
	 * Suppose that a bag contains Comparable objects. Define a method for the class ArrayBag 
	 * that returns a new bag of
		items that are less than some given item. The header of the method could be as follows:
		public ArrayBag<T> getAllLessThan(Comparable<T> anObject).
		
		metoden nedenfor er et forsøg, der går ud fra at det er en compareTo()
		metode der returnere -1, 0 eller 1 afhængig af dens resultat om 2 objekter 
		minder om hinanden - men måske er det misforstået . 
	 * @param anObject
	 * @return
	 */
	public ArrayBag<T> getAllLessThan(Comparable<T> anObject)
	{
		BagInterface<T> arrayBag = new ArrayBag<T>();
		for(int i = 0; i < bag.length; i++)
		{
			if( -1 ==((Comparable<T>) bag[i]).compareTo((T) anObject))
			{
				arrayBag.add(bag[i]);
			}
		}
		return (ArrayBag<T>) arrayBag;
	}
	
	
//	Suppose that a bag contains Comparable objects. Implement the following methods for the class ArrayBag:
//		● The method getMin that returns the smallest object in a bag
//		● The method getMax that returns the largest object in a bag
//		● The method removeMin that removes and returns the smallest object in a bag
//		● The method removeMax that removes and returns the largest object in a bag
	/**
	 * Tror sku ikke det her er rigtigt, men nu har vi givet det et forsøg.
	 * @return
	 */
	public Comparable<T> getMin()
	{
		Object currentMin = bag[0];
		for(int i = 0; i < bag.length-1; i++)
		{
			if(-1 == ((Comparable<T>) bag[i]).compareTo((T) currentMin))
			{
				currentMin = bag[i];
			}
		}
		
		return (Comparable<T>) currentMin;
	}
	
	public Object getMax()
	{
		return bag;
	}
	
	public void removeMin()
	{
		
	}
	
	public void removeMax()
	{
		
	}
	
	/*'
	 * Define an equals method for the class ArrayBag that returns true when the contents of two bags are the same.
Note that two equal bags contain the same number of entries, and each entry occurs in each bag the same number
of times.
	 */


	/** Creates an empty bag whose initial capacity is 25. */
	public ArrayBag() {
		this(DEFAULT_CAPACITY);
	} // end default constructor

	/**
	 * Creates an empty bag having a given initial capacity.
	 * 
	 * @param capacity
	 *            the integer capacity desired
	 */
	public ArrayBag(int capacity) {
		numberOfEntries = 0;
		// the cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[]) new Object[capacity]; // unchecked cast
		bag = tempBag;
	} // end constructor

	/**
	 * Adds a new entry to this bag.
	 * 
	 * @param newEntry
	 *            the object to be added as a new entry
	 * @return true if the addition is successful, or false if not
	 */
	public boolean add(T newEntry) {
		boolean result = true;
		if (isFull()) {
			result = false;
		} else { // assertion: result is true here
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
		} // end if
		return result;
	} // end add

	/**
	 * Retrieves all entries that are in this bag.
	 * 
	 * @return a newly allocated array of all the entries in the bag
	 */
	public T[] toArray() {
		// the cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries]; // unchecked cast
		for (int index = 0; index < numberOfEntries; index++) {
			result[index] = bag[index];
		} // end for
		return result;
	} // end toArray

	/**
	 * Sees whether this bag is full.
	 * 
	 * @return true if the bag is full, or false if not
	 */
	public boolean isFull() {
		return numberOfEntries == bag.length;
	} // end isFull

	/**
	 * Sees whether this bag is empty.
	 * 
	 * @return true if the bag is empty, or false if not
	 */
	public boolean isEmpty() {
		return numberOfEntries == 0;
	} // end isEmpty

	/**
	 * Gets the current number of entries in this bag.
	 * 
	 * @return the integer number of entries currently in the bag
	 */
	public int getCurrentSize() {
		return numberOfEntries;
	} // end getCurrentSize

	/**
	 * Removes one unspecified entry from this bag, if possible.
	 * 
	 * @return either the removed entry, if the removal was successful, or null
	 *         otherwise
	 * 
	 *         når vi fjerner et logEntry, så kan vi enten shifte alle sammen
	 *         hen af imod det index som er blevet null, eller også kan vi være
	 *         smarte, og huske på at vi ikke har lovet nogen bestemt orden ift.
	 *         index, så vi kan bare tage det sidste objekt i rækken og sætte
	 *         det ind der hvor vi har fjernet et objekt.
	 */
	public T remove() {
		T result = null;
		if (numberOfEntries > 0) {
			numberOfEntries--;
			result = bag[numberOfEntries];
			bag[numberOfEntries] = null;
		} // end if
		return result;
	} // end remove

	/**
	 * Removes one occurrence of a given entry from this bag.
	 * -- har senere tilføjet isTooBig() metoderne + reduceArray. 
	 * har ikke lige fået dem tjekket :)
	 * @param anEntry
	 *            the entry to be removed
	 * @return true if the removal was successful, or false if not
	 */
	public boolean remove(T anEntry) {
		if(isTooBig())
		{
			reduceArray();
		}
		int index = getIndexOf(anEntry);
		T result = removeEntry(index);
		return anEntry.equals(result);
	} // end remove

	/** Removes all entries from this bag. */
	public void clear() {
		while (!isEmpty())
			remove();

		for (int i = 0; i < bag.length - 1; i++) {
			remove();
		}
	} // end clear

	/**
	 * Counts the number of times a given entry appears in this bag.
	 * 
	 * @param anEntry
	 *            the entry to be counted
	 * @return the number of times anEntry appears in the bag
	 */
	public int getFrequencyOf(T anEntry) {
		int counter = 0;
		for (int index = 0; index < numberOfEntries; index++) {
			if (anEntry.equals(bag[index])) {
				counter++;
			} // end if
		} // end for
		return counter;
	} // end getFrequencyOf
	
	/**
	 * Define an equals method for the class ArrayBag that returns true when the contents of two bags 
	 * are the same. Note that two equal bags contain the same number of entries,
	 *  and each entry occurs in each bag the same number of times.
	 *  
	 *  "Ved sku ikke helt hvad jeg synes om den her metode, det er vel lidt underligt 
	 *  at vi returner true by-default nedenfor."
	 *  jeg er ikke helt sikker på de 2 asserts. tror det giver fin nok mening
	 * @param inputBag
	 * @return
	 */
	public boolean equals(BagInterface<T> inputBag)
	{
		assert inputBag.getCurrentSize() > 0;
		assert numberOfEntries > 0;
		T[] inputArray = inputBag.toArray();
		if(getCurrentSize() != inputBag.getCurrentSize())
		{
			return false;			
		}
		System.out.println("size returned true");
		for(int i = 0; i < getCurrentSize(); i++)
		{
			System.out.println("for loop going at index" + i);
			if(getFrequencyOf(inputArray[i]) != getFrequencyOf(bag[i]))
			{
				System.out.println("at index [" + i + "] it went wrong");
				return false;				
			}
		}
		System.out.println("about to return true");
		return true;
	}

	/**
	 * Tests whether this bag contains a given entry.
	 * 
	 * @param anEntry
	 *            the entry to locate
	 * @return true if the bag contains anEntry, or false otherwis
	 * 
	 *         **noter: denne metode kunne se sådan her ud: public boolean
	 *         contains(T anEntry) { return getFrequencyOf(anEntry) > 0; } men
	 *         så ville man skulle overveje fordele og ulemper ved dette. F.eks
	 *         er det måske et performance problem, at frequencyOf går hele
	 *         listen igennem, når vi bare vil vide om den forekommer 1 gang og
	 *         dermed kan terminate vores loop tidligere, og på den anden side
	 *         så er det genbrug af kode. men jeg synes sku ikke om det. ^^
	 */
//	public boolean contains(T anEntry) {
//		boolean found = false;
//		for (int index = 0; !found && (index < numberOfEntries); index++) {
//			if (anEntry.equals(bag[index])) {
//				found = true;
//			} // end if
//		} // end for
//		return found;
//	} // end contains
	/**
	 * contains() metoden ovenfor er den gamle version,
	 * efter vi implementerede metode getIndexOf(entry) 
	 * kan vi lige så godt bruge den.
	 * @param anEntry
	 * @return
	 */
	public boolean contains(T anEntry) 
	{
		return getIndexOf(anEntry) > -1;
	}

	// Removes and returns the entry at a given index within the arraybag.
	// If no such entry exists, returns null.
	private T removeEntry(int givenIndex) {
		T result = null;
		if (!isEmpty() && (givenIndex >= 0)) {
			result = bag[givenIndex]; // entry to remove
			numberOfEntries--;
			bag[givenIndex] = bag[numberOfEntries]; // replace entry with last
													// entry
			bag[numberOfEntries] = null; // remove last entry
		} // end if
		return result;
	} // end removeEntry


	/** Locates a given entry within the array bag.
	// Returns the index of the entry, if located, or -1 otherwise.
	 * Noter: vi har jo brugt det samme loop som i contains() 
	 * men vi har ændret vores boolean til en 'true' boolean,
	 * som er en del af det concept der hedder  "think positively",
	 * og som handler om hvilke værdier man giver booleans iforhold
	 * til context.
	 * @param anEntry
	 * @return
	 */
	private int getIndexOf(T anEntry) {
		int where = -1;
		boolean stillLooking = true;
		for (int index = 0; stillLooking && (index < numberOfEntries); index++) {
			if (anEntry.equals(bag[index])) {
				stillLooking = false;
				where = index;
			} // end if
		} // end for
			// Assertion: If where > -1, anEntry is in the array bag, and it
			// equals bag[where]; otherwise, anEntry is not in the array
		return where;
	} // end getIndexOf

	@Override
	public int length() {
		return bag.length;
	}

	@Override
	public void removeEvery(T entry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printItem(int i) {
		System.out.println(bag[i]);
		
	}
	
	/**
	 * The first new method checks whether we should reduce the size of the array:
	 * This method returns true if the number of entries in the bag is less than half the size of the array
	 *  and the size of the array is greater than 20.
	 * @return
	 */
	private boolean isTooBig()
	{
		assert bag.length > 20;
		if(bag.length/2 > numberOfEntries)
		{
			return true;
		}
		return false;
	}
	/**
	 * this method creates a new array that is three quarters the size of the current array and
	then copies the objects in the bag to the new array:
	 */
	private void reduceArray()
	{
		// the cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[bag.length*75/100]; // unchecked cast - ved sku ikke helt med det der
														  // regnestykke.
		for (int index = 0; index < numberOfEntries; index++) 
		{
			result[index] = bag[index];
		} // end for
	}


} // end ArrayBag