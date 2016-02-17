package opg4.stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class testMyQueue {

	@Test
	public void testEnQueue() throws Exception {
		MyQueue<String> mq = new MyQueue<String>();
		mq.createQueue();
		mq.enqueue(new String("a"));
		mq.enqueue(new String("b"));
		
		assertEquals(false, mq.isEmpty());
	}
	@Test
	public void testDeQueue() throws Exception {
		MyQueue<String> mq = new MyQueue<String>();
		mq.createQueue();
		mq.enqueue(new String("a"));
		mq.enqueue(new String("b"));
		mq.dequeue();
		mq.dequeue();
		
		assertEquals(true, mq.isEmpty());
	}
	@Test
	public void testFIFO() throws Exception {
		MyQueue<String> mq = new MyQueue<String>();
		mq.createQueue();
		String a = new String("a");
		String b = new String("b");
		mq.enqueue(a);
		mq.enqueue(b);
		assertEquals(a, mq.dequeue());
		assertEquals(b, mq.dequeue());
	}
	
	@Test
	public void testDeQueueAll() throws Exception {
		MyQueue<String> mq = new MyQueue<String>();
		mq.createQueue();
		mq.enqueue(new String("a"));
		mq.enqueue(new String("b"));
		mq.dequeueAll();
		
		assertEquals(true, mq.isEmpty());
	}

}
