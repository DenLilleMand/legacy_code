package queue.denNyeBog;

/** Implementation of the queue ADT using a fixed-length array. */
public class ArrayQueue<E> implements Queue<E> { // instance variables
	private E[] internalArray; // generic array used for storage
	private int front = 0; // index of the front element
	private int numberOfElem = 0; // current number of elements
	private static final int CAPACITY = 1000;

	// constructors
	public ArrayQueue() {
		this(CAPACITY);
	} // constructs queue with default capacity

	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity) { // constructs queue with given capacity
		internalArray = (E[]) new Object[capacity]; // safe cast; compiler may give
											// warning
	}

	// methods
	/** Returns the number of elements in the queue. */
	public int size() {
		return numberOfElem;
	}

	/** Tests whether the queue is empty. */
	public boolean isEmpty() {
		return (numberOfElem == 0);
	}

	/** Inserts an element at the rear of the queue. */
	public void enqueue(E e) throws IllegalStateException {
		if (numberOfElem == internalArray.length)
			throw new IllegalStateException("Queue is full");
		int avail = (front + numberOfElem) % internalArray.length; // use modular arithmetic
		internalArray[avail] = e;
		numberOfElem++;
	}

	/**
	 * Returns, but does not remove, the first element of the queue (null if
	 * empty).
	 */
	public E first() {
		if (isEmpty())
			return null;
		return internalArray[front];
	}

	/** Removes and returns the first element of the queue (null if empty). */
	public E dequeue() {
		if (isEmpty())
			return null;
		E answer = internalArray[front];
		internalArray[front] = null; // dereference to help garbage collection
		front = (front + 1) % internalArray.length;
		numberOfElem--;
		return answer;
	}
}