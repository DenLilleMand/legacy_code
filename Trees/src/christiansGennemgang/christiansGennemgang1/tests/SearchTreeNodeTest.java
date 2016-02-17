package christiansGennemgang.christiansGennemgang1.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import christiansGennemgang.christiansGennemgang1.SearchTree;

public class SearchTreeNodeTest {

	@Test
	public void testSearchTree_IfAddAndContainsWorks_ExpectTestPassed() 
	{
		SearchTree tree = new SearchTree(60);
		
		tree.add(20);
		tree.add(10);
		tree.add(40);
		tree.add(30);
		tree.add(50);
		tree.add(70);
		tree.add(75);
		
		
		tree.delete(70);
		assertTrue(tree.contains(75));
		
		
	}

}
