package binarySearchTreeFinal;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	public void test() {
		BinarySearchTree tree = new BinarySearchTree();
		Integer herp5 = 5;
		Integer herp10 = 20;
		
		tree.insert(herp5);
		tree.insert(herp10);
		
		System.out.println(tree.root.right);
		
		assertEquals(20, tree.search(20));
	}

}
