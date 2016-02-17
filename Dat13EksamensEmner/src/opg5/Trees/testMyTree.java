package opg5.Trees;

import static org.junit.Assert.*;

import org.junit.Test;

public class testMyTree {

	@Test
	public void testAdd() {
		MyTree<Integer> mt = new MyTree<Integer>();
		mt.add(new Integer(40));
		mt.add(new Integer(25));
		mt.add(new Integer(78));
		mt.add(new Integer(10));
		mt.add(new Integer(32));
		
		assertEquals(5, mt.count());
	}
	
	@Test
	public void testHeight() {
		MyTree<Integer> mt = new MyTree<Integer>();
		mt.add(new Integer(40));
		mt.add(new Integer(25));
		mt.add(new Integer(78));
		mt.add(new Integer(10));
		mt.add(new Integer(32));
		
		assertEquals(3, mt.height());
	}
	
	@Test
	public void testisBalanced() {
		MyTree<Integer> mt = new MyTree<Integer>();
		mt.add(new Integer(40));
		mt.add(new Integer(25));
		mt.add(new Integer(78));
		mt.add(new Integer(10));
		mt.add(new Integer(32));
		
		mt.inOrder();
		System.out.println("_______");
		mt.preOrder();
		System.out.println("_______");
		mt.postOrder();
		
		assertEquals(true, mt.isBalanced());
	}
}
