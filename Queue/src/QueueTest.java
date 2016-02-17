import static org.junit.Assert.*;

import org.junit.Test;


public class QueueTest 
{
	
	
	@Test(expected=Our5QueueIsFullException.class)
	public void test() throws Our5QueueIsFullException 
	{
		//arrange
		Queue<String> queue = new Queue<String>();
				
		//act
		queue.enqueue("Kristian");
		queue.enqueue("Ali1");
		queue.enqueue("Ali2");
		queue.enqueue("Ali3");
		queue.enqueue("Ali4");
		queue.enqueue("Ali5");
		queue.enqueue("Ali6");
	}
	
	
	@Test
	public void test_dequeue() throws Our5QueueIsFullException 
	{
		//arrange
		Queue<String> queue = new Queue<String>();
		queue.enqueue("Kristian");
		queue.enqueue("Ali1");
		//act
		String returnedValue = queue.dequeue();
		
		//assert
		assertEquals("Kristian", returnedValue);
	}
	
	
	@Test
	public void test_dequeue2() throws Our5QueueIsFullException 
	{
		//arrange
		Queue<String> queue = new Queue<String>();
		queue.enqueue("Kristian1");
		queue.enqueue("Kristian2");
		
		//act
		String returnedValue = queue.dequeue();
		
		//assert
		assertEquals("Kristian1", returnedValue);
		String returnedValue1 = queue.dequeue();
		assertEquals("Kristian2", returnedValue1);
	}
	
	
	@Test(expected=Our5QueueIsFullException.class)
	public void test_Enqueue_Dequeue_Exception() throws Our5QueueIsFullException
	{
		Queue<String> queue = new Queue<String>();
		queue.enqueue("Kristian");
		queue.enqueue("Ali1");
		queue.enqueue("Kristian");
		queue.enqueue("Ali1");
		queue.enqueue("Kristian");
		
		
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		
		queue.enqueue("Kristian Exception");
		String returnedValue = queue.dequeue();
		assertEquals("Kristian Exception",returnedValue);
		
	}
	

}
