package opg4.stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class testMyStack {

	@Test
	public void testPush() throws StackException {
		MyStack<String> ms = new MyStack<String>();
		ms.push(new String("mofo"));
		
		assertEquals(false, ms.isEmpty());
	}
	
	@Test
	public void testPop_LIFO() throws StackException {
		MyStack<String> ms = new MyStack<String>();
		ms.push(new String("mofo"));
		ms.push(new String("mofo2"));
		ms.push(new String("mofo3"));
		
		assertEquals("mofo3", ms.pop());
	}
	
	@Test
	public void testPeek() throws StackException {
		MyStack<String> ms = new MyStack<String>();
		ms.push(new String("mofo"));
		
		assertEquals("mofo", ms.peek());
	}

}
