package opg6.Graph;

import static org.junit.Assert.*;

import org.junit.Test;

public class testMyGraph {

	@Test
	public void test() {
		MyGraph<String> mg = new MyGraph<String>();
		mg.addEdge(new Edge(new String("JFK"),new String("MCO"),5));
		mg.addEdge(new Edge(new String("JFK"),new String("ATL"),4));
		mg.addEdge(new Edge(new String("JFK"),new String("ORD"),3));
		
		mg.addEdge(new Edge(new String("MCO"),new String("JFK"),5));
		mg.addEdge(new Edge(new String("ATL"),new String("JFK"),4));
		mg.addEdge(new Edge(new String("ORD"),new String("JFK"),3));
		
		mg.addEdge(new Edge(new String("ORD"),new String("ATL"),4));
		mg.addEdge(new Edge(new String("ORD"),new String("HOU"),6));
		mg.addEdge(new Edge(new String("ORD"),new String("DFW"),4));
		mg.addEdge(new Edge(new String("ORD"),new String("PHX"),6));
		mg.addEdge(new Edge(new String("ORD"),new String("DEN"),3));
		
		mg.addEdge(new Edge(new String("ATL"),new String("ORD"),4));
		mg.addEdge(new Edge(new String("HOU"),new String("ORD"),6));
		mg.addEdge(new Edge(new String("DFW"),new String("ORD"),4));
		mg.addEdge(new Edge(new String("PHX"),new String("ORD"),6));
		mg.addEdge(new Edge(new String("DEN"),new String("ORD"),3));
		
		mg.addEdge(new Edge(new String("DEN"),new String("PHX"),3));
		mg.addEdge(new Edge(new String("DEN"),new String("LAS"),3));
		
		mg.addEdge(new Edge(new String("PHX"),new String("DEN"),3));
		mg.addEdge(new Edge(new String("LAS"),new String("DEN"),3));
		
		mg.addEdge(new Edge(new String("LAS"),new String("LAX"),2));
		mg.addEdge(new Edge(new String("LAS"),new String("PHX"),5));
		
		mg.addEdge(new Edge(new String("LAX"),new String("LAS"),2));
		mg.addEdge(new Edge(new String("PHX"),new String("LAS"),5));
		
		mg.addEdge(new Edge(new String("ATL"),new String("HOU"),3));
		mg.addEdge(new Edge(new String("DFV"),new String("PHX"),2));
		
		mg.addEdge(new Edge(new String("HOU"),new String("ATL"),3));
		mg.addEdge(new Edge(new String("PHX"),new String("DFV"),2));
		
		assertEquals("JFX-ORD-PHX-LAX", mg.rute(new String("JFK"),new String("LAX")));
	}
	
	@Test
	public void testAddEdge() {
		MyGraph<String> mg = new MyGraph<String>();
		mg.addEdge(new Edge(new String("HOU"),new String("ATL"),3));
		
		assertEquals(true, mg.edgeExists(new String("HOU"), new String("ATL")));
	}
	
	@Test
	public void testAddEdgeFalse() {
		MyGraph<String> mg = new MyGraph<String>();
		mg.addEdge(new Edge(new String("HOU"),new String("ATL"),3));
		
		assertEquals(false, mg.edgeExists(new String("HEH"), new String("ALT")));
	}
}
