package opg2.hashing;

import static org.junit.Assert.*;

import org.junit.Test;

public class testHashingLinked {

	@Test()
	public void test() throws Exception {
		HashListLinked<String, String> hlist = new HashListLinked<String, String>();
		hlist.add("key", "value");
		hlist.add("key1", "value1");
		hlist.add("key2", "value2");
		hlist.add("key3", "value3");
		hlist.add("key4", "value4");
		hlist.add("key5", "value5");
		hlist.add("key6", "value6");
		
		assertEquals(7, hlist.noOfElements());
	}
	@Test()
	public void test2() throws Exception {
		HashListLinked<String, String> hlist = new HashListLinked<String, String>();
		System.out.println("____________________________");
		hlist.add("key", "value");
		hlist.add("key1", "value1");
		hlist.add("key2", "value2");
		String s = new String("key3");
		String s1 = new String("value3");
		hlist.add(s, s1);
		assertEquals(s1, hlist.get(s));
	}

}
