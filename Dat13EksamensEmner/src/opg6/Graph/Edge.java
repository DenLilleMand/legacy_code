package opg6.Graph;


public class Edge<T> {
	T fromVertex;
	T toVertex;
	Integer weight;
	
	public Edge(T fromVertex, T toVertex, Integer weight)
	{
		this.fromVertex = fromVertex;
		this.toVertex = toVertex;
		this.weight = weight;
	}
}
