package opg4.stack;

public class MyQueue<T> implements IQueue<T> {
	
	/** The internal array for the queue. 
	 * Will be treated as a circle
	 */
	private T[] internalArray;

	/** The maximum length of the queue */
	private int maxQueue;

	/** The number of items in the queue */
	private int count;
	/** The front of the queue */
	private int front;

	/** The back of the queue */
	private int back;

	@Override
	public void createQueue() {
		
		internalArray = (T[]) new Object[10];
		this.maxQueue = 10;
		this.front = 0;
		this.count = 0;
		this.back = maxQueue - 1;
	}

	@Override
	public boolean isEmpty() {
		if(count == 0){
			return true;
		}
		else
		return false;
	}

	@Override
	public void enqueue(T t) throws Exception {
		if(count < back)
		{
			internalArray[count] = t;
			count++;
		}
		else{
			throw new Exception("The queue is full");
		}
	}

	@Override
	public T dequeue() {
		T t = internalArray[front];
		front++; count--;
		return t;
	}

	@Override
	public void dequeueAll() {
		for(int i = 0; i<count ; i++)
		{
			System.out.println(internalArray[i]);
			internalArray[i] = null;
		}
		count = count - count;
	}

	@Override
	public T peek() {
		return internalArray[front];
	}

}
