package opg4.stack;

public interface IQueue<T> {
	void createQueue();
	//Creates an empty queue.

	boolean isEmpty();
	//Determines whether the queue is empty.

	void enqueue(T t) throws Exception;
	//adds NewItem at the back of a queue

	T dequeue(); 
	//retrieves and removes the front of a queue-the item that was added first.

	void dequeueAll();
	//removes all items

	T peek();
	//Retrieves the front of a queue. The queue is unchanged. (It does not remove the item from the queue).
}
