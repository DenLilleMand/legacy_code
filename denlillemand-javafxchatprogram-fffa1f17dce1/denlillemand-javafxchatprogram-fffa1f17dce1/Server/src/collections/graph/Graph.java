package collections.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import collections.queues.LinkedQueue;
import collections.tree.TreeNode;

/**
 * Graf med en adjacency list med generics og un-directed og weighted.
 * 
 * @author denlillemand
 *
 *         Undirected / weighted graph
 */
public class Graph<T> implements IGraph<T> {
	HashMap<T, HashMap<T, Integer>> graph = new HashMap<>();

	int numOfEdges;

	public Graph() {

	}
	
	public Set<T> keySet()
	{
		return graph.keySet();
	}
	
	public HashMap<T,Integer> get(T key)
	{
		return graph.get(key);
	}

	public void addVertex(T vertex) {
		graph.put(vertex, new HashMap<T, Integer>());
	}

	/**
	 * Vi har en directed graph, så når vi tilføjer en edge til 'fromVertex', så
	 * skal vi også tilføje den til sin 'toVertex' så derfor gør vi det hele 2
	 * gange. men vi plusser kun vores numOfEdges count op med 1, fordi det som
	 * sagt er en undirected graph.
	 * 
	 * @param edge
	 */
	@Override
	public void setEdge(T fromVertex, T toVertex, int weight) {
		HashMap<T, Integer> fromVertexMap = graph.get(fromVertex);
		HashMap<T, Integer> toVertexMap = graph.get(toVertex);
		if (fromVertexMap == null || toVertexMap == null) {
			throw new IllegalArgumentException();
		}
		numOfEdges++;
		fromVertexMap.put(toVertex, weight);
		toVertexMap.put(fromVertex, weight);
	}

	/**
	 * Vi ser bare om vores graph indeholder vertex.
	 * 
	 * @param vertex
	 * @return
	 */
	public boolean containsVertex(T vertex) {
		if (graph.get(vertex) != null) {
			return true;
		}
		return false;
	}

	/**
	 * edgesOf() returnere et set med alle de "keys" som dens hashMap
	 * indeholder.
	 * 
	 * @param vertex
	 * @return
	 */
	public Set<T> edgesOf(T vertex) {
		if (graph.get(vertex) == null) {
			throw new IllegalArgumentException();
		}
		return graph.get(vertex).keySet();
	}
	
	public int amountOfEdgesOf(T vertex)
	{
		if(graph.get(vertex)==null)
		{
			throw new IllegalArgumentException();
		}
		return graph.get(vertex).keySet().size();
	}

	/**
	 * Vi kender begge vertices der skal slettes. Så vi søger bare på dem i
	 * vores graph, returnere deres interne hashmaps og sletter dem fra
	 * hinandens.
	 */
	@Override
	public void deleteEdge(T fromVertex, T toVertex) {
		HashMap<T, Integer> fromVertexMap = graph.get(fromVertex);
		HashMap<T, Integer> toVertexMap = graph.get(toVertex);
		if (fromVertexMap == null || toVertexMap == null) {
			throw new IllegalArgumentException();
		}
		numOfEdges--;
		fromVertexMap.remove(toVertexMap);
		toVertexMap.remove(fromVertexMap);
	}

	public Iterator<T> breadthFirstTraversal(T startVertex) {
		ArrayList<T> visitedVertices = new ArrayList<>();
		breadthFirstTraversal(startVertex, graph, visitedVertices);
		return visitedVertices.iterator();
	}

	private void breadthFirstTraversal(T startVertex,HashMap<T, HashMap<T, Integer>> graph, ArrayList<T> visitedVertices) 
	{
		if (graph.get(startVertex) == null) {
			throw new IllegalArgumentException();
		}
		LinkedQueue<T> queue = new LinkedQueue<T>();
		queue.enqueue(startVertex);
		setMark(startVertex, visitedVertices);
		System.out.println(startVertex);
		while(!queue.isEmpty())
		{
			T vertex = queue.dequeue();
			for(T key : edgesOf(vertex))
			{
				if(!isMarked(key, visitedVertices))
				{
					setMark(key,visitedVertices);
					queue.enqueue(key);
				}	
			}
		}
		
	}

	public Iterator<T> depthFirstSearch(T startVertex) {
		ArrayList<T> visitedVertices = new ArrayList<>();
		depthFirstSearch(startVertex, graph, visitedVertices);
		return visitedVertices.iterator(); // Måske kan vi bare returnere
											// visited iteratoren?
	}

	private void depthFirstSearch(T startVertex,HashMap<T, HashMap<T, Integer>> graph, ArrayList<T> visitedVertices) 
	{
		setMark(startVertex, visitedVertices);
		Set<T> setEdges = edgesOf(startVertex);
		Iterator<T> allEdges = setEdges.iterator();
		while (allEdges.hasNext()) 
		{
			T vertex = allEdges.next();
			if (!isMarked(vertex, visitedVertices)) 
			{
				depthFirstSearch(vertex, graph, visitedVertices);
			}
		}
	}

	/**
	 * Først tjekker vi på om vertex overhovedt eksisterer i vores graf. ligesom
	 * vi har gjort i de andre metoder. Når vi vil slette en edge, så scanner vi
	 * 'vertix''s keys igennem vores 'graph hashmap' får fat i hashmappet for
	 * hver key, og sletter vores vertex der. Bagefter så sletter vi alle
	 * vertex's edges. Det er en undirected graph, derfor skal vi gøre dette. I
	 * en Directed graph ville dette ikke være nødvendigt. Directed = facebook,
	 * undirected = twitter. Vi tæller en local int op, for hver gang vi sletter
	 * en edge, og til sidst trækker vi dem fra vores totale mængde af edges.
	 * 
	 * @param vertex
	 * @return Void
	 */
	public void removeAllEdges(T vertex) {
		if (graph.get(vertex) == null) {
			throw new IllegalArgumentException();
		}
		int edgesDeleted = 0;
		for (T key : graph.get(vertex).keySet()) {
			HashMap<T, Integer> hashMap = graph.get(key);
			hashMap.remove(vertex);
			edgesDeleted++;
		}
		numOfEdges -= edgesDeleted;
		edgesOf(vertex).clear();
	}

	/**
	  * 
	  */
	@Override
	public boolean edgeExist(T fromVertex, T toVertex) {
		HashMap<T, Integer> fromVertexMap = graph.get(fromVertex);
		HashMap<T, Integer> toVertexMap = graph.get(toVertex);
		if (fromVertexMap == null || toVertexMap == null) {
			throw new IllegalArgumentException();
		}
		if (fromVertexMap.containsKey(toVertex)
				&& toVertexMap.containsKey(fromVertex)) {
			return true;
		}
		return false;
	}

	@Override
	public int returnAmountOfVertexes() {
		return graph.size();
	}

	@Override
	public int returnAmountOfEdges() {
		return numOfEdges;
	}

	@Override
	public int weight(T fromVertex, T toVertex) {
		HashMap<T, Integer> fromVertexMap = graph.get(fromVertex);
		HashMap<T, Integer> toVertexMap = graph.get(toVertex);
		if (fromVertexMap == null || toVertexMap == null) {
			throw new IllegalArgumentException();
		}
		return 0;
	}

	/**
	 * Ved ikke helt med den her metode, kan godt se at den burde tage 2
	 * vertices ind hvis vi havde med edges at gøre, men lige nu er jeg kun
	 * interesseret i at marke 1 vertex visited. Hvis vi ikke havde med Strings
	 * at gøre, så ville vores API være misledende her, fordi når folk får lyst
	 * til at sætte et mark på en vertex, så regner de med at den bliver sat på
	 * den objekt reference der hedder "toVertex".
	 */
	@Override
	public void setMark(T toVertex, ArrayList<T> visitedVertices) {
		for (T t : visitedVertices) {
			if (t.equals(toVertex)) {
				throw new IllegalArgumentException();
			}
		}
		visitedVertices.add(toVertex);
	}

	/**
	 * Denne metode ville vel kun give mening hvis den tjekede om en bestemt
	 * vertex var marked og returnerede en boolean?
	 * 
	 */
	@Override
	public boolean isMarked(T v, ArrayList<T> visitedVertices) {
		for (T t : visitedVertices) {
			if (t.equals(v)) {
				return true;
			}
		}
		return false;
	}
}
