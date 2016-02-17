package christiansGennemGang;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchTreeTest {

	@Test
	public void test() {
		//Arrange
		SearchTree<Movie> tree = new SearchTree<Movie>();
		Movie m1 = new Movie("What Women Want", 1999);
		Movie m2 = new Movie("JungleBogen", 2003);
		Movie m3 = new Movie("Hi bernie", 2001);
		
		//Act
		tree.add(m1);
		tree.add(m2);
		tree.add(m3);
		
		
		//Assert
		
	}
	
	
	@Test
	public void test_hvadManTester_HvadManForventer()
	{
		//Arrange
		SearchTree<Movie> tree = new SearchTree<Movie>();
		Movie m1 = new Movie("What Women Want", 1999);
		Movie m2 = new Movie("JungleBogen", 2003);
		Movie m3 = new Movie("Hi bernie", 2005);
		Movie m4 = new Movie("What Women Want", 2007);
		Movie m5 = new Movie("JungleBogen", 2009);
		Movie m6 = new Movie("Hi bernie", 2011);
		Movie m7 = new Movie("What Women Want", 2014);
		Movie m8 = new Movie("JungleBogen", 2017);
		Movie m9 = new Movie("Hi bernie", 2020);
		
		tree.add(m1);
		tree.add(m2);
		tree.add(m3);
		tree.add(m4);
		tree.add(m5);
		tree.add(m6);
		tree.add(m7);
		tree.add(m8);
		tree.add(m9);
		
		//Assert / Act
		
		assertTrue(tree.contains(m7));
		//assertTrue(tree.contains(new Movie("what Women Want",2007)));
		//assertFalse(tree.contains(new Movie("what Women Want",1999)));
		
		
	}

}
