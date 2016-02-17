package queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayQueueTest {

	@Test
	public void test() {
		ArrayQueue queue = new ArrayQueue(5);
		queue.enqueue("herpderp");
		queue.enqueue("herpderp");
		queue.enqueue("herpderp");
		queue.enqueue("herpderp");
		
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();

		queue.printAll();
	}

}
