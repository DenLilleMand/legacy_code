package collections.graph;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;

import org.junit.Before;
import org.junit.Test;

public class GraphTest 
{
	Graph<String> graph;
	@Before
	public void setup()
	{
		graph = new Graph<>();
		graph.addVertex("Denlillemand");
		graph.addVertex("Ditte");
		graph.addVertex("Jesper");
		graph.addVertex("Morten");
		graph.addVertex("Peter");
		graph.addVertex("Martin");
		graph.addVertex("Lars");
		
		graph.setEdge("Denlillemand", "Ditte", 50);
		graph.setEdge("Denlillemand", "Jesper", 50);
		graph.setEdge("Denlillemand", "Morten", 50);
		
		graph.setEdge("Ditte", "Lars", 50);
		graph.setEdge("Ditte", "Morten", 50);
		graph.setEdge("Ditte", "Martin", 50);
		graph.setEdge("Ditte", "Peter", 50);
		
	}
	

	@Test
	public void test_EdgeExist_ExpectSuccess() {
		graph.edgeExist("Morten", "Ditte");
	}
	
	@Test
	public void test_edgesOf_ExpectSuccess() {
		Set<String> set = graph.edgesOf("Ditte");
		System.out.println(set);
		
	}
	
	@Test
	public void test_removeEdges_ExpectSuccess() {
		graph.removeAllEdges("Ditte");
		Set<String> set = graph.edgesOf("Ditte");
		System.out.println(graph.edgeExist("Denlillemand", "Ditte"));
		System.out.println(graph.edgesOf("Denlillemand"));
		System.out.println(set);
		
		
	}
	
	@Test
	public void test_depthFirst_ExpectSuccess() {
		Iterator<String> iterator = graph.depthFirstSearch("Denlillemand");
		while(iterator.hasNext())
		{
			System.out.println("depthFirst:" +iterator.next());
		}
	}
	
	@Test
	public void test_breadthFirst_ExpectSuccess() {
		Iterator<String> iterators = graph.breadthFirstTraversal("Denlillemand");
		while(iterators.hasNext())
		{
			System.out.println("BreadthFirst:" + iterators.next());
		}
		
		
		
	}
	
	
	

}

