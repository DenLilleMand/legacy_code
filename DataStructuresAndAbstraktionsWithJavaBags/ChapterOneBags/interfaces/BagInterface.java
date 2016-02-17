package interfaces;

/**
 * An interface that describes the operations of a bag of objects.
 * 
 * @author Frank M. Carrano
 */
public interface BagInterface<T> 
{
	/**
	 * returner bare length,
	 * faktisk en af mine egne metoder for at bruge i det der test program der hedder
	 * ResizableArrayBagDemo
	 * @return
	 */
	public int length();
	
	public boolean equals(BagInterface<T> inputBag);
	
	
	/**
	 * Gets the current number of entries in this bag.
	 * 
	 * @return the integer number of entries currently in the bag
	 */
	public int getCurrentSize();

	/**
	 * Sees whether this bag is full.
	 * 
	 * @return true if the bag is full, or false if not
	 */
	public boolean isFull();

	/**
	 * Sees whether this bag is empty.
	 * 
	 * @return true if the bag is empty, or false if not
	 */
	public boolean isEmpty();

	/**
	 * Adds a new entry to this bag.
	 * 
	 * @param temp
	 *            the object to be added as a new entry
	 * @return true if the addition is successful, or false if not
	 */
	public boolean add(T temp);

	/**
	 * Removes one unspecified entry from this bag, if possible.
	 * 
	 * @return either the removed entry, if the removal was successful, or null
	 */
	public T remove();

	/**
	 * Removes one occurrence of a given entry from this bag, if possible.
	 * 
	 * @param anEntry
	 *            the entry to be removed
	 * @return true if the removal was successful, or false if not
	 */
	public boolean remove(T anEntry);

	/** Removes all entries from this bag. */
	public void clear();

	/**
	 * Counts the number of times a given entry appears in this bag.
	 * 
	 * @param anEntry
	 *            the entry to be counted
	 * @return the number of times anEntry appears in the bag
	 */
	public int getFrequencyOf(T anEntry);

	/**
	 * Tests whether this bag contains a given entry.
	 * 
	 * @param anEntry
	 *            the entry to locate
	 * @return true if the bag contains anEntry, or false otherwise
	 */
	public boolean contains(T anEntry);

	/**
	 * Creates an array of all entries that are in this bag.
	 * 
	 * @return a newly allocated array of all the entries in the bag
	 */
	public T[] toArray();


	public void removeEvery(T entry);


	public void printItem(int i);
} // end BagInterface