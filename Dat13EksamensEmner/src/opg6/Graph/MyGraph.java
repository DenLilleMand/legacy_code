package opg6.Graph;
import java.util.*;

public class MyGraph<T> implements IMyGraph<T>{
	
	private HashMap<T, HashMap<T, Integer>> graph = new HashMap<T, HashMap<T, Integer>>();
	
	@Override
	public void addEdge(Edge edge) {
		if(graph.containsKey(edge.fromVertex)){
			HashMap<T, Integer> inner = graph.get(edge.fromVertex);
			if(! inner.containsKey(edge.toVertex))
			{
				inner.put((T) edge.toVertex, edge.weight);
			}
		}
		else{
			HashMap<T, Integer> inner = new HashMap<T, Integer>();
			inner.put((T) edge.toVertex, edge.weight);
			graph.put((T) edge.fromVertex, inner);
		}
	}
	@Override
	public boolean edgeExists(T fromVertex, T toVertex) {
		if(graph.containsKey(fromVertex) && graph.get(fromVertex).containsKey(toVertex))
		{
			return true;
		}
		return false;
	}
	
	public String rute(T fromVertex, T toVertex)
	{
		if(!graph.containsKey(fromVertex))
		{
			return "No Departures from: " + fromVertex;
		}
		else{
			HashMap<T, Integer> inner = graph.get(fromVertex);
			if(inner.containsKey(toVertex))
			{
				return toVertex.toString();
			}
			else{
					System.out.println(inner.toString());
					return inner.toString();
			}
		}
	}
	
	private void rute(HashMap<T, Integer> map, T toVertex) {
		Iterator x = map.entrySet().iterator();
		while(x.hasNext()) {
			T t = (T) x.next();
			if(graph.containsKey(t.getFromVertex())) {
				
			}
		}
	}

}
//Opgave 1:
//Byg en graf med en adjacency list med generics og un-directed og weighted.

