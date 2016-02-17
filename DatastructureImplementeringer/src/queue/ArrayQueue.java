package queue;

public class ArrayQueue 
{
	private int first, last, size;
	private Object[] storage;

	public ArrayQueue() {
		this(100);
	}

	public ArrayQueue(int n) {
		size = n;
		storage = new Object[size];
		first = last = -1;
	}

	public boolean isFull() {
		return first == 0 && last == size - 1 || first == last + 1;
	}

	public boolean isEmpty() {
		return first == -1;
	}
	
	/**
	 * Rundt array, det den gør er i princippet bare (if full) {reset last til starten af arrayet
	 * så den overskriver}
	 * @param el
	 */
	public void enqueue(Object el) {
		if (last == size - 1 || last == -1) {
			storage[0] = el;
			last = 0;
			if (first == -1)
			{
				first = 0;				
			}
		} else
		{
			storage[++last] = el;			
		}
	}
	
	/**
	 * -Tager objektet der hvor first pointeren står.
	 * -checker om first er det samme som last
	 * -hvis det er sandt så sætter den first + last til -1. 
	 * @return
	 */
	public Object dequeue() {
		Object tmp = storage[first];
		if (first == last)
			last = first = -1;
		else if (first == size - 1)
			first = 0;
		else
			first++;
		return tmp;
	}

	public void printAll() {
		for (int i = 0; i < size; i++)
			System.out.print(storage[i] + " ");
	}
}