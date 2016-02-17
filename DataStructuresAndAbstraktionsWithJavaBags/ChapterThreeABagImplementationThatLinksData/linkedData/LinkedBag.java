package linkedData;

import interfaces.BagInterface;

/**
 * A class of bags whose entries are stored in a chain of linked nodes. The bag
 * is never full.
 * 
 * @author Frank M. Carrano
 */
public class LinkedBag<T> implements BagInterface<T> {
	private Node firstNode; // reference to first node(the head reference)
	private int numberOfEntries; // Initially, a bag is empty, so the default
									// constructor simply
									// initializes the data fields firstNode to
									// null and numberOfEntries to zero.
	/**
	 * Exercise opgave fra bogen:Add a constructor to the class 
	 * LinkedBag that creates a bag from a given array of objects.
	 */
	public LinkedBag(T[] inputArray)
	{
		/**
		 * psedeu kode:
		 * 1.itererer over arraylisten
		 * 2.kalder add metoden med array[index] værdi.
		 * 3....
		 * 4.profit ? :D
		 */
		
		firstNode = null;
		for(int i = 0; i < inputArray.length-1; i++)
		{
			add(inputArray[i]);
		}
	}
	
	
	public LinkedBag() 
	{
		firstNode = null;
		numberOfEntries = 0;
	} // end default constructor

	private class Node // private inner class
	{
		private T data; // entry in bag
		private Node next; // link to next node

		/**
		 * kan se her at den internt kalder en anden konstruktør, med this() og
		 * så bare giver 2 parameter, hvilket tydeligvis bare er den konstruktør
		 * lige nedenunder. Og 'next' node bliver ikke initialiseret før der
		 * bliver tilføjet endnu en Node, fordi det jo er en kæde der på den
		 * måde er lidt omvendt kompatibelt.
		 * 
		 * @param dataPortion
		 */
		private Node(T dataPortion) {
			this(dataPortion, null);
		} // end constructor

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		} // end constructor

		private T getData() {
			return data;
		} // end getData

		private void setData(T newData) {
			data = newData;
		} // end setData

		private Node getNextNode() {
			return next;
		} // end getNextNode

		private void setNextNode(Node nextNode) {
			next = nextNode;
		} // end setNextNode
	} // end Node

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(BagInterface<T> inputBag) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Selvom isFull() ikke er en del af vores core metoder, så er den så let at
	 * implementere at i stedet for at skrive en stub metode, så implementere vi
	 * den bare med det samme, den skal bare returnere false fordi en linked
	 * list aldrig er fyldt, den er først fyldt når der ikke er mere plads på
	 * vores computer.
	 */
	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * add() er en core metode, hvilket den er i enhver collection.
	 */
	@Override
	/** Adds a new entry to this bag.
	@param newEntry the object to be added as a new entry
	@return true */
	public boolean add(T newEntry) // OutOfMemoryError possible
	{
		{
			// add to beginning of chain:
			Node newNode = new Node(newEntry);
			newNode.setNextNode(firstNode);// make new node reference rest of chain
			// (firstNode is null if chain is empty)
			firstNode = newNode; // new node is at beginning of chain
			numberOfEntries++;
			return true;
		} // end add
	}

	/**
	 * Fjerner den første node i vores chain, og giver vores
	 * 'head reference' til det der plejede at være objekt 2.
	 * Super simpel metode, og det er gode er at, for at remove en specific er
	 * det nærmest præcis det samme, bare hvor vi giver vores firstNode til den
	 * vi gerne vil fjerne, og så sætter vi nr 2 i rækken til vores first, super
	 * simpelt, kan læse og se billeder omkring dette på side 76(pdf).
	 */
	public T remove() {
		T result = null;
		if (firstNode != null) // kunne også kalde isEmpty() i stedet for det
								// her, det ville nok være
		{ // mere læsbart.
			result = firstNode.getData();
			firstNode = firstNode.getNextNode(); // remove first node from chain
			numberOfEntries--;
		} // end if
		return result;
	} // end remove

	/**
	 * Den er faktisk rigtig smart den her metode, vi bruger en af vores andre
	 * metoder remove() der fjerner det entry der er på index 0, efter vi har
	 * sat dataen fra det entry vi gerne vil fjerne til denne. og efter at vi
	 * har flyttet vores første nodes data til den vi gerne vil fjerne ...
	 * hvertfald en metode som jeg ikke kunne bikse sammen her kl 23:30
	 */
	public boolean remove(T anEntry) {
		boolean result = false;
		Node nodeN = getReferenceTo(anEntry);
		if (nodeN != null) {
			nodeN.data = firstNode.data; // replace located entry with entry
			// in first node
			remove(); // remove first node
			result = true;
		} // end if
		return result;
	} // end remove

	// @Override
	// public boolean remove(T anEntry) {
	// Node currentNode = firstNode;
	// if (firstNode != null) // kunne også kalde isEmpty() i stedet for det
	// // her, det ville nok være
	// { // mere læsbart.
	// while ((currentNode != null)) {
	// if (currentNode.data.equals(anEntry)) {
	// /**
	// * Jeg forstår ikke helt den her sætning, det er jo
	// * currentNode vi skal fjerne, men lige nu virker det bare
	// * til at vi multiplicere den, men hvis vi skriver
	// * currentNode = firstNode, men det virker ikke.
	// */
	// firstNode = currentNode;
	// firstNode = firstNode.next; // remove first node from chain
	// numberOfEntries--;
	// return true;
	// }
	// currentNode = currentNode.next;
	// } // end while
	// } // end if
	// return false;
	// } // end method

	@Override
	public void clear() {
		while (!isEmpty())
			remove();
	} // end clear

	@Override
	public int getFrequencyOf(T anEntry) {
		int counter = 0;
		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			if (currentNode.data.equals(anEntry)) {
				counter++;
			}
			index++;
			currentNode = currentNode.getNextNode();
		} // end while
		return counter;
	}

	/**
	 * Bogen har en anden implementation, de gør i princippet det samme, det der
	 * dog er anderledes er at bogen har en variable som den returnerer, og som
	 * den tjekker på løbende sådan at den ikke kører listen færdig før den
	 * returnere, det gør vores heller ikke, men vi returner med det samme i
	 * stedet for at vente på at vores while løkke får tjekket på den der
	 * boolean og så har vi også et index kørende, ehm -- deres liste går udfra
	 * at der ingen null værdier er i listen, null bliver brugt til at fortælle
	 * os om vi er nået til vejs ende, og det er derfor de ikke har brug for et
	 * index, men det er vi klar, over - og vi beholder vores implementation,
	 * fordi rigtigt burde man jo godt kunne have en null værdi, (måske?), men
	 * på den anden side, så er det jo ikke en null værdi enlig, det er en null
	 * node, og det kan man jo ikke have, det er kun ved vejs ende. hmm så vores
	 * index variable er måske lidt retarderet.
	 */
	@Override
	public boolean contains(T anEntry) {
		if (getReferenceTo(anEntry) != null)
			return true;

		return false;
	}

	// Locates a given entry within this bag.
	// Returns a reference to the node containing the entry, if located,
	// or null otherwise.
	private Node getReferenceTo(T anEntry) 
	{
		boolean found = false;
		Node currentNode = firstNode;
		int index = 0;
		while (!found && index < numberOfEntries) 
		{
			if (anEntry.equals(currentNode.data))
				found = true;
			else
				currentNode = currentNode.getNextNode();
			index++;
		} // end while
		return currentNode;
	} // end getReferenceTo

	/**
	 * toArray() er en core-method, i den forstand at vi skal bruge den til at
	 * teste rigtige metoder. - The method toArray. The method toArray returns
	 * an array of the entries currently in a bag. By implementing this method,
	 * we will be able to test whether the add method works before we complete
	 * the rest of the class LinkedBag.-
	 */
	/**
	 * Retrieves all entries that are in this bag. appropos denne metode:
	 * Programming Tip If ref is a reference to a node in a chain, be sure that
	 * ref is not null before you use it to access ref.data or ref.next.
	 * Otherwise, if ref is null, a NullPointerException will occur.
	 * 
	 * @return a newly allocated array of all the entries in the bag
	 */
	public T[] toArray() {
		// the cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries]; // unchecked cast
		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.data;
			index++;
			currentNode = currentNode.getNextNode();
		} // end while
		return result;
	} // end toArray

	@Override
	public void removeEvery(T entry) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void printItem(int i) 
	{
		// TODO Auto-generated method stub

	}
} // end LinkedBag
