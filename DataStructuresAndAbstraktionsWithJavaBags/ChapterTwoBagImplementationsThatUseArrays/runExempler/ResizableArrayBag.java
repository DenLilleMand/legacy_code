package runExempler;

import java.util.Arrays;
import java.util.Random;

import interfaces.BagInterface;

/**
 * A class of bags whose entries are stored in a fixed-size array.
 * 
 * Husk at alle metoder som ikke er en del af vores API altså at de ikke er med i vores
 * interface, så SKAL de være protected  eller helst private.  
 * så vi må tilføje så mange metoder vi har lyst til udover vores interface, men de skal bare
 * have de rigtige access modifiers.
 * @author DenLilleMand
 */
public class ResizableArrayBag<T> implements BagInterface<T> {
	private T[] bag;
	private static final int DEFAULT_INITIAL_CAPACITY = 25;
	private int numberOfEntries;
	Random random = new Random();

	/** Creates an empty bag whose initial capacity is 25. */
	public ResizableArrayBag() {
		this(DEFAULT_INITIAL_CAPACITY);
	} // end default constructor

	/**
	 * Creates an empty bag having a given initial capacity.
	 * 
	 * @param capacity
	 *            the integer capacity desired
	 */
	public ResizableArrayBag(int capacity) {
		numberOfEntries = 0;
		// the cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[]) new Object[capacity]; // unchecked cast
		bag = tempBag;
	} // end constructor
	
	public int length()
	{
		return bag.length;
	}
	
	/**
	 * 	Implement a method replace for the ADT bag that replaces and returns any object currently in a bag with a
		given object.
	 */
	private void replace(T newEntry)
	{
		bag[random.nextInt(numberOfEntries)] = newEntry;
	}

	/**
	 * Adds a new entry to this Bag
	 * 
	 * @param newEntry
	 *            the object to be added as a new entry
	 *            Jeg har tilføjet en bag.length-1 ellers ville det ikke
	 *            kunne kører i et for-loop, så nu fordobler vi vores array 1 plads før den faktisk 
	 *            er fyldt, bare for at give noget buffer rum. 
	 * @return true if the addition is successful, or false if not
	 */
	public boolean add(T newEntry) {
		ensureCapacity();
		bag[numberOfEntries] = newEntry;
		numberOfEntries++;
		return true;
	} // end add

	private void ensureCapacity() {
		if (numberOfEntries == bag.length-1)
			bag = Arrays.copyOf(bag, 2 * bag.length);
	} // end ensureCapacity
	
	/**
	 * Define a method removeEvery for the class ArrayBag that
	 *  removes all occurrences of a given entry from a bag.
	 * @param newEntry
	 */

	public void removeEvery(T newEntry)
	{
		assert numberOfEntries > 0;
		for(int i = 0; i < bag.length-1; i++)
		{
			if(bag[i] != null && bag[i].equals(newEntry))
			{
				bag[i] = bag[numberOfEntries];
				bag[numberOfEntries] = null; 
				numberOfEntries--;
			}
		}
	}
	
	public void printItem(int index)
	{
		System.out.println(bag[index]);
	}
	

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
	 *         vi har 2 metoder nu af remove, under/over hinanden - fordi vi fik som opgave
	 *         at lave en metode der fjernede en random. og vores clear() metode
	 *         bliver tydeligvis påvirket af denne ændring.
	 */
//	public T remove() {
//		T result = null;
//		if (numberOfEntries > 0) {
//			numberOfEntries--;
//			result = bag[numberOfEntries];
//			bag[numberOfEntries] = null;
//		} // end if
//		return result;
//	} // end remove
//	
	public T remove() 
	{
		T result = null;
		assert numberOfEntries > 0;
		int index = random.nextInt(numberOfEntries);
		result = bag[index];
		bag[index] = bag[numberOfEntries];
		bag[numberOfEntries] = null;
		numberOfEntries--;
		return result;
	} // end remove
	
	
	

	/**
	 * Removes one occurrence of a given entry from this bag.
	 * 
	 * @param anEntry
	 *            the entry to be removed
	 * @return true if the removal was successful, or false if not
	 */
	public boolean remove(T anEntry) {
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
	// public boolean contains(T anEntry) {
	// boolean found = false;
	// for (int index = 0; !found && (index < numberOfEntries); index++) {
	// if (anEntry.equals(bag[index])) {
	// found = true;
	// } // end if
	// } // end for
	// return found;
	// } // end contains
	/**
	 * contains() metoden ovenfor er den gamle version, efter vi implementerede
	 * metode getIndexOf(entry) kan vi lige så godt bruge den.
	 * 
	 * @param anEntry
	 * @return
	 */
	public boolean contains(T anEntry) {
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

	/**
	 * Removes one unspecified entry from this bag, if possible.
	 * 
	 * @return either the removed entry, if the removal was successful, or null
	 *         otherwise
	 */
	// public T remove() {
	// T result = removeEntry(numberOfEntries - 1);
	// return result;
	// } // end remove

	/**
	 * Locates a given entry within the array bag. // Returns the index of the
	 * entry, if located, or -1 otherwise. Noter: vi har jo brugt det samme loop
	 * som i contains() men vi har ændret vores boolean til en 'true' boolean,
	 * som er en del af det concept der hedder "think positively", og som
	 * handler om hvilke værdier man giver booleans iforhold til context.
	 * 
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

	

} // end ArrayBag