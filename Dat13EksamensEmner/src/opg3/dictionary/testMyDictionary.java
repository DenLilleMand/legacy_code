package opg3.dictionary;

import static org.junit.Assert.*;

import org.junit.Test;

public class testMyDictionary {

	@Test
	public void test() throws Exception {
		MyDictionary<String,String> md = new MyDictionary<String,String>();
		md.add("key1", "val1");
		assertEquals(false, md.isEmpty());
	}
	
	@Test
	public void testContains() throws Exception {
		MyDictionary<String,String> md = new MyDictionary<String,String>();
		md.add("key1", "val1");
		assertEquals(true, md.contains("key1"));
	}
	
	@Test
	public void testIsEmpty() throws Exception {
		MyDictionary<String,String> md = new MyDictionary<String,String>();
		md.add("key1", "val1");
		assertEquals(false, md.isEmpty());
	}
	
	@Test
	public void testRemove() throws Exception {
		MyDictionary<String,String> md = new MyDictionary<String,String>();
		String s = new String("key1");
		String s1 = new String("val1");
		md.add(s, s1);
		md.remove(s);
		assertEquals(true, md.isEmpty());
	}
	
	@Test
	public void testGetValue() throws Exception {
		MyDictionary<String,String> md = new MyDictionary<String,String>();
		String s = new String("key1");
		String s1 = new String("val1");
		md.add(s, s1);
		assertEquals("val1", md.getValue(s));
	}
	
	@Test
	public void testClear() throws Exception {
		MyDictionary<String,String> md = new MyDictionary<String,String>();
		String s = new String("key1");
		String s1 = new String("val1");
		md.add(s, s1);
		md.clear();
		assertEquals(true, md.isEmpty());
	}

}
